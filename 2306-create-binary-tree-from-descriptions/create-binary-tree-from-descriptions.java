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
    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> childs = new HashSet<>();

        for(int[] des : descriptions){
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode p = map.get(parent);
            TreeNode c = map.get(child);

            childs.add(child);

            if(isLeft == 1)
                p.left = c;
            else
                p.right = c;
        }

        for(int[] des : descriptions){
            if(!childs.contains(des[0])){
                return map.get(des[0]);
            }
        }

        return null;
    }
}