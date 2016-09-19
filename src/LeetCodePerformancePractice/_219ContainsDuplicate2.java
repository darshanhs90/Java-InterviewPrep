package LeetCodePerformancePractice;

import java.util.HashSet;
import java.util.Set;

public class _219ContainsDuplicate2 {
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{3,1,2,4,2,6}));
	}
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
