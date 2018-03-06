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
	

	abstract public void ReadAll(); 
	abstract public void Add();
	abstract public void update();
	abstract public void Delete();

	
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
