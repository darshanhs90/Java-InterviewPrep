package Jan2021Leetcode;

public class _0011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(maxArea(new int[] { 1, 2, 1 }));
	}

	public static int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {

			int currArea = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, currArea);

			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return maxArea;
	}

}
