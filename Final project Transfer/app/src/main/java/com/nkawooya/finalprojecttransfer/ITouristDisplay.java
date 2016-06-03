package com.nkawooya.finalprojecttransfer;

import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.games.internal.GamesContract;

import java.io.InputStream;
import java.io.Serializable;


public class ITouristDisplay extends AppCompatActivity implements View.OnClickListener {
    TextView title,data;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itourist_display);
        title = (TextView)findViewById(R.id.title);
        data = (TextView)findViewById(R.id.data);
        map = (ImageView)findViewById(R.id.graph);

        Intent a = getIntent();
        String tite = a.getStringExtra("title");
        String tex = a.getStringExtra("text");
       Bundle extras = getIntent().getExtras();
        int x = extras.getInt("image");
        map.setImageResource(x);
        title.setText(tite);
        data.setText(tex);
map.setOnClickListener(this);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_itourist_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.map:
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                        map.startAnimation(animation);
                break;
            case R.id.data:
                break;
            default:break;
        }
    }
}
