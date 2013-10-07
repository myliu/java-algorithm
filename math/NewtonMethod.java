package math;

public class NewtonMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(newton());
	}
	
	public static double newton() {
		double x = 25; 
		for (int i = 0; i < 10; i++) {
			x =x - f1(x)/fd1(x);
		}
		return x;
	}
	
	private static double f1(double x) {
		return Math.pow(x, 2) - 2*x + 1;
	}
	
	private static double fd1(double x) {
		return 2*x - 2;
	}
	
	private static double f2(double x) {
		return Math.sqrt(x);
	}
	
	private static double fd2(double x) {
		return 0.5 * Math.pow(x, -0.5);
	}

}
