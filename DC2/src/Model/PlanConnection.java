package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;



public class PlanConnection extends SqlReader{
	private SchedDb connection;
	
	public PlanConnection(SchedDb  schedDb) { 
		connection=schedDb;
	}
	
	public void  readAll() {
		// create empty list of contacts
		List<Event> Events = new ArrayList<Event>();
		List<Task> Tasks = new ArrayList<Task>();
		// get connection from db
		Connection cnt = connection.getConnection();

		// create string query
		String query = "SELECT * FROM " + Event.TABLE;

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// get result and store in result set
			ResultSet rs = ps.executeQuery();

			// transform set to list
			// rs.next() means get next in result set
			while (rs.next()) {
				if(toObject(rs).getColor()==1)
					Events.add(toObject(rs));
				else if(toObject(rs).getColor()==2)
					Tasks.add(toTask(rs));
			}

			// close all the resources
			ps.close();
			rs.close();
			cnt.close();

			System.out.println("[Event] SELECT SUCCESS!");
		} catch (SQLException e) {
			System.out.println("[Event] SELECT FAILED!");
			e.printStackTrace();
		}
			events=(ArrayList<Event>) Events;
			tasks=(ArrayList<Task>) Tasks;
		// return list
	}
	
	private Task toTask(ResultSet rs) throws SQLException {
		Task task = new Task(rs.getInt(Task.COL_ID),rs.getString(Task.COL_NAME),rs.getDate(Task.COL_DATE),rs.getTime(Task.COL_START),rs.getBoolean(Task.COL_COMPLETED),rs.getBoolean(Task.COL_DELETED),rs.getInt(Task.COL_COLOR));
		return task;
	}

	private Event toObject(ResultSet rs) throws SQLException {
		Event event = new Event(rs.getInt(Event.COL_ID),rs.getString(Event.COL_NAME),rs.getDate(Event.COL_DATE),rs.getTime(Event.COL_START),rs.getTime(Event.COL_END),rs.getBoolean(Event.COL_COMPLETED),rs.getBoolean(Event.COL_DELETED),rs.getInt(Task.COL_COLOR));
		return event;
	}
	
	public boolean add(Object o) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "INSERT INTO " + Event.TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
//			if(((Event) o).getColor()==1){
				ps.setInt(1, Types.NULL); // because id is auto-increment anyway
				ps.setString(2, ((Event) o).getName());
				ps.setDate(3, ((Event) o).getDate());
				ps.setTime(4, ((Event) o).getStart());
				ps.setTime(5, ((Event) o).getEnd());
				ps.setBoolean(6, ((Event) o).isCompleted());
				ps.setBoolean(7, ((Event) o).isDeleted());
				ps.setInt(8,((Event) o).getColor());
//			}else if(((Event) o).getColor()==2) {
//				ps.setInt(1, Types.NULL); // because id is auto-increment anyway
//				ps.setString(2, ((Task) o).getName());
//				ps.setDate(3, ((Task) o).getDate());
//				ps.setTime(4, ((Task) o).getStart());
//				ps.setTime(5, ((Task) o).getEnd());
//				ps.setBoolean(6, ((Task) o).isCompleted());
//				ps.setBoolean(7, ((Task) o).isDeleted());
//				ps.setInt(8, ((Task) o).getColor());
//			}

			// execute the update
			ps.executeUpdate();

			// close resources
			ps.close();
			cnt.close();
			System.out.println("[Event] INSERT SUCCESS");
			return true;
		} catch (SQLException e) {
			System.out.println("[Event] INSERT FAILED");
			e.printStackTrace();
			return false;
		}
	}
	
	public void update(Object o) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "UPDATE " + Event.TABLE + " SET " + Event.COL_NAME + " = ?," + Event.COL_DATE
				+ " = ?," + Event.COL_START + " = ?," + Event.COL_END + " = ?," + Event.COL_COMPLETED
				+ " = ?," + Event.COL_DELETED + " = ?" + Event.COL_COLOR + " = ?" + " WHERE "
				+ Event.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(8, ((Event) o).getId()); // because id is auto-increment anyway
			ps.setString(1, ((Event) o).getName());
			ps.setDate(2, ((Event) o).getDate());
			ps.setTime(3, ((Event) o).getStart());
			ps.setTime(4, ((Event) o).getEnd());
			ps.setBoolean(5, ((Event) o).isCompleted());
			ps.setBoolean(6, ((Event) o).isDeleted());
			ps.setInt(7, ((Event) o).getColor());
			// execute the update
			ps.executeUpdate();

			// close resources
			ps.close();
			cnt.close();
			System.out.println("[Event] UPDATE SUCCESS");
		} catch (SQLException e) {
			System.out.println("[Event] UPDATE FAILED");
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "DELETE FROM " + Event.TABLE + " WHERE " + Event.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(1, id); // gets the first question mark and sets it to id

			// execute the update
			ps.executeUpdate();

			// close resources
			ps.close();
			cnt.close();
			System.out.println("[Event] DELETE SUCCESS");
		} catch (SQLException e) {
			System.out.println("[Event] DELETE FAILED");
			e.printStackTrace();
		}
	}
	
	public Event getObject(int id) {
		Event event = null ;

		// get connection from db
		Connection cnt = connection.getConnection();

		// create string query
		String query = "SELECT * FROM " + Event.TABLE + " WHERE " + Event.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			ps.setInt(1, id);

			// get result and store in result set
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				event = toObject(rs);
			}

			// close all the resources
			ps.close();
			rs.close();
			cnt.close();

			System.out.println("[Event] SELECT SUCCESS!");
		} catch (SQLException e) {
			System.out.println("[Event] SELECT FAILED!");
			e.printStackTrace();
		}

		// return list
		return event;
	}
	
//	public static void main(String[] args) {
//		PlanConnection service = new PlanConnection(new SchedDb());
//			 service.readAll();
//		 ArrayList<Event> events = service.getEvents();
//		 ArrayList<Task> tasks = service.getTasks();
////		Event Event = service.getEvent(1);
//
//		for (Event r : events) {
//			r.ToString();
//			System.out.println("");
//		}
//		
//		for (Task t : tasks) {
//			t.ToString();
//			System.out.println("");
//		}
//	
////		Event.ToString();
//	}




}
