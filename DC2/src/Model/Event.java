package Model;

import java.sql.Date;
import java.sql.Time;
import java.util.GregorianCalendar;

import sun.util.calendar.Gregorian;


public class Event {
	private int id;
	private String name;
	private Date date;
	private Time start;
	private Time end;
	private boolean completed;
	private boolean deleted;
	private int color;
	
	public static final String TABLE = "plandb";
	public static final String COL_ID = TABLE + ".id";
	public static final String COL_NAME = TABLE + ".name";
	public static final String COL_DATE = TABLE + ".date";
	public static final String COL_START = TABLE + ".start";
	public static final String COL_END = TABLE + ".end";
	public static final String COL_COMPLETED = TABLE + ".completed";
	public static final String COL_DELETED = TABLE + ".deleted";
	public static final String COL_COLOR = TABLE + ".color";
//	public Event()
//	{
//		this.name= "";
//		
//		this.month= 1;
//		this.day= 1;
//		this.year=1;
//
//	}
	public Event()
	{
		
	}
	
	public Event(int id,String name,Date date,Time start,Time end,boolean completed,boolean deleted,int color)
	{
		this.id=id;
		this.name= name;
		this.date= date;
		this.start= start;
		this.end=end;
		this.completed=completed;
		this.deleted=deleted;
		this.color=color;
		

	}
	
	public Date getDate() {
		return date;
	}


	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
//	public boolean isEqual(Event e)
//	{
//		if(e.getDay()== this.day && e.getMonth()== this.month && e.getYear()== this.year && e.getName().equals(this.name))
//			return true;
//		else 
//			return false;
//				
//	}
	
	public void ToString() {
		System.out.println("The Event name is "+name);
		System.out.println("The date is "+ date );
		System.out.println("start:"+start.toString());
		System.out.println("end:"+end.toString());
		System.out.println("canceled:"+deleted);
	}



	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

//	@SuppressWarnings("deprecation")
	public void setDate(java.util.Date date2) {
		// TODO Auto-generated method stub
//		GregorianCalendar cal = new GregorianCalendar();
//		cal.setTime(date2);
		this.date=new java.sql.Date(date2.getTime());
	
	}


	

}
