package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    public class Solution {
        Map<String, Boolean> breakableMap = new HashMap<String, Boolean>();

        public boolean wordBreak(String s, Set<String> dict) {
            if (dict.contains(s)) {
                return true;
            }

            if (breakableMap.containsKey(s)) {
                return breakableMap.get(s);
            }

            int len = s.length();

            for (int i = 1; i < len; i++) {
                String prefix = s.substring(0, i);
                if (dict.contains(prefix)) {
                    String suffix = s.substring(i);
                    if (wordBreak(suffix, dict)) {
                        breakableMap.put(s, true);
                        return true;
                    }
                }
            }

            breakableMap.put(s, false);
            return false;
        }
    }

}
