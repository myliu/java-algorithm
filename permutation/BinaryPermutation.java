package permutation;

import java.util.HashSet;
import java.util.Set;

public class BinaryPermutation {

	public static void main(String[] args) {
		BinaryPermutation bp = new BinaryPermutation();
		HashSet<Integer> set = new HashSet<Integer>();
		bp.foo(set, 6, 6, 2);
	}
	
	@SuppressWarnings("unchecked")
	private void foo(HashSet<Integer> set, int m, int n, int k) {
		if (k == 0) {
			print(set, m);
			return;
		}
		
		if (n > k) {
			HashSet<Integer> set1 = (HashSet<Integer>) set.clone();
			foo(set1, m, n - 1, k);
		}
		
		HashSet<Integer> set2 = (HashSet<Integer>) set.clone();
		set2.add(n);
		foo(set2, m, n - 1, k - 1);
	}
	
	private void print(Set<Integer> set, int n) {
		for (int i = 1; i <= n; i++) {
			if (set.contains(i))
				System.out.print(1);
			else 
				System.out.print(0);
		}
		System.out.println();
	}
	
}
