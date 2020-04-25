package com.example.cms_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Search extends SQLiteOpenHelper
{
	 String indexa[] = {"education", "meeting", "sports", "bank", "entertainment", "travel", "food", "telecom", "automible", "os"};
	 int call_heap=0;
		Heap hn;
		// CallHeap ch;

	 static final String db_name = "content.db";
	    static final String table_name = "content";
	    static final int db_version = 1;
	    private Context context;
	    int o;
	    static String key = null;
	    HashMap<String, ArrayList<String>> m;
		private String check;
		
		 public Search(Context context) {
		        super(context, db_name, null, db_version);
		        this.context = context;
		        SQLiteDatabase db = this.getWritableDatabase();		  
		        Map_KV map1=new Map_KV();
		        m = map1.KV();
		       
		    }
	
	
	 public ArrayList<Object> search(String key1) 
	 {
	        int flag = 0,flag1=0,flagz=0;
	        String new1 ,key2,key=null;
	        String value = null;
	        String send=key1;
	        ArrayList<Object> al = new ArrayList<Object>();
	        Set<Map.Entry<String, ArrayList<String>>> s = m.entrySet();
	        for (Map.Entry<String, ArrayList<String>> e : s)
	        {   flag=0;
	            value=null;
	            ArrayList a = e.getValue(); 
	            Iterator i = a.iterator();
	            while (i.hasNext()) 
	            {
	            	 new1 = (String)i.next();
	                if (key1.compareToIgnoreCase(new1) == 0) {
	                    key = e.getKey();
	                    value=new1; 
	                  //  Toast.makeText(context, key+"=" +value, Toast.LENGTH_LONG).show();
	                    flag = 1;
	                    break;
	                }
	         }
	           
	           if (flag == 1)
	                break;
	        }
	        if( flag==1)
	        {
	        	
	        SQLiteDatabase db = this.getReadableDatabase();
	        try {
	            String select = " SELECT " + key + " FROM " + table_name + "  ";
	            Cursor cursor1 = db.rawQuery(select, null);
	            if (cursor1.moveToFirst()) {
	                for (cursor1.moveToFirst(); !cursor1.isAfterLast(); cursor1.moveToNext()) 
	                {
	                	flagz= 0;
	                    String body1 = cursor1.getString(0);        
	                   	  if(value==key)
	                   	  {
	                    	  al.add(cursor1.getString(0)); 

	                   	  }
	                   	  else
	                   	  {
	                   		//Toast.makeText(context, "else ", Toast.LENGTH_LONG).show();
	                   		
	      
	                     try{
	                    	 StringTokenizer st1=new StringTokenizer(cursor1.getString(0));
	                   		while (st1.hasMoreElements()) 
	                    {
	    	                
	    	                check = st1.nextToken();
	    	                //Toast.makeText(context, " " +check, Toast.LENGTH_LONG).show();
	    	                if(check.equalsIgnoreCase(value))
	    	                {
	    	                	//Toast.makeText(context, check+" in check = value"+value, Toast.LENGTH_LONG).show();
	    	                	al.add(cursor1.getString(0)); 
	    	                	//Toast.makeText(context, " " +cursor1.getString(0), Toast.LENGTH_LONG).show();
	    	                	flagz = 1;
	                            break;
	    	                }
	                    }
	                     }
	                     catch(Exception ex){
	                    	 // Toast.makeText(context, body1+"while " +ex, Toast.LENGTH_LONG).show();
	                     }
	                    
	                   // Toast.makeText(context, " " + body1, Toast.LENGTH_LONG).show();
	                   
	                }
	                }
	                }
	            else
	            {
	                //Toast.makeText(context, "NO data found", Toast.LENGTH_LONG).show();
	                
	            }
	        } 
	            catch (Exception e1) 
	           {
	              Toast.makeText(context, "Error" + e1, Toast.LENGTH_LONG).show();

	            }
	        }
	        
	        if(flag==0)
	        {
	        	  call_heap=1;
	        	 if(call_heap==1)
	 	        {
	 	        	try
	 	        	 {
	 	        		//Toast.makeText(context, "send=="+send, Toast.LENGTH_LONG).show();
	 	        	    //CallHeap ch=new CallHeap(send);
	 	        	 }
	 	        	 catch(Exception e)
	 	        	 {
	 	        		 Toast.makeText(context, ""+e, Toast.LENGTH_LONG).show();
	 	        	 }
	 	        }
	        		 
	        }
	        
	        return al;

}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
