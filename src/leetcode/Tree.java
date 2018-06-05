package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tree {	
	public void dfs(TreeNode root,String prefix,List<String> ret) {
		if(root==null) return;
		if(root.left==null && root.right ==null) {
			ret.add(prefix+root.val);
			return;
		}
		prefix +=(root.val+"->");
		dfs(root.left,prefix,ret);
		dfs(root.right,prefix,ret);
	}
	
	/*先序遍历*/
    public static void preOrderRec(TreeNode root){  
        if(root!=null){  
            System.out.println(root.val);  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
        }  
    }
    
    /*中序遍历*/
    public static void inOrderRec(TreeNode root){  
        if(root!=null){  
            preOrderRec(root.left);  
            System.out.println(root.val);  
            preOrderRec(root.right);  
        }  
    } 
    
    /*后序遍历*/
    public static void postOrderRec(TreeNode root){  
        if(root!=null){  
            preOrderRec(root.left);  
            preOrderRec(root.right);  
            System.out.println(root.val);  
        }  
    }
    
    /*树的高度*/
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
    	return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    /*翻转树*/
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	TreeNode left = root.left;
    	root.left = invertTree(root.right);
    	root.right = invertTree(left);
    	return root;
    }
    
    /*归并两棵树*/
    /*判断路径和是否等于一个数*/
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	if(root.left ==null && root.right == null && root.val ==sum) return true;
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
    }
   /* 统计路径和等于一个数的路径数量,路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。*/
    public int pathSum(TreeNode root, int sum) {
    	if(root == null) return 0;
    	int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) +pathSum(root.right, sum);
    	return ret;
    }
    
    private int pathSumStartWithRoot(TreeNode root, int sum){
    	if(root == null) return 0;
    	int ret = 0;
    	if(root.val == sum) ret++;
    	ret += pathSumStartWithRoot(root.left, sum - root.val) +pathSumStartWithRoot(root.right, sum -root.val);
    	return ret;
    }
}
class TreeNode{
	TreeNode left,right;
	int val;
	public TreeNode(int val) {
		super();
		this.val = val;
	}
}
