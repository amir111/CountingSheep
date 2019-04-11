
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
import java.util.Iterator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class guestRequest extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    static User currentUser;
    static RequestBooking currentBooking;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestRequest frame = new guestRequest(currentUser, currentBooking);
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
    public guestRequest(User user, RequestBooking booking) {
        currentUser = user;
        currentBooking = booking;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 774, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.activeCaption);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblGuestRequest = new JLabel("Guest Request");
        lblGuestRequest.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 80));
        lblGuestRequest.setBounds(99, 0, 593, 125);
        contentPane.add(lblGuestRequest);

        JLabel lblFoood = new JLabel("Food");
        lblFoood.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblFoood.setBounds(102, 151, 121, 38);
        contentPane.add(lblFoood);

        JLabel lblMaintance = new JLabel("Maintenance");
        lblMaintance.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblMaintance.setBounds(92, 202, 150, 38);
        contentPane.add(lblMaintance);

        JLabel lblOther = new JLabel("Other");
        lblOther.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblOther.setBounds(102, 261, 121, 19);
        contentPane.add(lblOther);

        textField = new JTextField();
        textField.setBounds(235, 162, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_1 = new JTextField();
        textField_1.setBounds(235, 213, 116, 22);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_2 = new JTextField();
        textField_2.setBounds(235, 262, 116, 22);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        textField_2.setFont(new Font("Arial Black", Font.PLAIN, 12));

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!textField.getText().trim().equals("")) { //this is for food
                    DB.insertNewRequest(textField.getText(), "food", DB.getManagerOfMyBooking(currentBooking), currentUser.getUuid());
                    JOptionPane.showMessageDialog(lblGuestRequest, "Request Food Submitted");
                } else if (!textField_1.getText().trim().equals("")) { //this is for maintenance
                    DB.insertNewRequest(textField_1.getText(), "maintenance", DB.getManagerOfMyBooking(currentBooking), currentUser.getUuid());
                    JOptionPane.showMessageDialog(lblGuestRequest, "Request Maintenance Submitted");
                } else if (!textField_2.getText().trim().equals("")) { //this is for other
                    DB.insertNewRequest(textField_2.getText(), "other", DB.getManagerOfMyBooking(currentBooking), currentUser.getUuid());
                    JOptionPane.showMessageDialog(lblGuestRequest, "Request Other Submitted");
                }

                guestPortfolio guest1 = new guestPortfolio(currentUser);
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
                guestPortfolio guest1 = new guestPortfolio(currentUser);
                guest1.setVisible(true);
                close();
            }
        });
        btnGuestPortfolip.setBounds(449, 378, 295, 38);

        JTextArea request = new JTextArea();
        request.setLineWrap(true);
        request.setEditable(false);
        request.setVisible(true);

        JScrollPane scroll = new JScrollPane(request);
        scroll.setVisible(true);
        scroll.setBounds(435, 125, 300, 200);
        contentPane.add(scroll);

        Iterator requestList = DB.selectRequestsByClient(user.getUuid(),DB.getManagerOfMyBooking(currentBooking)).iterator();
        while (requestList.hasNext()) {
            PersonalRequest currentReq = (PersonalRequest) requestList.next();
            request.append("Category: " + currentReq.getCategory() + "\n");
            request.append("Description: " + currentReq.getDesc() + "\n");
            if (currentReq.getCompletionTime() != null) {
                request.append("Completed!\n");
            }
            else{
                request.append("Incomplete\n");
            }
            request.append("\n");
        }

        contentPane.add(btnGuestPortfolip);
    }

}
