
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
import java.awt.BorderLayout;
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

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class managerHotelOptions extends JFrame {

    private JPanel contentPane;
    static User currentUser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    managerHotelOptions frame = new managerHotelOptions(currentUser);
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
    public managerHotelOptions(User user) {
        currentUser = user;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 774, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.activeCaption);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Hotel Options\r\n");
        lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
        lblNewLabel.setBounds(131, 13, 656, 103);
        contentPane.add(lblNewLabel);

        //ADDED
        JLabel lblNewLabe2 = new JLabel("Hotel Options\r\n");
        lblNewLabe2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 70));
        lblNewLabe2.setBounds(131, 13, 656, 103);
        contentPane.add(lblNewLabe2);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Breakfast\r\n");
        chckbxNewCheckBox.setFont(new Font("Arial Black", Font.PLAIN, 18));
        chckbxNewCheckBox.setBounds(248, 200, 188, 28);
        contentPane.add(chckbxNewCheckBox);

        JCheckBox chckbxPool = new JCheckBox("Pool");
        chckbxPool.setFont(new Font("Arial Black", Font.PLAIN, 18));
        chckbxPool.setBounds(248, 250, 188, 28);
        contentPane.add(chckbxPool);

        JCheckBox chckbxFoodDelivery = new JCheckBox("Food Delivery");
        chckbxFoodDelivery.setFont(new Font("Arial Black", Font.PLAIN, 18));
        chckbxFoodDelivery.setBounds(248, 300, 188, 28);
        contentPane.add(chckbxFoodDelivery);
      

        JButton btnNewButton = new JButton("Previous Menu");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                managerMain mrm = new managerMain(currentUser);
                mrm.setVisible(true);
                close();

            }
        });
  
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 24));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(223, 366, 249, 28);
		contentPane.add(btnNewButton);
                //added
                
		JButton btnUpdateButton = new JButton("Update");
		btnUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            				JOptionPane.showMessageDialog(btnUpdateButton,"Hotel Options Updated");

				managerMain mrm = new managerMain(currentUser);
				mrm.setVisible(true);
				close();
				
			}
		});
		btnUpdateButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnUpdateButton.setForeground(Color.GREEN);
		btnUpdateButton.setBounds(519, 246, 193, 41);
		contentPane.add(btnUpdateButton);
		
    }

}
