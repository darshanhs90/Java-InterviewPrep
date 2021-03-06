package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0131PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> palindromes = new HashSet<String>();
		partitionString(0, s, new ArrayList<String>(), output, palindromes);
		return output;
	}

	public static void partitionString(int index, String s, List<String> list, List<List<String>> output,
			HashSet<String> palindromes) {
		if (index == s.length()) {
			output.add(new ArrayList<String>(list));
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (palindromes.contains(sb.toString()) || isPalindrome(sb.toString())) {
				palindromes.add(sb.toString());
				list.add(sb.toString());
				partitionString(i + 1, s, list, output, palindromes);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s);
	}

}
