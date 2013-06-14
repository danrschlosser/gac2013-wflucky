package com.wflucky.bopwithfriends;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private boolean needsWatch;
    private int potatoTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void joinGame(View view) {
        setContentView(R.layout.activity_lobby);
        Button button=(Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        NumberPicker picker = (NumberPicker)findViewById(R.id.numberPicker);
        picker.setVisibility(View.INVISIBLE);
    }

    public void hostGame(View view) {
        final String hostName = getName();
        final Intent intent = new Intent(this, Lobby.class);
        final CharSequence[] items = {"Hot Potato", "Sudden Death"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a game mode");
        builder
                .setNegativeButton("Hot Potato", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        setContentView(R.layout.activity_lobby);
                        TextView textView = (TextView)findViewById(R.id.textView);
                        textView.setText(hostName + "'s Hot Potato Game");
                        needsWatch = true;
                    }
                })
                .setPositiveButton("Sudden Death", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        setContentView(R.layout.activity_lobby);
                        TextView textView = (TextView)findViewById(R.id.textView);
                        textView.setText(hostName + "'s Sudden Death Game");
                        NumberPicker picker = (NumberPicker)findViewById(R.id.numberPicker);
                        picker.setVisibility(View.INVISIBLE);
                        needsWatch = false;
                    }
                })
                .create().show();
    }

    public void play(View view) {
        NumberPicker picker = (NumberPicker)findViewById(R.id.numberPicker);
        potatoTime = picker.getValue();

        Intent intent = new Intent(this, GestureAction.class);
        intent.putExtra("PotatoTime", potatoTime);
        intent.putExtra("TimerGame", needsWatch);
        startActivity(intent);
    }

    private String getName() {
        String name = "Host";

        try {
            Cursor c = this.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
            int count = c.getCount();
            String[] columnNames = c.getColumnNames();
            boolean b = c.moveToFirst();
            int position = c.getPosition();
            if (count == 1 && position == 0) {
                for (int j = 0; j < columnNames.length; j++) {
                    String columnName = columnNames[j];
                    String columnValue = c.getString(c.getColumnIndex(columnName));

                    if (columnName != null && columnName.equals("display_name")) {
                        name = columnValue != null ? columnValue : "Host";
                        break;
                    }
                }
            }

            c.close();

            name = name.split(" ")[0];
        } catch (Exception e) {}

        return name;
    }
}