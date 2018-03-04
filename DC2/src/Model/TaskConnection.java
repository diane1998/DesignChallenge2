package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class TaskConnection {
private SchedDb connection;
	
	public TaskConnection(SchedDb  schedDb) {
		connection=schedDb;
	}
	
	public List<Task> getAll() {
		// create empty list of contacts
		List<Task> Tasks = new ArrayList<Task>();

		// get connection from db
		Connection cnt = connection.getConnection();

		// create string query
		String query = "SELECT * FROM " + Task.TABLE;

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// get result and store in result set
			ResultSet rs = ps.executeQuery();

			// transform set to list
			// rs.next() means get next in result set
			while (rs.next()) {
				Tasks.add(toTask(rs));
			}

			// close all the resources
			ps.close();
			rs.close();
			cnt.close();

			System.out.println("[Task] SELECT SUCCESS!");
		} catch (SQLException e) {
			System.out.println("[Task] SELECT FAILED!");
			e.printStackTrace();
		}

		// return list
		return Tasks;
	}
	

	private Task toTask(ResultSet rs) throws SQLException {
		Task task = new Task(rs.getInt(Task.COL_ID),rs.getString(Task.COL_NAME),rs.getDate(Task.COL_DATE),rs.getTime(Task.COL_START),rs.getTime(Task.COL_END),rs.getBoolean(Task.COL_COMPLETED),rs.getBoolean(Task.COL_DELETED));
		return task;
	}
	
	public boolean addTask(Task Task) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "INSERT INTO " + Task.TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(1, Types.NULL); // because id is auto-increment anyway
			ps.setString(2, Task.getName());
			ps.setDate(3, Task.getDate());
			ps.setTime(4, Task.getStart());
			ps.setTime(5, Task.getEnd());
			ps.setBoolean(6, Task.isCompleted());
			ps.setBoolean(7, Task.isDeleted());
	

			// execute the update
			ps.executeUpdate();

			// close resources
			ps.close();
			cnt.close();
			System.out.println("[Task] INSERT SUCCESS");
			return true;
		} catch (SQLException e) {
			System.out.println("[Task] INSERT FAILED");
			e.printStackTrace();
			return false;
		}
	}
	
	public void updateTask(Task Task) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "UPDATE " + Task.TABLE + " SET " + Task.COL_NAME + " = ?," + Task.COL_DATE
				+ " = ?," + Task.COL_START + " = ?," + Task.COL_END + " = ?," + Task.COL_COMPLETED
				+ " = ?," + Task.COL_DELETED + " = ?" + " WHERE "
				+ Task.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			// prepare the values
			ps.setInt(7, Task.getId()); // because id is auto-increment anyway
			ps.setString(1, Task.getName());
			ps.setDate(2, Task.getDate());
			ps.setTime(3, Task.getStart());
			ps.setTime(4, Task.getEnd());
			ps.setBoolean(5, Task.isCompleted());
			ps.setBoolean(6, Task.isDeleted());

			// execute the update
			ps.executeUpdate();

			// close resources
			ps.close();
			cnt.close();
			System.out.println("[Task] UPDATE SUCCESS");
		} catch (SQLException e) {
			System.out.println("[Task] UPDATE FAILED");
			e.printStackTrace();
		}
	}
	
	public void deleteTask(int id) {
		// get connection from db
		Connection cnt = connection.getConnection();

		// create a query
		String query = "DELETE FROM " + Task.TABLE + " WHERE " + Task.COL_ID + " = ?";

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
			System.out.println("[Task] DELETE SUCCESS");
		} catch (SQLException e) {
			System.out.println("[Task] DELETE FAILED");
			e.printStackTrace();
		}
	}
	
	public Task getTask(int id) {
		Task Task = null ;

		// get connection from db
		Connection cnt = connection.getConnection();

		// create string query
		String query = "SELECT * FROM " + Task.TABLE + " WHERE " + Task.COL_ID + " = ?";

		try {
			// create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);

			ps.setInt(1, id);

			// get result and store in result set
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Task = toTask(rs);
			}

			// close all the resources
			ps.close();
			rs.close();
			cnt.close();

			System.out.println("[Task] SELECT SUCCESS!");
		} catch (SQLException e) {
			System.out.println("[Task] SELECT FAILED!");
			e.printStackTrace();
		}

		// return list
		return Task;
	}
	
	public static void main(String[] args) {
		TaskConnection service = new TaskConnection(new SchedDb());
		List<Task> Tasks = service.getAll();
		Task Task = service.getTask(1);

		for (Task r : Tasks) {
			r.ToString();
			System.out.println("");
		}
		Task.ToString();
	}
	
}
