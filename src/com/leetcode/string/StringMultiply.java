package com.leetcode.string;

public class StringMultiply {

    /**
     * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
     *
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *
     * 
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 
     *
     * 提示：
     *
     * 1 <= num1.length, num2.length <= 200
     * num1和 num2只能由数字组成。
     * num1和 num2都不包含任何前导零，除了数字0本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/multiply-strings
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(),n = num2.length();
        //res 存储的是进位的乘积结果 。该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + x * y;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
