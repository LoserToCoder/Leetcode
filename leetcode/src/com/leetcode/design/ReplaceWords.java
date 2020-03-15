package com.leetcode.design;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    class Trie{

        private TrieNode root;


        public Trie(){
            root=new TrieNode();
        }

        public void insert(String word){

            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char wc = word.charAt(i);
                if(!node.isContains(wc)){
                    node.put(wc,new TrieNode());
                }
                node = node.getCurNode(wc);
            }
            node.setVal(word);
            node.setEndpoint(true);

        }

        public String getPrefix(String word){

            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(node.isEndpoint||node.getCurNode(ch)==null){
                    break;
                }
                node = node.getCurNode(ch);
            }
            return  node.isEndpoint ? node.getVal():word;
        }


    }
    class TrieNode{

        TrieNode []children;

        boolean isEndpoint;
        String val;

        TrieNode(){
            children = new TrieNode[26];
        }

        public boolean isContains(char ch){
            return children[ch-'a']!=null;
        }

        public void put(char ch,TrieNode node){
            children[ch-'a']=node;
        }

        public TrieNode getCurNode(char ch){
            return children[ch - 'a'];
        }

        public void setEndpoint(boolean endpoint) {
            isEndpoint = endpoint;
        }

        public boolean isEndpoint() {
            return isEndpoint;
        }

         public void setVal(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie=new Trie();
        for(String word:dict){
            trie.insert(word);
        }
        String []joins=sentence.split("\\s+");
        StringBuilder sb=new StringBuilder();
        sb.append(trie.getPrefix(joins[0]));
        for(int i=1;i<joins.length;i++){
            String prefix = trie.getPrefix(joins[i]);
            sb.append(" ")
              .append(prefix);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dict=Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence ="a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        ReplaceWords words = new ReplaceWords();
        String s = words.replaceWords(dict, sentence);
        System.out.println(s);
    }
}
