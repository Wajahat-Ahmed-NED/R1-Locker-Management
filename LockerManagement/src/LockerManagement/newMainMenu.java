package LockerManagement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Dimension;
public class newMainMenu extends JFrame {
	
	public int auth=0;
	

	
	public newMainMenu(final int chk) {
		setResizable(false);
		setSize(new Dimension(600, 500));
		setLocation(new Point(500, 200));
		setTitle("Main Menu");
		getContentPane().setBackground(new Color(0, 102, 102));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton(chk ==1  ? "Pending Task" :"Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.print(chk);
				if(chk==0){
					newLockerModule obj= new newLockerModule(0);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
//					System.out.println("Auth Success");
				}
				else if (chk==1){

					newGrid obj=new newGrid(1);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
					
				}
			}
		});
		btnNewButton.setBounds(200, 200, 150, 60);
		getContentPane().add(btnNewButton);
		
		JButton btnSignOff = new JButton("Sign Off");
		btnSignOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newLogIn obj=new newLogIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		btnSignOff.setBounds(470, 410, 90, 30);
		getContentPane().add(btnSignOff);
		if(chk==1){
			
			setTitle("Authorizor Menu");
		}
		else{
			setTitle("User Menu");
		}
		// Date Label
        JLabel dateLabel = new JLabel(getCurrentDate());
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        dateLabel.setBounds(10, 440, 570, 20);
        getContentPane().add(dateLabel);
        
        }
	
	
	////////////////
	 String getCurrentDate() {
	        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM dd, yyyy");
	        Date currentDate = new Date(System.currentTimeMillis());
	        return formatter.format(currentDate);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		newMainMenu frame = new newMainMenu(0);
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}
}
