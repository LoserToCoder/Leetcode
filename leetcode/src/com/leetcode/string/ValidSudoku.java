package com.leetcode.string;

public class ValidSudoku {

    /*
    判断一个x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字1-9在每一行只能出现一次。
    数字1-9在每一列只能出现一次。
    数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
    数独部分空格内已填入了数字，空白格用'.'表示。
    链接：https://leetcode-cn.com/problems/valid-sudoku
    */
    public boolean isValidSudoku(char[][] board) {

        int [][]rows = new int[9][10];//代表行
        int [][]cols = new int[9][10];//代表列
        int [][]boxes = new int[9][10];//代表3*3的格子
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                char ch = board[r][c];
                if(ch=='.'){
                    continue;
                }
                int n = ch -'0';
                rows[r][n] +=1;
                cols[c][n] +=1;
                int box= (r/3)*3+c/3;
                boxes[box][n]+=1;
                if(rows[r][n]>1||cols[c][n]>1||boxes[box][n]>1){
                    return false;
                }
            }
        }
        return true;
    }
}
