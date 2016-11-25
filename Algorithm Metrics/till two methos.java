import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.jgrapht.alg.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;

public class DynamicGraph {
	static ArrayList<graphs> OpenAndReadDataset() throws IOException {
		ArrayList<graphs> graphslist = new ArrayList<graphs>();
		File file = new File("c:/sample.txt");
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
	public static void main(String args[]) throws IOException {
		// Creating Simple Graph
		SimpleGraph<String, DefaultWeightedEdge> weightedGraph = new SimpleGraph<String, DefaultWeightedEdge>(
				DefaultWeightedEdge.class);
		// Reading Graph Dataset
		ArrayList<graphs> graphslist = OpenAndReadDataset();
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
		//
		// Getting Selected Shortest Paths
		System.out.println("Enter the N Limits of Selected Shortest Path");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String start, end;
		// Creating ArrayList for Storing Paths and Cost to Each Selected
		// Shortest Paths
		ArrayList<SelectedShortestPath> selectedShortestPathList = new ArrayList<SelectedShortestPath>();
		// Getting Paths and Cost by BellmanFordShortestPath

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
		// Creating NonVisitedEgdes List from Graphs, The Edges didn't Visited
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

		// Creating (i) PartialVisisted List and by it's Number of Selected
		// Shortest Path which
		// they Pass Through and (ii) It's Selected Shortet Path list
		ArrayList<AllPartialEdges> AllPartialEdgesList = new ArrayList<AllPartialEdges>();

		for (Object object : Partial_Edges) {
			AllPartialEdges pEdgeList = new AllPartialEdges();
			pEdgeList.edge = object.toString();
			pEdgeList.cost = 0;
			// List -> for all ps1,s2 such that ei,j belong ps1,s2g;
			pEdgeList.subset_shortestpaths = new ArrayList<>();
			// List -> for all ps1,s2 such that ei,j not belongs to ps1;s2g;
			pEdgeList.un_subset_shortestpaths = new ArrayList<>();
			for (SelectedShortestPath shortestPath : selectedShortestPathList) {
				if (shortestPath.list.contains(object)) {
					pEdgeList.cost++;
					pEdgeList.subset_shortestpaths.add(new shortestpaths(
							shortestPath.start, shortestPath.end));
				} else {
					pEdgeList.un_subset_shortestpaths.add(new shortestpaths(
							shortestPath.start, shortestPath.end));
				}
			}
			AllPartialEdgesList.add(pEdgeList);
		}
		// AllPartialEdgesList
		for (AllPartialEdges Edges : AllPartialEdgesList) {
			System.out.println(Edges.cost);
			// System.out.println(Edges.subset_shortestpaths);
			// System.out.println(Edges.un_subset_shortestpaths);
		}

		// System.out.println(object.toString().replace('(', ' ').replace(')',
		// ' ').split(":")[0].trim());

	}
}
class SelectedShortestPath {
	public String start;
	public String end;
	public int cost = 0;
	public List list;
}
class AllPartialEdges {
	public String edge;
	public int cost;
	public List<shortestpaths> subset_shortestpaths;
	public List<shortestpaths> un_subset_shortestpaths;

}
class shortestpaths {
	public shortestpaths(String start, String end) {
		this.start = start;
		this.end = end;
	}
	public String start;
	public String end;
}
class graphs {
	public String vertex;
	public String edge;
	public int weight;
}