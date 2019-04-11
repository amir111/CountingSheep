import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class managerIncompleteRequest extends JFrame {

	private JPanel contentPane;
        static User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerIncompleteRequest frame = new managerIncompleteRequest(currentUser);
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
	public managerIncompleteRequest(User user) {
                currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Incomplete Request\r\n");
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
		btnCloseApplication.setBounds(469, 332, 245, 55);
		contentPane.add(btnCloseApplication);
                
                JTextArea request = new JTextArea();
                request.setLineWrap(true);
                request.setEditable(false);
                request.setVisible(true);
                
                JScrollPane scroll = new JScrollPane(request);
                scroll.setVisible(true);
                scroll.setBounds(50,175,600,150);
                contentPane.add(scroll);
                
                Iterator requestList = DB.selectRequestsByManager(user.uuid, false).iterator();
                int i =0;
                while(requestList.hasNext()){
                    PersonalRequest currentReq = (PersonalRequest) requestList.next();
                    request.append("Customer: " + currentReq.customerName + "\n");
                    request.append("Category: " + currentReq.category + "\n");
                    request.append("Description: " + currentReq.desc + "\n");
                    request.append("Request ID: " + String.valueOf(currentReq.requestId) + "\n");
                   // JCheckBox checkComplete = new JCheckBox("Complete");
		    //checkComplete.setBounds(0, 48+(i*64), 113, 15);
                   // checkComplete.setBackground(Color.white);
		    //contentPane.add(chckbxComplete);
                    //checkComplete.setLocation(20, 40);
                   // request.add(checkComplete);
                    request.append("\n");
                    i++;
                }
		
                JTextField requestID = new JTextField();
                requestID.setBounds(290, 332, 145, 55);
                requestID.setFont(new Font("Arial Black", Font.PLAIN, 12));
                contentPane.add(requestID);
                requestID.setColumns(10);
                
                JButton btnUpdate = new JButton("Close Request\r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String req = requestID.getText();
				DB.updateRequestAsComplete(Integer.valueOf(req));
                                managerRequest manReq = new managerRequest(currentUser);
                                manReq.setVisible(true);
				close();

			}
		});
              //btnUpdate.setForeground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnUpdate.setBounds(20, 332, 245, 55);
		contentPane.add(btnUpdate);
                

		/*JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerName.setBounds(55, 146, 221, 21);
		contentPane.add(lblCustomerName);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 186, 183, 21);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(55, 226, 183, 21);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(55, 260, 183, 21);
		contentPane.add(panel_2);
		
		JLabel lblCustomerRequest = new JLabel("Customer Request\r\n");
		lblCustomerRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCustomerRequest.setBounds(405, 151, 221, 21);
		contentPane.add(lblCustomerRequest);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(415, 186, 183, 21);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(415, 226, 183, 21);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(415, 260, 183, 21);
		contentPane.add(panel_5);
		
		JCheckBox chckbxComplete = new JCheckBox("Complete");
		chckbxComplete.setBounds(620, 186, 113, 25);
		contentPane.add(chckbxComplete);
		
		JCheckBox checkBox = new JCheckBox("Complete");
		checkBox.setBounds(620, 226, 113, 25);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Complete");
		checkBox_1.setBounds(606, 270, 113, 25);
		contentPane.add(checkBox_1);*/
	}
}
