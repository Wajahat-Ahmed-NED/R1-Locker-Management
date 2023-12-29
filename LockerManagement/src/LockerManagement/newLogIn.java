package LockerManagement;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.UIManager;

public class newLogIn extends JFrame {
	private JTextField branchCodeText;
	private JPasswordField passwordText;
	private JPasswordField userNameText;
	public static String currentDate;
	
	public newLogIn() {
		setResizable(false);
		setSize(new Dimension(600, 500));
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 102, 102));
		setTitle("Login");
		
		JPanel logInPanel = new JPanel();
		logInPanel.setBounds(293, 151, 241, 123);
		logInPanel.setBackground(new Color(0, 102, 102));
		logInPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Log In", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		logInPanel.setLayout(null);
		
		newMainMenu date = new newMainMenu(1);
        JLabel dateLabel = new JLabel(date.getCurrentDate());
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        dateLabel.setBounds(10, 440, 570, 20);
        getContentPane().add(dateLabel);
        
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
				//User
//				String branchCode = "1000";
//				String userName = "wajahat";
//				String password = "pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=";
				//Authorizer
				String branchCode = "1000";
				String userName = "ariz";
				String password = "pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=";
				
				
				
				
				if((!branchCode.isEmpty() || !userName.isEmpty() || !password.isEmpty()) && branchCode.length()==4){
					
					
					
					
					try {
						Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
						java.sql.Connection connection = null;
						java.sql.Statement  lcl_stmt =null;
						connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
//						PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserTable WHERE BRN_CD=? AND USER_NAME=? AND PASSWORD=?");
						
						PreparedStatement statement = connection.prepareStatement("select userTable.userId, userlockercode_tl.auth from userTable, userlockercode_tl where userTable.userId = userlockercode_tl.userid and userTable.branchcode=? and userTable.emailId=? and userTable.password=?");
						
						statement.setString(1, branchCode);
						statement.setString(2, userName);
						statement.setString(3, password);
						
						ResultSet result = statement.executeQuery();
//						System.out.println(result);
						if (result.next()) {
							JOptionPane.showMessageDialog(null,"Signin Successful");
							System.out.println(result.getString("AUTH"));


							Global.userId=result.getInt("USERID");

							if(Integer.parseInt(result.getString("AUTH"))==1){
								
								newMainMenu obj = new newMainMenu(1);
								
								obj.setVisible(true);
								obj.setSize(600, 500);
								
								dispose();
							}
							else if (Integer.parseInt(result.getString("AUTH"))==0) {
								newMainMenu obj = new newMainMenu(0);
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
				
		
		signInButton.setBounds(354, 285, 79, 23);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(452, 285, 79, 23);
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		JLabel lblUserVerification = new JLabel("User Verification");
		lblUserVerification.setForeground(Color.WHITE);
		lblUserVerification.setBounds(293, 101, 188, 39);
		lblUserVerification.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().setLayout(null);
		getContentPane().add(logInPanel);
		
		
		
		JLabel lblBranchCode = new JLabel("Branch Code");
		lblBranchCode.setForeground(Color.WHITE);
		lblBranchCode.setBounds(43, 29, 74, 14);
		logInPanel.add(lblBranchCode);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(130, 29, 88, 14);
		logInPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(43, 65, 74, 14);
		logInPanel.add(lblPassword);
		getContentPane().add(signInButton);
		getContentPane().add(exitButton);
		getContentPane().add(lblUserVerification);
		ImageIcon originalIcon = new ImageIcon("D:\\Ariz\\Locker Management\\R1-Locker-Management\\black.png");
		Image originalImage = originalIcon.getImage();
        Image scaledImage = getScaledImage(originalImage, 250, 250);
		JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(scaledImage));
		lblLogo.setBounds(10, 70, 250, 250);
		getContentPane().add(lblLogo,BorderLayout.CENTER);
	}
// change image size to fit in Label
	private Image getScaledImage(Image logoIcon, int width, int height) {
        int newWidth;
        int newHeight;
        double aspectRatio = (double) logoIcon.getWidth(null) / logoIcon.getHeight(null);

        // Scale based on the aspect ratio to fit within the given dimensions
        if (width / aspectRatio > height) {
            newWidth = (int) (height * aspectRatio);
            newHeight = height;
        } else {
            newWidth = width;
            newHeight = (int) (width / aspectRatio);
        }

        BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(logoIcon, 0, 0, newWidth, newHeight, null);
        g2.dispose();
        return resizedImg;
    }

    public static void main(String[] args) {
    	newLogIn frame = new newLogIn();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
    }
}
