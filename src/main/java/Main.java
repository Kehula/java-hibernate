import java.sql.*;

/**
 * @author kehul on 06.08.2020
 */
public class Main {
	
	public static void main(String[] args) {
		System.out.println("Testing connection...");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "sysdba", "masterkey");
			if (!con.isClosed()) {
				System.out.println("Connection opened!");
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from test_table");
				while (rs.next()) {
					System.out.println(String.format("|%10d|%20s|", rs.getInt(1), rs.getString(2)));
				}
			}
			System.out.println("Closing connection");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
