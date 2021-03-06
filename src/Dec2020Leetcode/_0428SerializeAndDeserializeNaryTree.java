package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0428SerializeAndDeserializeNaryTree {

	public static void main(String[] args) {
		Codec codec = new Codec();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.children = new ArrayList<Node>(Arrays.asList(n3, n2, n4));
		n3.children = new ArrayList<Node>(Arrays.asList(n5, n6));
		printNodes(n1);
		System.out.println();
		System.out.println(codec.serialize(n1));
		printNodes(codec.deserialize(codec.serialize(n1)));
		System.out.println();

		n1 = new Node(1);
		n2 = new Node(2);
		n3 = new Node(3);
		n4 = new Node(4);
		n5 = new Node(5);
		n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		n1.children = new ArrayList<Node>(Arrays.asList(n2, n3, n4, n5));
		n3.children = new ArrayList<Node>(Arrays.asList(n6, n7));
		n7.children = new ArrayList<Node>(Arrays.asList(n11));
		n11.children = new ArrayList<Node>(Arrays.asList(n14));
		n4.children = new ArrayList<Node>(Arrays.asList(n8));
		n8.children = new ArrayList<Node>(Arrays.asList(n12));
		n5.children = new ArrayList<Node>(Arrays.asList(n9, n10));
		n9.children = new ArrayList<Node>(Arrays.asList(n13));

		printNodes(n1);
		System.out.println();
		System.out.println(codec.serialize(n1));
		printNodes(codec.deserialize(codec.serialize(n1)));
		System.out.println();
	}

	static void printNodes(Node n1) {
		if (n1 != null) {
			System.out.print(n1.val + "->");
			if (n1.children != null) {
				for (int i = 0; i < n1.children.size(); i++) {
					printNodes(n1.children.get(i));
				}
			}
		}
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	static class Codec {
		// Encodes a tree to a single string.
		public String serialize(Node root) {
			StringBuilder sb = new StringBuilder();
			serializeHelper(root, sb);
			return sb.toString();
		}

		public void serializeHelper(Node root, StringBuilder sb) {
			if (root == null)
				return;
			sb.append(root.val + ",");
			if (root.children != null) {
				sb.append(root.children.size() + ",");
				for (Node child : root.children) {
					serializeHelper(child, sb);
				}
			} else {
				sb.append(0 + ",");
			}
		}

		// Decodes your encoded data to tree.
		public Node deserialize(String data) {
			if (data.isEmpty())
				return null;
			Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
			return deserialiseHelper(q);
		}

		public Node deserialiseHelper(Queue<String> q) {
			if (q.isEmpty())
				return null;
			Node n = new Node(Integer.parseInt(q.poll()));
			int noOfChildrens = Integer.parseInt(q.poll());
			n.children = new ArrayList<Node>();
			for (int i = 0; i < noOfChildrens; i++) {
				n.children.add(deserialiseHelper(q));
			}
			return n;
		}
	}

}
