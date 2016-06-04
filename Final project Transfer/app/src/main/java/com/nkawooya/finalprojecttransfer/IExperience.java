package com.nkawooya.finalprojecttransfer;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.nkawooya.finalprojecttransfer.Login.Experience_dashboard;
import com.nkawooya.finalprojecttransfer.Login.Register;
import com.nkawooya.finalprojecttransfer.ServerRequests.GetUserCallbacks;
import com.nkawooya.finalprojecttransfer.ServerRequests.LocalDatabase;
import com.nkawooya.finalprojecttransfer.ServerRequests.ServerRequests;
import com.nkawooya.finalprojecttransfer.ServerRequests.User;

/**
 * Created by nkawooya on 4/25/2016.
 */
public class IExperience extends AppCompatActivity {
     Button btlogin,reset;
    LocalDatabase localDatabase;
     EditText etemail,etpassword,atemail,atpassword;
    Button btcreate;
   TabHost th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_experience);


        th = (TabHost)findViewById(R.id.tabHost);
        etemail = (EditText)findViewById(R.id.Lemail);
        etpassword = (EditText)findViewById(R.id.Lpassword);
        atemail = (EditText)findViewById(R.id.Aemail);
        atpassword =(EditText)findViewById(R.id.Apassword);

localDatabase = new LocalDatabase(this);



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
public void onSigninClick(View view){
    Intent a = new Intent(IExperience.this,Register.class);
    startActivity(a);

}
  public void onLoginClick(View view)
  {
      String email = etemail.getText().toString();
      String password = etpassword.getText().toString();

      User user = new User(email,password);
      authenticate(user);





  }

    private void authenticate(User user) {
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchdatainBackgroung(user,new GetUserCallbacks() {
            @Override
            public void done(User returnedUdser) {
                if (returnedUdser == null)
                {
                    //show an error message
                    AlertDialog.Builder builder = new AlertDialog.Builder(IExperience.this);
                    builder.setMessage("email & password don't match");
                    etpassword.setText("");
                    etemail.setText("");
                    builder.setPositiveButton("ok",null);
                    builder.show();
                }else
                {
                    localDatabase.StoreData(returnedUdser);
                    localDatabase.setUserLoggedin(true);

                    Intent a = new Intent(IExperience.this, Experience_dashboard.class);
                   startActivity(a);
                }
            }
        });
    }

  /*  public void onAdminLog(View view)
{

    String email = atemail.getText().toString();
    String password = atpassword.getText().toString();
}
public void onAdminRegister(View view)
{
    Intent x = new Intent(IExperience.this,Register.class);
    startActivity(x);
}*/


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




    }

