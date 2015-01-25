package bst;

import java.util.Stack;

public class PreOrderTraversal {
	
	public static void preOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		stack.push(root);
		while (true) {
			if (stack.isEmpty())
				break;
			root = stack.pop();
			System.out.println(root.getData());
			if (root.getRight() != null)
				stack.push(root.getRight());
			if (root.getLeft() != null)
				stack.push(root.getLeft());
		}
	}

}
