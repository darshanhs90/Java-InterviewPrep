package May2021Leetcode;

public class _0616AddBoldTagInString {

	public static void main(String[] args) {
		System.out.println(addBoldTag("abcxyz123", new String[] { "abc", "123" }));
		System.out.println(addBoldTag("aaabbcc", new String[] { "aaa", "aab", "bc" }));
	}

	public static String addBoldTag(String s, String[] dict) {
		boolean bold[] = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			String subString = s.substring(i);
			for (String str : dict) {
				if (subString.startsWith(str)) {
					for (int j = i; j < i + str.length(); j++) {
						bold[j] = true;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length();) {
			if (!bold[i]) {
				sb.append(s.charAt(i));
				i++;
				continue;
			}

			sb.append("<b>");

			while (i < s.length() && bold[i]) {
				sb.append(s.charAt(i));
				i++;
			}
			sb.append("</b>");
		}
		return sb.toString();
	}
}
