package com.nkawooya.finalprojecttransfer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by nkawooya on 4/22/2016.
 */
public class IHome extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    //bundle declaration
    private ImageView dest;
    private Button bt1,bt2,bt3,bt4,bt5,bt6;
    //navdrawer declarations
    DrawerLayout dr;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView Nav_list;
    ArrayList<String> Nav_array;


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

        dr=(DrawerLayout)findViewById(R.id.drawerlayout);
        Nav_list = (ListView)findViewById(R.id.List_view);



        //Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.kasubi);
        //dest.setImageBitmap(icon);
      // dest.setOnTouchListener(new Touch());
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setSubtitle("The one way tour ");


        Nav_array = new ArrayList<String>();
        Nav_array.add("Home");
        Nav_array.add("Locate Site");
        Nav_array.add("Make Reservation");
        Nav_array.add("View your Experience");
        Nav_array.add("Object Tracking");
        Nav_array.add("About MTG");
        Nav_list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,Nav_array);
        Nav_list.setAdapter(adapter);
        Nav_list.setOnItemClickListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,dr,R.string.opendrawer,R.string.closedrawer);
        dr.setDrawerListener(actionBarDrawerToggle);
        loadselection(0);
    }


    private void loadselection(int i) {

        Nav_list.setItemChecked(i,true);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
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
            // finnish the current and start a new activity
            finish();

           Intent a = new Intent(IHome.this,IHome.class);
            startActivity(a);
        }else if (id == android.R.id.home){
            if(dr.isDrawerOpen(Nav_list)){
                dr.closeDrawer(Nav_list);
            }else{
                dr.openDrawer(Nav_list);
            }
        }else if(id == R.id.action_mode_close_button){
            finish();
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent a;
        switch(i){
            case 0:
                finish();
                a = new Intent(IHome.this,IHome.class);
                startActivity(a);
                break;
            case 1:
                a = new Intent(IHome.this,ILocation.class);
                startActivity(a);
                break;
            case 2:
                a = new Intent(IHome.this,IReservation.class);
                startActivity(a);
                break;
            case 3:
                a = new Intent(IHome.this,IExperience.class);
                startActivity(a);
                break;
            case 4:
               Toast.makeText(getBaseContext(),"Soon in the next update",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                a = new Intent(IHome.this,IMobileTouristGuide.class);
                startActivity(a);
                break;

        }
        dr.closeDrawer(Nav_list);
    }
}
