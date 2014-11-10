package leet;

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
}
