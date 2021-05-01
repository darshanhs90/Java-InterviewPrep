package May2021PrepLeetcode;

public class _0152MaximumProductSubArray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	public static int maxProduct(int[] nums) {
		int res = nums[0];
		int minSoFar = nums[0];
		int maxSoFar = nums[0];

		for (int i = 1; i < nums.length; i++) {

			int curr = maxSoFar;
			maxSoFar = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
			minSoFar = Math.min(nums[i], Math.min(curr * nums[i], minSoFar * nums[i]));
			res = Math.max(res, maxSoFar);
		}
		return res;
	}
}
