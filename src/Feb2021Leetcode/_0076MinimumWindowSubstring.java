package Feb2021Leetcode;

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

		String minString = "";
		int minLength = Integer.MAX_VALUE;
		int left = 0, right = 0;
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			if (tMap.containsKey(c)) {
				sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
				while (mapEquals(tMap, sMap)) {
					if (right - left + 1 < minLength) {
						minLength = right - left + 1;
						minString = s.substring(left, right+1);
					}
					char c1 = s.charAt(left);
					if (tMap.containsKey(c1)) {
						sMap.put(c1, sMap.get(c1) - 1);
						if (sMap.get(c1) == 0)
							sMap.remove(c1);
					}
					left++;
				}
			}
			right++;
		}
		return minString;
	}

	public static boolean mapEquals(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap) {
		for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
			if (!sMap.containsKey(entry.getKey()))
				return false;
			if (sMap.get(entry.getKey()).intValue() < entry.getValue().intValue())
				return false;
		}
		return true;
	}
}
