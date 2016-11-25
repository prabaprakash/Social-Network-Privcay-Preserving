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

public class GaussianRandomization {
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
		int i=0;
		while(i<10)
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
		Write_Graph_with_Weight(weightedGraph);
		Metrics(OriginalGraph, weightedGraph);
		CheckingSelectedPairPath(OriginalGraph, "180", "683");
		CheckingSelectedPairPath(weightedGraph, "180", "683");
		System.out.println("\n");
		i++;
		}
		// (weightedGraph, "17", "914");
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
