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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class managerAddRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
            
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerAddRoom frame = new managerAddRoom(currentUser);
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
	public managerAddRoom(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Room\r\n");
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
		btnCloseApplication.setBounds(267, 361, 245, 55);
		contentPane.add(btnCloseApplication);
		
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomId.setBounds(71, 139, 116, 32);
		contentPane.add(lblRoomId);
		
		JLabel lblRoomCost = new JLabel("Room Cost\r\n");
		lblRoomCost.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomCost.setBounds(71, 195, 150, 32);
		contentPane.add(lblRoomCost);
		
		
		
		JLabel lblFeatures = new JLabel("Features \r\n");
		lblFeatures.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFeatures.setBounds(418, 139, 116, 32);
		contentPane.add(lblFeatures);
		
		
		
		textField = new JTextField();
		textField.setBounds(199, 142, 137, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 187, 137, 32);
		contentPane.add(textField_1);
		
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(546, 139, 137, 32);
		contentPane.add(textField_3);
		
		
		
		JButton btnSubmit = new JButton("SUBMIT\r\n");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                //RoomManagement.AddRoom();
                                //DB.insertNewRoom(int rmNum,String descript, float price,)
				JOptionPane.showMessageDialog(btnCloseApplication,"Room Submitted");
				managerRoomMod mrm = new managerRoomMod(currentUser);
				mrm.setVisible(true);
				close();
				

			}
		});
		btnSubmit.setForeground(Color.GREEN);
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.setBounds(299, 284, 181, 44);
		contentPane.add(btnSubmit);
	}

}
