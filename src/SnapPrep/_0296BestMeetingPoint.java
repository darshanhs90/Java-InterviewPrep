package SnapPrep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0296BestMeetingPoint {

	public static void main(String[] args) {
		System.out.println(minTotalDistance(
				new int[][] { new int[] { 1, 0, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));
	}

	public static int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		}

		int[][] distance = new int[grid.length][grid[0].length];
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			populateDistance(arr, grid, distance);
		}

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				minDistance = Math.min(minDistance, distance[i][j]);
			}
		}

		return minDistance;
	}

	public static void populateDistance(int[] srcPoint, int[][] grid, int[][] distance) {
		HashSet<String> visited = new HashSet<String>();
		int baseX = srcPoint[0];
		int baseY = srcPoint[1];

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(srcPoint);
		visited.add(srcPoint[0] + "/" + srcPoint[1]);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				distance[x][y] += Math.abs(x - baseX) + Math.abs(y - baseY);

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
							|| visited.contains(newX + "/" + newY))
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
		}
	}
}
