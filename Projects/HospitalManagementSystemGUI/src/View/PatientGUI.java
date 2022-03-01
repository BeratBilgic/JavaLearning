package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.*;
import Model.*;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PatientGUI extends JFrame {

	private JPanel contentPane;
	private static Patient patient = new Patient();
	private Clinic clinic = new Clinic();
	private JTable table_doc;
	private DefaultTableModel doctorModel;
	private Object[] doctorData = null;
	private JTable table_whour;
	private Whour whour = new Whour();
	private DefaultTableModel whourModel;
	private Object[] whourData = null;
	private int selectDocId = 0;
	private String selectDocName = null;
	private JTable table_appoint;
	private DefaultTableModel appointModel;
	private Object[] appointData = null;
	private Appointment appoint = new Appointment();
	private JPopupMenu appointMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientGUI frame = new PatientGUI(patient);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public PatientGUI(Patient patient) throws SQLException {

		doctorModel = new DefaultTableModel();
		Object[] colDoctor = new Object[2];
		colDoctor[0] = "ID";
		colDoctor[1] = "Name Surname";
		doctorModel.setColumnIdentifiers(colDoctor);
		doctorData = new Object[2];

		whourModel = new DefaultTableModel();
		Object[] colWhour = new Object[2];
		colWhour[0] = "ID";
		colWhour[1] = "Date";
		whourModel.setColumnIdentifiers(colWhour);
		whourData = new Object[2];

		appointModel = new DefaultTableModel();
		Object[] colAppoint = new Object[3];
		colAppoint[0] = "ID";
		colAppoint[1] = "Doctor";
		colAppoint[2] = "Date";
		appointModel.setColumnIdentifiers(colAppoint);
		appointData = new Object[3];
		for (int i = 0; i < appoint.getPatientList(patient.getId()).size(); i++) {
			appointData[0] = appoint.getPatientList(patient.getId()).get(i).getId();
			appointData[1] = appoint.getPatientList(patient.getId()).get(i).getDoctor_name();
			appointData[2] = appoint.getPatientList(patient.getId()).get(i).getApp_date();
			appointModel.addRow(appointData);
		}

		setResizable(false);
		setTitle("Hospital Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome " + patient.getName());
		lblNewLabel.setBounds(144, 15, 224, 34);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("<");
		btnNewButton.setBounds(22, 20, 51, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 61, 710, 392);
		contentPane.add(tabbedPane);

		JPanel Appointment_panel = new JPanel();
		tabbedPane.addTab("Appointment system", null, Appointment_panel, null);
		Appointment_panel.setLayout(null);

		JScrollPane scrollDoc = new JScrollPane();
		scrollDoc.setBounds(6, 35, 256, 305);
		Appointment_panel.add(scrollDoc);

		table_doc = new JTable(doctorModel);
		scrollDoc.setViewportView(table_doc);
		table_doc.getColumnModel().getColumn(0).setPreferredWidth(3);

		JLabel lblNewLabel_1 = new JLabel("Doctor List");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(6, 14, 148, 16);
		Appointment_panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Clinic name");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(283, 41, 110, 16);
		Appointment_panel.add(lblNewLabel_2);

		JComboBox select_clinic = new JComboBox();
		select_clinic.setBounds(262, 62, 148, 28);
		select_clinic.addItem("Select Clinic");
		for (int i = 0; i < clinic.getClinicList().size(); i++) {
			select_clinic
					.addItem(new Item(clinic.getClinicList().get(i).getId(), clinic.getClinicList().get(i).getName()));
		}
		select_clinic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (select_clinic.getSelectedIndex() != 0) {
					JComboBox c = (JComboBox) e.getSource();
					Item item = (Item) c.getSelectedItem();
					DefaultTableModel clearModel = (DefaultTableModel) table_doc.getModel();
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < clinic.getClinicDoctorList(item.getKey()).size(); i++) {
							doctorData[0] = clinic.getClinicDoctorList(item.getKey()).get(i).getId();
							doctorData[1] = clinic.getClinicDoctorList(item.getKey()).get(i).getName();
							doctorModel.addRow(doctorData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					DefaultTableModel clearModel = (DefaultTableModel) table_doc.getModel();
					clearModel.setRowCount(0);
				}
			}

		});
		Appointment_panel.add(select_clinic);

		JLabel lblClinicName_1 = new JLabel("Select Doctor");
		lblClinicName_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblClinicName_1.setBounds(283, 133, 110, 24);
		Appointment_panel.add(lblClinicName_1);

		JButton workerSelect = new JButton("Select");
		workerSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_doc.getSelectedRow();
				if (row >= 0) {
					String id = table_doc.getModel().getValueAt(row, 0).toString();
					int selId = Integer.parseInt(id);
					DefaultTableModel clearModel = (DefaultTableModel) table_whour.getModel();
					clearModel.setRowCount(0);

					try {
						for (int i = 0; i < whour.getWhourList(selId).size(); i++) {
							whourData[0] = whour.getWhourList(selId).get(i).getId();
							whourData[1] = whour.getWhourList(selId).get(i).getWdate();
							whourModel.addRow(whourData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table_whour.setModel(whourModel);
					selectDocId = selId;
					selectDocName = table_doc.getModel().getValueAt(row, 1).toString();

				} else {
					Helper.showMsg("Please select a doctor");
				}
			}
		});
		workerSelect.setBounds(262, 160, 148, 35);
		Appointment_panel.add(workerSelect);

		JLabel lblNewLabel_1_1 = new JLabel("Doctor List");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(6, 15, 148, 16);
		Appointment_panel.add(lblNewLabel_1_1);

		JScrollPane scrollWhour = new JScrollPane();
		scrollWhour.setBounds(410, 35, 273, 305);
		Appointment_panel.add(scrollWhour);

		table_whour = new JTable(whourModel);
		scrollWhour.setViewportView(table_whour);
		table_whour.getColumnModel().getColumn(0).setPreferredWidth(3);

		JLabel lblNewLabel_1_2 = new JLabel("Working hours");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(416, 14, 180, 16);
		Appointment_panel.add(lblNewLabel_1_2);

		JButton btnMakeAppoint = new JButton("Make an appointment");
		btnMakeAppoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = table_whour.getSelectedRow();
				if (selRow >= 0) {
					String date = table_whour.getModel().getValueAt(selRow, 1).toString();
					try {
						boolean control = patient.addAppointment(selectDocId, patient.getId(), selectDocName,
								patient.getName(), date);
						if (control) {
							Helper.showMsg("success");
							patient.updateWhourStatus(selectDocId, date);
							updateWhourModel(selectDocId);
							updateAppointModel(patient.getId());
						} else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					Helper.showMsg("Please enter a valid date");
				}
			}
		});
		btnMakeAppoint.setBounds(262, 272, 148, 44);
		Appointment_panel.add(btnMakeAppoint);

		JLabel lblClinicName_1_1 = new JLabel("Make an appointment");
		lblClinicName_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblClinicName_1_1.setBounds(268, 245, 136, 24);
		Appointment_panel.add(lblClinicName_1_1);

		JPanel myAppointments_panel = new JPanel();
		tabbedPane.addTab("My appointments", null, myAppointments_panel, null);
		myAppointments_panel.setLayout(null);

		JScrollPane scroll_appoint = new JScrollPane();
		scroll_appoint.setBounds(6, 6, 677, 334);
		myAppointments_panel.add(scroll_appoint);

		appointMenu = new JPopupMenu();
		JMenuItem deleteMenu = new JMenuItem("Delete");
		appointMenu.add(deleteMenu);

		deleteMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirm("sure")) {
					try {
						String selDate = (String) table_appoint.getValueAt(table_appoint.getSelectedRow(), 2);
						int selId = Integer.parseInt(table_appoint.getValueAt(table_appoint.getSelectedRow(), 0).toString());
						if (patient.deleteAppointment(selectDocId, selDate)) {
							Helper.showMsg("success");
							updateWhourModel(selectDocId);
							updateAppointModel(patient.getId());
						} else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

		table_appoint = new JTable(appointModel);
		table_appoint.setComponentPopupMenu(appointMenu);
		table_appoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Point point = e.getPoint();
				int selectedRow = table_appoint.rowAtPoint(point);
				table_appoint.setRowSelectionInterval(selectedRow, selectedRow);
			}
		});
		scroll_appoint.setViewportView(table_appoint);
	}

	public void updateWhourModel(int doctor_id) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_whour.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < whour.getWhourList(doctor_id).size(); i++) {
			whourData[0] = whour.getWhourList(doctor_id).get(i).getId();
			whourData[1] = whour.getWhourList(doctor_id).get(i).getWdate();
			whourModel.addRow(whourData);
		}
	}

	public void updateAppointModel(int patient_id) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_appoint.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < appoint.getPatientList(patient_id).size(); i++) {
			appointData[0] = appoint.getPatientList(patient_id).get(i).getId();
			appointData[1] = appoint.getPatientList(patient_id).get(i).getDoctor_name();
			appointData[2] = appoint.getPatientList(patient_id).get(i).getApp_date();
			appointModel.addRow(appointData);
		}
	}
}
