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
        private JTextField textField_5;
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
		
		JLabel lblOldRoomId = new JLabel("Room Number");
		lblOldRoomId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblOldRoomId.setBounds(280, 119, 286, 32);
		contentPane.add(lblOldRoomId);
		
		JLabel lblNewRoomCost = new JLabel("New Room Cost\r\n");
		lblNewRoomCost.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewRoomCost.setBounds(280, 183, 286, 32);
		contentPane.add(lblNewRoomCost);
		 
		JLabel lblNewRoomDescrip = new JLabel("New Description\r\n");
		lblNewRoomDescrip.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewRoomDescrip.setBounds(280, 247, 286, 32);
		contentPane.add(lblNewRoomDescrip);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                int oldRoomNum = Integer.valueOf(textField.getText().trim()).intValue();
                                float newRoomCost = Float.valueOf(textField_4.getText().trim()).floatValue();
                                String newFeatures = textField_5.getText().trim();
                                
                                try{
                                    if(DB.roomExists(user.uuid, oldRoomNum)==false){
                                        throw new NullPointerException();
                                    }
                                    else{
                                        DB.updateRoom(oldRoomNum, user.uuid, newFeatures, newRoomCost);
                                        
                                        JOptionPane.showMessageDialog(btnCloseApplication,"Room Modified");
                                        managerModViewRooms mrm = new managerModViewRooms(currentUser);
                                        mrm.setVisible(true);
                                        close();
                                    }
                                }
                                catch(NullPointerException E){
                                    JOptionPane.showMessageDialog(btnCloseApplication,"Cannot Find Room Number");
                                }
                            
			}
		});
		btnSubmit.setForeground(Color.GREEN);
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.setBounds(280, 333, 181, 44);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(280, 151, 136, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(280, 215, 136, 32);
		contentPane.add(textField_4);
                
                textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(280, 279, 136, 32);
		contentPane.add(textField_5);
	}

}
