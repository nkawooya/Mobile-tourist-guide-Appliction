package com.nkawooya.finalprojecttransfer.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nkawooya.finalprojecttransfer.R;

/**
 * Created by nkawooya on 4/25/2016.
 */
public class Register extends AppCompatActivity {

    Button cont;
    EditText etname,etusername,etemail,etcountry,etpassword,etconfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_registert);
        Initialize();

     cont.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });









        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reservation, menu);
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

    public void Initialize(){
        cont = (Button)findViewById(R.id.cont);
        etname= (EditText)findViewById(R.id.Rname);
        etusername= (EditText)findViewById(R.id.Rusername);
        etemail=(EditText)findViewById(R.id.Remail);
        etcountry=(EditText)findViewById(R.id.Rcountry);
        etpassword=(EditText)findViewById(R.id.Rpassword);
        etconfirm=(EditText)findViewById(R.id.Rcpassword);

    }
}