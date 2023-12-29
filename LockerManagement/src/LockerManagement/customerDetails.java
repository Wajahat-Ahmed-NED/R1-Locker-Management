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
import java.time.LocalDate;
import java.time.Period;
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
//	private JTextField openInBranchText;
	private JButton authorizeButton;

//	private JTextField operatingInstructionText;
//	private JTextField openInBranchText;
	private JTextField securityDepositText;
	private JTextField yearlyRentText;
	private JTextField expiryDateText;

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
	Integer paymentId;
	Integer operationId;
	private JTextField lockerNumberText;
	private JTextField keyNumberText;
	public String accountNum;
	public String branchcodeid;
	public String lockerSize;
	public String operationMode;
	public String paymentMode;
	public Integer lockerSizeId;
	public String lockerNo;
	public String refNo;
	public String expiryDate;
	JComboBox comboBox = new JComboBox();
	double charges;
	double actualCharges;
	
	public customerDetails(final int chk)
	{

		setResizable(false);

		
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
		
		mobileText = new JTextField();
		mobileText.setEditable(false);
		mobileText.setColumns(10);
		mobileText.setBounds(144, 157, 183, 20);
		getContentPane().add(mobileText);
		
//		openInBranchText = new JTextField();
//		openInBranchText.setEditable(false);
//		openInBranchText.setColumns(10);
//		openInBranchText.setBounds(144, 188, 183, 20);
//		getContentPane().add(openInBranchText);
		
		JLabel lblLockerSize = new JLabel("Locker Size");
		lblLockerSize.setBounds(10, 230, 112, 20);
		getContentPane().add(lblLockerSize);
		


		
		comboBox.addActionListener(new ActionListener() {

//			 @Override
	            public void actionPerformed(ActionEvent e) {
	                JComboBox<String> cb = (JComboBox<String>) e.getSource();
	                String selectedItem = (String) cb.getSelectedItem();
	                System.out.println("Selected item: " + selectedItem);
	                lockerSize=selectedItem;
	                
	                int val=0;
	                
	                
	                if(selectedItem=="Small"){
	                	if(availableLockers.get(0)==0){
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
	                operationId = cb.getSelectedIndex()+1;
	               
	                System.out.println("Selected item: " + selectedItem + " "+operationId);
	                
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
	                paymentId=cb.getSelectedIndex()+1;
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
			surrenderPanel();
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
		signOffButton.setBounds(10, 431, 89, 23);
		getContentPane().add(signOffButton);
	
	
		
if(chk==1) {
	

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
}
		
		
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
	backButton.setBounds(356, 431, 89, 23);
	getContentPane().add(backButton);
	
	
	
	
	if(chk==0){
		
	JButton addToGridButton = new JButton("Save");
	
	
	addToGridButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Object [][] data= {
				   {accountNum,titleOfAccountText.getText(),branchcodeid,lockerSize,operationMode,paymentMode,expiryDateText.getText()}
				};
			
//			if(paymentId==2) {
//				purpose="Locker Charges";
//				charges=50000;
//				fedAccount="M-230-01-01-0586-2";
//			}
//			else if (paymentId==3) {
//				purpose="MO Account";
//				fedAccount="1036-230-01-01-0586-2";
//				charges=5000;
//			}
			System.out.println("Ind"+comboBox.getSelectedIndex());
			
			if(paymentId==1) {
				actualCharges=0;
				charges=0;
				System.out.println("charges c"+charges);
			}
			else if(paymentId==2) {
				actualCharges=Integer.parseInt(securityDepositText.getText());
				charges=Integer.parseInt(securityDepositText.getText())*1.13;
				charges=Math.round(charges* 100)/100;
				System.out.println("charges s " +charges);
			}
			else if(paymentId==3) {
				actualCharges=Integer.parseInt(yearlyRentText.getText());
				charges=Integer.parseInt(yearlyRentText.getText())*1.13;
				charges=Math.round(charges* 100)/100;
				System.out.println("charges y "+charges);
			}
			
//			System.out.println(paymentMode);
			
			
			if(updateBalance(accountNum,charges)==true) {
				if(createVoucher()==true) {
					grid obj=new grid(0,true,refNo);
					obj.setData(data,lockerSizeId);
					obj.setSize(600,500);
					obj.setVisible(true);
					dispose();
				}

			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient Balance");
			}
			
			
			
			
			
			
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

	cancelButton.setBounds(257, 431, 89, 23);

	cancelButton.setBounds(248, 394, 89, 23);

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
		
		this.accountNum=custAccRelation.get("accountnum");
		this.branchcodeid=custAccRelation.get("branchcodeid");
		customerNameText.setText(custAccRelation.get("customername"));
		contactInformationText.setText(custAccRelation.get("contactno"));
		emailText.setText(custAccRelation.get("email"));
		customerNameText.setEditable(false);
		contactInformationText.setEditable(false);
		emailText.setEditable(false);
		titleOfAccountText.setText(custAccRelation.get("accounttitle"));

		mobileText.setText(custAccRelation.get("operatinginstruction"));
//		openInBranchText.setText("1000");
		titleOfAccountText.setEditable(false);
		mobileText.setEditable(false);
//		openInBranchText.setEditable(false);

//		operatingInstructionText.setText(custAccRelation.get("operatinginstruction"));
//		openInBranchText.setText(custAccRelation.get("branchcode"));
		titleOfAccountText.setEditable(false);
//		operatingInstructionText.setEditable(false);
//		openInBranchText.setEditable(false);

	}
	
	
	
	public void insertArray(ArrayList<Integer> arr){
		availableLockers=arr;
		for(int i=0;i<arr.size();i++) {
			System.out.println("insert "+arr.get(i));
		}
	}
	
	
	
	public void fetchLockerDetails(int val){
		try{
			lockerSizeId=val;
			
			lockerNum=val;
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
			    securityDepositText.setText(secDeposit);
			    yearlyRentText.setText(Integer.toString(charges));
			    System.out.println(secDeposit);
			    System.out.println(charges);
			}
			else {
				JOptionPane.showMessageDialog(null,"Locker Not Available");
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			 JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	}
	
	public Integer lockerNum;
	
	
	//Not saving data in db when dynamic
	//and do validations every where
	// then merge code
	
	
	public boolean createVoucher(){
		
		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
			
			
			Integer locker=getLockerAvailable(lockerNum);
			
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
			
			if(locker==-1 || locker==0) {
				JOptionPane.showMessageDialog(null,"Selected Locker Is Not Available");
				return false;
			}
			String lockernum=getLockerNum(lockerNum);
			
			if(lockernum!=null) {
				
			
			
			System.out.println("Voucher Test");
			
			
			String query = "INSERT INTO voucher_master_tl (lockernum, customerId, userId, accountnum, modeofoperationid, modeofpaymentid, vouchertypeid, voucherstatusid,expirydate) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
					
//			String query="insert into voucher_master_tl (lockernum,customerId,userId,accountnum,modeofoperationid,modeofpaymentid,vouchertypeid,voucherstatusid) values('"+lockernum+"',"+Global.customerId+","+2001+",'"+Global.accountNum+"',"+"1,1,1,1);";
			PreparedStatement statement = connection.prepareStatement(query);
//			'A120',3000,2001,'1234567891245689',1,1,1,1
			System.out.println(query);
			statement.setString(1, lockernum);
			statement.setInt(2, Global.customerId);
			statement.setInt(3, 2001);
			statement.setString(4, Global.accountNum);
			statement.setInt(5, operationId);
			statement.setInt(6, paymentId);
			statement.setInt(7, 1);
			statement.setInt(8, 1);
			if(expiryDateText.isEnabled()==true) {
				statement.setString(9,expiryDateText.getText());
			}
			else {
				statement.setString(9,"");
			}
			
			
			System.out.println(lockernum);
			System.out.println(Global.accountNum);
			
			int result = statement.executeUpdate();
			
			
			if (result>0) {
//				JOptionPane.showMessageDialog(null,"Signin Successful");
//				System.out.println("Voucher"+result.getString("AUTH"));
				System.out.println("Voucher Created");
				
				
				Integer vId;
				String query2="select voucherid from voucher_master_tl order by voucherid desc limit 0,1;";
				PreparedStatement statement2 = connection.prepareStatement(query2);
//				'A120',3000,2001,'1234567891245689',1,1,1,1
				System.out.println(query2);
				ResultSet result2 = statement2.executeQuery();
				
				if(result2.next()) {
					vId=result2.getInt("VOUCHERID");
					System.out.println(vId);
//				String queryVDetail="insert into voucherdetail_tl (refno,description,accounttitle,accountNum,voucherid,amount) values("+123456+",'"+"Testing"+"','"+"Wajahat"+"','"+Global.accountNum+"',"+vId+",5650);";
				
					refNo="A"+Integer.toString(vId);
				
					String purpose="";
					String accountNo="M230010105861";
					String fedAccount="";
					
					// This statement is not saving into database--check it
				
				if(paymentId==2) {
					purpose="Locker Charges";
					
					fedAccount="M230010105862";
				}
				else if (paymentId==3) {
					purpose="MO Account";
					fedAccount="1036230010105862";
					
				}
				String queryVDetail="";
				if (paymentId==1) {
					queryVDetail="INSERT INTO voucherdetail_tl (refno, description, accounttitle, accountNum, voucherid, amount,ref_no)VALUES("+vId+", 'Locker Assigning', "
							+ "'Wajahat', '"+Global.accountNum+"', "+vId+", "+charges+",'"+refNo+"');";
				}
				
				else {
					String ans=paymentId==2?"Security Deposit":" Yearly Rent"; 
					queryVDetail="INSERT INTO voucherdetail_tl (refno, description, accounttitle, accountNum, voucherid, amount,ref_no)VALUES("+vId+", 'Locker Assigning', "
							+ "'Wajahat', '"+Global.accountNum+"', "+vId+", "+charges*-1+",'"+refNo+"'),("+vId+", 'Locker Assigning with "+ans+"', '"+purpose+"', '"+accountNo+"', "+vId+", "+actualCharges+",'"+refNo+"'),"
							+ "("+vId+", 'Govt Charges', 'FED (13%)', '"+fedAccount+"', "+vId+", "+Math.round((actualCharges*0.13)* 100)/100+",'"+refNo+"');";
					
				}
				
//					=?:;
				
				String queryLockerAssigned="Insert into lockerassigned_tr (voucherid,customerid,lockernum,depositamount,overdue,lastrecoverdate,rentstatus)"
															+" values("+vId+","+Global.customerId+",'"+lockernum+"',"+charges*1.13+",'"+LocalDate.now().plus(Period.ofYears(1)).toString()+"','"+LocalDate.now().toString()+"',0);";
				PreparedStatement statementVDetail = connection.prepareStatement(queryVDetail);
				PreparedStatement statementLockerAssigned = connection.prepareStatement(queryLockerAssigned);
				
				statementVDetail.addBatch();
				
				statementLockerAssigned.addBatch();

				
				System.out.print(queryVDetail);
				
				int[] resultVDetail = statementVDetail.executeBatch();
				int[] resultLockerAssigned = statementLockerAssigned.executeBatch();
				
				
				if (resultVDetail.length > 0 && resultLockerAssigned.length > 0) {
				    JOptionPane.showMessageDialog(null, "Voucher Generated Success");
				    return true;
				   
				} else {
				    JOptionPane.showMessageDialog(null, "Voucher Not Generated");
				   
				    
				}
				
				
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Could Not Inserted");
				
			}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			System.out.println("DB Connection fail");
			
		}
		return false;
		
	}
	
	
	public Boolean updateBalance(String accountNum,double charges) {
		try{
			
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
			
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
			String query="UPDATE accountnew"
					+ " SET "
					+ "    onHoldbalance = CASE"
					+ "                WHEN balance > ? THEN onHoldbalance + ?"
					+ "                ELSE onHoldbalance"
					+ "              END"
					+ " WHERE balance - onHoldbalance > ?  and accountnum=?;";
			PreparedStatement statement = connection.prepareStatement(query);
//			'A120',3000,2001,'1234567891245689',1,1,1,1
			statement.setDouble(1, charges);
			statement.setDouble(2, charges);
			statement.setDouble(3, charges);
			statement.setString(4, accountNum);
			
			int result = statement.executeUpdate();
//			System.out.println(result);
			System.out.println("Balance Updatesd"+result);
			if (result>0) {
				
				System.out.println("Balance Update"+result);
				
				return true;
				}
			else {
				return false;
			}
				
				
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			System.out.println("DB Connection fail");
			return false;
		}
		
		
	}
	
	public Integer getLockerAvailable(Integer num){
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
			
			System.out.println("Locker Available"+result.getInt("AVAILABLE"));
			
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

	
	
	public String getLockerNum(Integer num) {
		try{
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
			
//			PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
			
			PreparedStatement statement = connection.prepareStatement("select * from locker where lockernum not in (select lockernum from lockerassigned_tr union select lockernum from lockerassigned_tl order by lockernum)and lockersizeid=? order by lockernum desc limit 0,1;");
//			'A120',3000,2001,'1234567891245689',1,1,1,1
			statement.setInt(1, num);
			
			
			
			ResultSet result = statement.executeQuery();
			System.out.println("Locker No");
			if (result.next()) {
				
				System.out.println("LockerNum"+result.getString("LockerNum"));
				
				return result.getString("LOCKERNUM");
				}
				
			return null;
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
			System.out.println("DB Connection fail");
			return null;
		}
	}
	 public static void main(String[] args) {

		 customerDetails frame = new customerDetails(1);

//		 customerDetails frame = new customerDetails(0);

	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    	
	    }
}
