import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.BellmanFordShortestPath;
import org.jgrapht.alg.FloydWarshallShortestPaths;
import org.jgrapht.experimental.isomorphism.IsomorphismRelation;
import org.jgrapht.graph.AbstractBaseGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.omg.CORBA.WStringValueHelper;

public class GaussianRandomizationMetrics {
	static ArrayList<graphs> OpenAndReadDataset(String filename)
			throws IOException {
		ArrayList<graphs> graphslist = new ArrayList<graphs>();
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("Not Exist");
		}
		try {

			Reader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(reader);
			String string;
			while ((string = bufferedReader.readLine()) != null) {

				graphs graphs = new graphs();
				String data[] = string.split(" ");
				graphs.vertex = data[0];
				graphs.edge = data[1];
				graphs.weight = Integer.parseInt(data[2]);
				// System.out.println(graphs.vertex);
				graphslist.add(graphs);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return graphslist;

	}
	@SuppressWarnings("unused")
	public static void main(String args[]) throws IOException {
		int j=0;
		while(j<10)
		{
		// Creating Simple Graph
		SimpleGraph<String, DefaultWeightedEdge> weightedGraph = CreatingGraphs("C:/Dataset/rmat1.txt");
		SimpleGraph<String, DefaultWeightedEdge> subGraph = CreatingGraphs("C:/Dataset/rmat2.txt");
		

		Graphs.addGraph(weightedGraph, subGraph);
		
		SimpleGraph<String, DefaultWeightedEdge> OriginalGraph = CreatingGraphs("C:/Dataset/rmat.txt");
		/*
		List<String> vlist1=(List<String>) weightedGraph.vertexSet(); 
		List<String> vlist2=(List<String>) OriginalGraph.vertexSet(); 
		IsomorphismRelation isomorphismRelation=new IsomorphismRelation<>(vlist1, vlist2, weightedGraph, OriginalGraph);
		*/
		// CheckingSelectedPairPath(weightedGraph, "17", "914");

		for (DefaultWeightedEdge d : weightedGraph.edgeSet()) {
			String[] arr = stringProcess(d.toString());
			DefaultWeightedEdge e1 = weightedGraph.getEdge(arr[0], arr[1]);

			double cost = weightedGraph.getEdgeWeight(e1);
			double val = new Random().nextGaussian() * 0.15;

			weightedGraph.setEdgeWeight(e1, cost * Math.abs(1 - val));
		}
		ArrayList<SelectedShortestPath> selectedShortestPathList = new ArrayList<SelectedShortestPath>();
		// Getting Paths and Cost by BellmanFordShortestPath
        String start,end;
        int n=10;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the N Limits of Selected Shortest Path");
        n=input.nextInt();
		for (int i = 0; i < n; i++) {
			start = input.next();
			end = input.next();
			BellmanFordShortestPath bfs = new BellmanFordShortestPath(
					weightedGraph, start);

			SelectedShortestPath ob = new SelectedShortestPath();
			ob.start = start;
			ob.end = end;
			ob.list = bfs.getPathEdgeList(end);
			ob.cost = (int) bfs.getCost(end);
			selectedShortestPathList.add(ob);

		}

		// Creating Unique EdgeList from Selected ShortestPath Paths
		Set<List> uniquelist = new LinkedHashSet<>(
				selectedShortestPathList.get(0).list);
		// Creating AllVisitedEdges List
		List AllVisitedEdges = new ArrayList<>(
				selectedShortestPathList.get(0).list);
		// Creating NonVisitedEgdes List from Graphs, The Edges didn't
		// Visited
		// by Selected Shortest Paths
		List NonVisitedEdges = new ArrayList();
		NonVisitedEdges.addAll(weightedGraph.edgeSet());
		NonVisitedEdges.removeAll(selectedShortestPathList.get(0).list);

		for (int i = 1; i < n; i++) {

			NonVisitedEdges.removeAll(selectedShortestPathList.get(i).list);
			AllVisitedEdges.retainAll(selectedShortestPathList.get(i).list);
			uniquelist.addAll(selectedShortestPathList.get(i).list);
		}

		System.out.println("NonVisitedEdges :" + NonVisitedEdges);
		System.out.println("AllVisitedEdges :" + AllVisitedEdges);

		List Partial_Edges = new ArrayList<>(uniquelist);
		Partial_Edges.removeAll(AllVisitedEdges);

		System.out.println("PartialVisitedEdges :" + Partial_Edges);
	ArrayList<Double> edgeMetrics=new ArrayList<Double>();
	
	for (Object obj: Partial_Edges) {
		String[] arr = stringProcess(obj.toString());
		edgeMetrics.add(MetricsForEdges(OriginalGraph,
				weightedGraph,arr));
	}
		
	
   // Edge Metrics
	Double max = MaxInList(edgeMetrics);
	MetricsXAxisProcessing(edgeMetrics, max,"Weight");
	ArrayList<Double> pathMetrics=new ArrayList<Double>();
	
	for (SelectedShortestPath path : selectedShortestPathList) {
		BellmanFordShortestPath bfs = new BellmanFordShortestPath(
				OriginalGraph, path.start);

		Double d1= bfs.getCost(path.end);
		bfs = new BellmanFordShortestPath(weightedGraph, path.start);

		Double d2= bfs.getCost(path.end);
		pathMetrics.add(Math.abs(d2-d1));
	}
	//System.out.println("......................................"+edgeMetrics);
	//System.out.println(max+" "+(max * 20) / 100+"......................................"+pathMetrics);
	for (Double double1 : pathMetrics) {
		//System.out.println("list.add("+double1+");");
	}
	MetricsXAxisProcessing(pathMetrics, max,"Length");
	
	//	Write_Graph_with_Weight(weightedGraph);
		
		for (SelectedShortestPath path : selectedShortestPathList) {
	//	CheckingSelectedPairPath(OriginalGraph,path.start, path.end);
		//CheckingSelectedPairPath(weightedGraph, path.start, path.end);
		}
		System.out.println("\n");
		j++;
		}
		// (weightedGraph, "17", "914");
	}
	private static void MetricsXAxisProcessing(ArrayList<Double> list,
			Double max, String type) throws IOException {

		Double val = (max * 20) / 100;
		Double inc = val;
		// System.out.println(val);
		Double limit = 0.0;
		ArrayList<metricsA> m = new ArrayList<metricsA>();
		while (val <= max) {
			Double count = 0.0;
			for (Double i : list) {
				// System.out.println(i);
				if (i >= limit && i <= val) {
					count++;

					// list.remove(i);
				}
			}
			// System.out.println(val+" "+count);
			Double double1 = count / list.size();
			m.add(new metricsA(val, double1));
			limit = val;
			val = val + inc;

		}
		File out = new File("C:/Users/PrabaKarthi/Desktop/GaussianMetrics.txt");
		if (out.exists())
		{
			//out.delete();
		}
		else
			out.createNewFile();

		// FileWriter fw = new FileWriter (out);
		FileOutputStream fw = new FileOutputStream(out, true);
		PrintWriter pw = new PrintWriter(fw);
		//pw.append("\n");
		for (metricsA metricsA : m) {
			// if(metricsA.y!=0.0000)
			pw.append(type + "," + metricsA.x + "," + metricsA.y+"\n");
       //System.out.println(type + "," + metricsA.x + "," + metricsA.y+"\n");	
		}
		pw.close();
        fw.close();
		
	}
	private static Double MaxInList(ArrayList<Double> list) {
		Double min = list.get(0);
		Double max = list.get(0);

		for (Double i : list) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		return max;
	}
	private static Double MetricsForEdges(
			SimpleGraph<String, DefaultWeightedEdge> OriginalGraph,
			SimpleGraph<String, DefaultWeightedEdge> newWeightGraph,
			String[] arr) {
		DefaultWeightedEdge dA = newWeightGraph.getEdge(arr[0], arr[1]);
		Double wA = newWeightGraph.getEdgeWeight(dA);
		
		
		DefaultWeightedEdge dB = OriginalGraph.getEdge(arr[0], arr[1]);
		Double wB = newWeightGraph.getEdgeWeight(dB);
		return Math.abs(wA - wB);
	}
	private static void CheckingSelectedPairPath(
			SimpleGraph<String, DefaultWeightedEdge> weightedGraph,
			String start, String end) {
		BellmanFordShortestPath pp = new BellmanFordShortestPath(weightedGraph,
				start);

		System.out.println(pp.getPathEdgeList(end) + "  " + pp.getCost(end));
	}
	private static SimpleGraph<String, DefaultWeightedEdge> CreatingGraphs(
			String filename) throws IOException {
		SimpleGraph<String, DefaultWeightedEdge> weightedGraph = new SimpleGraph<String, DefaultWeightedEdge>(
				DefaultWeightedEdge.class);

		// Reading Graph Dataset
		ArrayList<graphs> graphslist = OpenAndReadDataset(filename);
		// Adding Nodes to the Graphs
		for (graphs graphs : graphslist) {
			weightedGraph.addVertex(graphs.vertex);
			weightedGraph.addVertex(graphs.edge);
		}
		// Adding Weight to the Edges
		for (graphs graphs : graphslist) {
			try {
				DefaultWeightedEdge e1 = weightedGraph.addEdge(graphs.vertex,
						graphs.edge);

				weightedGraph.setEdgeWeight(e1, graphs.weight);
			} catch (Exception e) {
			}
		}
		return weightedGraph;
	}
	private static void Write_Graph_with_Weight(
			SimpleGraph<String, DefaultWeightedEdge> graph) throws IOException {
		File out = new File("C:/Users/PrabaKarthi/Desktop/output1.txt");
		if (out.exists())
			out.delete();
		else
			out.createNewFile();

		// FileWriter fw = new FileWriter (out);
		FileOutputStream fw = new FileOutputStream(out, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.flush();
		for (DefaultWeightedEdge d : graph.edgeSet()) {
			String[] arr = stringProcess(d.toString());
			DefaultWeightedEdge e1 = graph.getEdge(arr[0], arr[1]);

			double cost = graph.getEdgeWeight(e1);
			pw.append(arr[0] + " " + arr[1] + " " + cost + "\n");
			// System.out.println(arr[0] + " " + arr[1] + " " + cost);
		}

		pw.close();
		fw.close();

		// System.out.println("Path = "
		// + BellmanFordShortestPath.findPathBetween(graph, "v3", "v6"));
	}
	
	private static void Metrics(
			SimpleGraph<String, DefaultWeightedEdge> original,
			SimpleGraph<String, DefaultWeightedEdge> perturbed)
			throws IOException {

		File out = new File("C:/Users/PrabaKarthi/Desktop/Metrics.txt");
		if (out.exists())
			out.delete();
		else
			out.createNewFile();

		// FileWriter fw = new FileWriter (out);
		FileOutputStream fw = new FileOutputStream(out, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.flush();
		for (DefaultWeightedEdge d : original.edgeSet()) {
			String[] arr = stringProcess(d.toString());
			DefaultWeightedEdge e1 = original.getEdge(arr[0], arr[1]);
			double edgeweighta = original.getEdgeWeight(e1);

			DefaultWeightedEdge e2 = perturbed.getEdge(arr[0], arr[1]);
			double edgeweightb = perturbed.getEdgeWeight(e2);

			double costa = new BellmanFordShortestPath(original, arr[0])
					.getCost(arr[1]);

			double costb = new BellmanFordShortestPath(perturbed, arr[0])
					.getCost(arr[1]);

			pw.append(edgeweightb + " " + Math.abs(costb - costa) + "\n");

			// System.out.println(arr[0] + " " + arr[1] + " " + cost);
		}

		pw.close();
		fw.close();

		// System.out.println("Path = "
		// + BellmanFordShortestPath.findPathBetween(graph, "v3", "v6"));
	}

	public static String[] stringProcess(String temp) {
		// System.out.println(object.toString().replace('(', ' ').replace(')',
		// ' ').split(":")[0].trim());
		String dString = temp.replace('(', ' ').replace(')', ' ');
		String arr[] = dString.split(":");
		arr[0] = arr[0].trim();
		arr[1] = arr[1].trim();
		return arr;
	}
	public static class GraphHelper implements Cloneable {

		public SimpleGraph<String, DefaultWeightedEdge> weightedGraph;
		public GraphHelper(
				SimpleGraph<String, DefaultWeightedEdge> weightedGraph) {
			this.weightedGraph = weightedGraph;
		}

		public Object clone() {
			Object clone = null;

			try {
				clone = super.clone();

			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}

			return clone;
		}
	}

}
