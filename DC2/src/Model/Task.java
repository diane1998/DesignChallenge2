package Model;

import java.sql.Date;
import java.sql.Time;


public class Task extends Event{
	
static Time t =new Time(0); //	private String name;
//	private Date date;
//	private Time start;
//	private Time end;
//	private boolean completed;
//	private boolean deleted;
	
	public static final String TABLE = "plandb";
	public static final String COL_ID = TABLE + ".id";
	public static final String COL_NAME = TABLE + ".name";
	public static final String COL_DATE = TABLE + ".date";
	public static final String COL_START = TABLE + ".start";
	public static final String COL_END = TABLE + ".end";
	public static final String COL_COMPLETED = TABLE + ".completed";
	public static final String COL_DELETED = TABLE + ".deleted";
	public static final String COL_COLOR = TABLE + ".color";
	
	public Task() {
		this.setEnd(t);
	}

	public Task(int id,String name,Date date,Time start,boolean completed ,boolean deleted,int color)
	{
		
		super(id,name,date,start,t,completed,deleted,color); 

	}
	
	public void ToString() {
		System.out.println("ID is "+ this.getId());
		System.out.println("The Task name is "+this.getName());
		System.out.println("The date is "+this.getDate());
		System.out.println("start:"+this.getStart());
		System.out.println("end:"+this.getEnd());
		System.out.println("completed:"+this.isCompleted());
		System.out.println("canceled:"+this.isDeleted());
	}


}
