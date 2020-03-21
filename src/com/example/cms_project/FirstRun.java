package com.example.cms_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class FirstRun extends Activity
{
	Context context;
	String key,body;
	Cursor cursor;
	public FirstRun(Context context)
	{
		Toast.makeText(context,"constructor", Toast.LENGTH_LONG).show();
	}
  public void FirstRunProcess()
  {
	  cursor = getContentResolver().query(Uri.parse("content://sms/inbox"),null, null, null, null);
      SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
      p.edit().putBoolean("PREFERENCE_FIRST_RUN",true);
      boolean firstRun = p.getBoolean("PREFERENCE_FIRST_RUN",true);
      if(firstRun==true)
      {
    	  CreateDatabase cd=new CreateDatabase(context);
    	  InsertProcess ip=new InsertProcess(context);
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
               Toast.makeText(context,"inbox empty", Toast.LENGTH_LONG).show();
        	  
           }
           cd.index1();
      	p.edit().putBoolean("PREFERENCE_FIRST_RUN", false).commit();
      	
      }
  }
}
