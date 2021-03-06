package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0056MergeIntervals {
	public static void main(String[] args) {
		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } }));
		System.out.println(merge(new int[][] { new int[] { 1, 4 }, new int[] { 4, 5 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 20 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length < 2)
			return intervals;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		List<int[]> output = new ArrayList<int[]>();

		int prevStart = intervals[0][0];
		int prevEnd = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int currStart = intervals[i][0];
			int currEnd = intervals[i][1];

			if (currStart >= prevStart && currStart <= prevEnd) {
				prevStart = Math.min(currStart, prevStart);
				prevEnd = Math.max(currEnd, prevEnd);
			} else {
				output.add(new int[] { prevStart, prevEnd });
				prevStart = currStart;
				prevEnd = currEnd;
			}
		}
		output.add(new int[] { prevStart, prevEnd });
		int[][] outputArr = new int[output.size()][2];
		for (int i = 0; i < outputArr.length; i++) {
			outputArr[i] = output.get(i);
		}

		return outputArr;
	}

}
