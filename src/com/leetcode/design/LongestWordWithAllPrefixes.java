package com.leetcode.design;

public class LongestWordWithAllPrefixes {

    public String longestWord(String[] words) {
        Trie root = new Trie();

        for (String w : words) {
            insert(root, w);
        }

        String res = null;

        for (String w : words) {
            if (search(root, w)) {
                if (res == null) {
                    res = w;
                } else {
                    if (w.length() > res.length()) {
                        res = w;
                    } else if (w.length() == res.length() && w.compareTo(res) < 0) {
                        res = w;
                    }
                }
            }
        }
        return res;
    }

    class Trie {
        Trie[] next;
        boolean end;
        Trie() {
            next = new Trie[26];
        }
    }

    void insert(Trie root, String w) {
        Trie t = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (t.next[idx] == null) {
                t.next[idx] = new Trie();
            }
            t = t.next[idx];
        }
        t.end = true;
    }

    boolean search(Trie root, String w) {
        Trie t = root;

        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (t.next[idx] == null) {
                t.next[idx] = new Trie();
            }
            t = t.next[idx];
            if (!t.end) {
                return false;
            }
        }
        return true;
    }


}
