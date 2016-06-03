package com.nkawooya.finalprojecttransfer.ServerRequests;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;


import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by KNICK on 3/11/2016.
 */
public class ServerRequests {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT =15000;
   // public static final String SERVER_ADDRESS = "http://localhost/phpmyadmin/index.php";


    public ServerRequests(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }
    public void storedatainBackground(User user,GetUserCallbacks callbacks)
    {
      progressDialog.show();
        new StoreDataAsyncTask(user,callbacks).execute();
    }
    public void fetchdatainBackgroung(User user,GetUserCallbacks callbacks)
    {
        progressDialog.show();
        //new FetchDataAsyncTask(user,callbacks).execute();
    }
    public class StoreDataAsyncTask extends AsyncTask<Void,Void,Void> {
        User user;
        GetUserCallbacks callbacks;

        public StoreDataAsyncTask(User user, GetUserCallbacks callbacks) {
            this.user = user;
            this.callbacks = callbacks;
        }

        @Override
        protected Void doInBackground(Void... params) {






            try {
                StringBuilder content = new StringBuilder("res");
                // URL url = new URL(SERVER+"registerUser.php");


                //URL url = new URL("http://10.0.3.2/smsd/registerUser.php");
                URL url = new URL("http://10.103.6.196:80/smart_tour/Register.php");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(CONNECTION_TIMEOUT);
                urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("name",user.name)
                        .appendQueryParameter("username", user.username)
                        .appendQueryParameter("email", user.email)
                        .appendQueryParameter("country",user.country)
                        .appendQueryParameter("password", user.password);



                String query = builder.build().getEncodedQuery();

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null)
                {
                    content.append(line + "\n");
                }
                bufferedReader.close();
                // result = content.toString();


            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

        }

        public class FetchDataAsyncTask extends AsyncTask<Void, Void, User> {
            User user;
            GetUserCallbacks callbacks;
            StringBuilder content1 = new StringBuilder("Res");

            public FetchDataAsyncTask(User user, GetUserCallbacks callbacks) {
                this.user = user;
                this.callbacks = callbacks;
            }

            @Override
            protected User doInBackground(Void... params) {


                String res = null;
                User user1 = null;
                try {

                    //URL url = new URL(SERVER+"retrive.php");
                    URL url = new URL("http://10.103.6.196:80/smart_tour/FetchUserData.php");
                    URLConnection urlConnection = url.openConnection();

                    urlConnection.setReadTimeout(CONNECTION_TIMEOUT);
                    urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);

                    Uri.Builder builder = new Uri.Builder().appendQueryParameter("UName", user.username)
                            .appendQueryParameter("Pass", user.password);
                    String query = builder.build().getEncodedQuery();

                    OutputStream os = urlConnection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line;
                    // read from the urlconnection via the bufferedreader

                    while ((line = bufferedReader.readLine()) != null) {
                        content1.append(line + "\n");
                    }
                    bufferedReader.close();
                    res = content1.toString();

                    //json decode the data
                    JSONArray jsonArray = new JSONArray(res);
                    String uname = jsonArray.getString(1);
                    String upass = jsonArray.getString(4);
                    user1 = new User(uname, upass);

                } catch (Exception e) {
                    e.printStackTrace();
                    res = e.toString();
                }



                return user1;
            }

            @Override
            protected void onPostExecute(User res) {
                progressDialog.dismiss();
                callbacks.done(res);
                super.onPostExecute(res);

            }
        }
    }
