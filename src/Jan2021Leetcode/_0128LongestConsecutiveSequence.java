package Jan2021Leetcode;

import java.util.HashSet;

public class _0128LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i] - 1)) {
				int count = 0;
				int start = nums[i];
				while (set.contains(start)) {
					start++;
					count++;
				}
				max = Math.max(count, max);
			}
		}
		return max;
	}
}
