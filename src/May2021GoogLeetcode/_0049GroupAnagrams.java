package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "" }));
		System.out.println(groupAnagrams(new String[] { "a" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {

			char cArr[] = str.toCharArray();
			Arrays.sort(cArr);
			String newString = new String(cArr);

			if (!map.containsKey(newString)) {
				map.put(newString, new ArrayList<String>());
			}
			map.get(newString).add(str);
		}

		List<List<String>> output = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
