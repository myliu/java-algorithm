package DP;

public class LongestCommonSubsequence1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcdebcae";
		String s2 = "abcebc";
		
		System.out.println("Longest Common Subsequence is of length " + lcs(s1, s2));
	}
	
	private static int lcs(String s1, String s2) {
		int[][] a = new int[s1.length()][s2.length()];
		
		char c = s2.charAt(0);
		boolean f = false;
		for (int i = 0; i < s1.length(); i++) {
			if (f)
				a[i][0] = 1;
			if (s1.charAt(i) == c) {
				a[i][0] = 1;
				f = true;
			}
		}
		
		c = s1.charAt(0);
		f = false;
		for (int i = 0; i < s2.length(); i++) {
			if (f)
				a[0][i] = 1;
			if (s2.charAt(i) == c) {
				a[0][i] = 1;
				f = true;
			}
		}
		
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j))
					a[i][j] = a[i-1][j-1] + 1;
				else
					a[i][j] = Math.max(a[i-1][j], a[i][j-1]);
			}
		}
		
		return a[s1.length()-1][s2.length()-1];
	}

}
