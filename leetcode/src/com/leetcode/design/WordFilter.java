package com.leetcode.design;


/**
 * 给定多个words，words[i]的权重为i。
 * 设计一个类WordFilter实现函数WordFilter.f(String prefix, String suffix)。
 * 这个函数将返回具有前缀prefix和后缀suffix的词的最大权重。如果没有这样的词，返回 -1。
 * 例子:
 * 输入:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // 返回 0
 * WordFilter.f("b", "") // 返回 -1
 * 注意:words的长度在[1, 15000]之间。
 * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
 * words[i]的长度在[1, 10]之间。
 * prefix, suffix的长度在[0, 10]之前。
 * words[i]和prefix, suffix只包含小写字母。
 * 链接：https://leetcode-cn.com/problems/prefix-and-suffix-search
 */
public class WordFilter {

    class TrieNode {

        private TrieNode[] chilrens;

        int weight;

        TrieNode() {
            chilrens = new TrieNode[27];
            weight = 0;
        }

        public boolean isContains(char ch) {
            return chilrens[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            chilrens[ch - 'a'] = node;
        }

        public TrieNode getCurNode(char ch) {
            return chilrens[ch - 'a'];
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word, int weight) {
            word = word + '{';
            for (int i = 0; i < word.length(); i++) {
                TrieNode node = root;//每次重新组合都要重新改变引用指针
                for(int j=i;j<2*word.length()-1;j++){

                    char ch = word.charAt(j % word.length());
                    if(!node.isContains(ch)){
                        node.put(ch,new TrieNode());
                    }
                    node = node.getCurNode(ch);
                    node.weight=weight;

                } 

            }
        }


        public int search(String prefix, String suffix) {

            TrieNode node = root;
            prefix = suffix + '{' + prefix;
            for (int i = 0; i < prefix.length(); i++) {

                char pc = prefix.charAt(i);
                if (!node.isContains(pc)) {
                    return -1;
                }
                node=node.getCurNode(pc);
            }
            return node.weight;
        }
    }

    private Trie trie = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        return trie.search(prefix, suffix);
    }


    public static void main(String[] args) {

        String[] words = {"apple"};
        WordFilter wf = new WordFilter(words);
        System.out.println(wf.f("a", "e"));
    }
}
