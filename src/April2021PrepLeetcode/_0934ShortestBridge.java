package April2021PrepLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0934ShortestBridge {

	public static void main(String[] args) {
		System.out.println(shortestBridge(new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 } }));
		System.out.println(
				shortestBridge(new int[][] { new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(shortestBridge(new int[][] { new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0, 1 },
				new int[] { 1, 0, 1, 0, 1 }, new int[] { 1, 0, 0, 0, 1 }, new int[] { 1, 1, 1, 1, 1 } }));
	}

	public static int shortestBridge(int[][] A) {
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					populateQ(i, j, A, q);
					return shortestBridge(q, A);
				}
			}
		}
		return 0;
	}

	public static int shortestBridge(Queue<int[]> q, int[][] A) {
		int count = 0;
		HashSet<String> visited = new HashSet<String>();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				if (A[x][y] == 1)
					return count-1;

				for (int j = 0; j < dirs.length; j++) {
					int newX = x + dirs[j][0];
					int newY = y + dirs[j][1];

					if (newX < 0 || newY < 0 || newX >= A.length || newY >= A[0].length || A[newX][newY] == -1
							|| visited.contains(newX + "/" + newY))
						continue;
					q.offer(new int[] { newX, newY });
					visited.add(newX + "/" + newY);
				}
			}
			count++;
		}
		return 0;
	}

	public static void populateQ(int x, int y, int[][] A, Queue<int[]> q) {
		if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] != 1)
			return;
		q.offer(new int[] { x, y });
		A[x][y] = -1;
		populateQ(x - 1, y, A, q);
		populateQ(x + 1, y, A, q);
		populateQ(x, y - 1, A, q);
		populateQ(x, y + 1, A, q);
	}

}
