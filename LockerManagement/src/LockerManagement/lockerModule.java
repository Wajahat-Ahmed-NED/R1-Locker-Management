package LockerManagement;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Point;

public class lockerModule extends JFrame {
	
	
	public int chk;
	
	
	
	public lockerModule(final int chk)
	
	{
			
		this.chk=chk;
		setLocation(new Point(500, 200));
		setTitle("Locker Module");
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		
		
		
		JButton lockerIssuanceButton = new JButton("Locker Issuance");
		lockerIssuanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chk==0) {
					lockerIssuance obj=new lockerIssuance(0);
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
				} else if(chk==1){
					customerDetails obj = new customerDetails(1); 
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
				}
			}
		});
		lockerIssuanceButton.setBounds(196, 134, 159, 35);
		getContentPane().add(lockerIssuanceButton);
		
		
		
		
		JButton lockerSurrenderButton = new JButton("Locker Surrender");
		lockerSurrenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lockerMaintenance obj=new lockerMaintenance(2);
				obj.setVisible(true);
				obj.setSize(600, 400);
				dispose();
			}
		});
		lockerSurrenderButton.setBounds(196, 192, 159, 35);
		getContentPane().add(lockerSurrenderButton);
		
		
		
		JButton btnNewButton_2 = new JButton("Locker Maintenance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lockerMaintenance obj =new lockerMaintenance(1);
				obj.setVisible(true);
				obj.setSize(600,500);
				dispose();
			}
		});
		btnNewButton_2.setBounds(196, 251, 159, 35);
		getContentPane().add(btnNewButton_2);
		
		
		
		JButton signOffButton = new JButton("Sign Off");
		signOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(10, 424, 89, 23);
		getContentPane().add(signOffButton);
		
		
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainMenuAuthorization obj = new mainMenuAuthorization(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		backButton.setBounds(469, 424, 89, 23);
		getContentPane().add(backButton);
		
	}
	
	
	
	 public static void main(String[] args) {
		 lockerModule frame = new lockerModule(0);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    }
}
