package sorting;

public class QuickSort {
	
	int[] array = new int[] {2, 1, 4, 9, 3, 11, 8, 0, 7, 6};
	
	public static void main(String[] args) {
		new QuickSort().run();
	}
	
	public void run() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ... ");
		}
		
		sort(array, 0, array.length - 1);
		System.out.println();
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ... ");
		}
	}
	
	public void sort(int[] a, int left, int right) {
		if (left < right) {
			int pivot = partition(a, left, right);
			sort(a, left, pivot - 1);
			sort(a, pivot + 1, right);
		}		
	}
	
	public int partition(int[] a, int left, int right) {
		int pivot = left + (right - left) / 2;
		int temp = a[right];
		a[right] = a[pivot];
		a[pivot] = temp;
		
		int store = left;
		for (int i = left; i < right; i++) {
			if (a[i] < a[right]) {
				temp = a[i];
				a[i] = a[store];
				a[store] = temp;
				store++;
			}
		}
		temp = a[store];
		a[store] = a[right];
		a[right] = temp;
		
		return store;
	}

}
