package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Menu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Images/logo.jpg")));
		frmMenu.setTitle("Menu Management");
		frmMenu.getContentPane().setBackground(new Color(255, 128, 128));
		frmMenu.setBounds(100, 100, 676, 440);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add Menu");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdd.setSize(149, 77);
		btnAdd.setLocation(50, 94);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItem.main(null);
			}
		});
		//btnAdd.setBounds(50, 25,89, 77);
		frmMenu.getContentPane().add(btnAdd);
		
		JButton btnMenuDatabase = new JButton("Database");
		btnMenuDatabase.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMenuDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.main(null);
			  //  JDBCHandling db = new JDBCHandling();
			    
			}
		});
		btnMenuDatabase.setBounds(448, 94, 149, 77);
		frmMenu.getContentPane().add(btnMenuDatabase);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateItem.main(null);
			}
		});
		btnUpdate.setBounds(150, 211, 149, 77);
		frmMenu.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteItem.main(null);
			}
		});
		btnDelete.setBounds(357, 211, 149, 77);
		frmMenu.getContentPane().add(btnDelete);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenu.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(50, 347, 89, 23);
		frmMenu.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Menu Management");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel.setBounds(222, 24, 216, 34);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(222, 56, 216, 2);
		frmMenu.getContentPane().add(separator);
	}
}
