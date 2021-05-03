package com.leetcode.string;

public class LongestPalindromicSubString {


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。
     * 你可以假设s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * @param s
     * @return

    算法:
    因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点,
    往两边扩散，看最多能扩散多远。枚举“中心位置”时间复杂度为 O(N)，从“中心位置”扩散得到“回文子串”的时间复杂度为 O(N)，
    因此时间复杂度可以降到 O(N^2) */

    
    public int central(String s,int l,int r){
             int maxLen=1;
             while(l>=0&&r<s.length()){
                  if(s.charAt(l)==s.charAt(r)){
                       maxLen=r-l+1;
                       l--;
                       r++;
                  }else{
                    break;
                  }

             }
             return maxLen;
    }


    public String longestPalindrome(String s) {


       if(s==null||s.length()<1) return "";
       int maxLen=1;
       int start=0,end=0;
       for(int i=1;i<s.length();i++){

            int oddLen=central(s,i,i);
            int evenLen=central(s,i,i+1);
            int len=Math.max(oddLen,evenLen);

            if(maxLen<len){
                start=i-(len-1)/2;
                end=i+len/2;
                maxLen=len;
            }

       }

        return s.substring(start,end+1);
    }

    public static void main(String[] args) {


        LongestPalindromicSubString palindrom = new LongestPalindromicSubString();

        String s = "cbbd";
        System.out.println(palindrom.longestPalindrome(s));

    }
}
