package May2021Leetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Pair {
		String str;
		int count;
		boolean isString;

		public Pair(String str) {
			this.str = str;
			this.isString = true;
		}

		public Pair(int count) {
			this.count = count;
		}
	}

	public static String decodeString(String s) {
		Stack<Pair> stack = new Stack<Pair>();
		int i = 0;
		while (i < s.length()) {

			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				String str = c + "";
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					str += s.charAt(i + 1);
					i++;
				}
				stack.push(new Pair(Integer.parseInt(str)));
				i++;
			} else if (c == '[') {
				i++;
			} else if (c == ']') {

				String str = "";
				while (!stack.isEmpty() && stack.peek().isString) {
					str += stack.pop().str;
				}

				int mult = 1;
				if (!stack.isEmpty() && !stack.peek().isString) {
					mult = stack.pop().count;
				}

				String out = "";
				for (int j = 0; j < mult; j++) {
					out += str;
				}
				stack.push(new Pair(out));
				i++;
			} else {
				stack.push(new Pair(c + ""));
				i++;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop().str);
		}
		return sb.reverse().toString();
	}

}
