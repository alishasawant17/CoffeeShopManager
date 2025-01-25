package MyProject;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeDatabase {

	private JFrame frmEmployeeDatabase;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeDatabase window = new EmployeeDatabase();
					window.frmEmployeeDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeDatabase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeDatabase = new JFrame();
		frmEmployeeDatabase.getContentPane().setBackground(new Color(255, 174, 174));
		frmEmployeeDatabase.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Database");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setBounds(567, 11, 216, 41);
		frmEmployeeDatabase.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(539, 63, 271, 2);
		frmEmployeeDatabase.getContentPane().add(separator);
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setForeground(Color.blue);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null,null,null,null,null},
			},
			new String[] {
				"FullName", "MobileNo", "Email","Address","Gender","Qualification","DOB"
			}
//			new ava.sql.Date[] {
//					"DOB"
//			}
		
	));
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(58, 94, 1234, 529);
		frmEmployeeDatabase.getContentPane().add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeDatabase.setVisible(false);
			}
		});
		btnBack.setBounds(58, 666, 66, 20);
		frmEmployeeDatabase.getContentPane().add(btnBack);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBCHandling db = new JDBCHandling();
				ResultSet result=db.getTable1();
				
				DefaultTableModel model = new DefaultTableModel();
				String[] columnNames = {"FullName","MobileNo","Email","Address","Gender","Qualification","DOB"};
				model.setColumnIdentifiers(columnNames);

				try {
				    while(result.next()) {
				        model.addRow(new Object[] {
				          
				            result.getString(1),
				            result.getString(2),
				            result.getString(3),
				            result.getString(4),
				            result.getString(5),
				            result.getString(6),
				            result.getDate(7),
				        });
				    }
				} catch (SQLException e1) {
				    // TODO Auto-generated catch block
				    e1.printStackTrace();
				}
				
				table.setModel(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				
				try {
				    result.close();
				} catch (SQLException e1) {
				    // TODO Auto-generated catch block
				    e1.printStackTrace();
				}


			}
			
		});
		btnShow.setBounds(642, 666, 66, 20);
		frmEmployeeDatabase.getContentPane().add(btnShow);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1226, 666, 66, 20);
		frmEmployeeDatabase.getContentPane().add(btnExit);
		
		//scrollPane.setViewportView(table);
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmEmployeeDatabase.setSize(width,height);
		frmEmployeeDatabase.setLocationRelativeTo(null);
		frmEmployeeDatabase.setTitle("Employee Database");
		frmEmployeeDatabase.setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeDatabase.class.getResource("/Images/logo.jpg")));
		//frmEmployeeDatabase.setBounds(100, 100, 688, 432);
		frmEmployeeDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
