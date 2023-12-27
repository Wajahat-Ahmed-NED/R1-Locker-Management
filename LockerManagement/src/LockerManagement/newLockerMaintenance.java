package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Font;

public class newLockerMaintenance extends JFrame{
	private JTextField lockerNumberText;
	public int chk;
	
	public newLockerMaintenance(final int chk) {
		setSize(new Dimension(600, 500));
		this.chk=chk;
		setLocation(new Point(500, 200));
		
		if(chk==2){
			setTitle("Locker Maintenance");
		}
		else if (chk==3){
			setTitle("Locker Surrender");
		}
		getContentPane().setBackground(new Color(0, 102, 102));
		getContentPane().setLayout(null);
		
		
		JLabel lblLockerNumber = new JLabel("Locker Number");
		lblLockerNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLockerNumber.setForeground(Color.WHITE);
		lblLockerNumber.setBounds(200, 180, 150, 30);
		getContentPane().add(lblLockerNumber);
		
		lockerNumberText = new JTextField();
		lockerNumberText.setBounds(200, 210, 150, 30);
		getContentPane().add(lockerNumberText);
		lockerNumberText.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==2){
					
				newDetails obj=new newDetails(2);
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
				}
				else if (chk==3){
					
					newDetails obj=new newDetails(3);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		searchButton.setBounds(200, 250, 100, 30);
		getContentPane().add(searchButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==0)
				{
					newGrid obj=new newGrid(0);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
				else if (chk==2){	

				newLockerModule obj=new newLockerModule(2);

//				newLockerModule obj=new newLockerModule(0);

				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
				}
				else if (chk==3) {

					newLockerModule obj=new newLockerModule(3);

//					newGrid obj=new newGrid(1);

					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		backButton.setBounds(370, 410, 90, 30);
		getContentPane().add(backButton);
		
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

		//date
				newMainMenu date = new newMainMenu(1);
		        JLabel dateLabel = new JLabel(date.getCurrentDate());
		        dateLabel.setForeground(Color.WHITE);
		        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		        dateLabel.setBounds(10, 440, 570, 20);
		        getContentPane().add(dateLabel);
		
	}

	/**
	 * @param args
	 */
    public static void main(String[] args) {
    	newLockerMaintenance frame = new newLockerMaintenance(2);
    	frame.setSize(600, 500);
    	frame.setVisible(true);
    }

}
