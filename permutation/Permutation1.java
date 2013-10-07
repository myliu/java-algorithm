package permutation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutation1 {
	
	static HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();
	static Set<String> set = new HashSet<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Character> list1 = new LinkedList<Character>();
		list1.add('a');
		list1.add('b');
		List<Character> list2 = new LinkedList<Character>();
		list2.add('c');
		list2.add('d');
		list2.add('e');
		map.put('1', list1);
		map.put('2', list2);
		
		String input = "12";
		perm(input, "");
		
		for (String s : set) {
			System.out.println(s);
		}
	}
	
	private static void perm(String input, String output) {
		if (input == null) 
			return;
		
		if (input.isEmpty()) {
			set.add(output);
			return;
		}
		
		char c = input.charAt(0);
		List<Character> list = map.get(c);
		for (char ch : list) {
			perm(input.substring(1), ""+ch+output);
		}
	}


}
