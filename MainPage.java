package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class MainPage {

	private JFrame frmMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainPage = new JFrame();
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmMainPage.setSize(width,height);
		frmMainPage.setLocationRelativeTo(null);
		//frmMainPage.setBounds(100, 100, 450, 300);
		frmMainPage.setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/Images/logo.jpg")));
		frmMainPage.setForeground(new Color(255, 185, 185));
		frmMainPage.setTitle("Main Page");
		
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		frmMainPage.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnMenu =new JButton("Menu");
		btnMenu.setIcon(new ImageIcon("D:\\MyJavaAssignments\\GUIDevelopment\\src\\Images\\menu1.jpg"));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(null);
			}
		});
		btnMenu.setBounds(915, 202, 281, 242);
		panel.add(btnMenu);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainPage.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(93, 639, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1.setBounds(1166, 639, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagement.main(null);
			}
		});
		btnEmployee.setIcon(new ImageIcon("D:\\MyJavaAssignments\\GUIDevelopment\\src\\Images\\employee.jpg"));
		btnEmployee.setBounds(195, 202, 289, 242);
		panel.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("Employee");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 19));
		lblNewLabel.setBounds(301, 455, 96, 28);
		panel.add(lblNewLabel);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Sylfaen", Font.BOLD, 19));
		lblMenu.setBounds(1037, 455, 96, 28);
		panel.add(lblMenu);
		
		JLabel lblNewLabel_1 = new JLabel("Data Management");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(563, 11, 224, 53);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(552, 59, 245, 2);
		panel.add(separator);
	}
}
