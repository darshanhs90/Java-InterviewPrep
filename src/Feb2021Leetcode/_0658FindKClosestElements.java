package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0658FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			out.add(arr[i]);
		}
		Collections.sort(out, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
		out = out.subList(0, k);
		Collections.sort(out);
		return out;
	}

}
