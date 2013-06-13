package com.wflucky.bopwithfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import static com.wflucky.bopwithfriends.Gestures.*;

/**
 * Created by Andrew
 */
public class GestureAction extends Activity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetector detector;
    private static final String TAG = "GestureExample";
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    Gestures target;
    private TextView canvas;
    private TextView score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        detector = new GestureDetector(this, this);
        detector.setOnDoubleTapListener(this);
        canvas = (TextView) findViewById(R.id.canvas);
        score = (TextView) findViewById(R.id.score);
        play();
    }


    public void play(){
        Gestures next = Gestures.getRandom();
        canvas.setText(next.toString());
        target = next;
    }
    public void failed(){
        Intent intent = new Intent(GestureAction.this, FinalScore.class);
        intent.putExtra("FANTASTICSCORE", Integer.parseInt(score.getText().toString()));
        startActivity(intent);
        score.setText("0");
    }

    public boolean onTouchEvent(MotionEvent e){
        this.detector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }
    public boolean onDown(MotionEvent e) {
        return true;
    }
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        if ((e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE) && (Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)) {
            if (target == SWIPE_LEFT) {
                incrementScore();
                play();
            } else {
                failed();
            }
            return true;
        } else if ((e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE) && (Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)) {
            if (target == SWIPE_RIGHT) {
                incrementScore();
                play();
            } else {
                failed();
            }
            return true;
        } else if ((e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE) && (Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)) {
            if (target == SWIPE_UP) {
                incrementScore();
                play();
            } else {
                failed();
            }
            return true;
        }else if ((e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE) && (Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)) {
            if (target == SWIPE_DOWN) {
                incrementScore();
                play();
            } else {
                failed();
            }
            return true;
        } else {
            Log.d(TAG, "FAILED: onFling: " + e1.toString() + e2.toString());
            return false;
        }
    }
    public void onLongPress(MotionEvent e) {
        if (target == LONGPRESS) {
            incrementScore();
            play();
        } else {
            failed();
        }
        Log.d(TAG, "onLongPress: " + e.toString());
    }
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return true;
    }
    public void onShowPress(MotionEvent e) {
        Log.d(TAG, "onShowPress: " + e.toString());
    }
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp: " + e.toString());
        return true;
    }
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap: " + e.toString());
        if (target == DTAP) {
            incrementScore();
            play();
        } else {
            failed();
        }
        return true;
    }
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(TAG, "onDoubleTapEvent: " + e.toString());
        return true;
    }
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TAG, "onSingleTapConfirmed: " + e.toString());
        if (target == TAP | target == DTAP | target == LONGPRESS) {
            play();
            incrementScore();
        } else {
            failed();
        }
        return true;
    }

    public void incrementScore() {
        score.setText("" + (Integer.parseInt(score.getText().toString()) + 1));
        Toast t = Toast.makeText(this, "GLENN SAYS: SUCCESS!", 2);
        t.setGravity(t.getGravity(), t.getXOffset(), t.getYOffset()+100);
        t.show();
    }
}