package sorting;

public class OneTwoThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = new int[]{2, 1, 0, 2, 0, 1, 1, 1, 2, 0};
		array = sort(array);
		for (int i : array) {
			System.out.println(i);
		}
		
		
	}
	
	private static int[] sort(int[] array) {
		int m = 0; // all numbers on the left side of m are 0
		int n = 0; // all numbers on the left side of n and starting from m are 1 
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 2)
				continue;
			else if (array[i] == 1) {
				array[n] = 1;
				array[i] = 2;
				n++;
			} else {
				array[m] = 0;
				array[n] = 1;
				array[i] = 2;
				m++;
				n++;
			}
		}
		
		return array;
	}

}
