package com.leetcode.slidewindows;

import java.util.Arrays;

public class PermutationInString {

    /**
     * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     *
     * 
     *
     * 示例 1：
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * 
     *
     * 提示：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     *
     * 链接：https://leetcode-cn.com/problems/permutation-in-string
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length(),n = s2.length();
        int[] map = new int[26];
        int [] windows = new int[26];
        for(int i=0;i<m;i++){
            char ch = s1.charAt(i);
            map[ch-'a']++;
        }
        int l=0,r=0;
        for(;r<n;r++){

            char ch = s2.charAt(r);
            if(map[ch-'a']==0){
                l = r+1;
                Arrays.fill(windows,0);
                continue;
            }
            windows[ch-'a']++;
            if(r-l+1==m){
                if(isEquals(map,windows)){
                    return true;
                }else{
                    windows[s2.charAt(l)-'a']--;
                    l++;
                }
            }
        }
        return false;
    }

    public boolean isEquals(int[]map,int []windows){

        for(int i=0;i<26;i++){
            if(map[i]!=0&&map[i]!=windows[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        permutationInString.checkInclusion("ky",
                "ainwkckifykxlribaypk");
    }
}
