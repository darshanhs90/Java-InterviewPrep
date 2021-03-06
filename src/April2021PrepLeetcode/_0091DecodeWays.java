package April2021PrepLeetcode;

import java.util.HashMap;

public class _0091DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("1"));
		System.out.println(numDecodings("2101"));
		System.out.println(numDecodings("123123"));
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		dfs(0, s, map);
		return map.containsKey(s) ? map.get(s) : 0;
	}

	public static int dfs(int index, String s, HashMap<String, Integer> map) {
		if (index == s.length())
			return 1;
		if (index > s.length())
			return 0;

		if (map.containsKey(s.substring(index))) {
			return map.get(s.substring(index));
		}

		char c = s.charAt(index);
		if (c == '0') {
			map.put(s.substring(index), 0);
			return 0;
		}

		int count = 0;
		count += dfs(index + 1, s, map);

		if (index + 1 < s.length()) {
			String str = c + "" + s.charAt(index + 1);
			int val = Integer.parseInt(str);
			if (val >= 10 && val <= 26) {
				count += dfs(index + 2, s, map);
			}
		}
		map.put(s.substring(index), count);
		return count;
	}
}
