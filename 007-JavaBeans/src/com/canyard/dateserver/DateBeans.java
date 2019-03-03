package com.canyard.dateserver;

import java.io.Serializable;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.omg.CORBA.portable.ValueBase;

public class DateBeans implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String date;
	private String time;
	
	
	public DateBeans() {
	Calendar dt=Calendar.getInstance();
	date=String.format("%02d-%02d-%04d", dt.get(Calendar.DATE),dt.get(Calendar.MONTH),Calendar.YEAR);
	time=String.format("%02d:%02d:%02d",dt.get(Calendar.HOUR_OF_DAY),dt.get(Calendar.MINUTE),dt.get(Calendar.SECOND) );
	}
	
	
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}


	public void setDate(String date) {
		try {
			StringTokenizer tk=new StringTokenizer(date,"-");
			if(tk.countTokens()!=3) 
				throw new Exception("Illegal date");
			int day=value(tk.nextToken(), 1, 31);
			int month=value(tk.nextToken(), 1, 12);
			int year=value(tk.nextToken(), 1900, 2100);
			if(month==4 || month==6|| month==9 || month==11 && day==31) throw new Exception("Illegal valuse");
			else if(month==2 && day>(leapYear(year) ? 29 : 28)) throw new Exception("Illegal year");
			this.date=String.format("%02d-%02d-%04d",day,month,year );
			
		}catch (Exception e) {
			this.date =e.toString();
		}
	}

	public void setTime(String time) {
		try {
			StringTokenizer tk=new StringTokenizer(date,"-");
			if(tk.countTokens()!=3) 
				throw new Exception("Illegal date");
			int tim=value(tk.nextToken(), 0, 23);
			int min=value(tk.nextToken(), 0, 59);
			int sec=value(tk.nextToken(), 0, 59);
			
			this.time=String.format("%02d:%02d:%02d",tim,min,sec);
			
		}catch (Exception e) {
			this.date =e.getMessage();
		}
	}
	private int value(String text,int a,int b) throws Exception{
		int t= Integer.parseInt(text);
		if(a<=t && t<=b)
		return t;
		throw new Exception("Illegal value");
	}
	private boolean leapYear(int aar) {
		if(aar%100 ==0)
			return aar%400==0;
	    return aar %4==0;		
	}
		
	@Override
	public String toString() {
		return date+" "+time;
	}

	
	

}
