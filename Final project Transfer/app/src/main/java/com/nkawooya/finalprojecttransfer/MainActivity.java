package com.nkawooya.finalprojecttransfer;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    ImageView image = (ImageView)findViewById(R.id.Tourist);
                    //TextView tv = (TextView)findViewById(R.id.appname);

                    Animation animation1 =
                            AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                    image.startAnimation(animation1);
                    /*/Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanim);
                    //tv.startAnimation(animation);
                   // Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                   // tv.startAnimation(animation2);*/

                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(getBaseContext(), IHome.class);
                    startActivity(i);
                    finish();

                }

            }
        };
        th.start();

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.hide();
    }



}
