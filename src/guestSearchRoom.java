import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class guestSearchRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guestSearchRoom frame = new guestSearchRoom();
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
	public guestSearchRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblBookARoom = new JLabel("Search A Room");
		lblBookARoom.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 80));
		contentPane.setBackground(SystemColor.activeCaption);

		lblBookARoom.setBounds(105, 0, 614, 111);
		contentPane.add(lblBookARoom);
		
		JButton btnPreviousMenu = new JButton("Guest Protfolio");
		btnPreviousMenu.setForeground(Color.RED);
		btnPreviousMenu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestPortfolio guest1 = new guestPortfolio();
				guest1.setVisible(true);
				close();
			}
		});
		btnPreviousMenu.setBounds(250, 377, 222, 25);
		contentPane.add(btnPreviousMenu);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCity.setBounds(191, 143, 68, 33);
		contentPane.add(lblCity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPrice.setBounds(191, 200, 56, 16);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(295, 144, 153, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 193, 153, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestBookRoom broom = new guestBookRoom();
				broom.setVisible(true);
				close();
			}
		});
		btnSearch.setBounds(295, 256, 153, 25);
		contentPane.add(btnSearch);
		
		
		
		
		
		
		
		
		
	}

}
