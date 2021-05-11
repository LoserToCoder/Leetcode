package com.leetcode.bits;

public class MaximumProductOfWordLengths {


    /**
     * 318. 最大单词长度乘积
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
     * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     *
     * 示例 1:
     *
     * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
     * 输出: 16
     * 解释: 这两个单词为 "abcw", "xtfn"。
     * 示例 2:
     *
     * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
     * 输出: 4
     * 解释: 这两个单词为 "ab", "cd"。
     * 示例 3:
     *
     * 输入: ["a","aa","aaa","aaaa"]
     * 输出: 0
     * 解释: 不存在这样的两个单词。
     * 链接:https://leetcode-cn.com/problems/maximum-product-of-word-lengths
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int [] bitMask =new int[n];
        for(int i=0;i<n;i++){

            for(int j=0;j<words[i].length();j++) {
                bitMask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int maxLen = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){

                if((bitMask[i]&bitMask[j])==0){
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        int len = new MaximumProductOfWordLengths().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"});
        System.out.println(len);

    }


}
