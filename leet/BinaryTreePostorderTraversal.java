package leet;

import java.util.ArrayList;

public class BinaryTreePostorderTraversal {

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Solution
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        postorderTraversal(root, result);
        return result;
    }

    public void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
