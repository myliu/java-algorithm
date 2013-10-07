package string;

import java.util.HashMap;
import java.util.TreeSet;

public class AddSpace {
	
	static TreeSet<String> dict = new TreeSet<String>();
	static HashMap<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		String input = "thisisanawesomebanana";
		String[] words = {"a", "an", "ana", "awesome", "banana", "is", "some", "this"};
		for (String word : words) {
			dict.add(word);
		}
		System.out.println(addSpace(input));
	}
	
	private static String addSpace(String input) {
		if (dict.contains(input))
			return input;
		if (map.containsKey(input))
			return map.get(input);
		for (int i = 1; i < input.length(); i++) {
			String prefix = input.substring(0, i);
			if (!dict.contains(prefix))
				continue;
			String suffix = input.substring(i);
			String result = addSpace(suffix);
			if (result != null) {
				map.put(suffix, result);
				return prefix + " " + result;
			}
		}
		map.put(input, null);
		return null;
	}

}
