package com.example.cms_project;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class Heap 
{
	static int heapSize;
    private HeapNode[] heap;
    int max=0,capacity=100;
    String max_word;
    int flag=0;
    Context context;
     public Heap()
    {
    	 Toast.makeText(context, "heap called", Toast.LENGTH_LONG).show();
        heapSize = 0;
        heap = new HeapNode[capacity + 1];
        Arrays.fill(heap, null);
        try
        {
          CallTimeStamp();
        }
        catch(Exception e)
        {
        	e.getStackTrace();
        }
       
    }
    
      
    public void insert(String word)
    {
    	try
    	{
    	Date d=new Date();
        if(heapSize==0)
        {
         HeapNode hn=new HeapNode(word,d);
         heap[heapSize++] = hn; 
        }
        else
        {
        	for (int i = 0; i < heapSize; i++) 
            {
        		if(heap[i].word==word)
        		{
        			flag=1;
        			heap[i].count++;
        		}
            }
        	if(flag!=1)
        	{
        		 HeapNode hn=new HeapNode(word,d);
                 heap[heapSize++] = hn; 
        	}
        }
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    public void CallTimeStamp()
    {
    	Date referenceDate = new Date();
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(referenceDate); 
    	c.add(Calendar.MONTH,+1);
    	TimeStamp ts=new TimeStamp(heap,heapSize,c);
    }
 
    
}
