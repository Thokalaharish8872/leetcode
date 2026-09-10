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
    private int[] f(TreeNode root){
        if(root == null)
            return new int[]{0, 0, 0};
        
        int[] left = f(root.left);
        int[] right = f(root.right);

        int[] ans = left;

        ans[0] = left[0] + right[0] + root.val;
        ans[1] = left[1] + right[1] + 1;
        ans[2] = left[2] + right[2];

        if(ans[0] / ans[1] == root.val)
            ans[2]++;

        return ans;
    }
    public int averageOfSubtree(TreeNode root) {
        return f(root)[2];

    }
}