import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class guestRequest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guestRequest frame = new guestRequest();
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
	public guestRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGuestRequest = new JLabel("Guest Request");
		lblGuestRequest.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 80));
		lblGuestRequest.setBounds(99, 0, 593, 125);
		contentPane.add(lblGuestRequest);
		
		JLabel lblFoood = new JLabel("Foood");
		lblFoood.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblFoood.setBounds(102, 151, 121, 38);
		contentPane.add(lblFoood);
		
		JLabel lblMaintance = new JLabel("Maintance");
		lblMaintance.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblMaintance.setBounds(102, 202, 121, 38);
		contentPane.add(lblMaintance); 
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblOther.setBounds(102, 261, 121, 19);
		contentPane.add(lblOther);
		
		textField = new JTextField();
		textField.setBounds(235, 162, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(235, 213, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(235, 262, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(lblGuestRequest, "Request Submitted");
				
				Guest guest1 = new Guest();
				guest1.setVisible(true);
				close();
			}
		});
		btnSubmit.setBounds(222, 324, 157, 25);
		contentPane.add(btnSubmit);
		
		JButton btnGuestPortfolip = new JButton("Guest Portfolio");
		btnGuestPortfolip.setForeground(Color.RED);
		btnGuestPortfolip.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnGuestPortfolip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guest guest1 = new Guest();
				guest1.setVisible(true);
				close();
			}
		});
		btnGuestPortfolip.setBounds(449, 378, 295, 38);
		contentPane.add(btnGuestPortfolip);
	}

}
