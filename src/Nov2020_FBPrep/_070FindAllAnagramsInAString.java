package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _070FindAllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < p.length(); i++) {
			pMap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			sMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			if (i >= p.length()) {
				int deleteIndex = i - p.length();
				if (sMap.get(s.charAt(deleteIndex)) <= 1) {
					sMap.remove(s.charAt(deleteIndex));
				} else {
					sMap.put(s.charAt(deleteIndex), sMap.get(s.charAt(deleteIndex)) - 1);
				}
			}

			if (i >= p.length() - 1) {
				if (sMap.equals(pMap)) {
					output.add(i - p.length() + 1);
				}
			}
		}
		return output;
	}
}
