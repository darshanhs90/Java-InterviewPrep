package Mar2021Leetcode;

public class _0543DiameterOfBinaryTree {

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
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(2);
		System.out.println(diameterOfBinaryTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.left.left.left = new TreeNode(6);
		tn.left.left.left.left = new TreeNode(7);
		tn.left.left.left.left.left = new TreeNode(8);
		tn.left.left.left.left.left.left = new TreeNode(9);
		tn.left.right.right = new TreeNode(10);
		tn.left.right.right.right = new TreeNode(11);
		tn.left.right.right.right.right = new TreeNode(12);
		tn.left.right.right.right.right.right = new TreeNode(13);
		tn.right = new TreeNode(2);
		System.out.println(diameterOfBinaryTree(tn));
	}

	static int max;

	public static int diameterOfBinaryTree(TreeNode root) {
		max = 0;
		if (root == null)
			return 0;
		getDiameter(root);
		return max;
	}

	public static int getDiameter(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = getDiameter(root.left);
		int rightHeight = getDiameter(root.right);

		max = Math.max(max, leftHeight + rightHeight);
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
