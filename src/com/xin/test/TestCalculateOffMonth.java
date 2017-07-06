package com.xin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCalculateOffMonth {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date myStartDate = dateFormat.parse("2013-01-02");
		Date myEndDate = dateFormat.parse("2015-01-17");
		
		System.out.println(myStartDate);
		System.out.println(myEndDate);
		Integer offDay = 0;
		Date startDate = (myStartDate.getYear() < new Date().getYear())?new Date(new Date().getYear(),0,1):myStartDate;
		Date endDate = (myEndDate.getYear() > new Date().getYear())?new Date(new Date().getYear(),11,31):myEndDate;
		System.out.println(startDate);
		System.out.println(endDate);
		offDay = (int) ((endDate.getTime()-startDate.getTime())/1000 / 60 / 60 / 24); 
		System.out.println(offDay);
		double offMonth = ((int)(offDay / 15))/2.0;
		System.out.println(offMonth);
	}

}
