package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _050LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> output = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return output;
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		dfs(0, "", digits, map, output);
		return output;
	}

	public static void dfs(int index, String currString, String digits, HashMap<Character, String> map,
			List<String> output) {
		if (index == digits.length()) {
			output.add(currString);
			return;
		}

		char c = digits.charAt(index);
		if (map.containsKey(c)) {
			String str = map.get(c);
			for (int i = 0; i < str.length(); i++) {
				dfs(index + 1, currString + str.charAt(i), digits, map, output);
			}
		} else {
			dfs(index + 1, currString, digits, map, output);
		}
	}
}
