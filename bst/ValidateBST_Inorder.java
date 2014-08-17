package binarySearchTree;

public class ValidateBST_Inorder {
	
	int prev = Integer.MIN_VALUE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateBST_Inorder bst = new ValidateBST_Inorder();
		System.out.println(bst.prev);
		
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		root.left = left;
		
		System.out.println(bst.isValidBST(root));
	}
	
    public boolean isValidBST(TreeNode root) {
    	if (root == null)
    		return true;
    	
    	if (isValidBST(root.left)) {
    		if (root.val > prev) {
    			prev = root.val;
    			return isValidBST(root.right);
    		}
    		return false;
    	}    	
    	return false;
    }
    
    public static class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }

}
