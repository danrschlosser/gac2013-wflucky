package com.wflucky.bopwithfriends;

import android.os.CountDownTimer;

/**
 * Created by Anna on 6/11/13.
 */
public class Timer extends CountDownTimer{

    String currentPlayer;
    Game myGame;
    boolean done;

    public Timer( int time, int division, Game game, boolean isDeath){
        super(time, division);
        this.myGame = game;
        if (isDeath){
            done = false;
        }
        else done = true;

    }


    public void onTick(long millisUntilFinished) {
        //going to set up some sort of timer on screen using this
    }

    public void onFinish() {
        if (!done){
            myGame.setGameOver();
        }
    }

    public void setCurrentPlayer(String player){
        this.currentPlayer= player;
    }

    public void setDone(){
        done = true;
    }


}
