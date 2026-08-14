package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.adminPanelController;
import controller.employeePanelController;
import database.Database_connection;
import model.adminPanel;
import model.employeePanel;
import service.ReportServices;

import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class AdminDashboardFrame extends JFrame{

//	private JFrame AdminDashboardFramee;
	private JTextField totalemployeetxt;
	private JTextField fullnametxt;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;
	String fnfrominput ;
	 String usfrominput ;
	 char[] pswfrominput ;
	  String id;
	 String role ;
	 public static String message;
	 adminPanelController apc = new adminPanelController();
	 employeePanelController epc = new employeePanelController();
	 private JTable employeetable;
	 private JTable employeetbl;
	 private JTextField idtxt;
	 private JTable table;
	 private JTextField totalcustomertxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboardFrame window = new AdminDashboardFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void refreshEmployeeTable() {

	    ArrayList fullnames = new ArrayList(adminPanelController.employee_fullname);
	    ArrayList usernames = new ArrayList(adminPanelController.employee_username);
	    ArrayList ids = new ArrayList(adminPanelController.employee_id);
	    ArrayList roles = new ArrayList(adminPanelController.employee_role);
	    if (adminPanelController.employee_fullname == null) {
	        System.out.println("employee_fullname is null");
	    }
	    if (adminPanelController.employee_username == null) {
	        System.out.println("employee_username is null");
	    }
	    if (adminPanelController.employee_id == null) {
	        System.out.println("employee_id is null");
	    }
	    if (adminPanelController.employee_role == null) {
	        System.out.println("employee_role is null");
	    }

	    DefaultTableModel model = (DefaultTableModel) employeetbl.getModel();

	    model.setRowCount(0); // remove old rows

	    for (int i = 0; i < fullnames.size(); i++) {
	        model.addRow(new Object[] {
	            ids.get(i),
	            fullnames.get(i),
	            usernames.get(i),
	            roles.get(i)
	        });
	    }
	}

	/**
	 * Create the application.
	 */
	public AdminDashboardFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminDashboardFrame.class.getResource("/images/images.jpg")));
		setTitle("Courier Management System");
		setBounds(100, 100, 1077, 699);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1094, 662);
		getContentPane().add(desktopPane);
		
		JDesktopPane menupanel = new JDesktopPane();
		menupanel.setBackground(Color.ORANGE);
		menupanel.setBounds(-30, 0, 229, 662);
		desktopPane.add(menupanel);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 10, 180, 21);
		menupanel.add(lblNewLabel);
		
		
		
		
		
		
		
		JDesktopPane parentpanel = new JDesktopPane();
		parentpanel.setBounds(199, 0, 865, 662);
		desktopPane.add(parentpanel);
		parentpanel.setLayout(new CardLayout(0, 0));
		
		JDesktopPane dashboardpanel = new JDesktopPane();
		dashboardpanel.setBackground(Color.PINK);
		parentpanel.add(dashboardpanel, "name_804619898566700");
		
		JLabel lblDashboardPanel = new JLabel("Dashboard Panel");
		lblDashboardPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboardPanel.setForeground(Color.RED);
		lblDashboardPanel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblDashboardPanel.setBounds(338, 10, 180, 21);
		dashboardpanel.add(lblDashboardPanel);
		
		JLabel lblTotalEmployees = new JLabel("Total Employees");
		lblTotalEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalEmployees.setForeground(Color.RED);
		lblTotalEmployees.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblTotalEmployees.setBounds(45, 76, 180, 21);
		dashboardpanel.add(lblTotalEmployees);
		
		apc.employee_count();
		totalemployeetxt = new JTextField();
		totalemployeetxt.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		totalemployeetxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totalemployeetxt.setText(String.valueOf(adminPanelController.totalCount));
		totalemployeetxt.setBounds(90, 107, 84, 28);
		dashboardpanel.add(totalemployeetxt);
		totalemployeetxt.setColumns(10);
		
		JLabel lblTotalCustomers = new JLabel("Total Customers");
		lblTotalCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCustomers.setForeground(Color.RED);
		lblTotalCustomers.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblTotalCustomers.setBounds(269, 76, 180, 21);
		dashboardpanel.add(lblTotalCustomers);
		epc.customer_count();
		totalcustomertxt = new JTextField();
		totalcustomertxt.setText(String.valueOf( employeePanelController.totalCount));
		totalcustomertxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalcustomertxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totalcustomertxt.setColumns(10);
		totalcustomertxt.setBounds(314, 107, 84, 28);
		dashboardpanel.add(totalcustomertxt);
		
		JDesktopPane employeepanel = new JDesktopPane();
		employeepanel.setBackground(Color.DARK_GRAY);
		
		parentpanel.add(employeepanel, "name_804625372200800");
		
		JLabel lblEmployeePanel = new JLabel("Employee Panel");
		lblEmployeePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeePanel.setForeground(Color.ORANGE);
		lblEmployeePanel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblEmployeePanel.setBounds(371, 9, 180, 21);
		employeepanel.add(lblEmployeePanel);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setForeground(Color.ORANGE);
		lblFullName.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblFullName.setBounds(77, 53, 100, 21);
		employeepanel.add(lblFullName);
		
		fullnametxt = new JTextField();
		fullnametxt.setEnabled(false);
		fullnametxt.setHorizontalAlignment(SwingConstants.LEFT);
		fullnametxt.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		fullnametxt.setColumns(10);
		fullnametxt.setBounds(198, 52, 180, 21);
		employeepanel.add(fullnametxt);
		
		JLabel usernamelbl = new JLabel("Username:");
		usernamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernamelbl.setForeground(Color.ORANGE);
		usernamelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		usernamelbl.setBounds(460, 53, 100, 21);
		employeepanel.add(usernamelbl);
		
		usernametxt = new JTextField();
		usernametxt.setEnabled(false);
		usernametxt.setHorizontalAlignment(SwingConstants.LEFT);
		usernametxt.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		usernametxt.setColumns(10);
		usernametxt.setBounds(581, 52, 180, 21);
		employeepanel.add(usernametxt);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setEnabled(false);
		passwordtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		passwordtxt.setBounds(198, 134, 180, 18);
		employeepanel.add(passwordtxt);
		
		JLabel passlbl = new JLabel("Password:");
		passlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passlbl.setForeground(Color.ORANGE);
		passlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		passlbl.setBounds(77, 134, 100, 21);
		employeepanel.add(passlbl);
		JLabel messagelbl = new JLabel("11");
		messagelbl.setVisible(false);
		
		messagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		messagelbl.setForeground(Color.ORANGE);
		messagelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		messagelbl.setBounds(266, 215, 386, 21);
		employeepanel.add(messagelbl);
		
		JLabel rolecombo = new JLabel("Role:");
		rolecombo.setHorizontalAlignment(SwingConstants.CENTER);
		rolecombo.setForeground(Color.ORANGE);
		rolecombo.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		rolecombo.setBounds(500, 133, 84, 21);
		employeepanel.add(rolecombo);
		
		String[] rolelist = {"Admin", "Employee"};
		JComboBox rolecomboBox = new JComboBox(rolelist);
		rolecomboBox.setEnabled(false);
		rolecomboBox.setModel(new DefaultComboBoxModel(new String[] {"Employee"}));
		rolecomboBox.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		rolecomboBox.setBounds(594, 135, 104, 20);
		employeepanel.add(rolecomboBox);
		
		
		
	
		
		
		
		
		
		JButton savebtn = new JButton("Save");
		savebtn.setEnabled(false);
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnfrominput = fullnametxt.getText();
				  usfrominput = usernametxt.getText();
				  pswfrominput =  passwordtxt.getPassword();
				  role = (String) rolecomboBox.getSelectedItem();
				  
				  
				  
				adminPanel ap = new adminPanel(fnfrominput, usfrominput, pswfrominput, role);
				
				
				
				apc.employee_data_insert();
				apc.employee_data_fetch();
				
				 refreshEmployeeTable(); // <-- update JTable
				 messagelbl.setVisible(true);
			        fullnametxt.setText("");
			        usernametxt.setText("");
			        passwordtxt.setText("");
				
				
			}
		});
		savebtn.setBackground(Color.RED);
		savebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		savebtn.setBounds(257, 185, 84, 20);
		employeepanel.add(savebtn);
		
		JButton updatebtn = new JButton("Update");
		updatebtn.setEnabled(false);
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnfrominput = fullnametxt.getText();
				usfrominput = usernametxt.getText();
				id = idtxt.getText(); 
				System.out.println(id);
				adminPanel ap1 = new adminPanel(id  , fnfrominput, usfrominput);
				
				System.out.println("proam "+ adminPanel.getEmployee_id() );
				apc.employee_data_update();
				apc.employee_data_fetch();
				refreshEmployeeTable(); // <-- update JTable
				idtxt.setText("");
		        fullnametxt.setText("");
		        usernametxt.setText("");
		        messagelbl.setVisible(true);
			
		        messagelbl.setText(message);
		        savebtn.setEnabled(true);
		        updatebtn.setEnabled(false);
		        
			}
		});
		updatebtn.setBackground(Color.RED);
		updatebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		updatebtn.setBounds(391, 185, 94, 20);
		employeepanel.add(updatebtn);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.setEnabled(false);
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = idtxt.getText(); 
				adminPanel ap1 = new adminPanel(id  , fnfrominput, usfrominput);
				
				apc.employee_data_delete();
				apc.employee_data_fetch();
				refreshEmployeeTable(); // <-- update JTable
				idtxt.setText("");
				fullnametxt.setText("");
		        usernametxt.setText("");
		        messagelbl.setText(message);
		        messagelbl.setVisible(true);
			}
		});
		deletebtn.setBackground(Color.RED);
		deletebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		deletebtn.setBounds(523, 185, 84, 20);
		employeepanel.add(deletebtn);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.ORANGE);
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblId.setBounds(333, 103, 84, 21);
		employeepanel.add(lblId);
		
		idtxt = new JTextField();
		idtxt.setEditable(false);
		idtxt.setEnabled(false);
		idtxt.setHorizontalAlignment(SwingConstants.LEFT);
		idtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		idtxt.setColumns(10);
		idtxt.setBounds(427, 102, 119, 21);
		employeepanel.add(idtxt);
		
	
		
		
		
		
		
	
	
		
		
		
		JButton dashboardbtn = new JButton("Dashboard");
		dashboardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				apc.employee_count();
				String.valueOf( employeePanelController.totalCount);
				parentpanel.removeAll();
				parentpanel.add(dashboardpanel);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		dashboardbtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		dashboardbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		dashboardbtn.setBackground(Color.CYAN);
		dashboardbtn.setBounds(30, 41, 199, 40);
		menupanel.add(dashboardbtn);
		
		
		JButton employeebtn = new JButton("Employee");
		employeebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(employeepanel);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		employeebtn.setSelectedIcon(null);
		employeebtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		employeebtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		employeebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		employeebtn.setBackground(Color.CYAN);
		employeebtn.setBounds(29, 91, 200, 40);
		menupanel.add(employeebtn);
		
		
		
		
		JButton newbtn = new JButton("New");
		newbtn.setBackground(Color.RED);
		newbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fullnametxt.setEnabled(true);
				fullnametxt.setBackground(Color.ORANGE);
				fullnametxt.requestFocusInWindow();
				
				
				usernametxt.setEnabled(true);
				usernametxt.setBackground(Color.ORANGE);
				
				passwordtxt.setEnabled(true);
				passwordtxt.setBackground(Color.ORANGE);
				
				rolecomboBox.setBackground(Color.ORANGE);
				
				idtxt.setBackground(Color.ORANGE);
				
				savebtn.setEnabled(true);
				updatebtn.setEnabled(false);
				deletebtn.setEnabled(false);
			}
		});
		newbtn.setBounds(135, 185, 84, 20);
		employeepanel.add(newbtn);
		
		
