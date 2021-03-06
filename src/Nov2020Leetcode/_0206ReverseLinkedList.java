package Nov2020Leetcode;

public class _0206ReverseLinkedList {
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
		ln.next.next.next.next = new ListNode(5);
		ln.next.next.next.next.next = new ListNode(6);
		ln.next.next.next.next.next.next = new ListNode(7);
		ln = reverseList(ln);
		printElements(ln);
		System.out.println();

	}

	public static void printElements(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "/");
			head = head.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode nextNode = head.next;
		ListNode newHead = reverseList(head.next);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}
}
