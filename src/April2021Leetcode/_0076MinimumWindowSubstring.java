package April2021Leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0076MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		String outString = "";
		int minLength = Integer.MAX_VALUE;
		int left = 0, right = 0;
		while (right < s.length()) {
			char currChar = s.charAt(right);
			if (tMap.containsKey(currChar)) {
				sMap.compute(currChar, (k, v) -> v == null ? 1 : v + 1);

				while (isMapEqual(sMap, tMap)) {
					if (right - left + 1 < minLength) {
						outString = s.substring(left, right + 1);
						minLength = right - left + 1;
					}

					char c = s.charAt(left);
					if (tMap.containsKey(c)) {
						sMap.put(c, sMap.get(c) - 1);

						if (sMap.get(c) == 0)
							sMap.remove(c);
					}

					left++;
				}
			}
			right++;
		}
		return outString;
	}

	public static boolean isMapEqual(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
		if (sMap.size() != tMap.size())
			return false;
		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {

			if (!sMap.containsKey(entry.getKey()))
				return false;
			if (sMap.get(entry.getKey()).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
