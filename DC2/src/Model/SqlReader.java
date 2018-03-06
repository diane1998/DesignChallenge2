package Model;

import java.util.ArrayList;

public abstract class SqlReader  {
	public ArrayList<Event> events = new ArrayList<Event>();
	public ArrayList<Task> tasks = new ArrayList<Task>();
	
	public ArrayList <Event> getEvents() {
        return events;

        
    }
	
	public ArrayList <Task> getTasks() { 
        return tasks;
        
    }
	

	abstract public void readAll(); 
	abstract public boolean add(Object j);
	abstract public void update(Object j);
	abstract public void delete(int i);


}
//public abstract class EventReader {
//
//    public ArrayList<Event> data = new ArrayList<Event>();
//
//    public ArrayList <Event> getList() {
//        return data;
//    }
//
//    abstract void readANDprocessData();
//    abstract void writeData(String name, int m, int d, int y, String color);
//    abstract String toString(String name, int m, int d, int y, String color);
//}
