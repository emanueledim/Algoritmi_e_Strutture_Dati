package vari;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* 	BACKTRACKING
 * 	https://www.techiedelight.com/print-k-colorable-configurations-graph-vertex-coloring-graph/
 *	CORRETTO
 */

class Edge {
	int source, dest;

	public Edge(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
}

// A class to represent a graph object
class Graph {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge : edges) {
			int src = edge.source;
			int dest = edge.dest;

			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
	}
}

public class ColorableGraphClass {
	private static String COLORS[] = { "", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK", "BLACK", "BROWN",
			"WHITE", "PURPLE" };

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 4), new Edge(0, 5), new Edge(4, 5), new Edge(1, 4),
				new Edge(1, 3), new Edge(2, 3), new Edge(2, 4));
		int n = 6;

		// build a graph from the given edges
		Graph graph = new Graph(edges, n);
		List<List<String>> results_colors = new ArrayList<>();
		List<String> candidate_solution = new ArrayList<>();
		Colorable(graph, n, 0, candidate_solution, results_colors);
		return;
	}

	private static void Colorable(Graph graph, int n, int i, List<String> candidate_solution, List<List<String>> solution_colors) {
		if(candidate_solution.isEmpty()) {
			for(int j=0; j<n; j++) {
				candidate_solution.add(COLORS[0]);
			}
		}
		if(baseStep(n, i)) {
			List<String> solution_to_save = new ArrayList<>(candidate_solution);
			solution_colors.add(solution_to_save);
		}else{
			candidate_solution.set(i, COLORS[0]);
			for(int k=1; k<COLORS.length; k++) {
				String candidate = COLORS[k];
				candidate_solution.set(i, candidate);
				if(isSafe(graph, n, i, candidate, candidate_solution)){
					Colorable(graph, n, i+1, candidate_solution, solution_colors);
				}
				candidate_solution.set(i, COLORS[0]);
			}
		}
	}

	private static boolean isSafe(Graph graph, int n, int i, String candidate, List<String> candidate_solution) {
		List<Integer> adjacent = graph.adjList.get(i);
		for(int j=0; j<adjacent.size(); j++) {
			int index = adjacent.get(j);
			if(candidate.equals(candidate_solution.get(index))) {
				return false;
			}
		}
		return true;
	}

	private static boolean baseStep(int n, int i) {
		if (i == n) {
			return true;
		}
		return false;
	}

}
