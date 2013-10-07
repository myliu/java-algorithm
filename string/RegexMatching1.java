package string;

public class RegexMatching1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "a*";
		System.out.println(isMatch(s1, s2));
//		System.out.println("\"" + s1.substring(1) + "\"");
	}
	
	public static boolean isMatch(String s, String p) {
		if (p.equals(""))
			return s.equals("");
		
		if ((p.length() > 1 && p.charAt(1) != '*') || (p.length() == 1)) {
			if (s.equals(""))
				return false;
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
		}
		
		int i = 0;
		while (i < s.length() && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.')) {
			if (isMatch(s.substring(i), p.substring(2)))
				return true;
			i++;
		}
		return isMatch(s.substring(i), p.substring(2));
	}
	
	public static boolean isMatch2(String s, String p) {
		if (s.equals("")) {
			if (p.equals(""))
				return true;
			if (p.length() > 1 && p.charAt(1) == '*')
				return isMatch2(s, p.substring(2));
			return false;
		}
		
		if (!s.equals("") && p.equals(""))
			return false;
		
		if (p.charAt(0) != '.') {
			if (s.charAt(0) == p.charAt(0)) {
				if (p.length() > 1 && p.charAt(1) == '*') {
					if (isMatch2(s.substring(1), p.substring(0)))
						return true;
					for (int i = 0; i <= s.length(); i++) {
						if (isMatch2(s.substring(i), p.substring(2)))
							return true;
					}
				}
				else
					return isMatch2(s.substring(1), p.substring(1));
			}
	
			if (s.charAt(0) != p.charAt(0)) {
				if (p.length() > 2 && p.charAt(1) == '*')
					return isMatch2(s, p.substring(2));
				else
					return false;
			}
		}

		
		if (p.charAt(0) == '.') {
			if (p.length() == 1 || (p.length() > 1 && p.charAt(1) != '*')) {
				return isMatch2(s.substring(1), p.substring(1));
			}
			if (p.length() > 1) {
				for (int i = 0; i <= s.length(); i++) {
					if (isMatch2(s.substring(i), p.substring(2)))
						return true;
				}
			}
		}
		
		return false;
	}

}
