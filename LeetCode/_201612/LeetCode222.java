package edu.ustc.shshen.LeetCode._201612;

/**
 * @Title: LeetCode222
 * @Description: 时间复杂度o(lgn^2)
 * @School: USTC 
 * @Author ShShen
 * @Date 2016年12月2日下午3:08:14*/
public class LeetCode222 {
	
	public int countNodes(TreeNode root) {
        int h = findHead(root);
        return h == -1?0:
        			findHead(root.right) == h-1?(1<<h)+countNodes(root.right):
        									(1<<h-1)+countNodes(root.left);
    }
	public int findHead(TreeNode root){
		return root == null?-1:1+findHead(root.left);
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}