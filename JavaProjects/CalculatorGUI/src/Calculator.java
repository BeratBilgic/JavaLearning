import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField output;
	private	double num,answer;
	private int operation;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addOutPut(JButton button) {
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(output.getText().equals((String.valueOf(answer)))){
					output.setText("");
				}
				output.setText(output.getText() + e.getActionCommand());
			}
		});
	}
	
	public void calculate() {
		switch(operation) {
			case 1 :
				answer = num + Double.parseDouble(output.getText());
				break;
			case 2 :
				answer = num - Double.parseDouble(output.getText());
				break;
			case 3 :
				answer = num * Double.parseDouble(output.getText());
				break;
			case 4 :
				answer = num / Double.parseDouble(output.getText());
				break;
		}
		output.setText(String.valueOf(answer));
		
	}

	public Calculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Screen = new JPanel();
		Screen.setBounds(6, 6, 381, 60);
		contentPane.add(Screen);
		Screen.setLayout(null);
		
		output = new JTextField();
		output.setEditable(false);
		output.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
		output.setBounds(6, 6, 370, 48);
		Screen.add(output);
		output.setColumns(10);

		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBounds(6, 78, 375, 338);
		contentPane.add(ButtonPanel);
		ButtonPanel.setLayout(new GridLayout(0, 4, 15, 15));
		
		JButton btnNewButton_7 = new JButton("7");
		ButtonPanel.add(btnNewButton_7);
		addOutPut(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		ButtonPanel.add(btnNewButton_8);
		addOutPut(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		ButtonPanel.add(btnNewButton_9);
		addOutPut(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("+");
		ButtonPanel.add(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				operation = 1;
				num = Double.parseDouble(output.getText());
				output.setText("");
			}
		});
		
		JButton btnNewButton_4 = new JButton("4");
		ButtonPanel.add(btnNewButton_4);
		addOutPut(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		ButtonPanel.add(btnNewButton_5);
		addOutPut(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		ButtonPanel.add(btnNewButton_6);
		addOutPut(btnNewButton_6);
		
		JButton btnNewButton_11 = new JButton("-");
		ButtonPanel.add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				operation = 2;
				num = Double.parseDouble(output.getText());
				output.setText("");
			}
		});
		
		JButton btnNewButton_1 = new JButton("1");
		ButtonPanel.add(btnNewButton_1);
		addOutPut(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		ButtonPanel.add(btnNewButton_2);
		addOutPut(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3");
		ButtonPanel.add(btnNewButton_3);
		addOutPut(btnNewButton_3);
		
		JButton btnNewButton_12 = new JButton("*");
		ButtonPanel.add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				operation = 3;
				num = Double.parseDouble(output.getText());
				output.setText("");
			}
		});
		
		JButton btnC = new JButton("C");
		ButtonPanel.add(btnC);
		btnC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				output.setText("");
			}
		});
		
		JButton btnNewButton_0 = new JButton("0");
		ButtonPanel.add(btnNewButton_0);
		addOutPut(btnNewButton_0);
		
		JButton btnNewButton_14 = new JButton("=");
		ButtonPanel.add(btnNewButton_14);
		btnNewButton_14.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		
		JButton btnNewButton_13 = new JButton("/");
		ButtonPanel.add(btnNewButton_13);
		btnNewButton_13.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				operation = 4;
				num = Double.parseDouble(output.getText());
				output.setText("");
			}
		});
	}
}
