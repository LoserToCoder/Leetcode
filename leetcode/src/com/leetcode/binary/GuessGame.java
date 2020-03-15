package com.leetcode.binary;

public class GuessGame {

    private int guessNumer;
    public GuessGame(int val){
        this.guessNumer=val;
    }
    public int guess(int num){
        return guessNumer==num?0:(guessNumer<num)?-1:1;
    }
    public GuessGame(){

    }
}