apc.employee_data_fetch();
		
		ArrayList fullnames = new ArrayList(adminPanelController.employee_fullname);
		ArrayList usernames = new ArrayList(adminPanelController.employee_username);
		ArrayList ids = new ArrayList(adminPanelController.employee_id);
		ArrayList roles = new ArrayList(adminPanelController.employee_role);
		String[] columnNames = { "ID", "Fullname", "Username", "Role" };
//		
		System.out.println("This is AdminDashboardFrame: "+usernames);
		String[][] data1 = new String[fullnames.size()][4];
		for(int i = 0; i < fullnames.size() ; i++) {
			data1[i][0] =  String.valueOf(ids.get(i)) ; 
			data1[i][1] = (String) fullnames.get(i);
		    data1[i][2] = (String) usernames.get(i);
		    data1[i][3] = (String )roles.get(i); 
			}
			
		
		DefaultTableModel model = new DefaultTableModel(data1, columnNames) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		employeetbl = new JTable( model);
		employeetbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				fullnametxt.setEnabled(true);
				usernametxt.setEnabled(true);
				savebtn.setEnabled(false);
				updatebtn.setEnabled(true);
				deletebtn.setEnabled(true);
				 int row = employeetbl.getSelectedRow();
			        idtxt.setText(employeetbl.getValueAt(row, 0).toString());
			        fullnametxt.setText(employeetbl.getValueAt(row, 1).toString());
			        usernametxt.setText(employeetbl.getValueAt(row, 2).toString());
			        
				
			}
		});
		
		employeetbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		employeetbl.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		JScrollPane scrollPane = new JScrollPane(employeetbl);
		scrollPane.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		scrollPane.setBounds(62, 270, 730, 349);
		employeepanel.add(scrollPane);
		
		JDesktopPane Customerpane = new JDesktopPane();
		Customerpane.setBackground(Color.GREEN);
		parentpanel.add(Customerpane, "name_401014838455900");
		
		JLabel lblEmployeeDetails = new JLabel("Customers Details");
		lblEmployeeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDetails.setForeground(Color.RED);
		lblEmployeeDetails.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblEmployeeDetails.setBounds(336, 10, 180, 21);
		Customerpane.add(lblEmployeeDetails);
		
		 ArrayList <Integer> customers_ids = new ArrayList <Integer>();
		 ArrayList <String>customers_usernames = new  ArrayList <String>();
		 ArrayList <String> customers_fullnames = new ArrayList <String>();
		 ArrayList <String> customers_Cnic  = new  ArrayList <String>();
		 ArrayList <String> customers_addresses= new ArrayList <String>();
		 ArrayList <String> customers_phonenumbers = new ArrayList <String>();
		
		employeePanelController epc = new employeePanelController();
		epc.customer_data_fetch();
		customers_ids = employeePanelController.customer_ids ;
		customers_usernames = employeePanelController.customer_username ;
		customers_fullnames = employeePanelController.customer_fullname ;
		customers_phonenumbers = employeePanelController.customer_phonenumber ;
		customers_Cnic = employeePanelController.customer_cnic;
		customers_addresses = employeePanelController.customer_address;
		
		String[] column2 = {"id","Fullname","Username","CNIC", "phone","Address"};
		String[][] data2 = new String [customers_fullnames.size()][6];
		for(int i = 0; i < customers_fullnames.size() ; i++) {
			data2[i][0] =  String.valueOf(customers_ids.get(i)); 
			data2[i][1] = (String) customers_fullnames.get(i);
		    data2[i][2] = (String) customers_usernames.get(i);
		    data2[i][3] = String.valueOf(customers_Cnic.get(i));
		    data2[i][4] = (String) customers_phonenumbers.get(i);
		    data2[i][5] = (String )customers_addresses.get(i); 
		    
			}
		DefaultTableModel model1 = new DefaultTableModel(data2, column2)  {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		table = new JTable(model1);
		table.setFont(new Font("Segoe UI", Font.BOLD, 14));
		table.setBounds(0, 0, 6, 6);
		Customerpane.add(table);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		scrollPane_1.setBounds(25, 75, 818, 577);
		Customerpane.add(scrollPane_1);
		
		JDesktopPane ReportsPane = new JDesktopPane();
		ReportsPane.setBackground(new Color(255, 0, 128));
		parentpanel.add(ReportsPane, "name_86002816448600");
		
		JLabel messbox = new JLabel("");
		messbox.setHorizontalAlignment(SwingConstants.CENTER);
		messbox.setForeground(new Color(255, 255, 0));
		messbox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		messbox.setBounds(381, 637, 130, 14);
		ReportsPane.add(messbox);
		JButton btnDownloadEmployeeReport = new JButton("Employees Report");
		btnDownloadEmployeeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportServices.reports();
				
				messbox.setEnabled(true);
				messbox.setText("Saved Successfully PDF");
			}
		});
		btnDownloadEmployeeReport.setForeground(Color.RED);
		btnDownloadEmployeeReport.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDownloadEmployeeReport.setBackground(new Color(255, 128, 0));
		btnDownloadEmployeeReport.setBounds(87, 244, 140, 23);
		ReportsPane.add(btnDownloadEmployeeReport);
		
		JButton btnCustomersReport = new JButton("Customers Report");
		btnCustomersReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportServices.customerreport();
				messbox.setText("Save Successfully");
			}
		});
		btnCustomersReport.setForeground(Color.RED);
		btnCustomersReport.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCustomersReport.setBackground(new Color(255, 128, 0));
		btnCustomersReport.setBounds(341, 244, 140, 23);
		ReportsPane.add(btnCustomersReport);
		
		
		
		
		JButton customerbtn = new JButton("Customers");
		customerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(Customerpane);
				parentpanel.repaint();
				parentpanel.revalidate();
				epc.customer_count();
				totalcustomertxt.setText(String.valueOf( employeePanelController.totalCount));
			}
		});
		customerbtn.setSelectedIcon(null);
		customerbtn.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		customerbtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		customerbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		customerbtn.setBackground(Color.CYAN);
		customerbtn.setBounds(29, 141, 200, 40);
		menupanel.add(customerbtn);
		
		JButton btnReports = new JButton("Reports");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(ReportsPane);
				parentpanel.repaint();
				parentpanel.revalidate();
				
			}
		});
		btnReports.setSelectedIcon(null);
		btnReports.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnReports.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnReports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReports.setBackground(Color.CYAN);
		btnReports.setBounds(29, 192, 200, 40);
		menupanel.add(btnReports);
		
		
	}
}
