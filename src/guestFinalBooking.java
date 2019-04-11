
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

import java.util.ArrayList;

public class guestFinalBooking extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    static User currentUser;
    static ArrayList<Room> currentRooms;
    static String startBooking;
    static String endBooking;
    static int chosenRoom;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestFinalBooking frame = new guestFinalBooking(currentUser, currentRooms, startBooking, endBooking, chosenRoom);
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
    public guestFinalBooking(User user, ArrayList<Room> rooms, String startDate, String endDate, int choice) {
        currentUser = user;
        currentRooms = rooms;
        startBooking = startDate;
        endBooking = endDate;
        chosenRoom = choice;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 774, 476);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.activeCaption);

        JLabel lblFinalBooking = new JLabel("Final Booking");
        lblFinalBooking.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 75));
        lblFinalBooking.setBounds(221, 13, 570, 67);
        contentPane.add(lblFinalBooking);

        JLabel lblHotel = new JLabel("Hotel ");
        lblHotel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblHotel.setBounds(174, 101, 150, 28);
        contentPane.add(lblHotel);

        JLabel lblCost = new JLabel("Cost");
        lblCost.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblCost.setBounds(174, 142, 56, 16);
        contentPane.add(lblCost);

        JLabel lblRating = new JLabel("Rating");
        lblRating.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblRating.setBounds(174, 171, 116, 28);
        contentPane.add(lblRating);

        JLabel lblCcNumber = new JLabel("CC Number");
        lblCcNumber.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblCcNumber.setBounds(174, 212, 150, 22);
        contentPane.add(lblCcNumber);

        textField = new JTextField();
        textField.setBounds(324, 215, 116, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnBookNow = new JButton("BOOK NOW!");
        btnBookNow.setForeground(Color.GREEN);
        btnBookNow.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnBookNow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (CheckCreditCard.CheckTheCC(Long.valueOf(textField.getText().trim()))) {
                        DB.insertNewBooking(startBooking, endBooking, currentUser.getUuid(), currentRooms.get(chosenRoom).getRoomID());
                        JOptionPane.showMessageDialog(lblFinalBooking, "You are BOOKED");
                    } else {
                        throw new Exception();
                    }
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(btnBookNow, "CC Invalid, please enter a 16 digit card number that has no letters and doesn't start with 0");
                }

                guestPortfolio guest1 = new guestPortfolio(currentUser);
                guest1.setVisible(true);
                close();

            }
        });
        btnBookNow.setBounds(276, 356, 190, 47);
        contentPane.add(btnBookNow);

        JButton btnCheckEnterCc = new JButton("Check CC Valid\r\n");
        btnCheckEnterCc.setForeground(Color.BLACK);
        btnCheckEnterCc.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnCheckEnterCc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //String cc = "1234567812345678";
                //call checkcreditcard.java, return false or true 
                //cc.equals("1234567812345678")
                try {
                    if (CheckCreditCard.CheckTheCC(Long.valueOf(textField.getText().trim()))) {
                        JOptionPane.showMessageDialog(btnBookNow, "CC Valid");
                    } else {
                        throw new Exception();
                    }
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(btnBookNow, "CC Invalid, please enter a 16 digit card number that has no letters and doesn't start with 0");
                }

            }
        });
        btnCheckEnterCc.setBounds(260, 268, 229, 47);
        contentPane.add(btnCheckEnterCc);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnCancel.setForeground(Color.RED);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestBookRoom broom = new guestBookRoom(currentUser, currentRooms, startBooking, endBooking);
                broom.setVisible(true);
                close();
            }
        });
        btnCancel.setBounds(27, 21, 150, 47);
        contentPane.add(btnCancel);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(324, 101, 116, 22);
        textField_1.setText(currentRooms.get(chosenRoom).getName());
        textField_1.setEditable(false);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(324, 136, 116, 22);
        textField_2.setText(Float.toString(currentRooms.get(chosenRoom).getRoomPrice()));
        textField_2.setEditable(false);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(324, 180, 116, 22);
        textField_3.setText(Integer.toString(currentRooms.get(chosenRoom).getRating()));
        textField_3.setEditable(false);
        contentPane.add(textField_3);
    }

}
