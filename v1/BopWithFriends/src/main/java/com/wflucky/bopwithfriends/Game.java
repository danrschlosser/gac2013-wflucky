package com.wflucky.bopwithfriends;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Andrew.
 * Put an X once you've figured out how to do it, and put the method in this class.
 * Gestures:
 * [ ] Tap Once
 * [ ] Tap Twice
 * [ ] Pinch in
 * [ ] Pinch out
 * [ ] Swipe up
 * [ ] Swipe down
 * [ ] Swipe up two fingers
 * [ ] Swipe down two fingers
 * Motions:
 * [ ] Shake
 * [ ] Twist
 * [ ] Pull
 * [ ] Flip
 * [ ] Raise
 * [ ] Level
 */

/**
 * Anna -
 * Code will call another game activity depending on what type of game is being played and whether
 * the user is the host or not
 * Still need:
 * - how the users communicate
 * - connection to the UI
 * - transition to scoreboard
 * - implementation of gestures/motions
 * - method that will take a string/int representing the gesture and call
 *   appropriate method for it (to avoid repetition of code) - will implement once I have some gestures available
 */
public class Game extends Activity {

    private int type;
    private ArrayList<String> players;
    private int current;
    private Game currentGame;
    private boolean isHost;
    protected boolean gameOver;

    /**
     * Type is handed down when game is created. Let's go with 0 for death and 1 for hot potato.
     * Players may be changed form Strings to player objects if needed in the future. First player
     * must be the host (index = 0)
     * @param type
     * @param players
     */
    public Game( int type, ArrayList<String> players, boolean isHost){
        this.type = type;
        this.players = players;
        this.isHost = isHost;
        this.gameOver = false;

        current = 0;
        if (isHost){
            if (type == 0) currentGame = new DeathHost(type, players);
            else currentGame = new HotPotatoHost(type, players);
        }
        else{
            if (type == 0) currentGame = new Death(type, players);
            else currentGame = new HotPotato(type, players);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentGame.onCreate(savedInstanceState);
    }

    /**
     * called by specific game when it has been completed.
     * Hashmap< Rank or Score, player name>
     * calls scoreboard
     * @param playerRanks
     */
    public void gameOver(HashMap<Integer, String> playerRanks){
        Scoreboard scoreboard = new Scoreboard(playerRanks);
    }

    public void setGameOver(){
       gameOver = true;
    }

}