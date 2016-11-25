import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.omg.CORBA.WStringValueHelper;

public class DynamicGraph {
	static ArrayList<graphs> OpenAndReadDataset(String filename) throws IOException {
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
		// Creating Simple Graph
		SimpleGraph<String, DefaultWeightedEdge> weightedGraph = CreatingGraphs("c:/dataset/rmat.txt");
		SimpleGraph<String, DefaultWeightedEdge> OriginalGraph = CreatingGraphs("c:/dataset/rmat.txt");
		/*
		 * FloydWarshallShortestPaths objj = new FloydWarshallShortestPaths<>(
		 * weightedGraph); Collection<GraphPath> obja = objj.getShortestPaths();
		 * ArrayList<selectedpair> fList = new ArrayList<>(); for (GraphPath gra
		 * : obja) { // System.out.println(graphPath.getStartVertex() + " " // +
		 * graphPath.getEndVertex() + " " + graphPath.getWeight());
		 * 
		 * fList.add(new
		 * selectedpair(gra.getWeight(),(String)gra.getStartVertex(
		 * ),(String)gra.getEndVertex())); } Collections.sort(fList, new
		 * Comparator<selectedpair>() { public int compare(selectedpair o1,
		 * selectedpair o2) { double comp = o2.cost-o1.cost; return (int)comp; }
		 * }); for (int i = 0; i < 10; i++) {
		 * System.out.println(fList.get(i).start
		 * +" "+fList.get(i).end+" "+fList.get(i).cost); }
		 */

		// SimpleGraph<String, DefaultWeightedEdge>
		// newWeightGraph=(SimpleGraph<String, DefaultWeightedEdge>)
		// weightedGraph.clone();
		// newWeightGraph.removeEdge("v1", "v2");
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

		// Creating (i) PartialVisisted List , by it's Number of
		// Selected
		// Shortest Path which
		// they Pass Through and (ii) It's Selected Shortet Path list
		ArrayList<AllPartialEdges> AllPartialEdgesList = new ArrayList<AllPartialEdges>();

		for (Object object : Partial_Edges) {
			AllPartialEdges pEdgeList = new AllPartialEdges();
			pEdgeList.edge = object.toString();
			pEdgeList.cost = 0;
			// List -> for all ps1,s2 such that ei,j belong ps1,s2g;
			pEdgeList.subset_shortestpaths = new ArrayList<>();
			// List -> for all ps1,s2 such that ei,j not belongs to
			// ps1;s2g;
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
		// Printing (i) PartialVisisted List , by it's Number of
		// Selected
		// Shortest Path which
		// they Pass Through and (ii) It's Selected Shortet Path list
		// for (AllPartialEdges Edges : AllPartialEdgesList) {
		// System.out.println(Edges.cost);
		// System.out.println(Edges.subset_shortestpaths);
		// System.out.println(Edges.un_subset_shortestpaths);
		// }
		// Sorting the AllPartialEdgesList
		Collections.sort(AllPartialEdgesList,
				new Comparator<AllPartialEdges>() {
					public int compare(AllPartialEdges o1, AllPartialEdges o2) {
						int comp = o1.cost - o2.cost;
						return comp;
					}
				});
		PrintGraphwithWeight(weightedGraph, selectedShortestPathList);
		 /*
		weightedGraph.removeEdge("180", "235");
		BellmanFordShortestPath fs = new BellmanFordShortestPath(weightedGraph, "180");
	    System.out.println("Cost after removing edges"+(int) fs.getCost("683"));
		*/
		SimpleGraph<String, DefaultWeightedEdge> newWeightGraph = (SimpleGraph<String, DefaultWeightedEdge>) weightedGraph
				.clone();
		// Algorithm (i) for all non-visited edges wi,j + r (r is any
		// random
		// positive number)
		for (Object obj : NonVisitedEdges) {
			String[] arr = stringProcess(obj.toString());
			// System.out.println(arr[0] + " " + arr[1]);

			DefaultWeightedEdge e1 = newWeightGraph.getEdge(arr[0], arr[1]);
			int r = new Random().nextInt(5);
			int cost = (int) newWeightGraph.getEdgeWeight(e1);
			newWeightGraph.setEdgeWeight(e1, cost + r);
		}

		// Algorithm (ii) for all visited edges wi,j - r (r is any
		// random
		// positive number)
		for (Object obj : AllVisitedEdges) {
			String[] arr = stringProcess(obj.toString());
			DefaultWeightedEdge e1 = newWeightGraph.getEdge(arr[0], arr[1]);
			int min = 1, max = 10;
			int cost = (int) newWeightGraph.getEdgeWeight(e1);
			int new_weight = -1;
			while (new_weight <= 0) {
				int t = new Random().nextInt((max - min) + 1) + min;
				new_weight = cost - t;
			}
			// System.out.println("New Weight "+new_weight);
			newWeightGraph.setEdgeWeight(e1, new_weight);
		}
		SimpleGraph<String, DefaultWeightedEdge> backupofperGraph = (SimpleGraph<String, DefaultWeightedEdge>) newWeightGraph
				.clone();
		try {
			int count = 0;
			while (count < 10) {
				newWeightGraph = (SimpleGraph<String, DefaultWeightedEdge>) backupofperGraph
						.clone();
				/*
				 * for (AllPartialEdges partialEdges : AllPartialEdgesList) {
				 * System.out.println("---------->" + partialEdges.edge + " " +
				 * partialEdges.cost); for (shortestpaths ss :
				 * partialEdges.subset_shortestpaths) {
				 * System.out.println(ss.start + " " + ss.end); } }
				 */
				// /PrintGraphwithWeight(newWeightGraph);
				// Algorithm (iii) for all partial visited edges wi,j
				for (AllPartialEdges partialEdges : AllPartialEdgesList) {
                    
					int less_than_equal_to = 0, greater_than = 0;

					for (shortestpaths path : partialEdges.subset_shortestpaths) {
						try {

							BellmanFordShortestPath bfs = new BellmanFordShortestPath(
									newWeightGraph, path.start);

							int d1 = (int) bfs.getCost(path.end);
							bfs = new BellmanFordShortestPath(OriginalGraph,
									path.start);
							int d2 = (int) bfs.getCost(path.end);
							if (d1 <= d2) {
								less_than_equal_to++;
							} else {
								greater_than++;
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					// System.out.println(partialEdges.edge);
					// /
					String arr[] = stringProcess(partialEdges.edge);
					int t = 1;
					// /
					DefaultWeightedEdge e1 = newWeightGraph.getEdge(arr[0],
							arr[1]);
					int w = (int) newWeightGraph.getEdgeWeight(e1);
					// /
					if (less_than_equal_to > greater_than) {
						ArrayList<Integer> minarry = PartiallyVisitedEgde_Method_a(
								newWeightGraph, partialEdges, arr, w);
						int minIndex = minarry
								.indexOf(Collections.min(minarry));

						t = Random_Generator(minarry, minIndex);

						if (t==1 || t < minarry.get(minIndex)) {
							DefaultWeightedEdge e11 = newWeightGraph.getEdge(
									arr[0], arr[1]);
							// System.out.println("Method a,Edges=" + arr[0] +
							// "" +
							// arr[1]
							// + " t=" + (w + t));
							//System.out.println(t);
							newWeightGraph.setEdgeWeight(e11, w + t);
							

						}
					} else {
						ArrayList<Integer> minarry = PartiallyVisitedEgde_Method_b(
								newWeightGraph, partialEdges, arr, w);
						int minIndex = minarry
								.indexOf(Collections.min(minarry));
						t = Random_Generator(minarry, minIndex);

						if (t==1 || t < minarry.get(minIndex)) {

							DefaultWeightedEdge e11 = newWeightGraph.getEdge(
									arr[0], arr[1]);
							int x = (w - t) > 0 ? (w - t) : 1;
							//System.out.println(t);
							newWeightGraph.setEdgeWeight(e11, x);

						}
					}

				}

				PrintGraphwithWeight(newWeightGraph, selectedShortestPathList);
				Write_Graph_with_Weight(newWeightGraph);
				newWeightGraph = null;
				count++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static SimpleGraph<String, DefaultWeightedEdge> CreatingGraphs(String filename)
			throws IOException {
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
	private static int Random_Generator(ArrayList<Integer> minarry, int minIndex) {
		int t;
		try {
			if(minarry.get(minIndex)==1)
				return 1;
			
			int min = 1;
			int max = minarry.get(minIndex);
			//for (Integer integer : minarry) {
				//System.out.print(integer+"  ");
			//}
			//System.out.println("max = "+minIndex);
			int check = ((max - 1) - min + 1) > 0 ? (max - 1) - min + 1 : 2;

			// random.nextInt(max - min + 1) + min

			t = new Random().nextInt(check) + min;
			t = (t <= 0) ? 1 : t;
		} catch (Exception e) {
			t = 1;
		}

		return t;

	}
	private static void Write_Graph_with_Weight(
			SimpleGraph<String, DefaultWeightedEdge> graph) throws IOException {
		File out = new File("C:/Users/PrabaKarthi/Desktop/output.txt");
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

			int cost = (int) graph.getEdgeWeight(e1);
			pw.append(arr[0] + " " + arr[1] + " " + cost + "\n");
			// System.out.println(arr[0] + " " + arr[1] + " " + cost);
		}

		pw.close();
		fw.close();

		// System.out.println("Path = "
		// + BellmanFordShortestPath.findPathBetween(graph, "v3", "v6"));
	}
	private static void PrintGraphwithWeight(
			SimpleGraph<String, DefaultWeightedEdge> graph,
			ArrayList<SelectedShortestPath> selectedShortestPathList) {

		/*
		 * for (DefaultWeightedEdge d : graph.edgeSet()) { String[] arr =
		 * stringProcess(d.toString()); DefaultWeightedEdge e1 =
		 * graph.getEdge(arr[0], arr[1]);
		 * 
		 * int cost = (int) graph.getEdgeWeight(e1);
		 * 
		 * System.out.println("Edge=" + d.toString() +"Cost="+cost + " Path = "
		 * + BellmanFordShortestPath.findPathBetween(graph, arr[0], arr[1])); }
		 */for (SelectedShortestPath selectedShortestPath : selectedShortestPathList) {

			BellmanFordShortestPath pp = new BellmanFordShortestPath(graph,
					selectedShortestPath.start);

			System.out.println(pp.getPathEdgeList(selectedShortestPath.end)
					+ "  " + pp.getCost(selectedShortestPath.end));
		}

		System.out.println("\n");
	}
	private static ArrayList<Integer> PartiallyVisitedEgde_Method_a(
			SimpleGraph<String, DefaultWeightedEdge> newWeightGraph,
			AllPartialEdges partialEdges, String[] arr, int weight_i_j) {
		ArrayList<Integer> minarry = new ArrayList<>();
		//System.out.println("test subset_shortestpaths"+partialEdges.subset_shortestpaths.size());
		for (shortestpaths path : partialEdges.subset_shortestpaths) {
			
			// / Shortest Path Cost
			BellmanFordShortestPath bfs = new BellmanFordShortestPath(
					newWeightGraph, path.start);
			int d1 = (int) bfs.getCost(path.end);
			// / Modified Shortest Path Cost
			newWeightGraph.removeEdge(arr[0], arr[1]);
			bfs = new BellmanFordShortestPath(newWeightGraph, path.start);
			int d2 = (int) bfs.getCost(path.end);
			//
			DefaultWeightedEdge e1 = newWeightGraph.addEdge(arr[0], arr[1]);
			newWeightGraph.setEdgeWeight(e1, weight_i_j);
			// //
			int x = d2 - d1;
			// //
			x = x > 0 ? x : 1;
			//System.out.println("test subset_shortestpaths"+d1+" "+d2+" ");
			minarry.add(x);
		}
		return minarry;
	}

	private static ArrayList<Integer> PartiallyVisitedEgde_Method_b(
			SimpleGraph<String, DefaultWeightedEdge> newWeightGraph,
			AllPartialEdges partialEdges, String[] arr, int weight_i_j) {
		ArrayList<Integer> minarry = new ArrayList<>();

		for (shortestpaths path : partialEdges.un_subset_shortestpaths) {
			// /
			BellmanFordShortestPath bfs = new BellmanFordShortestPath(
					newWeightGraph, path.start);
			int d_s_i = (int) bfs.getCost(arr[0]);
			// /
			bfs = new BellmanFordShortestPath(newWeightGraph, arr[1]);
			int d_j_s = (int) bfs.getCost(path.end);
			// /
			bfs = new BellmanFordShortestPath(newWeightGraph, path.start);
			int d_s_e = (int) bfs.getCost(path.end);
			int x = d_s_i + weight_i_j + d_j_s - d_s_e;
			// /////
			x = x > 0 ? x : 1;
			// /////
			minarry.add(x);
		}
		return minarry;
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
class selectedpair {
	public double cost;
	public String start;
	public String end;
	public selectedpair(Double a, String b, String c) {
		cost = a;
		start = b;
		end = c;
	}
}