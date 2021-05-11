package com.leetcode.bits;

import java.util.ArrayList;
import java.util.List;

public class DecodeXoredPermutation {

    /**
     * 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
     *
     * 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。
     * 比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
     *
     * 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：encoded = [3,1]
     * 输出：[1,2,3]
     * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
     * 示例 2：
     *
     * 输入：encoded = [6,5,4,6]
     * 输出：[2,4,1,5,3]
     *
     * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
     *
     * 求xor_total [1^2^3...n]
     * 由于
     *  encoded[0] =perm[0]^perm[1];
     *  encoded[1] =perm[1]^perm[2];
     *  encoded[2] =perm[2]^perm[3];
     *  取奇数encoded[1]、encoded[3]、encoded[5]
     *        即(perm[1]^perm[2]^perm[3]^perm[4]...) 可以求出perm[0]
     *        接下来就很好做了
     * @param encoded
     * @return
     */
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int xor_total = 0;
        for (int i = 1; i <= n; i++) {
            xor_total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = xor_total ^ odd;
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;

    }

    /**
     * @param s
     * @return
     */

    List<String> ret = new ArrayList<>();
    public String[] permutation(String s) {
        int len = s.length();
        boolean[] used = new boolean[len];
        StringBuilder sb = new StringBuilder();
        backtrack(s,sb,used);
        int n =ret.size();
        String[] results = new String[n];
        ret.toArray(results);
        return results;
    }

    public void backtrack(String s,StringBuilder sb,boolean [] used) {

        if(sb.length()==s.length()){
            ret.add(sb.toString());
            return;
        }

        for(int i=0;i<s.length();i++){

            if(used[i]){
                continue;
            }
            used[i]=true;
            sb.append(s.charAt(i));
            backtrack(s, sb, used);
            used[i]=false;
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {

        new DecodeXoredPermutation().permutation("suvyls");

    }


}
