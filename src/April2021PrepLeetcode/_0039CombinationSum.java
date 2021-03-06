package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0039CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 1));
		System.out.println(combinationSum(new int[] { 1 }, 2));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(0, 0, candidates, target, new ArrayList<Integer>(), output);
		return output;
	}

	public static void dfs(int index, int currSum, int[] nums, int target, List<Integer> list,
			List<List<Integer>> output) {
		if (currSum == target) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		if (index >= nums.length || currSum > target)
			return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(i, currSum + nums[i], nums, target, list, output);
			list.remove(list.size() - 1);
		}
	}

}
