package math;

public class Fibonacci1 {
	static int[] a2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fib1(4));
		System.out.println(fib2(4));
		System.out.println(fib3(4));
	}
	
	private static int fib1(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib1(n-1) + fib1(n-2);		
	}

	private static int fib2(int n) {
		a2 = new int[n+1];
		a2[1] = 1;
		int i = 2;
		while (i <= n) {
			a2[i] = a2[i-1] + a2[i-2];
			i++;
		}
		return a2[n];
	}

	private static int fib3(int n) {
		int m = 0;
		int k = 1;
		int s = 0;
		int i = 2;
		while (i <= n) {
			s = m + k;
			m = k;
			k = s;
			i++;
		}
		return s;
	}
	
}
