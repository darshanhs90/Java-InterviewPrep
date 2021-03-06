package June2021GoogLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0296BestMeetingPoint {

	public static void main(String[] args) {
		System.out.println(minTotalDistance(
				new int[][] { new int[] { 1, 0, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 1, 0, 0 } }));

		System.out.println(minTotalDistance(new int[][] { new int[] { 1, 1 } }));
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
		int[][] dist = new int[grid.length][grid[0].length];
		while (!q.isEmpty()) {
			populateDist(q.poll(), dist);
		}

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist[0].length; j++) {
				minDistance = Math.min(minDistance, dist[i][j]);
			}
		}
		return minDistance;
	}

	public static void populateDist(int[] arr, int[][] dist) {
		HashSet<String> visited = new HashSet<String>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(arr);
		visited.add(arr[0] + "/" + arr[1]);
		int count = 0;

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				arr = q.poll();
				int x = arr[0];
				int y = arr[1];

				dist[x][y] += count;
				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= dist.length || newY >= dist[0].length
							|| visited.contains(newX + "/" + newY))
						continue;

					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
	}

}
