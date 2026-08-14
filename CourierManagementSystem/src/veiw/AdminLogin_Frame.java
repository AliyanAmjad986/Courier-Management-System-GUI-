package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.adminLoginController;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AdminLogin_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordtxt;
	public static String username_from_input;
	public static String password_from_input;
	public static String userrole_from_input;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin_Frame frame = new AdminLogin_Frame();
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
	public AdminLogin_Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin_Frame.class.getResource("/images/images.jpg")));
		setTitle("Courier Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(204, 66, 150, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(72, 219, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(77, 285, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox<String> rolecombobox = new JComboBox<String>();
		rolecombobox.setEnabled(false);
		rolecombobox.setModel(new DefaultComboBoxModel(new String[] {"Admin"}));
		rolecombobox.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		rolecombobox.setBounds(new Rectangle(20, 20, 0, 0));
		rolecombobox.setBounds(210, 357, 109, 20);
		contentPane.add(rolecombobox);
		
		JLabel Rolelbl = new JLabel("Role:");
		Rolelbl.setForeground(Color.RED);
		Rolelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		Rolelbl.setBounds(156, 356, 44, 23);
		contentPane.add(Rolelbl);
		
		
		JLabel messageboxlbl = new JLabel("");
		messageboxlbl.setHorizontalAlignment(SwingConstants.CENTER);
		messageboxlbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		messageboxlbl.setBounds(148, 566, 206, 14);
		contentPane.add(messageboxlbl);
		
		
		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		passwordtxt.setFocusTraversalKeysEnabled(false);
		passwordtxt.setBounds(191, 281, 200, 21);
		contentPane.add(passwordtxt);
		
		JTextArea usernametxt = new JTextArea();
		usernametxt.setTabSize(0);
		usernametxt.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		usernametxt.setFocusTraversalKeysEnabled(false);
		usernametxt.setBounds(191, 213, 200, 21);
		contentPane.add(usernametxt);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username_from_input = usernametxt.getText().trim();
				password_from_input = String.valueOf( passwordtxt.getPassword());
				userrole_from_input = (String) rolecombobox.getSelectedItem();
				
				adminLoginController alc = new adminLoginController();
				alc.fetchlogin_details();
				System.out.println(alc.password+ "geo"+password_from_input);
				if(alc.username.equals(username_from_input)  && alc.password.equals(password_from_input) ) {
					AdminDashboardFrame adf = new AdminDashboardFrame();
					adf.setVisible(true);
					AdminLogin_Frame.this.dispose();
					System.out.println("loged int");
					messageboxlbl.setText("Login Successfully");
				}else {
					System.out.println("not work");
					messageboxlbl.setText("Wrong Username or Password");
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
		loginbtn.setBounds(169, 464, 150, 40);
		contentPane.add(loginbtn);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(AdminLogin_Frame.class.getResource("/images/4 (3).png")));
		lblNewLabel_3.setBounds(10, 11, 150, 168);
		contentPane.add(lblNewLabel_3);
		
		JButton GoToLoginbtn = new JButton("Go to Employee Login");
		GoToLoginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLogin_Frame elf = new EmployeeLogin_Frame();
				elf.setVisible(true);
				AdminLogin_Frame.this.dispose();
			
			}
		});
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
		GoToLoginbtn.setBounds(154, 530, 184, 21);
		contentPane.add(GoToLoginbtn);
		
	

	}
}
