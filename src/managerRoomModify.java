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

public class managerRoomModify extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerRoomModify frame = new managerRoomModify(currentUser);
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
	public managerRoomModify(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify Room");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(177, 13, 427, 103);
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
		btnCloseApplication.setBounds(253, 414, 245, 55);
		contentPane.add(btnCloseApplication);
		
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomId.setBounds(71, 139, 116, 32);
		contentPane.add(lblRoomId);
		
		JLabel lblRoomCost = new JLabel("Room Cost\r\n");
		lblRoomCost.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomCost.setBounds(71, 195, 150, 32);
		contentPane.add(lblRoomCost);
		
		JLabel lblCity = new JLabel("City \r\n");
		lblCity.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCity.setBounds(71, 239, 116, 32);
		contentPane.add(lblCity);
		
		JLabel lblFeatures = new JLabel("Features \r\n");
		lblFeatures.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFeatures.setBounds(418, 139, 116, 32);
		contentPane.add(lblFeatures);
		
		JLabel lblRatings = new JLabel("Ratings\r\n");
		lblRatings.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRatings.setBounds(418, 206, 116, 32);
		contentPane.add(lblRatings);
		 
		
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnCloseApplication,"Room Updated");
				managerModViewRooms mrm = new managerModViewRooms(currentUser);
				mrm.setVisible(true);
				close();
				

			}
		});
		btnSubmit.setForeground(Color.GREEN);
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.setBounds(280, 333, 181, 44);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(204, 147, 123, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 203, 123, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 247, 123, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(546, 129, 123, 35);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(531, 214, 123, 35);
		contentPane.add(textField_4);
	}

}
