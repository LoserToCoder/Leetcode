package com.leetcode.stack;

public class RemoveDuplicates {


    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            int len=sb.length();
            if (len>0&&ch == sb.charAt(len - 1)) {
                sb.deleteCharAt(len-1);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates("abbaca"));

    }

}
