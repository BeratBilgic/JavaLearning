package View;

import Model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DirectorGUI extends JFrame {

	private JPanel contentPane;
	private static Director director = new Director();
	Clinic clinic = new Clinic();
	private JTextField nameSur;
	private JTextField tcno;
	private JTextField passw;
	private JTextField id;
	private JTable doc_table;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTable table_clinic;
	private JTextField clinicNameField;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;
	private JPopupMenu clinicMenu;
	private DefaultTableModel workerModel = null;
	private Object[] workerData = null;
	private JTable table_worker;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectorGUI frame = new DirectorGUI(director);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DirectorGUI(Director director) throws SQLException {
		
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Name Surname";
		colDoctorName[2] = "TC Number";
		colDoctorName[3] = "Password";
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for(int i = 0; i < director.getDoctorList().size(); i++) {
			doctorData[0] = director.getDoctorList().get(i).getId();
			doctorData[1] = director.getDoctorList().get(i).getName();
			doctorData[2] = director.getDoctorList().get(i).getTcno();
			doctorData[3] = director.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		
		clinicModel = new DefaultTableModel();
		Object[] colClinicName = new Object[2];
		colClinicName[0] = "ID";
		colClinicName[1] = "Clinic name";
		clinicModel.setColumnIdentifiers(colClinicName);
		clinicData = new Object[2];
		for(int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
		
		workerModel = new DefaultTableModel();
		Object[] colWorker = new Object[2];
		colWorker[0] = "ID";
		colWorker[1] = "Name Surname";
		workerModel.setColumnIdentifiers(colWorker);
		workerData = new Object[2];
		
		setTitle("Hospital Management System");
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome " + director.getName());
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
		
		JPanel doc_mang_panel = new JPanel();
		doc_mang_panel.setBackground(UIManager.getColor("List.selectionInactiveBackground"));
		tabbedPane.addTab("Doctor Management", null, doc_mang_panel, null);
		doc_mang_panel.setLayout(null);
		
		JLabel lblNewLabel_name = new JLabel("Name Surname");
		lblNewLabel_name.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblNewLabel_name.setBounds(512, 6, 117, 24);
		doc_mang_panel.add(lblNewLabel_name);
		
		JLabel lblNewLabel_tcno = new JLabel("TC Number");
		lblNewLabel_tcno.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblNewLabel_tcno.setBounds(512, 72, 91, 24);
		doc_mang_panel.add(lblNewLabel_tcno);
		
		JLabel lblNewLabel_pass = new JLabel("Password");
		lblNewLabel_pass.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblNewLabel_pass.setBounds(512, 128, 91, 24);
		doc_mang_panel.add(lblNewLabel_pass);
		
		JLabel lblNewLabel_id = new JLabel("User ID");
		lblNewLabel_id.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblNewLabel_id.setBounds(512, 234, 61, 16);
		doc_mang_panel.add(lblNewLabel_id);
		
		nameSur = new JTextField();
		nameSur.setBounds(512, 31, 172, 35);
		doc_mang_panel.add(nameSur);
		nameSur.setColumns(10);
		
		tcno = new JTextField();
		tcno.setBounds(512, 93, 171, 35);
		doc_mang_panel.add(tcno);
		tcno.setColumns(10);
		
		passw = new JTextField();
		passw.setBounds(512, 148, 171, 35);
		doc_mang_panel.add(passw);
		passw.setColumns(10);
		
		id = new JTextField();
		id.setBounds(512, 251, 171, 35);
		doc_mang_panel.add(id);
		id.setColumns(10);
		
		JButton add_doc = new JButton("Add");
		add_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameSur.getText().length() == 0 || passw.getText().length() == 0 || tcno.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = director.addDoctor(tcno.getText(), passw.getText(), nameSur.getText());
						if(control) {
							Helper.showMsg("success");
							updateDoctorModel();
							tcno.setText(null);
							passw.setText(null);
							nameSur.setText(null);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add_doc.setBounds(535, 187, 126, 35);
		doc_mang_panel.add(add_doc);
		
		JButton delete_doc = new JButton("Delete");
		delete_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().length() == 0) {
					Helper.showMsg("choose doctor");
				}else {
					if(Helper.confirm("sure")){
						int intId = Integer.parseInt(id.getText());
						try {
							Boolean control = director.deleteDoctor(intId);
							if(control) {
								Helper.showMsg("success");
								id.setText(null);
								updateDoctorModel();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		delete_doc.setBounds(535, 287, 126, 35);
		doc_mang_panel.add(delete_doc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 494, 327);
		doc_mang_panel.add(scrollPane);
		
		doc_table = new JTable(doctorModel);
		scrollPane.setViewportView(doc_table);
		
		doc_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					id.setText(doc_table.getValueAt(doc_table.getSelectedRow(), 0).toString());
				}catch(Exception ex) {
					
				}
			}});
		
		doc_table.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType() == TableModelEvent.UPDATE) {
					int selectedID = Integer.parseInt(doc_table.getValueAt(doc_table.getSelectedRow(), 0).toString());
					String selectedName = doc_table.getValueAt(doc_table.getSelectedRow(), 1).toString();
					String selectedTCno = doc_table.getValueAt(doc_table.getSelectedRow(), 2).toString();
					String selectedPassword = doc_table.getValueAt(doc_table.getSelectedRow(), 3).toString();
					try {
						director.updateDoctor(selectedID, selectedTCno, selectedPassword, selectedName);
					} catch (SQLException e1) {	
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		JPanel clinic_panel = new JPanel();
		clinic_panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Clinics", null, clinic_panel, null);
		clinic_panel.setLayout(null);
		
		JScrollPane scrollClinic = new JScrollPane();
		scrollClinic.setBounds(6, 6, 249, 334);
		clinic_panel.add(scrollClinic);
		
		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("Update");
		JMenuItem deleteMenu = new JMenuItem("Delete");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);
		
		updateMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(),0).toString());
				Clinic selectClinic = clinic.getFetch(selID);
				UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectClinic);
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
				updateGUI.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		
		deleteMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure"));
				int selID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(),0).toString());
				try {
					if(clinic.deleteClinic(selID)) {
						Helper.showMsg("success");
						updateClinicModel();
					}else {
						Helper.showMsg("error");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
			
		
		table_clinic = new JTable(clinicModel);
		table_clinic.setComponentPopupMenu(clinicMenu);
		table_clinic.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Point point = e.getPoint();
				int selectedRow = table_clinic.rowAtPoint(point);
				table_clinic.setRowSelectionInterval(selectedRow, selectedRow);
			}
		});
		scrollClinic.setViewportView(table_clinic);
		
		clinicNameField = new JTextField();
		clinicNameField.setColumns(10);
		clinicNameField.setBounds(261, 52, 140, 35);
		clinic_panel.add(clinicNameField);
		
		JLabel lblClinicName = new JLabel("Clinic Name");
		lblClinicName.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblClinicName.setBounds(280, 29, 89, 24);
		clinic_panel.add(lblClinicName);
		
		JButton add_clinic = new JButton("Add");
		add_clinic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clinicNameField.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						if(clinic.addClinic(clinicNameField.getText())) {
							Helper.showMsg("success");
							updateClinicModel();
							clinicNameField.setText(null);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		add_clinic.setBounds(261, 86, 140, 35);
		clinic_panel.add(add_clinic);
		
		JScrollPane scrollWorker = new JScrollPane();
		scrollWorker.setBounds(407, 6, 276, 334);
		clinic_panel.add(scrollWorker);
		
		table_worker = new JTable();
		scrollWorker.setViewportView(table_worker);
		
		JComboBox select_doc = new JComboBox();
		select_doc.setBounds(257, 245, 150, 41);
		for(int i = 0; i < director.getDoctorList().size(); i++) {
			select_doc.addItem(new Item(director.getDoctorList().get(i).getId(), director.getDoctorList().get(i).getName()));
		}
		select_doc.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
		});
		clinic_panel.add(select_doc);
		
		JButton add_worker = new JButton("Add");
		add_worker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = table_clinic.getSelectedRow();
				if(selRow >= 0) {
					String selClinic = table_clinic.getModel().getValueAt(selRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					Item doctorItem = (Item) select_doc.getSelectedItem();
					try {
						boolean control = director.addWorker(doctorItem.getKey(),selClinicID);
						if(control) {
							Helper.showMsg("success");
							DefaultTableModel clearModel = (DefaultTableModel) table_worker.getModel();
							clearModel.setRowCount(0);
							for(int i=0; i < director.getClinicDoctorList(selClinicID).size(); i++){
								workerData[0] = director.getClinicDoctorList(selClinicID).get(i).getId();
								workerData[1] = director.getClinicDoctorList(selClinicID).get(i).getName();
								workerModel.addRow(workerData);		
							}
							table_worker.setModel(workerModel);
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					Helper.showMsg("Please select an clinic");
				}
			}
		});
		add_worker.setBounds(261, 281, 140, 35);
		clinic_panel.add(add_worker);
		
		JLabel lblClinicName_1 = new JLabel("Clinic Name");
		lblClinicName_1.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblClinicName_1.setBounds(267, 156, 89, 24);
		clinic_panel.add(lblClinicName_1);
		
		JButton workerSelect = new JButton("Select");
		workerSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = table_clinic.getSelectedRow();
				if(selRow >= 0) {
					String selClinic = table_clinic.getModel().getValueAt(selRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					DefaultTableModel clearModel = (DefaultTableModel) table_worker.getModel();
					clearModel.setRowCount(0);
					
					try {
						for(int i=0; i < director.getClinicDoctorList(selClinicID).size(); i++){
							workerData[0] = director.getClinicDoctorList(selClinicID).get(i).getId();
							workerData[1] = director.getClinicDoctorList(selClinicID).get(i).getName();
							workerModel.addRow(workerData);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table_worker.setModel(workerModel);
				}else {
					Helper.showMsg("Please select an clinic");
				}
			}
		});
		workerSelect.setBounds(261, 179, 140, 35);
		clinic_panel.add(workerSelect);
		
	}
	
	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) doc_table.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i < director.getDoctorList().size(); i++) {
			doctorData[0] = director.getDoctorList().get(i).getId();
			doctorData[1] = director.getDoctorList().get(i).getName();
			doctorData[2] = director.getDoctorList().get(i).getTcno();
			doctorData[3] = director.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		
	}
	
	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_clinic.getModel();
		clearModel.setRowCount(0);
		for(int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
		
	}
}
