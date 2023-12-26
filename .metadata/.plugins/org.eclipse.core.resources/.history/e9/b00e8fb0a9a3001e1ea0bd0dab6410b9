package LockerManagement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.Point;
import java.awt.Cursor;
//Merged Code
public class logIn extends JFrame {
	private JTextField branchCodeText;
	private JPasswordField passwordText;
	private JPasswordField userNameText;
	public static String currentDate;
//	String password = "myPassword123";
	String hashPassword = "";
	
	public logIn() {
		setResizable(false);
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 102, 102));
		setTitle("Login");
		
		JPanel logInPanel = new JPanel();
		logInPanel.setBounds(157, 151, 241, 123);
		logInPanel.setBackground(new Color(0, 102, 102));
		logInPanel.setBorder(new TitledBorder(null, "Log In", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		logInPanel.setLayout(null);
		
		branchCodeText = new JTextField();
		branchCodeText.setBounds(43, 45, 74, 20);
		logInPanel.add(branchCodeText);
		branchCodeText.setColumns(10);
        
		passwordText = new JPasswordField();
		passwordText.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordText.setBounds(43, 81, 175, 20);
		logInPanel.add(passwordText);
		
		userNameText = new JPasswordField();
		userNameText.setEchoChar('X');
		userNameText.setBounds(121, 45, 97, 20);
		logInPanel.add(userNameText);

		
		String branchCode = branchCodeText.getText();
		String userName = userNameText.getText();
		String password = passwordText.getText();
		
		JButton signInButton = new JButton("Sign In");
		
		signInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
//				String branchCode = branchCodeText.getText();
//				String userName = userNameText.getText();
//				String password = passwordText.getText();
				
				String branchCode = "1000";
				String userName = "ariz";
				String password = "123";
				
				
				if((!branchCode.isEmpty() || !userName.isEmpty() || !password.isEmpty()) && branchCode.length()==4){
					
					try {
						
						hashString(password);
						
						Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
						java.sql.Connection connection = null;
						java.sql.Statement  lcl_stmt =null;
						connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
						PreparedStatement statement = connection.prepareStatement("select userTable.userId, userlockercode_tl.auth from userTable, userlockercode_tl where userTable.userId = userlockercode_tl.userid and userTable.branchcode=? and userTable.emailId=? and userTable.password=?");
						
						statement.setString(1, branchCode);
						statement.setString(2, userName);
						statement.setString(3, hashPassword);
						
						ResultSet result = statement.executeQuery();

						if (result.next()) {
							JOptionPane.showMessageDialog(null,"Signin Successful");
							System.out.println(result.getString("AUTH"));
							Global.userId=result.getInt("USERID");
							if(Integer.parseInt(result.getString("AUTH"))==1){
								
								mainMenuAuthorization obj = new mainMenuAuthorization(1);
								
								obj.setVisible(true);
								obj.setSize(600, 500);
								
								dispose();
							}
							else if (Integer.parseInt(result.getString("AUTH"))==0) {
								mainMenuAuthorization obj = new mainMenuAuthorization(0);
								obj.setVisible(true);
								obj.setSize(600, 500);
								dispose();
							}
							
							else
							{
								JOptionPane.showMessageDialog(null,"Not Authorized");
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid Credentials");
						}
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
						// TODO: handle exception
						System.out.println("DB Connection fail");
						JOptionPane.showMessageDialog(null,"DB Connection Failed");
					}
				}
				else if (branchCode.length()!=4){
					
					JOptionPane.showMessageDialog(null,"Invalid Branch Code! ");
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Field cannot be epmty! ");
				}
			}
		});
				
		
		signInButton.setBounds(230, 285, 79, 23);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(319, 285, 79, 23);
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
			
		});
		
		JLabel lblUserVerification = new JLabel("User Verification");
		lblUserVerification.setBounds(91, 101, 187, 39);
		lblUserVerification.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().setLayout(null);
		getContentPane().add(logInPanel);
		
		
		
		JLabel lblBranchCode = new JLabel("Branch Code");
		lblBranchCode.setBounds(43, 29, 74, 14);
		logInPanel.add(lblBranchCode);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(130, 29, 88, 14);
		logInPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 65, 74, 14);
		logInPanel.add(lblPassword);
		getContentPane().add(signInButton);
		getContentPane().add(exitButton);
		getContentPane().add(lblUserVerification);
	}

//    private static void createAndShowGUI() {
//
//    }

	public void hashString(String password) {
		try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            digest.update(password.getBytes());

            // Get the hashed bytes
            byte[] hashedBytes = digest.digest();

            // Convert hashed bytes to base64 for storage
            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            hashPassword=hashedPassword;
           
            // Print the hashed password
            
        } catch (NoSuchAlgorithmException e) {
            
            e.printStackTrace();
        }
	}
    public static void main(String[] args) {
    	logIn frame = new logIn();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
    }
}
