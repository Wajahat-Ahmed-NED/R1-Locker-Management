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
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class customerDetails extends JFrame {
	private JTextField customerNameText;
	private JTextField emailText;
	private JTextField contactInformationText;
	private JTextField titleOfAccountText;
	private JTextField mobileText;
	private JTextField openInBranchText;
	private JButton authorizeButton;
	public int chk;
	ArrayList<Integer> availableLockers;
	JLabel securityDepositLabel = new JLabel("Security Deposit :");
	JLabel yearlyRentLabel = new JLabel("Yearly Rent :");
	JLabel expiryDateLabel = new JLabel("Expiry Date");
	private JTextField nameText;
	private JTextField corresspondedAddressText;
	private JTextField accountNumberText;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField operatingInstrucionText;
	private JTextField modeOfPaymentText;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	final JTextPane textPane = new JTextPane();
	
	
	public customerDetails(final int chk)
	{
		setResizable(false);
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		setTitle("Customer Details");
		getContentPane().setLayout(null);
		this.chk=chk;
//		customerAccountRelationship=custAccRelation;
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
		
		JLabel lblOpenInBranch = new JLabel("Open In Branch");
		lblOpenInBranch.setBounds(10, 188, 112, 20);
		getContentPane().add(lblOpenInBranch);
		
		contactInformationText = new JTextField();
		contactInformationText.setColumns(10);
		contactInformationText.setBounds(144, 95, 183, 20);
		getContentPane().add(contactInformationText);
		
		titleOfAccountText = new JTextField();
		titleOfAccountText.setEditable(false);
		titleOfAccountText.setColumns(10);
		titleOfAccountText.setBounds(144, 126, 183, 20);
		getContentPane().add(titleOfAccountText);
		
		mobileText = new JTextField();
		mobileText.setEditable(false);
		mobileText.setColumns(10);
		mobileText.setBounds(144, 157, 183, 20);
		getContentPane().add(mobileText);
		
		openInBranchText = new JTextField();
		openInBranchText.setEditable(false);
		openInBranchText.setColumns(10);
		openInBranchText.setBounds(144, 188, 183, 20);
		getContentPane().add(openInBranchText);
		
		JLabel lblLockerSize = new JLabel("Locker Size");
		lblLockerSize.setBounds(10, 230, 112, 20);
		getContentPane().add(lblLockerSize);
		
		}
		
//		else if(chk==1){
			surrenderPanel();
//		}

		JButton signOffButton = new JButton("Sign Off");
		signOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(10, 431, 89, 23);
		getContentPane().add(signOffButton);
	
	
		
		JButton referBackButton = new JButton("Refer Back");
		referBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {;
//				textPane.setEnabled(true);
			}
		});
		referBackButton.setBounds(109, 431, 133, 23);
		getContentPane().add(referBackButton);
			
	JButton rejectButton = new JButton("Reject");
	rejectButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
