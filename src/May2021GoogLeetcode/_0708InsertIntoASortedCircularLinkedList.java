package May2021GoogLeetcode;

public class _0708InsertIntoASortedCircularLinkedList {
	public static void main(String[] args) {
	}

	static class Node {
		public int val;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	};

	public static Node insert(Node head, int insertVal) {
		Node newNode = new Node(insertVal);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		} else if (head.next == null) {
			head.next = newNode;
			newNode.next = head;
			return head;
		} else {
			Node prev = head;
			Node curr = head.next;
			Node maxNode = prev;
			int count = 0;
			while (count < 2) {
				if (curr == head) {
					count++;
				}

				if (prev.val <= insertVal && curr.val >= insertVal) {
					prev.next = newNode;
					newNode.next = curr;
					return head;
				}

				if (curr.val >= maxNode.val) {
					maxNode = curr;
				}
                prev = curr;
                curr = curr.next;
			}
			Node next = maxNode.next;

			maxNode.next = newNode;
			newNode.next = next;
			return head;
		}
	}
}
