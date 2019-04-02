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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class managerRoomMod extends JFrame {

	private JPanel contentPane;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerRoomMod frame = new managerRoomMod(currentUser);
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
	public managerRoomMod(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Modifications\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(69, 13, 656, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnRoomModificaton = new JButton("Add Room");
		btnRoomModificaton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRoomModificaton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				managerAddRoom mar = new managerAddRoom(currentUser);
				mar.setVisible(true);
				close();
				
			}
		});
		btnRoomModificaton.setBounds(49, 173, 179, 55);
		contentPane.add(btnRoomModificaton);
		
		JButton btnCloseApplication = new JButton("Main Menu");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerMain mm = new managerMain(currentUser);
				mm.setVisible(true);
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(229, 332, 245, 55);
		contentPane.add(btnCloseApplication);
		
		JButton btnDeleteRoom = new JButton("Delete Room\r\n");
		btnDeleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerDeleteRoom mdr = new managerDeleteRoom(currentUser);
				mdr.setVisible(true);
				close();
			}
		});
		btnDeleteRoom.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnDeleteRoom.setBounds(257, 173, 179, 55);
		contentPane.add(btnDeleteRoom);
		
		JButton btnModifyRoom = new JButton("Modify/View Rooms\r\n");
		btnModifyRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerModViewRooms mdr = new managerModViewRooms(currentUser);
				mdr.setVisible(true);
				close();
			}
		});
		btnModifyRoom.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnModifyRoom.setBounds(479, 173, 265, 55);
		contentPane.add(btnModifyRoom);
	
	}

}
