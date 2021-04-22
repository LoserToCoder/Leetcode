package com.leetcode.design;

/***
 * 实现一个 Trie (前缀树)，包含insert,search, 和startsWith这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母a-z构成的。
 * 保证所有输入均为非空字符串。
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class Trie {


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

    public Trie() {
      root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode node=root;
        char ch;
        for(int i=0;i<word.length();i++){
            ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEndpoint();

    }

    public TrieNode getNext(char ch){
        return root.get(ch);
    }
    public TrieNode searchPrefix(String word){
        TrieNode node=root;

        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null&&node.isEndpoint();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

    public static void main(String[] args) {
        System.out.println();
        Trie trie=new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));//false
        System.out.println(trie.search("app"));//true
        System.out.println(trie.search("ad"));//false
        System.out.println(trie.search("applepie"));//false
        System.out.println(trie.search("rest"));//false
        System.out.println(trie.search("jan"));//false
        System.out.println(trie.search("rent"));//false
        System.out.println(trie.search("beer"));//true
        System.out.println(trie.search("jam"));//true
       
        System.out.println(trie.startsWith("apps"));//false
        System.out.println(trie.startsWith("app"));//true
        System.out.println(trie.startsWith("ad"));//true
        System.out.println(trie.startsWith("applepie"));//
        System.out.println(trie.startsWith("rest"));//false
        System.out.println(trie.startsWith("jan"));//false
        System.out.println(trie.startsWith("rent"));//true
        System.out.println(trie.startsWith("beer"));//false
        System.out.println(trie.startsWith("jam"));//false


    }
}
