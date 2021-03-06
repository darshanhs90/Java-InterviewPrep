package May2021PrepLeetcode;

public class _0096UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(1));
		System.out.println(numTrees(2));
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(5));
	}

	public static int numTrees(int n) {
		if (n <= 1)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[dp.length - 1];
	}

}
