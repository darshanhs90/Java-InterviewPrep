package eBayPrep;

public class _268MissingNumber{
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,2,3}));
		System.out.println(missingNumber(new int[]{0,1,3}));
		System.out.println(missingNumber(new int[]{1,2,3}));
		
	}
	public static int missingNumber(int[] nums) {
		int n=nums.length;
		int sum=(n*(n+1))/2;
		int arraySum=0;
		for (int i = 0; i < nums.length; i++) {
			arraySum+=nums[i];
		}
		return (-arraySum+sum);

	}
}

