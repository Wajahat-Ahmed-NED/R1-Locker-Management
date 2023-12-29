package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class newGrid extends JFrame {
	private JTable table;
	String [] columnNames={"Locker Number", "Locker"};
	Object[][] data= new Object[5][7];
	Object[][] newdata = new Object [1][7] ;
	Object[][] newdata3 = new Object [4][6] ;
	public int chk;
	public boolean issuance;
	/**
	 * @wbp.parser.constructor
	 */
	public newGrid(final int chk) {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		this.chk=chk;
		JPanel panel= new JPanel();
		panel.setBounds(10,71,563,119);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		table = new JTable(data,columnNames);
//		table.setVisible(false);
		table.setBounds(77, 166, 414, 156);
		getContentPane().add(table);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scroll.setBounds(0,0,563,119);
		panel.add(scroll);

		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select  lockernum,rentstatus from lockerAssigned_tr;";
			PreparedStatement statement = connection.prepareStatement(query);
			
//			statement.setString(1, branchCode);
//			statement.setString(2, userName);
//			statement.setString(3, password);
				
			ResultSet result = statement.executeQuery();
			ResultSetMetaData metaData = result.getMetaData();
		        // Get number of columns in the result set
		    int columnCount = metaData.getColumnCount();
		    System.out.print("test "+columnCount+"    ");
			
			
			ArrayList<Object[]> rows= new ArrayList<Object[]>();
			
			while(result.next()) {
				Object[] row= new Object[columnCount];
				for ( int i=0;i<columnCount;i++){
					
					row[i]=result.getString(i+1);
					System.out.println(i+" "+row[i]);
				}
				System.out.println(row);

				if(row[1].equals("0")){
					row[1]="Issuance";
				}
				else if (row[1].equals("1")){
					row[1]="Maintenance";
				}
				else if (row[1].equals("2"))
				{ 
					row[1]="Surrender";
				}
				rows.add(row);
			}
			
			
			for (int i=0; i<rows.size();i++){
				data[i]=rows.get(i);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		JButton exitButton = new JButton("Back");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.exit(404);
				dispose();
			}
		});
		exitButton.setBounds(472, 419, 89, 23);
		getContentPane().add(exitButton);
		
		if(chk==1)
		{
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(120, 419, 89, 23);
		getContentPane().add(deleteButton);
//		10, 419, 99, 23
//		JButton modifyButton = new JButton("Modify");
//		modifyButton.setBounds(373, 419, 89, 23);
//		getContentPane().add(modifyButton);
//		
//		JButton updateButton = new JButton("Update");
//		updateButton.setBounds(120, 419, 89, 23);
//		getContentPane().add(updateButton);
		setTitle("Locker Issuance Details");
		}
		
		JButton proceedButton = new JButton("Save");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==1)
				{
						lockerModule obj = new lockerModule(0);
						obj.setVisible(true);
						obj.setSize(600, 500);
//						dispose();
				} else if(chk==0)
				{
					lockerMaintenance obj = new lockerMaintenance(1);

					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		proceedButton.setBounds(219, 419, 99, 23);
		getContentPane().add(proceedButton);
		// TODO Auto-generated constructor stub
		JButton Signoffbutton = new JButton("Sign Off");
		Signoffbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		Signoffbutton.setBounds(10, 419, 99, 23);
		getContentPane().add(Signoffbutton);
	}
	public Integer lockerNum;
	
	public newGrid(final int chk,final Boolean issuance){

		if(issuance==true){
			
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		this.chk=chk;
		JPanel panel= new JPanel();
		panel.setBounds(10,71,563,119);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		String [] columnNames={"Trans No", "Trans Detail","Account Title","Account No","Debit","Credit"};
//				,"BranchCode","LockerSize","PaymentMode","Expiry"};
		
		table = new JTable(newdata3,columnNames);
//		table.setVisible(false);
		table.setBounds(77, 166, 414, 156);
		getContentPane().add(table);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scroll.setBounds(0,0,563,119);
		panel.add(scroll);

		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select  lockernum,rentstatus from lockerAssigned_tr;";
			PreparedStatement statement = connection.prepareStatement(query);
			
//			statement.setString(1, branchCode);
//			statement.setString(2, userName);
//			statement.setString(3, password);
				
			ResultSet result = statement.executeQuery();
			ResultSetMetaData metaData = result.getMetaData();
		        // Get number of columns in the result set
		    int columnCount = metaData.getColumnCount();
		    System.out.print("test "+columnCount+"    ");
			
			
			ArrayList<Object[]> rows= new ArrayList<Object[]>();
			
			while(result.next()) {
				Object[] row= new Object[columnCount];
				for ( int i=0;i<columnCount;i++){
					
					row[i]=result.getString(i+1);
					System.out.println(i+" "+row[i]);
				}
				System.out.println(row);

				if(row[1].equals("0")){
					row[1]="Issuance";
				}
				else if (row[1].equals("1")){
					row[1]="Maintenance";
				}
				else if (row[1].equals("2"))
				{ 
					row[1]="Surrender";
				}
				rows.add(row);
			}
			
			
			for (int i=0; i<rows.size();i++){
				data[i]=rows.get(i);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		JButton exitButton = new JButton("Back");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.exit(404);
				dispose();
			}
		});
		exitButton.setBounds(472, 419, 89, 23);
		getContentPane().add(exitButton);
		
		if(chk==1)
		{
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(120, 419, 89, 23);
		getContentPane().add(deleteButton);
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==1)
				{
	
					JOptionPane.showMessageDialog(null,"Are you sure you want to delete? ");
					dispose();
				}
			}
		});
		
