package math;

public class Factorial2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fac(4));
	}
	
//	private static int fac(int n) {
//		if (n == 0)
//			return 1;
//		if (n == 1)
//			return 1;
//		return fac(n-1)*n;
//	}
	
	private static int fac(int n) {
		int s = 1;
		int i = 2;
		while (i <= n) {
			s *= i;
			i++;
		}
		return s;
	}

}
