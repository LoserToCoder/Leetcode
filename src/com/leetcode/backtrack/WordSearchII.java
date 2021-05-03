package com.leetcode.backtrack;


import java.util.*;

class TrieNode {
    //可以不用val来记录这个值,使用匹配的时候可以使用StringBuilder来记录匹配成功的字符
    private String val;
    private TrieNode[] childrens;
    private final static int n = 26;
    private boolean endpoint;

    public boolean isEndpoint() {
        return endpoint;
    }

    public TrieNode() {
        childrens = new TrieNode[n];
    }

    public boolean containsKey(char ch) {
        return childrens[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return childrens[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        childrens[ch - 'a'] = node;
    }

    public void setEndpoint() {
        this.endpoint = true;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
class Trie {




    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode node = root;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEndpoint();
        node.setVal(word);

    }

    public TrieNode getRoot() {
        return root;
    }
}
public class WordSearchII {



    /***

     给定一个二维网格board和一个字典中的单词列表 words，
     找出所有同时在二维网格和字典中出现的单词。
     单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     同一个单元格内的字母在一个单词中不允许被重复使用。
     示例:
     输入:
     words = ["oath","pea","eat","rain"] and board =
     [
     ['o','a','a','n'],
     ['e','t','a','e'],
     ['i','h','k','r'],
     ['i','f','l','v']
     ]
     输出:["eat","oath"]
     说明:
     你可以假设所有输入都由小写字母 a-z组成。
     链接：https://leetcode-cn.com/problems/word-search-ii
     提示:
     你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
     如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的
     数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？
     如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
     */
    private List<String> uniqueWord = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        Set<String> map = new HashSet<>();

        int m=board.length,n=board[0].length;
        boolean[][]visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,trie.getRoot(),map,visited);
            }
        }
        uniqueWord.addAll(map);
        return uniqueWord;
    }

    private void dfs(char[][]board, int i, int j,TrieNode node,Set<String> map,boolean[][]visited){
        if(node!=null&&node.isEndpoint()) {
            if(!map.contains(node.getVal())){
                map.add(node.getVal());
            }
            //return;即使查找到单词之后也不要回溯,因为可能会出现单词重叠的问题
            //app,apple,找到app之后,可能还会有apple这个单词
        }
        if(i<0||j<0||i>=board.length||
           j>=board[0].length||visited[i][j]||
           node==null||!node.containsKey(board[i][j])) return;

        node=node.get(board[i][j]);
        if(node==null) return;//没有节点了就直接回溯
        visited[i][j]=true;
        dfs(board,i,j-1,node,map,visited);
        dfs(board,i,j+1,node,map,visited);
        dfs(board,i-1,j,node,map,visited);
        dfs(board,i+1,j,node,map,visited);
        visited[i][j]=false;
    }


    public static void main(String[] args) {
          //char [][]board ={ {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
          char[][]board={{'a','b'},
                         {'a','a'}};
          String[]words={"aba","baa","bab","aaab","aaa","aaaa","aaba"};
          WordSearchII searchII = new WordSearchII();
          List<String> iiWords = searchII.findWords(board, words);
          for(String word:iiWords){
            System.out.println(word);
          }
    }
}
