package math;

public class Fibonacci {
	static int[] a2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fib1(4));
		System.out.println(fib2x(4));
		System.out.println(fib3(4));
	}
	
	private static int fib1(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return fib1(n - 1) + fib1(n - 2);
	}
	
	private static int fib2x(int n) {
		a2 = new int[n+1];
		return fib2(n);
	}

	private static int fib2(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (a2[n] != 0)
			return a2[n];
		a2[n] = fib2(n - 1) + fib2(n - 2);
		return a2[n];
	}

	private static int fib3(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		int[] a3 = new int[n+1];
		a3[0] = 1;
		a3[1] = 1;
		int i;
		for (i = 2; i <= n; i++) {
			a3[i] = a3[i-1] + a3[i-2];
		}
		return a3[n];
	}
	
}
