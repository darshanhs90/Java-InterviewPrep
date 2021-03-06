package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0145BinaryTreePostOrderTraversal {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		System.out.println(postorderTraversal(tn));

		tn = new TreeNode(4);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(0);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(1);
		System.out.println(postorderTraversal(tn));
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		if (root == null)
			return output;
		postOrder(root, output);
		return output;
	}

	public static void postOrder(TreeNode root, List<Integer> output) {
		if (root == null)
			return;
		postOrder(root.left, output);
		postOrder(root.right, output);
		output.add(root.val);
	}
}
