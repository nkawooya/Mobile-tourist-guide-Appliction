package com.nkawooya.finalprojecttransfer.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nkawooya.finalprojecttransfer.IExperience;
import com.nkawooya.finalprojecttransfer.R;
import com.nkawooya.finalprojecttransfer.ServerRequests.GetUserCallbacks;
import com.nkawooya.finalprojecttransfer.ServerRequests.ServerRequests;
import com.nkawooya.finalprojecttransfer.ServerRequests.User;

/**
 * Created by nkawooya on 4/25/2016.
 */
public class Register extends AppCompatActivity implements View.OnClickListener {


    EditText etname,etusername,etemail,etcountry,etpassword,etconfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_registert);
        Initialize();

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.hide();
    }
public void onRegisterclick(View view)
{


    String name = etname.getText().toString();
    String username = etusername.getText().toString();
    String email = etemail.getText().toString();
    String country = etcountry.getText().toString();
    String password = etpassword.getText().toString();
    String confirm = etconfirm.getText().toString();

    if(password.equals(confirm))
    {

    }else
    {
        Toast.makeText(getBaseContext(),"passwords don't match",Toast.LENGTH_SHORT).show();

    }


}


    //method fo calling widgets
    public void Initialize(){

        etname= (EditText)findViewById(R.id.Rname);
        etusername= (EditText)findViewById(R.id.Rusername);
        etemail=(EditText)findViewById(R.id.Remail);
        etcountry=(EditText)findViewById(R.id.Rcountry);
        etpassword=(EditText)findViewById(R.id.Rpassword);
        etconfirm=(EditText)findViewById(R.id.Rcpassword);



    }
    public void getdata(){
        String sname = etname.getText().toString();
        String susername = etusername.getText().toString();
        String semail = etemail.getText().toString();
        String scountry = etcountry.getText().toString();
        String spassword = etpassword.getText().toString();
        String sconfirm = etconfirm.getText().toString();


        User user;
        if (sname.equals("")||susername.equals("")||semail.equals("")||scountry.equals("")||spassword.equals("")){
            Toast.makeText(getBaseContext(),"missing fields",Toast.LENGTH_SHORT).show();
            etpassword.setText("");
            etconfirm.setText("");
          }else {
            if(spassword.equals(sconfirm)){
                user = new User(sname,susername,semail,scountry,sconfirm);
                ServerRequests serverRequests = new ServerRequests(this);
                serverRequests.storedatainBackground(user,new GetUserCallbacks() {
                    @Override
                    public void done(User returnedUdser) {
                        Intent a = new Intent(Register.this, IExperience.class);
                        startActivity(a);
                    }
                });
            }else {
                Toast.makeText(getBaseContext(),"passwords do not match",Toast.LENGTH_SHORT).show();
                etpassword.setText("");
                etconfirm.setText("");
            }


        }

    }


    @Override
    public void onClick(View view) {
       int id = view.getId();
                if(id == R.id.cont){
                 getdata();



        }
    }
}