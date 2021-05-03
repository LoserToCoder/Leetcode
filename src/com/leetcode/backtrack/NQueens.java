package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    private List<List<String>> queens;

    private List<String> seg;

    public List<List<String>> solveNQueens(int n) {
    	queens=new ArrayList<>(n);
        seg = new ArrayList<>(n);
        char[][] boards = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(boards[i],'.');
        }
        backtrack(0,boards);
        return queens;
    }

    private void backtrack(int r,char[][] boards) {
      
      if(r>=boards.length){
          for(int i=0;i<boards.length;i++){
              seg.add(new String(boards[i]));
          }
          queens.add(new ArrayList<>(seg));
          seg.clear();
          return;
      }

      for(int c=0;c<boards.length;c++){

          if(!isValid(boards,r,c)) continue;

          boards[r][c]='Q';

          backtrack(r+1,boards);

          boards[r][c] = '.';


      }
        
    }

    private boolean isValid(char[][]boards,int r,int c){

        int n=boards.length;

        for(int i=0;i<n;i++){

            if(boards[i][c]=='Q') return false;

        }

        for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++){

            if(boards[i][j]=='Q') return false;

        }

        for (int i = r - 1, j = c -1; i >= 0 && j >= 0; i--, j--) {
            if(boards[i][j]=='Q') return false;
        }

        return true;

    }

    public static void main(String[] args) {

        NQueens queens = new NQueens();
        List<List<String>> nQueens = queens.solveNQueens(8);
        for(List<String> item:nQueens){

            System.out.println(item);
        }
    }
}