//			textPane.setEnabled(true);
			
		}
	});
	rejectButton.setBounds(250, 431, 89, 23);
	getContentPane().add(rejectButton);
	
	authorizeButton = new JButton("Authorize");
	if (chk==1) {
		authorizeButton.setText("Authorize");
	}
	authorizeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			if (chk==1) {
				try {
					Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
					java.sql.Connection connection = null;
					java.sql.Statement  lcl_stmt =null;
					connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
								
					String query="select LOCKERNUM from lockerassigned_tr";
					PreparedStatement statement = connection.prepareStatement(query);
					
					ResultSet result = statement.executeQuery();
					System.out.println("ariz");
					System.out.println(result.getString("LOCKERNUM"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				//validation for account check
				
				
			}
		}
	});
	authorizeButton.setBounds(349, 431, 89, 23);
	getContentPane().add(authorizeButton);
	
	JButton cancelButton = new JButton("Cancel");
	cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
		}
	});
	cancelButton.setBounds(449, 431, 89, 23);
	getContentPane().add(cancelButton);
	
				
	}
	
	
	
	public void surrenderPanel()
	{
		JPanel customerDetailsPanel = new JPanel();
		customerDetailsPanel.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerDetailsPanel.setBackground(new Color(0, 153, 102));
		customerDetailsPanel.setBounds(61, 11, 434, 121);
		getContentPane().add(customerDetailsPanel);
		customerDetailsPanel.setLayout(null);
		
		JLabel lblLockerNumber = new JLabel("Customer Name");
		lblLockerNumber.setBounds(23, 34, 76, 14);
		customerDetailsPanel.add(lblLockerNumber);
		
		JLabel lblKeyNumber = new JLabel("Corresponded Address");
		lblKeyNumber.setBounds(23, 52, 112, 20);
		customerDetailsPanel.add(lblKeyNumber);
		
		nameText = new JTextField();
		nameText.setBounds(166, 11, 258, 20);
		customerDetailsPanel.add(nameText);
		nameText.setVisible(false);
		nameText.setEditable(false);
		nameText.setColumns(10);
		
		corresspondedAddressText = new JTextField();
		corresspondedAddressText.setBounds(166, 34, 258, 20);
		customerDetailsPanel.add(corresspondedAddressText);
		corresspondedAddressText.setEditable(false);
		corresspondedAddressText.setColumns(10);
		
				JLabel lblOperatingInstruction = new JLabel("Mobile");
				lblOperatingInstruction.setBounds(23, 71, 112, 20);
				customerDetailsPanel.add(lblOperatingInstruction);
				
				mobileText = new JTextField();
				mobileText.setBounds(166, 62, 258, 20);
				customerDetailsPanel.add(mobileText);
				mobileText.setEditable(false);
				mobileText.setColumns(10);
				
				accountNumberText = new JTextField();
				accountNumberText.setBounds(166, 91, 258, 20);
				customerDetailsPanel.add(accountNumberText);
				accountNumberText.setColumns(10);
				
				JLabel lblAccountNumber = new JLabel("Account Number");
				lblAccountNumber.setBounds(23, 91, 112, 20);
				customerDetailsPanel.add(lblAccountNumber);
				
				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Locker Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.setBackground(new Color(0, 153, 102));
				panel.setBounds(61, 132, 434, 102);
				getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblLocker = new JLabel("Locker Number");
				lblLocker.setBounds(33, 24, 112, 20);
				panel.add(lblLocker);
				
				textField = new JTextField();
				textField.setBounds(155, 24, 89, 20);
				panel.add(textField);
				textField.setColumns(10);
				
				JLabel lblSize = new JLabel("Size");
				lblSize.setBounds(268, 27, 35, 14);
				panel.add(lblSize);
				
				JLabel lblLockerKey = new JLabel("Locker Key");
				lblLockerKey.setBounds(33, 55, 89, 14);
				panel.add(lblLockerKey);
				
				textField_1 = new JTextField();
				textField_1.setBounds(157, 52, 89, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblStatus = new JLabel("Status");
				lblStatus.setBounds(268, 58, 46, 14);
				panel.add(lblStatus);
				
				JLabel lblOperatingInstruction_1 = new JLabel("Operating Instruction");
				lblOperatingInstruction_1.setBounds(35, 80, 112, 14);
				panel.add(lblOperatingInstruction_1);
				
				operatingInstrucionText = new JTextField();
				operatingInstrucionText.setBounds(157, 77, 258, 20);
				panel.add(operatingInstrucionText);
				operatingInstrucionText.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(324, 24, 79, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(324, 52, 79, 20);
				panel.add(textField_4);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rent & Security Deposit Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBackground(new Color(0, 153, 102));
				panel_1.setBounds(61, 245, 434, 121);
				getContentPane().add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblModeOfPaymeent = new JLabel("Mode Of Payment");
				lblModeOfPaymeent.setBounds(10, 22, 99, 14);
				panel_1.add(lblModeOfPaymeent);
				
				modeOfPaymentText = new JTextField();
				modeOfPaymentText.setBounds(165, 19, 248, 20);
				panel_1.add(modeOfPaymentText);
				modeOfPaymentText.setColumns(10);
				
				JLabel lblRentsecurityDepositAmount = new JLabel("Rent/Security Deposit Amount");
				lblRentsecurityDepositAmount.setBounds(10, 47, 145, 14);
				panel_1.add(lblRentsecurityDepositAmount);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(165, 44, 248, 20);
				panel_1.add(textField_3);
				
				JLabel lblOverdues = new JLabel("Overdue Date");
				lblOverdues.setBounds(256, 94, 79, 14);
				panel_1.add(lblOverdues);
				
				textField_5 = new JTextField();
				textField_5.setBounds(334, 91, 79, 20);
				panel_1.add(textField_5);
				textField_5.setColumns(10);
				
				JLabel lblLastRentRecover = new JLabel("Last Rent Recover Date");
				lblLastRentRecover.setBounds(10, 97, 129, 14);
				panel_1.add(lblLastRentRecover);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(165, 91, 79, 20);
				panel_1.add(textField_6);
				
				JLabel lblRentStatus = new JLabel("Rent Status");
				lblRentStatus.setBounds(10, 72, 79, 14);
				panel_1.add(lblRentStatus);
				
				textField_7 = new JTextField();
				textField_7.setBounds(165, 69, 248, 20);
				panel_1.add(textField_7);
				textField_7.setColumns(10);


		textPane.setBorder(new TitledBorder(null, "Comments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textPane.setEnabled(false);
		textPane.setBounds(61, 377, 434, 43);
		getContentPane().add(textPane);

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
		
		customerNameText.setText(custAccRelation.get("customername"));
		contactInformationText.setText(custAccRelation.get("contactno"));
		emailText.setText(custAccRelation.get("email"));
		customerNameText.setEditable(false);
		contactInformationText.setEditable(false);
		emailText.setEditable(false);
		titleOfAccountText.setText(custAccRelation.get("accounttitle"));
		mobileText.setText(custAccRelation.get("operatinginstruction"));
		openInBranchText.setText(custAccRelation.get("branchcode"));
		titleOfAccountText.setEditable(false);
		mobileText.setEditable(false);
		openInBranchText.setEditable(false);
	}
	
	
	
	public void insertArray(ArrayList<Integer> arr){
		availableLockers=arr;
	}
	
	
	
	public void fetchLockerDetails(int val){
		try{
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
			    
			   
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			 JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	}
	
	 public static void main(String[] args) {
		 customerDetails frame = new customerDetails(1);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    	
	    }
}
