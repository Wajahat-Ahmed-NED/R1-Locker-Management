package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class authorizorLockerIssuance extends JFrame {

	public authorizorLockerIssuance() {
		setLocation(new Point(500, 200));
		setTitle("Locker Issuance");
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		JLabel lblPendingLockerIssuance = new JLabel("Pending Locker Issuance");
		lblPendingLockerIssuance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPendingLockerIssuance.setBounds(124, 11, 209, 31);
		getContentPane().add(lblPendingLockerIssuance);
		
		JList list = new JList();
		list.setBounds(111, 138, 352, 191);
		getContentPane().add(list);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
		});
		exitButton.setBounds(471, 404, 89, 23);
		getContentPane().add(exitButton);
		setBackground(new Color(0, 153, 102));
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		authorizorLockerIssuance frame = new authorizorLockerIssuance();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}
}
