package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SplitPalindrome {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * 示例 1：
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     *
     * 示例 2：
     *
     * 输入：s = "a"
     * 输出：[["a"]]
     * 
     *
     * 提示：
     *
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     *
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
     */

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s==null||s.length()<1) return results;
        backtrack(results, new ArrayList<>(),s,0);
        return results;
    }
    private void backtrack(List<List<String>> results,List<String> cur,String s,int lo){
        if(lo==s.length()){
            results.add(cur);
            return;
        }
        int n = s.length();
        for(int hi = lo; hi <n; hi++){

            if(isPalindrome(s,lo, hi)){
                cur.add(s.substring(lo, hi +1));
                backtrack(results, cur, s, hi +1);
                cur.remove(cur.size() - 1);
            }

        }
    }
    private boolean isPalindrome(String s,int lo,int hi){

        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {

        /*"aadsffghfdhb";*/
    }
}
