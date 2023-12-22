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

public class yearlyRent extends JFrame{
	private JTable table;

	public yearlyRent() {
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		
		JLabel lblYearlyRent = new JLabel("Yearly Rent");
		lblYearlyRent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYearlyRent.setBounds(127, 11, 194, 30);
		getContentPane().add(lblYearlyRent);
		
		table = new JTable();
		table.setBounds(37, 39, 331, 172);
		getContentPane().add(table);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(404);
			}
		});
		closeButton.setBounds(313, 227, 89, 23);
		getContentPane().add(closeButton);
		setTitle("Voucher");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		yearlyRent frame = new yearlyRent();
    	frame.setSize(600, 500);
    	frame.setVisible(true);
	}

}
