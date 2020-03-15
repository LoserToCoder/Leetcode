package com.leetcode.map;

public class ValidAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 算法：
     *
     * 为了检查 t 是否是 s的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
     * 因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
     * 我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，
     * 用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零

     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[]letters=new int[26];
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            letters[sc-'a']++;
            letters[tc-'a']--;
        }
        for(int i=0;i<26;i++){
            if(letters[i]!=0) return false;
        }
        return true;
    }
}
