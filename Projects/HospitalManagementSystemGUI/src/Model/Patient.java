package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.*;

public class Patient extends User {
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Patient(int id, int type, String tcno, String name, String password) {
		super(id, type, tcno, name, password);
	}
	
	public Patient() {}
	
	public boolean register(String tcno, String password, String name) throws SQLException {
		boolean key = false, duplicate = false;
		String query = "INSERT INTO user (tcno,password,name,type) VALUES (?,?,?,?)";
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE tcno = '" + tcno + "'");
			
			while(rs.next()) {
				Helper.showMsg("There is a register of this tc number");
				duplicate = true;
				break;
			}
			
			if(!duplicate) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, tcno);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, name);
				preparedStatement.setInt(4, 1);
				preparedStatement.executeUpdate();
				key = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key == true)
			return true;
		else
			return false;
	}
}
