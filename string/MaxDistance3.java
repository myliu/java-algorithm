package string;

import java.util.Stack;

public class MaxDistance3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] A = new int[]{4,3,5,2,1,3,2,3};
		Pair p = max(A);
		System.out.println(p.m + " " + p.n);		
	}
	
	private static Pair max(int[] A) {
		Stack<VI> stack1 = new Stack<VI>();
		Stack<VI> stack2 = new Stack<VI>();
		int smallest = A[0];
		stack1.push(new VI(A[0], 0));
		for (int i = 1; i < A.length; i++) {
			if (A[i] < smallest) {
				stack1.push(new VI(A[i], i));
				smallest = A[i];
			} else {
				stack2.push(new VI(A[i], i));
			}
		}
		
		VI s = null, t = null; 
		VI i = stack1.pop(), j = stack2.pop(); 
		int max = 0;
		while (true) {
			if (j.value > i.value) {
				if (j.index - i.index > max) {
					max = j.index - i.index;
					t = j;
					s = i;
				}
				if (!stack1.empty())
					i = stack1.pop();
				else
					break;
			} else {
				if (!stack2.empty())
					j = stack2.pop();
				else
					break;
			}
		}
		Pair p = new Pair(s.index, t.index);
		return p;
	}
	
	static class VI {
		int value;
		int index;
		VI(int v, int i) {
			value = v;
			index = i;
		}
	}
	
	static class Pair {
		int m;
		int n;
		Pair(int i, int j) {
			m = i;
			n = j;
		}
	}
}
