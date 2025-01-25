package MyProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteEmployee {

	private JFrame frmDeleteEmployee;
	private JTextField txtGetdata;
	private JTextField txtMob;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee window = new DeleteEmployee();
					window.frmDeleteEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteEmployee = new JFrame();
		frmDeleteEmployee.getContentPane().setBackground(new Color(255, 174, 174));
		frmDeleteEmployee.setForeground(new Color(255, 147, 147));
		frmDeleteEmployee.getContentPane().setForeground(new Color(0, 0, 0));
		frmDeleteEmployee.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Delete Employee Details");
		lblNewLabel_2.setForeground(new Color(0, 0, 64));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2.setBounds(553, 11, 244, 29);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(553, 38, 244, 2);
		frmDeleteEmployee.getContentPane().add(separator);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Full Name to Delete:");
		lblNewLabel_2_1.setForeground(new Color(64, 128, 128));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBackground(new Color(255, 255, 128));
		lblNewLabel_2_1.setBounds(191, 159, 292, 29);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_2_1);
		
		txtGetdata = new JTextField();
		txtGetdata.setColumns(10);
		txtGetdata.setBounds(493, 159, 532, 29);
		frmDeleteEmployee.getContentPane().add(txtGetdata);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FullName=txtGetdata.getText();
				
				JDBCHandling db = new JDBCHandling();
				
				ResultSet result = null;
				result = db.getRow1(FullName);

				try {
                    if (result.next()) {
                        //txtitem.setText(result.getString("Item"));
                        txtMob.setText(result.getString("MobileNo"));
                        txtemail.setText(result.getString("Email"));
                        
                        
                        
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
		btnGetData.setBounds(1090, 144, 100, 48);
		frmDeleteEmployee.getContentPane().add(btnGetData);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mobile no.: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(191, 265, 116, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(191, 295, 77, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(191, 325, 77, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_3);
		
		txtMob = new JTextField();
		txtMob.setColumns(10);
		txtMob.setBounds(343, 267, 722, 20);
		frmDeleteEmployee.getContentPane().add(txtMob);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(343, 297, 722, 20);
		frmDeleteEmployee.getContentPane().add(txtemail);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(343, 325, 722, 75);
		frmDeleteEmployee.getContentPane().add(txtAddress);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("D.O.B:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4_1.setBounds(191, 451, 57, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_4_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(270, 451, 210, 29);
		frmDeleteEmployee.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(553, 456, 77, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_4);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(640, 451, 212, 29);
		frmDeleteEmployee.getContentPane().add(panel);
		
		JRadioButton btnMale = new JRadioButton("Male ");
		btnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMale.setBounds(0, 0, 58, 37);
		panel.add(btnMale);
		
		JRadioButton btnFemale = new JRadioButton("Female");
		btnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFemale.setBounds(60, 0, 75, 37);
		panel.add(btnFemale);
		
		JRadioButton btnOther = new JRadioButton("Other");
		btnOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOther.setBounds(137, 0, 62, 37);
		panel.add(btnOther);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Qualification:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3_1.setBounds(922, 451, 116, 19);
		frmDeleteEmployee.getContentPane().add(lblNewLabel_1_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"12th Pass", "10th Pass", "DHM/BHM"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(1035, 452, 199, 29);
		frmDeleteEmployee.getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteEmployee.setVisible(false);
			}
		});
		btnBack.setBounds(95, 639, 66, 20);
		frmDeleteEmployee.getContentPane().add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				    String FullName = txtGetdata.getText();
			        String MobileNo = txtMob.getText();
			        String Email = txtemail.getText();
			        String Address = txtAddress.getText();

			        System.out.println( FullName +" " + MobileNo + " " + Email + " " + Address);
			        		 
			        JDBCHandling db = new JDBCHandling();
					
					int status = db.insertDelete1( FullName, MobileNo, Email, Address);
					
					if(status==1) {
						JOptionPane.showMessageDialog(null,"Data Deleted!");
					}else if(status==0){
						JOptionPane.showMessageDialog(null,"Problem in deleting data.");
					
					}
			}
	});
		btnDelete.setBounds(631, 630, 88, 29);
		frmDeleteEmployee.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1168, 639, 66, 20);
		frmDeleteEmployee.getContentPane().add(btnExit);
		frmDeleteEmployee.setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteEmployee.class.getResource("/Images/logo.jpg")));
		frmDeleteEmployee.setTitle("Delete Employee");
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmDeleteEmployee.setSize(width,height);
		//frame.setBounds(100, 100, 450, 300);
		frmDeleteEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
