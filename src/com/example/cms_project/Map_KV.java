package com.example.cms_project;

import java.util.*;


public class Map_KV 
{
	HashMap<String,ArrayList<String>> KV()
	    {
	       // Map<String,ArrayList<String>> m=new HashMap<String, ArrayList<String>>();
		 HashMap<String, ArrayList<String>> m = new HashMap<String,ArrayList<String>>();
	        ArrayList<String> education=new ArrayList<String>();
	        education.add("exam");
	        education.add("result");
	        education.add("student");
	        education.add("semester");
	        education.add("education");
	        ArrayList<String> meeting=new ArrayList<String>();
	        meeting.add("seminar");
	        meeting.add("conference");
	        meeting.add("meeting");
	        ArrayList<String> sports=new ArrayList<String>();
	        sports.add("games");
	        sports.add("play");
	        sports.add("sports");
	        ArrayList<String> bank=new ArrayList<String>();
	        bank.add("credited");
	        bank.add("debited");
	        bank.add("deposited");
	        bank.add("account");
	        bank.add("bank");
	        ArrayList<String> entertainment=new ArrayList<String>();
	        entertainment.add("music");
	        entertainment.add("dance");
	        entertainment.add("movie");
	        entertainment.add("songs");
	        entertainment.add("bookmyshow");
	        entertainment.add("entertainment");
	        ArrayList<String> travel=new ArrayList<String>();
	        travel.add("train");
	        travel.add("uber");
	        travel.add("ola");
	        travel.add("jugnoo"); travel.add("travel");
	        
	        ArrayList<String> food=new ArrayList<String>();
	        food.add("dominos");
	        food.add("subway");
	        food.add("pizza");
	        food.add("food");
	        ArrayList<String> telecom=new ArrayList<String>();
	        telecom.add("tv");
	        telecom.add("balance");
	        telecom.add("recharge");
	        telecom.add("offer");
	        telecom.add("valid");
	        telecom.add("telecom");
	        telecom.add("roaming");
	        ArrayList<String> automobile=new ArrayList<String>();
	        automobile.add("servicing");
	        automobile.add("automobile");
	        ArrayList<String> os=new ArrayList<String>();
	        os.add("amazon");
	        os.add("flipkart");
	        os.add("sale");
	        os.add("snapdeal");
	        os.add("myntra's");
	        os.add("jabong");
	        os.add("os");
	        m.put("education",education);
	        m.put("meeting",meeting);
	        m.put("sports", sports);
	        m.put("entertainment", entertainment);
	        m.put("travel",travel);
	        m.put("food", food);
	        m.put("telecom",telecom);
	        m.put("os", os);
	        m.put("automobile",automobile);
	        m.put("bank",bank);
	        return m;
	    }
}
