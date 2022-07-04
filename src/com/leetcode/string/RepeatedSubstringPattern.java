package com.leetcode.string;

public class RepeatedSubstringPattern {

    /**
     * 给定一个非空的字符串s，检查是否可以通过由它的一个子串重复多次构成。
     *
     * 
     *
     * 示例 1:
     *
     * 输入: s = "abab"
     * 输出: true
     * 解释: 可由子串 "ab" 重复两次构成。
     * 示例 2:
     *
     * 输入: s = "aba"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "abcabcabcabc"
     * 输出: true
     * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
     * 
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s由小写英文字母组成
     ** 链接：https://leetcode.cn/problems/repeated-substring-pattern
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int lens = s.length(), i = 0;
        while (++i < lens) {
            if (lens % i != 0) continue;
            //移位,错位
            if (s.substring(lens - i, lens).equals(s.substring(0, i)))
                if (s.substring(i, lens).equals(s.substring(0, lens - i))) return true;
        }
        return false;
    }
}
