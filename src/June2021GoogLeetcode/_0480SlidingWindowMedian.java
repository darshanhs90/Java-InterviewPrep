package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0480SlidingWindowMedian {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(medianSlidingWindow(new int[] { 2147483647, 2147483647 }, 2)));
	}

	public static double[] medianSlidingWindow(int[] nums, int k) {
		double[] out = new double[nums.length - k + 1];
		List<Integer> list = new ArrayList<Integer>();
		int left = 0, right = 0;
		while (right < nums.length) {
			list.add(nums[right]);
			if (list.size() >= k) {
				Collections.sort(list);
				double val = list.get(k / 2);
				if (k % 2 == 0) {
					Long sum = (long) (list.get(k / 2));
					sum += list.get((k / 2) - 1);
					val = (sum) / (double) 2;
				}
				out[left] = val;
				list.remove(Integer.valueOf(nums[left]));
				left++;
			}
			right++;
		}
		return out;
	}

}
