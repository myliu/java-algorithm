package bst;

public class Tree {
	
	private int value;
	private Tree left;
	private Tree right;
	private Tree parent;
	
	public Tree() {
		
	}

	public Tree(int v, Tree l, Tree r, Tree p) {
		value = v;
		left = l;
		right = r;
		parent = p;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Tree getLeft() {
		return left;
	}

	public void setLeft(Tree left) {
		this.left = left;
	}

	public Tree getRight() {
		return right;
	}

	public void setRight(Tree right) {
		this.right = right;
	}

	public Tree getParent() {
		return parent;
	}

	public void setParent(Tree parent) {
		this.parent = parent;
	}
	
	public void insert(int v) {
		if (v == value)
			return;
		else if (v < value) {
			if (left == null) 
				left = new Tree(v, null, null, this);
			else 
				left.insert(v);
		} else {
			if (right == null)
				right = new Tree(v, null, null, this);
			else 
				right.insert(v);
		}
	}

}
