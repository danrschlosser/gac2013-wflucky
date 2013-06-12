package com.wflucky.bopwithfriends;

import android.os.CountDownTimer;

/**
 * Created by demouser on 6/11/13.
 */
public class Timer extends CountDownTimer{

    String currentPlayer;
    Game myGame;

    public Timer( int time, int division, Game game){
        super(time, division);
        this.myGame = game;
    }


    public void onTick(long millisUntilFinished) {
        //going to set up some sort of timer on screen using this
    }

    public void onFinish() {
        myGame.setGameOver();
    }

    public void setCurrentPlayer(String player){
        this.currentPlayer= player;
    }


}
