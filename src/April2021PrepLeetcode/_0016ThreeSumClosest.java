package April2021PrepLeetcode;

import java.util.Arrays;

public class _0016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 4));
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 3));
		System.out.println(threeSumClosest(new int[] { 0, 2, 1, -3 }, 1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		int closestSum = Integer.MAX_VALUE;
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = sum - target;
				if (Math.abs(diff) <= minDiff) {
					minDiff = Math.abs(diff);
					closestSum = sum;
				}

				if (diff > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return closestSum;
	}

}
