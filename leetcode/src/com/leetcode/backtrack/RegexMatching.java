package com.leetcode.backtrack;


public class RegexMatching {

    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
     * 说明:
     * s可能为空，且只包含从a-z的小写字母。
     * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     */
    /**
     *
     * @param s 目标串
     * @param p 模式串
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s==null||p==null) return false;
        return match(s, p);
    }
    
    public boolean match(String s,String p){

        if(p.length()==0) return s.length()==0;

        boolean firstMatch=s.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');

        if(p.length()>=2&&p.charAt(1)=='*'){
             // match(s,p.substring(2)) 意味着*代表0个字符意思,
             // firstMatch&&match(s.subtring(1),p)意味着*代表多个
            return match(s, p.substring(2)) || (firstMatch && match(s.substring(1), p));
        }else{
            return firstMatch && match(s.substring(1), p.substring(1));
        }

    }


    public boolean isMatchByDp(String s,String p){
        int m=s.length();
        int n=p.length();
        boolean [][]dps=new boolean[m+1][n+1];
        /**
        dps[i,j]代表i代表s的长度,j代表p的长度,dps[i,j]代表匹配结果
        **/
        dps[0][0]=true;//代表空串是否匹配
        for(int i=2;i<=n;i++) {
            if (p.charAt(i - 1) == '*') dps[0][i] = dps[0][i - 2];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
              char sc=s.charAt(i-1);
              char pc=p.charAt(j-1);
              if(sc==pc||pc=='.'){
                dps[i][j]=dps[i-1][j-1];
              }else if(pc=='*'){
                   if(dps[i][j-2]){
                      dps[i][j]=true;
                   }else if(sc==p.charAt(j-2)||p.charAt(j-2)=='.'){
                      dps[i][j]=dps[i-1][j];
                   }
              }
            }
        }
        return dps[m][n];
    }
    public static void main(String[] args) {
    }
}
