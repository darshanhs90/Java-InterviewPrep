package May2021GoogLeetcode;

public class _0124BinaryTreeMaximumPathSum {

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
		System.out.println(maxPathSum(tn));

		tn = new TreeNode(-10);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(maxPathSum(tn));

		tn = new TreeNode(-2);
		tn.right = new TreeNode(-3);
		System.out.println(maxPathSum(tn));
	}

	static long maxSum;

	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxSum = Long.MIN_VALUE;
		helper(root);
		return (int) maxSum;
	}

	public static long helper(TreeNode root) {
		if (root == null)
			return 0;

		long leftVal = Math.max(helper(root.left), 0);
		long rightVal = Math.max(helper(root.right), 0);

		maxSum = Math.max(maxSum, leftVal + rightVal + root.val);
		return root.val + Math.max(leftVal, rightVal);
	}

}
