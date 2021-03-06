package Nov2020Leetcode;

public class _0275HIndexII {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 0, 1, 3, 5, 6 }));
	}

	public static int hIndex(int[] citations) {
		int n = citations.length;
		int[] out = new int[n + 1];

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= n)
				out[n]++;
			else {
				out[citations[i]]++;
			}
		}

		int count = 0;
		for (int i = out.length - 1; i >= 0; i--) {
			count += out[i];
			if (count >= i)
				return i;
		}
		return 0;
	}

}
