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

public class managerRequest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerRequest frame = new managerRequest();
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
	public managerRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIew Request\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(188, 13, 656, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnRoomModificaton = new JButton("Completed ");
		btnRoomModificaton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRoomModificaton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				managerCompletedRequest mrm = new managerCompletedRequest();
				mrm.setVisible(true);
				close();
				
			}
		});
		btnRoomModificaton.setBounds(52, 173, 245, 55);
		contentPane.add(btnRoomModificaton);
		
		JButton btnRequest = new JButton("Incomplete\r\n");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerIncompleteRequest mrm = new managerIncompleteRequest();
				mrm.setVisible(true);
				close();
				
			}
		});
		btnRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnRequest.setBounds(421, 173, 245, 55);
		contentPane.add(btnRequest);
		
		JButton btnCloseApplication = new JButton("Main Menu\r\n");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerMain mrm = new managerMain();
				mrm.setVisible(true);
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(229, 332, 245, 55);
		contentPane.add(btnCloseApplication);
	}

}
