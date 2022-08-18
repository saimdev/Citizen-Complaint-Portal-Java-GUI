package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CitizenPortal extends JFrame implements ActionListener{
	
	JButton regist;
	JButton login;
	JButton back;
    
    CitizenPortal(){
    	
	    JLabel citizenPortal = new JLabel();
		citizenPortal.setText("CITIZEN PORTAL");
		citizenPortal.setFont(new Font("Sans Serif",Font.BOLD, 70));
		citizenPortal.setBounds(140, 40, 700, 100);
		
		JLabel note = new JLabel();
		note.setText("NOTE:\nIf you are new user then first you should register yourself for your data record.\nAfterthat, you are able to login.");
		note.setFont(new Font("", Font.PLAIN, 15));
		note.setBounds(70, 600, 1000, 60);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(700, 550, 80, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		
		regist = new JButton();
		regist.setText("Registration");
		regist.setBorderPainted(false);
		regist.setBackground(new Color(0xa000ef));
		regist.setForeground(Color.WHITE);
		regist.setFocusable(false);
		regist.setBounds(350, 254, 150, 40);
		regist.addActionListener(this);
		
		login = new JButton();
		login.setText("Login");
		login.setBorderPainted(false);
		login.setBackground(new Color(0xa000ef));
		login.setForeground(Color.WHITE);
		login.setFocusable(false);
		login.setBounds(350, 320, 150, 40);
		login.addActionListener(this);
		
		this.setLayout(null);
		this.setTitle("Citizen Complaints Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,700);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
		this.add(citizenPortal);
		this.add(regist);
		this.add(login);
		this.add(note);
		this.add(back);
		
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			Menu m = new Menu();
		}
		else if (e.getSource()==regist) {
			this.dispose();
			CitizenRegLogin crl = new CitizenRegLogin(1);
		}
		else if (e.getSource()==login) {
			this.dispose();
			CitizenRegLogin cll1 = new CitizenRegLogin("CCR");
		}
		
	}
}
