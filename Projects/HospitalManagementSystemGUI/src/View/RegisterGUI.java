package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.*;
import Model.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField namesur;
	private JTextField tcno;
	private JTextField passw;
	private Patient patient = new Patient();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_name = new JLabel("Name Surname");
		lblNewLabel_name.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_name.setBounds(34, 17, 135, 24);
		contentPane.add(lblNewLabel_name);
		
		JLabel lblNewLabel_tcno = new JLabel("TC Number");
		lblNewLabel_tcno.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_tcno.setBounds(34, 78, 91, 24);
		contentPane.add(lblNewLabel_tcno);
		
		JLabel lblNewLabel_pass = new JLabel("Password");
		lblNewLabel_pass.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_pass.setBounds(34, 138, 91, 24);
		contentPane.add(lblNewLabel_pass);
		
		namesur = new JTextField();
		namesur.setColumns(10);
		namesur.setBounds(23, 42, 254, 35);
		contentPane.add(namesur);
		
		tcno = new JTextField();
		tcno.setColumns(10);
		tcno.setBounds(23, 104, 254, 35);
		contentPane.add(tcno);
		
		passw = new JTextField();
		passw.setColumns(10);
		passw.setBounds(23, 161, 254, 35);
		contentPane.add(passw);
		
		JButton btn_register = new JButton("Register");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tcno.getText().length() == 0 || namesur.getText().length() == 0 || passw.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = patient.register(tcno.getText(), passw.getText(), namesur.getText());
						if(control) {
							Helper.showMsg("success");
							LoginGUI login = new LoginGUI();
							login.setVisible(true);
							dispose();
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_register.setBounds(34, 214, 223, 41);
		contentPane.add(btn_register);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btn_back.setBounds(34, 261, 223, 41);
		contentPane.add(btn_back);
	}
}
