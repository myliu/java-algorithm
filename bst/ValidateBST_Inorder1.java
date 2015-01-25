package bst;


public class ValidateBST_Inorder1 {
	
	int prev = Integer.MIN_VALUE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateBST_Inorder1 bst = new ValidateBST_Inorder1();
		bst.run();
	}
	
	private void run() {
		System.out.println(prev);
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(0);
		root.left = left;
		
		System.out.println(isValidBST(root));
	}
	
    public boolean isValidBST(TreeNode root) {
        if (root == null)
        	return true;
        
        if (!isValidBST(root.left))
        	return false;
        
        if (prev > root.val)
        	return false;
        
        prev = root.val;
        return isValidBST(root.right);        
    }
    
    public class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode(int x) { val = x; }
    }

}
