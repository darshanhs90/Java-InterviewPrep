package May2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0211DesignAddAndSearchWordsDataStructure {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True

		wordDictionary = new WordDictionary();
		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");
		wordDictionary.addWord("add");
		System.out.println(wordDictionary.search("a")); // return False
		System.out.println(wordDictionary.search(".at")); // return False
		wordDictionary.addWord("bat");
		System.out.println(wordDictionary.search(".at")); // return True
		System.out.println(wordDictionary.search("an.")); // return True
		System.out.println(wordDictionary.search("a.d.")); // return False
		System.out.println(wordDictionary.search("b.")); // return False
		System.out.println(wordDictionary.search("a.d")); // return True
		System.out.println(wordDictionary.search(".")); // return False

	}

	static class WordDictionary {
		Trie tr;

		/** Initialize your data structure here. */
		public WordDictionary() {
			tr = new Trie();
		}

		public void addWord(String word) {
			tr.insertWord(word);
		}

		public boolean search(String word) {
			return tr.searchWord(word);
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void insertWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		public boolean searchWord(String word) {
			Queue<TrieNode> q = new LinkedList<TrieNode>();
			q.offer(root);
			for (int i = 0; i < word.length() && !q.isEmpty(); i++) {
				char c = word.charAt(i);

				int size = q.size();
				for (int j = 0; j < size; j++) {
					TrieNode tn = q.poll();
					if (c == '.') {
						TrieNode[] childrens = tn.childrens;
						for (TrieNode child : childrens) {
							if (child != null)
								q.offer(child);
						}
					} else {
						if (tn.childrens[c - 'a'] == null)
							continue;
						q.offer(tn.childrens[c - 'a']);
					}
				}
			}
			while (!q.isEmpty()) {
				TrieNode tn = q.poll();
				if (tn.isWord)
					return true;
			}
			return false;
		}

	}

	static class TrieNode {
		char c;
		TrieNode[] childrens;
		boolean isWord;

		public TrieNode(char c) {
			this.c = c;
			this.childrens = new TrieNode[26];
		}
	}
}
