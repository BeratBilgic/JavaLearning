package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBconnection;

public class Appointment {
	private int id, doctor_id, patient_id;
	private String doctor_name, patient_name, app_date;
	DBconnection conn = new DBconnection();
	Connection con = conn.connDB();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;
	
	
	
	public Appointment(int id, int doctor_id, int patient_id, String doctor_name, String patient_name, String app_date) {
		this.id = id;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.doctor_name = doctor_name;
		this.patient_name = patient_name;
		this.app_date = app_date;
	}
	
	public Appointment() {}
	
	public ArrayList<Appointment> getPatientList(int patient_id) throws SQLException{
		ArrayList<Appointment> list = new ArrayList<>();
		Appointment obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE patient_id = " + patient_id);
			while(rs.next()) {
				obj = new Appointment();
				obj.setId(rs.getInt("id"));
				obj.setDoctor_id(rs.getInt("doctor_id"));
				obj.setDoctor_name(rs.getString("doctor_name"));
				obj.setPatient_id(rs.getInt("patient_id"));
				obj.setPatient_name(rs.getString("patient_name"));
				obj.setApp_date(rs.getString("app_date"));
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
	
	public ArrayList<Appointment> getDoctorList(int doctor_id) throws SQLException{
		ArrayList<Appointment> list = new ArrayList<>();
		Appointment obj;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM appointment WHERE doctor_id = " + doctor_id);
			while(rs.next()) {
				obj = new Appointment();
				obj.setId(rs.getInt("id"));
				obj.setDoctor_id(rs.getInt("doctor_id"));
				obj.setDoctor_name(rs.getString("doctor_name"));
				obj.setPatient_id(rs.getInt("patient_id"));
				obj.setPatient_name(rs.getString("patient_name"));
				obj.setApp_date(rs.getString("app_date"));
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getApp_date() {
		return app_date;
	}
	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}
}
