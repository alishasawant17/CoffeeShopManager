package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class EmployeeManagement {

	private JFrame frmEmployeeManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement window = new EmployeeManagement();
					window.frmEmployeeManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeManagement = new JFrame();
		frmEmployeeManagement.getContentPane().setBackground(new Color(255, 128, 128));
		frmEmployeeManagement.getContentPane().setLayout(null);
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmEmployeeManagement.setSize(width,height);
		frmEmployeeManagement.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee.main(null);
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 64));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(225, 132, 218, 143);
		frmEmployeeManagement.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Database");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDatabase.main(null);
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 64));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_1.setBounds(945, 132, 202, 143);
		frmEmployeeManagement.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee.main(null);
			}
		});
		btnNewButton_2.setForeground(new Color(128, 0, 64));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_2.setBounds(781, 413, 183, 127);
		frmEmployeeManagement.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployee.main(null);
			}
		});
		btnNewButton_3.setForeground(new Color(128, 0, 64));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_3.setBounds(438, 413, 183, 127);
		frmEmployeeManagement.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Employee Management");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel.setBounds(541, 18, 268, 34);
		frmEmployeeManagement.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(534, 48, 282, 11);
		frmEmployeeManagement.getContentPane().add(separator);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeManagement.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(74, 637, 89, 23);
		frmEmployeeManagement.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Exit");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4_1.setBounds(1198, 637, 89, 23);
		frmEmployeeManagement.getContentPane().add(btnNewButton_4_1);
		frmEmployeeManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeManagement.class.getResource("/Images/logo.jpg")));
		frmEmployeeManagement.setTitle("Employee Management");
		//frmEmployeeManagement.setBounds(100, 100, 708, 447);
		frmEmployeeManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
