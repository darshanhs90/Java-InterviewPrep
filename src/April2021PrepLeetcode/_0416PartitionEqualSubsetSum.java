package April2021PrepLeetcode;

public class _0416PartitionEqualSubsetSum {

	public static void main(String[] args) {
		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
		System.out.println(canPartition(new int[] { -2, -1, 1, 2 }));
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		return canPartition(0, nums, sum / 2);
	}

	public static boolean canPartition(int index, int[] nums, int currSum) {
		if (index >= nums.length)
			return false;
		if (currSum == 0)
			return true;
		for (int i = index; i < nums.length; i++) {
			if (canPartition(i + 1, nums, currSum - nums[i]))
				return true;
		}
		return false;
	}

}
