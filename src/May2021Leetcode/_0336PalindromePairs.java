package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0336PalindromePairs {

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));

	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			tr.searchWord(words[i], i, output);
		}
		return output;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void addWord(String word, int index) {
			TrieNode tn = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				String str = word.substring(0, i);
				if (isPalindrome(str)) {
					tn.palIndex.add(index);
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode();
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.pos = index;
			tn.palIndex.add(index);
		}

		public void searchWord(String word, int index, List<List<Integer>> output) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				String str = word.substring(i, word.length());
				if (tn.pos != -1 && tn.pos != index && isPalindrome(str)) {
					output.add(new ArrayList<Integer>(Arrays.asList(index, tn.pos)));
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return;
				}
				tn = tn.childrens[c - 'a'];
			}
			List<Integer> list = tn.palIndex;
			for (Integer num : list) {
				if (num != index) {
					output.add(new ArrayList<Integer>(Arrays.asList(index, num)));
				}
			}
		}

		public boolean isPalindrome(String word) {
			return new StringBuilder(word).reverse().toString().equals(word);
		}

	}

	static class TrieNode {
		TrieNode[] childrens;
		int pos;
		List<Integer> palIndex;

		public TrieNode() {
			this.pos = -1;
			this.palIndex = new ArrayList<Integer>();
			this.childrens = new TrieNode[26];
		}
	}

}
