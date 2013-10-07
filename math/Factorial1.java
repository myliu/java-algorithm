package math;

public class Factorial1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fac1(4));
		System.out.println(fac2(4));
	}
	
	private static int fac1(int n) {
		if (n >= 1)
			return n*fac1(n-1);
		else
			return 1;
	}
	
	private static int fac2(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = i * result;
		}
		return result;
	}

}
