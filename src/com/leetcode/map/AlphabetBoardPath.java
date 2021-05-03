package com.leetcode.map;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target){

        StringBuilder sb = new StringBuilder();
        int curRow=0;
        int curCol=0;
        for(int i=0;i<target.length();i++){

            char tc = target.charAt(i);
            int row=(tc-'a')/5;
            int col=(tc-'a')%5;
            if(row==5&&col<curCol){

                for(int j=curRow;j<4;j++){
                    sb.append('D');
                }

                for(int j=curCol;j>col;j--){
                    sb.append('L');
                }
                sb.append('D');

            }else{
                if(curRow>row){

                    for(int j=curRow;j>row;j--){
                        sb.append('U');
                    }

                }else if(curRow<row){
                    for(int j=curRow;j<row;j++){
                        sb.append('D');
                    }
                }
                if(curCol>col){

                    for(int j=curCol;j>col;j--){
                        sb.append('L');
                    }

                }else if(curCol<col){

                    for(int j=curCol;j<col;j++){
                        sb.append('R');
                    }

                }
            }
            curRow=row;
            curCol=col;
            sb.append('!');
        }


        return sb.toString();

    }


    public static void main(String[] args) {

        AlphabetBoardPath alphabet = new AlphabetBoardPath();
        //"DDDDD!UUUUURRR!DDDDLLLD!"
        System.out.println(alphabet.alphabetBoardPath("zdz"));
        /***
         * "abcde",
         * "fghij",
         * "klmno",
         * "pqrst",
         * "uvwxy",
         * "z"
         */

    }
}
