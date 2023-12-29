package LockerManagement;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
public class newDetails extends JFrame {

	public int chk;
	public String lockerNumber;
	public Integer lockerSizeId;
	private JTextField customerNameText;
	private JTextField correspondedAddressText;
	private JTextField mobileNumberText;
	private JTextField accountNumberText;
	private JTextField lockerNumberText;
	private JTextField lockerKeyText;
	private JTextField lockerSizeText;
	private JTextField rentStatusText;
//	private JTextField operatingInstructionText;
	private JTextField depositText;
	private JTextField overdueDateText;
	private JTextField recoverDateText;
	private JTextField modeOfOperationText;
	private JComboBox modeOfOperationComboBox;
	ArrayList<Integer> availableLockers;
	public String lockerSize;
	public String paymentMode;
	private JTextField expiryDateText;
	private JTextField modeOfPaymentText;
	final JPanel DepositDetailsPanel = new JPanel();
	final JLabel lblExpiryDate = new JLabel("Expiry Date");
	HashMap<Integer, String> lockerSizeName = new HashMap<>();
	HashMap<Integer, String> rentStatus = new HashMap<>();
	//Constructor
	/**
	 * @wbp.parser.constructor
	 */
	public newDetails(final int chk)
	{
		this.chk=chk;
		customerPanel();

	}
	public newDetails(final int chk, String lockerNumber)
	{
		  // Set names using put method
        lockerSizeName.put(1, "Small");
        lockerSizeName.put(2, "Medium");
        lockerSizeName.put(3, "Large");
        rentStatus.put(0,"Assign");
        rentStatus.put(1,"Surrender");
		this.lockerNumber=lockerNumber;
		this.chk=chk;
		if (chk==1) {
			customerPanel();
			fetchDetails();
		}
//		System.out.println(lockerSizeText);

	}
public void customerPanel()
{
	getContentPane().setBackground(new Color(0, 102, 102));
	getContentPane().setLayout(null);
	setSize(new Dimension(600, 500));
	setResizable(false);
	setLocation(new Point(500, 200));
	setTitle("Customer Details");
	JPanel customerDetailsPanel = new JPanel();
	customerDetailsPanel.setForeground(new Color(0, 0, 0));
	customerDetailsPanel.setBackground(new Color(0, 102, 102));
	customerDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
	customerDetailsPanel.setBounds(20, 10, 540, 130);
	getContentPane().add(customerDetailsPanel);
	customerDetailsPanel.setLayout(null);
	
	JLabel lblCustomerName = new JLabel("Customer Name");
	lblCustomerName.setForeground(Color.WHITE);
	lblCustomerName.setBounds(10, 20, 120, 20);
	customerDetailsPanel.add(lblCustomerName);
	
	customerNameText = new JTextField();
	customerNameText.setBounds(200, 20, 300, 20);
	customerDetailsPanel.add(customerNameText);
	customerNameText.setColumns(10);
	
	JLabel lblEmail = new JLabel("Email");
	lblEmail.setForeground(Color.WHITE);
	lblEmail.setBounds(10, 45, 150, 20);
	customerDetailsPanel.add(lblEmail);
	
	correspondedAddressText = new JTextField();
	correspondedAddressText.setBounds(200, 45, 300, 20);
	customerDetailsPanel.add(correspondedAddressText);
	correspondedAddressText.setColumns(10);
	
	JLabel lblConatctNumber = new JLabel("Contact Number");
	lblConatctNumber.setForeground(Color.WHITE);
	lblConatctNumber.setBounds(10, 70, 120, 20);
	customerDetailsPanel.add(lblConatctNumber);
	
	mobileNumberText = new JTextField();
	mobileNumberText.setBounds(200, 70, 300, 20);
	customerDetailsPanel.add(mobileNumberText);
	mobileNumberText.setColumns(10);
	
	JLabel lblAccountNumber = new JLabel("Account Number");
	lblAccountNumber.setForeground(Color.WHITE);
	lblAccountNumber.setBounds(10, 95, 120, 20);
	customerDetailsPanel.add(lblAccountNumber);
	
	accountNumberText = new JTextField();
	accountNumberText.setEditable(false);
	accountNumberText.setBounds(200, 95, 300, 20);
	customerDetailsPanel.add(accountNumberText);
	accountNumberText.setColumns(10);

	JPanel lockerDetailsPanel = new JPanel();
	lockerDetailsPanel.setForeground(new Color(0, 0, 0));
	lockerDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Locker Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
	lockerDetailsPanel.setBackground(new Color(0, 102, 102));
//	if(chk!=0){
	lockerDetailsPanel.setBounds(20, 150, 540, 105);
	getContentPane().add(lockerDetailsPanel);
	lockerDetailsPanel.setLayout(null);
//	}
	JLabel lblNewLabel = new JLabel("Locker Number");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setBounds(10, 45, 150, 20);
	lockerDetailsPanel.add(lblNewLabel);
	
	lockerNumberText = new JTextField();
	lockerNumberText.setEditable(false);
	lockerNumberText.setBounds(200, 45, 90, 20);
	lockerDetailsPanel.add(lockerNumberText);
	lockerNumberText.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Locker Key");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setBounds(300, 20, 80, 20);
	lockerDetailsPanel.add(lblNewLabel_1);
	
	lockerKeyText = new JTextField();
	lockerKeyText.setEditable(false);
	lockerKeyText.setBounds(400, 20, 100, 20);
	lockerDetailsPanel.add(lockerKeyText);
	lockerKeyText.setColumns(10);
	//if user then textfield replace to combobox
	JLabel lblNewLabel_2 = new JLabel("Locker Size");
	lblNewLabel_2.setForeground(Color.WHITE);
	lblNewLabel_2.setBounds(10, 20, 80, 20);
	JComboBox lockerSizeComboBox = new JComboBox();
	lockerSizeComboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
	            JComboBox<String> cb = (JComboBox<String>) e.getSource();
	            String selectedItem = (String) cb.getSelectedItem();
	            System.out.println("Selected item: " + selectedItem);
	            lockerSize=selectedItem;
	            int val=0;
	            if(selectedItem=="Small"){
	            	if(availableLockers.get(0)==3){
	            		 JOptionPane.showMessageDialog(null,"Small Locker Not Available");
	            	}
	            	else{
	            		val=1;
	            		
	            		fetchLockerDetails(val);
	            	}
	            }
	            else if (selectedItem=="Medium"){
	            
	            	if(availableLockers.get(1)==0){
	            		 JOptionPane.showMessageDialog(null,"Medium Locker Not Available");
	            	}
	            	else{
	            		val=2;
	            		fetchLockerDetails(val);
	            	}
	            }
	            else if(selectedItem=="Large"){
	            	
	            	if(availableLockers.get(2)==0){
	            		 JOptionPane.showMessageDialog(null,"Large Locker Not Available");
	            	}
	            	else{
	            		val=3;
	            		fetchLockerDetails(val);
	            	}
	            }
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	});
	lockerSizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
	lockerSizeComboBox.setSelectedIndex(-1);
	lockerDetailsPanel.add(lblNewLabel_2);
	
