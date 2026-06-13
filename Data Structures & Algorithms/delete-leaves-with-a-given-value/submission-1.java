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
    int globalCount;
    int ElementChange;
    boolean allErased;
    //left -> 0 
    //right -> 1
    void dfs(TreeNode node ,TreeNode parent,int side,int target){

        if(node.left == null && node.right == null && node.val == target){
            ElementChange++;
            if(side == 0){
                parent.left = null;
            }else if(side == 1){
                parent.right = null;
            }else{
                allErased = true;
            }


        }

        if(node.left !=null)  dfs(node.left , node , 0 , target);
        if(node.right !=null) dfs(node.right , node , 1 , target); 

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;
        globalCount = -1;
        ElementChange = 0;
        allErased = false;
        TreeNode result = null;
        do{
            if(allErased)  return result;
            dfs(root,root,-1,target);
            globalCount++;
        }while(ElementChange  != globalCount);
        return root ;
    }
}