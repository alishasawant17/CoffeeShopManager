package MyProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import org.jdatepicker.util.JDatePickerUtil;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.UtilCalendarModel;
import org.jdatepicker.impl.DateComponentFormatter;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.DefaultComboBoxModel;

public class AddEmployee {

	private JFrame frmEmployeeForm;
	private JTextField txtName;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JDateChooser dateChooser;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
					window.frmEmployeeForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frmEmployeeForm = new JFrame();
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		frmEmployeeForm.setSize(width,height);
		frmEmployeeForm.setLocationRelativeTo(null);
		frmEmployeeForm.getContentPane().setBackground(new Color(255, 185, 185));
		frmEmployeeForm.setTitle("Employee Form");
		frmEmployeeForm.setIconImage(Toolkit.getDefaultToolkit().getImage(AddEmployee.class.getResource("/Images/logo.jpg")));
		//frmEmployeeForm.setBounds(100, 100, 664, 473);
		frmEmployeeForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Entry Form");
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(555, 11, 239, 44);
		frmEmployeeForm.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(549, 53, 251, 2);
		frmEmployeeForm.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(166, 79, 108, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mobile no.: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(166, 112, 116, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(166, 145, 77, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(166, 172, 77, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(472, 381, 77, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_4);
		
		
		
		
		txtName = new JTextField();
		txtName.setBounds(437, 81, 722, 20);
		frmEmployeeForm.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(437, 172, 722, 75);
		frmEmployeeForm.getContentPane().add(txtAddress);
		
		txtMobile = new JTextField();
		txtMobile.setBounds(437, 114, 722, 20);
		frmEmployeeForm.getContentPane().add(txtMobile);
		txtMobile.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(437, 144, 722, 20);
		frmEmployeeForm.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(582, 371, 212, 29);
		frmEmployeeForm.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton btnMale = new JRadioButton("Male ");
		btnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(btnMale);
		btnMale.setBounds(0, 0, 58, 37);
		panel.add(btnMale);
		
		JRadioButton btnFemale = new JRadioButton("Female");
		btnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(btnFemale);
		btnFemale.setBounds(60, 0, 75, 37);
		panel.add(btnFemale);
		
		JRadioButton btnOther = new JRadioButton("Other");
		btnOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(btnOther);
		btnOther.setBounds(137, 0, 62, 37);
		panel.add(btnOther);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1323, 184, 17, 288);
		frmEmployeeForm.getContentPane().add(scrollBar);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Qualification:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3_1.setBounds(917, 381, 116, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_3_1);
		
		JComboBox<?> comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		String[] Qualification = {"12th Pass", "10th Pass" , "DHM/BHM"};
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"12th Pass", "10th Pass", "DHM/BHM"}));
		comboBox.setBounds(1043, 371, 199, 29);
		frmEmployeeForm.getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeForm.setVisible(false);
			}
		});
		btnBack.setBounds(61, 650, 66, 20);
		frmEmployeeForm.getContentPane().add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAddress.setText(null);
				txtEmail.setText(null);
				txtMobile.setText(null);
				txtName.setText(null);
			}
		});
		btnReset.setBounds(399, 650, 76, 20);
		frmEmployeeForm.getContentPane().add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FullName = txtName.getText();
				String MobileNo = txtMobile.getText();
				String Email = txtEmail.getText();
				String Address = txtAddress.getText();
				//String Gender = JRadioButton.getDefaultGender();
				
				String Gender = null;
				if(btnMale.isSelected()){
					Gender = "Male";
					}
				if(btnFemale.isSelected()) {
					Gender = "Female";
				}
				if(btnOther.isSelected()) {
					Gender = "Other";
				}
				
				String Qualification = comboBox.getSelectedItem().toString();

				java.util.Date selectedDate = dateChooser.getDate();

				if (selectedDate != null) {
				    // Convert java.util.Date to java.sql.Date
				    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
				    
				    System.out.println("DOB (java.sql.Date): " + sqlDate); 
				
//				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
//				Date selectedDate = (Date) dateChooser.getDate();
//				String DOB = selectedDate != null ? sdf.format(selectedDate) : "";


	
			
				
				System.out.println(FullName+ MobileNo + Email + Address + Qualification+ sqlDate);
				
				JDBCHandling db = new JDBCHandling();
				
                int status = db.insertData(FullName, MobileNo, Email, Address,Gender, Qualification, sqlDate);
				
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Updated!");
				}else if(status==0){
					JOptionPane.showMessageDialog(null,"Problem in adding data.");
				}
			}

			}
			
		});
		btnSave.setBounds(789, 650, 76, 20);
		frmEmployeeForm.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeForm.setVisible(false);
			}
			
		});
		btnExit.setBounds(1174, 650, 76, 20);
		frmEmployeeForm.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("D.O.B:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4_1.setBounds(61, 381, 57, 19);
		frmEmployeeForm.getContentPane().add(lblNewLabel_1_4_1);
						
						JPanel panel_1 = new JPanel();
						panel_1.setBounds(128, 371, 212, 29);
						frmEmployeeForm.getContentPane().add(panel_1);
						panel_1.setLayout(null);
						
								// Create the JDateChooser and add it to the panel
								//JDateChooser dateChooser = new JDateChooser();
								dateChooser = new JDateChooser();
								dateChooser.setBounds(0, 0, 210, 29);
								panel_1.add(dateChooser);

}
}