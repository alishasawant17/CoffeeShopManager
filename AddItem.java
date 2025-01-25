package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class AddItem {

	private JFrame frmAddItem;
	private JTextField txtItemName;
	private JTextField txtPrice;
	private JTextField txtCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem window = new AddItem();
					window.frmAddItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddItem = new JFrame();
		frmAddItem.setTitle("Add Item in Menu");
		frmAddItem.setIconImage(Toolkit.getDefaultToolkit().getImage(AddItem.class.getResource("/Images/logo.jpg")));
		frmAddItem.setBounds(100, 100, 583, 405);
		frmAddItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 185, 185));
		frmAddItem.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(64, 0, 0));
		separator.setBounds(193, 40, 180, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 185, 185));
		panel_1.setBounds(0, 0, 566, 364);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add New Item");
		lblNewLabel_2.setForeground(new Color(128, 64, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBackground(new Color(128, 64, 0));
		lblNewLabel_2.setBounds(210, 11, 146, 31);
		panel_1.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(42, 323, 66, 20);
		panel_1.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCategory.setText(null);
				txtItemName.setText(null);
				txtPrice.setText(null);
			}
		});
		btnReset.setBounds(162, 322, 76, 20);
		panel_1.add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int Sr_no = 0;
				String Item = txtItemName.getText();
				String Price = txtPrice.getText();
				String Category = txtCategory.getText();
				
				System.out.println(Item+Price+Category);
				
				JDBCHandling db = new JDBCHandling();
				
				int status = db.insertData(Item, Price, Category);
				
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Updated!");
				}else if(status==0){
					JOptionPane.showMessageDialog(null,"Problem in adding data.");
				}
			}
		});
		btnSave.setBounds(307, 323, 76, 20);
		panel_1.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(430, 321, 76, 20);
		panel_1.add(btnExit);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(183, 168, 249, 20);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtItemName = new JTextField();
		txtItemName.setBounds(183, 107, 249, 20);
		panel_1.add(txtItemName);
		txtItemName.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(42, 166, 66, 20);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Item Name:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_3.setBounds(42, 105, 88, 20);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Category:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(42, 218, 88, 20);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		txtCategory = new JTextField();
		txtCategory.setColumns(10);
		txtCategory.setBounds(183, 220, 249, 20);
		panel_1.add(txtCategory);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddItem.setVisible(false);
			}
		});
	}
}
