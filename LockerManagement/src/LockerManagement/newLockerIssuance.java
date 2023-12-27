package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class newLockerIssuance extends JFrame {
	private JTable smallLockerTable;
	private JTextField accountNumberText;
	String [] columnNames={"Locker Available", "Lockers Size"};
	Object[][] data= new Object[3][2];
	boolean auth=true;
	ArrayList<Integer> availableLockers= new ArrayList<Integer>();
	public int chk;
	
	public newLockerIssuance(final int chk)
	{
		setSize(new Dimension(600, 500));
		JPanel panel= new JPanel();
		panel.setBounds(30,147,513,70);
		getContentPane().add(panel);
		panel.setLayout(null);
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells non-editable
		    }
		};

		tableModel.setColumnIdentifiers(columnNames); // Set column names
		
		smallLockerTable = new JTable(tableModel);
		smallLockerTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		smallLockerTable.setBounds(65,83,674,174);
		getContentPane().add(smallLockerTable);
		JScrollPane scroll=new JScrollPane(smallLockerTable);
		scroll.setBounds(0, 0, 513, 70);
		panel.add(scroll);
		try {
			if(chk==0)
			{
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select count(*) as Available, lockersizeid from locker where lockernum not in(select lockernum from lockerassigned_tr union select lockernum from lockerassigned_tl order by lockernum) group by lockersizeid;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet result = statement.executeQuery();
			
			
			
			ArrayList<Object[]> rows= new ArrayList<Object[]>();
			while(result.next()) {
				Object[] row= new Object[2];
				for ( int i=0;i<2;i++){
					
					row[i]=result.getString(i+1);
				}
				availableLockers.add(Integer.parseInt((String) row[0]));
				if(row[1].equals("1")){
					row[1]="Small";
				}
				else if (row[1].equals("2")){
					row[1]="Medium";
				}
				else if (row[1].equals("3")){
					row[1]="Large";
				}
				rows.add(row);
			}
			
			
			for (int i=0; i<rows.size();i++){
				data[i]=rows.get(i);
			}
			tableModel.setDataVector(data, columnNames);
			}else if(chk==1)
			{
				newDetails obj=new newDetails(1);
				obj.setVisible(true);
				obj.setSize(600, 400);
				dispose();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("DB Connection fail");
		}
		
		
		setLocation(new Point(500, 200));
		setTitle("Locker Issuance");
		getContentPane().setBackground(new Color(0, 102, 102));
		getContentPane().setLayout(null);
		
		JLabel lblLockersInformation = new JLabel("Lockers Information");
		lblLockersInformation.setForeground(Color.WHITE);
		lblLockersInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLockersInformation.setBounds(30, 59, 214, 48);
		getContentPane().add(lblLockersInformation);
		
		JButton signOffButton = new JButton("Sign Off");
		signOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newLogIn obj=new newLogIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(470, 410, 90, 30);
		getContentPane().add(signOffButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chk==0) {
					newLockerModule obj = new newLockerModule(0);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				} else if(chk==1){

					newLockerModule obj = new newLockerModule(1);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		backButton.setBounds(370, 410, 90, 30);
		getContentPane().add(backButton);
		
		JComboBox identificationComboBox = new JComboBox();
		identificationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Account Number"}));
		identificationComboBox.setSelectedIndex(-1);
		identificationComboBox.setMaximumRowCount(3);
		identificationComboBox.setToolTipText("");
		identificationComboBox.setBounds(91, 320, 153, 30);
		getContentPane().add(identificationComboBox);
		
		JLabel lblLockerSize = new JLabel("Identification Type");
		lblLockerSize.setForeground(Color.WHITE);
		lblLockerSize.setBounds(90, 300, 150, 20);
		getContentPane().add(lblLockerSize);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setForeground(Color.WHITE);
		lblAccountNumber.setBounds(315, 300, 139, 21);
		getContentPane().add(lblAccountNumber);
		
		accountNumberText = new JTextField();
		accountNumberText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try{
					Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
					java.sql.Connection connection = null;
					java.sql.Statement  lcl_stmt =null;
					connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
								
					String query="select * from account as Available, lockersizeid from locker where lockernum not in(select lockernum from lockerassigned_tr union select lockernum from lockerassigned_tl order by lockernum) group by lockersizeid;";
					PreparedStatement statement = connection.prepareStatement(query);
					
//					statement.setString(1, branchCode);
//					statement.setString(2, userName);
//					statement.setString(3, password);
					
					ResultSet result = statement.executeQuery();
					System.out.println(result);
				}
				catch(Exception e){
					
				}
			}
		});
		accountNumberText.setBounds(313, 321, 153, 30);
		getContentPane().add(accountNumberText);
		accountNumberText.setColumns(10);
		
		
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==0 )
				{
						try{
							
							String accNum=accountNumberText.getText();
							Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
							java.sql.Connection connection = null;
							java.sql.Statement  lcl_stmt =null;
							connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
										
							String query="select accountstatus.accountstatusid,accountstatus.accountstatus from accountnew,accountstatus where accountnew.accountstatusid=accountstatus.accountstatusid and accountnew.accountnum=?;";
							PreparedStatement statement = connection.prepareStatement(query);
							
							statement.setString(1, "1234567891245689");
							
							ResultSet result = statement.executeQuery();
							
							if (result.next()) {
							    String accountStatus = result.getString("accountstatus");
							    Integer id = result.getInt("accountstatusid");
							    if (id==1){
							    	
		//					    	 JOptionPane.showMessageDialog(null,"Authorized For Locker");
							    	 
							    	 getCustDetails("1234567891245689");
							    	 
							    	
							    }
							    else{
							    		
							     	 JOptionPane.showMessageDialog(null,"Not Authorized For Locker");
							    }
							   
							}
							else{
								 JOptionPane.showMessageDialog(null,"Account Not Found");
							}
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
				}else if(chk==1)
				{
					newDetails obj = new newDetails(1);
					obj.setSize(600, 500);
					obj.setVisible(true);
					dispose();
				}
				
			}
		});
		proceedButton.setBounds(270, 410, 90, 30);
		getContentPane().add(proceedButton);
		
		newMainMenu date = new newMainMenu(0);
        JLabel dateLabel = new JLabel(date.getCurrentDate());
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        dateLabel.setBounds(10, 440, 570, 20);
        getContentPane().add(dateLabel);
	}
	
	public void getCustDetails(String accNumText){
		
		try{
			String accNum="1234567891245689";
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select c.customerid,c.customername,c.email, c.contactno  from Accountnew a, customerAccountRelationship r, customer c where a.accountNum=r.accountNum and r.customerId=c.customerid and a.accountNum=?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, accNum);
			
			ResultSet result = statement.executeQuery();
			
			String queryAccount="select  a.accountNum,a.accounttitle, a.branchCode, o.operatinginstruction from accountnew a,operatinginstruction o where a.operatinginstructionid=o.operatinginstructionid  and accountnum=?;";
			PreparedStatement statementAccount = connection.prepareStatement(queryAccount);
			
			statementAccount.setString(1, accNum);
			
			ResultSet resultAccount = statementAccount.executeQuery();
			
			HashMap<String, String> customerAccountRelationship = new HashMap<String, String>();
			if(resultAccount.next()){
				customerAccountRelationship.put("accounttitle",resultAccount.getString("ACCOUNTTITLE")) ;
				Global.accountNum(resultAccount.getString("ACCOUNTNUM"));
				int branchCode=resultAccount.getInt("BRANCHCODE");
				if(branchCode==1001){
					customerAccountRelationship.put("branchcode","No - Digital Account") ;
				}
				else{
					customerAccountRelationship.put("branchcode","Yes - "+ Integer.toString(resultAccount.getInt("BRANCHCODE"))) ;
				}
				customerAccountRelationship.put("branchcodeid",Integer.toString(resultAccount.getInt("BRANCHCODE"))) ;
				customerAccountRelationship.put("operatinginstruction", resultAccount.getString("OPERATINGINSTRUCTION")) ;
				customerAccountRelationship.put("accountnum", resultAccount.getString("ACCOUNTNUM")) ;

			}
			
			
			
			if (result.next()) {
				customerAccountRelationship.put("customername",result.getString("CUSTOMERNAME")) ;
				customerAccountRelationship.put("contactno",result.getString("CONTACTNO")) ;
				customerAccountRelationship.put("email", result.getString("EMAIL")) ;
				Global.customerId= result.getInt("customerid");
			    newDetails obj= new newDetails(0);
//			    	obj.insertData(customerAccountRelationship);
//			    	obj.insertArray(availableLockers);
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
			  
			   
			}
			else{
				 JOptionPane.showMessageDialog(null,"Customer Details Not Found");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Could not connect to DB");
			System.out.println(e);
		}
		
		
		
	}
	 public static void main(String[] args) {
		 newLockerIssuance frame = new newLockerIssuance(0);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    }
}