//	operatingInstructionText = new JTextField();
//	JComboBox OperatingInstructionComboBox = new JComboBox();
//	OperatingInstructionComboBox.setModel(new DefaultComboBoxModel(new String[] {"Singly", "Either or Surviver", "Jointly by all of Us","Jointly by two of Us", "Others"}));
//	OperatingInstructionComboBox.setSelectedIndex(-1);

	modeOfOperationComboBox = new JComboBox();
	modeOfOperationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Singly", "Either or Surviver", "Jointly by all of Us", "Jointly by two of Us", "Others"}));
	modeOfOperationComboBox.setSelectedIndex(-1);
	modeOfOperationComboBox.setMaximumRowCount(5);
	
	modeOfOperationText = new JTextField();
	lockerSizeText = new JTextField();
	if (chk==1 | chk==3) {

//		operatingInstructionText.setBounds(200, 70, 300, 20);
//		lockerDetailsPanel.add(operatingInstructionText);
//		operatingInstructionText.setColumns(10);
		

		lockerSizeText.setBounds(200, 20, 90, 20);
		lockerDetailsPanel.add(lockerSizeText);
		lockerSizeText.setColumns(10);
		lockerSizeText.setEditable(false);
		modeOfOperationText.setBounds(200, 70, 300, 20);
		lockerDetailsPanel.add(modeOfOperationText);
		modeOfOperationText.setColumns(10);
		
		
		
	}
	else if(chk==0){
//		OperatingInstructionComboBox.setBounds(200, 67, 300, 22);
//		lockerDetailsPanel.add(OperatingInstructionComboBox);
		lockerSizeComboBox.setBounds(200, 20, 90, 20);
		lockerDetailsPanel.add(lockerSizeComboBox);
		modeOfOperationComboBox.setBounds(200, 70, 300, 20);
		lockerDetailsPanel.add(modeOfOperationComboBox);
//		OperatingInstructionComboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			});
		modeOfOperationComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			});
	}
	if(chk==1)
	{
		JButton rejectButton = new JButton("Reject");
	    rejectButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		 JPanel panel = new JPanel();
	    	        JTextArea textArea = new JTextArea(5, 20);
	    	        JScrollPane scrollPane = new JScrollPane(textArea);
	    	        panel.add(scrollPane);
	    	        UIManager.put("OptionPane.background", new ColorUIResource(0, 102, 102));
			        UIManager.put("Panel.background", new ColorUIResource(0, 102, 102));
	    	        Object[] options = { "Reject", "Cancel" };

	    	        // Show the confirm dialog with custom button labels
	    	        int result = JOptionPane.showOptionDialog(null, panel, "Enter Comments", JOptionPane.OK_CANCEL_OPTION,
	    	                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	    	        // Check if the user clicked the OK button
	    	        if (result == JOptionPane.OK_OPTION) {
	    	            String comment = textArea.getText();
	    	            try {

							Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
							java.sql.Connection connection = null;
							connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
							
							PreparedStatement statement = connection.prepareStatement("select * from lockerassigned_tr where LOCKERNUM=?");
						
							statement.setString(1,lockerNumber);
							
						
							ResultSet result2 = statement.executeQuery();
							System.out.println("DB successful");
								if (result2.next()) {
									int ASSIGNEDID = result2.getInt("ASSIGNEDID");
					                int VOUCHERID = result2.getInt("VOUCHERID");
					                int CUSTOMERID = result2.getInt("CUSTOMERID");
					                int DEPOSITAMOUNT = result2.getInt("DEPOSITAMOUNT");
					                String OVERDUE = result2.getString("OVERDUE");
					                String LASTRECOVERDATE = result2.getString("LASTRECOVERDATE");
					                int RENTSTATUS = result2.getInt("RENTSTATUS");
					                String ASSIGNEDDATE = result2.getString("ASSIGNEDDATE");
					                String COMMENTS = result2.getString("COMMENTS");
					                int NOTIFYUSER = result2.getInt("NOTIFYUSER");
					                String LOCKERNUM = result2.getString("LOCKERNUM");
					                String insertQuery= "INSERT INTO lockerassigned_ht (ASSIGNEDID, VOUCHERID,CUSTOMERID,DEPOSITAMOUNT," +
										     "OVERDUE,LASTRECOVERDATE,RENTSTATUS,ASSIGNEDDATE,COMMENTS,NOTIFYUSER,LOCKERNUM) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
					                String deleteQuery="DELETE FROM lockerassigned_tr WHERE LOCKERNUM=?";
					                //Insert
					              
					                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
					                insertStatement.setInt(1, ASSIGNEDID);
					                insertStatement.setInt(2, VOUCHERID);
					                insertStatement.setInt(3, CUSTOMERID);
					                insertStatement.setInt(4, DEPOSITAMOUNT);
					                insertStatement.setString(5, OVERDUE);
					                insertStatement.setString(6, LASTRECOVERDATE);
					                insertStatement.setInt(7, RENTSTATUS);
					                insertStatement.setString(8, ASSIGNEDDATE);
					                insertStatement.setString(9, COMMENTS);
					                insertStatement.setInt(10, NOTIFYUSER);
					                insertStatement.setString(11, LOCKERNUM);
					                // Set other column values as needed

					                

//					                if(res>0){
					                	//DATA MOVE INTO ASSIGNEDLOCKER_HT FROM ASSIGNEDLOCKER_TR

	            		                //account select query
					                String selectQuery="SELECT ACCOUNTNUM FROM voucher_master_tl WHERE VOUCHERID = ?";
	            		                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
	            		                System.out.println(VOUCHERID);
	            		                selectStatement.setInt(1, VOUCHERID);
	            		                ResultSet result3 = selectStatement.executeQuery();
	            		                System.out.println("selectQuery");
	            		                if(result3.next())
	            		                {
	            		                String accountNumber=result3.getString("ACCOUNTNUM");
	            		                System.out.println(accountNumber);
	            		                //balance change
	            		                String selectBalanceQuery="Select BALANCE,ONHOLDBALANCE from ACCOUNTNEW  WHERE ACCOUNTNUM=?";
	            		                PreparedStatement selectBalanceStatement = connection.prepareStatement(selectBalanceQuery);
	            		                selectBalanceStatement.setString(1, accountNumber);
	            		                ResultSet balance = selectBalanceStatement.executeQuery();
	            		                if(balance.next())
		            		                {
		            		                System.out.println("selectBalanceQuery");
		            		                int NewBalance = balance.getInt("BALANCE")+balance.getInt("ONHOLDBALANCE");
		            		                int onHold =0;
		            		                //ONHold amount reverse into user account
		            		                String updateQuery=" UPDATE ACCOUNTNEW SET BALANCE = ?, ONHOLDBALANCE = ? WHERE ACCOUNTNUM=? ";
		            		                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
		            		                updateStatement.setInt(1, NewBalance);
		            		                updateStatement.setInt(2, onHold);
		            		                updateStatement.setString(3, accountNumber);
		            		                updateStatement.execute();
		            		                System.out.println("updateQuery");
		            		                //insert  query
		            		                insertStatement.executeUpdate();
							                System.out.println("Inserted");
		            		                //delete query
		            		                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
		            		                deleteStatement.setString(1, lockerNumber);
		            		                deleteStatement.execute();
		            		                System.out.println("deleteQuery");
		    								UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
		    								UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
		    					            JOptionPane.showMessageDialog(null, "<html>Your Comment:<br>\t" + comment + "\t</html>");
		    					            newMainMenu obj = new newMainMenu(1);
		    			    		    	obj.setSize(600, 500);
		    			    		    	obj.setVisible(true);
		    			    		    	dispose();
		            		                }
	            		                balance.close();
	            		                }
	            		                result3.close();
//					                }
					                
					                result2.close();
					                statement.close();
					                connection.close();

								}
					
						
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.print(e.getMessage());
						}
	    	          
	    	        } else if (result == JOptionPane.CANCEL_OPTION) {
	    	            // Close the JOptionPane
	    	            System.exit(0);
	    	        }
	    	}
	    });
	    rejectButton.setBounds(20, 410, 90, 30);
	    getContentPane().add(rejectButton);
	    
	    JButton referBackButton = new JButton("Refer Back");
	    referBackButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	   		 JPanel panel = new JPanel();
		        JTextArea textArea = new JTextArea(5, 20);
		        JScrollPane scrollPane = new JScrollPane(textArea);
		        panel.add(scrollPane);
		        UIManager.put("OptionPane.background", new ColorUIResource(0, 102, 102));
		        UIManager.put("Panel.background", new ColorUIResource(0, 102, 102));
		        // Set the background color of the pop-up box
		        Object[] options = { "Refer Back", "Cancel" };

		        // Show the confirm dialog with custom button labels
		        int result = JOptionPane.showOptionDialog(null, panel, "Enter Comments", JOptionPane.OK_CANCEL_OPTION,
		                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		        
		        // Check if the user clicked the OK button
		        if (result == JOptionPane.OK_OPTION) {
			            String comment = textArea.getText();

				            try {
				            	Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
								java.sql.Connection connection = null;
								java.sql.Statement  lcl_stmt =null;
								connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
								
								PreparedStatement statement = connection.prepareStatement("UPDATE lockerassigned_tr SET COMMENTS = ?, NOTIFYUSER = ? WHERE LOCKERNUM = ? ;");				
								statement.setString(1,comment);
								statement.setInt(2,1);
								statement.setString(3,lockerNumber);
								
								int rowsUpdated = statement.executeUpdate();
								System.out.print(comment);
								if (rowsUpdated>0) {
									UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
									UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));
						            JOptionPane.showMessageDialog(null, "<html>Your Comment:<br>" + comment + "<br>send to User</html>");
								
						            newMainMenu obj = new newMainMenu(1);
							    	obj.setSize(600, 500);
							    	obj.setVisible(true);
							    	dispose();
								}
							} catch (Exception e) {
								// TODO: handle exception
								System.out.print(e.getMessage());
							}
			           
		        } else if (result == JOptionPane.CANCEL_OPTION) {
		            // Close the JOptionPane
		            System.exit(0);
		        }
		}
	    });
	    referBackButton.setBounds(120, 410, 100, 30);
	    getContentPane().add(referBackButton);

	}
	
	JLabel lblLockerStatus = new JLabel("Rent Status");
	lblLockerStatus.setForeground(Color.WHITE);
	lblLockerStatus.setBounds(300, 45, 80, 20);
	lockerDetailsPanel.add(lblLockerStatus);
	
	rentStatusText = new JTextField();
	rentStatusText.setEditable(false);
	rentStatusText.setBounds(400, 45, 100, 20);
	lockerDetailsPanel.add(rentStatusText);
	rentStatusText.setColumns(10);
	
	JLabel lblNewLabel_9 = new JLabel("Mode Of Operation");
	lblNewLabel_9.setForeground(Color.WHITE);
	lblNewLabel_9.setBounds(10, 70, 120, 20);
	lockerDetailsPanel.add(lblNewLabel_9);
	
	DepositDetailsPanel.setForeground(new Color(0, 0, 0));
	DepositDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rent & Security Deposit Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
	DepositDetailsPanel.setBackground(new Color(0, 102, 102));
	DepositDetailsPanel.setBounds(20, 265, 540, 100);
	
	// DepositDetailsPanel.setBounds(20, 290, 540, 125);
	getContentPane().add(DepositDetailsPanel);
	DepositDetailsPanel.setLayout(null);
	final JLabel lbldateFormat = new JLabel("Date format: dd/MM/yyyy");
	JLabel lblNewLabel_4 = new JLabel("Mode Of Payment");
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setBounds(10, 20, 120, 20);
	DepositDetailsPanel.add(lblNewLabel_4);

	lblExpiryDate.setForeground(Color.WHITE);
	depositText = new JTextField();
	depositText.setEditable(false);
	depositText.setBounds(200, 45, 90, 20);
	DepositDetailsPanel.add(depositText);
	depositText.setColumns(10);
	
	JLabel lblNewLabel_6 = new JLabel("Overdue Date");
	lblNewLabel_6.setForeground(Color.WHITE);
	lblNewLabel_6.setBounds(300, 45, 80, 20);
	DepositDetailsPanel.add(lblNewLabel_6);
	
	overdueDateText = new JTextField();
	overdueDateText.setEditable(false);
	overdueDateText.setBounds(400, 45, 100, 20);
	DepositDetailsPanel.add(overdueDateText);
	overdueDateText.setColumns(10);
	
	JLabel lblNewLabel_7 = new JLabel("Last Rent Recover Date");
	lblNewLabel_7.setForeground(Color.WHITE);
	lblNewLabel_7.setBounds(10, 70, 150, 20);
	DepositDetailsPanel.add(lblNewLabel_7);
	
	recoverDateText = new JTextField();
	recoverDateText.setEditable(false);
	recoverDateText.setBounds(200, 70, 90, 20);
	DepositDetailsPanel.add(recoverDateText);
	recoverDateText.setColumns(10);
	
	////

	//Mode of Payment
	if(chk==0 | chk==2)
	{
				JComboBox modeOfPaymentComboBox = new JComboBox();
				modeOfPaymentComboBox.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									
					            JComboBox<String> cb = (JComboBox<String>) e.getSource();
					            String selectedItem = (String) cb.getSelectedItem();
					            System.out.println("Selected item: " + selectedItem);
					            paymentMode=selectedItem;
					            
					            int val=0;
					            if(selectedItem=="Complementary" & (chk==0 | chk==2)){
					            	// Set the new bounds here
					            
					            		DepositDetailsPanel.setBounds(20, 265, 540, 125);
					            		lblExpiryDate.setBounds(10, 95, 150, 20);
					            		lblExpiryDate.setForeground(Color.WHITE);
					            		DepositDetailsPanel.add(lblExpiryDate);
					                   	lblExpiryDate.setVisible(true);
					            		expiryDateText = new JTextField();
					            		expiryDateText.setBounds(200, 95, 90, 20);
					                    expiryDateText.setVisible(true);
					                    expiryDateText.setText("dd/MM/yyyy");
					            		DepositDetailsPanel.add(expiryDateText);
					            		expiryDateText.setForeground(Color.GRAY);
					            		expiryDateText.setColumns(10);
					            		
//					            		lbldateFormat = new JLabel()
					            		lbldateFormat.setBounds(300, 95, 150, 20);
					            		lbldateFormat.setForeground(new Color(0, 0, 0));					            		
					            		DepositDetailsPanel.add(lbldateFormat);
					            		lbldateFormat.setForeground(Color.WHITE);
					            		lbldateFormat.setVisible(true);
					            		lbldateFormat.setEnabled(false);
					            		
					            		expiryDateText.addFocusListener(new FocusAdapter() {
					            			 @Override
					            	            public void focusGained(FocusEvent e) {
					            	                if (expiryDateText.getText().equals("dd/MM/yyyy")) {
					            	                	expiryDateText.setText("");
					            	                	expiryDateText.setForeground(Color.BLACK);
					            	                }
					            			 }
					            			@Override
					            			public void focusLost(FocusEvent e) {
					            				
					            				if (expiryDateText.getText().isEmpty()) {
					            					expiryDateText.setText("dd/MM/yyyy");
					            					expiryDateText.setForeground(Color.GRAY);
					                            }
					            				///
					            				expiryDateText.setForeground(Color.GRAY);
					            				String text=expiryDateText.getText();
					            				System.out.print(text);
					            				boolean ans=formatDate(text);
					            				if(!ans){
					            					JOptionPane.showMessageDialog(null,"Invalid Date");
					            					expiryDateText.setText("dd/MM/yyyy");
					            					expiryDateText.setForeground(Color.GRAY);
					            				}
					            				
					            			}
					            		});
					                 // Repaint the panel to reflect changes
						                 DepositDetailsPanel.revalidate();
						                 DepositDetailsPanel.repaint();
					            	
					            }
					            else if (selectedItem=="Security Deposit" || selectedItem=="Yearly Rent" ){

				            		DepositDetailsPanel.setBounds(20, 265, 540, 100);
					            	
					                expiryDateText.setVisible(false);
					            	lblExpiryDate.setVisible(false);
					            	lbldateFormat.setVisible(false);
					            	DepositDetailsPanel.revalidate();
					                DepositDetailsPanel.repaint();
					            }
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
							});

					modeOfPaymentComboBox.setMaximumRowCount(3);
					modeOfPaymentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Complementary", "Security Deposit", "Yearly Rent"}));
					modeOfPaymentComboBox.setSelectedIndex(-1);
					modeOfPaymentComboBox.setBounds(200, 20, 300, 20);
					DepositDetailsPanel.add(modeOfPaymentComboBox);
				}
				else if(chk==1 | chk==3)
				{
					modeOfPaymentText = new JTextField();
					modeOfPaymentText.setBounds(200, 20, 300, 20);
					DepositDetailsPanel.add(modeOfPaymentText);
					modeOfPaymentText.setColumns(10);	
					customerNameText.setEditable(false);
					correspondedAddressText.setEditable(false);
					mobileNumberText.setEditable(false);
					accountNumberText.setEditable(false);
					lockerSizeText.setEditable(false);
					lockerKeyText.setEditable(false);
					lockerNumberText.setEditable(false);
					rentStatusText.setEditable(false);
//					operatingInstructionText.setEditable(false);
					modeOfOperationText.setEditable(false);
					modeOfPaymentText.setEditable(false);
					depositText.setEditable(false);
					overdueDateText.setEditable(false);
					recoverDateText.setEditable(false);
					

				}
				if(chk==2)
				{
					lockerSizeText.setBounds(200, 20, 90, 20);
					lockerDetailsPanel.add(lockerSizeText);
					lockerSizeText.setColumns(10);
					lockerSizeText.setEnabled(false);

//					operatingInstructionText.setEditable(true);
					depositText.setEditable(true);
					overdueDateText.setEditable(true);
					recoverDateText.setEditable(true);
					modeOfOperationComboBox.setBounds(200, 70, 300, 20);
					lockerDetailsPanel.add(modeOfOperationComboBox);
//					OperatingInstructionComboBox.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//						});
					modeOfOperationComboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
					
						}
						});
				}
	JLabel lblNewLabel_5 = new JLabel("Rent/Security Deposit");
	lblNewLabel_5.setForeground(Color.WHITE);
	lblNewLabel_5.setBounds(10, 45, 150, 20);
	DepositDetailsPanel.add(lblNewLabel_5);
	
	
	JButton backButton = new JButton("Back");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chk==0) {
				newLockerIssuance obj=new newLockerIssuance(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}else if(chk==1){
				newGrid obj=new newGrid(1);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
			else if(chk==2){
				newLockerMaintenance obj=new newLockerMaintenance(2);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
			else if(chk==3){
				newLockerMaintenance obj=new newLockerMaintenance(3);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
			
			
		}
	});
	backButton.setBounds(370, 410, 90, 30);
	getContentPane().add(backButton);
	
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
//date
	newMainMenu date = new newMainMenu(1);
    JLabel dateLabel = new JLabel(date.getCurrentDate());
    dateLabel.setForeground(Color.WHITE);
    dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    dateLabel.setBounds(10, 440, 570, 20);
    getContentPane().add(dateLabel);
    
    JButton saveButton = new JButton(chk==1 ? "Authorize" : chk==2 ? "Update": chk==3 ? "Surrender": "Save");
    saveButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		if(chk==0)
    		{
    			//user query 
    			
	            JOptionPane.showMessageDialog(null, "Save");
    		}else if(chk==1){
				//authorizer
    			try {
						Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
						java.sql.Connection connection = null;
						java.sql.Statement  lcl_stmt =null;
						connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
						PreparedStatement statement = connection.prepareStatement("select * from lockerassigned_tr where LOCKERNUM=?");
					
						statement.setString(1,lockerNumber);
						
					
						ResultSet result = statement.executeQuery();
						System.out.println("DB successful");
							if (result.next()) {
								int ASSIGNEDID = result.getInt("ASSIGNEDID");
				                int VOUCHERID = result.getInt("VOUCHERID");
				                int CUSTOMERID = result.getInt("CUSTOMERID");
				                int DEPOSITAMOUNT = result.getInt("DEPOSITAMOUNT");
				                String OVERDUE = result.getString("OVERDUE");
				                String LASTRECOVERDATE = result.getString("LASTRECOVERDATE");
				                int RENTSTATUS = result.getInt("RENTSTATUS");
				                String ASSIGNEDDATE = result.getString("ASSIGNEDDATE");
				                String COMMENTS = result.getString("COMMENTS");
				                int NOTIFYUSER = result.getInt("NOTIFYUSER");
				                String LOCKERNUM = result.getString("LOCKERNUM");
				                String insertQuery="";
				                String deleteQuery="DELETE FROM lockerassigned_tr WHERE LOCKERNUM=?";
				                String deleteTl= "DELETE FROM lockerassigned_tl WHERE LOCKERNUM=?";
				                
				                //Insert
				                if(RENTSTATUS==0)//assign
				                {
				                	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				                    Date currentDate = new Date(System.currentTimeMillis());
					                ASSIGNEDDATE=formatter.format(currentDate);
					                System.out.println(ASSIGNEDDATE);
					                 insertQuery = "INSERT INTO lockerassigned_tl (ASSIGNEDID, VOUCHERID,CUSTOMERID,DEPOSITAMOUNT," +
					                "OVERDUE,LASTRECOVERDATE,RENTSTATUS,ASSIGNEDDATE,COMMENTS,NOTIFYUSER,LOCKERNUM) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
					                
					                }
					                else if(RENTSTATUS==1)//surrender
					                {
					                	  insertQuery = "INSERT INTO lockerassigned_ht (ASSIGNEDID, VOUCHERID,CUSTOMERID,DEPOSITAMOUNT," +
									     "OVERDUE,LASTRECOVERDATE,RENTSTATUS,ASSIGNEDDATE,COMMENTS,NOTIFYUSER,LOCKERNUM) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
									}
				                
				                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
				                insertStatement.setInt(1, ASSIGNEDID);
				                insertStatement.setInt(2, VOUCHERID);
				                insertStatement.setInt(3, CUSTOMERID);
				                insertStatement.setInt(4, DEPOSITAMOUNT);
				                insertStatement.setString(5, OVERDUE);
				                insertStatement.setString(6, LASTRECOVERDATE);
				                insertStatement.setInt(7, RENTSTATUS);
				                insertStatement.setString(8, ASSIGNEDDATE);
				                insertStatement.setString(9, COMMENTS);
				                insertStatement.setInt(10, NOTIFYUSER);
				                insertStatement.setString(11, LOCKERNUM);
				             
				                System.out.println("next");

				                int res=insertStatement.executeUpdate();
				                System.out.println(res);
				                if(res>0){
				                	
				                	System.out.println("new");
				                	System.out.println(res);

				                	if(RENTSTATUS==1)//for assignment
				                	{
				                		PreparedStatement delete = connection.prepareStatement(deleteTl);
				                		delete.setString(1, lockerNumber);
				                		delete.executeUpdate();
				                	}
            		                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            		                deleteStatement.setString(1, lockerNumber);
            		                deleteStatement.executeUpdate();
				                	System.out.println("delete");
				                	//select account number
				                	String selectQuery="SELECT ACCOUNTNUM FROM voucher_master_tl WHERE VOUCHERID = ?";
            		                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            		                System.out.println(VOUCHERID);
            		                selectStatement.setInt(1, VOUCHERID);
            		                ResultSet result3 = selectStatement.executeQuery();
            		                if(result3.next())
            		                {
            		                System.out.println("selectQuery");
            		                String accountNumber=result3.getString("ACCOUNTNUM");
            		                System.out.println(accountNumber);
				                	//update onHold amount
            		                System.out.println("DEPOSITAMOUNT");
            		                String updateQuery="UPDATE ACCOUNTNEW SET BALANCE=BALANCE-ONHOLDBALANCE," +
            		                		" ONHOLDBALANCE = ONHOLDBALANCE-? WHERE ACCOUNTNUM=? ";
            		                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            		                updateStatement.setInt(1, DEPOSITAMOUNT);
            		                updateStatement.setString(2, accountNumber);
            		                updateStatement.execute();
            		                System.out.println("updateQuery");
            		                }
				                }
				                
				                result.close();
				                statement.close();
				                connection.close();
				       
				                System.out.println("Row inserted successfully!");
				                JOptionPane.showMessageDialog(null, "Authorize");
				                
							}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
//					e.printStackTrace();
				}
//    			try {
//					Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
//					java.sql.Connection connection = null;
//					java.sql.Statement  lcl_stmt =null;
//					connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
//					String deleteQuery = "DELETE FROM lockerassigned_tr WHERE LOCKERNUM=?";
//
//	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
//	                deleteStatement.executeUpdate();
//	                deleteStatement.close();
//	                connection.close();
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//					System.out.println("connection fail! FOR DELETE QUERY");
//				}
			}else if(chk==2){
				//authorizer
    			
	            JOptionPane.showMessageDialog(null, "Maintenance");
			}else if(chk==3){
				//authorizer
    			
	            JOptionPane.showMessageDialog(null, "Surrender");
			}
    	}
    });
    saveButton.setBounds(260, 410, 100, 30);
    getContentPane().add(saveButton);
    
    }
	
	// functions declarations
	public boolean formatDate(String inp){
		Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Set lenient property to false
        try {
            java.util.Date date = sdf.parse(inp);
            int month = date.getMonth() + 1; // Extract month value
            if (month > 12) {
            	JOptionPane.showMessageDialog(null,"Invalid Month");
                System.out.println("Invalid month. Please enter a month between 1 and 12.");
                return false;
            }
            System.out.println("The date you entered is: "+ sdf.format(date));
  //          System.out.println("The date you entered is: " +  new Date());
            Date currentDate = new Date();
            return !date.before(currentDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
            return false;
        }
	}
	
	
	public static boolean validateDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Disallow lenient parsing

        try {
            Date date = dateFormat.parse(dateString);
            Date currentDate = new Date(); // Get the current date
//            System.out.println(date);
//            System.out.println(currentDate);
            System.out.println("The date you entered is: " + date.getDate()+"  "+ date.getMonth()+ "  "+date.getYear());
            return !date.before(currentDate); // Check if the date is not before the current date
        } catch (ParseException e) {
        	System.out.println(e.getMessage());
            return false; // Invalid date format
        }
    }
	
	
	
	public void insertData(HashMap<String,String> custAccRelation ){
		
//		this.accountNum=custAccRelation.get("accountnum");
//		this.branchcodeid=custAccRelation.get("branchcodeid");
//		customerNameText.setText(custAccRelation.get("customername"));
//		contactInformationText.setText(custAccRelation.get("contactno"));
//		emailText.setText(custAccRelation.get("email"));
//		customerNameText.setEditable(false);
//		contactInformationText.setEditable(false);
//		emailText.setEditable(false);
//		titleOfAccountText.setText(custAccRelation.get("accounttitle"));
//		operatingInstructionText.setText(custAccRelation.get("operatinginstruction"));
////		openInBranchText.setText(custAccRelation.get("branchcode"));
//		titleOfAccountText.setEditable(false);
//		operatingInstructionText.setEditable(false);
////		openInBranchText.setEditable(false);
	}
