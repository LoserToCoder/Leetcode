package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCharII {


    private List<String> permutes=new ArrayList<>();

    /**
     * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
     * 示例1:
     *  输入：S = "qqe"
     *  输出：["eqq","qeq","qqe"]
     * 示例2:
     *  输入：S = "ab"
     *  输出：["ab", "ba"]
     * 提示:
     *
     * 字符都是英文字母。
     * 字符串长度在[1, 9]之间。
     *
     * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
     * @param S
     * @return
     */
    public String[] permutation(String S) {

        char[] alphas = S.toCharArray();
        int len=alphas.length;
        StringBuilder sb = new StringBuilder(len);
        Arrays.sort(alphas);
        dfs(alphas,sb,new boolean[len]);
        String[] ans = new String[permutes.size()];
        return permutes.toArray(ans);
    }


    private void dfs(char[]alphas,StringBuilder sb,boolean[]used){
  
        if(sb.length()==alphas.length){
            permutes.add(sb.toString());
        }

        for(int i=0;i<alphas.length;i++){

            if(used[i]) continue;

            if(i>0&&alphas[i]==alphas[i-1]&&!used[i-1]) continue;
            sb.append(alphas[i]);
            used[i]=true;
            dfs(alphas,sb,used);
            used[i]=false;
            sb.deleteCharAt(sb.length() - 1);

        }

    }

    public static void main(String[] args) {

        String s = "qqw";

        PermutationCharII permutationChar = new PermutationCharII();
        System.out.println(permutationChar.permutation(s));

    }



}
