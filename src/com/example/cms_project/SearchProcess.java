package com.example.cms_project;

import java.util.ArrayList;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SearchProcess extends Activity
{
	EditText ed;
    String key,body;
    ArrayAdapter<Object>  ad;
    ListView lvmsg;
    Search s;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.search);
	        Toast.makeText(this,"Enter Text to search", Toast.LENGTH_LONG).show();
	       s=new Search(this);
	    }

	 public void GO(View v)
	    {
	        ed = (EditText)findViewById(R.id.editText1);
	        String k = ed.getText().toString();
	       ArrayList<Object> al = s.search(k);
	       ad  =  new ArrayAdapter<Object>(this,R.layout.simple,R.id.text_s,al);
	       lvmsg = (ListView) findViewById(R.id.list_view);
	       lvmsg.setAdapter(ad);
	    }	
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
 
}
