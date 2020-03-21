package com.example.cms_project;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CreateDatabase extends SQLiteOpenHelper
{
	String indexa[] = {"education", "meeting", "sports", "bank", "entertainment", "travel", "food", "telecom", "automible", "os"};
    static final String db_name = "content.db";
    static final String table_name = "content";
    static final int db_version = 1;
    private Context context;
    int o;
    static String key = null;
    HashMap<String, ArrayList<String>> m;
	private String check;

	public CreateDatabase(Context context) 
	{
		super(context, db_name, null, db_version);
        this.context = context;
        SQLiteDatabase db = this.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE = " CREATE TABLE " + table_name + " " +
                " (" + indexa[0] + " VARCHAR(255), " + indexa[1] + " VARCHAR(255), " + indexa[2] + " VARCHAR(255)," +
                " " + indexa[3] + " VARCHAR(255)," + indexa[4] + " VARCHAR(255)," + indexa[5] + " VARCHAR(255)," +
                " " + indexa[6] + " VARCHAR(255)," + indexa[7] + " VARCHAR(255)," + indexa[8] + " VARCHAR(255)," +
                " " + indexa[9] + " VARCHAR(255)); ";

        try {
            db.execSQL(CREATE);
            Toast.makeText(context, "table created", Toast.LENGTH_LONG).show();

        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
            System.out.println(e);
        }
		
	}

	 void index1() {

	        Toast.makeText(context, "index called", Toast.LENGTH_LONG).show();
	        SQLiteDatabase db = this.getWritableDatabase();
	        for (int i = 0; i < indexa.length; i++) {
	            String index = " CREATE INDEX " + indexa[i] + " on " + table_name + "(" + indexa[i] + ") ";
	            try {
	                db.execSQL(index);
	                Toast.makeText(context, "index added", Toast.LENGTH_LONG).show();
	            } catch (SQLException e) {
	                Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
	                System.out.println(e);
	            }
	        }
	    }
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
		
	}

}
