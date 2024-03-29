package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import Helper.*;
import Model.*;

import java.sql.*;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField TcNoField;
	private JTextField TcNoField_doc;
	private JPasswordField passField_doc;
	private JPasswordField passField;
	DBconnection conn = new DBconnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelIcon = new JLabel(new ImageIcon("medicine-icon.png"));
		labelIcon.setBounds(207, 16, 82, 69);
		contentPane.add(labelIcon);

		JLabel lblNewLabel = new JLabel("WELCOME TO THE HOSPITAL MANAGEMENT SYSTEM");
		lblNewLabel.setBounds(52, 97, 398, 24);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(17, 123, 464, 231);
		contentPane.add(tabbedPane);

		JPanel patient_panel = new JPanel();
		patient_panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Patient Login", null, patient_panel, null);
		patient_panel.setLayout(null);

		JLabel TcNo = new JLabel("T.C. Number : ");
		TcNo.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		TcNo.setBounds(102, 41, 108, 20);
		patient_panel.add(TcNo);

		JLabel Password = new JLabel("Password : ");
		Password.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		Password.setBounds(123, 73, 87, 20);
		patient_panel.add(Password);

		TcNoField = new JTextField();
		TcNoField.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		TcNoField.setBounds(209, 35, 174, 26);
		patient_panel.add(TcNoField);
		TcNoField.setColumns(10);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TcNoField.getText().length() == 0 || passField.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					boolean key = true;
					try {
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (TcNoField.getText().equals(rs.getString("tcno")) && passField.getText().equals(rs.getString("password"))) {
								Patient patient = new Patient();
								patient.setId(rs.getInt("id"));
								patient.setPassword("password");
								patient.setTcno(rs.getString("tcno"));
								patient.setName(rs.getString("name"));
								patient.setType(rs.getInt("type"));
								System.out.println(patient.getName());
								PatientGUI patientGUI = new PatientGUI(patient);
								patientGUI.setVisible(true);
								key = false;
								dispose();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(key) {
						Helper.showMsg("Patient not found, please register");
					}
				}
			}
		});
		btnSignIn.setBounds(222, 118, 131, 35);
		patient_panel.add(btnSignIn);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterGUI registerGUI = new RegisterGUI();
				registerGUI.setVisible(true);
				dispose();
			}
		});
		btnRegister.setBounds(88, 118, 131, 35);
		patient_panel.add(btnRegister);

		passField = new JPasswordField();
		passField.setBounds(209, 67, 174, 33);
		patient_panel.add(passField);

		JPanel doctor_panel = new JPanel();
		doctor_panel.setBackground(Color.WHITE);
		doctor_panel.setForeground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Doctor Login", null, doctor_panel, null);
		doctor_panel.setLayout(null);

		JLabel TcNo_doc = new JLabel("T.C. Number : ");
		TcNo_doc.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		TcNo_doc.setBounds(102, 41, 108, 20);
		doctor_panel.add(TcNo_doc);

		JLabel Password_doc = new JLabel("Password : ");
		Password_doc.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		Password_doc.setBounds(123, 73, 87, 20);
		doctor_panel.add(Password_doc);

		TcNoField_doc = new JTextField();
		TcNoField_doc.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		TcNoField_doc.setColumns(10);
		TcNoField_doc.setBounds(209, 35, 174, 26);
		doctor_panel.add(TcNoField_doc);

		JButton btnSignIn_doc = new JButton("Sign in");
		btnSignIn_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TcNoField_doc.getText().length() == 0 || passField_doc.getText().length() == 0) {
					Helper.showMsg("fill");
				} else {
					boolean key = true;
					try {
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) {
							if (TcNoField_doc.getText().equals(rs.getString("tcno")) && passField_doc.getText().equals(rs.getString("password"))) {
								if (rs.getInt("type") == 3) {
									Director director = new Director();
									director.setId(rs.getInt("id"));
									director.setPassword("password");
									director.setTcno(rs.getString("tcno"));
									director.setName(rs.getString("name"));
									director.setType(rs.getInt("type"));
									System.out.println(director.getName());
									DirectorGUI directorGUI = new DirectorGUI(director);
									directorGUI.setVisible(true);
									key = false;
									dispose();
								} else if (rs.getInt("type") == 2) {
									Doctor doctor = new Doctor();
									doctor.setId(rs.getInt("id"));
									doctor.setPassword("password");
									doctor.setTcno(rs.getString("tcno"));
									doctor.setName(rs.getString("name"));
									doctor.setType(rs.getInt("type"));
									System.out.println(doctor.getName());
									DoctorGUI doctorGUI = new DoctorGUI(doctor);
									doctorGUI.setVisible(true);
									key = false;
									dispose();
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(key) {
						Helper.showMsg("Patient not found, please register");
					}
				}
			}
		});
		btnSignIn_doc.setBounds(222, 118, 131, 35);
		doctor_panel.add(btnSignIn_doc);

		passField_doc = new JPasswordField();
		passField_doc.setBounds(209, 67, 174, 33);
		doctor_panel.add(passField_doc);

	}
}
