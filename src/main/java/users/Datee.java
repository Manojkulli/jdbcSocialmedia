package users;

import java.util.Date;

public class Datee {
	Date d=new Date();
   
	int date=d.getDate();
	int month=d.getMonth();
	int hours=d.getHours();
	int min=d.getMinutes();
	private String Date=""+date+"-"+(month+1)+"-2022";
	private String Time=""+hours+":"+min+"";
	public String getDate() {
		return Date;
	}
	
	public String getTime() {
		return Time;
	}
	public static void main(String[] args) {
		Datee dd=new Datee();
		System.out.println(dd.getDate());
		System.out.println(dd.getTime());
	}
	
}
