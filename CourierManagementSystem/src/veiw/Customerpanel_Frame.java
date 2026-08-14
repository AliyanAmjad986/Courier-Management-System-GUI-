package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomertrackingpanelController;

import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.awt.event.ActionEvent;

public class Customerpanel_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField trackingidtxt;
	private JTextField receivertxt;
	private JTextField sendertxt;
	private JTextField parceltypetxt;
	private JTextField weighttxt;
	private JTextField pricetxt;
	private JTextField status_txt;
	private JTextField booking_datetxt;
	private JTextField expected_datatxt;
	public static int tracking_id_from_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerpanel_Frame frame = new Customerpanel_Frame();
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
	public Customerpanel_Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customerpanel_Frame.class.getResource("/images/images.jpg")));
		setTitle("CourierMangementSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.PINK);
		desktopPane.setBounds(0, 0, 206, 670);
		contentPane.add(desktopPane);
		
		JLabel lblCustomersPanel = new JLabel("Customers Panel");
		lblCustomersPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomersPanel.setForeground(Color.RED);
		lblCustomersPanel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblCustomersPanel.setBounds(41, 11, 130, 20);
		desktopPane.add(lblCustomersPanel);
		
		JButton Parcel = new JButton("Parcel Details");
		Parcel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Parcel.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		Parcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Parcel.setBackground(Color.CYAN);
		Parcel.setBounds(0, 52, 205, 29);
		desktopPane.add(Parcel);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.YELLOW);
		desktopPane_1.setBounds(208, 0, 944, 670);
		contentPane.add(desktopPane_1);
		
		JLabel lblCustomersPanel_1 = new JLabel("Track Your Parcel");
		lblCustomersPanel_1.setBackground(Color.BLACK);
		lblCustomersPanel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomersPanel_1.setForeground(Color.RED);
		lblCustomersPanel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblCustomersPanel_1.setBounds(379, 11, 197, 34);
		desktopPane_1.add(lblCustomersPanel_1);
		
		JLabel lblTrackingId = new JLabel("Tracking ID:");
		lblTrackingId.setBackground(Color.WHITE);
		lblTrackingId.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId.setForeground(Color.BLACK);
		lblTrackingId.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId.setBounds(301, 169, 130, 20);
		desktopPane_1.add(lblTrackingId);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 944, 50);
		desktopPane_1.add(panel);
		
		trackingidtxt = new JTextField();
		trackingidtxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		trackingidtxt.setBounds(467, 163, 185, 34);
		desktopPane_1.add(trackingidtxt);
		trackingidtxt.setColumns(10);
		
		JLabel lblReceiverName = new JLabel("Receiver Name:");
		lblReceiverName.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceiverName.setForeground(Color.BLACK);
		lblReceiverName.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblReceiverName.setBackground(Color.WHITE);
		lblReceiverName.setBounds(100, 242, 130, 20);
		desktopPane_1.add(lblReceiverName);
		
		receivertxt = new JTextField();
		receivertxt.setHorizontalAlignment(SwingConstants.CENTER);
		receivertxt.setEditable(false);
		receivertxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		receivertxt.setColumns(10);
		receivertxt.setBounds(240, 236, 185, 34);
		desktopPane_1.add(receivertxt);
		
		sendertxt = new JTextField();
		sendertxt.setHorizontalAlignment(SwingConstants.CENTER);
		sendertxt.setEditable(false);
		sendertxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		sendertxt.setColumns(10);
		sendertxt.setBounds(612, 236, 185, 34);
		desktopPane_1.add(sendertxt);
		
		JLabel lblTrackingId_1_1 = new JLabel("Sender Name:");
		lblTrackingId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1_1.setForeground(Color.BLACK);
		lblTrackingId_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1_1.setBackground(Color.WHITE);
		lblTrackingId_1_1.setBounds(472, 242, 130, 20);
		desktopPane_1.add(lblTrackingId_1_1);
		
		parceltypetxt = new JTextField();
		parceltypetxt.setHorizontalAlignment(SwingConstants.CENTER);
		parceltypetxt.setEditable(false);
		parceltypetxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		parceltypetxt.setColumns(10);
		parceltypetxt.setBounds(240, 297, 185, 34);
		desktopPane_1.add(parceltypetxt);
		
		JLabel lblTrackingId_1 = new JLabel("Parcel Type:");
		lblTrackingId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1.setForeground(Color.BLACK);
		lblTrackingId_1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1.setBackground(Color.WHITE);
		lblTrackingId_1.setBounds(100, 303, 130, 20);
		desktopPane_1.add(lblTrackingId_1);
		
		weighttxt = new JTextField();
		weighttxt.setHorizontalAlignment(SwingConstants.CENTER);
		weighttxt.setEditable(false);
		weighttxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		weighttxt.setColumns(10);
		weighttxt.setBounds(612, 297, 185, 34);
		desktopPane_1.add(weighttxt);
		
		JLabel lblTrackingId_1_2 = new JLabel("Weight:");
		lblTrackingId_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1_2.setForeground(Color.BLACK);
		lblTrackingId_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1_2.setBackground(Color.WHITE);
		lblTrackingId_1_2.setBounds(472, 303, 130, 20);
		desktopPane_1.add(lblTrackingId_1_2);
		
		pricetxt = new JTextField();
		pricetxt.setHorizontalAlignment(SwingConstants.CENTER);
		pricetxt.setEditable(false);
		pricetxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		pricetxt.setColumns(10);
		pricetxt.setBounds(240, 365, 185, 34);
		desktopPane_1.add(pricetxt);
		
		JLabel lblTrackingId_1_3 = new JLabel("Price:");
		lblTrackingId_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1_3.setForeground(Color.BLACK);
		lblTrackingId_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1_3.setBackground(Color.WHITE);
		lblTrackingId_1_3.setBounds(100, 371, 130, 20);
		desktopPane_1.add(lblTrackingId_1_3);
		
		status_txt = new JTextField();
		status_txt.setHorizontalAlignment(SwingConstants.CENTER);
		status_txt.setEditable(false);
		status_txt.setFont(new Font("Tahoma", Font.BOLD, 16));
		status_txt.setColumns(10);
		status_txt.setBounds(612, 365, 185, 34);
		desktopPane_1.add(status_txt);
		
		JLabel lblTrackingId_1_4 = new JLabel("Current Status:");
		lblTrackingId_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1_4.setForeground(Color.BLACK);
		lblTrackingId_1_4.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1_4.setBackground(Color.WHITE);
		lblTrackingId_1_4.setBounds(472, 371, 130, 20);
		desktopPane_1.add(lblTrackingId_1_4);
		
		JLabel trackimage6 = new JLabel("New label");
		trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/Pickup (3).png")));
		trackimage6.setBounds(165, 546, 727, 83);
		desktopPane_1.add(trackimage6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/4 (3).png")));
		lblNewLabel.setBounds(10, 491, 160, 154);
		desktopPane_1.add(lblNewLabel);
		
		JLabel booking_datelbl = new JLabel("Booking Date:");
		booking_datelbl.setHorizontalAlignment(SwingConstants.CENTER);
		booking_datelbl.setForeground(Color.BLACK);
		booking_datelbl.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		booking_datelbl.setBackground(Color.WHITE);
		booking_datelbl.setBounds(100, 452, 130, 20);
		desktopPane_1.add(booking_datelbl);
		
		booking_datetxt = new JTextField();
		booking_datetxt.setHorizontalAlignment(SwingConstants.CENTER);
		booking_datetxt.setEditable(false);
		booking_datetxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		booking_datetxt.setColumns(10);
		booking_datetxt.setBounds(240, 446, 185, 34);
		desktopPane_1.add(booking_datetxt);
		
		JLabel lblTrackingId_1_1_2 = new JLabel("Expected  Date:");
		lblTrackingId_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackingId_1_1_2.setForeground(Color.BLACK);
		lblTrackingId_1_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblTrackingId_1_1_2.setBackground(Color.WHITE);
		lblTrackingId_1_1_2.setBounds(442, 452, 160, 20);
		desktopPane_1.add(lblTrackingId_1_1_2);
		CustomertrackingpanelController cptc = new CustomertrackingpanelController();
		
		expected_datatxt = new JTextField();
		expected_datatxt.setHorizontalAlignment(SwingConstants.CENTER);
		expected_datatxt.setEditable(false);
		expected_datatxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		expected_datatxt.setColumns(10);
		expected_datatxt.setBounds(612, 446, 185, 34);
		desktopPane_1.add(expected_datatxt);
		
	
		
		
		JButton searchbtn = new JButton("Search");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tracking_id_from_input = Integer.valueOf(trackingidtxt.getText()) ;
				
				cptc.cust_parcel_fetch();
				 
			 receivertxt.setText(cptc.Receivers);
				 sendertxt.setText(cptc.Sender);
				 parceltypetxt.setText(cptc.parcel_types);
				 weighttxt.setText(String.valueOf(cptc.Weights) );
				 pricetxt.setText(String.valueOf(cptc.prices) );
				 status_txt.setText(cptc.current_status);
				 
				 booking_datetxt.setText(String.valueOf(cptc.booking_dates));
			 expected_datatxt.setText(String.valueOf(cptc.expected_date));
			  String status_img = cptc.current_status;
			 if( status_img.equals("Pending")) {
				System.out.println("Good hu gaya");
				trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/Pending.png")));
				
			 }else if (status_img.equals("Picked Up") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/pickupmain.png")));
			 }
			 else if (status_img.equals("In Transit") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/InTransit.png")));
			 }
			 else if (status_img.equals("At Destination Hub") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/AtDesitnation.png")));
			 }
			 else if (status_img.equals("Out for Delivery") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/outofdelivery.png")));
			 }
			 else if (status_img.equals("Delivered") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/Pickup (3).png")));;
			 }
			 else if (status_img.equals("Delivery Failed") ) {
				 trackimage6.setIcon(new ImageIcon(Customerpanel_Frame.class.getResource("/images/deliveryfailed.png")));;
			 }
				
			}
		});
		searchbtn.setBounds(674, 169, 89, 23);
		desktopPane_1.add(searchbtn);

	}
}
