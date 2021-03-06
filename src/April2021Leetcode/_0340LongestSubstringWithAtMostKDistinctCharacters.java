package April2021Leetcode;

import java.util.HashMap;

public class _0340LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
	}

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		int left = 0, right = 0;
		while (right < s.length()) {
			map.compute(s.charAt(right), (key, val) -> val == null ? 1 : val + 1);

			while (map.size() > k) {
				char c = s.charAt(left);
				map.put(c, map.get(c) - 1);

				if (map.get(c) == 0)
					map.remove(c);

				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
			right++;
		}
		return maxLength;
	}
}
