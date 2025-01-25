package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JSlider;

public class CoffeeShop {

	private JFrame JFrame;
	private JPasswordField passwordField;
	private JTextField txtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeShop window = new CoffeeShop();
					window.JFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoffeeShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame = new JFrame();
		JFrame.getContentPane().setBackground(new Color(255, 147, 147));
		JFrame.setBackground(new Color(128, 64, 64));
		JFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alisha\\OneDrive\\Desktop\\coffee shop\\logo.jpg"));
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height  = screenSize.height;
		JFrame.setSize(701, 403);
		JFrame.setLocationRelativeTo(null);
		JFrame.setTitle("Coffee Shop Management");
		//JFrame.setBounds(100, 100, 450, 300);
		JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.getContentPane().setLayout(null);
		
		JLabel JLabel1 = new JLabel("Name: ");
		JLabel1.setFont(new Font("Verdana", Font.PLAIN, 18));
		JLabel1.setBounds(74, 132, 67, 23);
		JFrame.getContentPane().add(JLabel1);
		
		JLabel JLabel2 = new JLabel("Password: ");
		JLabel2.setBackground(new Color(240, 240, 240));
		JLabel2.setFont(new Font("Verdana", Font.PLAIN, 18));
		JLabel2.setBounds(74, 197, 99, 23);
		JFrame.getContentPane().add(JLabel2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 202, 372, 20);
		JFrame.getContentPane().add(passwordField);
		
		JButton JButton1 = new JButton("Enter");
		JButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//if(Name: )
				String name = txtField.getText();
				String password = passwordField.getText();
				System.out.println("Name: "+txtField.getText()+"\nPassword: "+passwordField.getText());
				
				if(name.equals("Alisha")&& password.equals("coldcoffee")) {
					MainPage.main(null);
				}else {
					JOptionPane.showMessageDialog(null,"invalid credentials","Login error", 0);
				}
				
				
			}
		});
		JButton1.setFont(new Font("Tahoma", Font.BOLD, 13));
		JButton1.setBounds(531, 302, 89, 23);
		JFrame.getContentPane().add(JButton1);
		
		JButton JButton2 = new JButton("Go Back");
		JButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JButton2.setFont(new Font("Tahoma", Font.BOLD, 13));
		JButton2.setBounds(52, 302, 89, 23);
		JFrame.getContentPane().add(JButton2);
		
		txtField = new JTextField();
		txtField.setBounds(202, 137, 372, 20);
		JFrame.getContentPane().add(txtField);
		txtField.setColumns(10);
		
		JLabel JLabel = new JLabel("Coffee Shop");
		JLabel.setBackground(new Color(64, 0, 0));
		JLabel.setFont(new Font("Vivaldi", Font.BOLD, 44));
		JLabel.setBounds(226, 11, 233, 77);
		JFrame.getContentPane().add(JLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(156, 70, 372, 2);
		JFrame.getContentPane().add(separator);
	}
}
