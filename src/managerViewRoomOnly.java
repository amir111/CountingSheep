import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.util.Iterator;

public class managerViewRoomOnly extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
        private JScrollPane sp;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerViewRoomOnly frame = new managerViewRoomOnly(currentUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}public void close() {
		this.setVisible(false);
		this.dispose();
}

	/**
	 * Create the frame.
	 */
	public managerViewRoomOnly(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Room\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(186, 13, 427, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnCloseApplication = new JButton("Main Menu");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerModViewRooms mrm = new managerModViewRooms(currentUser);
				mrm.setVisible(true);
				close();

			}
		});
                
                btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(282, 360, 245, 55);
		contentPane.add(btnCloseApplication);
                
                
                JTextArea rooms = new JTextArea();
                rooms.setLineWrap(true);
                rooms.setEditable(false);
                rooms.setVisible(true);
                
                sp = new JScrollPane(rooms);
                
                sp.setBounds(186, 125, 450, 200);
                sp.setFont(new Font("Arial Black",Font.PLAIN, 20));
                
                
                
                rooms.setBounds(186, 125, 450, 200);
                //contentPane.add(rooms);
                contentPane.add(sp);
                rooms.setFont(new Font("Arial Black",Font.PLAIN, 20));
     
                Iterator iterator = DB.selectHotelByManager(user.uuid).getRoom().iterator();
                //Hotel hotel = DB.selectHotelByManager(user.uuid);
               // rooms.append(DB.selectHotelByManager(user.uuid).address);
                while(iterator.hasNext()){
                    Room room = (Room) iterator.next();
                    rooms.append("Room Number: " + room.roomName + "\n");
                    rooms.append("Room Price: " + String.valueOf(room.roomPrice) + "\n");
                    rooms.append("Description: " + room.roomDescription + "\n");
                    if(room.booked){
                        rooms.append("Booking: Unavailable" + "\n");
                        Iterator bkngs = room.bookings.iterator();
                        while(bkngs.hasNext()){
                            RequestBooking currentBook = (RequestBooking) bkngs.next();
                        rooms.append("Start Date: " + 
                                currentBook.start_date
                                + "\n"
                                + "End Date: "+
                                currentBook.end_date +
                                "\n");
                        
                        }
                        rooms.append("\n");
                    }
                    else{
                        rooms.append("Booking: Available" + "\n");
                        rooms.append("\n");
                    }
                    
                    
                    //rooms.append("g");
                    
                }

		
		/*JLabel lblRoomId = new JLabel("Room #");
		lblRoomId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomId.setBounds(66, 174, 127, 34);
		contentPane.add(lblRoomId);
		
		JLabel lblCost = new JLabel("Cost\r\n");
		lblCost.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCost.setBounds(66, 221, 127, 34);
		contentPane.add(lblCost);
		
		JLabel lblRatings = new JLabel("Ratings");
		lblRatings.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRatings.setBounds(66, 274, 127, 34);
		contentPane.add(lblRatings);
		
		JLabel lblFetures = new JLabel("Booked - Y/N");
		lblFetures.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFetures.setBounds(47, 325, 146, 34);
		contentPane.add(lblFetures);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCity.setBounds(66, 372, 127, 34);
		contentPane.add(lblCity);
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 157, 163, 293);
		panel.setBackground(SystemColor.red);

		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(219, 179, 146, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 230, 146, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 283, 146, 31);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 334, 146, 31);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 381, 146, 31);
		contentPane.add(textField_4);
		
		JLabel label = new JLabel("Room #");
		label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label.setBounds(522, 174, 127, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Cost\r\n");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_1.setBounds(522, 221, 127, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Ratings");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_2.setBounds(522, 274, 127, 34);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Booked - Y/N");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_3.setBounds(503, 325, 146, 34);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("City");
		label_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_4.setBounds(522, 372, 127, 34);
		contentPane.add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(500, 157, 163, 293);
		contentPane.add(panel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(675, 381, 146, 31);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(675, 334, 146, 31);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(675, 283, 146, 31);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(675, 230, 146, 31);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(675, 179, 146, 31);
		contentPane.add(textField_9);
		
		JLabel label_5 = new JLabel("Room #");
		label_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_5.setBounds(997, 174, 127, 34);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Cost\r\n");
		label_6.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_6.setBounds(997, 221, 127, 34);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Ratings");
		label_7.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_7.setBounds(997, 274, 127, 34);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Booked - Y/N");
		label_8.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_8.setBounds(978, 325, 146, 34);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("City");
		label_9.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_9.setBounds(997, 372, 127, 34);
		contentPane.add(label_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(975, 157, 163, 293);
		contentPane.add(panel_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(1150, 381, 146, 31);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(1150, 334, 146, 31);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(1150, 283, 146, 31);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(1150, 230, 146, 31);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(1150, 179, 146, 31);
		contentPane.add(textField_14);
		
		JLabel label_10 = new JLabel("Room #");
		label_10.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_10.setBounds(69, 547, 127, 34);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Cost\r\n");
		label_11.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_11.setBounds(69, 594, 127, 34);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Ratings");
		label_12.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_12.setBounds(69, 647, 127, 34);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Booked - Y/N");
		label_13.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_13.setBounds(50, 698, 146, 34);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("City");
		label_14.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_14.setBounds(69, 745, 127, 34);
		contentPane.add(label_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		panel_3.setBounds(47, 530, 163, 293);
		contentPane.add(panel_3);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(222, 754, 146, 31);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(222, 707, 146, 31);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(222, 656, 146, 31);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(222, 603, 146, 31);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(222, 552, 146, 31);
		contentPane.add(textField_19);
		
		JLabel label_15 = new JLabel("Room #");
		label_15.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_15.setBounds(525, 547, 127, 34);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("Cost\r\n");
		label_16.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_16.setBounds(525, 594, 127, 34);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("Ratings");
		label_17.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_17.setBounds(525, 647, 127, 34);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("Booked - Y/N");
		label_18.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_18.setBounds(506, 698, 146, 34);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("City");
		label_19.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_19.setBounds(525, 745, 127, 34);
		contentPane.add(label_19);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(503, 530, 163, 293);
		contentPane.add(panel_4);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(678, 754, 146, 31);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(678, 707, 146, 31);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(678, 656, 146, 31);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(678, 603, 146, 31);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(678, 552, 146, 31);
		contentPane.add(textField_24);
		
		JLabel label_20 = new JLabel("Room #");
		label_20.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_20.setBounds(1000, 547, 127, 34);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("Cost\r\n");
		label_21.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_21.setBounds(1000, 594, 127, 34);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("Ratings");
		label_22.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_22.setBounds(1000, 647, 127, 34);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("Booked - Y/N");
		label_23.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_23.setBounds(981, 698, 146, 34);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel("City");
		label_24.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_24.setBounds(1000, 745, 127, 34);
		contentPane.add(label_24);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.RED);
		panel_5.setBounds(978, 530, 163, 293);
		contentPane.add(panel_5);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(1153, 754, 146, 31);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(1153, 707, 146, 31);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(1153, 656, 146, 31);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(1153, 603, 146, 31);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(1153, 552, 146, 31);
		contentPane.add(textField_29);*/
		
	
	}

}
