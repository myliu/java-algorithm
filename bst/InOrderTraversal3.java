package bst;

import java.util.Stack;

public class InOrderTraversal3 {

//	public static void inOrder(Node<Integer> root) {
//		if (root == null)
//			return;
//		
//		inOrder(root.getLeft());
//		System.out.println(root.getData());
//		inOrder(root.getRight());
//	}
	
	public static void inOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			
			if (stack.isEmpty())
				break;
			
			root = stack.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
	}
}
