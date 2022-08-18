package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener{
	JFrame frame = new JFrame();
	JButton admin;
	JButton citizen;
	JButton faculty;
	JButton back;
	
	Menu(){
		
		JLabel portals = new JLabel();
		portals.setText("PORTALS");
		portals.setFont(new Font("Sans Serif",Font.BOLD, 80));
		portals.setBounds(230, 40, 400, 100);
		
		admin = new JButton();
		admin.setText("ADMIN PORTAL");
		admin.setBorderPainted(false);
		admin.setForeground(Color.WHITE);
		admin.setBackground(new Color(0xa000ef));
		admin.setBounds(150, 250, 180, 40);
		admin.setFocusable(false);
		admin.addActionListener(this);
		
		citizen = new JButton();
		citizen.setText("CITIZEN PORTAL");
		citizen.setBorderPainted(false);
		citizen.setForeground(Color.WHITE);
		citizen.setBackground(new Color(0xa000ef));
		citizen.setBounds(150, 400, 180, 40);
		citizen.setFocusable(false);
		citizen.addActionListener(this);
		
		faculty = new JButton();
		faculty.setText("FACULTY PORTAL");
		faculty.setBorderPainted(false);
		faculty.setForeground(Color.WHITE);
		faculty.setBackground(new Color(0xa000ef));
		faculty.setBounds(500, 250, 180, 40);
		faculty.setFocusable(false);
		faculty.addActionListener(this);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(500, 400, 180, 40);
		back.setFocusable(false);
		back.addActionListener(this);
		
		
		frame.setLayout(null);
		frame.setTitle("Citizen Complaints Registration System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,700);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(0xFFFFFF));
		
		frame.add(portals);
		frame.add(admin);
		frame.add(citizen);
		frame.add(faculty);
		frame.add(back);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			frame.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==admin) {
			frame.dispose();
			AdminLogin al = new AdminLogin();
		}
		else if (e.getSource()==faculty) {
			frame.dispose();
			FacultyLogin f1 = new FacultyLogin();
		}
		else if (e.getSource()==citizen) {
			frame.dispose();
			CitizenPortal cp = new CitizenPortal();
		}
	}
}
