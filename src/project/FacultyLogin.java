package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import project.Menu;

public class FacultyLogin extends JFrame implements ActionListener{
	
	private String[] facUserNames = {"Police", "Hospital", "Cda", "Wapda", "Suigas"};
	private String[] facPasswords = {"police@1", "hospital@2", "cda@3", "wapda@4", "suigas@5"};
	private String user;
	private String pass;
	
	JTextField userText;
	JButton login;
	JButton back;
	JPasswordField passText;
	
	FacultyLogin(String n){}
	
	FacultyLogin(){
		
		JLabel facultyPortal = new JLabel();
		facultyPortal.setText("FACULTY PORTAL");
		facultyPortal.setFont(new Font("Sans Serif",Font.BOLD, 70));
		facultyPortal.setBounds(120, 40, 700, 100);
		
		JLabel username = new JLabel();
		username.setText("Enter Username");
		username.setFont(new Font("", Font.BOLD, 20));
		username.setBounds(230, 200, 160, 30);
		
		JLabel password = new JLabel();
		password.setText("Enter Password");
		password.setFont(new Font("", Font.BOLD, 20));
		password.setBounds(230, 250, 160, 30);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(700, 600,  80, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		
		login = new JButton();
		login.setText("Login");
		login.setBorderPainted(false);
		login.setBackground(new Color(0xa000ef));
		login.setForeground(Color.WHITE);
		login.setBounds(350, 310, 150, 30);
		login.setFocusable(false);
		login.addActionListener(this);
		
		userText = new JTextField();
		userText.setPreferredSize(new Dimension(200,40));
		userText.setBounds(410, 204, 200, 25);
		
		passText = new JPasswordField();
		passText.setPreferredSize(new Dimension(200,40));
		passText.setBounds(410, 254, 200, 25);
		
		this.setLayout(null);
		this.setTitle("Citizen Complaints Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,700);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
		this.add(userText);
		this.add(passText);
		this.add(facultyPortal);
		this.add(password);
		this.add(username);
		this.add(back);
		this.add(login);
		
	}
	
	public String getUser() {
		return user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		
		else if (e.getSource()==login) {
			FacultyDashBoard fdb = new FacultyDashBoard("use");
			user = userText.getText();
			pass = passText.getText();
			fdb.facultyName = userText.getText();
			int entered=0;
			
			for (int i=0; i<5; i++){
                if(user.equals(facUserNames[i])){
                    if(pass.equals(facPasswords[i])){
                    	JOptionPane.showMessageDialog(this, "You are succesfully Logged In");
                    	this.dispose();
                    	FacultyDashBoard fd = new FacultyDashBoard();
                        entered=1;
                    }
                }
            }
			if(entered==0){
				JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            }
		}
		
	}

}
