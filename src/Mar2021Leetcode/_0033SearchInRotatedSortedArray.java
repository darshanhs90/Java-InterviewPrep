package Mar2021Leetcode;

public class _0033SearchInRotatedSortedArray {

	public static void main(String[] args) {

		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 6));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 7));
		System.out.println(search(new int[] { 1 }, 0) == -1);
		System.out.println(search(new int[] { 5, 1, 3 }, 5) == 0);
	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[left] <= nums[mid]) {
				// left to mid is sorted
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// mid to right is sorted
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
