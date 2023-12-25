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
					newDetails obj = new newDetails(0); 
					obj.setVisible(true);
					obj.setSize(600,500);
					dispose();
				} else if(chk==1){
//					lockerIssuance obj=new lockerIssuance(1);

					newLockerIssuance obj=new newLockerIssuance(1);
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
				newLockerMaintenance obj =new newLockerMaintenance(1);
				obj.setVisible(true);
				obj.setSize(600,500);
				dispose();
			}
		});
		lockerSurrenderButton.setBounds(200, 180, 150, 60);
		getContentPane().add(lockerSurrenderButton);
		
		JButton btnNewButton_2 = new JButton("Locker Maintenance");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newLockerMaintenance obj =new newLockerMaintenance(1);
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
				newLogIn obj=new newLogIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		signOffButton.setBounds(470, 410, 90, 30);
		getContentPane().add(signOffButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newMainMenu obj = new newMainMenu(0);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		backButton.setBounds(370, 410, 90, 30);
		getContentPane().add(backButton);
		//date
		newMainMenu date = new newMainMenu(0);
        JLabel dateLabel = new JLabel(date.getCurrentDate());
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        dateLabel.setBounds(10, 440, 570, 20);
        getContentPane().add(dateLabel);
	}
	 public static void main(String[] args) {
		 newLockerModule frame = new newLockerModule(0);
	    	frame.setSize(600, 500);
	    	frame.setVisible(true);
	    }
}
