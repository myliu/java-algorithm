package dp;

public class ContinuousMax {
	
	static int[] sum = new int[7];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1, -5, 7, 6, -8, 3, -2};
		System.out.println(max(array));
	}
	
	private static int max(int[] array) {
		if (array[0] > 0)
			sum[0] = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] + sum[i - 1] > 0)
				sum[i] = array[i] + sum[i - 1];
			else
				sum[i] = 0;
		}
		
		int mx = 0;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] > mx)
				mx = sum[i];
		}
		return mx;
	}

}
