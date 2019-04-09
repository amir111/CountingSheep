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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.util.Iterator;

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
		
                JPanel requestPane = new JPanel();
                requestPane.setBackground(SystemColor.activeCaption);
                requestPane.setBounds(50,175,600,150);
                //contentPane.add(requestPane);
                
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
		
		/*JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerName.setBounds(55, 146, 221, 21);
		contentPane.add(lblCustomerName);*/
                
                JTextArea request = new JTextArea();
                request.setLineWrap(true);
                request.setEditable(false);
                request.setVisible(true);
                
                JScrollPane scroll = new JScrollPane(request);
                scroll.setVisible(true);
                scroll.setBounds(50,175,600,150);
                contentPane.add(scroll);
                
                Iterator requestList = DB.selectRequestsByManager(user.uuid, true).iterator();
                
                while(requestList.hasNext()){
                    PersonalRequest currentReq = (PersonalRequest) requestList.next();
                    request.append("Customer: " + currentReq.customerName + "\n");
                    request.append("Category: " + currentReq.category + "\n");
                    request.append("Description: " + currentReq.desc + "\n");
                    request.append("\n");
                }
		/*int i = 0;
                while(i<5){
                JTextArea request_i = new JTextArea();
                request_i.setEditable(true);
                request_i.setBackground(Color.red);
                
                requestPane.add(request_i);
                request_i.setBounds(10,15+(i*30),160,15);
                request_i.setLocation(10, 15+(i*30));
                request_i.append("yeet");
                i++;
                }*/
		/*JPanel panel = new JPanel();
		panel.setBounds(55, 186, 183, 21);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(55, 226, 183, 21);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(55, 260, 183, 21);
		contentPane.add(panel_2);*/
		
		/*JLabel lblCustomerRequest = new JLabel("Customer Request\r\n");
		lblCustomerRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerRequest.setBounds(405, 146, 221, 21);
		contentPane.add(lblCustomerRequest);*/
		
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
