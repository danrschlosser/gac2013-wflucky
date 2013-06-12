package com.wflucky.bopwithfriends;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Anna on 6/11/13.
 */

public class HotPotatoHost extends Game {

    ArrayList<String> players ;

    public HotPotatoHost(int type, ArrayList<String> players) {
        super(type, players, true);
        this.players = players;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //create timer/countdown and pass it to startMove
        Timer timer = new Timer(30000, 1000, this);
        timer.start();
        startMove();
    }

    public void startMove(){
        Random rand = new Random(players.size());
        //pick new player, send them message to call performAction,
        //while !gameOver listen for end of turn
        //if end of turn occurs, manageMove
        //else transition into scoreboard
    }

    public boolean performAction(Timer timer){
        //wait on user to perform necessary action
        //once performed throw back a true;
        return false;
    }

    public void setGameOver(){
        super.setGameOver();
    }
}
