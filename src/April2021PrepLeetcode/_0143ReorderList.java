package April2021PrepLeetcode;

public class _0143ReorderList {
	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(5);
		reorderList(ln);

		ln = new ListNode(1);
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		reorderList(ln);

		ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		reorderList(ln);

	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head;
		ListNode fast = head;
		ListNode headPtr = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}

		ListNode nextNode = slow.next;
		slow.next = null;
		nextNode = reverseLL(nextNode);
		ListNode op = new ListNode();
		ListNode opPtr = op;

		while (headPtr != null || nextNode != null) {
			if (headPtr != null) {
				op.next = headPtr;
				op = op.next;
				headPtr = headPtr.next;
			}

			if (nextNode != null) {
				op.next = nextNode;
				op = op.next;
				nextNode = nextNode.next;
			}
		}
		head = opPtr.next;
		printNodes(head);
	}

	public static ListNode reverseLL(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode reverseNode = reverseLL(head.next);
		head.next = null;
		nextNode.next = head;
		return reverseNode;
	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
}
