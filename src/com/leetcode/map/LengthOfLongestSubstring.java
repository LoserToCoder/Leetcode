package com.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1 || s == null) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0,prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            prev = Math.max(prev, map.getOrDefault(ch, -1));
            maxLen = Math.max(maxLen, i - prev);
            map.put(ch, i);
        }
        return maxLen;
    }


}
