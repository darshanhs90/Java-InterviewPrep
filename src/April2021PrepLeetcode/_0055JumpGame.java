package April2021PrepLeetcode;

public class _0055JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 2, 0, 4 }));
	}

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length < 2)
			return true;

		int maxReach = nums.length - 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= maxReach) {
				maxReach = i;
			}
		}
		return maxReach == 0;
	}

}
