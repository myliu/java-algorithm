package bst;

public class LowestCommonAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree root = new Tree();
		Tree l1 = new Tree();
		Tree l2 = new Tree();
		Tree l3 = new Tree();
		Tree l4 = new Tree();
		Tree l5 = new Tree();
		Tree l6 = new Tree();
		
		root.setValue(12);
		root.setLeft(l1);
		root.setRight(l2);
		
		l1.setValue(5);
		l1.setLeft(l3);
		l1.setRight(l4);
		
		l2.setValue(15);
		l2.setLeft(l5);
		
		l3.setValue(2);
		
		l4.setValue(8);
		
		l5.setValue(13);
		l5.setRight(l6);
		
		l6.setValue(14);
		
		int result = lca(root, l3, l1);
		System.out.println(result);
	}
	
	private static int lca(Tree root, Tree n1, Tree n2) {
		if (root.getValue() >= n1.getValue() && root.getValue() <= n2.getValue())
			return root.getValue();
		if (root.getValue() >= n1.getValue() && root.getValue() >= n2.getValue())
			return lca(root.getLeft(), n1, n2);
		else
			return lca(root.getRight(), n1, n2);
	}

}
