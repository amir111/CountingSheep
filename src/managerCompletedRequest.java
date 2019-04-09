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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class managerCompletedRequest extends JFrame {

	private JPanel contentPane;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerCompletedRequest frame = new managerCompletedRequest(currentUser);
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
	public managerCompletedRequest(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Completed Request\r\n");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
		lblNewLabel.setBounds(88, 13, 656, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnCloseApplication = new JButton("Main Menu\r\n");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerRequest mrm = new managerRequest(currentUser);
				mrm.setVisible(true);
				close();

			}
		});
		btnCloseApplication.setForeground(new Color(255, 0, 0));
		btnCloseApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnCloseApplication.setBounds(229, 332, 245, 55);
		contentPane.add(btnCloseApplication);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerName.setBounds(55, 146, 221, 21);
		contentPane.add(lblCustomerName);
                
                JScrollPane scroll = new JScrollPane();
                scroll.setVisible(true);
                scroll.setBounds(100, 100, 774, 476);
		
		/*JPanel panel = new JPanel();
		panel.setBounds(55, 186, 183, 21);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(55, 226, 183, 21);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(55, 260, 183, 21);
		contentPane.add(panel_2);*/
		
		JLabel lblCustomerRequest = new JLabel("Customer Request\r\n");
		lblCustomerRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerRequest.setBounds(405, 151, 221, 21);
		contentPane.add(lblCustomerRequest);
		
		/*JPanel panel_3 = new JPanel();
		panel_3.setBounds(415, 186, 183, 21);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(415, 226, 183, 21);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(415, 260, 183, 21);
		contentPane.add(panel_5);*/
	}

}
