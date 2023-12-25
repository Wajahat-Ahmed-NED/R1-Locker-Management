package LockerManagement;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class customerDetails extends JFrame {
	
	
	private JTextField customerNameText;
	private JTextField emailText;
	private JTextField contactInformationText;
	private JTextField titleOfAccountText;
	private JTextField operatingInstructionText;
//	private JTextField openInBranchText;
	private JTextField securityDepositText;
	private JTextField yearlyRentText;
	private JTextField expiryDateText;
	public int chk;
	ArrayList<Integer> availableLockers;
	JLabel securityDepositLabel = new JLabel("Security Deposit :");
	JLabel yearlyRentLabel = new JLabel("Yearly Rent :");
	JLabel expiryDateLabel = new JLabel("Expiry Date");
	private JTextField lockerNumberText;
	private JTextField keyNumberText;
	public String accountNum;
	public String branchcodeid;
	public String lockerSize;
	public String operationMode;
	public String paymentMode;
	public Integer lockerSizeId;
	
	
	public customerDetails(final int chk)
	{
		
		
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		setTitle("Customer Details");
		getContentPane().setLayout(null);
		this.chk=chk;
		
		if (chk==0) {
			
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(10, 33, 112, 20);
		getContentPane().add(lblCustomerName);
		
		customerNameText = new JTextField();
		customerNameText.setForeground(Color.BLACK);
		customerNameText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		customerNameText.setBounds(144, 33, 183, 20);
		getContentPane().add(customerNameText);
		customerNameText.setColumns(10);
		
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(10, 64, 112, 20);
		getContentPane().add(lblEmailAddress);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(144, 64, 183, 20);
		getContentPane().add(emailText);
		
		JLabel lblContactInformation = new JLabel("Contact Information");
		lblContactInformation.setBounds(10, 95, 112, 20);
		getContentPane().add(lblContactInformation);
		
		JLabel lblTitleOfAccount = new JLabel("Title Of Account");
		lblTitleOfAccount.setBounds(10, 126, 112, 20);
		getContentPane().add(lblTitleOfAccount);
		
		JLabel lblOperatingInstruction = new JLabel("Operating Instruction");
		lblOperatingInstruction.setBounds(10, 157, 112, 20);
		getContentPane().add(lblOperatingInstruction);
		
//		JLabel lblOpenInBranch = new JLabel("Open In Branch");
//		lblOpenInBranch.setBounds(10, 188, 112, 20);
//		getContentPane().add(lblOpenInBranch);
		
		contactInformationText = new JTextField();
		contactInformationText.setColumns(10);
		contactInformationText.setBounds(144, 95, 183, 20);
		getContentPane().add(contactInformationText);
		
		titleOfAccountText = new JTextField();
		titleOfAccountText.setEditable(false);
		titleOfAccountText.setColumns(10);
		titleOfAccountText.setBounds(144, 126, 183, 20);
		getContentPane().add(titleOfAccountText);
		
		operatingInstructionText = new JTextField();
		operatingInstructionText.setEditable(false);
		operatingInstructionText.setColumns(10);
		operatingInstructionText.setBounds(144, 157, 183, 20);
		getContentPane().add(operatingInstructionText);
		
//		openInBranchText = new JTextField();
//		openInBranchText.setEditable(false);
//		openInBranchText.setColumns(10);
//		openInBranchText.setBounds(144, 188, 183, 20);
//		getContentPane().add(openInBranchText);
		
		JLabel lblLockerSize = new JLabel("Locker Size");
		lblLockerSize.setBounds(10, 230, 112, 20);
		getContentPane().add(lblLockerSize);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {

//			 @Override
	            public void actionPerformed(ActionEvent e) {
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
	                
	               
	            }
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(144, 219, 183, 20);
		getContentPane().add(comboBox);
		
		
		securityDepositLabel.setEnabled(false);
		securityDepositLabel.setBounds(10, 260, 89, 14);
		getContentPane().add(securityDepositLabel);
		
		
		securityDepositText = new JTextField();
		securityDepositText.setEnabled(false);
		securityDepositText.setBackground(new Color(0, 153, 102));
		securityDepositText.setEditable(false);
		securityDepositText.setBounds(109, 257, 86, 20);
		getContentPane().add(securityDepositText);
		securityDepositText.setColumns(10);
		
		
		yearlyRentLabel.setEnabled(false);
		yearlyRentLabel.setBounds(205, 260, 89, 17);
		getContentPane().add(yearlyRentLabel);
		
		
		yearlyRentText = new JTextField();
		yearlyRentText.setBackground(new Color(0, 153, 102));
		yearlyRentText.setEnabled(false);
		yearlyRentText.setEditable(false);
		yearlyRentText.setColumns(10);
		yearlyRentText.setBounds(273, 257, 86, 20);
		getContentPane().add(yearlyRentText);
		
		JLabel lblModeOfOperation = new JLabel("Mode Of Operation");
		lblModeOfOperation.setBounds(10, 299, 112, 20);
		getContentPane().add(lblModeOfOperation);
		
		JComboBox modeOfOperationComboBox = new JComboBox();
		modeOfOperationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Singly", "Either or Surviver", "Jointly by all of Us", "Jointly by two of Us"}));
		modeOfOperationComboBox.setSelectedIndex(-1);
		modeOfOperationComboBox.setMaximumRowCount(5);
		modeOfOperationComboBox.setBounds(144, 299, 183, 20);
		getContentPane().add(modeOfOperationComboBox);
		
		modeOfOperationComboBox.addActionListener(new ActionListener() {

	//		 @Override
	            public void actionPerformed(ActionEvent e) {
	                JComboBox<String> cb = (JComboBox<String>) e.getSource();
	                String selectedItem = (String) cb.getSelectedItem();
	                System.out.println("Selected item: " + selectedItem);
	          
	                operationMode=selectedItem;
	               
			 }
		});
		
		
		
		JLabel lblModeOfPayment = new JLabel("Mode Of Payment");
		lblModeOfPayment.setBounds(10, 336, 112, 20);
		getContentPane().add(lblModeOfPayment);
		
		JComboBox modeOfPaymentComboBox = new JComboBox();
		modeOfPaymentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Complementary", "Security Deposit", "Yearly Rent"}));
		modeOfPaymentComboBox.addActionListener(new ActionListener() {

//			 @Override
	            public void actionPerformed(ActionEvent e) {
	                JComboBox<String> cb = (JComboBox<String>) e.getSource();
	                String selectedItem = (String) cb.getSelectedItem();
	                System.out.println("Selected item: " + selectedItem);
	                paymentMode=selectedItem;
	                
	                int val=0;
	                
	                if(selectedItem=="Complementary"){
	                	expiryDateText.setEnabled(true);
	                	expiryDateText.setEditable(true);
	                	
	                	expiryDateLabel.setEnabled(true);
	                	
	                }
	                else if (selectedItem=="Security Deposit" || selectedItem=="Yearly Rent"){
	                	expiryDateText.setEnabled(false);
	                	expiryDateText.setEditable(false);
	                	
	                	expiryDateLabel.setEnabled(false);
	                	
	                }
	              
			 }
		}
		);
		modeOfPaymentComboBox.setSelectedIndex(-1);
		modeOfPaymentComboBox.setMaximumRowCount(5);
		modeOfPaymentComboBox.setBounds(144, 336, 183, 20);
		getContentPane().add(modeOfPaymentComboBox);
		
		
		expiryDateLabel.setEnabled(false);
		expiryDateLabel.setBounds(10, 363, 112, 20);
		getContentPane().add(expiryDateLabel);
		
		expiryDateText = new JTextField();
		expiryDateText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String text=expiryDateText.getText();
				boolean ans=formatDate(text);
				if(!ans){
					JOptionPane.showMessageDialog(null,"Invalid Date");
				}
				
			}
		});
		
		expiryDateText.setBackground(new Color(0, 153, 102));
		expiryDateText.setEditable(false);
		expiryDateText.setEnabled(false);
		expiryDateText.setBounds(132, 363, 86, 20);
		getContentPane().add(expiryDateText);
		expiryDateText.setColumns(10);
	
		
		JLabel lblDateFormatDdmmyyyy = new JLabel("Date Format dd/MM/yyyy");
		lblDateFormatDdmmyyyy.setBounds(228, 367, 141, 14);
		getContentPane().add(lblDateFormatDdmmyyyy);
		
		}
		
		else if(chk==1){
			JLabel lblOperatingInstruction = new JLabel("Operating Instruction");
			lblOperatingInstruction.setBounds(10, 153, 112, 20);
			getContentPane().add(lblOperatingInstruction);
			
			operatingInstructionText = new JTextField();
			operatingInstructionText.setEditable(false);
			operatingInstructionText.setColumns(10);
			operatingInstructionText.setBounds(144, 153, 183, 20);
			getContentPane().add(operatingInstructionText);
			
			JLabel lblLockerSize = new JLabel("Locker Size");
			lblLockerSize.setBounds(10, 184, 112, 20);
			getContentPane().add(lblLockerSize);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
			comboBox.setMaximumRowCount(3);
			comboBox.setSelectedIndex(-1);
			comboBox.setBounds(144, 184, 183, 20);
			getContentPane().add(comboBox);
			
			JLabel lblSecurityDeposit = new JLabel("Security Deposit :");
			lblSecurityDeposit.setEnabled(false);
			lblSecurityDeposit.setBounds(10, 301, 89, 14);
			getContentPane().add(lblSecurityDeposit);
			
			securityDepositText = new JTextField();
			securityDepositText.setEnabled(false);
			securityDepositText.setBackground(new Color(0, 153, 102));
			securityDepositText.setEditable(false);
			securityDepositText.setBounds(110, 298, 86, 20);
			getContentPane().add(securityDepositText);
			securityDepositText.setColumns(10);
			
			JLabel lblYearlyRent = new JLabel("Yearly Rent :");
			lblYearlyRent.setEnabled(false);
			lblYearlyRent.setBounds(206, 300, 89, 17);
			getContentPane().add(lblYearlyRent);
			
			yearlyRentText = new JTextField();
			yearlyRentText.setBackground(new Color(0, 153, 102));
			yearlyRentText.setEnabled(false);
			yearlyRentText.setEditable(false);
			yearlyRentText.setColumns(10);
			yearlyRentText.setBounds(278, 298, 86, 20);
			getContentPane().add(yearlyRentText);
			
			JLabel lblModeOfOperation = new JLabel("Mode Of Operation");
			lblModeOfOperation.setBounds(10, 215, 112, 20);
			getContentPane().add(lblModeOfOperation);
			
			JComboBox modeOfOperationComboBox = new JComboBox();
			modeOfOperationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "Either or Surviver", "Jointly by all of Us", "Jointly by two of Us", "Others(Please Specify)"}));
			modeOfOperationComboBox.setSelectedIndex(-1);
			modeOfOperationComboBox.setMaximumRowCount(5);
			modeOfOperationComboBox.setBounds(144, 215, 183, 20);
			getContentPane().add(modeOfOperationComboBox);
			
			JLabel lblModeOfPayment = new JLabel("Mode Of Payment");
			lblModeOfPayment.setBounds(10, 246, 112, 20);
			getContentPane().add(lblModeOfPayment);
			
			JComboBox modeOfPaymentComboBox = new JComboBox();
			modeOfPaymentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Complementary", "Security Deposit", "Yearly Rent"}));
			modeOfPaymentComboBox.setSelectedIndex(-1);
			modeOfPaymentComboBox.setMaximumRowCount(5);
			modeOfPaymentComboBox.setBounds(144, 246, 183, 20);
			getContentPane().add(modeOfPaymentComboBox);
			
			JLabel lblExpiryDate = new JLabel("Expiry Date");
			lblExpiryDate.setEnabled(false);
			lblExpiryDate.setBounds(10, 329, 112, 20);
			getContentPane().add(lblExpiryDate);
			
			expiryDateText = new JTextField();
			expiryDateText.setBackground(new Color(0, 153, 102));
			expiryDateText.setEditable(false);
			expiryDateText.setEnabled(false);
			expiryDateText.setBounds(110, 329, 86, 20);
			getContentPane().add(expiryDateText);
			expiryDateText.setColumns(10);
			
			lockerNumberText = new JTextField();
			lockerNumberText.setEditable(false);
			lockerNumberText.setBounds(144, 91, 183, 20);
			getContentPane().add(lockerNumberText);
			lockerNumberText.setColumns(10);
			
			JLabel lblLockerNumber = new JLabel("Locker Number");
			lblLockerNumber.setBounds(10, 91, 112, 20);
			getContentPane().add(lblLockerNumber);
			
			JLabel lblKeyNumber = new JLabel("Key Number");
			lblKeyNumber.setBounds(10, 122, 112, 20);
			getContentPane().add(lblKeyNumber);
			
			keyNumberText = new JTextField();
			keyNumberText.setEditable(false);
			keyNumberText.setBounds(144, 122, 183, 20);
			getContentPane().add(keyNumberText);
			keyNumberText.setColumns(10);
		}

		JButton signOffButton = new JButton("Sign Off");
		signOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(10, 394, 89, 23);
		getContentPane().add(signOffButton);
		
		
		
	JButton backButton = new JButton("Back");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (chk==0) {
				lockerIssuance obj=new lockerIssuance(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}else if(chk==1){
				lockerMaintenance obj=new lockerMaintenance(1);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
//			else if(chk==2){
//				lockerMaintenance obj=new lockerMaintenance(2);
//				obj.setVisible(true);
//				obj.setSize(600, 500);
//				dispose();
//			}

		}
	});
	backButton.setBounds(355, 394, 89, 23);
	getContentPane().add(backButton);
	
	
	
	
	if(chk==0){
		
	JButton addToGridButton = new JButton("Save");
	
	
	addToGridButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Object [][] data= {
				   {accountNum,titleOfAccountText.getText(),branchcodeid,lockerSize,operationMode,paymentMode,expiryDateText.getText()}
				};
			
			grid obj=new grid(0,true);
			obj.setData(data,lockerSizeId);
			obj.setSize(600,500);
			obj.setVisible(true);
			
			
		}
	});
	addToGridButton.setBounds(121, 394, 109, 23);
	getContentPane().add(addToGridButton);
	}
