package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 交换位置使得棘手的问题很容易得到解决
 */
public class PermutationRepeatChar {


    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, result);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
        }

        for (int i = index; i < chars.length; i++) {
            if (isRepeat(chars, index, i)) continue;
            swap(chars, index, i);
            dfs(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    private boolean isRepeat(char[] chars, int index, int i) {
        for (int j = index; j < i; j++) {
            if (chars[j] == chars[i]) {
                return true;
            }
        }
        return false;
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}
