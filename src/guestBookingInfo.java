
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.Checkbox;
import java.awt.Color;

public class guestBookingInfo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    static User currentUser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestBookingInfo frame = new guestBookingInfo(currentUser);
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
    public guestBookingInfo(User user) {
        currentUser = user;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 774, 476);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnGoBackTo = new JButton("Guest Portfolio\r\n");
        btnGoBackTo.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnGoBackTo.setForeground(Color.RED);
        btnGoBackTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestPortfolio guest1 = new guestPortfolio(currentUser);
                guest1.setVisible(true);
                close();

            }
        });
        btnGoBackTo.setBounds(228, 380, 294, 36);
        contentPane.add(btnGoBackTo);

        JLabel lblHotelName = new JLabel("Hotel name");
        lblHotelName.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblHotelName.setBounds(61, 150, 155, 22);
        contentPane.add(lblHotelName);

        JLabel lblCity = new JLabel("City ");
        lblCity.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblCity.setBounds(61, 212, 78, 24);
        contentPane.add(lblCity);

        JLabel lblFeatures = new JLabel("Features ");
        lblFeatures.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblFeatures.setBounds(61, 249, 123, 28);
        contentPane.add(lblFeatures);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblPrice.setBounds(61, 291, 56, 16);
        contentPane.add(lblPrice);

        JLabel lblMyBookingInformation = new JLabel(" My Booking Information");
        lblMyBookingInformation.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 55));
        lblMyBookingInformation.setBounds(61, 28, 683, 63);
        contentPane.add(lblMyBookingInformation);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblAddress.setBounds(61, 185, 123, 16);
        contentPane.add(lblAddress);

        textField = new JTextField();
        textField.setBounds(228, 153, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_1 = new JTextField();
        textField_1.setBounds(228, 185, 116, 22);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_2 = new JTextField();
        textField_2.setBounds(228, 216, 116, 22);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        textField_2.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_3 = new JTextField();
        textField_3.setBounds(228, 255, 116, 22);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        textField_3.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_4 = new JTextField();
        textField_4.setBounds(228, 291, 116, 22);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        textField_4.setFont(new Font("Arial Black", Font.PLAIN, 12));

        JLabel lblRequest = new JLabel("Request ");
        lblRequest.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblRequest.setBounds(530, 95, 128, 32);
        contentPane.add(lblRequest);

        JLabel lblMade = new JLabel("Made");
        lblMade.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblMade.setBounds(472, 140, 92, 42);
        contentPane.add(lblMade);

        JLabel lblComplete = new JLabel("Complete");
        lblComplete.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblComplete.setBounds(623, 147, 108, 28);
        contentPane.add(lblComplete);

        Checkbox checkbox = new Checkbox("Complete");
        checkbox.setFont(new Font("Arial Black", Font.PLAIN, 20));
        checkbox.setBounds(623, 183, 108, 24);
        contentPane.add(checkbox);

        Checkbox checkbox_1 = new Checkbox("Complete");
        checkbox_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
        checkbox_1.setBounds(623, 212, 128, 36);
        contentPane.add(checkbox_1);

        textField_5 = new JTextField();
        textField_5.setBounds(472, 188, 116, 22);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        textField_5.setFont(new Font("Arial Black", Font.PLAIN, 12));

        textField_6 = new JTextField();
        textField_6.setBounds(472, 232, 116, 22);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        textField_6.setFont(new Font("Arial Black", Font.PLAIN, 12));

    }
}
