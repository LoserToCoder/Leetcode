package com.leetcode.map;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class FindAllAnagrams {

    /**
     * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，
     * 返回这些子串的起始索引。
     * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
     * 说明：
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例1:
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * 输出:
     * [0, 6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     * 示例 2:
     * 输入:
     * s: "abab" p: "ab"
     * 输出:
     * [0, 1, 2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * @param s
     * @param p
     * @return
     * 同ValidAnagram即:
     * 散列表+滑动窗口
     */

    public List<Integer> findAnagrams(String s, String p) {
      return null;
    }


    public static void main(String[] args) {

    }
}
