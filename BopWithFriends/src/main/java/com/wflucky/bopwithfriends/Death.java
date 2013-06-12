package com.wflucky.bopwithfriends;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anna on 6/11/13.
 */
public class Death extends Game {


    ArrayList<String> players; /// never used except by the host - needed as a super placeholder
    HashMap<Integer, String> scoreBoard;

    public Death(int type, ArrayList<String> players){
        super(type, players, false);
        this.players = players;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //set up listener to be called on by host
        //call perform action when host demands
        //send back up to host true or false, depending on whether you are still alive
    }

    public boolean performAction(){
        //choose random movement
        Timer timer = new Timer(15000, 1000, this, true);
        timer.start();
        //wait for user to perform action while timer is running
        //let host know action is done. False says that timer ran out on you.
        return false;
    }

    public void setGameOver(){
        super.setGameOver();
    }



}
