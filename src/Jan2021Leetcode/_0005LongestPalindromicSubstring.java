package Jan2021Leetcode;

public class _0005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("a"));
		System.out.println(longestPalindrome("ac"));
		System.out.println(longestPalindrome("amalayalam"));
	}

	public static String longestPalindrome(String s) {
		String max = "";
		for (int i = 0; i < s.length(); i++) {
			String st = getPalindrome(i, i, s);
			if (st.length() > max.length())
				max = st;

			if (i + 1 < s.length()) {
				st = getPalindrome(i, i + 1, s);
				if (st.length() > max.length())
					max = st;
			}
		}
		return max;
	}

	public static String getPalindrome(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return s.substring(left + 1, right);
	}

}
