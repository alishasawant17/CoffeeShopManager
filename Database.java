package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;

public class Database {

	private JFrame frmDatabase;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database window = new Database();
					window.frmDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Database() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatabase = new JFrame();
		frmDatabase.getContentPane().setBackground(new Color(255, 176, 176));
		frmDatabase.setIconImage(Toolkit.getDefaultToolkit().getImage(Database.class.getResource("/Images/logo.jpg")));
		frmDatabase.setTitle("Menu Database");
		frmDatabase.setBounds(100, 100, 597, 373);
		frmDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabase.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Database");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(219, 11, 142, 21);
		frmDatabase.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(208, 30, 165, 2);
		frmDatabase.getContentPane().add(separator);
	
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setForeground(Color.blue);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Item Name", "Price", "Category"
			}
		
	));
	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 60, 500, 215);
		frmDatabase.getContentPane().add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDatabase.setVisible(false);
			}
		});
		btnBack.setBounds(36, 303, 66, 20);
		frmDatabase.getContentPane().add(btnBack);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBCHandling db = new JDBCHandling();
				ResultSet result=db.getTable();
				
				DefaultTableModel model = new DefaultTableModel();
				String[] columnNames = {"Item Name","Price","Category"};
				model.setColumnIdentifiers(columnNames);

				try {
				    while(result.next()) {
				        model.addRow(new Object[] {
				          
				            result.getString(1),
				            result.getString(2),
				            result.getString(3)
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
		btnShow.setBounds(257, 302, 66, 20);
		frmDatabase.getContentPane().add(btnShow);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(488, 303, 66, 20);
		frmDatabase.getContentPane().add(btnExit);
		frmDatabase.setVisible(true);

		
//		table = new JTable();
//		table.setBounds(87, 196, 196, -98);
//		frmDatabase.getContentPane().add(table);
	}
}
