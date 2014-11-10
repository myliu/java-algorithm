package leet;

import java.util.HashMap;
import java.util.Map;

public class StrStr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = strStr("mississippi", "ssi");
        System.out.println(s);
    }

    /**
     * Horspool Algorithm
     */
    public static String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }

        if (needle.isEmpty()) {
            return haystack;
        }

        int m = needle.length();

        // Build shitTable
        // By default, shift needle.length()
        // The shift distance is defined by the distance between last character and current character
        Map<Character, Integer> shiftTable = new HashMap<Character, Integer>();
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            shiftTable.put(c, m);
        }

        // Make sure the last character of the needle does not participate in shift table
        for (int i = 0; i < m - 1; i++) {
            shiftTable.put(needle.charAt(i), m - 1 - i);
        }

        // i keeps track of the end of needle in the haystack
        int i = m - 1;
        while (i < haystack.length()) {
            for (int j = 0; j < m; j++) {
                // If any character does not match, we should try to move the needle
                if (haystack.charAt(i - j) != needle.charAt(m - 1 - j)) {
                    char c = haystack.charAt(i);
                    i += shiftTable.get(c);
                    break;
                }

                if (j == m - 1) {
                    return haystack.substring(i - m + 1);
                }
            }
        }

        return null;
    }

    /**
     * Brute Force
     */
    public static String strStrBF(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length() && i + j < haystack.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

                if (j == needle.length() - 1) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }

}
