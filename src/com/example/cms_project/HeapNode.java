package com.example.cms_project;

import java.util.Date;

public class HeapNode
{
	int count=0;
	String word;
        Date date;
 
        
	public HeapNode(String word,Date date){
		this.word = word;
		 count++;
         this.date=date;
	}
 
	public int getCount()
	{
		return count;
	}
 
	public String getWord(){
		return word;
	}
        
        public Date getDate()
        {
            return date;
        }
}
