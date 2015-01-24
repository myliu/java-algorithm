package dp;

public class ContinuousMax1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, -5, 7, 6, -8, 3, -2};
		System.out.println(max(array));
	}
	
	private static int max(int[] array) {
		int max = 0;
		int[] sum = new int[array.length];
		sum[0] = array[0];
		for (int i = 1; i < sum.length; i++) {
			if (sum[i-1] > 0) 
				sum[i] = sum[i-1] + array[i];
			else
				sum[i] = array[i];
			if (sum[i] > max)
				max = sum[i];
		}
		return max;
	}

}
