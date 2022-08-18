package project;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.*;

public class DataBaseClass {
	
	public static Connection connection;
	public String databaseURL = "jdbc:ucanaccess://Portal.accdb";
	public static String sql;
	public static String sqlC;
	public static String sql1;
	public String[] facComplaints = new String[5000];
	
	public void dbInsertReg(String f, String l, String cnic, String p, String a, String g, String pass) {
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Connected Reg");
			
			sql = "INSERT INTO Registration (First_Name, Last_Name, Cnic, Phone_Num, Address, Gender, Pass) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, f);
			statement.setString(2, l);
			statement.setString(3, cnic);
			statement.setString(4, p);
			statement.setString(5, a);
			statement.setString(6, g);
			statement.setString(7, pass);
			statement.executeUpdate();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbLogin(String c, String p) {
		
		CitizenRegLogin crl = new CitizenRegLogin();
		ComplaintsReg cr = new ComplaintsReg("r");
		PreparedStatement statement;
		ResultSet rs;
		int found=0;
		
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Connected Search Cnic");
			String sql = "SELECT First_Name, Last_Name, Cnic, Phone_Num, Address, Gender, Pass FROM Registration";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();		
			while(rs.next()) {
				String firstname = rs.getString("First_Name");
				String lastname = rs.getString("Last_Name");
				String phonenum = rs.getString("Phone_Num");
				String addres = rs.getString("Address");
				String gen = rs.getString("Gender");
				String username = rs.getString("Cnic");
				String pass = rs.getString("Pass");
				
				if(c.equals(username)) {
					if(p.equals(pass)) {
						cr.firstName=firstname;
						cr.lastName = lastname;
						cr.cnic = username;
						cr.phoneNum = phonenum;
						cr.address = addres;
						cr.gender = gen;
						System.out.println("Logged IN");
						found=1;
						crl.setValue(found);
						break;
					
				}
				}	
			}
			if(found==0) {
				crl.setValue(found);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dbInsertComplaint(String f, String l, String cnic, String p, String a, String g, String depart, String comp) {
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Connected Complaint");
			
			sql = "INSERT INTO "+depart+" (Citizen_First, Citizen_Last, Citizen_Cnic, Citizen_Phone, Citizen_Address, Citizen_Gender, Complaint) VALUES (?,?,?,?,?,?,?)";
			sqlC = "INSERT INTO AllComplaints (Complaints) VALUES (?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement statementC = connection.prepareStatement(sqlC);
			statement.setString(1, f);
			statement.setString(2, l);
			statement.setString(3, cnic);
			statement.setString(4, p);
			statement.setString(5, a);
			statement.setString(6, g);
			statement.setString(7, comp);
			statementC.setString(1, comp);
			statementC.executeUpdate();
			statement.executeUpdate();
			statement.close();
			statementC.close();
			
			sql1 = "INSERT INTO C_"+ cnic + " (Complaints, Depart, Status) VALUES (?,?,?)";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setString(1, comp);
			statement1.setString(2, depart);
			statement1.setString(3, "SENT");
			statement1.executeUpdate();
			
			statement1.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public void newDB(String cnicNO) {
	
		Statement statement;
		try {
			connection =DriverManager.getConnection(databaseURL);  
			System.out.println("Connected Search Cnic");
			String sql = "CREATE Table C_"+ cnicNO +" (ID AUTOINCREMENT, Complaints VARCHAR(255), Depart VARCHAR(20), Status VARCHAR(20), PRIMARY KEY(ID))";
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void showComplaints(String facultyName) {
	PreparedStatement statement;
	ResultSet rs;
	int i=0;
	int a=0;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Complaints");
		String sql = "SELECT Complaint FROM "+facultyName;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();	
		
		while(rs.next()) {
			for (int x=0; x<5000; x++) {
				if(facComplaints[x]==rs.getString("Complaint")) {
					i=0;
					break;
				}
				else {
					i=1;
				}
			}
			if(i==1) {
				facComplaints[a]=rs.getString("Complaint");
			}
			++a;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void setFacComplaints(String comp, String dep) {
	FacComplaintClass use = new FacComplaintClass("use");
	PreparedStatement statement;
	ResultSet rs;
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Cnic");
		String sql = "SELECT Citizen_First, Citizen_Last, Citizen_Cnic, Citizen_Phone, Citizen_Address, Citizen_Gender, Complaint FROM "+dep;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();	
		
		while(rs.next()) {
			String firstname = rs.getString("Citizen_First");
			String lastname = rs.getString("Citizen_Last");
			String phonenum = rs.getString("Citizen_Phone");
			String addres = rs.getString("Citizen_Address");
			String gen = rs.getString("Citizen_Gender");
			String Cnic = rs.getString("Citizen_Cnic");
			String complaint = rs.getString("Complaint");
			
			if(comp.equals(complaint)) {
				use.firstName=firstname;
				use.lastName = lastname;
				use.cnic = Cnic;
				use.phoneNum = phonenum;
				use.address = addres;
				use.gender = gen;
				break;
			
		}

		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public int checkCitizens() {
	PreparedStatement statement;
	ResultSet rs;
	int count = 0;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Citizens");
		String sql = "SELECT * FROM Registration";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();	
		
		while(rs.next()) {
			count++;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return count;
}

public int checkComplaints() {
	PreparedStatement statement;
	ResultSet rs;
	int counts = 0;
	
	try {
		connection =DriverManager.getConnection(databaseURL);  
		System.out.println("Connected Search Citizens");
		String sql = "SELECT * FROM AllComplaints";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();	
		
		while(rs.next()) {
			counts++;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return counts;
}

public void updateStatus(String comp, String cnicNum, String faculty, int aOrd) {
	PreparedStatement statement;
	PreparedStatement statementC;
	String idNo;
//	int id=1;
	ResultSet rs;
	String app = "Approved";
	try {
		System.out.println(cnicNum);
		connection = DriverManager.getConnection(databaseURL);
		sqlC = "SELECT * FROM C_"+cnicNum;
		statementC = connection.prepareStatement(sqlC);	
		rs = statementC.executeQuery();	
		
		while(rs.next()) {
			if(comp.equals(rs.getString("Complaints"))) {
				if(aOrd==0) {
					idNo = rs.getString("ID");
					sql = "UPDATE C_"+cnicNum+
				            " SET Status = 'Approved' WHERE id in ("+idNo+")";
					statement = connection.prepareStatement(sql);
					statement.executeUpdate();
					statement.close();
					break;
				}
				else if(aOrd==1) {
					idNo = rs.getString("ID");
					sql = "UPDATE C_"+cnicNum+
				            " SET Status = 'Disapproved' WHERE id in ("+idNo+")";
					statement = connection.prepareStatement(sql);
					statement.executeUpdate();
					statement.close();
					break;
				}
			}
		}
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void deleteComp(String comp, String depart) {
	PreparedStatement statement;
	PreparedStatement statementC;
	String idNo;
	ResultSet rs;
	try {
		connection = DriverManager.getConnection(databaseURL);
		sqlC = "SELECT * FROM "+depart;
		statementC = connection.prepareStatement(sqlC);	
		rs = statementC.executeQuery();	
		
		while(rs.next()) {
			if(comp.equals(rs.getString("Complaint"))) {
					idNo = rs.getString("ID");
					sql = "DELETE FROM "+depart+" WHERE id in ("+idNo+")";
					statement = connection.prepareStatement(sql);
					statement.executeUpdate();
					statement.close();
					break;
			}
		}
		statementC.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void showAllComplaints(JTable compTable) {
	String columns[]= {"ID", "Complaint"};
	PreparedStatement statement;
	ResultSet rs;
	int i=0;
	int x=0;
	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM AllComplaints";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			String id = String.valueOf(rs.getInt("ID"));
			String comp = String.valueOf(rs.getString("Complaints"));
			
			String compData[]= {id, comp};
			DefaultTableModel tableModel = (DefaultTableModel)compTable.getModel();
			tableModel.setColumnIdentifiers(columns);
			tableModel.addRow(compData);
		}
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void showAllRegistrations(JTable regTable) {
	String columns[]= {"ID", "FirstName", "LastName", "CNIC", "Phone", "Address", "Gender"};
	PreparedStatement statement;
	ResultSet rs;
	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM Registration";
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			String id = String.valueOf(rs.getInt("ID"));
			String first = String.valueOf(rs.getString("First_Name"));
			String last = String.valueOf(rs.getString("Last_Name"));
			String cnic = String.valueOf(rs.getString("Cnic"));
			String phone = String.valueOf(rs.getString("Phone_Num"));
			String addr = String.valueOf(rs.getString("Address"));
			String gender = String.valueOf(rs.getString("Gender"));
			
			String regData[]= {id, first, last, cnic, phone, addr, gender};
			DefaultTableModel tableModel = (DefaultTableModel)regTable.getModel();
			tableModel.setColumnIdentifiers(columns);
			tableModel.addRow(regData);
		}
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

public void showComplaintsStatus(JTable statusTable, String cnicNum) {
	String columns[]= {"ID", "Complaints", "Department", "Status"};
	PreparedStatement statement;
	ResultSet rs;
	try {
		connection = DriverManager.getConnection(databaseURL);
		sql = "SELECT * FROM C_"+cnicNum;
		statement = connection.prepareStatement(sql);
		rs = statement.executeQuery();
		
		while(rs.next()) {
			String id = String.valueOf(rs.getInt("ID"));
			String complaint = String.valueOf(rs.getString("Complaints"));
			String depart = String.valueOf(rs.getString("Depart"));
			String status = String.valueOf(rs.getString("Status"));
			
			String statusData[]= {id, complaint, depart, status};
			DefaultTableModel tableModel = (DefaultTableModel)statusTable.getModel();
			tableModel.setColumnIdentifiers(columns);
			tableModel.addRow(statusData);
		}
		statement.close();
		connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}
