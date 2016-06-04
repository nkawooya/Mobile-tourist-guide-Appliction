package com.nkawooya.finalprojecttransfer.ServerRequests;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KNICK on 3/11/2016.
 */
public class LocalDatabase {
    public static final String SP_NAME ="UserDetails";
    SharedPreferences localDatabase;

    public LocalDatabase(Context context){
        localDatabase = context.getSharedPreferences(SP_NAME,0);
    }
    // method for storing data on the local/phone database
    public void StoreData(User user)
    {
        SharedPreferences.Editor sp_editor = localDatabase.edit();
        sp_editor.putString("name",user.name);
        sp_editor.putString("username",user.username);
        sp_editor.putString("email",user.email);
        sp_editor.putString("country",user.country);
        sp_editor.putString("password",user.password);
        sp_editor.commit();

    }
    public User getLoggedinUser()
    {
        String name = localDatabase.getString("name","");
        String username = localDatabase.getString("username","");
        String email = localDatabase.getString("email","");
        String country = localDatabase.getString("country","");
        String password = localDatabase.getString("password","");

        User Storeduser = new User(name,username,email,country,password);
        return Storeduser;
    }
    public void setUserLoggedin(boolean loggedin)
    {
        SharedPreferences.Editor SpEditor = localDatabase.edit();
        SpEditor.putBoolean("LoggedIn",loggedin);
        SpEditor.commit();
    }
    public boolean getUserloggedin()
    {
        if (localDatabase.getBoolean("LoggedIn",false)== true)
            return true;
        else
            return false;

    }
    public void clearData()
    {

        SharedPreferences.Editor SpEditor = localDatabase.edit();
        SpEditor.clear();
        SpEditor.commit();
    }
}
