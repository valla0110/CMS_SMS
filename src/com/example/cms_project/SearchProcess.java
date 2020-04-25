package com.example.cms_project;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchProcess extends Activity
{
	EditText ed,t;
	TextView tv;
    String key,body,text;
    ArrayAdapter<Object>  ad;
    ListView lvmsg;
    Search s;
    String[] a;
    ArrayList<String> al=new ArrayList<String>();
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.search);
			  t=(EditText) findViewById(R.id.editText1);
		      tv=(TextView) findViewById(R.id.textView2);
		      Toast.makeText(this,"Enter Text to search", Toast.LENGTH_LONG).show();
		     
		      AutoCompleteTextView autocom=(AutoCompleteTextView) findViewById(R.id.editText1);
		     
		     
		      autocom.addTextChangedListener(new TextWatcher() {
				
		    	  
		    	  @Override
				public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
				{
				}
				
				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
						int arg3) {
				}	
				@Override
				public void afterTextChanged(Editable arg0) 
				{
					text=arg0.toString();
					SearchTrie st=new SearchTrie();
					List matches=st.searchTrie(text);
					 a=new String[matches.size()];
					if(matches==null || matches.size() == 0)
					{
						;
					}
					else
					{
						
						ListIterator<String> l=matches.listIterator();
						a=(String[]) matches.toArray();
						for(String s:a)
						{
							
						}
			               
			                       
					}
				}
			});
		      Toast.makeText(this, ""+al,Toast.LENGTH_LONG).show();
		      ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice,a);
		      AutoCompleteTextView autocom1=(AutoCompleteTextView) findViewById(R.id.editText1);
		     // autocom1.setThreshold(1);
		     // autocom1.setAdapter(ad);
		      autocom.setThreshold(1);
		      autocom.setAdapter(ad);
	       s=new Search(this);
	    }

	 public void GO(View v)
	    {
	        ed = (EditText)findViewById(R.id.editText1);
	        String k = ed.getText().toString();
	       ArrayList<Object> al = s.search(k);
	       ColorDrawable white=new ColorDrawable(this.getResources().getColor(R.drawable.sage));
	       ad  =  new ArrayAdapter<Object>(this,R.layout.simple,R.id.text_s,al);
	       lvmsg = (ListView) findViewById(R.id.list_view);
	       lvmsg.setDivider(white);
	       lvmsg.setDividerHeight(2);
	       lvmsg.setAdapter(ad);
	    }	
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
 
}
