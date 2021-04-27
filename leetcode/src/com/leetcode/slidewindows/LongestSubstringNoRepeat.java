package com.leetcode.slidewindows;

import java.util.Arrays;

public class LongestSubstringNoRepeat {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1 || s == null) {
            return s.length();
        }
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int maxLen = 0, pre = -1, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 当前字母 最后出现的位置
            // 找到 前一的最长子串 的长度
            pre = Math.max(pre, map[ch]);
            // 当前长度就是 i - 之前的坐标
            cur = i - pre;
            maxLen = Math.max(cur, maxLen);
            // 更新当前字母出现的最后位置
            map[ch] = i;
        }
        return maxLen;
    }

}
