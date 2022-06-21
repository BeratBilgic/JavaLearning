package Model;

import Helper.*;

public class User {
	private int id,type;
	private String tcno,name,password;
	DBconnection conn = new DBconnection();
	
	public User(int id, int type, String tcno, String name, String password) {
		this.id = id;
		this.type = type;
		this.tcno = tcno;
		this.name = name;
		this.password = password;
	}
	
	public User() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
