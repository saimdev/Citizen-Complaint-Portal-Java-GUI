package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CitizenRegLogin extends JFrame implements ActionListener{

	private static String firstName;
	private static String lastName;
	private static String cnic;
	private static String phoneNum;
	private static String address;
	private static String gender;
	private static String password;
    
  	private static int entered=0;
    private String citizencnic;
	private String citizenpass;
    private static int index = 0;
    
    DataBaseClass dbc = new DataBaseClass();
    
    JTextField fText;
    JTextField lText;
    JTextField cnicNo;
    JTextField phone;
    JTextField adrs;
    JTextField gndr;
    JTextField pswrd;
    JButton submit;
	JTextField userText;
	JButton login;
	JButton back;
	JPasswordField passText;

	CitizenRegLogin(){}
	
	CitizenRegLogin(String n){
		
		JLabel citizenPortal = new JLabel();
		citizenPortal.setText("CITIZEN PORTAL");
		citizenPortal.setFont(new Font("Sans Serif",Font.BOLD, 70));
		citizenPortal.setBounds(160, 40, 600, 100);
		
		JLabel username = new JLabel();
		username.setText("Enter CNIC");
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
		this.add(citizenPortal);
		this.add(password);
		this.add(username);
		this.add(back);
		this.add(login);
	}
	
	CitizenRegLogin(int i){
		
		JLabel citizenReg = new JLabel();
		citizenReg.setText("CITIZEN REGISTRATION");
		citizenReg.setFont(new Font("Sans Serif",Font.BOLD, 50));
		citizenReg.setBounds(150, 40, 700, 60);
		
		JLabel fName = new JLabel();
		fName.setText("Enter First Name");
		fName.setFont(new Font("", Font.BOLD, 15));
		fName.setBounds(260, 150, 160, 20);
		
		fText = new JTextField();
		fText.setPreferredSize(new Dimension(200,40));
		fText.setBounds(400, 150, 200, 25);
		
		JLabel lName = new JLabel();
		lName.setText("Enter Last Name");
		lName.setFont(new Font("", Font.BOLD, 15));
		lName.setBounds(260, 200, 160, 20);
		
		lText = new JTextField();
		lText.setPreferredSize(new Dimension(200,40));
		lText.setBounds(400, 200, 200, 25);
		
		JLabel Cnic = new JLabel();
		Cnic.setText("Enter Your Cnic");
		Cnic.setFont(new Font("", Font.BOLD, 15));
		Cnic.setBounds(260, 247, 160, 20);
		
		JLabel cnic_details = new JLabel();
		cnic_details.setText("Without Dashes");
		cnic_details.setFont(new Font("", Font.PLAIN, 10));
		cnic_details.setBounds(275, 260, 160, 20);
		
		cnicNo = new JTextField();
		cnicNo.setPreferredSize(new Dimension(200,40));
		cnicNo.setBounds(400, 250, 200, 25);
		
		JLabel phoneNo = new JLabel();
		phoneNo.setText("Enter Phone Num");
		phoneNo.setFont(new Font("", Font.BOLD, 15));
		phoneNo.setBounds(260, 300, 160, 20);
		
		phone = new JTextField();
		phone.setPreferredSize(new Dimension(200,40));
		phone.setBounds(400, 300, 200, 25);
		
		JLabel adress = new JLabel();
		adress.setText("Enter Address");
		adress.setFont(new Font("", Font.BOLD, 15));
		adress.setBounds(260, 350, 160, 20);
		
		adrs = new JTextField();
		adrs.setPreferredSize(new Dimension(200,40));
		adrs.setBounds(400, 350, 200, 25);
		
		JLabel genderMF = new JLabel();
		genderMF.setText("Enter Gender");
		genderMF.setFont(new Font("", Font.BOLD, 15));
		genderMF.setBounds(260, 395, 160, 20);
		
		JLabel mf = new JLabel();
		mf.setText("M/F/O 'O for others'");
		mf.setFont(new Font("", Font.PLAIN, 10));
		mf.setBounds(263, 410, 160, 20);
		
		gndr = new JTextField();
		gndr.setPreferredSize(new Dimension(200,40));
		gndr.setBounds(400, 400, 200, 25);
		
		JLabel pass = new JLabel();
		pass.setText("Enter Password");
		pass.setFont(new Font("", Font.BOLD, 15));
		pass.setBounds(260, 450, 160, 20);
		
		pswrd = new JTextField();
		pswrd.setPreferredSize(new Dimension(200,40));
		pswrd.setBounds(400, 450, 200, 25);
		
		submit = new JButton();
		submit.setText("Submit");
		submit.setForeground(Color.WHITE);
		submit.setBackground(new Color(0xa000ef));
		submit.setBorderPainted(false);
		submit.setBounds(350, 500, 150, 30);
		submit.setFocusable(false);
		submit.addActionListener(this);
		
		back = new JButton();
		back.setText("BACK");
		back.setBackground(new Color(0xFFFFFF));
		back.setBorderPainted(false);
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
		
		this.add(citizenReg);
		this.add(fName);
		this.add(fText);
		this.add(lName);
		this.add(lText);
		this.add(Cnic);
		this.add(cnic_details);
		this.add(cnicNo);
		this.add(phoneNo);
		this.add(phone);
		this.add(adress);
		this.add(adrs);
		this.add(genderMF);
		this.add(mf);
		this.add(gndr);
		this.add(pass);
		this.add(pswrd);
		this.add(submit);
		this.add(back);
	}
		
	public void setValue(int ent) {
		entered = ent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			WelcomeScreen ws = new WelcomeScreen();
		}
		else if (e.getSource()==submit) {
			if (fText.getText().isEmpty() || lText.getText().isEmpty() || cnicNo.getText().isEmpty() || phone.getText().isEmpty() ||  adrs.getText().isEmpty() || gndr.getText().isEmpty() || pswrd.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Some Fields are Empty");
			}
			else {
				firstName= fText.getText();
				lastName= lText.getText();
				cnic= cnicNo.getText();
				phoneNum = phone.getText();
				address = adrs.getText();
				gender= gndr.getText();
				password = pswrd.getText();
				dbc.dbInsertReg(firstName, lastName, cnic, phoneNum, address, gender, password);
				dbc.newDB(cnic);
				JOptionPane.showMessageDialog(this, "Successfully Registered");
				this.dispose();
				WelcomeScreen ws = new WelcomeScreen();
			}
		}
		
		else if (e.getSource()==login) {
			if(userText.getText().isEmpty() || passText.getText().isEmpty() ) {
				JOptionPane.showMessageDialog(this, "Some Fields are Empty");
			}
			else {
				citizencnic = userText.getText();
				citizenpass = passText.getText();
				dbc.dbLogin(citizencnic, citizenpass);
				if(entered==1) {
					ComplaintsStatus cs = new ComplaintsStatus("use");
					cs.cnic=citizencnic;
					JOptionPane.showMessageDialog(this, "You are succesfully Logged In");
					this.dispose();
					CitizenDashBoard cdb = new CitizenDashBoard();
				}
				else if(entered==0) {
				JOptionPane.showMessageDialog(this, "Incorrect Cnic or Password");
			}
		}
		
	}

}
}
