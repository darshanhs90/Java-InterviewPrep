package April2021PrepLeetcode;

public class _0161OneEditDistance {
	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("", ""));
		System.out.println(isOneEditDistance("a", ""));
		System.out.println(isOneEditDistance("", "A"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1)
			return false;

		String maxString = "", minString = "";
		if (s.length() > t.length()) {
			maxString = s;
			minString = t;
		} else {
			maxString = t;
			minString = s;
		}

		for (int i = 0; i < minString.length(); i++) {
			if (maxString.charAt(i) != minString.charAt(i)) {
				if (maxString.length() == minString.length()) {
					return maxString.substring(i + 1).equals(minString.substring(i + 1));
				} else {
					return maxString.substring(i + 1).equals(minString.substring(i));
				}
			}
		}
		return true;
	}

}
