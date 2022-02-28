package Model;

import java.sql.*;
import java.util.ArrayList;

import Helper.DBconnection;

public class Clinic {
	private int id;
	private String name;
	
	DBconnection conn = new DBconnection();
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	public Clinic(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Clinic () {}
	
	public ArrayList<Clinic> getClinicList() throws SQLException{
		ArrayList<Clinic> list = new ArrayList<>();
		Clinic obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");
			while(rs.next()) {
				obj = new Clinic();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean addClinic(String name) throws SQLException {
		String query = "INSERT INTO clinic(name) VALUES (?)";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(key == true)
			return true;
		else
			return false;
	}
	
	public boolean deleteClinic(int id) throws SQLException {
		String query = "DELETE FROM clinic WHERE id = ?";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(key == true)
			return true;
		else
			return false;
	}
	
	public Clinic getFetch(int id) {
		Clinic c = new Clinic();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic WHERE id =" + id);
			while(rs.next()) {
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	public boolean updateClinic(int id, String name) throws SQLException {
		String query = "UPDATE clinic SET name=? WHERE id=?";
		boolean key = false;
		
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(key == true)
			return true;
		else
			return false;
	}
	
	public ArrayList<User> getClinicDoctorList(int clinic_id) throws SQLException {
		ArrayList<User> list = new ArrayList<>();
		User obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT u.id,u.tcno,u.password,u.name,u.type FROM worker w LEFT JOIN user u ON w.user_id=u.id WHERE clinic_id= "+ clinic_id);
			while(rs.next()) {
				obj = new User(rs.getInt("id"),rs.getInt("type"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
