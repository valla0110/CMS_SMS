package com.example.cms_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class InsertProcess extends SQLiteOpenHelper
{
	static final String db_name = "content.db";
    static final String table_name = "content";
    static final int db_version = 1;
	    private Context context;
	    static String key = null;
	    private String check;
	    HashMap<String, ArrayList<String>> m;
	    
	public InsertProcess(Context context)
	{
		 super(context, db_name, null, db_version);
	        this.context = context;
	        SQLiteDatabase db = this.getWritableDatabase();
	        Map_KV map1=new Map_KV();
	        m = map1.KV();
	        Toast.makeText(context, "Insert process", Toast.LENGTH_LONG).show();
	}

	void token(String body) {
        String check;
        int flag = 0;
        Cursor c = null;
        Set<Map.Entry<String, ArrayList<String>>> s= m.entrySet();
        try {
            StringTokenizer st = new StringTokenizer(body);
            while (st.hasMoreElements()) {
                flag = 0;
                check = st.nextToken();

                for (Map.Entry<String, ArrayList<String>> e : s) {
                    ArrayList a = e.getValue();
                    Iterator i = a.iterator();
                    while (i.hasNext()) {
                        if (check.equalsIgnoreCase((String) i.next())) {
                            key = e.getKey();
                            insert(key, body);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1)
                        break;
                }
                if (flag == 1)
                    break;
            }
        } catch (Exception e) {

           // Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }
    }
 void insert(String key, String body) {
       // Toast.makeText(context, "insert called", Toast.LENGTH_LONG).show();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(key, body);
        long id = db.insert(InsertProcess.table_name, null, con);
        //Toast.makeText(context, "insert successful", Toast.LENGTH_LONG).show();
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
