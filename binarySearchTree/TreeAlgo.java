package binarySearchTree;

import java.util.ArrayList;


public class TreeAlgo {
	
	public static void main(String[] args) {
//		int[] input = {2, 3, 6, 8, 1, 5, 4, 7, -7};
		
//		int[] input = {10, 1, 8, 2};
		
		int[] input = {30, 25, 39, 10, 27, 5, 32, 31, 35, 48, 42, 51, 40, 43};
		
		Tree root = new Tree(input[0], null, null, null);
		for (int i = 1; i < input.length; i++) {
			root.insert(input[i]);
		}
		
//		inOrderTraversal(root);
		
//		System.out.println("Max is " + findMax(root));
		
//		System.out.println("Sum Max is " + findSumMax(root));
		
//		ArrayList<Integer> p = new ArrayList<Integer>();
//		if (findSum(root, p, -4))
//			System.out.println("Sum found!");
//		else
//			System.out.println("Sum not found!");
		
//		System.out.println("Successor is " + successor(root.getLeft().getRight()));
		
		delete(root, root.getRight());
		
		inOrderTraversal(root);
	}
	
	private static void inOrderTraversal(Tree t) {
		if (t != null) {
			inOrderTraversal(t.getLeft());
			System.out.println(t.getValue());
			inOrderTraversal(t.getRight());
		}			
	}
	
	private static int findMax(Tree t) {
		System.out.println(t.getValue());
		if (t.getRight() == null) 
			return t.getValue();
		else 
			return findMax(t.getRight());
	}
	
	private static int findSumMax(Tree t) {
		if (t == null)
			return 0;
		return t.getValue() + Math.max(findSumMax(t.getLeft()), findSumMax(t.getRight()));
	}
	
	@SuppressWarnings("unchecked")
	private static boolean findSum(Tree t, ArrayList<Integer> p, int k) {
		if (t == null)
			return false;
		ArrayList<Integer> p1 = (ArrayList<Integer>) p.clone();
		p1.add(t.getValue());
		int result = k;
		for (int i = 0; i < p1.size(); i++) {
			result -= p1.get(i);
		}
		if (result == 0) {
			for (int i : p1) {
				System.out.print(i + " ");
			}
			return true;
		}
		return findSum(t.getLeft(), p1, k) || findSum(t.getRight(), p1, k);		
	}
	
	private static int successor(Tree t) {
		if (t.getRight() != null) {
			return findMax(t.getRight());
		}
		Tree p = t.getParent();
		while (p != null) {
			if (p.getLeft() == t)
				return t.getParent().getValue();
			else {
				t = p;
				p = p.getParent();
			}
		}
		return -1;
	}
	
	private static void transplant(Tree root, Tree u, Tree v) {
		if (u.getParent() == null) {
			root = v;
		} else if (u.getParent().getLeft() == u) {
			u.getParent().setLeft(v);
		} else {
			u.getParent().setRight(v);
		}
		if (v != null)
			v.setParent(u.getParent());
	} 
	
	private static Tree min(Tree t) {
		if (t.getLeft() == null) {
			return t;
		} 
		return min(t.getLeft());
	}
	
	private static void delete(Tree root, Tree z) {
		if (z.getLeft() == null) 
			transplant(root, z, z.getRight());
		else if (z.getRight() == null)
			transplant(root, z, z.getLeft());
		else {
			Tree y = min(z.getRight());
			if (y.getParent() != z) {
				transplant(root, y, y.getRight());
				y.setRight(z.getRight());
				z.getRight().setParent(y);
			}
			transplant(root, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}

}
