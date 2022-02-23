import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tFieldTcNumber;
	private JTextField tFieldPassword;
	private JTextField tfTcNumber_doc;
	private JTextField tfPassword_doc;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelIcon = new JLabel(new ImageIcon(getClass().getResource("medicine-icon.png")));
		labelIcon.setBounds(207, 16, 82, 69);
		contentPane.add(labelIcon);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE HOSPITAL MANAGEMENT SYSTEM");
		lblNewLabel.setBounds(66, 97, 373, 24);
		lblNewLabel.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(17, 123, 464, 231);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Patient Login", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblTcNumber = new JLabel("T.C. Number : ");
		lblTcNumber.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
		lblTcNumber.setBounds(102, 41, 108, 20);
		panel.add(lblTcNumber);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
		lblPassword.setBounds(122, 73, 88, 20);
		panel.add(lblPassword);
		
		tFieldTcNumber = new JTextField();
		tFieldTcNumber.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		tFieldTcNumber.setBounds(209, 35, 174, 26);
		panel.add(tFieldTcNumber);
		tFieldTcNumber.setColumns(10);
		
		tFieldPassword = new JTextField();
		tFieldPassword.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		tFieldPassword.setColumns(10);
		tFieldPassword.setBounds(209, 67, 174, 26);
		panel.add(tFieldPassword);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setBounds(222, 118, 131, 35);
		panel.add(btnSignIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(88, 118, 131, 35);
		panel.add(btnRegister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Doctor Login", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTcNumber_doc = new JLabel("T.C. Number : ");
		lblTcNumber_doc.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
		lblTcNumber_doc.setBounds(98, 36, 108, 20);
		panel_1.add(lblTcNumber_doc);
		
		JLabel lblPassword_doc = new JLabel("Password : ");
		lblPassword_doc.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 16));
		lblPassword_doc.setBounds(118, 68, 88, 20);
		panel_1.add(lblPassword_doc);
		
		tfTcNumber_doc = new JTextField();
		tfTcNumber_doc.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		tfTcNumber_doc.setColumns(10);
		tfTcNumber_doc.setBounds(205, 30, 174, 26);
		panel_1.add(tfTcNumber_doc);
		
		tfPassword_doc = new JTextField();
		tfPassword_doc.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		tfPassword_doc.setColumns(10);
		tfPassword_doc.setBounds(205, 62, 174, 26);
		panel_1.add(tfPassword_doc);
		
		JButton btnSignIn_doc = new JButton("Sign in");
		btnSignIn_doc.setBounds(218, 113, 131, 35);
		panel_1.add(btnSignIn_doc);
		
	}
}
