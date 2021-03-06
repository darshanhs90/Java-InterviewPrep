package Nov2020_UberPrep;

public class _014TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));// 6
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));// 9
	}

	public static int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		leftMax[0] = height[0];
		rightMax[height.length - 1] = height[height.length - 1];

		for (int i = 1; i < leftMax.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		for (int i = height.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			sum += (Math.min(leftMax[i], rightMax[i]) - height[i]);
		}
		return sum;
	}
}
