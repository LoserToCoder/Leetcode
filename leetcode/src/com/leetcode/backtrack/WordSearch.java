package com.leetcode.backtrack;

public class WordSearch {


    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     * 链接：https://leetcode-cn.com/problems/word-search
     *
     * @param board
     * @param word
     * @return
     */

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, String word, int pos) {

        if (pos == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] != word.charAt(pos))
            return false;

        /**
         * tmp记录当前访问的坐标的状态
         * 并改变board[row][col]的状态表示已经访问过了
         */
        char tmp = board[row][col];
        board[row][col] = ' ';
        /**
         * dx = [-1, 1, 0, 0]
         * dy = [0, 0, -1, 1]
         * Point(dx[i],dy[i])
         * Point(-1,0) 上
         * Point(1,0)  下
         * Point(0,-1) 左
         * Point(0,1)  右
         */
        if (dfs(board, row - 1, col, word, pos + 1) ||
                dfs(board, row, col + 1, word, pos + 1) ||
                dfs(board, row + 1, col, word, pos + 1) ||
                dfs(board, row, col - 1, word, pos + 1)) {
            return true;
        }
        board[row][col] = tmp;
        return false;
    }


    public static void main(String[] args) {


    }
}
