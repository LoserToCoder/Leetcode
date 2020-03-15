package com.leetcode.design;

import java.util.*;

/**
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词
 * 中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 示例 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 注意:
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。
 * 请参阅这里了解更多详情。
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 *
 *
 * 构造思路去解决问题:
 *  将单词构造成符合条件的模型
 *  当去匹配的时候,只需要将单词转化成模型模式:匹配就可以
 */
class MagicDictionary {


    private Map<String,Integer> map;

    private Set<String> dic;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
        dic = new HashSet<>();
    }


    public List<String> generalize(String word) {

        List<String> dic = new ArrayList<>();

        char[] cn = word.toCharArray();

        for(int i=0;i<word.length();i++){

            char letter=cn[i];
            cn[i] = '*';
            dic.add(new String(cn));
            cn[i]=letter;
        }
        return dic;
    }


    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

        for(String word:dict){

            dic.add(word);

            for (String magic : generalize(word)) {

                map.put(magic, map.getOrDefault(magic,0) + 1);
            }

        }

    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {

        for (String magic : generalize(word)) {

            int c = map.getOrDefault(magic, 0);
            if(c>1||c==1&&!dic.contains(word)) return true;
            //c=1时候,要看看是否在dic中也包含word

        }
        return false;
    }


    public static void main(String[] args) {

        MagicDictionary dictionary = new MagicDictionary();
        String[] dict = {"hello","leetcode"};
        dictionary.buildDict(dict);

        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hhllo"));
        System.out.println(dictionary.search("hell"));
        System.out.println(dictionary.search("leetcoded"));

    }
}