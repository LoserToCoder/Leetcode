package com.leetcode.design;

public class LongestCommonPrefix {
    /**
     *14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     *
     * 提示：
     *
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * @param strs
     * @return
     */

    private Trie root = new Trie();

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        for(int i=0;i<len;i++){
            add(strs[i]);
        }
        return getCommonPrefix(strs[0], len);
    }

    private void add(String s){

        Trie curNode = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            curNode.add(ch);
            curNode = curNode.getTrie(ch);
        }
    }
    private String getCommonPrefix(String s,int len){
        Trie curNode = root;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            Trie trie=curNode.getTrie(ch);
            if(trie==null){
                return s.substring(0, i);
            }
            if(trie.commonPrefix==len){
                curNode =trie;
            }else{
                return s.substring(0, i);
            }
        }
        return s;
    }


    class Trie{

        Trie [] alphabets;
        int commonPrefix;
        public Trie(){
           this.alphabets = new Trie[26];
           this.commonPrefix =0;
        }
        public Trie getTrie(char ch){
            return alphabets[ch - 'a'];
        }
        public void add(char ch){
            Trie trie = alphabets[ch-'a'];
            if(trie==null){
                trie =new Trie();
                alphabets[ch-'a']=trie;
            }
            trie.commonPrefix++;
        }
    }
}
