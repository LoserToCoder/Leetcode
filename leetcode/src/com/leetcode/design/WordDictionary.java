package com.leetcode.design;

public class WordDictionary {
    /**
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addWord(word)
     * bool search(word)
     * search(word)可以搜索文字或正则表达式字符串，字符串只包含字母.或a-z。
     * . 可以表示任何一个字母。
     * 示例:
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * 说明:
     * 你可以假设所有单词都是由小写字母 a-z组成的。
     * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
     */

    class TrieNode{

        private TrieNode []childrens;
        private final static int n=26;
        private boolean endpoint;

        public boolean isEndpoint(){
            return endpoint;
        }
        public TrieNode(){
            childrens = new TrieNode[n];
        }
        public boolean containsKey(char ch){
            return childrens[ch-'a']!=null;
        }
        public TrieNode get(char ch){
            return childrens[ch-'a'];
        }

        public void put(char ch,TrieNode node){
            childrens[ch-'a']=node;
        }

        public void setEndpoint() {
            this.endpoint = true;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEndpoint();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }

    public boolean match(String word,int i,TrieNode node){
        if(node==null) return false;
        if(i>=word.length()) return node.isEndpoint();
        char ch = word.charAt(i);
        if(ch=='.'){
            for(char k='a';k<='z';k+=1){
                if(match(word,i+1,node.get(k))) return true;
            }
            return false;
        }else if(!node.containsKey(ch)){
            return false;
        }else{
            node = node.get(ch);
        }
        return match(word,i+1,node);
    }

    public static void main(String[] args) {

        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search(".at"));
        dictionary.addWord("bat");
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("an."));
        System.out.println(dictionary.search("a.d."));
        System.out.println(dictionary.search("b."));
        System.out.println(dictionary.search("a.d"));
        System.out.println(dictionary.search("."));
    }

}
