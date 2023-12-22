package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class mainMenuAuthorization extends JFrame {
	
	public int auth=0;
	

	
	public mainMenuAuthorization(final int a) {
		setLocation(new Point(500, 200));
		setTitle("Main Menu");
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Main Menu");
		if(a==0)
		{
			btnNewButton.setText("Main Menu");
		} else if(a==1)
		{
			btnNewButton.setText("Pending Task");
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.print(a);
				if(a==1){
//					lockerMaintenance obj= new lockerMaintenance(1);
					grid obj=new grid(1);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
//					System.out.println("Auth Success");
				}
				else if (a==0){
					lockerModule obj= new lockerModule(0);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
					
				}
			}
		});
		btnNewButton.setBounds(198, 160, 140, 54);
		getContentPane().add(btnNewButton);
		
		JButton btnSignOff = new JButton("Sign Off");
		btnSignOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		btnSignOff.setBounds(10, 334, 89, 23);
		getContentPane().add(btnSignOff);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
		});
		btnExit.setBounds(425, 334, 89, 23);
		getContentPane().add(btnExit);
		if(a==1){
			
			setTitle("Authorizor Menu");
		}
		else{
			setTitle("User Menu");
		}
		// TODO Auto-generated constructor stub
	}

}
