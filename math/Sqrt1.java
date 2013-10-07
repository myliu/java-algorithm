package math;

public class Sqrt1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sqrt(26));

	}
	
	private static int sqrt(int x) {
		if (x < 0)
			return -1;
		if (x == 0)
			return 0;
		int i = 1;
		while (true) {
			if (i * i == x) {
				return i;
			} else if (i * i > x) {
				return i - 1;
			}
			i++;
		}
	}

}
