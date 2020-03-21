package com.example.cms_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class NewMessage extends BroadcastReceiver 
{
		@Override
	public void onReceive(Context context, Intent intent)
		{
			Bundle b=intent.getExtras();
			if(b!=null)
			{
				Object[] pdusObj = (Object[]) b.get("pdus");
				for (int i = 0; i < pdusObj.length; i++) 
				{

	                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
	                String body= currentMessage.getDisplayMessageBody();
	                InsertProcess ip=new InsertProcess(context);
	                ip.token(body);
	                Toast.makeText(context,""+body,Toast.LENGTH_LONG).show();
				}
			}


		}

}
