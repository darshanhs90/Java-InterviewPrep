package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _1192CriticalConnectionsInANetwork {
	public static void main(String[] args) {
		System.out.println(criticalConnections(4,
				new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(0, 1)),
						new ArrayList<Integer>(Arrays.asList(1, 2)), new ArrayList<Integer>(Arrays.asList(2, 0)),
						new ArrayList<Integer>(Arrays.asList(1, 3))))));
	}

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			adjList.put(i, new HashSet<Integer>());
		}

		for (List<Integer> connection : connections) {
			int src = connection.get(0);
			int dst = connection.get(1);
			adjList.get(src).add(dst);
			adjList.get(dst).add(src);
		}

		for (List<Integer> connection : connections) {
			int src = connection.get(0);
			int dst = connection.get(1);
			adjList.get(src).remove(Integer.valueOf(dst));
			adjList.get(dst).remove(Integer.valueOf(src));
			HashSet<Integer> visited = new HashSet<Integer>();
			dfs(0, adjList, visited);
			if (visited.size() != n) {
				output.add(connection);
			}
			adjList.get(src).add(dst);
			adjList.get(dst).add(src);
		}
		return output;
	}

	public static void dfs(int src, HashMap<Integer, HashSet<Integer>> adjList, HashSet<Integer> visited) {
		if (visited.contains(src))
			return;
		visited.add(src);

		Iterator<Integer> neighbors = adjList.get(src).iterator();
		while (neighbors.hasNext()) {
			dfs(neighbors.next(), adjList, visited);
		}
	}

}
