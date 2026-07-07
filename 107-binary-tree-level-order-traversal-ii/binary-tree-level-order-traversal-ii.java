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

    private void f(TreeNode root, List<List<Integer>> outer, int level){
        if(root == null)
            return;
        
        if(outer.size() == level){
            outer.add(0, new ArrayList<>());
        }

        outer.get(outer.size() - level - 1).add(root.val);

        if(root.left != null)
            f(root.left, outer, level + 1);
        
        if(root.right != null)
            f(root.right, outer, level + 1);

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        f(root, outer, 0);

        // Collections.reverse(outer);
        return outer;
    }
}