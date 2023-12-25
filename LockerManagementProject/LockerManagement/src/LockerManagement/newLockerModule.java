package LockerManagement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;

public class newLockerModule extends JFrame {
	public int chk;
	public newLockerModule(final int chk)
	{
		setSize(new Dimension(600, 500));
		this.chk=chk;
		setLocation(new Point(500, 200));
		setTitle("Locker Module");
		getContentPane().setBackground(new Color(0, 102, 102));
		getContentPane().setLayout(null);
		
		JButton lockerIssuanceButton = new JButton("Locker Issuance");
		lockerIssuanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chk==0) {
					newLockerIssuance obj=new newLockerIssuance(0);
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
				} else if(chk==1){
//					lockerIssuance obj=new lockerIssuance(1);
					newDetails obj = new newDetails(1); 
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
				}
			}
		});
		lockerIssuanceButton.setBounds(200, 110, 150, 60);
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
		lockerSurrenderButton.setBounds(200, 180, 150, 60);
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
		btnNewButton_2.setBounds(200, 250, 150, 60);
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
		signOffButton.setBounds(470, 420, 90, 30);
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
		backButton.setBounds(370, 420, 90, 30);
		getContentPane().add(backButton);
		//date
		newMainMenu date = new newMainMenu(1);
        JLabel dateLabel = new JLabel(date.getCurrentDate());
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        dateLabel.setBounds(0, 440, 580, 20);
        getContentPane().add(dateLabel);
	}
	 public static void main(String[] args) {
		 newLockerModule frame = new newLockerModule(1);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    }
}
