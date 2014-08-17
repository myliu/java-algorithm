package binarySearchTree;

public class ValidateBST_Min_Max {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
    		return true;
    	if (root.val > min && root.val < max)
    		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    	return false;
    } 
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }

}
