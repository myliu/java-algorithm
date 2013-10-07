package string;

public class MaxDistance1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] A = new int[]{4,3,5,2,1,3,2,3};
		Pair p = max(A);
		System.out.println(p.m + " " + p.n);
		
	}
	
	private static Pair max(int[] A) {
		int m = 0, n = 0, max = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = A.length - 1; j >= 0; j--) {
				if (A[i] < A[j]) {
					if (j - i > max) {
						max = j - i;
						m = i;
						n = j;
					}
					break;
				}
			}
		}		
		
		return new Pair(m, n);
	}
	
	static class Pair {
		int m;
		int n;
		Pair(int i, int j) {
			m = i;
			n = j;
		}
	}

}
