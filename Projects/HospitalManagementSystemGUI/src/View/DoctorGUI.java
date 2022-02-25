package View;

import Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;

public class DoctorGUI extends JFrame {

	private JPanel contentPane;
	private static Doctor doctor = new Doctor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorGUI frame = new DoctorGUI(doctor);
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
	public DoctorGUI(Doctor doctor) {
		setTitle("Hospital Management System");
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + doctor.getName());
		lblNewLabel.setBounds(144, 15, 224, 34);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(22, 20, 51, 29);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 61, 710, 392);
		contentPane.add(tabbedPane);
		
		JPanel wHour_panel = new JPanel();
		tabbedPane.addTab("New tab", null, wHour_panel, null);
		wHour_panel.setLayout(null);
	}
}
