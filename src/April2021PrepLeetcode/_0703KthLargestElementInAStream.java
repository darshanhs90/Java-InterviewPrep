package April2021PrepLeetcode;

import java.util.PriorityQueue;

public class _0703KthLargestElementInAStream {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
		System.out.println(kthLargest.add(3)); // return 4
		System.out.println(kthLargest.add(5)); // return 5
		System.out.println(kthLargest.add(10)); // return 5
		System.out.println(kthLargest.add(9)); // return 8
		System.out.println(kthLargest.add(4)); // return 8
	}

	static class KthLargest {
		PriorityQueue<Integer> pq;
		int size;

		public KthLargest(int k, int[] nums) {
			pq = new PriorityQueue<Integer>();
			size = k;

			for (int i = 0; i < nums.length; i++) {
				pq.offer(nums[i]);
				if (pq.size() > k)
					pq.poll();
			}
		}

		public int add(int val) {
			pq.offer(val);
			if (pq.size() > size)
				pq.poll();
			return pq.peek();
		}
	}

}
