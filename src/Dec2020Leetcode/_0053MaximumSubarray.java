package Dec2020Leetcode;

public class _0053MaximumSubarray {
	// https://www.youtube.com/watch?v=2MmGzdiKR9Y
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { 1 }));
		System.out.println(maxSubArray(new int[] { 0 }));
		System.out.println(maxSubArray(new int[] { -1 }));
		System.out.println(maxSubArray(new int[] { -2147483647 }));
		System.out.println(maxSubArray(new int[] { -2, 1 }));
	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum + nums[i] > nums[i]) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
