package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Customer_login_Conntroller;
import model.Customer_Login;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Login_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passwordField;
	public static String username_from_input ;
	public static String password_from_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Login_Frame frame = new Customer_Login_Frame();
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
	public Customer_Login_Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customer_Login_Frame.class.getResource("/images/images.jpg")));
		setTitle("Courier Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Customer_Login_Frame.class.getResource("/images/4 (3).png")));
		lblNewLabel.setBounds(0, 204, 148, 150);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(171, 10, 126, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(67, 94, 91, 27);
		contentPane.add(lblNewLabel_2);
		
		usernametxt = new JTextField();
		usernametxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernametxt.setBounds(171, 100, 158, 18);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(67, 142, 91, 27);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 148, 158, 18);
		contentPane.add(passwordField);
		Customer_login_Conntroller CLC = new Customer_login_Conntroller();
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			username_from_input = usernametxt.getText().trim();
			password_from_input =String.valueOf(passwordField.getPassword()) ;	
			Customer_Login cf = new Customer_Login(username_from_input, password_from_input);
			cf.display();
			System.out.println(username_from_input +" "+ password_from_input);
			
			CLC.login();
			if(CLC.username.equals(username_from_input) && CLC.password.equals(password_from_input)){
				Customerpanel_Frame frame = new Customerpanel_Frame();
				frame.setVisible(true);
				Customer_Login_Frame.this.dispose();
			}
			
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(202, 204, 95, 18);
		contentPane.add(btnNewButton);
		
		JButton btnLoginAsEmployee = new JButton("Login as Employee");
		btnLoginAsEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeLogin_Frame elf = new EmployeeLogin_Frame();
				elf.setVisible(true);
				Customer_Login_Frame.this.dispose();
				
			}
		});
		btnLoginAsEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoginAsEmployee.setBackground(Color.PINK);
		btnLoginAsEmployee.setBounds(172, 268, 171, 18);
		contentPane.add(btnLoginAsEmployee);

	}
}
