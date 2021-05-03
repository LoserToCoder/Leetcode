package com.leetcode.map;

import java.util.*;

public class GroupAnagrams {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。
     * 字母异位词指字母相同，但排列不同的字符串。
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * 说明：
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * @param strs
     *
     *1: 通过计算排列之后的字符的相对位置的重新组合成key
     * 2: 通过计算字母相对位置的索引所对应位置的素数相乘之积当做key
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        int[]chars=new int[26];
        Map<String,List<String>> map=new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            Arrays.fill(chars,0);
            for(int i=0;i<str.length();i++){
                char sc = str.charAt(i);
                chars[sc-'a']++;
            }
            for(int c:chars){
                sb.append(c);
            }
            String key=sb.toString();
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
            sb.delete(0, sb.length());
        }


        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
