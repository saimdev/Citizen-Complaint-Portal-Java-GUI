package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminDashBoard extends JFrame implements ActionListener{
	
	DataBaseClass dbc = new DataBaseClass();
	JButton allComplaints;
	JButton allRegistration;
	JButton back;
	
	AdminDashBoard(){
		
		CitizenRegLogin crl = new CitizenRegLogin();
		
		JLabel hello = new JLabel();
		hello.setText("HELLO ADMIN!");
		hello.setFont(new Font("Sans Serif", Font.BOLD, 25));
		hello.setBounds(20, 20, 300, 30);
		
		JLabel no_citizens = new JLabel();
		no_citizens.setText("NO OF CITIZENS");
		no_citizens.setFont(new Font("Sans Serif", Font.BOLD, 35));
		no_citizens.setBounds(160, 90, 600, 60);
		
		JLabel numberC = new JLabel();
		numberC.setText(String.valueOf(dbc.checkCitizens()));
		numberC.setFont(new Font("Sans Serif", Font.BOLD, 100));
		numberC.setForeground(new Color(0xa000ef));
		numberC.setBounds(250, 130, 200, 100);
		
		JLabel no_registration = new JLabel();
		no_registration.setText("COMPLAINTS");
		no_registration.setFont(new Font("Sans Serif", Font.BOLD, 35));
		no_registration.setBounds(500, 90, 600, 60);
		
		JLabel numberR = new JLabel();
		numberR.setText(String.valueOf(dbc.checkComplaints()));
		numberR.setFont(new Font("Sans Serif", Font.BOLD, 100));
		numberR.setForeground(new Color(0xa000ef));
		numberR.setBounds(575, 130, 165, 100);
		
		allRegistration = new JButton();
		allRegistration.setText("All Registrations");
		allRegistration.setForeground(Color.WHITE);
		allRegistration.setBackground(new Color(0xa000ef));
		allRegistration.setBorderPainted(false);
		allRegistration.setBounds(370, 350, 150, 30);
		allRegistration.setFocusable(false);
		allRegistration.addActionListener(this);
		
		allComplaints = new JButton();
		allComplaints.setText("All Complaints");
		allComplaints.setForeground(Color.WHITE);
		allComplaints.setBackground(new Color(0xa000ef));
		allComplaints.setBorderPainted(false);
		allComplaints.setBounds(370, 400, 150, 30);
		allComplaints.setFocusable(false);
		allComplaints.addActionListener(this);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(700, 600,  80, 30);
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
		
		this.add(hello);
		this.add(no_citizens);
		this.add(numberC);
		this.add(no_registration);
		this.add(numberR);
		this.add(allComplaints);
		this.add(allRegistration);
		this.add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==allComplaints) {
			this.dispose();
			AdminAllComplaints aac = new AdminAllComplaints();
		}
		else if(e.getSource()==allRegistration) {
			this.dispose();
			AdminAllRegistrations aar = new AdminAllRegistrations();
		}
		
	}
	
}
