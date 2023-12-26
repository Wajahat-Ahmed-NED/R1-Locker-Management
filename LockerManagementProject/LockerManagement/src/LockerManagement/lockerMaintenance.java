package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class lockerMaintenance extends JFrame{
	private JTextField lockerNumberText;
	public int chk;
	
	public lockerMaintenance(final int chk) {
		setResizable(false);
		this.chk=chk;

		
		if(chk==1){
			setLocation(new Point(1000, 200));
			setTitle("Locker Maintenance");
		}
		else if (chk==2){
			setTitle("Locker Surrender");
		}
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		
		JLabel lblLockerNumber = new JLabel("Locker Number");
		lblLockerNumber.setBounds(183, 185, 93, 31);
		getContentPane().add(lblLockerNumber);
		
		lockerNumberText = new JTextField();
		lockerNumberText.setBounds(183, 216, 196, 31);
		getContentPane().add(lockerNumberText);
		lockerNumberText.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==1){
					
				customerDetails obj=new customerDetails(1);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
				}
				else if (chk==2){
					
					customerDetails obj=new customerDetails(2);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		searchButton.setBounds(183, 265, 123, 24);
		getContentPane().add(searchButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (chk==0){	
				lockerModule obj=new lockerModule(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
				}
				else if (chk==1) {
					grid obj=new grid(1);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		backButton.setBounds(452, 416, 89, 23);
		getContentPane().add(backButton);
		
		JButton signOffButton = new JButton("Sign Off");
		signOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(10, 416, 89, 23);
		getContentPane().add(signOffButton);
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lockerMaintenance frame = new lockerMaintenance(1);
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}

}
