package June2021GoogLeetcode;

import java.util.Stack;

public class _1047RemoveAllAdjacentDuplicatesInString {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("aaaaaaaaa"));
	}

	public static String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (stack.isEmpty() || stack.peek() != c) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

}
