package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLogin extends JFrame implements ActionListener{
	
	JTextField userText;
	JPasswordField passText;
	JButton login;
	JButton back;

	AdminLogin(){
		
		JLabel adminPortal = new JLabel();
		adminPortal.setText("ADMIN PORTAL");
		adminPortal.setFont(new Font("Sans Serif",Font.BOLD, 70));
		adminPortal.setBounds(160, 40, 600, 100);
		
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
		this.add(adminPortal);
		this.add(password);
		this.add(username);
		this.add(back);
		this.add(login);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		
		else if (e.getSource()==login) {
			String user = userText.getText();
			String pass = passText.getText();
			if(user.equals("admin") && pass.equals("admin123")) {
				JOptionPane.showMessageDialog(this, "You are succesfully Logged In");
				this.dispose();
				AdminDashBoard adb = new AdminDashBoard();
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
			}
		}
	}
}
