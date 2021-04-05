package com.leetcode.string;

public class FirstUniqChar {

    public char firstUniqChar(String s) {
        char target =' ';
        if(s==null||s.length()<1) {
            return target;
        }
        //存储字符出现的次数,使用int数组就是因为字符可能会很长,避免溢出
        int [] alphabet = new int[26];
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            alphabet[ch-'a']+=1;
        }
        //s保留着次序,其实可以使用另外一个数组来存储次序
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(alphabet[ch-'a']==1){
                return ch;
            }
        }
        return target;
    }

    public char firstUniqChars(String s) {
        char target =' ';
        if(s==null||s.length()<1) {
            return target;
        }
        //存储字符出现的次数,使用int数组就是因为字符可能会很长,避免溢出
        int [] alphabet = new int[26];
        //存储字符第一次出现的位置
        int [] sequent = new int[26];
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            alphabet[ch-'a']+=1;
            if(sequent[ch-'a']==0){
                sequent[ch-'a']=i;
            }
        }
        int seq = s.length();
        for(int i=0;i<26;i++){
            if(alphabet[i]==1){
                seq = Math.min(sequent[i], seq);
            }
        }
        if(seq<s.length()){
            return s.charAt(seq);
        }
        return target;
    }

}
