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

public class managerDeleteRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerDeleteRoom frame = new managerDeleteRoom(currentUser);
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
	public managerDeleteRoom( final User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Room\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(177, 13, 427, 103);
		contentPane.add(lblNewLabel);
		
		final JButton btnCloseApplication = new JButton("Previous Menu\r\n");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerRoomMod mrm = new managerRoomMod(currentUser);
				mrm.setVisible(true);
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(234, 361, 245, 55);
		contentPane.add(btnCloseApplication);
		
		JLabel lblRoomId = new JLabel("Room #");
		lblRoomId.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRoomId.setBounds(299, 129, 116, 32);
		contentPane.add(lblRoomId);
		
		
		JButton btnSubmit = new JButton("Delete Room");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                int roomNum = Integer.valueOf(textField.getText().trim()).intValue();
                                try{
                                    if(DB.deleteRoomByNumber(roomNum, user.uuid)==false){
                                        throw new Exception();
                                    }
                                    else{
                                        DB.deleteRoomByNumber(roomNum, user.uuid);
                                        JOptionPane.showMessageDialog(btnCloseApplication,"Room Deleted");
                                        managerRoomMod mrm = new managerRoomMod(currentUser);
                                        mrm.setVisible(true);
                                        close();}
                                }
                                catch(Exception EE){
                                    JOptionPane.showMessageDialog(btnCloseApplication,"Room Not Found");
                                }

			}
		});
		btnSubmit.setForeground(Color.RED);
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.setBounds(264, 256, 181, 44);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(299, 193, 116, 32);
		contentPane.add(textField);
		textField.setColumns(10);

}
}

