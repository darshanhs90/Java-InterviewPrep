package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0350IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
		System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			map1.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
		}
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0) {
				output.add(nums2[i]);
				map1.compute(nums2[i], (k, v) -> v == null ? 0 : v - 1);
			}
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}
}