//		10, 419, 99, 23
//		JButton modifyButton = new JButton("Modify");
//		modifyButton.setBounds(373, 419, 89, 23);
//		getContentPane().add(modifyButton);
//		
//		JButton updateButton = new JButton("Update");
//		updateButton.setBounds(120, 419, 89, 23);
//		getContentPane().add(updateButton);
		setTitle("Locker Issuance Details");
		}
		
		JButton proceedButton = new JButton("Issue");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createVoucher();
			}
		});
		proceedButton.setBounds(219, 419, 99, 23);
		getContentPane().add(proceedButton);
		// TODO Auto-generated constructor stub
		JButton Signoffbutton = new JButton("Sign Off");
		Signoffbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		Signoffbutton.setBounds(10, 419, 99, 23);
		getContentPane().add(Signoffbutton);
	
	}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	newGrid frame = new newGrid(0,true);
    	frame.setSize(600, 500);
    	frame.setVisible(true);

	}


	public void setData(Object[][] data2,Integer lockerid) {
		// TODO Auto-generated method stub
		
		
		for (int i = 0; i < data2.length; i++) {
	        newdata[i] = new Object[data2[i].length];
	        System.arraycopy(data2[i], 0, newdata[i], 0, data2[i].length);
	       
	    }
		
	}
	
	
	public void createVoucher(){
		
		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
			
			
			Integer lockernum=getLockerNum(lockerNum);
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
			
			PreparedStatement statement = connection.prepareStatement("insert into voucher_master_tl (lockernum,customerId,userId,accountnum,modeofoperationid,modeofpaymentid,vouchertypeid,voucherstatusid) values(?,?,?,?,?,?,?,?);");
//			'A120',3000,2001,'1234567891245689',1,1,1,1
			statement.setInt(1, lockernum);
			statement.setInt(2, Global.customerId);
			statement.setInt(3, Global.userId);
			statement.setString(4, Global.accountNum);
			statement.setInt(5, 1);
			statement.setInt(6, 1);
			statement.setInt(7, 1);
			statement.setInt(8, 1);
			
			
			ResultSet result = statement.executeQuery();
//			System.out.println(result);
			if (result.next()) {
//				JOptionPane.showMessageDialog(null,"Signin Successful");
				System.out.println(result.getString("AUTH"));
				JOptionPane.showMessageDialog(null,"Voucher Generated Success");
				
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Could Not Inserted");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			System.out.println("DB Connection fail");
//			JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	}
	
	public Integer getLockerNum(Integer num){
		try{
		Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		java.sql.Connection connection = null;
		java.sql.Statement  lcl_stmt =null;
		connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
		
//		PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
		
		PreparedStatement statement = connection.prepareStatement("select count(*) as Available, lockersizeid from locker where lockernum not in(select lockernum from lockerassigned_tr union select lockernum from lockerassigned_tl order by lockernum) group by lockersizeid having lockersizeid=?;");
//		'A120',3000,2001,'1234567891245689',1,1,1,1
		statement.setInt(1, num);
		
		ResultSet result = statement.executeQuery();
//		System.out.println(result);
		if (result.next()) {
			
			System.out.println(result.getInt("AVAILABLE"));
			
			return result.getInt("AVAILABLE");
			}
			
			
		
		else
		{
			return result.getInt("AVAILABLE");
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		// TODO: handle exception
		System.out.println("DB Connection fail");
		return -1;
	}
	}
}