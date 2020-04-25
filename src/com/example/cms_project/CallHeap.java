package com.example.cms_project;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class CallHeap 
{
   Heap hn;
   String word;
   int call_heap=0;
   Context context;
   public CallHeap(String word) 
   {
	   Toast.makeText(context, "callheap called", Toast.LENGTH_LONG).show();
	   SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
       p.edit().putBoolean("PREFERENCE_FIRST_RUN",true);
       boolean firstRun = p.getBoolean("PREFERENCE_FIRST_RUN",true);
       if(firstRun==true)
       {
   	     call_heap=1;
   	     try
     	 {
     	    hn=new Heap();
     	    hn.insert(word);
     	 }
     	 catch(Exception e)
     	 {
     		Toast.makeText(context, "exception", Toast.LENGTH_LONG).show();
     	 }
   	      p.edit().putBoolean("PREFERENCE_FIRST_RUN", false).commit();
       }
       else
       	 call_heap=2;
       
  
     if(call_heap==2)
       {
    	   try{
       	     hn.insert(word);
    	   }
    	   catch(Exception e)
    	   {
    		   Toast.makeText(context, ""+e, Toast.LENGTH_LONG).show();
    	   }
       }
   }
}
