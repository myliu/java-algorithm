package string;

public class RegexMatching2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "a*";
		System.out.println(isMatch(s1, s2));
	}
	
	public static boolean isMatch(String s, String p) {
		if (p.equals(""))
			return s.equals("");
		
		if (p.length() == 1 || p.length() > 1 && p.charAt(1) != '*') {
			if (s.equals(""))
				return false;
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
		
		int i = 0;
		while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s.substring(i), p.substring(2)))
				return true;
			i++;
		}
		return isMatch(s.substring(i), p.substring(2));			
	}

}
