package binarySearchTree;

import java.util.Stack;

public class InOrderTraversal2 {
	
	public static void inOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
	}

}
