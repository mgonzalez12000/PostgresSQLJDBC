package cs4222Project;
import java.sql.*;

public class ConnectDataBase  {

	static final String DB_URL = "jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s80";
	static final String USER = "cs4222s80";
	static final String PASS = "ViIb6GWA";
//	static final String QUERY = "SELECT sid, pid, cost FROM catalog";

	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			
			if (connection != null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("No connection");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}