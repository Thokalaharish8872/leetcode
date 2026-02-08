/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag = true;
    private int getLevel(TreeNode root){
        if(root == null) return 1;

        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);

        int height = Math.max(leftLevel, rightLevel);
        int avgHeight = Math.abs(leftLevel - rightLevel);

        if(!(avgHeight == 0 || avgHeight == 1)) flag = false;
        return height + 1;
        
    }
    public boolean isBalanced(TreeNode root) {
        
        getLevel(root);
        return flag;
    }
}