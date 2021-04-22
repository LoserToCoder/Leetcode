package com.leetcode.doublespoints;

public class IndexOf {

    /**
     * 实现strStr()函数。
     * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        if (needle==null||"".equals(needle)) {
            return 0;
        }
        int p,q,back=-1;

        for(p=0,q=0;p<haystack.length()&&q<needle.length();){

            if(haystack.charAt(p)==needle.charAt(q)){

                if(q==0){
                    back=p;
                }
                p++;
                q++;
            }else {
                p=++back;
                q=0;
            }
        }

        return q==needle.length()?back:-1;

    }

    public static void main(String[] args) {


        IndexOf indexOf = new IndexOf();
        System.out.println(indexOf.strStr("",""));
        System.out.println("".equals(""));

    }
}