//	
//	
//	
//	public void insertArray(ArrayList<Integer> arr){
//		availableLockers=arr;
//	}
	
	
	
	public void fetchLockerDetails(int val){
		try{
			lockerSizeId=val;
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select l.lockersizeid,l.lockersize,c.charges, s.secdeposit from lockersize l,lockercharges c,lockersecuritydeposit s where l.lockerchargesid=c.lockerchargesid and l.secdepositid=s.secdepositid and l.lockersizeid=?;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, val);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
//			    String secDeposit = result.getString("SECDEPOSIT");
//			    Integer charges= result.getInt("CHARGES");
//			    
//			   securityDepositText.setEnabled(true);
//			   yearlyRentText.setEnabled(true);
//			   
//			   securityDepositText.setText(secDeposit);
//			   yearlyRentText.setText(Integer.toString(charges));
//			    		
//			     	 
//			   securityDepositLabel.setEnabled(true);
//			   yearlyRentLabel.setEnabled(true);
//			    
//			   
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			 JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	
	}

	// customer Details fetching function
	public void getCustDetails(String lockerNumber){
			
			try{
				
				Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
				java.sql.Connection connection = null;
				java.sql.Statement  lcl_stmt =null;
				connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
							
				String query="select c.customerid,c.customername,c.email, c.contactno  from Accountnew a, customerAccountRelationship r, customer c where a.accountNum=r.accountNum and r.customerId=c.customerid and a.accountNum=?;";
				PreparedStatement statement = connection.prepareStatement(query);
				
				statement.setString(1, lockerNumber);
				
				ResultSet result = statement.executeQuery();
				
				String queryAccount="select  a.accountNum,a.accounttitle, a.branchCode, o.operatinginstruction from accountnew a,operatinginstruction o where a.operatinginstructionid=o.operatinginstructionid  and accountnum=?;";
				PreparedStatement statementAccount = connection.prepareStatement(queryAccount);
				
				statementAccount.setString(1, lockerNumber);
				
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
				    customerDetails obj= new customerDetails(0);
				    	obj.insertData(customerAccountRelationship);
				    	obj.insertArray(availableLockers);
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
	public void fetchDetails()
	{
		try {
		Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		java.sql.Connection connection = null;
		java.sql.Statement  lcl_stmt =null;
		connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
		
		PreparedStatement statement = connection.prepareStatement("select temp.customername,temp.email, temp.contactno,temp.accountNum,temp.lockerno,temp.lockersizeid,temp.keynum, temp.rentstatus,temp.depositamount,temp.overdue, temp.lastrecoverdate, p.modeofpayment,p.expiry_date, o.modeofoperation from modeofpayment p,("
				+ "select *,tr.lockernum as lockerno  from lockerAssigned_tr tr, locker l,customer c, voucher_master_tl v where tr.lockernum=l.lockernum and tr.voucherid=v.voucherid and tr.customerid=c.customerid and tr.lockernum=?) temp"
				+ ", modeofoperation o where temp.modeofoperationid=o.modeofoperationid and temp.modeofpaymentid=p.modeofpaymentid;");
	
		statement.setString(1,lockerNumber);
		ResultSet result = statement.executeQuery();
		System.out.println("After Execution");
		
		if (result.next()) {
//			System.out.println(result.getString("AUTH"));
//			Global.userId=result.getInt("USERID");
			customerNameText.setText(result.getString("CUSTOMERNAME"));
			correspondedAddressText.setText(result.getString("EMAIL"));
			mobileNumberText.setText(result.getString("CONTACTNO"));
			
			accountNumberText.setText(result.getString("ACCOUNTNUM"));
			
			lockerSizeText.setText(lockerSizeName.get(result.getInt("LOCKERSIZEID")));
			
			lockerKeyText.setText(result.getString("KEYNUM"));
			
			rentStatusText.setText(rentStatus.get(result.getInt("RENTSTATUS")));
			lockerNumberText.setText(result.getString("LOCKERNO"));
			
			modeOfOperationText.setText(result.getString("MODEOFOPERATION"));
			
			modeOfPaymentText.setText(result.getString("MODEOFPAYMENT"));
//			depositText.setText(result.getString("DEPOSITAMOUNT"));
			if(modeOfPaymentText.equals("Complementary"))
			{
				expiryDateText = new JTextField();
				expiryDateText.setBounds(300, 70, 100, 20);
				expiryDateText.setEditable(false);
		        expiryDateText.setVisible(true);
				DepositDetailsPanel.add(expiryDateText);
				expiryDateText.setColumns(10);
				
				lblExpiryDate.setBounds(10, 95, 150, 20);
        		lblExpiryDate.setForeground(Color.WHITE);
        		DepositDetailsPanel.add(lblExpiryDate);
               	lblExpiryDate.setVisible(true);
			}
			overdueDateText.setText(result.getString("OVERDUE"));
			depositText.setText(Integer.toString(result.getInt("DEPOSITAMOUNT")));
			recoverDateText.setText(result.getString("LASTRECOVERDATE"));
			
			if(result.getString("MODEOFOPERATION").equals("Complementary")) {
//				expiryTextField = new JTextField();
//				expiryTextField.setBounds(400, 70, 100, 20);
//				DepositDetailsPanel.add(expiryTextField);
//				expiryTextField.setColumns(10);
//				expiryTextField.setText(result.getString("EXPIRY_DATE"));
//				expiryTextField.setEditable(false);
//				
//				JLabel lblNewLabel_3 = new JLabel("Expiry");
//				lblNewLabel_3.setForeground(new Color(255, 255, 255));
//				lblNewLabel_3.setBounds(300, 73, 56, 14);
//				DepositDetailsPanel.add(lblNewLabel_3);
				
				
				
				DepositDetailsPanel.setBounds(20, 265, 540, 125);
        		lblExpiryDate.setBounds(10, 95, 150, 20);
        		lblExpiryDate.setForeground(Color.WHITE);
        		DepositDetailsPanel.add(lblExpiryDate);
               	lblExpiryDate.setVisible(true);
        		expiryDateText = new JTextField();
        		expiryDateText.setBounds(200, 95, 90, 20);
                expiryDateText.setVisible(true);
        		DepositDetailsPanel.add(expiryDateText);
        		expiryDateText.setColumns(10);
        		
//        		lbldateFormat = new JLabel()
//        		lbldateFormat.setBounds(300, 95, 150, 20);
//        		lbldateFormat.setForeground(new Color(0, 0, 0));					            		
//        		DepositDetailsPanel.add(lbldateFormat);
//        		lbldateFormat.setForeground(Color.WHITE);
//        		lbldateFormat.setVisible(true);
//        		lbldateFormat.setEnabled(false);
//        		
        		
				
				
//        		DepositDetailsPanel.add(expiryTextField);
//        		
//        		DepositDetailsPanel.setForeground(new Color(0, 0, 0));
//        		DepositDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rent & Security Deposit Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
//        		DepositDetailsPanel.setBackground(new Color(0, 102, 102));
//        		DepositDetailsPanel.setBounds(20, 265, 540, 100);
        	
                 
			}
		
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Locker Number Not Found");
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		// TODO: handle exception
		System.out.println("DB Connection fail");
		JOptionPane.showMessageDialog(null,"DB Connection Failed");
	}
	}
	 public static void main(String[] args) {
		 newDetails frame = new newDetails(1);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    	
	    }
}

