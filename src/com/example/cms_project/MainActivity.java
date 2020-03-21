package com.example.cms_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	EditText ed;
    String key,body;
    ArrayAdapter<Object>  ad;
    ListView lvmsg;
    FirstRun fr;
    public Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer = new  Thread()
        {
        	 public void run(){
        		  try{
        			  sleep(5000);
        			  
        		  }catch(Exception e){
        			   e.printStackTrace();
        		  }
        	      finally{
        	    	   Intent openstartingpoint = new Intent("com.example.cms_project.SEARCH");
        	    	   startActivity(openstartingpoint);
        	      }
        	 }
        	 
        };
	
        timer.start();
        cursor = getContentResolver().query(Uri.parse("content://sms/inbox"),null, null, null, null);
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
        p.edit().putBoolean("PREFERENCE_FIRST_RUN",true);
        boolean firstRun = p.getBoolean("PREFERENCE_FIRST_RUN",true);
        if(firstRun==true)
        {
      	  CreateDatabase cd=new CreateDatabase(this);
      	  InsertProcess ip=new InsertProcess(this);
      	  SQLiteDatabase db=cd.getWritableDatabase();
             if (cursor.moveToFirst()) {
                 do
                 {
                     body = cursor.getString(cursor.getColumnIndexOrThrow("body")).toString();
                     ip.token(body);
                     cursor.moveToNext();
                 }while (cursor.moveToNext());
             }
             else {
                 Toast.makeText(this,"inbox empty", Toast.LENGTH_LONG).show();
          	  
             }
             cd.index1();
        	p.edit().putBoolean("PREFERENCE_FIRST_RUN", false).commit();
        	
        }
    }
      /* fr=new FirstRun(getBaseContext());
       try
       {
         fr.FirstRunProcess();
       }
       catch(Exception ex)
       {
    	   Toast.makeText(this, "first  "+ex,Toast.LENGTH_LONG).show();
       }*/
       
       

   

   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
