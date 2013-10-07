package string;

public class LongestCommonSubstring2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcbbbabc";
		String s2 = "abcdabc";
		String s3 = LCS(s1, s2);
		System.out.println(s3);
	}
	
	public static String LCS(String s1, String s2) {
		int[][] map = new int[s1.length()][s2.length()];
		int max = 0;
		int m = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == s1.charAt(0)) 
				map[0][i] = 1;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0))
				map[i][0] = 1;
		}
		
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					map[i][j] = map[i-1][j-1] + 1;
					if (map[i][j] > max) {
						max = map[i][j];
						m = i;
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(m);
		return s1.substring(m-max+1, m+1);
	}

}
