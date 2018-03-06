package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;



public class EventConnection extends SqlReader{
	private SchedDb connection;
	
	public EventConnection(SchedDb  schedDb) {
		connection=schedDb;
	}
	
	public void  ReadAll() {
		// create empty list of contacts
		List<Event> Events = new ArrayList<Event>();

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
				Events.add(toObject(rs));
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
		// return list
	}
	

	private Event toObject(ResultSet rs) throws SQLException {
		Event event = new Event(rs.getInt(Event.COL_ID),rs.getString(Event.COL_NAME),rs.getDate(Event.COL_DATE),rs.getTime(Event.COL_START),rs.getTime(Event.COL_END),rs.getBoolean(Event.COL_COMPLETED),rs.getBoolean(Event.COL_DELETED));
		return event;
	}
	
	public boolean addEvent(Event Event) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "INSERT INTO " + Event.TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(1, Types.NULL); // because id is auto-increment anyway
			ps.setString(2, Event.getName());
			ps.setDate(3, Event.getDate());
			ps.setTime(4, Event.getStart());
			ps.setTime(5, Event.getEnd());
			ps.setBoolean(6, Event.isCompleted());
			ps.setBoolean(7, Event.isDeleted());
	

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
	
	public void updateEvent(Event Event) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "UPDATE " + Event.TABLE + " SET " + Event.COL_NAME + " = ?," + Event.COL_DATE
				+ " = ?," + Event.COL_START + " = ?," + Event.COL_END + " = ?," + Event.COL_COMPLETED
				+ " = ?," + Event.COL_DELETED + " = ?" + " WHERE "
				+ Event.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(7, Event.getId()); // because id is auto-increment anyway
			ps.setString(1, Event.getName());
			ps.setDate(2, Event.getDate());
			ps.setTime(3, Event.getStart());
			ps.setTime(4, Event.getEnd());
			ps.setBoolean(5, Event.isCompleted());
			ps.setBoolean(6, Event.isDeleted());

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
	
	public void deleteEvent(int id) {
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
	
	public Event getEvent(int id) {
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
	
	public static void main(String[] args) {
		EventConnection service = new EventConnection(new SchedDb());
		 service.ReadAll();
		 ArrayList<Event> events = service.getEvents();
		
//		Event Event = service.getEvent(1);
//
		for (Event r : events) {
			r.ToString();
			System.out.println("");
		}
//		Event.ToString();
	}



	@Override
	public void Add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		
	}


	
}
