package permutation;


public class BinaryPermutation1 {

	public static void main(String[] args) {
		BinaryPermutation1 bp = new BinaryPermutation1();
		bp.run();
	}
	
	private void run() {
		gen(4, 2, "");
	}
	
	private void gen(int m, int n, String s) {
//		m is number of 0, n is number of 1
		if (m == 0 && n == 0) {
			System.out.println(s);
			return;
		}
		if (n > 0) {
			String next = s + '1';
			gen(m,n-1,next);
		}
		if (m > 0) {
			String next = s + '0';
			gen(m-1,n,next);
		}
	}
	
}
