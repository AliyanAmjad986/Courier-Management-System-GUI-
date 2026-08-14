package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.eclipse.swt.widgets.MessageBox;

import controller.adminPanelController;
import controller.employeePanelController;
import controller.parcel_DetailController;
//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
import model.adminPanel;
import model.employeePanel;
import model.parcel_detail;
import service.ReportServices;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;


import com.toedter.calendar.JDateChooser;
import javax.swing.ListSelectionModel;

public class employee_dashboard_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtxt;
	private JTextField fullnametxt;
	private JTextField usernametxt;
	private JTextField cnictxt;
	private JTextField addresstxt;
	private JPasswordField passwordtxt;
	private JTextField phonenumbertxt;
	private JTable table;
	public static int id_fromuser ;
	public static String  fnfrominput;
	public static String unfrominput;
	public static String cnicfrominput;
	public static char[] pswfrominput;
	public static String addressfrominput;
	public static String phonefrominput;
	public static ArrayList <Integer> ids = new ArrayList <Integer>();
	public static ArrayList <String>usernames = new  ArrayList <String>();
	public static ArrayList <String> fullnames = new ArrayList <String>();
	public static ArrayList <String> Cnic = new  ArrayList <String>();
	public static ArrayList <String> addresses = new ArrayList <String>();
	public static ArrayList <String> phonenumbers = new ArrayList <String>();
	public static JTextField totalcustxt;
	public static JTextField trackingidtxt;
	public static JTextField sendertxt;
	public static JTextField receivertxt;
	public static JTextField pickupaddresstxt;
	public static JTextField weighttxt;
	public static JTextField pricetxt;
	public static JTable Receivertable;
	public static JTable Sendertable;
	public static int price;	
	public static JTextField trackingid;
	public static int tracking_id_from_input;
	public static String pickadd_input;
	public static String receiver_from_input;
	public static String sender_from_input;
	public static String parcelType_from_input;
	public static int weight_from_input;
	public static int price_from_input;
	public static Date bookingDate_from_input;
	public static Date expectedDeliveryDate_from_input;
	public static String currentStatus_from_input;
	private JTable parceltable;
	private JTextField totalparceltxt;
	private JTextField totalpendingparcelstxt;
	private JTextField totaltransitparcels;
	private JTextField totaldeliveredparcels;
	private JTextField totaldeliveryfailedtxt;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					
					employee_dashboard_Frame frame = new employee_dashboard_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refreshEmployeeTable() {
		 
		  ArrayList <Integer> ids1 = new ArrayList <Integer>(employeePanelController.customer_ids);
		 ArrayList <String>usernames1 = new  ArrayList <String>(employeePanelController.customer_username);
		 ArrayList <String> fullnames1 = new ArrayList <String>(employeePanelController.customer_fullname);
		 ArrayList <String> phonenumber1 = new  ArrayList<String> (employeePanelController.customer_phonenumber);
		 ArrayList <String> Cnic1 = new  ArrayList<String> (employeePanelController.customer_cnic);
		 ArrayList <String> addresses1 = new ArrayList <String>(employeePanelController.customer_address);
		 ArrayList <String> phonenumber = new ArrayList <String>(employeePanelController.customer_phonenumber);
	    if (employeePanelController.customer_ids == null) {
	        System.out.println("customer_ids is null");
	    }
	    if (employeePanelController.customer_username == null) {
	        System.out.println("customer_username is null");
	    }
	    if (employeePanelController.customer_fullname == null) {
	        System.out.println("customer_fullname is null");
	    }
	    if (employeePanelController.customer_phonenumber == null) {
	        System.out.println("customer_phone is null");
	    }
	    if (employeePanelController.customer_cnic == null) {
	        System.out.println("customer_Cnic is null");
	    }
	    if (employeePanelController.customer_address == null) {
	        System.out.println("customer_address is null");
	    }
	    DefaultTableModel model = (DefaultTableModel) table.getModel();

	    model.setRowCount(0); // remove old rows

	    for (int i = 0; i < fullnames.size(); i++) {
	        model.addRow(new Object[] {
	            ids1.get(i),
	            fullnames1.get(i),
	            usernames1.get(i),
	            phonenumber1.get(i),
	            Cnic1.get(i),
	            addresses1.get(i)
	        });
	    }
	
	}
	void parcel_table_refresh() {
		 
		ArrayList tracking_ids1      = new ArrayList(parcel_DetailController.tracking_ids);
		ArrayList receivers1         = new ArrayList(parcel_DetailController.Receivers);
		ArrayList senders1           = new ArrayList(parcel_DetailController.Sender);
		ArrayList weight1            = new ArrayList(parcel_DetailController.Weights);
		ArrayList price1             = new ArrayList(parcel_DetailController.prices);
		ArrayList parceltypes1       = new ArrayList(parcel_DetailController.parcel_types);
		ArrayList booking_dates1     = new ArrayList(parcel_DetailController.booking_dates);
		ArrayList expected_dates1    = new ArrayList(parcel_DetailController.expected_date);
		ArrayList pickup_addresses1  = new ArrayList(parcel_DetailController.pickup_address);
		ArrayList currentstatus1     = new ArrayList(parcel_DetailController.current_status);

		// Null Checks
		if (parcel_DetailController.tracking_ids == null) {
		    System.out.println("tracking_ids is null");
		}

		if (parcel_DetailController.Receivers == null) {
		    System.out.println("Receivers is null");
		}

		if (parcel_DetailController.Sender == null) {
		    System.out.println("Sender is null");
		}

		if (parcel_DetailController.Weights == null) {
		    System.out.println("Weights is null");
		}

		if (parcel_DetailController.prices == null) {
		    System.out.println("prices is null");
		}

		if (parcel_DetailController.parcel_types == null) {
		    System.out.println("parcel_types is null");
		}

		if (parcel_DetailController.booking_dates == null) {
		    System.out.println("booking_dates is null");
		}

		if (parcel_DetailController.expected_date == null) {
		    System.out.println("expected_date is null");
		}

		if (parcel_DetailController.pickup_address == null) {
		    System.out.println("pickup_address is null");
		}

		if (parcel_DetailController.current_status == null) {
		    System.out.println("current_status is null");
		}
	    DefaultTableModel model = (DefaultTableModel) parceltable.getModel();

	    model.setRowCount(0); // remove old rows

	    for (int i = 0; i < tracking_ids1.size(); i++) {
	        model.addRow(new Object[] {
	            tracking_ids1.get(i),
	            receivers1.get(i),
	            senders1.get(i),
	            weight1.get(i),
	            price1.get(i),
	            booking_dates1.get(i),
	            expected_dates1.get(i),
	            parceltypes1.get(i),
	            pickup_addresses1.get(i),
	            currentstatus1.get(i)
	        });
	    }
	}
	
	public employee_dashboard_Frame() {
		parcel_DetailController pdc = new parcel_DetailController();
		employeePanelController epc = new employeePanelController();
		
		setTitle("CourierManagementSystem");
		setIconImage(Toolkit.getDefaultToolkit().getImage(employee_dashboard_Frame.class.getResource("/images/Untitled design (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1230, 890);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(-13, 0, 215, 853);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setBounds(59, 5, 96, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1, 1);
		contentPane.add(scrollPane_1);
		
		
		
		
		
		
		JDesktopPane parentpanel = new JDesktopPane();
		parentpanel.setBounds(199, 0, 1027, 863);
		contentPane.add(parentpanel);
		parentpanel.setLayout(new CardLayout(0, 0));
		
		JDesktopPane dashboardpane = new JDesktopPane();
		dashboardpane.setBackground(Color.YELLOW);
		parentpanel.add(dashboardpane, "name_45865293011400");
		dashboardpane.setLayout(null);
		
		JButton dashboardbtn = new JButton("Dashboard");
		dashboardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdc.total_parcel_fetch();
				pdc.total_in_transist();
				pdc.total_in_delivery_failed();
				pdc.total_in_delivered();
				epc.customer_count();
				totaltransitparcels.setText(String.valueOf(pdc.total_in_transists_parcels));
				totalpendingparcelstxt.setText(String.valueOf(pdc.total_in_pending_parcels));
				totaldeliveryfailedtxt.setText(String.valueOf(pdc.total_delivery_failed_parcels));
				totaldeliveredparcels.setText(String.valueOf(pdc.total_delivered_parcels));
				totalcustxt.setText(String.valueOf( employeePanelController.totalCount)  );
				parentpanel.removeAll();
				parentpanel.add(dashboardpane);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		dashboardbtn.setBounds(10, 30, 205, 29);
		dashboardbtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		dashboardbtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		dashboardbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashboardbtn.setBackground(Color.CYAN);
		panel.add(dashboardbtn);
		
		
		
		
		
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(Color.RED);
		lblDashboard.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblDashboard.setBounds(449, 10, 146, 20);
		dashboardpane.add(lblDashboard);
		
		JLabel lblTotalCustomer = new JLabel("Total Customers");
		lblTotalCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCustomer.setForeground(Color.RED);
		lblTotalCustomer.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalCustomer.setBounds(86, 77, 202, 20);
		dashboardpane.add(lblTotalCustomer);
		
		epc.customer_count();
		
		totalcustxt = new JTextField( );
		totalcustxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalcustxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totalcustxt.setColumns(10);
		totalcustxt.setText(String.valueOf( employeePanelController.totalCount));
		totalcustxt.setBounds(96, 107, 191, 20);
		dashboardpane.add(totalcustxt);
		
		JLabel lblTotalParcels = new JLabel("Total Parcels");
		lblTotalParcels.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalParcels.setForeground(Color.RED);
		lblTotalParcels.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalParcels.setBounds(365, 77, 202, 20);
		dashboardpane.add(lblTotalParcels);
		
	
		
		JDesktopPane customerpane = new JDesktopPane();
		customerpane.setBackground(Color.CYAN);
		parentpanel.add(customerpane, "name_45865319812100");
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers.setForeground(Color.BLUE);
		lblCustomers.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers.setBounds(303, 10, 262, 20);
		customerpane.add(lblCustomers);
		
		
		
		JButton addcustbtn = new JButton("Customers");
		addcustbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(customerpane);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		addcustbtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addcustbtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		addcustbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addcustbtn.setBackground(Color.CYAN);
		addcustbtn.setBounds(10, 86, 205, 29);
		panel.add(addcustbtn);
		
	
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.BLUE);
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblId.setBounds(349, 52, 82, 20);
		customerpane.add(lblId);
		
		JLabel lblCustomers_1_1 = new JLabel("Fullname:");
		lblCustomers_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1.setForeground(Color.BLUE);
		lblCustomers_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1.setBounds(55, 82, 120, 20);
		customerpane.add(lblCustomers_1_1);
		
		JLabel lblCustomers_1_2 = new JLabel("Username:");
		lblCustomers_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_2.setForeground(Color.BLUE);
		lblCustomers_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_2.setBounds(444, 82, 140, 20);
		customerpane.add(lblCustomers_1_2);
		
		JLabel lblCustomers_1_3 = new JLabel("Password:");
		lblCustomers_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_3.setForeground(Color.BLUE);
		lblCustomers_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_3.setBounds(55, 145, 140, 20);
		customerpane.add(lblCustomers_1_3);
		
		JLabel lblCustomers_1_4 = new JLabel("CNIC:");
		lblCustomers_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_4.setForeground(Color.BLUE);
		lblCustomers_1_4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_4.setBounds(68, 218, 94, 20);
		customerpane.add(lblCustomers_1_4);
		
		JLabel lblCustomers_1_5 = new JLabel("Address:");
		lblCustomers_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_5.setForeground(Color.BLUE);
		lblCustomers_1_5.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_5.setBounds(448, 218, 120, 20);
		customerpane.add(lblCustomers_1_5);
		
		idtxt = new JTextField();
		idtxt.setEnabled(false);
		idtxt.setHorizontalAlignment(SwingConstants.CENTER);
		idtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		idtxt.setBounds(416, 54, 96, 20);
		customerpane.add(idtxt);
		idtxt.setColumns(10);
		
		fullnametxt = new JTextField();
		fullnametxt.setHorizontalAlignment(SwingConstants.CENTER);
		fullnametxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		fullnametxt.setColumns(10);
		fullnametxt.setBounds(185, 84, 191, 20);
		customerpane.add(fullnametxt);
		
		usernametxt = new JTextField();
		usernametxt.setHorizontalAlignment(SwingConstants.CENTER);
		usernametxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		usernametxt.setColumns(10);
		usernametxt.setBounds(594, 84, 190, 20);
		customerpane.add(usernametxt);
		
		cnictxt = new JTextField();
		cnictxt.setHorizontalAlignment(SwingConstants.CENTER);
		cnictxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		cnictxt.setColumns(10);
		cnictxt.setBounds(172, 218, 190, 20);
		customerpane.add(cnictxt);
		
		addresstxt = new JTextField();
		addresstxt.setHorizontalAlignment(SwingConstants.CENTER);
		addresstxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		addresstxt.setColumns(10);
		addresstxt.setBounds(579, 218, 229, 20);
		customerpane.add(addresstxt);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		passwordtxt.setBounds(186, 151, 190, 18);
		customerpane.add(passwordtxt);
		
		
		
		
		
		JButton updatebtn = new JButton("Update");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnfrominput =  fullnametxt.getText();
				unfrominput = usernametxt.getText();
				phonefrominput = phonenumbertxt.getText();
				pswfrominput = passwordtxt.getPassword();
				cnicfrominput = cnictxt.getText() ;
				addressfrominput = addresstxt.getText();
				id_fromuser = Integer.valueOf(idtxt.getText()) ;
				epc.customer_data_update();
				
				epc.customer_data_fetch();
				refreshEmployeeTable();
				
				
			}
		});
		updatebtn.setEnabled(false);
		updatebtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		updatebtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		updatebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updatebtn.setBackground(Color.RED);
		updatebtn.setBounds(495, 269, 94, 29);
		customerpane.add(updatebtn);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_fromuser = Integer.valueOf(idtxt.getText());
				epc.customre_data_delete();
				epc.customer_data_fetch();
				refreshEmployeeTable();
				
			}
		});
		deletebtn.setEnabled(false);
		deletebtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		deletebtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		deletebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deletebtn.setBackground(Color.RED);
		deletebtn.setBounds(690, 269, 94, 29);
		customerpane.add(deletebtn);
		
		JButton savebtn = new JButton("Save");
		savebtn.setEnabled(false);
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fnfrominput =  fullnametxt.getText();
				unfrominput = usernametxt.getText();
				phonefrominput = phonenumbertxt.getText();
				pswfrominput = passwordtxt.getPassword();
				cnicfrominput = cnictxt.getText() ;
				addressfrominput = addresstxt.getText();
				
				 
				employeePanel ep = new employeePanel(fnfrominput, unfrominput, pswfrominput, phonefrominput ,cnicfrominput, addressfrominput);
				epc.customer_data_insert();
				updatebtn.setEnabled(false);
				deletebtn.setEnabled(false);
				epc.customer_data_fetch();
				refreshEmployeeTable();
				
				
			}
		});
		savebtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		savebtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		savebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		savebtn.setBackground(Color.RED);
		savebtn.setBounds(282, 269, 94, 29);
		customerpane.add(savebtn);
		
		JButton newbtn = new JButton("New");
		newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernametxt.setEnabled(true);
				fullnametxt.setEnabled(true);
				phonenumbertxt.setEnabled(true);
				passwordtxt.setEnabled(true);
				cnictxt.setEnabled(true);
				addresstxt.setEnabled(true);
				updatebtn.setEnabled(false);
				deletebtn.setEnabled(false);
				savebtn.setEnabled(true);
				
				idtxt.setBackground(Color.YELLOW);
				usernametxt.setBackground(Color.YELLOW);
				fullnametxt.setBackground(Color.YELLOW);
				passwordtxt.setBackground(Color.YELLOW);
				cnictxt.setBackground(Color.YELLOW);
				addresstxt.setBackground(Color.YELLOW);
				phonenumbertxt.setBackground(Color.YELLOW);
				usernametxt.setText("");
				fullnametxt.setText("");
				passwordtxt.setText("");
				phonenumbertxt.setText("");
				cnictxt.setText("");
				addresstxt.setText("");
				fullnametxt.requestFocusInWindow();
			
				
			}
		});
		newbtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		newbtn.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		newbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newbtn.setBackground(Color.RED);
		newbtn.setBounds(80, 269, 94, 29);
		customerpane.add(newbtn);
		
		epc.customer_data_fetch();
		ids = employeePanelController.customer_ids ;
		 usernames = employeePanelController.customer_username ;
		 fullnames = employeePanelController.customer_fullname ;
		 phonenumbers = employeePanelController.customer_phonenumber ;
		  Cnic = employeePanelController.customer_cnic;
		  addresses = employeePanelController.customer_address;
		
		String[] column = {"id","Fullname","Username","CNIC", "phone","Address"};
		String[][] data = new String[fullnames.size()][6];
		for(int i = 0; i < fullnames.size() ; i++) {
			data[i][0] =  String.valueOf(ids.get(i)) ; 
			data[i][1] = (String) fullnames.get(i);
		    data[i][2] = (String) usernames.get(i);
		    data[i][3] = String.valueOf(Cnic.get(i));
		    data[i][4] = (String) phonenumbers.get(i);
		    data[i][5] = (String )addresses.get(i); 
		    
			}
		
		
		
		
		
		DefaultTableModel model = new DefaultTableModel(data, column) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		table = new JTable(model);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				fullnametxt.setEnabled(true);
				usernametxt.setEnabled(true);
				savebtn.setEnabled(false);
				updatebtn.setEnabled(true);
				deletebtn.setEnabled(true);
				
				 int row = table.getSelectedRow();

			        idtxt.setText(table.getValueAt(row, 0).toString());
			        fullnametxt.setText(table.getValueAt(row, 1).toString());
			        usernametxt.setText(table.getValueAt(row, 2).toString());
			        cnictxt.setText(table.getValueAt(row, 3).toString());
			        phonenumbertxt.setText(table.getValueAt(row, 4).toString());
			        addresstxt.setText(table.getValueAt(row, 5).toString());
			        
				
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setBounds(31, 343, 959, 273);
		customerpane.add(scrollPane);
		
		JLabel lblCustomers_1_1_1 = new JLabel("Phone Number:");
		lblCustomers_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_1.setForeground(Color.BLUE);
		lblCustomers_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_1.setBounds(466, 145, 178, 20);
		customerpane.add(lblCustomers_1_1_1);
		
		phonenumbertxt = new JTextField();
		phonenumbertxt.setHorizontalAlignment(SwingConstants.CENTER);
		phonenumbertxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		phonenumbertxt.setColumns(10);
		phonenumbertxt.setBounds(654, 147, 191, 20);
		customerpane.add(phonenumbertxt);
		
		JDesktopPane parcelpane = new JDesktopPane();
		parcelpane.setBackground(Color.CYAN);
		parentpanel.add(parcelpane, "name_432836876194300");
		
		JLabel lblNewLabel_1 = new JLabel("Parcels Panel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel_1.setBounds(444, 11, 131, 20);
		parcelpane.add(lblNewLabel_1);
		
		JLabel lblCustomers_1_1_2 = new JLabel("Tracking ID");
		lblCustomers_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2.setForeground(Color.BLUE);
		lblCustomers_1_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2.setBounds(63, 89, 131, 20);
		parcelpane.add(lblCustomers_1_1_2);
		
		trackingidtxt = new JTextField();
		trackingidtxt.setHorizontalAlignment(SwingConstants.CENTER);
		trackingidtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		trackingidtxt.setColumns(10);
		trackingidtxt.setBounds(271, 92, 191, 20);
		parcelpane.add(trackingidtxt);
		
		JLabel lblCustomers_1_1_2_1 = new JLabel("Sender:");
		lblCustomers_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_1.setForeground(Color.BLUE);
		lblCustomers_1_1_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_1.setBounds(558, 150, 131, 20);
		parcelpane.add(lblCustomers_1_1_2_1);
		
		JLabel lblCustomers_1_1_2_2 = new JLabel("Receiver:");
		lblCustomers_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2.setBounds(63, 150, 131, 20);
		parcelpane.add(lblCustomers_1_1_2_2);
		
		JLabel lblCustomers_1_1_2_2_1 = new JLabel("Pickup Address:");
		lblCustomers_1_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_1.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_1.setBounds(513, 89, 176, 20);
		parcelpane.add(lblCustomers_1_1_2_2_1);
		
		JLabel lblCustomers_1_1_2_2_2 = new JLabel("Parcel Type:");
		lblCustomers_1_1_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_2.setBounds(63, 379, 131, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2);
		
		JLabel lblCustomers_1_1_2_2_2_1 = new JLabel("Weight:");
		lblCustomers_1_1_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2_1.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_2_1.setBounds(558, 379, 131, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2_1);
		
		JLabel lblCustomers_1_1_2_2_2_2 = new JLabel("Price:");
		lblCustomers_1_1_2_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2_2.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_2_2.setBounds(63, 443, 131, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2_2);
		
		JLabel lblCustomers_1_1_2_2_2_3 = new JLabel("Booking Date:");
		lblCustomers_1_1_2_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2_3.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2_3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_2_3.setBounds(543, 443, 191, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2_3);
		
		JLabel lblCustomers_1_1_2_2_2_4 = new JLabel("Expected Delivery Date:");
		lblCustomers_1_1_2_2_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2_4.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2_4.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblCustomers_1_1_2_2_2_4.setBounds(22, 510, 239, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2_4);
		
		JLabel lblCustomers_1_1_2_2_2_4_1 = new JLabel("Current Status:");
		lblCustomers_1_1_2_2_2_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomers_1_1_2_2_2_4_1.setForeground(Color.BLUE);
		lblCustomers_1_1_2_2_2_4_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblCustomers_1_1_2_2_2_4_1.setBounds(558, 502, 176, 20);
		parcelpane.add(lblCustomers_1_1_2_2_2_4_1);
		
		
		
		
		
		pickupaddresstxt = new JTextField();
		pickupaddresstxt.setHorizontalAlignment(SwingConstants.CENTER);
		pickupaddresstxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		pickupaddresstxt.setColumns(10);
		pickupaddresstxt.setBounds(737, 91, 191, 20);
		parcelpane.add(pickupaddresstxt);
		
		weighttxt = new JTextField();
		weighttxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pricecounter();
			}
		});
		weighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		weighttxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		weighttxt.setColumns(10);
		weighttxt.setBounds(761, 381, 191, 20);
		parcelpane.add(weighttxt);
		
		pricetxt = new JTextField();
		pricetxt.setHorizontalAlignment(SwingConstants.CENTER);
		pricetxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		pricetxt.setColumns(10);
		pricetxt.setBounds(271, 444, 191, 20);
		parcelpane.add(pricetxt);
		
		
		sendertxt = new JTextField();
		sendertxt.addKeyListener(new KeyAdapter() {
			private TableRowSorter<TableModel> sorters;
			@Override
			public void keyReleased(KeyEvent e) {
				TableModel obj1 = Sendertable.getModel();
				
				if(sorters == null) {
					sorters = new TableRowSorter<TableModel>(obj1);
					Sendertable.setRowSorter(sorters);
				
				}
				String textgettingfromsender = sendertxt.getText().trim();
					if(textgettingfromsender.isEmpty()) {
						sorters.setRowFilter(null);
					}else {
						sorters.setRowFilter(RowFilter.regexFilter("(?i)"+textgettingfromsender));
					}
					
				
			}
		});
		sendertxt.setHorizontalAlignment(SwingConstants.CENTER);
		sendertxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		sendertxt.setColumns(10);
		sendertxt.setBounds(694, 152, 258, 20);
		parcelpane.add(sendertxt);
		
		
		receivertxt = new JTextField();
		receivertxt.addKeyListener(new KeyAdapter() {
			private TableRowSorter<TableModel> sorter;
			@Override
		
			public void keyReleased(KeyEvent e) {
			TableModel obj = Receivertable.getModel();
			
			if(sorter == null) {
				sorter = new TableRowSorter<TableModel>(obj);
				Receivertable.setRowSorter(sorter);
			
			}
			String textgetting = receivertxt.getText().trim();
				if(textgetting.isEmpty()) {
					sorter.setRowFilter(null);
				}else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)"+textgetting));
				}
				
			}
			
		});
		receivertxt.setHorizontalAlignment(SwingConstants.CENTER);
		receivertxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		receivertxt.setColumns(10);
		receivertxt.setBounds(204, 157, 258, 20);
		parcelpane.add(receivertxt);
		
		epc.customer_fullname();
		ArrayList <String> receivers_fullnames = new ArrayList <String>();
		 receivers_fullnames = employeePanelController.customer_fullname ;
		 
		String[] columnn = {"Fullname"};
