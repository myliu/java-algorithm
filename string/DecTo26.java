package string;

public class DecTo26 {
	
	public static void main(String[] args) {
		System.out.println(convert(27));
	}
	
	public static String convert(int x) {
		String str = "";
		while (x > 0) {
			str = String.valueOf((char)(x % 26 + 'a')) + str;
			x = x / 26;
		}
		return str;
	}

}