//	if (chk==1) {
//		saveButton.setText("Authorize");
//	}
	
	JButton cancelButton = new JButton("Cancel");
	cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
		}
	});
	cancelButton.setBounds(248, 394, 89, 23);
	getContentPane().add(cancelButton);
		
		
		
		
		
	}
	
	
	
	
	
	public boolean formatDate(String inp){
		Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String userDateInput = inp;

        try {
            java.util.Date date = sdf.parse(userDateInput);
            System.out.println("The date you entered is: " + date.getDate()+"  "+ date.getMonth()+ " "+date.getYear());
            System.out.println("The date you entered is: " +  new Date());
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
            return !date.before(currentDate); // Check if the date is not before the current date
        } catch (ParseException e) {
        	System.out.println(e.getMessage());
            return false; // Invalid date format
        }
    }
	
	
	
	public void insertData(HashMap<String,String> custAccRelation ){
		
		this.accountNum=custAccRelation.get("accountnum");
		this.branchcodeid=custAccRelation.get("branchcodeid");
		customerNameText.setText(custAccRelation.get("customername"));
		contactInformationText.setText(custAccRelation.get("contactno"));
		emailText.setText(custAccRelation.get("email"));
		customerNameText.setEditable(false);
		contactInformationText.setEditable(false);
		emailText.setEditable(false);
		titleOfAccountText.setText(custAccRelation.get("accounttitle"));
		operatingInstructionText.setText(custAccRelation.get("operatinginstruction"));
//		openInBranchText.setText(custAccRelation.get("branchcode"));
		titleOfAccountText.setEditable(false);
		operatingInstructionText.setEditable(false);
//		openInBranchText.setEditable(false);
	}
	
	
	
	public void insertArray(ArrayList<Integer> arr){
		availableLockers=arr;
	}
	
	
	
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
			    String secDeposit = result.getString("SECDEPOSIT");
			    Integer charges= result.getInt("CHARGES");
			    
			   securityDepositText.setEnabled(true);
			   yearlyRentText.setEnabled(true);
			   
			   securityDepositText.setText(secDeposit);
			   yearlyRentText.setText(Integer.toString(charges));
			    		
			     	 
			   securityDepositLabel.setEnabled(true);
			   yearlyRentLabel.setEnabled(true);
			    
			   
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			 JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	}
	
	 public static void main(String[] args) {
		 customerDetails frame = new customerDetails(0);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    	
	    }
}
