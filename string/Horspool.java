package string;

import java.util.HashMap;

public class Horspool {

	public static void main(String[] args) {
		String s1 = "bbcdabcd";
		String s2 = "abcd";
		if (substring(s1, s2))
			System.out.println("s2 is a substring of s1");
		else
			System.out.println("s2 is not a substring of s1");
	}
	
	private static boolean substring(String s1, String s2) {
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();		
		for (int i = 0; i < s2.length() - 1; i++) {
			map.put(s2.charAt(i), s2.length() - 1 - i);
		}
		
		int m = s2Length - 1;
		int x = s2Length;
		while (m < s1Length) {
			for (int i = 0; i < s2Length; i++) {
				if (s1.charAt(m - i) == s2.charAt(s2Length - 1 - i)) {
					if (i == s2Length - 1)
						return true;
				} else {					
					if (map.containsKey(s1.charAt(m)))
						x = map.get(s1.charAt(m));
					else 
						x = s2Length;											
					m = m + x;
					break;
				}
			}
		}		
		return false;
	}
}
