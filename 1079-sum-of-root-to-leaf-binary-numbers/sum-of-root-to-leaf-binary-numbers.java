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

    private int helper(TreeNode root, String binary, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum+= Integer.parseInt(binary+root.val, 2);

        return helper(root.left, binary+root.val, sum) + helper(root.right, binary+root.val, sum);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, "", 0);
    }
}