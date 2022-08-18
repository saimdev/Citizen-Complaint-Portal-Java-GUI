package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FacultyDashBoard extends JFrame implements ActionListener{
	
	JButton back;
	JButton details;
	DataBaseClass dbc = new DataBaseClass();
	FacultyLogin fl = new FacultyLogin("use");
	public static String facultyName;
	JComboBox complaints;
	
	FacultyDashBoard(String c){}
	
	FacultyDashBoard(){
		
		JLabel facultyPortal = new JLabel();
		facultyPortal.setText("COMPLAINTS");
		facultyPortal.setFont(new Font("Sans Serif",Font.BOLD, 70));
		facultyPortal.setBounds(180, 40, 700, 100);
		
		dbc.showComplaints(facultyName);
		complaints = new JComboBox(dbc.facComplaints);
		complaints.addActionListener(this);
		complaints.setBounds(245, 300, 350, 20);
		
		details = new JButton();
		details.setText("See The Details");
		details.setBorderPainted(false);
		details.setForeground(Color.WHITE);
		details.setBackground(new Color(0xa000ef));
		details.setBounds(355, 340, 130, 40);
		details.setFocusable(false);
		details.addActionListener(this);
		
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
		
		this.add(back);
		this.add(complaints);
		this.add(facultyPortal);
		this.add(details);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==details) {
			FacComplaintClass use = new FacComplaintClass("use");
			use.complaint =String.valueOf(complaints.getSelectedItem());
			DataBaseClass dbc = new DataBaseClass();
			dbc.setFacComplaints(use.complaint, facultyName);
			this.dispose();
			FacComplaintClass fcc = new FacComplaintClass();
		}
	}

}
