package Mar2021Leetcode;

public class _0129SumRootToLeafNumbers {
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
		System.out.println(sumNumbers(tn));

		tn = new TreeNode(4);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(0);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(1);
		System.out.println(sumNumbers(tn));
	}

	static int sum;

	public static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sum = 0;
		dfs(root, "");
		return sum;
	}

	public static void dfs(TreeNode root, String currNum) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			sum += Integer.parseInt(currNum + root.val);
			return;
		}

		dfs(root.left, currNum + root.val);
		dfs(root.right, currNum + root.val);
	}

}
