package PracticeLeetCode;

public class _024SwapNodesInPairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln=swapPairs(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode prevNode=new ListNode(-1);
		prevNode.next=head;
		ListNode prevNodePointer=prevNode;
		while(prevNode.next!=null && prevNode.next.next!=null)
		{
			ListNode curr=prevNode.next;
			ListNode next=prevNode.next.next;
			ListNode nextNext=prevNode.next.next.next;
			next.next=curr;
			curr.next=nextNext;
			prevNode.next=next;
			prevNode=curr;
		}
		return prevNodePointer.next;
	}


}

