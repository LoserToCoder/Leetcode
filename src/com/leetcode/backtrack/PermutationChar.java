package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationChar {

    /**
     *无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，
     * 字符串每个字符均不相同。
     *
     * 示例1:
     *
     *  输入：S = "qwe"
     *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
     * 示例2:
     *
     *  输入：S = "ab"
     *  输出：["ab", "ba"]
     * 提示:
     *
     * 字符都是英文字母。
     * 字符串长度在[1, 9]之间。
     * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
     * @param S
     * @return
     */

    private List<String> permutes=new ArrayList<>();

    public String[] permutation(String S) {

        int len=S.length();
        StringBuilder sb = new StringBuilder(len);
        boolean[]used=new boolean[len];
        dfs(S,sb,used);
        String[] ans = new String[permutes.size()];
        return permutes.toArray(ans);
    }


    private void dfs(String s,StringBuilder sb,boolean[]used){
  
        if(sb.length()==s.length()){
            permutes.add(sb.toString());
            return;
        }

        for(int i=0;i<s.length();i++){

            if(used[i]) continue;
            sb.append(s.charAt(i));
            used[i]=true;
            dfs(s,sb,used);
            used[i]=false;
            sb.deleteCharAt(sb.length() - 1);

        }

    }

    public static void main(String[] args) {

      /*  String s = "algorithm";

        PermutationChar permutationChar = new PermutationChar();
        System.out.println(permutationChar.permutation(s));*/

        PermutationChar permutationChar = new PermutationChar();

        String permutation = permutationChar.getPermutation(8, 8590);
        System.out.println(permutation);

    }


    private List<String> ans = new ArrayList<>();
    public String getPermutation(int n, int k) {

        dfs(n,new StringBuilder(),new boolean[n]);

        return ans.get(k-1);

    }
    private void dfs(int n,StringBuilder sb, boolean[]used){

        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }

        for(int i=0;i<n;i++){
            if(used[i]){
                continue;
            }
            sb.append(i+1);
            used[i]= true;
            dfs(n,sb,used);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }



}
