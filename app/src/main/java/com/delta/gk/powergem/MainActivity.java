package com.delta.gk.powergem;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;

import org.w3c.dom.Text;

import java.util.Random;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity {
    String msg = "";
    Boolean[] stoneRet = new Boolean[6];
    String[] stoneStat = {"stone_0", "stone_1", "stone_2", "stone_3", "stone_4", "stone_5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("stoneStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        msg = sp.getString("stoneStatus", "");
        if (!(msg == "")) {
            TextView stone = (TextView) findViewById(R.id.stone);
            stone.setText("");
            TextView head = (TextView) findViewById(R.id.head);
            head.setVisibility(View.VISIBLE);
            TextView list = (TextView) findViewById(R.id.List);
            list.setText(msg);
        }
        for (int i = 0; i < 6; i++) {
            stoneRet[i] = sp.getBoolean(stoneStat[i], false);
        }
        check();
        editor.commit();
    }

    String stoneName[] = {"Power", "Space", "Time", "Reality", "Soul", "Mind"};


    public void button(View view) {

        Random rand = new Random();
        int stoneNum = rand.nextInt(6) + 0;
        TextView stone = (TextView) findViewById(R.id.stone);

        stone.setText("You got " + stoneName[stoneNum] + " STONE");

        stoneColour(stoneNum, stone);
        stoneRet[stoneNum] = true;
        SharedPreferences sp = getSharedPreferences("stoneStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(stoneStat[stoneNum], stoneRet[stoneNum]);
        check();
        editor.putString("stoneStatus", msg);
        TextView head = (TextView) findViewById(R.id.head);
        head.setVisibility(View.VISIBLE);
        TextView list = (TextView) findViewById(R.id.List);
        list.setText(msg);


        editor.commit();
    }

    public void check() {
        if (stoneRet[0] && stoneRet[1] && stoneRet[2] && stoneRet[3] && stoneRet[4] && stoneRet[5]) {
            TextView finalMsg = (TextView) findViewById(R.id.finalMsg);
            finalMsg.setVisibility(View.VISIBLE);
            Button button = (Button) findViewById(R.id.button);
            button.setVisibility(View.INVISIBLE);
        }
    }

    private void stoneColour(int stoneNum, TextView stoneMsg) {
        switch (stoneNum) {
            case 0: {
                stoneMsg.setBackgroundColor(Color.rgb(128, 0, 128));
                stoneMsg.setTextColor(Color.WHITE);
                if (!(stoneRet[0])) {
                    msg = stoneName[0] + " Stone" + "\n" + msg;
                }
                stoneRet[0] = true;
                break;
            }
            case 1: {
                stoneMsg.setBackgroundColor(Color.BLUE);
                stoneMsg.setTextColor(Color.WHITE);
                if (!(stoneRet[1])) {
                    msg = stoneName[1] + " Stone" + "\n" + msg;
                }
                stoneRet[1] = true;
                break;
            }
            case 2: {
                stoneMsg.setBackgroundColor(Color.GREEN);
                stoneMsg.setTextColor(Color.BLACK);
                if (!(stoneRet[2])) {
                    msg = stoneName[2] + " Stone" + "\n" + msg;
                }
                stoneRet[2] = true;
                break;
            }
            case 3: {
                stoneMsg.setBackgroundColor(Color.RED);
                stoneMsg.setTextColor(Color.WHITE);
                if (!(stoneRet[3])) {
                    msg = stoneName[3] + " Stone" + "\n" + msg;
                }
                stoneRet[3] = true;
                break;
            }
            case 4: {
                stoneMsg.setBackgroundColor(Color.rgb(255, 165, 0));
                stoneMsg.setTextColor(Color.BLACK);
                if (!(stoneRet[4])) {
                    msg = stoneName[4] + " Stone" + "\n" + msg;
                }
                stoneRet[4] = true;
                break;
            }
            case 5: {
                stoneMsg.setBackgroundColor(Color.rgb(255, 255, 0));
                stoneMsg.setTextColor(Color.BLACK);
                if (!(stoneRet[5])) {
                    msg = stoneName[5] + " Stone" + "\n" + msg;
                }
                stoneRet[5] = true;
                break;
            }
        }
    }


    public void reset(View v) {
        TextView stone = (TextView) findViewById(R.id.stone);
        stone.setText("You have NO gems");
        stone.setTextColor(Color.BLACK);
        SharedPreferences sp = getSharedPreferences("stoneStatus", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        stone.setBackgroundColor(Color.TRANSPARENT);
        for (int j = 0; j < 6; j++) {
            stoneRet[j] = false;
            editor.putBoolean(stoneStat[j], false);
        }
        msg = "";
        Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        TextView finalMsg = (TextView) findViewById(R.id.finalMsg);
        finalMsg.setVisibility(View.INVISIBLE);
        TextView head = (TextView) findViewById(R.id.head);
        head.setVisibility(View.INVISIBLE);
        TextView list = (TextView) findViewById(R.id.List);
        list.setText(msg);
        editor.clear();
        editor.commit();

    }

}