package leetcode;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//翻转树
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode left = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(left);
		return root;
	}
	
	//归并两棵树
	public TreeNode mergeTrees(TreeNode t1 ,TreeNode t2) {
		if(t1==null && t2==null) return null;
		if(t1==null) return t2;
		if(t2==null) return t1;
		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = mergeTrees(t1.left,t2.left);
		root.right = mergeTrees(t1.right, t2.right);
		return root;
	}
	
}
