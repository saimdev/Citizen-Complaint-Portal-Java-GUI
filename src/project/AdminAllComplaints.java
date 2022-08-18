package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableModel;

public class AdminAllComplaints implements ActionListener{
	
	DataBaseClass dbc = new DataBaseClass();
	JFrame f = new JFrame();  
	JButton back;
	
    AdminAllComplaints(){
    	
    	JTable jt=new JTable();    
	    dbc.showAllComplaints(jt);
//	    jt.setBounds(10,10,700,600);
	    JScrollPane sp=new JScrollPane(jt);  
	    
    	JPanel tablePanel = new JPanel();
    	tablePanel.setBounds(0,0,900, 550);
    	tablePanel.setBackground(Color.WHITE);
    	tablePanel.add(sp);
    	    
		back = new JButton();
		back.setText("BACK");
		back.setBorderPainted(false);
		back.setBackground(Color.WHITE);
//		back.setHorizontalAlignment(JButton.WHITE);
		back.setFocusable(false);
		back.addActionListener(this);
		
		JPanel buttPanel = new JPanel();
		buttPanel.setBounds(0,550, 900, 100);
		buttPanel.setBackground(Color.WHITE);
		buttPanel.add(back);
	    
		f.setLayout(null);
	    f.setSize(900,700);    
	    f.setVisible(true);  
	    f.setTitle("Citizen Complaints Registration System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.getContentPane().setBackground(new Color(0xFFFFFF));
		
		f.add(tablePanel);
		f.add(buttPanel);
    }
    
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			f.dispose();
			AdminDashBoard adb = new AdminDashBoard();
		}
		
	}

}
