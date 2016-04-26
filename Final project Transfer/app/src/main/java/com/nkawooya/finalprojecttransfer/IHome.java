package com.nkawooya.finalprojecttransfer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by nkawooya on 4/22/2016.
 */
public class IHome extends AppCompatActivity implements View.OnClickListener {
    private ImageView dest;
    private Button bt1,bt2,bt3,bt4,bt5,bt6;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_home);
        bt1 =(Button)findViewById(R.id.btlocation);
        bt2 =(Button)findViewById(R.id.bttoursites);
        bt3 =(Button)findViewById(R.id.btreservation);
        bt4 =(Button)findViewById(R.id.btexperience);
        bt5 =(Button)findViewById(R.id.bthelp);
        bt6 =(Button)findViewById(R.id.btabout);

        dest =(ImageView)findViewById(R.id.location);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);




        //Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.kasubi);
        //dest.setImageBitmap(icon);
       dest.setOnTouchListener(new Touch());
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.tourist);
        ab.setDisplayUseLogoEnabled(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }else if(id == R.id.action_refresh){
           Intent a = new Intent(IHome.this,IHome.class);
            startActivity(a);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        Intent a;
        switch (v.getId()){
            case R.id.btlocation:
                a = new Intent(IHome.this,ILocation.class);
                startActivity(a);
                break;
            case R.id.bttoursites:
                a = new Intent(IHome.this,ITourist.class);
                startActivity(a);
                break;
            case R.id.btreservation:
                a = new Intent(IHome.this,IReservation.class);
                startActivity(a);
                break;
            case R.id.btexperience:
                a = new Intent(IHome.this,IExperience.class);
                startActivity(a);
                break;
            case R.id.bthelp:
                a = new Intent(IHome.this,IHelp.class);
                startActivity(a);
                break;
            case R.id.btabout:
                a = new Intent(IHome.this,IAbout.class);
                startActivity(a);
                break;

        }
    }
}
