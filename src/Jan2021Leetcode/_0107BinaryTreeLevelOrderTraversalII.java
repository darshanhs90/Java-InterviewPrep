package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0107BinaryTreeLevelOrderTraversalII {
	public static class TreeNode {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(levelOrderBottom(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(3);
		System.out.println(levelOrderBottom(tn));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				list.add(tn.val);
				if (tn.left != null)
					q.offer(tn.left);

				if (tn.right != null)
					q.offer(tn.right);
			}
			output.add(list);
		}

		Collections.reverse(output);
		return output;
	}

}
