
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

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
import java.awt.Color;
import java.awt.Font;

public class guestPortfolio extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    public static User currentUser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestPortfolio frame = new guestPortfolio(currentUser);
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
    public guestPortfolio(User user) {
        currentUser = user;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 774, 476);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblGuetProtfolio = new JLabel("Guest Portfolio");
        lblGuetProtfolio.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 90));
        lblGuetProtfolio.setBounds(62, 0, 744, 92);
        contentPane.add(lblGuetProtfolio);

        JLabel lblGuestName = new JLabel("Guest Name");
        lblGuestName.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblGuestName.setBounds(62, 107, 143, 55);
        contentPane.add(lblGuestName);

        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblEmailAddress.setBounds(62, 176, 170, 55);
        contentPane.add(lblEmailAddress);

        JLabel lblChangePassword = new JLabel("Change Password ");
        lblChangePassword.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblChangePassword.setBounds(62, 262, 221, 26);
        contentPane.add(lblChangePassword);

        JButton btnBookingInfo = new JButton("Booking Info");
        btnBookingInfo.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnBookingInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //Guest.Dispose();
                guestBookingInfo bookinfo = new guestBookingInfo(currentUser);
                bookinfo.setVisible(true);
                close();

            }
        });
        btnBookingInfo.setBounds(513, 113, 177, 49);
        contentPane.add(btnBookingInfo);

        JButton btnBookRoom = new JButton("Book Room");
        btnBookRoom.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnBookRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestSearchRoom sroom = new guestSearchRoom(currentUser);
                sroom.setVisible(true);
                close();

            }

        });
        btnBookRoom.setBounds(513, 198, 177, 49);
        contentPane.add(btnBookRoom);

        JButton btnRequest = new JButton("Request");
        btnRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestRequest greq = new guestRequest(currentUser);
                greq.setVisible(true);
                close();
            }
        });
        btnRequest.setBounds(513, 277, 177, 49);
        contentPane.add(btnRequest);

        JButton btnLogout = new JButton("Close Application");
        btnLogout.setForeground(Color.RED);
        btnLogout.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Login mainscreen = new Login();
                mainscreen.setVisible(true);
                close();

            }
        });
        btnLogout.setBounds(245, 345, 232, 60);
        contentPane.add(btnLogout);

        JPanel panel = new JPanel();
        panel.setBounds(62, 154, 210, 26);
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(62, 223, 210, 26);
        contentPane.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(62, 301, 210, 26);
        contentPane.add(panel_2);
                //ADDED BUTTON
        //CHANGES THE PASSWORD

        JButton changePassword = new JButton("Change Password\r\n");
        changePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textField_2.getText().equals("")) {
                    JOptionPane.showMessageDialog(btnBookingInfo, "No Password Change");
                } else {
                    DB.updateUserPassword(currentUser.getUuid(), textField_2.getText());
                    JOptionPane.showMessageDialog(btnBookingInfo, "Password Changed");
                }
                guestPortfolio back = new guestPortfolio(currentUser);
                back.setVisible(true);
                close();
            }
        });

        changePassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
        changePassword.setBounds(284, 301, 177, 29);
        contentPane.add(changePassword);

        textField = new JTextField();
        textField.setText(currentUser.getUsername());
        textField.setEditable(false);
        panel.add(textField);
        textField.setColumns(15);
        //changes font
        textField.setFont(new Font("Arial Black",Font.PLAIN, 12));

        textField_1 = new JTextField();
        textField_1.setText(currentUser.getEmail());
        textField_1.setEditable(false);
        panel_1.add(textField_1);
        textField_1.setColumns(15);
        textField_1.setFont(new Font("Arial Black",Font.PLAIN, 12));

        textField_2 = new JTextField();
        panel_2.add(textField_2);
        textField_2.setColumns(15);
        textField_2.setFont(new Font("Arial Black",Font.PLAIN, 12));

    }
}
