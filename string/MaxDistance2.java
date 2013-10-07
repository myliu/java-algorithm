package string;

public class MaxDistance2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] A = new int[]{4,3,5,2,1,3,2,3};
		Pair p = max(A);
		System.out.println(p.m + " " + p.n);		
	}
	
	private static Pair max(int[] A) {
		VI[] list = new VI[A.length];

		for (int i = 0; i < A.length; i++) {
			list[i] = new VI(A[i], i);
		}

		mergeSort(list);
		
//		for (int i = 0; i < list.length; i++) {
//			System.out.println(list[i].value + " " + list[i].index);
//		}
		
		int largest = 0;
		int[] A2 = new int[list.length];
		for (int i = list.length - 1; i >= 0; i--) {
			if (list[i].index > largest)
				largest = list[i].index;
			A2[i] = largest;
		}
		
		int s = 0;
		int t = 0;
		int diff = 0;
		for (int i = 0; i < list.length; i++) {
			if (A2[i] - list[i].index > diff) {
				diff = A2[i] - list[i].index;
				s = i;
				t = A2[i];
			}
		}
		return new Pair(s, t);
	}
	
	static void mergeSort(VI[] list) {
		if (list.length <= 1)
			return;		
		
		int m = list.length / 2;
		int n = list.length - m;
		VI[] firstList = new VI[m];
		for (int i = 0; i < m; i++) {
			firstList[i] = list[i];
		}
		mergeSort(firstList);
		
		VI[] secondList = new VI[n];
		for (int i = 0; i < n; i++) {
			secondList[i] = list[m + i];
		}
		mergeSort(secondList);
		
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (firstList[i].value <= secondList[j].value) {
				list[i+j] = firstList[i];
				i++;
			}
			else {
				list[i+j] = secondList[j];
				j++;
			}
		}
		if (i == m) {
			while (j < n) {
				list[i+j] = secondList[j];
				j++;
			}
		}
		
		if (j == n) {
			while (i < m) {
				list[i+j] = firstList[i];
				i++;
			}
		}
		return;
	}
	
	static class Pair {
		int m;
		int n;
		Pair(int i, int j) {
			m = i;
			n = j;
		}
	}
	
	static class VI {
		int value;
		int index;
		VI(int v, int i) {
			value = v;
			index = i;
		}
	}

}
