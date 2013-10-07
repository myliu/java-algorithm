package permutation;

import java.util.Random;

public class RandomGen {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		randGen(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void randGen(int[] a) {
		Random rand = new Random();
		for (int i = a.length; i > 0; i--) {
			int x = rand.nextInt(i);
			int temp = a[i - 1];
			a[i - 1] = a[x];
			a[x] = temp;
		}
	}
	
}
