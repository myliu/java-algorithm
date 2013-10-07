package string;

public class LongestPalindrome1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abcbcbad"));
	}
	
    public static String longestPalindrome(String s) {
    	String r = reverse(s);
    	System.out.println(r);
    	int l = s.length();
    	int[][] map = new int[l][l];
    	int max = 0;
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
        			map[i][j] = map[i-1][j-1] + 1;
        			if (map[i][j] > max) {
        				System.out.println("map[i][j]: " + map[i][j]);
        				System.out.println("i: " + i);
        				System.out.println("j: " + j);
        				if (l - 1 - i + map[i][j] - 1 == j) {
        					max = map[i][j];
        					k = j;
        				}
        			}
        		}
        	}
        }
        
        System.out.println("max: " + max);
        System.out.println("k: " + k);
        return s.substring(k - max + 1, k + 1);
    }
    
    private static String reverse(String s) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = s.length() - 1; i >= 0; i--) {
    		sb.append(s.charAt(i));
    	}
    	return sb.toString();
    }

}
