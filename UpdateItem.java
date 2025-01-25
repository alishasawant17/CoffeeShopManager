package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateItem {

	private JFrame frmUpdateItem;
	private JTextField txtitem;
	private JTextField txtprice;
	private JTextField txtcat;
	private JTextField txtgetdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateItem window = new UpdateItem();
					window.frmUpdateItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateItem = new JFrame();
		frmUpdateItem.getContentPane().setBackground(new Color(255, 185, 185));
		frmUpdateItem.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUpdateItem.setVisible(false);
			}
		});
		btnBack.setBounds(38, 307, 66, 20);
		frmUpdateItem.getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnExit.setBounds(458, 306, 76, 20);
		frmUpdateItem.getContentPane().add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcat.setText(null);
				txtitem.setText(null);
				txtprice.setText(null);
				txtgetdata.setText(null);
			}
		});
		btnReset.setBounds(173, 306, 76, 20);
		frmUpdateItem.getContentPane().add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item = txtitem.getText();
				String Price = txtprice.getText();
				String Category = txtcat.getText();
				
				System.out.println(Item+Price+Category);
				
				JDBCHandling db = new JDBCHandling();
				
				int status = db.insertUpdate(Item, Price, Category);
				
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Updated!");
				}else if(status==0){
					JOptionPane.showMessageDialog(null,"Problem in adding data.");
				}
			}
		});
		btnSave.setBounds(324, 306, 76, 20);
		frmUpdateItem.getContentPane().add(btnSave);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Item Name to Update:");
		lblNewLabel_2.setForeground(new Color(128, 64, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBackground(new Color(128, 64, 0));
		lblNewLabel_2.setBounds(10, 12, 292, 29);
		frmUpdateItem.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Item Name:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_3.setBounds(54, 78, 88, 20);
		frmUpdateItem.getContentPane().add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(54, 133, 66, 20);
		frmUpdateItem.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Category:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(54, 183, 88, 20);
		frmUpdateItem.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtitem = new JTextField();
		txtitem.setColumns(10);
		txtitem.setBounds(193, 80, 249, 20);
		frmUpdateItem.getContentPane().add(txtitem);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(193, 135, 249, 20);
		frmUpdateItem.getContentPane().add(txtprice);
		
		txtcat = new JTextField();
		txtcat.setColumns(10);
		txtcat.setBounds(193, 185, 249, 20);
		frmUpdateItem.getContentPane().add(txtcat);
		
		txtgetdata = new JTextField();
		txtgetdata.setColumns(10);
		txtgetdata.setBounds(305, 20, 164, 20);
		frmUpdateItem.getContentPane().add(txtgetdata);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item=txtgetdata.getText();
				
				JDBCHandling db = new JDBCHandling();
				
				ResultSet result=null;

				result = db.getRow(Item);

				try {
                    if (result.next()) {
                        txtitem.setText(result.getString("Item"));
                        txtprice.setText(result.getString("Price"));
                        txtcat.setText(result.getString("Category"));
                    } else {
                        System.out.println("Item not found.");
                        JOptionPane.showMessageDialog(null,"Item NOT found!");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } finally {
                    try {
                        if (result != null) result.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
		btnGetData.setBounds(479, 10, 92, 40);
		frmUpdateItem.getContentPane().add(btnGetData);
		frmUpdateItem.setBackground(new Color(255, 128, 128));
		frmUpdateItem.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateItem.class.getResource("/Images/logo.jpg")));
		frmUpdateItem.setTitle("Update Item");
		frmUpdateItem.setBounds(100, 100, 597, 377);
		frmUpdateItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
