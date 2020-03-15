package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {


    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * <p>
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     * 输入: S = "12345"
     * 输出: ["12345"]
     * 注意：
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation
     * 单分支递归
     * @param args
     */

    private List<String> letters = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        backtrack(S,0,new char[S.length()]);
        return letters;
    }

    /**
     * 没有控制顺序的代码(结果测试准确)
     * @param s
     * @param pos
     * @param chs  没有采用以往的StringBuilder,是因为chs比StringBuilder更加的灵活和方便
        更加节省存储空间
     */
    public void backtrack(String s,int pos,char[]chs){
        if(pos==s.length()){
          letters.add(new String(chs));
          return;
        }
        chs[pos]=s.charAt(pos);
        backtrack(s,pos+1,chs);
        if(s.charAt(pos)>'9'){//如果是字母再增加一个分支
            chs[pos]^=1<<5;//字母大小写切换
            backtrack(s,pos+1,chs);
        }

    }

    /**
     * 标准有序的代码
     * @param s
     * @param pos
     * @param sb
     */
    public void dfs(String s,int pos,StringBuilder sb) {
            if(pos==s.length()) {
               letters.add(sb.toString());
               return;
            }
            char sc = s.charAt(pos);
            if('0'<=sc&&sc<='9'){
                sb.append(sc);
                dfs(s, pos + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }else{
                //不用判断大小写,直接按照规则来定义
                sb.append(Character.toLowerCase(sc));
                dfs(s, pos + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                sb.append(Character.toUpperCase(sc));
                dfs(s,pos+1,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
    }

    public static void main(String[] args) {

        LetterCasePermutation casePermutation = new LetterCasePermutation();
        List<String> list = casePermutation.letterCasePermutation("12345");
        for (String item : list) {
            System.out.println(item);
        }

    }
}
