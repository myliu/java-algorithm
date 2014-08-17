package binarySearchTree;

import java.util.Stack;

public class PreOrderTraversal1 {

//	public static void preOrder(Node<Integer> root) {
//		if (root == null)
//			return;
//		
//		System.out.println(root.getData());
//		preOrder(root.getLeft());
//		preOrder(root.getRight());
//	}
	
	public static void preOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<Integer> current = stack.pop();
			if (current == null)
				continue;
			System.out.println(current.getData());
			stack.push(current.getRight());
			stack.push(current.getLeft());
		}
	}
	
}
