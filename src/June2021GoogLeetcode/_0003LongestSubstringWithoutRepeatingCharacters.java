package June2021GoogLeetcode;

import java.util.HashMap;

public class _0003LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring("abcdefgh"));
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring("abbab"));
	}

	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0, max = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				left = Math.max(left, map.get(c) + 1);
			}
			map.put(c, right);
			max = Math.max(max, right - left + 1);
			right++;
		}
		return max;
	}
}
