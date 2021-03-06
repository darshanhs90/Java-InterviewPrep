package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _040EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		equations.add(new ArrayList<String>(Arrays.asList("b", "c")));
		List<List<String>> queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("b", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "e")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("x", "x")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 2.0, 3.0 }, queries)));

		equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		equations.add(new ArrayList<String>(Arrays.asList("b", "c")));
		equations.add(new ArrayList<String>(Arrays.asList("bc", "cd")));
		queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("c", "b")));
		queries.add(new ArrayList<String>(Arrays.asList("bc", "cd")));
		queries.add(new ArrayList<String>(Arrays.asList("cd", "bc")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 1.5, 2.5, 5.0 }, queries)));

		equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "b")));
		queries.add(new ArrayList<String>(Arrays.asList("b", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("x", "y")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 0.5 }, queries)));
	}

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);

		double[] output = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			output[i] = getValue(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<String>());
		}
		return output;
	}

	public static double getValue(String start, String end, HashMap<String, HashMap<String, Double>> graph,
			HashSet<String> visited) {
		if (!graph.containsKey(start))
			return -1.0;

		if (graph.get(start).containsKey(end))
			return graph.get(start).get(end);

		visited.add(start);
		HashMap<String, Double> vals = graph.get(start);
		for (Map.Entry<String, Double> entry : vals.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				double newVal = getValue(entry.getKey(), end, graph, visited);
				if (newVal != -1.0) {
					return entry.getValue() * newVal;
				}
			}
		}

		return -1.0;

	}

	public static HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
		HashMap<String, HashMap<String, Double>> graph = new HashMap<String, HashMap<String, Double>>();

		for (int i = 0; i < equations.size(); i++) {
			String start = equations.get(i).get(0);
			String end = equations.get(i).get(1);
			double weight = values[i];
			if (graph.containsKey(start)) {
				HashMap<String, Double> val = graph.get(start);
				val.put(end, weight);
				graph.put(start, val);
			} else {
				HashMap<String, Double> val = new HashMap<String, Double>();
				val.put(end, weight);
				graph.put(start, val);
			}

			if (graph.containsKey(end)) {
				HashMap<String, Double> val = graph.get(end);
				val.put(start, 1 / weight);
				graph.put(end, val);
			} else {
				HashMap<String, Double> val = new HashMap<String, Double>();
				val.put(start, 1 / weight);
				graph.put(end, val);
			}
		}
		return graph;
	}

}
