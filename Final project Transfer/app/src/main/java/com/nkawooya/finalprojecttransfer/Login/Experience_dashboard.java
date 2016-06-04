package com.nkawooya.finalprojecttransfer.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nkawooya.finalprojecttransfer.IExperience;
import com.nkawooya.finalprojecttransfer.IHome;
import com.nkawooya.finalprojecttransfer.R;
import com.nkawooya.finalprojecttransfer.ServerRequests.LocalDatabase;
import com.nkawooya.finalprojecttransfer.ServerRequests.User;

/**
 * Created by nkawooya on 6/3/2016.
 */
public class Experience_dashboard extends AppCompatActivity{
LocalDatabase localDatabase;
    TextView tvusername,tvcountry;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_dashboard);
        tvusername = (TextView)findViewById(R.id.dusername);
       tvcountry = (TextView)findViewById(R.id.dcountry);
localDatabase = new LocalDatabase(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate()== true)
        {
            Displaydetails();

        }else {
            Intent a = new Intent(Experience_dashboard.this, IExperience.class);
            startActivity(a);
        }
    }

    private void Displaydetails() {
        User user = localDatabase.getLoggedinUser();
        tvusername.setText(user.username);
        tvcountry.setText("from " +user.country);

    }

    private boolean authenticate() {
        return localDatabase.getUserloggedin();
    }

    public void OnLogoutClick(View view)
    {
        localDatabase.clearData();
        localDatabase.setUserLoggedin(false);
        finish();
        Intent x = new Intent(Experience_dashboard.this, IHome.class);
        startActivity(x);
    }
}
