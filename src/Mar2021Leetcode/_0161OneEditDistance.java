package Mar2021Leetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));

		System.out.println(isOneEditDistance("a", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		if (s.equals(t))
			return false;

		String maxString = "";
		String minString = "";
		if (s.length() > t.length()) {
			maxString = s;
			minString = t;
		} else {
			maxString = t;
			minString = s;
		}

		for (int i = 0; i < Math.min(maxString.length(), minString.length()); i++) {
			char c1 = maxString.charAt(i);
			char c2 = minString.charAt(i);

			if (c1 != c2) {
				if (maxString.length() == minString.length()) {
					return maxString.substring(i+1).equals(minString.substring(i+1));
				} else {
					return maxString.substring(i + 1).equals(minString.substring(i));
				}
			}
		}

		return true;
	}

}
