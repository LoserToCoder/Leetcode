package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {

    class TrieNode{

        private TrieNode []childrens;

        private boolean endpoint;

        private int count=0;

        public boolean isEndpoint(){
            return endpoint;
        }
        public TrieNode(){
            childrens = new TrieNode[26];
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

        public void setCount() {
            this.count++;
        }

        public int getCount() {
            return count;
        }
    }

    private TrieNode trie=new TrieNode();


    public WordsFrequency(String[] book){
       for(String word:book){
           addWord(word);
       }
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=trie;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEndpoint();
        node.setCount();
    }
    /*private Map<String, Integer> wf = new HashMap<>();

    public WordsFrequency(String[] book) {

        for(String word:book){
            wf.put(word, wf.getOrDefault(word, 0) + 1);
        }

    }

    public int get(String word) {
        return wf.getOrDefault(word, 0);
    }*/

    public int search(String word){
        TrieNode node=trie;

        for(int i=0;i<word.length();i++){

            char ch = word.charAt(i);

            if(node==null||!node.containsKey(ch)){
                return 0;
            }
            node = node.get(ch);
        }
        return node.isEndpoint()?node.getCount():0;

    }

    public int get(String word) {
        return search(word);
    }
}
