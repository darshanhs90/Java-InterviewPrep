package May2021GoogLeetcode;

public class _0647PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += countPalindromes(i, i, s);
			if (i + 1 < s.length()) {
				count += countPalindromes(i, i + 1, s);
			}
		}
		return count;
	}

	public static int countPalindromes(int left, int right, String s) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count += 1;
			left--;
			right++;
		}
		return count;
	}
}
