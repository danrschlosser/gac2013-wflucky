package com.wflucky.bopwithfriends;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**a
 * Created by Anna on 6/11/13.
 */
public class DeathHost extends Game {


    ArrayList<String> players;
    HashMap<Integer, String> scoreBoard;

    public DeathHost(int type, ArrayList<String> players){
        super(type, players,  true);
        this.players = players;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game); //this will probably need to be a separate layout
        startMove(new Random(players.size()));
    }

    public void startMove(Random rand){
        // choose random player and trigger them to preform action.
        // wait for response, true or false, whether they completed the task
        if (players.size() > 1){
            startMove(new Random(players.size()));
        }
        else{
            // gameOver(HashMap<Integer, String> playerRanks);
        }
    }


    public boolean performAction(){
        //chose random movement
        Timer timer = new Timer(15000, 1000, this, true);
        timer.start();
        // if action is completed before timer ends return true, else (signified by super.gameOver) return false.
        return false;
    }

    public void setGameOver(){
        super.setGameOver();
    }

}
