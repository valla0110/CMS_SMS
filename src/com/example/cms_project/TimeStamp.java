package com.example.cms_project;

import java.util.*;
import java.lang.*;


public class TimeStamp extends Timer
{
	int total=0,avg;
	   HeapNode[] heap;
	   int heapsize,temp,max=0,flag=0;
	   TimerTask tt;
	   String max_word;
	   
	    public TimeStamp(HeapNode[] heap, int heapsize,Calendar c)
	    {
	        this.heap=heap;
	        this.heapsize=heapsize;
	        Calendar calendar=Calendar.getInstance();
	        boolean sameDay=calendar.get(Calendar.YEAR) == c.get(Calendar.YEAR) &&
	                  calendar.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
	        if(sameDay==true)
	        call();
	        
	    } 
	    public void call()
	    {
	    
				//checking least frequent word searched
				for(int i=0;i<heapsize;i++)
			      {
			          total=total+heap[i].getCount();
			      }
			       avg=total/heapsize;
			        System.out.println("avg="+avg);
			        for(int i=0;i<heapsize;i++)
			        {
			            if(heap[i].getCount() < avg)
			            {
			                 heap[i] = heap[heapsize - 1];
			                 heapsize--;
			            }
			        }
			        
			        //finding most frequent word searched
			        for (int i = 0; i < heapsize; i++) 
	                 {
	                 max = Math.max(heap[i].getCount(),max);
	                 }
	                  for (int i = 0; i < heapsize; i++)
	                  {
	                      if (max==heap[i].getCount())
	                      {
	                    	  flag=1;
	                         max_word=heap[i].getWord();
	                      }
	                  }
	                  
	                  //insert max word in trie
	                  if(flag==1)
	                  {
	                	  //call trie
	                  }
	               
				
			}
		
	    }

