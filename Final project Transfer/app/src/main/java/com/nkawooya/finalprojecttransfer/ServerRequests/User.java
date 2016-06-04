package com.nkawooya.finalprojecttransfer.ServerRequests;

/**
 * Created by KNICK on 3/11/2016.
 */
public class User {

    String name;
    public String username;
    String email;
    public String country;
    String password;
    public User(String name, String username,String email,String country,String password)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.country = country;
        this.password = password;

    }
    public User(String username,String password)
    {
        this.username = username;
        this.password = password;
    }
}
