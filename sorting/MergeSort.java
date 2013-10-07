package sorting;

public class MergeSort {
	
	int[] array = new int[] {2, 1, 4, 9, 3, 11, 8, 0, 7, 6};
	
	public static void main(String[] args) {
		new MergeSort().run();
	}
	
	public void run() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ... ");
		}
		
		sort(array);
		System.out.println();
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ... ");
		}
	}
	
	public void sort(int[] a) {
		int length = a.length;
		if (length == 1) 
			return;
		int mid = length / 2;
		int[] left = new int[mid];
		int[] right = new int[length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int i = 0; i < (length - mid); i++) {
			right[i] = a[i + mid];
		}
		
		sort(left);
		sort(right);
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		while (x < mid && y < (length - mid)) {
			if (left[x] <= right[y]) {
				a[z] = left[x]; 
				x++;
			} else {
				a[z] = right[y];
				y++;
			}
			z++;		
		}
		
		if (x >= mid) {
			while (y < (length - mid)) {
				a[z] = right[y];
				y++;
				z++;
			}
		}
		
		if (y >= (length - mid)) {
			while (x < mid) {
				a[z] = left[x];
				x++;
				z++;
			}
		}
	}

}
