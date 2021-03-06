package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0210CourseScheduleII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOrder(2, new int[][] { new int[] { 1, 0 } })));
		System.out.println(Arrays.toString(findOrder(4,
				new int[][] { new int[] { 1, 0 }, new int[] { 2, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 } })));
		System.out.println(Arrays.toString(findOrder(1, new int[][] {})));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		return canFinish(numCourses, prerequisites);
	}

	public static int[] canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < numCourses; i++) {
			adjList.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int source = prerequisites[i][0];
			int destination = prerequisites[i][1];
			adjList.get(destination).add(source);
			if (adjList.get(source).contains(destination))
				return new int[] {};
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if (entry.getValue().size() == 0) {
				q.offer(entry.getKey());
			}
		}
		List<Integer> output = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer currCourse = q.poll();
				output.add(currCourse);
				visited.add(currCourse);
				for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
					if (!visited.contains(entry.getKey())) {

						if (entry.getValue().contains(currCourse)) {
							entry.getValue().remove(Integer.valueOf(currCourse));
							if (entry.getValue().size() == 0) {
								q.offer(entry.getKey());
							}
						}
					}
				}
			}
		}
		if (output.size() != numCourses)
			return new int[] {};
		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[out.length - i - 1] = output.get(i);
		}

		return out;
	}

}
