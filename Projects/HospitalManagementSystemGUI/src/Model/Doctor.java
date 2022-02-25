package Model;

import java.sql.*;

public class Doctor extends User{
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public Doctor(int id, int type, String tcno, String name, String password) {
		super(id, type, tcno, name, password);
	}
	
	public Doctor() {}
	
	public boolean addWhour(int doctor_id, String doctor_name, String wdate) throws SQLException {
		boolean key = false;
		int count = 0;
		String query = "INSERT INTO whour (doctor_id,doctor_name,wdate) VALUES + (?,?,?)";
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM whour WHERE status=1 AND doctor_id = " + doctor_id + "AND wdate = '"+wdate+"'");
			
			while(rs.next()) {
				count++;
				break;
			}
			
			if(count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, doctor_id);
				preparedStatement.setString(2, doctor_name);
				preparedStatement.setString(3, wdate);
				preparedStatement.executeUpdate();
			}
			key = true;
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
