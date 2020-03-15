package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 请你设计一个迭代器类，包括以下内容：
 * 一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）
 * 和一个数字 combinationLength 。
 * 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
 * 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 True；否则，返回 False。
 * 示例：
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
 * iterator.next(); // 返回 "ab"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "ac"
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 "bc"
 * iterator.hasNext(); // 返回 false
 * 提示：
 * 1 <= combinationLength <= characters.length <= 15
 * 每组测试数据最多包含 10^4 次函数调用。
 * 题目保证每次调用函数 next 时都存在下一个字母组合
 * 链接：https://leetcode-cn.com/problems/iterator-for-combination
 */

public class CombinationIterator {

    private List<String> combination = new ArrayList<>();

    private int cursor=0;

    public CombinationIterator(String characters, int combinationLength) {
        backtrack(characters,0,combinationLength,new StringBuilder());
    }

    private void backtrack(String characters,int pos,int len,StringBuilder sb){

        if(sb.length()==len){
            combination.add(sb.toString());
            return;
        }
        for(int i=pos;i+len-sb.length()<=characters.length();i++){
            sb.append(characters.charAt(i));
            backtrack(characters,i+1,len,sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public String next() {
        return combination.get(cursor++);
    }

    public boolean hasNext() {
        return cursor<combination.size();
    }

    public int size(){
        return combination.size();
    }

    public List<String> getCombination() {
        return combination;
    }

    public static void main(String[] args)throws Exception {

        CombinationIterator iterator = new CombinationIterator("12345",4);
        System.out.println(iterator.getCombination());
    }
}
