package April2021PrepLeetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1383MaximumPerformanceOfATeam {
	public static void main(String[] args) {
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 2));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));
	}

	public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int[][] perf = new int[speed.length][2];
		for (int i = 0; i < perf.length; i++) {
			perf[i] = new int[] { speed[i], efficiency[i] };
		}

		Arrays.sort(perf, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		long sum = 0, maxPerf = 0;
		for (int i = 0; i < perf.length; i++) {
			sum += perf[i][0];
			pq.offer(perf[i][0]);
			if (pq.size() > k) {
				sum -= pq.poll();
			}
			maxPerf = Math.max(maxPerf, sum * perf[i][1]);
		}
		return (int) (maxPerf % (long) (1e9 + 7));
	}

}
