package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.employeeloginController;
import model.Employee_login;

import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeLogin_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserLogin;
	private JPasswordField passwordField;
	private String usfrominput;
	private String pswfrominput;
	private String userrole;
	
	employeeloginController lg = new employeeloginController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLogin_Frame frame = new EmployeeLogin_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeLogin_Frame() {
		setTitle("CourierManagementSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dell\\Downloads\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 255, 255));
		desktopPane.setBounds(0, 0, 606, 505);
		contentPane.add(desktopPane);
		
		txtUserLogin = new JTextField();
		txtUserLogin.setText("Employee Login");
		txtUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		txtUserLogin.setEnabled(false);
		txtUserLogin.setEditable(false);
		txtUserLogin.setDisabledTextColor(Color.RED);
		txtUserLogin.setColumns(7);
		txtUserLogin.setBorder(null);
		txtUserLogin.setBackground(Color.CYAN);
		txtUserLogin.setAlignmentY(1.0f);
		txtUserLogin.setAlignmentX(1.0f);
		txtUserLogin.setBounds(203, 73, 262, 29);
		desktopPane.add(txtUserLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIconTextGap(10);
		lblNewLabel.setIcon(new ImageIcon(EmployeeLogin_Frame.class.getResource("/images/4 (3).png")));
		lblNewLabel.setBounds(10, 10, 149, 163);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(169, 159, 105, 21);
		desktopPane.add(lblNewLabel_1);
		
		JTextArea usernametxt = new JTextArea();
		usernametxt.setTabSize(0);
		usernametxt.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		usernametxt.setFocusTraversalKeysEnabled(false);
		usernametxt.setBounds(284, 161, 200, 21);
usernametxt.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "moveFocus");
		
		usernametxt.getActionMap().put("moveFocus", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        usernametxt.transferFocus();
		    }
		    
		});
		desktopPane.add(usernametxt);
		
		JButton loginbtn = new JButton("Login");
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		passwordField.setFocusTraversalKeysEnabled(false);
		passwordField.setBounds(284, 216, 200, 21);
		passwordField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "moveFocus");
		passwordField.getActionMap().put("moveFocus", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        passwordField.transferFocus();
		    }
		});
		passwordField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "register");
		passwordField.getActionMap().put("register", new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        loginbtn.doClick();
		    }
		});
		desktopPane.add(passwordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(169, 214, 105, 21);
		desktopPane.add(lblNewLabel_1_1);
		
		JLabel Rolelbl = new JLabel("Role:");
		Rolelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		Rolelbl.setBounds(253, 270, 44, 23);
		desktopPane.add(Rolelbl);
		
		String[] rolelist = {"Admin", "Employee"};
		JComboBox<String> rolecombobox = new JComboBox<String>(rolelist);
		rolecombobox.setModel(new DefaultComboBoxModel(new String[] {"Employee"}));
		rolecombobox.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		rolecombobox.setBounds(new Rectangle(20, 20, 0, 0));
		rolecombobox.setBounds(294, 273, 109, 20);
		desktopPane.add(rolecombobox);
		
		JLabel messageboxlbl = new JLabel("Login Successfully");
		messageboxlbl.setVisible(false);
		messageboxlbl.setForeground(new Color(255, 0, 0));
		messageboxlbl.setHorizontalAlignment(SwingConstants.CENTER);
		messageboxlbl.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		messageboxlbl.setBounds(245, 404, 149, 21);
		desktopPane.add(messageboxlbl);
		
		
		loginbtn.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	loginbtn.setBackground(new Color(0, 86, 179)); // Darker blue
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	loginbtn.setBackground(new Color(0, 123, 255)); // Original blue
		    }
		});
		
		loginbtn.addActionListener(new ActionListener() {

	       
			public void actionPerformed(ActionEvent e) {
				
				usfrominput = usernametxt.getText();
				pswfrominput = new String(passwordField.getPassword());
				userrole = (String) rolecombobox.getSelectedItem();
				Employee_login log = new Employee_login(usfrominput, pswfrominput, userrole);
				log.display();
				
				
				lg.fetchingemployee_db();;

				
				
				if (lg.username.equals(usfrominput)&& lg.password.equals(pswfrominput))  {
				    employee_dashboard_Frame ELF = new employee_dashboard_Frame();
				    ELF.setVisible(true);
				    EmployeeLogin_Frame.this.dispose();
				    messageboxlbl.setText("Successfull Login");
				   
				}else {
					messageboxlbl.setText("Something Wrong");
				}
				
			}
		});
		loginbtn.setForeground(Color.WHITE);
		loginbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		loginbtn.setFocusTraversalPolicyProvider(true);
		loginbtn.setFocusTraversalKeysEnabled(false);
		loginbtn.setFocusPainted(false);
		loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbtn.setContentAreaFilled(true);
		loginbtn.setBorderPainted(false);
		loginbtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		loginbtn.setBackground(new Color(0, 123, 255));
		loginbtn.setBounds(244, 324, 150, 40);
		desktopPane.add(loginbtn);
		
		
		
		JButton GoToLoginbtn = new JButton("Go to Admin Login");
		GoToLoginbtn.setForeground(new Color(65, 105, 225));
		GoToLoginbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		GoToLoginbtn.setFocusTraversalPolicyProvider(true);
		GoToLoginbtn.setFocusTraversalKeysEnabled(false);
		GoToLoginbtn.setFocusPainted(false);
		GoToLoginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GoToLoginbtn.setContentAreaFilled(true);
		GoToLoginbtn.setBorderPainted(false);
		GoToLoginbtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		GoToLoginbtn.setBackground(new Color(255, 165, 0));
		GoToLoginbtn.setBounds(235, 435, 171, 21);
		desktopPane.add(GoToLoginbtn);
		
		JButton btnLoginAsCustomer = new JButton("Login as Customer");
		btnLoginAsCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Login_Frame clf = new Customer_Login_Frame();
				clf.setVisible(true);
				EmployeeLogin_Frame.this.dispose();
			}
		});
		btnLoginAsCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoginAsCustomer.setBackground(Color.PINK);
		btnLoginAsCustomer.setBounds(235, 477, 171, 18);
		desktopPane.add(btnLoginAsCustomer);
		
		
		GoToLoginbtn.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	GoToLoginbtn.setBackground(new Color(0, 86, 179));
		    	GoToLoginbtn.setForeground(new Color(255, 0, 0));// Darker blue
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	GoToLoginbtn.setBackground(new Color(255, 165, 0)); // Original blue
		    }
		});
		GoToLoginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin_Frame alf = new AdminLogin_Frame();
			alf.setVisible(true);
			EmployeeLogin_Frame.this.dispose();
			}
		});

	}
	public String getusername() {
		return usfrominput;
	}
	public String getpassword() {
		return pswfrominput;
	}
	public String getrole() {
		return userrole;
	}
}
