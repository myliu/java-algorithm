package string;

import java.util.HashMap;

public class WildcardMatching {
	
	HashMap<String, Boolean> map = new HashMap<String, Boolean>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching wm = new WildcardMatching();
		String s = "bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa";
		String p = "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****";
		
		System.out.println(wm.isMatch(s, p));
		
		
	}

    public boolean isMatch(String s, String p) {
    	if (p.equals("")) {
    		return s.equals("");
    	}
    	
    	if (map.containsKey(s+"|"+p)) {
	    	return map.get(s+"|"+p);
    	}
    	
    	if (p.charAt(0) != '?' && p.charAt(0) != '*') {
    		if (s.equals(""))
    			return false;
    		
    		if (s.charAt(0) != p.charAt(0))
    			return false;
    		else {
    			if (isMatch(s.substring(1), p.substring(1))) {
    				map.put(s+"|"+p, true);
    				return true;
    			} else {
    				map.put(s+"|"+p, false);
    				return false;
    			}
    		}
    	}
    	
    	if (p.charAt(0) == '?') {
    		if (s.equals(""))
    			return false;
			if (isMatch(s.substring(1), p.substring(1))) {
				map.put(s+"|"+p, true);
				return true;
			} else {
				map.put(s+"|"+p, false);
				return false;
			}
    	}
    	
    	if (p.charAt(0) == '*') {
    		for (int i = 0; i <= s.length(); i++) {
    			if (isMatch(s.substring(i), p.substring(1))) {
    				map.put(s+"|"+p, true);
    				return true;
    			} else {
    				map.put(s+"|"+p, false);
    			}
    		}
    	}
    	
    	return false;
    }
	
}
