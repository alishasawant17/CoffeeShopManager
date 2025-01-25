package MyProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class UpdateEmployee {

	private JFrame frmUpdateEmployeeDetails;
	private JTextField txtgetdata;
	private JTextField txtmob;
	private JTextField txtemail;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee window = new UpdateEmployee();
					window.frmUpdateEmployeeDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateEmployeeDetails = new JFrame();
		frmUpdateEmployeeDetails.getContentPane().setBackground(new Color(255, 170, 170));
		frmUpdateEmployeeDetails.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateEmployee.class.getResource("/Images/logo.jpg")));
		frmUpdateEmployeeDetails.setTitle("Update Employee Details");
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmUpdateEmployeeDetails.setSize(width,height);
		//frame.setBounds(100, 100, 450, 300);
		frmUpdateEmployeeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateEmployeeDetails.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Full Name to Update:");
		lblNewLabel_2.setForeground(new Color(128, 64, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_2.setBackground(new Color(128, 64, 0));
		lblNewLabel_2.setBounds(190, 47, 292, 29);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_2);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String FullName=txtgetdata.getText();
				
				JDBCHandling db = new JDBCHandling();
				
				ResultSet result=null;

				result = db.getRow1(FullName);

				try {
                    while (result.next()) {
                        txtname.setText(result.getString(1));
                        txtmob.setText(result.getString(2));
                        txtemail.setText(result.getString(3));
                        
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } 
                    try {
                    	result.close();
       
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                
			}
		});
		btnGetData.setBounds(1090, 41, 100, 48);
		frmUpdateEmployeeDetails.getContentPane().add(btnGetData);
		
		txtgetdata = new JTextField();
		txtgetdata.setColumns(10);
		txtgetdata.setBounds(489, 47, 532, 29);
		frmUpdateEmployeeDetails.getContentPane().add(txtgetdata);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mobile no.: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(119, 185, 116, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(119, 232, 77, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(119, 283, 77, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_3);
		
		txtmob = new JTextField();
		txtmob.setColumns(10);
		txtmob.setBounds(299, 187, 722, 20);
		frmUpdateEmployeeDetails.getContentPane().add(txtmob);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(299, 234, 722, 20);
		frmUpdateEmployeeDetails.getContentPane().add(txtemail);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(299, 283, 722, 75);
		frmUpdateEmployeeDetails.getContentPane().add(txtAddress);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(299, 138, 722, 20);
		frmUpdateEmployeeDetails.getContentPane().add(txtname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Full Name.: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(119, 141, 116, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("D.O.B:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4_1.setBounds(119, 415, 57, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_4_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(202, 415, 210, 29);
		frmUpdateEmployeeDetails.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(491, 415, 77, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_4);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(578, 415, 212, 29);
		frmUpdateEmployeeDetails.getContentPane().add(panel);
		
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
		lblNewLabel_1_3_1.setBounds(883, 415, 116, 19);
		frmUpdateEmployeeDetails.getContentPane().add(lblNewLabel_1_3_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"12th Pass", "10th Pass", "DHM/BHM"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(1009, 411, 199, 29);
		frmUpdateEmployeeDetails.getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUpdateEmployeeDetails.setVisible(false);
			}
		});
		btnBack.setBounds(108, 651, 66, 20);
		frmUpdateEmployeeDetails.getContentPane().add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String FullName = txtname.getText();
				        String MobileNo = txtmob.getText();
				        String Email = txtemail.getText();
				        String Address = txtAddress.getText();

				        System.out.println(FullName + " " + MobileNo + " " + Email + " " + Address);
				        
				        java.util.Date selectedDate = dateChooser.getDate();

				        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
					    
					    System.out.println("DOB (java.sql.Date): " + sqlDate); 

				        System.out.println(sqlDate);
				        
				        if (selectedDate != null) {

				        String Qualification = comboBox.getSelectedItem().toString();
				        
				        JDBCHandling db = new JDBCHandling();
						
						int status = db.insertUpdate1(FullName, MobileNo, Email, Address,Qualification, sqlDate);
						
						if(status==1) {
							JOptionPane.showMessageDialog(null,"Data Updated!");
						}else if(status==0){
							JOptionPane.showMessageDialog(null,"Problem in adding data.");
						}


				        
				    }
				    }
				});


		btnSave.setBounds(631, 634, 88, 37);
		frmUpdateEmployeeDetails.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1152, 651, 66, 20);
		frmUpdateEmployeeDetails.getContentPane().add(btnExit);
	}
}
