package DP;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcdebcae";
		String s2 = "abcebc";
		
		System.out.println("Longest Common Subsequence is of length " + lcs(s1, s2));
	}
	
	private static int lcs(String s1, String s2) {
		int[][] array = new int[s2.length() + 1][s1.length() + 1];
		for (int i = s2.length() - 1; i >= 0; i--) {
			for (int j = s1.length() - 1; j >= 0; j--) {
				array[i][j] = array[i + 1][j + 1];
				if (s1.charAt(j) == s2.charAt(i)) {
					array[i][j]++;
//					System.out.println(s1.charAt(j));
				}
				int temp = Math.max(array[i][j + 1], array[i + 1][j]);
				if (temp > array[i][j])
					array[i][j] = temp;
			}
		}
		
		int i = 0; 
		int j = 0;
		while (array[i][j] != 0) {
			if (array[i][j] > array[i + 1][j + 1]) {
				if (array[i][j] == array[i][j + 1])
					j++;
				else if (array[i][j] == array[i + 1][j])
					i++;
				else {
					System.out.println(s2.charAt(i));
					i++;
					j++;
				}
			} else {
				i++;
				j++;
			}				
		}
		
		return array[0][0];
	}

}
