package com.delta.gk.powergem;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Boolean[] stoneRet={false,false,false,false,false,false};
    String stoneName[]={"Power","Space","Time","Reality","Soul","Mind"};

    public String msg="";

    public void button(View v){

        Random rand=new Random();
        int stoneNum=rand.nextInt(6)+0;

        TextView stone=(TextView) findViewById(R.id.stone);

        stone.setText("You got "+ stoneName[stoneNum] +" STONE");
        stoneColour(stoneNum,stone);
        stoneRet[stoneNum]=true;
        check();
        TextView head=(TextView) findViewById(R.id.head);
        head.setVisibility(View.VISIBLE);
        TextView list=(TextView) findViewById(R.id.List);
        list.setText(msg);
    }

    private void stoneColour(int stoneNum, TextView stoneMsg) {
        switch(stoneNum){
            case 0:
            { stoneMsg.setBackgroundColor(Color.rgb(128,0,128));
                stoneMsg.setTextColor(Color.WHITE);
                if(!(stoneRet[0]))
                {
                    msg=stoneName[0]+" Stone"+"\n"+msg;
                }
                stoneRet[0]=true;
                break;}
            case 1:
            { stoneMsg.setBackgroundColor(Color.BLUE);
                stoneMsg.setTextColor(Color.WHITE);
                if(!(stoneRet[1])){ msg=stoneName[1]+" Stone"+"\n"+msg;}
                stoneRet[1]=true;
                break;}
            case 2:
            { stoneMsg.setBackgroundColor(Color.GREEN);
                stoneMsg.setTextColor(Color.BLACK);
                if(!(stoneRet[2])){ msg=stoneName[2]+" Stone"+"\n"+msg;}
                stoneRet[2]=true;
                break;}
            case 3:{
                stoneMsg.setBackgroundColor(Color.RED);
                stoneMsg.setTextColor(Color.WHITE);
                if(!(stoneRet[3])){ msg=stoneName[3]+" Stone"+"\n"+msg;}
                stoneRet[3]=true;
                break;}
            case 4:{
                stoneMsg.setBackgroundColor(Color.rgb(255,165,0));
                stoneMsg.setTextColor(Color.BLACK);
                if(!(stoneRet[4])){ msg=stoneName[4]+" Stone"+"\n"+msg;}
                stoneRet[4]=true;
                break;}
            case 5:{
                stoneMsg.setBackgroundColor(Color.rgb(255,255,0));
                stoneMsg.setTextColor(Color.BLACK);
                if(!(stoneRet[5])){ msg=stoneName[5]+" Stone"+"\n"+msg;}
                stoneRet[5]=true;
                break;}
        }
    }


    public void check(){
        if(stoneRet[0]&&stoneRet[1]&&stoneRet[2]&&stoneRet[3]&&stoneRet[4]&&stoneRet[5])
        {
            TextView finalMsg=(TextView) findViewById(R.id.finalMsg);
            finalMsg.setVisibility(View.VISIBLE);
        }
    }
    public void reset(View v){
        TextView stone=(TextView) findViewById(R.id.stone);
        stone.setText("You have NO gems");
        stone.setTextColor(Color.BLACK);
        stone.setBackgroundColor(Color.TRANSPARENT);
        for(int j=0;j<6;j++)
            stoneRet[j]=false;
        msg="";
        TextView finalMsg=(TextView) findViewById(R.id.finalMsg);
        finalMsg.setVisibility(View.INVISIBLE);
        TextView head=(TextView) findViewById(R.id.head);
        head.setVisibility(View.INVISIBLE);
        TextView list=(TextView) findViewById(R.id.List);
        list.setText(msg);
    }
}
