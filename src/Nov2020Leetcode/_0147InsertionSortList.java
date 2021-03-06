package Nov2020Leetcode;

public class _0147InsertionSortList {
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
		ListNode ln = new ListNode(4);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(1);
		ln.next.next.next = new ListNode(3);
		printNodes(insertionSortList(ln));

		ln = new ListNode(-1);
		ln.next = new ListNode(5);
		ln.next.next = new ListNode(3);
		ln.next.next.next = new ListNode(4);
		ln.next.next.next.next = new ListNode(0);
		printNodes(insertionSortList(ln));

	}

	public static void printNodes(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummyHead = new ListNode();
		ListNode prev = dummyHead;
		ListNode curr = head;
		ListNode next = head.next;

		while (curr != null) {
			next = curr.next;
			while (prev != null && prev.next != null && prev.next.val < curr.val) {
				prev = prev.next;
			}
			curr.next = prev.next;
			prev.next = curr;
			curr = next;
			prev = dummyHead;
		}

		return dummyHead.next;
	}
}
