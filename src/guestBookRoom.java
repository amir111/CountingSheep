import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;

public class guestBookRoom extends JFrame {

	private JPanel contentPane;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guestBookRoom frame = new guestBookRoom(currentUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close() {
		this.setVisible(false);
		this.dispose();
}

	/**
	 * Create the frame.
	 */
	public guestBookRoom(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1071, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookARoom = new JLabel("Book A Room");
		lblBookARoom.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 75));
		contentPane.setBackground(SystemColor.activeCaption);

		lblBookARoom.setBounds(322, 0, 627, 102);
		contentPane.add(lblBookARoom);
		
		JButton btnGuestPortfolio = new JButton("Back To Search ");
		btnGuestPortfolio.setForeground(Color.RED);
		btnGuestPortfolio.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnGuestPortfolio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestSearchRoom sroom = new guestSearchRoom(currentUser);
				sroom.setVisible(true);
				close();
				
			}
		});
		btnGuestPortfolio.setBounds(22, 19, 260, 25);
		contentPane.add(btnGuestPortfolio);
		
		
		
		JLabel label_20 = new JLabel("Price ");
		label_20.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_20.setBounds(22, 276, 159, 25);
		contentPane.add(label_20);
		
		JLabel label_23 = new JLabel("Address");
		label_23.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_23.setBounds(19, 238, 166, 37);
		contentPane.add(label_23);
		//ADDED
		JLabel label_26 = new JLabel("Rating ");
		label_26.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_26.setBounds(22, 360, 146, 37);
		contentPane.add(label_26);
		
                
                JLabel label_36 = new JLabel("Room #  ");
		label_36.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_36.setBounds(22, 400, 146, 37);
		contentPane.add(label_36);
                
                
                
		JLabel label_29 = new JLabel("Features");
		label_29.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_29.setBounds(22, 314, 146, 25);
		contentPane.add(label_29);
		
		JButton button_5 = new JButton("Book");
		button_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button_5.setBounds(74, 445, 97, 25);
		contentPane.add(button_5);
		
		JLabel lblHotelId = new JLabel("Hotel Name");
		lblHotelId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblHotelId.setBounds(22, 205, 159, 37);
		contentPane.add(lblHotelId);
		
		JPanel panel = new JPanel();
		panel.setBounds(163, 206, 97, 25);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(163, 243, 97, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(163, 276, 97, 25);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(163, 314, 97, 25);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(163, 364, 97, 25);
		contentPane.add(panel_4);
		
		
		
		JLabel label = new JLabel("Hotel Name");
		label.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label.setBounds(383, 205, 159, 37);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Address");
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_1.setBounds(380, 238, 166, 37);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Price ");
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_2.setBounds(383, 276, 159, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Features");
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_3.setBounds(383, 314, 146, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Rating ");
		label_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_4.setBounds(383, 352, 146, 37);
		contentPane.add(label_4);
                //ADDED
                 JLabel label_37 = new JLabel("Room # ");
		label_37.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_37.setBounds(383, 400, 146, 37);
		contentPane.add(label_37);
                
                   JPanel panel_39 = new JPanel();
		panel_39.setBounds(524, 400, 97, 25);
		contentPane.add(panel_39);
		
                
                JPanel panel_36 = new JPanel();
		panel_36.setBounds(163, 400, 97, 25);
		contentPane.add(panel_36);
		
		JButton button = new JButton("Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button.setBounds(435, 445, 97, 25);
		contentPane.add(button);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(524, 364, 97, 25);
		contentPane.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(524, 314, 97, 25);
		contentPane.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(524, 276, 97, 25);
		contentPane.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(524, 243, 97, 25);
		contentPane.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(524, 206, 97, 25);
		contentPane.add(panel_11);
		
	
		
		JLabel label_5 = new JLabel("Hotel Name");
		label_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_5.setBounds(743, 205, 159, 37);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Address");
		label_6.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_6.setBounds(740, 238, 166, 37);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Price ");
		label_7.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_7.setBounds(743, 276, 159, 25);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Features");
		label_8.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_8.setBounds(743, 314, 146, 25);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Rating ");
		label_9.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_9.setBounds(743, 352, 146, 37);
		contentPane.add(label_9);
                
                
                //ADDED
                 JLabel label_38 = new JLabel("Room #  ");
		label_38.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_38.setBounds(743, 400, 146, 37);
		contentPane.add(label_38);
                
                   JPanel panel_37 = new JPanel();
		panel_37.setBounds(884, 400, 97, 25);
		contentPane.add(panel_37);
                
                
		JPanel panel_40 = new JPanel();
		panel_40.setBounds(884, 775, 97, 25);
		contentPane.add(panel_40);
		
                
                
		JButton button_1 = new JButton("Book");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button_1.setBounds(795, 445, 97, 25);
		contentPane.add(button_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(884, 364, 97, 25);
		contentPane.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(884, 314, 97, 25);
		contentPane.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(884, 276, 97, 25);
		contentPane.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(884, 243, 97, 25);
		contentPane.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(884, 206, 97, 25);
		contentPane.add(panel_17);
		
	
		
		JLabel label_10 = new JLabel("Hotel Name");
		label_10.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_10.setBounds(25, 579, 159, 37);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Address");
		label_11.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_11.setBounds(22, 612, 166, 37);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Price ");
		label_12.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_12.setBounds(25, 650, 159, 25);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Features");
		label_13.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_13.setBounds(25, 688, 146, 25);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Rating ");
		label_14.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_14.setBounds(25, 726, 146, 37);
		contentPane.add(label_14);
                //ADDED
                 JLabel label_40 = new JLabel("Room # ");
		label_40.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_40.setBounds(25, 760, 146, 37);
		contentPane.add(label_40);
                
                
                JPanel panel_42 = new JPanel();
		panel_42.setBounds(166, 775, 97, 25);
		contentPane.add(panel_42);
		
		JButton button_2 = new JButton("Book");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button_2.setBounds(77, 815, 97, 25);
		contentPane.add(button_2);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(166, 738, 97, 25);
		contentPane.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(166, 688, 97, 25);
		contentPane.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(166, 650, 97, 25);
		contentPane.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBounds(166, 617, 97, 25);
		contentPane.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBounds(166, 580, 97, 25);
		contentPane.add(panel_23);
		
		
		JLabel label_15 = new JLabel("Hotel Name");
		label_15.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_15.setBounds(386, 579, 159, 37);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("Address");
		label_16.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_16.setBounds(383, 612, 166, 37);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("Price ");
		label_17.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_17.setBounds(386, 650, 159, 25);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("Features");
		label_18.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_18.setBounds(386, 688, 146, 25);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("Rating ");
		label_19.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_19.setBounds(386, 726, 146, 37);
		contentPane.add(label_19);
                //ADDED
                  JLabel label_41 = new JLabel("Room # ");
		label_41.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_41.setBounds(386, 760, 146, 37);
		contentPane.add(label_41);
                
                JPanel panel_43 = new JPanel();
		panel_43.setBounds(527, 775, 97, 25);
		contentPane.add(panel_43);
                
		
		JButton button_3 = new JButton("Book");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button_3.setBounds(438, 815, 97, 25);
		contentPane.add(button_3);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBounds(527, 738, 97, 25);
		contentPane.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBounds(527, 688, 97, 25);
		contentPane.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBounds(527, 650, 97, 25);
		contentPane.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBounds(527, 617, 97, 25);
		contentPane.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBounds(527, 580, 97, 25);
		contentPane.add(panel_29);
		
		
		
		JLabel label_21 = new JLabel("Hotel Name");
		label_21.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_21.setBounds(746, 579, 159, 37);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel("Address");
		label_22.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_22.setBounds(743, 612, 166, 37);
		contentPane.add(label_22);
		
		JLabel label_24 = new JLabel("Price ");
		label_24.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_24.setBounds(746, 650, 159, 25);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel("Features");
		label_25.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_25.setBounds(746, 688, 146, 25);
		contentPane.add(label_25);
		
		JLabel label_27 = new JLabel("Rating ");
		label_27.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_27.setBounds(746, 726, 146, 37);
		contentPane.add(label_27);
		
                //ADDED
                  JLabel label_42 = new JLabel("Room # ");
		label_42.setFont(new Font("Arial Black", Font.PLAIN, 20));
		label_42.setBounds(746, 760, 146, 37);
		contentPane.add(label_42);
                
                
		JButton button_4 = new JButton("Book");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestFinalBooking fbook = new guestFinalBooking(currentUser);
				fbook.setVisible(true);
				close();
			}
		});
		button_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		button_4.setBounds(798, 815, 97, 25);
		contentPane.add(button_4);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBounds(887, 738, 97, 25);
		contentPane.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBounds(887, 688, 97, 25);
		contentPane.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBounds(887, 650, 97, 25);
		contentPane.add(panel_33);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBounds(887, 617, 97, 25);
		contentPane.add(panel_34);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBounds(887, 580, 97, 25);
		contentPane.add(panel_35);
	}
}
