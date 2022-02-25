package com.wf3.model;

import java.util.Date;

public interface IDate {

	public Date stringToDate(String Sdate);
	public String dateToString(Date dDate);
	public int diffDays(Date d1, Date d2);
	public int diffYears(Date d1, Date d2);
	public int diffMonths(Date d1, Date d2);
	
}
