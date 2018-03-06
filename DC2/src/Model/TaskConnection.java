//package Model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class TaskConnection extends SqlReader{
//	private SchedDb connection;
//	
//	public TaskConnection(SchedDb  schedDb) { 
//		connection=schedDb;
//	}
//	
//	public void  readAll() {
//		// create empty list of contacts
//		List<Task> Tasks = new ArrayList<Task>();
//
//		// get connection from db
//		Connection cnt = connection.getConnection();
//
//		// create string query
//		String query = "SELECT * FROM " + Task.TABLE;
//
//		try {
//			// create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//
//			// get result and store in result set
//			ResultSet rs = ps.executeQuery();
//
//			// transform set to list
//			// rs.next() means get next in result set
//			while (rs.next()) {
//				Tasks.add(toObject(rs));
//			}
//
//			// close all the resources
//			ps.close();
//			rs.close();
//			cnt.close();
//
//			System.out.println("[Task] SELECT SUCCESS!");
//		} catch (SQLException e) {
//			System.out.println("[Task] SELECT FAILED!");
//			e.printStackTrace();
//		}
//			tasks=(ArrayList<Task>) Tasks;
//		// return list
//	}
//	
//
//	
//	
//	public boolean add(Object o) {
//		// get connection from db
//		Connection cnt = connection.getConnection();
//
//		// create a query
//		String query = "INSERT INTO " + Task.TABLE + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			// create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//
//			// prepare the values
//			ps.setInt(1, Types.NULL); // because id is auto-increment anyway
//			ps.setString(2, ((Task) o).getName());
//			ps.setDate(3, ((Task) o).getDate());
//			ps.setTime(4, ((Task) o).getStart());
//			ps.setTime(5, ((Task) o).getEnd());
//			ps.setBoolean(6, ((Task) o).isCompleted());
//			ps.setBoolean(7, ((Task) o).isDeleted());
//	
//
//			// execute the update
//			ps.executeUpdate();
//
//			// close resources
//			ps.close();
//			cnt.close();
//			System.out.println("[Task] INSERT SUCCESS");
//			return true;
//		} catch (SQLException e) {
//			System.out.println("[Task] INSERT FAILED");
//			e.printStackTrace();
//			return false;
//		}
//	}
//	
//	public void update(Object o) {
//		// get connection from db
//		Connection cnt = connection.getConnection();
//
//		// create a query
//		String query = "UPDATE " + Task.TABLE + " SET " + Task.COL_NAME + " = ?," + Task.COL_DATE
//				+ " = ?," + Task.COL_START + " = ?," + Task.COL_END + " = ?," + Task.COL_COMPLETED
//				+ " = ?," + Task.COL_DELETED + " = ?" + " WHERE "
//				+ Task.COL_ID + " = ?";
//
//		try {
//			// create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//
//			// prepare the values
//			ps.setInt(7, ((Task) o).getId()); // because id is auto-increment anyway
//			ps.setString(1, ((Task) o).getName());
//			ps.setDate(2, ((Task) o).getDate());
//			ps.setTime(3, ((Task) o).getStart());
//			ps.setTime(4, ((Task) o).getEnd());
//			ps.setBoolean(5, ((Task) o).isCompleted());
//			ps.setBoolean(6, ((Task) o).isDeleted());
//
//			// execute the update
//			ps.executeUpdate();
//
//			// close resources
//			ps.close();
//			cnt.close();
//			System.out.println("[Task] UPDATE SUCCESS");
//		} catch (SQLException e) {
//			System.out.println("[Task] UPDATE FAILED");
//			e.printStackTrace();
//		}
//	}
//	
//	public void delete(int id) {
//		// get connection from db
//		Connection cnt = connection.getConnection();
//
//		// create a query
//		String query = "DELETE FROM " + Task.TABLE + " WHERE " + Task.COL_ID + " = ?";
//
//		try {
//			// create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//
//			// prepare the values
//			ps.setInt(1, id); // gets the first question mark and sets it to id
//
//			// execute the update
//			ps.executeUpdate();
//
//			// close resources
//			ps.close();
//			cnt.close();
//			System.out.println("[Task] DELETE SUCCESS");
//		} catch (SQLException e) {
//			System.out.println("[Task] DELETE FAILED");
//			e.printStackTrace();
//		}
//	}
//	
//	public Task getTask(int id) {
//		Task Task = null ;
//
//		// get connection from db
//		Connection cnt = connection.getConnection();
//
//		// create string query
//		String query = "SELECT * FROM " + Task.TABLE + " WHERE " + Task.COL_ID + " = ?";
//
//		try {
//			// create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//
//			ps.setInt(1, id);
//
//			// get result and store in result set
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				Task = toObject(rs);
//			}
//
//			// close all the resources
//			ps.close();
//			rs.close();
//			cnt.close();
//
//			System.out.println("[Task] SELECT SUCCESS!");
//		} catch (SQLException e) {
//			System.out.println("[Task] SELECT FAILED!");
//			e.printStackTrace();
//		}
//
//		// return list
//		return Task;
//	}
//	
//	private Task toObject(ResultSet rs) throws SQLException { 
//		Task task = new Task(rs.getInt(Task.COL_ID),rs.getString(Task.COL_NAME),rs.getDate(Task.COL_DATE),rs.getTime(Task.COL_START),rs.getBoolean(Task.COL_COMPLETED),rs.getBoolean(Task.COL_DELETED),rs.getInt(Task.COL_COLOR));
//		return task;
//	}
////	public static void main(String[] args) {
////		TaskConnection service = new TaskConnection(new SchedDb());
////		 service.readAll();
////		 ArrayList<Task> tasks = service.getTasks();
////		
//////		Task Task = service.getTask(1);
//////
////		for (Task r : tasks) {
////			r.ToString();
////			System.out.println("");
////		}
//////		Task.ToString();
////	} 
//
//
//
//
//}
