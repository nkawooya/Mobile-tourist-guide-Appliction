package com.nkawooya.finalprojecttransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.nkawooya.finalprojecttransfer.Login.Register;

/**
 * Created by nkawooya on 4/25/2016.
 */
public class IExperience extends AppCompatActivity implements View.OnClickListener {
    Button create,login,btlogin,btcreate,reset;
    EditText etemail,etpassword,atemail,atpassword;
    TabHost th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_experience);
        Initialize();



        //setting onclick listeners
        create.setOnClickListener(this);
        login.setOnClickListener(this);
        btcreate.setOnClickListener(this);
        btlogin.setOnClickListener(this);


       //setting up the tab host
        th.setup();

       TabHost.TabSpec         specs = th.newTabSpec("client");
        specs.setContent(R.id.tab1);
        specs.setIndicator("Tourist");
        th.addTab(specs);


        specs = th.newTabSpec("Admin");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Administrator");
        th.addTab(specs);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
    }


    //method to initialize the widgets
    private void Initialize() {
        create = (Button)findViewById(R.id.Lcreate);
        login = (Button)findViewById(R.id.login);
        th = (TabHost)findViewById(R.id.tabHost);
        etemail = (EditText)findViewById(R.id.Lemail);
        etpassword = (EditText)findViewById(R.id.Lpassword);
        atemail = (EditText)findViewById(R.id.Aemail);
        atpassword =(EditText)findViewById(R.id.Apassword);
        btlogin = (Button) findViewById(R.id.btlogin);
        btcreate = (Button)findViewById(R.id.btcreate);
        //,reset

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_experience, menu);
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
            super.onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent a;
        switch (view.getId()){
            case R.id.login:
                break;
            case R.id.btlogin:
                break;
            case R.id.Lcreate:
               a = new Intent(IExperience.this, Register.class);
                startActivity(a);

                break;
            case R.id.btcreate:
                break;


        }


    }
}
