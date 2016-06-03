package com.nkawooya.finalprojecttransfer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nkawooya on 4/24/2016.
 */
public class ITourist extends AppCompatActivity implements View.OnClickListener {

    Button wcenter,wbodies,wmarkets,wmuseum,wrecreation,wother;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_tourist);
        Initialize();
            wcenter.setOnClickListener(this);
            wcenter.setOnClickListener(this);
            wbodies.setOnClickListener(this);
            wmarkets.setOnClickListener(this);
            wmuseum.setOnClickListener(this);
            wrecreation.setOnClickListener(this);
            wother.setOnClickListener(this);




        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
    }

    public void Initialize(){

        wcenter = (Button)findViewById(R.id.btwcenter);
        wbodies = (Button)findViewById(R.id.btwbodies);
        wmarkets= (Button)findViewById(R.id.btmarket);
        wmuseum = (Button)findViewById(R.id.btmuseums);
        wrecreation =(Button)findViewById(R.id.btrecreation);
        wother=(Button)findViewById(R.id.btothers);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tourist, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }
String title,text;


    /*
    * Imageview.buildDrawingcache();
    * Bitmap image = imageView.getDrawingcache();
    * Bundle extras = new Bandle();
    * extras.putParcelable("Image", image);
    * Intent.putextras(extras);
    * */

    @Override
    public void onClick(View view) {
        Intent a = new Intent(ITourist.this,ITouristDisplay.class);
        switch (view.getId()){
            case R.id.btwcenter:
                text = String.valueOf(R.raw.wildlife1);
                a.putExtra("title", title);
                a.putExtra("image", R.raw.wildlife);
                a.putExtra("text", getdata(text));

                startActivity(a);
                break;
            case R.id.btwbodies:
                text = String.valueOf(R.raw.wildlife1);

                a.putExtra("title", title);
                a.putExtra("image", R.raw.kabaka);
                a.putExtra("text", getdata(text));
                startActivity(a);
                break;
            case R.id.btmarket:
                text = String.valueOf(R.raw.nakasero1);

                a.putExtra("image", R.raw.nakasero);
                a.putExtra("text", getdata(text));
                startActivity(a);
                break;
            case R.id.btmuseums:

                break;
            case R.id.btrecreation:
                a.putExtra("title", title);
                a.putExtra("image", R.raw.wonderworld);
                a.putExtra("text", text);
                startActivity(a);
                break;
            case R.id.btothers:
                break;

        }


            }


    public String getdata(String text){
        InputStream inputStream = getResources().openRawResource(Integer.parseInt(text));
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1){
                byteArrayOutputStream.write(i);
                i=inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }


    }

