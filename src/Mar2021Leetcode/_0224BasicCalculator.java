package Mar2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0224BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ')
				q.offer(c);
		}
		q.offer('+');
		return calc(q);
	}

	public static int calc(Queue<Character> q) {
		int res = 0;
		char prev = '+';
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();

			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				res = Integer.parseInt(str);
			} else if (c == '(') {
				res = calc(q);
			} else {
				if (prev == '+') {
					stack.push(+res);
				} else if (prev == '-') {
					stack.push(-res);
				} else if (prev == '*') {
					stack.push(stack.pop() * res);
				} else if (prev == '/') {
					stack.push(stack.pop() / res);
				}

				if (c == ')')
					break;
				res = 0;
				prev = c;
			}
		}

		int out = 0;
		while (!stack.isEmpty()) {
			out += stack.pop();
		}
		return out;
	}
}
