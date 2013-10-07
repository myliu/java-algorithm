package string;

public class LongestPalindrome3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPalindrome("a"));
	}
	
    public static String longestPalindrome(String s) {
    	int l = s.length();
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = l - 1; i >= 0; i--)
    		sb.append(s.charAt(i));
    	String r = sb.toString();
    	
    	int[][] map = new int[l][l];
    	int max = 1;
    	int k = 0;
    	for (int i = 0; i < l; i++) {
    		if (r.charAt(0) == s.charAt(i))
    			map[0][i] = 1;
    	}
    	
    	for (int i = 0; i < l; i++) {
    		if (r.charAt(i) == s.charAt(0))
    			map[i][0] = 1;
    	}
    	
    	for (int i = 1; i < l; i++) {
    		for (int j = 1; j < l; j++) {
    			if (r.charAt(i) == s.charAt(j)) {
    				map[i][j] = map[i - 1][j - 1] + 1;
    				if (map[i][j] > max && (l - 1 - i + map[i][j] - 1 == j)) {
    					max = map[i][j];
    					k = j;
    				}
    			}
    		}
    	}
    	return s.substring(k - max + 1, k + 1);
    }
}
