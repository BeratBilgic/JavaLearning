package Helper;
import java.sql.*;

public class DBconnection {
	Connection c = null;
	String url = "jdbc:sqlite:/Users/beratbilgic/Desktop/GitHub/JavaOOP/Projects/HospitalManagementSystemGUI/database/hospital.db";
	
	public DBconnection() {
	}
	
	public Connection connDB() {
		try {
			this.c = DriverManager.getConnection(url);
			System.out.println("database connected");
			return c;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
