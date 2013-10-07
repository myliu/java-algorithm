package string;

import java.util.HashMap;

public class WindowSliding {
	
	public static void main(String[] args) {
		String input = "mikelikesapplebaee";
		String window = "aee";
		System.out.println("Min window is " + minWindow(input, window));
	}
	
	private static int minWindow(String input, String window) {

		int[] toFind = new int[256];
		int[] found = new int[256];
		int count = 0;
		int j  = 0; 
		int start = 0;
		int end = input.length() - 1;
		int minWin = input.length();
		
		for (int i = 0; i < window.length(); i++) {
			char temp = window.charAt(i);
			toFind[temp]++;
		}
		
		for (int i = 0; i < input.length(); i++) {
			if (toFind[input.charAt(i)] == 0)
				continue;
			
			found[input.charAt(i)]++;
			
			if (found[input.charAt(i)] <= toFind[input.charAt(i)])
				count++;
			
			if (count == window.length()) {
				while (toFind[input.charAt(j)] == 0 || found[input.charAt(j)] > toFind[input.charAt(j)]) {
					if (found[input.charAt(j)] > toFind[input.charAt(j)])
						found[input.charAt(j)]--;
					j++;
				}
				
				if (minWin > i - j + 1) {
					minWin = i - j + 1;
					start = j ;
					end = i;
				}
			}
		}
		return minWin;
	}

}
