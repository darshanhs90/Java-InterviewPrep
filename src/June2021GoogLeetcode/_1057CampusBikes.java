package June2021GoogLeetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _1057CampusBikes {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(assignBikes(new int[][] { new int[] { 0, 0 }, new int[] { 2, 1 } },
				new int[][] { new int[] { 1, 2 }, new int[] { 3, 3 } })));

		System.out.println(
				Arrays.toString(assignBikes(new int[][] { new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 2, 0 } },
						new int[][] { new int[] { 1, 0 }, new int[] { 2, 2 }, new int[] { 2, 1 } })));
	}

	public static int[] assignBikes(int[][] workers, int[][] bikes) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int dist1 = o1[0];
				int dist2 = o2[0];

				int workerIndex1 = o1[1];
				int workerIndex2 = o2[1];

				int bikeIndex1 = o1[2];
				int bikeIndex2 = o2[2];

				if (dist1 == dist2) {
					if (workerIndex1 == workerIndex2)
						return bikeIndex1 - bikeIndex2;
					return workerIndex1 - workerIndex2;
				}
				return dist1 - dist2;
			}
		});

		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);

				pq.offer(new int[] { dist, i, j });
			}
		}

		int[] res = new int[workers.length];
		Arrays.fill(res, -1);
		HashSet<Integer> visitedBikes = new HashSet<Integer>();
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			int workerIndex = arr[1];
			int bikeIndex = arr[2];

			if (res[workerIndex] == -1 && !visitedBikes.contains(bikeIndex)) {
				res[workerIndex] = bikeIndex;
				visitedBikes.add(bikeIndex);
			}
		}
		return res;
	}
}
