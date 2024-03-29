package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class authorizorViewScreen extends JFrame{
	private JTable table;

	public authorizorViewScreen() {
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		JLabel lblCustomersLockerDetail = new JLabel("Customer's Locker Detail");
		lblCustomersLockerDetail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustomersLockerDetail.setBounds(122, 48, 224, 40);
		getContentPane().add(lblCustomersLockerDetail);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setBounds(122, 115, 313, 121);
		getContentPane().add(table);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
		});
		
		exitButton.setBounds(481, 408, 89, 23);
		getContentPane().add(exitButton);
		
		JButton authorizeButton = new JButton("Auhtorize");
		authorizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		authorizeButton.setBounds(382, 408, 89, 23);
		getContentPane().add(authorizeButton);
		
		JButton rejectButton = new JButton("Reject");
		rejectButton.setBounds(23, 408, 89, 23);
		getContentPane().add(rejectButton);
		
		JButton referBackButton = new JButton("Refer Back");
		referBackButton.setBounds(122, 408, 117, 23);
		getContentPane().add(referBackButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(121, 281, 314, 40);
		getContentPane().add(textArea);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setEnabled(false);
		lblComments.setBounds(122, 247, 89, 23);
		getContentPane().add(lblComments);
		setTitle("Voucher View");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		authorizorViewScreen frame = new authorizorViewScreen();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}
}
