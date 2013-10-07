package permutation;

import java.util.Random;

public class RandomGen1 {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		randGen(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void randGen(int[] a) {
		Random rand = new Random();
		int n = 0;
		for (int m = a.length; m > 0; m--) {
			n = Math.abs(rand.nextInt()) % m;
			int temp = a[m-1];
			a[m-1] = a[n];
			a[n] = temp;
		}
	}
	
}
