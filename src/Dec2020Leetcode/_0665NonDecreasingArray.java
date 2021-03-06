package Dec2020Leetcode;

public class _0665NonDecreasingArray {

	public static void main(String[] args) {
		System.out.println(checkPossibility(new int[] { 4, 2, 3 }));
		System.out.println(checkPossibility(new int[] { 4, 2, 1 }));
		System.out.println(checkPossibility(new int[] { -1, 4, 2, 3 }));
		System.out.println(checkPossibility(new int[] { -1, 4, 2, 8 }));
		System.out.println(checkPossibility(new int[] { 3, 4, 2, 3 }));
	}

	public static boolean checkPossibility(int[] nums) {
		if (nums == null || nums.length < 2)
			return true;
		int noOfChanges = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				noOfChanges++;

				if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
					nums[i - 1] = nums[i];
				} else {
					nums[i] = nums[i - 1];
				}

			}
			if (noOfChanges == 2)
				return false;
		}
		return true;
	}
}
