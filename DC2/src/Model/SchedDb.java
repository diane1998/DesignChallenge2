package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class SchedDb {
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://127.0.0.1:3306/";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String DATABASE = "productivity";
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(
					URL +
					DATABASE + "?autoReconnect=true&useSSL=false", 
					USERNAME,
					PASSWORD);
			System.out.println("[MYSQL] Connection successful");
			return connection;
		} catch (SQLException e) {
			System.out.println("[MYSQL] Connection failed!");
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("[MYSQL] Connection failed!");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main (String[] args) {
		SchedDb db = new SchedDb();
		db.getConnection();
	}
}
