package Nov2020Leetcode;

import java.util.PriorityQueue;

public class _0215KthLargestElementInAnArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
			if (queue.size() > k)
				queue.poll();
		}
		return queue.peek();
	}
}
