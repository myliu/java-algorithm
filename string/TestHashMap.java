package string;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("a", "2");
		System.out.println(map.get("a"));
	}

}
