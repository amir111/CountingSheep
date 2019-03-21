import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class managerMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerMain frame = new managerMain();
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
	public managerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Options\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(69, 13, 656, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnRoomModificaton = new JButton("Room Modificaton");
		btnRoomModificaton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRoomModificaton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				managerRoomMod mrm = new managerRoomMod();
				mrm.setVisible(true);
				close();
				
			}
		});
		btnRoomModificaton.setBounds(52, 173, 245, 55);
		contentPane.add(btnRoomModificaton);
		
		JButton btnRequest = new JButton("Request \r\n");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerRequest mrm = new managerRequest();
				mrm.setVisible(true);
				close();
				
			}
		});
		btnRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRequest.setBounds(421, 173, 245, 55);
		contentPane.add(btnRequest);
		
		JButton btnCloseApplication = new JButton("Close Application\r\n");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(229, 332, 245, 55);
		contentPane.add(btnCloseApplication);
		
		
	}
}
