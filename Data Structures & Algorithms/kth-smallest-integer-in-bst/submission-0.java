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
    public List<Integer> InOrder(TreeNode root,List<Integer> arr){
        if(root == null){
            return arr;
        }

        if(root.left!=null){
            InOrder(root.left,arr);
        }

        arr.add(root.val);

        if(root.right!=null){
            InOrder(root.right,arr);
        }

        return arr;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();

        arr = InOrder(root,arr);

        for(int i = 0;i<arr.size();i++){

            if(i == k-1){
                return arr.get(i);
            }
        }

        return -1;
    }
}
