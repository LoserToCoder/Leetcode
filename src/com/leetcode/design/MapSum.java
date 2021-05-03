package com.leetcode.design;

class TrieNode{

    private TrieNode [] childrens;

    private boolean isEndpoint;

    private int prefixCount;

    TrieNode(){
        childrens=new TrieNode[26];
    }

    public boolean containsKey(char ch){
        return childrens[ch-'a']!=null;
    }

    public void put(char ch,TrieNode node){
        childrens[ch-'a']=node;
    }

    public TrieNode get(char ch){
        return childrens[ch-'a'];
    }
    public void setPrefixCount(int prefixCount) {
        this.prefixCount = prefixCount;
    }

    public int getPrefixCount() {
        return prefixCount;
    }

    public void setEndpoint(boolean endpoint) {
        isEndpoint = endpoint;
    }

    public boolean isEndpoint() {
        return isEndpoint;
    }
}




public class MapSum {
    class Trie{

        private TrieNode root;

        public Trie(){
            root=new TrieNode();
        }

        public void insert(String key,int num){
            TrieNode curNode= search(key);
            boolean flag=curNode!=null&&curNode.isEndpoint();
            TrieNode node=root;
            for(int i=0;i<key.length();i++){
                char ch = key.charAt(i);

                if(!node.containsKey(ch)){
                    node.put(ch,new TrieNode());
                }
                node=node.get(ch);
                if(flag){//如果已经存在需要减去之前重复的次数,以key为前缀
                    node.setPrefixCount(node.getPrefixCount()+num-curNode.getPrefixCount());
                }else{
                    node.setPrefixCount(node.getPrefixCount()+num);
                }

            }
            node.setEndpoint(true);
        }

        public boolean containsWord(String word){
            TrieNode node = search(word);
            return node!=null&&node.isEndpoint();
        }


        public TrieNode search(String word){
            TrieNode node=root;

            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node==null||!node.containsKey(ch)) return null;
                node = node.get(ch);
            }
            return node;
        }


        public int sumPrefix(String prefix){
            TrieNode node = search(prefix);
            return node==null?0:node.getPrefixCount();
        }

    }

    private Trie trie;

    public MapSum() {
        trie=new Trie();
    }

    public void insert(String key, int val) {
         trie.insert(key,val);
    }

    public int sum(String prefix) {
      return trie.sumPrefix(prefix);
    }

    public static void main(String[] args) {

        MapSum mapSum=new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("apple",2);
        System.out.println(mapSum.sum("ap"));
    }

}
