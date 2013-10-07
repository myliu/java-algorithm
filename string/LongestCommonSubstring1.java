package string;

public class LongestCommonSubstring1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcbabbbb";
		String s2 = "bbcbabcc";
		String s3 = LCS(s1, s2);
		System.out.println(s3);
	}
	
	public static String LCS(String s1, String s2) {
		int[][] map = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		int m = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					map[i+1][j+1] = map[i][j] + 1;
					if (map[i+1][j+1] > max) {
						max = map[i+1][j+1];
						m = i;
					}					
				}
			}
		}
		
		System.out.println(m);
		System.out.println(max);
		return s1.substring(m-max+1, m+1);
	}
 
}
