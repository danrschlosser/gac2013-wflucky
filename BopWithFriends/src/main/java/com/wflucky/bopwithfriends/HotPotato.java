package com.wflucky.bopwithfriends;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Anna on 6/11/13.
 */

public class HotPotato extends Game {

    ArrayList<String> players ; // never used except by the host - needed as a super placeholder

    public HotPotato(int type, ArrayList<String> players) {
        super(type, players, false);
        this.players = players;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Timer timer = new Timer(30000, 1000, this, false);
        timer.start();
        //set up listener for host to trigger performAction
    }

    public boolean performAction(){
        //choose random movement
        //wait for user to perform action while timer is running
        //let host know action is done. False says that timer ran out on you.
        return false;
    }

    public void setGameOver(){
        super.setGameOver();
    }


}
