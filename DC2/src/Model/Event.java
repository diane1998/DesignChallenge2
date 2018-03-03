package Model;

import java.time.LocalTime;

public class Event {
	private String name;
	private int month;
	private int day;
	private int year;
	private LocalTime start;
	private LocalTime end;
	private boolean completed;
	private boolean canceled;
	
	public Event()
	{
		this.name= "";
	
		this.month= 1;
		this.day= 1;
		this.year=1;

	}
	
	public Event(String name, int month, int day, int year,String color,String type)
	{
		this.name= name;

		this.month= month;
		this.day= day;
		this.year=year;

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isEqual(Event e)
	{
		if(e.getDay()== this.day && e.getMonth()== this.month && e.getYear()== this.year && e.getName().equals(this.name))
			return true;
		else 
			return false;
				
	}
	
	public void ToString() {
		System.out.println("The Event name is "+name);
		System.out.println("The date is "+ month+"/"+ day +"/" + year );
		System.out.println("start:"+start.toString());
		System.out.println("end:"+end.toString());
		System.out.println("canceled:"+canceled);
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}


	
	

}
