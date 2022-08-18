package project;

import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomeScreen extends JFrame implements ActionListener{
	
	JButton welcomeBut;
	JButton admin;
	JButton login;
	JButton signup;
	JButton citizen;
	JButton faculty;
	
	WelcomeScreen(){
	
		JLabel mainText = new JLabel();
		mainText.setText("CCR SYSTEM");
		mainText.setFont(new Font("Sans Serif", Font.BOLD,20));
		mainText.setBounds(20,25, 130, 25);
		
		JLabel imgLabel = new JLabel();
		ImageIcon image = new ImageIcon("portalLogo9.png");
		imgLabel.setIcon(image);
		imgLabel.setBounds(320,90,500,500);
		
		login = new JButton();
		login.setText("Log In");
		login.setFont(new Font("Sans Serif", Font.BOLD, 12));
		login.setBounds(610, 30, 70, 20);
		login.setFocusable(false);
		login.setBackground(Color.WHITE);
		login.setBorderPainted(false);
		login.addActionListener(this);
		
		admin = new JButton();
		admin.setText("Admin");
		admin.setFont(new Font("Sans Serif", Font.BOLD, 12));
		admin.setBounds(250, 30, 70, 20);
		admin.setFocusable(false);
		admin.setBackground(Color.WHITE);
		admin.setBorderPainted(false);
		admin.addActionListener(this);
		
		citizen = new JButton();
		citizen.setText("Citizen");
		citizen.setFont(new Font("Sans Serif", Font.BOLD, 12));
		citizen.setBounds(330, 30, 80, 20);
		citizen.setFocusable(false);
		citizen.setBackground(Color.WHITE);
		citizen.setBorderPainted(false);
		citizen.addActionListener(this);
		
		JLabel line = new JLabel();
		ImageIcon underLine = new ImageIcon("line.png");
		line.setIcon(underLine);
		line.setBounds(317, 50, 70, 15);
		
		faculty = new JButton();
		faculty.setText("Faculty");
		faculty.setFont(new Font("Sans Serif", Font.BOLD, 12));
		faculty.setBounds(410, 30, 80, 20);
		faculty.setFocusable(false);
		faculty.setBackground(Color.WHITE);
		faculty.setBorderPainted(false);
		faculty.addActionListener(this);
		
		signup = new JButton();
		signup.setText("Sign Up");
		signup.setFont(new Font("Sans Serif", Font.BOLD, 12));
		signup.setBounds(710, 29, 90, 25);
		signup.setFocusable(false);
		signup.setForeground(Color.WHITE);
		signup.setBackground(new Color(0xa000ef));
		signup.setBorderPainted(false);
		signup.addActionListener(this);
		
		welcomeBut = new JButton();
		welcomeBut.setText("WELCOME");
		welcomeBut.setFont(new Font("Sans Serif", Font.BOLD, 18));
		welcomeBut.setFocusable(false);	
		welcomeBut.setForeground(Color.WHITE);
		welcomeBut.setBorderPainted(false);
		welcomeBut.setBackground(new Color(0xa000ef));
		welcomeBut.setHorizontalTextPosition(JButton.LEFT);
		welcomeBut.addActionListener(this);
		welcomeBut.setBounds(45, 470, 150,40);
		
		JLabel solution = new JLabel();
		solution.setText("<html> Ultimate Solution <br> For All Your <br> ISSUES");
		solution.setFont(new Font("Sans Serif", Font.BOLD, 25));
		solution.setBounds(30, 250, 250, 90);
		
		JLabel second = new JLabel();
		second.setText("Fast, Efficient, Easy");
		second.setFont(new Font("Sans Serif", Font.ITALIC, 20));
		second.setBounds(30, 370, 200, 20);
		
		JLabel register = new JLabel();
		register.setText("<html>Register All Your Complaints <br>From Comfort of Your Home");
		register.setFont(new Font("Sans Serif", Font.ITALIC, 14));
		register.setBounds(30, 400, 200, 30);
		
		this.setLayout(null);
		this.setTitle("Citizen Complaints Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.add(mainText);
		this.add(imgLabel);
		this.add(welcomeBut);
		this.add(login);
		this.add(admin);
		this.add(citizen);
		this.add(faculty);
		this.add(signup);
		this.add(solution);
		this.add(second);
		this.add(register);
		this.add(line);
		
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==welcomeBut) {
			this.dispose();
			Menu menu = new Menu();
		}
		else if (e.getSource()==signup) {
			this.dispose();
			CitizenRegLogin crl = new CitizenRegLogin(1);
		}
		else if (e.getSource()==admin) {
			this.dispose();
			AdminLogin al = new AdminLogin();
		}
		else if (e.getSource()==faculty) {
			this.dispose();
			FacultyLogin fl = new FacultyLogin();
		}
		else if (e.getSource()==citizen) {
			this.dispose();
			CitizenPortal cp = new CitizenPortal();
		}
		else if (e.getSource()==login) {
			this.dispose();
			CitizenRegLogin clr1 = new CitizenRegLogin("CCR");
		}
	}
}
