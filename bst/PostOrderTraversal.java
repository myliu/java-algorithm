package bst;

import java.util.Stack;

public class PostOrderTraversal {
	
	// not working
	public static void postOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			else {
				if (stack.isEmpty()) {
					System.out.println("Stack is Empty");
					return;
				}
				else {
					if (stack.peek().getRight() == null) {
						root = stack.pop();
//						stack.pop();
//						System.out.println(root.getData());
//						if (root == stack.peek().getRight()) {
//							System.out.println(stack.peek().getData());
//							stack.pop();
//						}
 					}
				}
				if (!stack.isEmpty())
					root= stack.peek().getRight();
				else
					root = null;
			}
		}
	}

}