//		String[][] dataa = {{"Aliyan"},{"Amjad"}};
//		String receivercolumn = "Fullname";
//		String[][] receiverdata = "Aliyan";
		
		
		String[][] dataa = new String[receivers_fullnames.size()][1];
		for(int i = 0; i < receivers_fullnames.size() ; i++) {
			
			dataa[i][0] = (String) receivers_fullnames.get(i);
		
		    
			}
		DefaultTableModel modell = new DefaultTableModel(dataa, columnn) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		Receivertable = new JTable(modell);
		Receivertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int receiver_roww = Receivertable.getSelectedRow();

				 receivertxt.setText(Receivertable.getValueAt( receiver_roww, 0).toString());
			       
			       
			}
		});
		Receivertable.setBounds(204, 187, 258, 175);
		parcelpane.add(Receivertable);
		
		Sendertable = new JTable(modell);
		Sendertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int receiver_roww = Sendertable.getSelectedRow();

				 sendertxt.setText(Sendertable.getValueAt( receiver_roww, 0).toString());
			       
			       
			}
		});
		Sendertable.setBounds(694, 187, 258, 175);
		parcelpane.add(Sendertable);
		String parceltypes[] = {  "Document","Electronics","Clothing","Fragile", "Food","Medicine","Books","Gift","Household","Cosmetics","Accessories","Industrial","Other"};
		
		JComboBox parceltypecombo = new JComboBox(parceltypes);
		parceltypecombo.setBounds(229, 384, 221, 20);
		parcelpane.add(parceltypecombo);
		
		String status[] = {"Pending","Picked Up","In Transit","At Destination Hub","Out for Delivery","Delivered","Delivery Failed"};
		JComboBox crntstatuscombo = new JComboBox(status);
		crntstatuscombo.setBounds(761, 502, 221, 20);
		parcelpane.add(crntstatuscombo);
		
	
		
		JDateChooser bookingdatechooser = new JDateChooser();
		bookingdatechooser.setDateFormatString("yyyy-MM-dd");
		bookingdatechooser.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		bookingdatechooser.setBounds(757, 445, 195, 18);
		parcelpane.add(bookingdatechooser);
		
		JDateChooser Expectdatechooser = new JDateChooser();
		Expectdatechooser.setDateFormatString("yyyy-MM-dd");
		Expectdatechooser.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		Expectdatechooser.setBounds(267, 512, 195, 18);
		parcelpane.add(Expectdatechooser);
		
		JButton Parcel = new JButton("Parcel Details");
		Parcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(parcelpane);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		Parcel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Parcel.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		Parcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Parcel.setBackground(Color.CYAN);
		Parcel.setBounds(10, 140, 205, 29);
		panel.add(Parcel);
		
		
		
		
		JButton parcelsave_btn = new JButton("Save");
		parcelsave_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				pickadd_input = pickupaddresstxt.getText();
			receiver_from_input = receivertxt.getText();
			sender_from_input = sendertxt.getText();
			weight_from_input = Integer.valueOf(weighttxt.getText());
			 price_from_input = Integer.valueOf(pricetxt.getText());
			 bookingDate_from_input = bookingdatechooser.getDate();
			 expectedDeliveryDate_from_input = Expectdatechooser.getDate();
			 parcelType_from_input = (String) parceltypecombo.getSelectedItem();
			 currentStatus_from_input = (String) crntstatuscombo.getSelectedItem();
			 parcel_detail pd = new parcel_detail(pickadd_input, receiver_from_input, sender_from_input, parcelType_from_input, weight_from_input, price_from_input, bookingDate_from_input, expectedDeliveryDate_from_input, currentStatus_from_input);
			pdc.parcel_detail_insert();
			pdc.parcel_detail_fetch();
			
			
			trackingidtxt.setText("");
			sendertxt.setText("");
			receivertxt.setText("");
			pickupaddresstxt.setText("");
			weighttxt.setText("");
			pricetxt.setText("");
			bookingdatechooser.setDate(null);
			Expectdatechooser.setDate(null);
			crntstatuscombo.setSelectedIndex(-1);
			parceltypecombo.setSelectedIndex(-1);
			parcel_table_refresh();
			 
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
			}}
		});
		parcelsave_btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		parcelsave_btn.setBounds(169, 571, 84, 20);
		parcelpane.add(parcelsave_btn);
		
		pdc.parcel_detail_fetch();
		
		
		 ArrayList  tracking_ids = new ArrayList(pdc.tracking_ids);
		 ArrayList Receivers = new  ArrayList (pdc.Receivers);
		 ArrayList  Sender = new ArrayList (pdc.Sender);
		 ArrayList  Weights = new  ArrayList (pdc.Weights);
		 ArrayList prices = new ArrayList(pdc.prices);
		 ArrayList  booking_dates= new ArrayList(pdc.booking_dates);
		 ArrayList  expected_date= new ArrayList(pdc.expected_date);
		 ArrayList  parcel_types = new ArrayList(pdc.parcel_types);
		 ArrayList  pickup_address= new ArrayList(pdc.pickup_address);
		 ArrayList  current_status= new ArrayList (pdc.current_status);
		
		System.out.println("geooo kaka"+ tracking_ids);
		System.out.println(Receivers);
		System.out.println(Sender);
		System.out.println(Weights);
		System.out.println(prices);
		System.out.println(booking_dates);
		System.out.println(expected_date);
		System.out.println(pickup_address);
		System.out.println(current_status);
		
		String[] column_for_parcel= {"Tracking Id","Receiver", "Sender", "Weight", "Price", "Booking Date", "Edxpected Date", "Parcel Typre", "Pickup Address", "Current Status" };
		String[][] data_for_parcel = new String[tracking_ids.size()][10];
		for(int i = 0; i < tracking_ids.size() ; i++) {
			data_for_parcel[i][0] =  String.valueOf(tracking_ids.get(i)) ; 
			data_for_parcel[i][1] = (String) Receivers.get(i);
			data_for_parcel[i][2] = (String) Sender.get(i);
			data_for_parcel[i][3] = String.valueOf(Weights.get(i));
			data_for_parcel[i][4] = String.valueOf(prices.get(i));
			data_for_parcel[i][5] = (String) booking_dates.get(i).toString();
			data_for_parcel[i][6] = (String ) expected_date.get(i).toString();
			data_for_parcel[i][7] = (String ) parcel_types.get(i);
			data_for_parcel[i][8] = (String ) pickup_address.get(i);
			data_for_parcel[i][9] = (String ) current_status.get(i);
		    
		    
			}
		
		DefaultTableModel model_for_table = new DefaultTableModel(data_for_parcel, column_for_parcel) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		    
		};
		
		
		
		parceltable = new JTable(model_for_table);
		parceltable.setGridColor(Color.RED);
		parceltable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		parceltable.setBounds(22, 600, 977, 239);
		parcelpane.add(parceltable);

		
		JScrollPane scrollPane_2 = new JScrollPane(parceltable);
		scrollPane_2.setBounds(22, 602, 980, 235);
		parcelpane.add(scrollPane_2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		parceltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				fullnametxt.setEnabled(true);
//				usernametxt.setEnabled(true);
//				savebtn.setEnabled(false);
//				updatebtn.setEnabled(true);
//				deletebtn.setEnabled(true);
				 
				 int row = parceltable.getSelectedRow();

			        trackingidtxt.setText(parceltable.getValueAt(row, 0).toString());
			        receivertxt.setText(parceltable.getValueAt(row, 1).toString());
			        sendertxt.setText(parceltable.getValueAt(row, 2).toString());
			        weighttxt.setText(parceltable.getValueAt(row, 3).toString());
			        pricetxt.setText(parceltable.getValueAt(row, 4).toString());
			      	 parceltypecombo.setSelectedItem(parceltable.getValueAt(row, 7).toString());
			        try {
			     
			            bookingdatechooser.setDate(sdf.parse(parceltable.getValueAt(row, 5).toString()));
			            Expectdatechooser.setDate(sdf.parse(parceltable.getValueAt(row, 6).toString()));
			        } catch (ParseException ex) {
			            ex.printStackTrace();
			        }
			       

			        pickupaddresstxt.setText(parceltable.getValueAt(row, 8).toString());
			        crntstatuscombo.setSelectedItem(parceltable.getValueAt(row, 9).toString());
			       
			        
				
			}
		});
		
		
		JButton parcel_updatebtn = new JButton("Update");
		parcel_updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tracking_id_from_input = Integer.valueOf(trackingidtxt.getText());
				receiver_from_input = receivertxt.getText();
				sender_from_input = sendertxt.getText();
				weight_from_input = Integer.valueOf(weighttxt.getText());
				price_from_input = Integer.valueOf(pricetxt.getText());
				currentStatus_from_input = (String) crntstatuscombo.getSelectedItem();
				parcelType_from_input = (String) parceltypecombo.getSelectedItem();
				bookingDate_from_input = bookingdatechooser.getDate();
				expectedDeliveryDate_from_input = Expectdatechooser.getDate();
				pickadd_input = pickupaddresstxt.getText();
				
				pdc.parcel_detail_update();
			
				pdc.parcel_detail_fetch();
				parcel_table_refresh();
			}
		});
		
		parcel_updatebtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		parcel_updatebtn.setBounds(697, 570, 98, 20);
		parcelpane.add(parcel_updatebtn);
		
		
		pdc.total_parcel_fetch();
		totalparceltxt = new JTextField();
		
		totalparceltxt.setText(String.valueOf(pdc.total_parcel) );
		totalparceltxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalparceltxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totalparceltxt.setColumns(10);
		totalparceltxt.setBounds(375, 107, 191, 20);
		dashboardpane.add(totalparceltxt);
		
		pdc.total_pending_fetch();
		totalpendingparcelstxt = new JTextField();
		totalpendingparcelstxt.setText(String.valueOf(pdc.total_in_pending_parcels) );
		totalpendingparcelstxt.setHorizontalAlignment(SwingConstants.CENTER);
		totalpendingparcelstxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totalpendingparcelstxt.setColumns(10);
		totalpendingparcelstxt.setBounds(663, 107, 191, 20);
		dashboardpane.add(totalpendingparcelstxt);
		
		JLabel lblTotalPendingParcels = new JLabel("Total Pending Parcels");
		lblTotalPendingParcels.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPendingParcels.setForeground(Color.RED);
		lblTotalPendingParcels.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalPendingParcels.setBounds(653, 77, 202, 20);
		dashboardpane.add(lblTotalPendingParcels);
		
		totaltransitparcels = new JTextField();
		pdc.total_in_transist();
		totaltransitparcels.setText(String.valueOf(pdc.total_in_transists_parcels));
		totaltransitparcels.setHorizontalAlignment(SwingConstants.CENTER);
		totaltransitparcels.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totaltransitparcels.setColumns(10);
		totaltransitparcels.setBounds(96, 311, 191, 20);
		dashboardpane.add(totaltransitparcels);
		
		JLabel lblTotalInTrasit = new JLabel("Total In Trasit Parcels");
		lblTotalInTrasit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalInTrasit.setForeground(Color.RED);
		lblTotalInTrasit.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalInTrasit.setBounds(86, 281, 202, 20);
		dashboardpane.add(lblTotalInTrasit);
		
		pdc.total_in_delivered();
		totaldeliveredparcels = new JTextField();
		
		totaldeliveredparcels.setText(String.valueOf(pdc.total_delivered_parcels));
		totaldeliveredparcels.setHorizontalAlignment(SwingConstants.CENTER);
		totaldeliveredparcels.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totaldeliveredparcels.setColumns(10);
		totaldeliveredparcels.setBounds(385, 311, 191, 20);
		dashboardpane.add(totaldeliveredparcels);
		
		JLabel lblTotalDeliveredParcels = new JLabel("Total Delivered Parcels");
		lblTotalDeliveredParcels.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDeliveredParcels.setForeground(Color.RED);
		lblTotalDeliveredParcels.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalDeliveredParcels.setBounds(375, 281, 202, 20);
		dashboardpane.add(lblTotalDeliveredParcels);
		
		totaldeliveryfailedtxt = new JTextField();
		pdc.total_in_delivery_failed();
		totaldeliveryfailedtxt.setText(String.valueOf(pdc.total_delivery_failed_parcels));
		totaldeliveryfailedtxt.setHorizontalAlignment(SwingConstants.CENTER);
		totaldeliveryfailedtxt.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		totaldeliveryfailedtxt.setColumns(10);
		totaldeliveryfailedtxt.setBounds(673, 311, 191, 20);
		dashboardpane.add(totaldeliveryfailedtxt);
		
		JLabel lblTotalDeliveryFailed = new JLabel("Total Delivery Failed Parcels");
		lblTotalDeliveryFailed.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDeliveryFailed.setForeground(Color.RED);
		lblTotalDeliveryFailed.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblTotalDeliveryFailed.setBounds(663, 281, 202, 20);
		dashboardpane.add(lblTotalDeliveryFailed);
		
		JDesktopPane reportspane = new JDesktopPane();
		reportspane.setBackground(Color.CYAN);
		parentpanel.add(reportspane, "name_190370028768900");
		
		JLabel lblReportsPanel = new JLabel("Reports Panel");
		lblReportsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportsPanel.setForeground(Color.RED);
		lblReportsPanel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblReportsPanel.setBounds(430, 8, 96, 20);
		reportspane.add(lblReportsPanel);
		
		JButton btnPrintSummaryReport = new JButton("Print Summary Report");
		btnPrintSummaryReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportServices.summaryreport();
			}
		});
		btnPrintSummaryReport.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPrintSummaryReport.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		btnPrintSummaryReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrintSummaryReport.setBackground(Color.RED);
		btnPrintSummaryReport.setBounds(119, 91, 205, 29);
		reportspane.add(btnPrintSummaryReport);
		
		
		JButton Reports = new JButton("Parcel Reports");
		Reports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentpanel.removeAll();
				parentpanel.add(reportspane);
				parentpanel.repaint();
				parentpanel.revalidate();
			}
		});
		Reports.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Reports.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		Reports.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Reports.setBackground(Color.CYAN);
		Reports.setBounds(10, 195, 205, 29);
		panel.add(Reports);

	}
	void pricecounter() {
		try {
			String weightt = weighttxt.getText();
			if(weightt.isEmpty()){
				pricetxt.setText("");
			}
			int price_per_kg  = 180;
			int get_weight = Integer.valueOf(weighttxt.getText()) ;
			this.price = get_weight * price_per_kg;
			System.out.println(this.price);
			pricetxt.setText(String.valueOf(this.price));
				
		}
		catch (Exception e) {
			e.getMessage();
		}
			
		
		
		
	}
}
