package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class securtiyDeposit extends JFrame {
	private JTable securityDepositTable;

	public securtiyDeposit() {
		setLocation(new Point(500, 200));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		setTitle("Voucher");
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		JLabel lblV = new JLabel("Security Deposit");
		lblV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblV.setBounds(120, 11, 184, 47);
		getContentPane().add(lblV);
		
		securityDepositTable = new JTable();
		securityDepositTable.setRowSelectionAllowed(false);
		securityDepositTable.setBounds(35, 57, 360, 162);
		getContentPane().add(securityDepositTable);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
		});
		closeButton.setBounds(318, 227, 89, 23);
		getContentPane().add(closeButton);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		securtiyDeposit frame = new securtiyDeposit();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}
}
