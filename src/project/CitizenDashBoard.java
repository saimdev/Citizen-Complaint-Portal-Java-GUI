package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CitizenDashBoard extends JFrame implements ActionListener{
	
	ComplaintsReg CompR = new ComplaintsReg("Simple");
	CitizenRegLogin crl = new CitizenRegLogin();
	String[] departs = {"Police", "Hospital", "CDA", "Wapda", "SuiGas"};
	
	JButton back;
	JButton compStatus;
	JButton ok;
	JComboBox faculty;
	String depart; 
	
	CitizenDashBoard(){
		
		JLabel complaints = new JLabel();
		complaints.setText("Register Your Complaints");
		complaints.setFont(new Font("Sans Serif", Font.BOLD, 50));
		complaints.setBounds(150, 20, 700, 70);
		
		JLabel department = new JLabel();
		department.setText("CHOOSE DEPARTMENT");
		department.setFont(new Font("Sans Serif", Font.BOLD, 25));
		department.setBounds(290, 300, 300, 70);
		
		ok = new JButton();
		ok.setText("OK");
		ok.setBorderPainted(false);
		ok.setForeground(Color.WHITE);
		ok.setBackground(new Color(0xa000ef));
		ok.setBounds(410, 415, 60, 40);
		ok.setFocusable(false);
		ok.addActionListener(this);
		
		faculty = new JComboBox(departs);
		faculty.addActionListener(this);
		faculty.setBounds(260, 380, 350, 20);
		
		compStatus = new JButton();
		compStatus.setText("Check Status");
		compStatus.setBackground(new Color(0xa000ef));
		compStatus.setForeground(Color.WHITE);
		compStatus.setFocusable(false);
		compStatus.setBorderPainted(false);
		compStatus.setBounds(670,150, 150, 30);
		compStatus.addActionListener(this);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(700, 550, 80, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		
		this.setLayout(null);
		this.setTitle("Citizen Complaints Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,700);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
		this.add(complaints);
		this.add(back);
		this.add(compStatus);
		this.add(faculty);
		this.add(ok);
		this.add(department);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==ok) {
			this.dispose();
			CompR.depart=String.valueOf(faculty.getSelectedItem());
			ComplaintsReg Cr = new ComplaintsReg();
		}
		else if(e.getSource()==compStatus) {
			this.dispose();
			ComplaintsStatus cs = new ComplaintsStatus();
		}
		
	}
	
}
