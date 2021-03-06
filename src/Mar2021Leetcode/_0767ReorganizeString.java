package Mar2021Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0767ReorganizeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
	}

	static class Pair {
		char val;
		int count;

		public Pair(char val, int count) {
			this.val = val;
			this.count = count;
		}
	}

	public static String reorganizeString(String S) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			map.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.count - o1.count;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		while (pq.size() > 1) {
			Pair p1 = pq.poll();
			Pair p2 = pq.poll();

			sb.append(p1.val);
			sb.append(p2.val);

			if (p1.count > 1) {
				p1.count--;
				pq.offer(p1);
			}

			if (p2.count > 1) {
				p2.count--;
				pq.offer(p2);
			}
		}

		if (pq.isEmpty())
			return sb.toString();

		if (pq.peek().count > 1)
			return "";

		if (pq.peek().val == sb.charAt(sb.length() - 1))
			return "";

		sb.append(pq.peek().val);
		return sb.toString();
	}
}
