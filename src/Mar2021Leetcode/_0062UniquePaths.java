package Mar2021Leetcode;

import java.util.Arrays;

public class _0062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] arr = new int[m][n];
		Arrays.fill(arr[0], 1);
		for (int i = 0; i < m; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m - 1][n - 1];
	}
}
