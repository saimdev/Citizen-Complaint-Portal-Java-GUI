package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComplaintsReg extends JFrame implements ActionListener{
	public static String complaints;
	public static String firstName;
	public static String lastName;
	public static String cnic ;
	public static String phoneNum;
	public static String address ;
	public static String gender;
	public static String depart;
    
    JButton back;
    JTextArea complaint;
    JButton submit;
    
    private static int indeX = 0;
    
	ComplaintsReg(String n){}
	
	ComplaintsReg(){
		
		JLabel department = new JLabel();
		department.setText(depart);
		department.setForeground(new Color(0xa000ef));
		department.setFont(new Font("Sans Serif", Font.BOLD, 25));
		department.setBounds(370, 10,100, 40);
		
		JLabel fullName = new JLabel();
		fullName.setText("Full Name");
		fullName.setFont(new Font("Sans Serif", Font.BOLD, 15));
		fullName.setBounds(40, 70,100, 20);
		
		JLabel fullText = new JLabel();
		fullText.setHorizontalAlignment(JLabel.CENTER);
		fullText.setText(firstName+ " "+lastName);
		fullText.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		fullText.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
		fullText.setBounds(140, 63,200, 30);
		
		JLabel CNIC = new JLabel();
		CNIC.setText("CNIC");
		CNIC.setFont(new Font("Sans Serif", Font.BOLD, 15));
		CNIC.setBounds(570, 70,70, 20);
		
		JLabel cnicText = new JLabel();
		cnicText.setHorizontalAlignment(JLabel.CENTER);
		cnicText.setText(cnic);
		cnicText.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		cnicText.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
		cnicText.setBounds(635, 63,200, 30);
		
		JLabel phone = new JLabel();
		phone.setText("Phone Num");
		phone.setFont(new Font("Sans Serif", Font.BOLD, 15));
		phone.setBounds(40, 120,100, 20);
		
		JLabel phoneText = new JLabel();
		phoneText.setHorizontalAlignment(JLabel.CENTER);
		phoneText.setText(phoneNum);
		phoneText.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		phoneText.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
		phoneText.setBounds(140, 113,200, 30);
		
		JLabel gndr = new JLabel();
		gndr.setText("Gender");
		gndr.setFont(new Font("Sans Serif", Font.BOLD, 15));
		gndr.setBounds(570, 120,70, 20);
		
		JLabel gndrText = new JLabel();
		gndrText.setHorizontalAlignment(JLabel.CENTER);
		gndrText.setText(gender);
		gndrText.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		gndrText.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
		gndrText.setBounds(635, 113,200, 30);
		
		JLabel addr = new JLabel();
		addr.setText("Address");
		addr.setFont(new Font("Sans Serif", Font.BOLD, 15));
		addr.setBounds(200, 160,80, 20);
		
		JLabel addrText = new JLabel();
		addrText.setHorizontalAlignment(JLabel.CENTER);
		addrText.setText(address);
		addrText.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		addrText.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
		addrText.setBounds(280, 155,400, 30);
		
		JLabel complaintDescrip = new JLabel();
		complaintDescrip.setText("Complaint:");
		complaintDescrip.setFont(new Font("Sans Serif", Font.BOLD, 20));
		complaintDescrip.setBounds(20, 190,120, 20);
		
		complaint = new JTextArea();
		complaint.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
		complaint.setBounds(20, 230, 800, 340);
		
		submit = new JButton();
		submit.setText("Submit");
		submit.setForeground(Color.WHITE);
		submit.setBackground(new Color(0xa000ef));
		submit.setBorderPainted(false);
		submit.setBounds(20, 600, 150, 30);
		submit.setFocusable(false);
		submit.addActionListener(this);
		
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
		back.setBounds(700, 600,  80, 30);
		back.setFocusable(false);
		back.addActionListener(this);
		
		System.out.println(depart);
		
		this.setLayout(null);
		this.setTitle("Citizen Complaints Registration System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,700);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(0xFFFFFF));
		
		this.add(department);
		this.add(back);
		this.add(fullName);
		this.add(CNIC);
		this.add(phone);
		this.add(gndr);
		this.add(addr);
		this.add(fullText);
		this.add(cnicText);
		this.add(phoneText);
		this.add(gndrText);
		this.add(addrText);
		this.add(complaintDescrip);
		this.add(complaint);
		this.add(submit);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			this.dispose();
			CitizenDashBoard cdb = new CitizenDashBoard();
		}
		else if(e.getSource()==submit) {
			complaints = complaint.getText();
			DataBaseClass dbc = new DataBaseClass();
			dbc.dbInsertComplaint(firstName, lastName, cnic, phoneNum, address, gender, depart, complaints);
			this.dispose();
			CitizenDashBoard cdb = new CitizenDashBoard();
		}
		
	}
}
