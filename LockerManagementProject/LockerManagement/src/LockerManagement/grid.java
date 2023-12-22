package LockerManagement;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class grid extends JFrame {
	private JTable table;
	String [] columnNames={"Locker Number", "Locker"};
	Object[][] data= new Object[5][2];
	public int chk;
	public grid(final int chk) {
		setLocation(new Point(500, 200));
		getContentPane().setBackground(new Color(0, 153, 102));
		getContentPane().setLayout(null);
		this.chk=chk;
		JPanel panel= new JPanel();
		panel.setBounds(24,23,403,262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(77, 166, 414, 156);
		getContentPane().add(table);
		
		
		table = new JTable(data,columnNames);
//		table.setVisible(false);
		table.setBounds(77, 166, 414, 156);
		getContentPane().add(table);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(0,0,403,262);
		panel.add(scroll);

		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
			java.sql.Connection connection = null;
			java.sql.Statement  lcl_stmt =null;
			connection = java.sql.DriverManager.getConnection("jdbc:db2:WA27389", "db2admin", "admin123/?");
						
			String query="select  lockernum,rentstatus from lockerAssigned_tr;";
			PreparedStatement statement = connection.prepareStatement(query);
			
//			statement.setString(1, branchCode);
//			statement.setString(2, userName);
//			statement.setString(3, password);
				
			ResultSet result = statement.executeQuery();
			ResultSetMetaData metaData = result.getMetaData();
		        // Get number of columns in the result set
		    int columnCount = metaData.getColumnCount();
		    System.out.print("test "+columnCount+"    ");
			
			
			ArrayList<Object[]> rows= new ArrayList<>();
			
			while(result.next()) {
				Object[] row= new Object[columnCount];
				for ( int i=0;i<columnCount;i++){
					
					row[i]=result.getString(i+1);
					System.out.println(i+" "+row[i]);
				}
				System.out.println(row);

				if(row[1].equals("0")){
					row[1]="Issuance";
				}
				else if (row[1].equals("1")){
					row[1]="Maintenance";
				}
				else if (row[1].equals("2"))
				{ 
					row[1]="Surrender";
				}
				rows.add(row);
			}
			
			
			for (int i=0; i<rows.size();i++){
				data[i]=rows.get(i);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.exit(404);
				dispose();
			}
		});
		exitButton.setBounds(472, 419, 89, 23);
		getContentPane().add(exitButton);
		
		if(chk==0)
		{
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(21, 419, 89, 23);
		getContentPane().add(deleteButton);
		
		JButton modifyButton = new JButton("Modify");
		modifyButton.setBounds(373, 419, 89, 23);
		getContentPane().add(modifyButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(120, 419, 89, 23);
		getContentPane().add(updateButton);
		setTitle("Grid");
		}
		
		JButton proceedButton = new JButton("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chk==1)
				{
						lockerMaintenance obj = new lockerMaintenance(1);
						obj.setVisible(true);
						obj.setSize(600, 500);
//						dispose();
				} else if(chk==0)
				{
	
					lockerModule obj = new lockerModule(0);
					obj.setVisible(true);
					obj.setSize(600, 500);
					dispose();
				}
			}
		});
		proceedButton.setBounds(219, 419, 144, 23);
		getContentPane().add(proceedButton);
		// TODO Auto-generated constructor stub
		JButton Signoffbutton = new JButton("sign Off");
		Signoffbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logIn obj=new logIn();
				obj.setVisible(true);
				obj.setSize(600, 500);
				dispose();
			}
		});
		Signoffbutton.setBounds(10, 419, 99, 23);
		getContentPane().add(Signoffbutton);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	grid frame = new grid(1);
    	frame.setSize(600, 500);
    	frame.setVisible(true);

	}
}
