package appleInterview;

public class _DS_LL_01LengthOfLLIterative {
	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		System.out.println(findLength(n));
	}
	static int findLength(Node n){
		int count=0;
		while(n!=null){
			n=n.next;
			count++;
		}
		return count;
	}
}
