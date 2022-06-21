package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.*;
import Model.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	private JPanel contentPane;
	private JTextField editClinicNameField;
	private static Clinic clinic;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
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
	public UpdateClinicGUI(Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 168, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton edit_clinic = new JButton("Edit");
		edit_clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					try {
						clinic.updateClinic(clinic.getId(), editClinicNameField.getText());
						Helper.showMsg("success");
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		edit_clinic.setBounds(6, 67, 156, 35);
		contentPane.add(edit_clinic);
		
		editClinicNameField = new JTextField();
		editClinicNameField.setText("");
		editClinicNameField.setColumns(10);
		editClinicNameField.setBounds(6, 31, 156, 35);
		editClinicNameField.setText(clinic.getName());
		contentPane.add(editClinicNameField);
		
		JLabel lblClinicName = new JLabel("Clinic Name");
		lblClinicName.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblClinicName.setBounds(42, 6, 94, 28);
		contentPane.add(lblClinicName);
	}
}
