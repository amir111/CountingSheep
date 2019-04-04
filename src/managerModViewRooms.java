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

public class managerModViewRooms extends JFrame {

	private JPanel contentPane;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerModViewRooms frame = new managerModViewRooms(currentUser);
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
	public managerModViewRooms(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify/View Room\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(71, 13, 628, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnCloseApplication = new JButton("Previous Menu\r\n");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerRoomMod mrm = new managerRoomMod(currentUser);
				mrm.setVisible(true);
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(245, 340, 245, 55);
		contentPane.add(btnCloseApplication);
		
		
		JButton btnSubmit = new JButton("View Room\r\n");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerViewRoomOnly mrm = new managerViewRoomOnly(currentUser);
				mrm.setVisible(true);
				close();
				

			}
		});
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.setBounds(83, 206, 181, 44);
		contentPane.add(btnSubmit);
		
		JButton btnModifyRoom = new JButton("Modify Room\r\n");
		btnModifyRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerRoomModify mrm = new managerRoomModify(currentUser);
				mrm.setVisible(true);
				close();
				
			}
		});
		btnModifyRoom.setForeground(Color.BLACK);
		btnModifyRoom.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnModifyRoom.setBounds(436, 206, 181, 44);
		contentPane.add(btnModifyRoom);
	}

}
