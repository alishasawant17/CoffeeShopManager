package MyProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteItem {

	private JFrame frmDelete;
	private JTextField txtGetData;
	private JTextField txtPrice;
	private JTextField txtCat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteItem window = new DeleteItem();
					window.frmDelete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDelete = new JFrame();
		frmDelete.getContentPane().setBackground(new Color(255, 185, 185));
		frmDelete.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Delete Item From Menu");
		lblNewLabel_2.setForeground(new Color(128, 64, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBackground(new Color(128, 64, 0));
		lblNewLabel_2.setBounds(168, 11, 244, 29);
		frmDelete.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Item Name to Delete:");
		lblNewLabel_2_1.setForeground(new Color(64, 128, 128));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBackground(new Color(255, 255, 128));
		lblNewLabel_2_1.setBounds(32, 81, 292, 29);
		frmDelete.getContentPane().add(lblNewLabel_2_1);
		
		txtGetData = new JTextField();
		txtGetData.setColumns(10);
		txtGetData.setBounds(283, 87, 164, 20);
		frmDelete.getContentPane().add(txtGetData);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String Item=txtGetData.getText();
				
				JDBCHandling db = new JDBCHandling();
				
				ResultSet result=null;

				result = db.getRow(Item);

				try {
                    if (result.next()) {
                        //txtitem.setText(result.getString("Item"));
                        txtPrice.setText(result.getString("Price"));
                        txtCat.setText(result.getString("Category"));
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
			
		
		btnGetData.setBounds(457, 81, 92, 40);
		frmDelete.getContentPane().add(btnGetData);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(117, 165, 66, 20);
		frmDelete.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Category:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(117, 211, 88, 20);
		frmDelete.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(206, 167, 249, 20);
		frmDelete.getContentPane().add(txtPrice);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(206, 213, 249, 20);
		frmDelete.getContentPane().add(txtCat);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDelete.setVisible(false);
			}
		});
		btnBack.setBounds(32, 303, 66, 20);
		frmDelete.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Item = txtGetData.getText();
				String Price = txtPrice.getText();
				String Category = txtCat.getText();
				
				System.out.println(Item+Price+Category);
				
				JDBCHandling db = new JDBCHandling();
				
				int status = db.insertDelete(Item, Price, Category);
				
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Deleted!");
				}else if(status==0){
					JOptionPane.showMessageDialog(null,"Problem in deleting data.");
				}
			}
		});
		btnDelete.setBounds(246, 293, 88, 29);
		frmDelete.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(483, 303, 66, 20);
		frmDelete.getContentPane().add(btnExit);
		frmDelete.setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteItem.class.getResource("/Images/logo.jpg")));
		frmDelete.setTitle("Delete Item From Menu");
		frmDelete.setBounds(100, 100, 596, 386);
		frmDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
