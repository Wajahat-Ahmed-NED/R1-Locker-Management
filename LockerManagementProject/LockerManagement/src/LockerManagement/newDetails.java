package LockerManagement;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	
	public Integer lockerSizeId;
	private JTextField customerNameText;
	private JTextField correspondedAddressText;
	private JTextField mobileNumberText;
	private JTextField textField;
	private JTextField lockerNumberText;
	private JTextField lockerKeyText;
	private JTextField lockerSizeText;
	private JTextField lockerStatusText;
	private JTextField operatingInstructionText;
	private JTextField depositText;
	private JTextField overdueDateText;
	private JTextField recoverDateText;
	private JTextField rentStatusText;
	private JTextField modeOfOperationText;
	private JComboBox modeOfOperationComboBox;
	ArrayList<Integer> availableLockers;
	public String lockerSize;
	public String paymentMode;
	private JTextField expiryDateText;
	//Constructor
	public newDetails(final int chk)
	{
		this.chk=chk;
		
//		if(chk==1) 
//		{
		customerPanel();
//		}
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
	customerDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	customerDetailsPanel.setBounds(20, 10, 540, 130);
	getContentPane().add(customerDetailsPanel);
	customerDetailsPanel.setLayout(null);
	
	JLabel lblCustomerName = new JLabel("Customer Name");
	lblCustomerName.setForeground(new Color(0, 0, 0));
	lblCustomerName.setBounds(10, 20, 120, 20);
	customerDetailsPanel.add(lblCustomerName);
	
	customerNameText = new JTextField();
	customerNameText.setBounds(200, 20, 300, 20);
	customerDetailsPanel.add(customerNameText);
	customerNameText.setColumns(10);
	
	JLabel lblCorrespondedAddress = new JLabel("Corresponded Address");
	lblCorrespondedAddress.setForeground(new Color(0, 0, 0));
	lblCorrespondedAddress.setBounds(10, 45, 150, 20);
	customerDetailsPanel.add(lblCorrespondedAddress);
	
	correspondedAddressText = new JTextField();
	correspondedAddressText.setBounds(200, 45, 300, 20);
	customerDetailsPanel.add(correspondedAddressText);
	correspondedAddressText.setColumns(10);
	
	JLabel lblMobileNumber = new JLabel("Mobile Number");
	lblMobileNumber.setForeground(new Color(0, 0, 0));
	lblMobileNumber.setBounds(10, 70, 120, 20);
	customerDetailsPanel.add(lblMobileNumber);
	
	mobileNumberText = new JTextField();
	mobileNumberText.setBounds(200, 70, 300, 20);
	customerDetailsPanel.add(mobileNumberText);
	mobileNumberText.setColumns(10);
	
	JLabel lblAccountNumber = new JLabel("Account Number");
	lblAccountNumber.setForeground(new Color(0, 0, 0));
	lblAccountNumber.setBounds(10, 95, 120, 20);
	customerDetailsPanel.add(lblAccountNumber);
	
	textField = new JTextField();
	textField.setBounds(200, 95, 300, 20);
	customerDetailsPanel.add(textField);
	textField.setColumns(10);
	
	JPanel lockerDetailsPanel = new JPanel();
	lockerDetailsPanel.setForeground(new Color(0, 0, 0));
	lockerDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Locker Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	lockerDetailsPanel.setBackground(new Color(0, 102, 102));
	lockerDetailsPanel.setBounds(20, 150, 540, 130);
	getContentPane().add(lockerDetailsPanel);
	lockerDetailsPanel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Locker Number");
	lblNewLabel.setForeground(new Color(0, 0, 0));
	lblNewLabel.setBounds(10, 45, 150, 20);
	lockerDetailsPanel.add(lblNewLabel);
	
	lockerNumberText = new JTextField();
	lockerNumberText.setBounds(200, 45, 90, 20);
	lockerDetailsPanel.add(lockerNumberText);
	lockerNumberText.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Locker Key");
	lblNewLabel_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_1.setBounds(300, 20, 80, 20);
	lockerDetailsPanel.add(lblNewLabel_1);
	
	lockerKeyText = new JTextField();
	lockerKeyText.setBounds(400, 20, 100, 20);
	lockerDetailsPanel.add(lockerKeyText);
	lockerKeyText.setColumns(10);
	//if user then textfield replace to combobox
	JLabel lblNewLabel_2 = new JLabel("Locker Size");
	lblNewLabel_2.setForeground(new Color(0, 0, 0));
	lblNewLabel_2.setBounds(10, 20, 80, 20);
	JComboBox lockerSizeComboBox = new JComboBox();
	lockerSizeComboBox.addActionListener(new ActionListener() {
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
	lockerSizeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Small", "Medium", "Large"}));
	lockerSizeComboBox.setSelectedIndex(-1);
	lockerDetailsPanel.add(lblNewLabel_2);
	JLabel lblNewLabel_3 = new JLabel("Operating Instruction");
	lblNewLabel_3.setForeground(new Color(0, 0, 0));
	lblNewLabel_3.setBounds(10, 70, 120, 20);
	lockerDetailsPanel.add(lblNewLabel_3);
	
	operatingInstructionText = new JTextField();
	JComboBox OperatingInstructionComboBox = new JComboBox();
	modeOfOperationComboBox = new JComboBox();
	modeOfOperationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Singly", "Either or Surviver", "Jointly by all of Us", "Jointly by two of Us", "Others"}));
	modeOfOperationComboBox.setSelectedIndex(-1);
	modeOfOperationComboBox.setMaximumRowCount(5);
	
	modeOfOperationText = new JTextField();

	if (chk==1) {

		operatingInstructionText.setBounds(200, 70, 300, 20);
		lockerDetailsPanel.add(operatingInstructionText);
		operatingInstructionText.setColumns(10);
		
		lockerSizeText = new JTextField();
		lockerSizeText.setBounds(200, 20, 90, 20);
		lockerDetailsPanel.add(lockerSizeText);
		lockerSizeText.setColumns(10);
		modeOfOperationText.setBounds(200, 95, 300, 20);
		lockerDetailsPanel.add(modeOfOperationText);
		modeOfOperationText.setColumns(10);
	}
//	else if(chk==0){
		OperatingInstructionComboBox.setBounds(200, 67, 300, 22);
		lockerDetailsPanel.add(OperatingInstructionComboBox);
		lockerSizeComboBox.setBounds(200, 20, 90, 20);
		lockerDetailsPanel.add(lockerSizeComboBox);
		modeOfOperationComboBox.setBounds(200, 95, 300, 20);
		lockerDetailsPanel.add(modeOfOperationComboBox);
//	}
	
	
	JLabel lblLockerStatus = new JLabel("Locker Status");
	lblLockerStatus.setForeground(new Color(0, 0, 0));
	lblLockerStatus.setBounds(300, 45, 80, 20);
	lockerDetailsPanel.add(lblLockerStatus);
	
	lockerStatusText = new JTextField();
	lockerStatusText.setBounds(400, 45, 100, 20);
	lockerDetailsPanel.add(lockerStatusText);
	lockerStatusText.setColumns(10);
	
	JLabel lblNewLabel_9 = new JLabel("Mode Of Operation");
	lblNewLabel_9.setForeground(new Color(0, 0, 0));
	lblNewLabel_9.setBounds(10, 95, 120, 20);
	lockerDetailsPanel.add(lblNewLabel_9);
	
	final JPanel DepositDetailsPanel = new JPanel();
	DepositDetailsPanel.setForeground(new Color(0, 0, 0));
	DepositDetailsPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rent & Security Deposit Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	DepositDetailsPanel.setBackground(new Color(0, 102, 102));
	DepositDetailsPanel.setBounds(20, 290, 540, 100);
	// DepositDetailsPanel.setBounds(20, 290, 540, 125);
	getContentPane().add(DepositDetailsPanel);
	DepositDetailsPanel.setLayout(null);
	
	JLabel lblNewLabel_4 = new JLabel("Mode Of Payment");
	lblNewLabel_4.setForeground(new Color(0, 0, 0));
	lblNewLabel_4.setBounds(10, 20, 120, 20);
	DepositDetailsPanel.add(lblNewLabel_4);
	final JLabel lblExpiryDate = new JLabel("Expiry Date");
	//Mode of Payment
	JComboBox modeOfPaymentComboBox = new JComboBox();
	modeOfPaymentComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
		            JComboBox<String> cb = (JComboBox<String>) e.getSource();
		            String selectedItem = (String) cb.getSelectedItem();
		            System.out.println("Selected item: " + selectedItem);
		            paymentMode=selectedItem;
		            
		            int val=0;
		            if(selectedItem=="Complementary"){
		            	// Set the new bounds here
		            		DepositDetailsPanel.setBounds(20, 290, 540, 125);
		            		lblExpiryDate.setBounds(10, 95, 150, 20);
		            		lblExpiryDate.setForeground(new Color(0, 0, 0));
		            		DepositDetailsPanel.add(lblExpiryDate);
		                   	lblExpiryDate.setVisible(true);
		            		expiryDateText = new JTextField();
		            		expiryDateText.setBounds(200, 95, 90, 20);
		                    expiryDateText.setVisible(true);
		            		DepositDetailsPanel.add(expiryDateText);
		            		expiryDateText.setColumns(10);
		                 // Repaint the panel to reflect changes
			                 DepositDetailsPanel.revalidate();
			                 DepositDetailsPanel.repaint();
//		            	expiryDateText.setEnabled(true);
//		            	expiryDateText.setEditable(true);
//		            	
//		            	expiryDate.setEnabled(true);
		            	
		            }
		            else if (selectedItem=="Security Deposit" || selectedItem=="Yearly Rent"){
		            	DepositDetailsPanel.setBounds(20, 290, 540, 100);
		            	DepositDetailsPanel.revalidate();
		                DepositDetailsPanel.repaint();
//		            	expiryDateText.setEnabled(false);
//		            	expiryDateText.setEditable(false);
		                expiryDateText.setVisible(false);
		            	lblExpiryDate.setVisible(false);
		            	
		            }
		          
		           
		            
		            
			 
				}
	});
	modeOfPaymentComboBox.setMaximumRowCount(3);
	modeOfPaymentComboBox.setModel(new DefaultComboBoxModel(new String[] {"Complementary", "Security Deposit", "Yearly Rent"}));
	modeOfPaymentComboBox.setSelectedIndex(-1);
	modeOfPaymentComboBox.setBounds(200, 20, 300, 20);
	DepositDetailsPanel.add(modeOfPaymentComboBox);
	
	JLabel lblNewLabel_5 = new JLabel("Rent/Security Deposit");
	lblNewLabel_5.setForeground(new Color(0, 0, 0));
	lblNewLabel_5.setBounds(10, 45, 150, 20);
	DepositDetailsPanel.add(lblNewLabel_5);
	
	depositText = new JTextField();
	depositText.setBounds(200, 45, 90, 20);
	DepositDetailsPanel.add(depositText);
	depositText.setColumns(10);
	
	JLabel lblNewLabel_6 = new JLabel("Overdue Date");
	lblNewLabel_6.setForeground(new Color(0, 0, 0));
	lblNewLabel_6.setBounds(300, 45, 80, 20);
	DepositDetailsPanel.add(lblNewLabel_6);
	
	overdueDateText = new JTextField();
	overdueDateText.setBounds(400, 45, 100, 20);
	DepositDetailsPanel.add(overdueDateText);
	overdueDateText.setColumns(10);
	
	JLabel lblNewLabel_7 = new JLabel("Last Rent Recover Date");
	lblNewLabel_7.setForeground(new Color(0, 0, 0));
	lblNewLabel_7.setBounds(10, 70, 150, 20);
	DepositDetailsPanel.add(lblNewLabel_7);
	
	recoverDateText = new JTextField();
	recoverDateText.setBounds(200, 70, 90, 20);
	DepositDetailsPanel.add(recoverDateText);
	recoverDateText.setColumns(10);
	
	JLabel lblNewLabel_8 = new JLabel("Rent Status");
	lblNewLabel_8.setForeground(new Color(0, 0, 0));
	lblNewLabel_8.setBounds(300, 70, 80, 20);
	DepositDetailsPanel.add(lblNewLabel_8);
	
	rentStatusText = new JTextField();
	rentStatusText.setBounds(400, 70, 100, 20);
	DepositDetailsPanel.add(rentStatusText);
	rentStatusText.setColumns(10);	
	
	JButton backButton = new JButton("Back");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chk==0) {
				newLockerIssuance obj=new newLockerIssuance(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}else if(chk==1){
				lockerMaintenance obj=new lockerMaintenance(1);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		}
	});
	backButton.setBounds(471, 427, 89, 23);
	getContentPane().add(backButton);
	
	JButton signOffButton = new JButton("Sign Off");
	signOffButton.setBounds(372, 427, 89, 23);
	getContentPane().add(signOffButton);
	newMainMenu date = new newMainMenu(1);
    JLabel dateLabel = new JLabel(date.getCurrentDate());
    dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
    dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    dateLabel.setBounds(0, 440, 580, 20);
    getContentPane().add(dateLabel);
}
	
	// functions declarations
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
			
//			if (result.next()) {
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
//			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			 JOptionPane.showMessageDialog(null,"DB Connection Failed");
		}
	
	}
	
	 public static void main(String[] args) {
		 newDetails frame = new newDetails(0);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    	
	    }
	public int getModeOfOperationComboBoxSelectedIndex() {
		return modeOfOperationComboBox.getSelectedIndex();
	}
	public void setModeOfOperationComboBoxSelectedIndex(int selectedIndex) {
		modeOfOperationComboBox.setSelectedIndex(selectedIndex);
	}
}

