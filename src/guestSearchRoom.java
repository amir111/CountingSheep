
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
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class guestSearchRoom extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField startMonth;
    private JTextField startDay;
    private JTextField startYear;
    private JTextField endMonth;
    private JTextField endDay;
    private JTextField endYear;
    static User currentUser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestSearchRoom frame = new guestSearchRoom(currentUser);
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
    public guestSearchRoom(User user) {
        currentUser = user;
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

        JButton btnPreviousMenu = new JButton("Guest Portfolio");
        btnPreviousMenu.setForeground(Color.RED);
        btnPreviousMenu.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnPreviousMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestPortfolio guest1 = new guestPortfolio(currentUser);
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
        
        JLabel lblDate = new JLabel("Dates");
        lblDate.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblDate.setBounds(191, 247, 65, 16);
        contentPane.add(lblDate);

        textField = new JTextField();
        textField.setBounds(295, 144, 153, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(295, 193, 153, 36);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        startMonth = new JTextField();
        startMonth.setBounds(295, 247, 30, 36);
        contentPane.add(startMonth);
        startMonth.setColumns(2);
        
        startDay = new JTextField();
        startDay.setBounds(330, 247, 30, 36);
        contentPane.add(startDay);
        startDay.setColumns(2);
        
        startYear = new JTextField();
        startYear.setBounds(365, 247, 50, 36);
        contentPane.add(startYear);
        startYear.setColumns(2);
        
        JLabel lblDate2 = new JLabel("to");
        lblDate2.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblDate2.setBounds(440, 252, 65, 16);
        contentPane.add(lblDate2);
        
        endMonth = new JTextField();
        endMonth.setBounds(480, 247, 30, 36);
        contentPane.add(endMonth);
        endMonth.setColumns(2);
        
        endDay = new JTextField();
        endDay.setBounds(515, 247, 30, 36);
        contentPane.add(endDay);
        endDay.setColumns(2);
        
        endYear = new JTextField();
        endYear.setBounds(550, 247, 50, 36);
        contentPane.add(endYear);
        endYear.setColumns(2);

        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Room> rooms;
                try {
                    float inputPrice;
                    if (textField_1.getText().trim().equals("")) {
                        inputPrice = 0;
                    } else {
                        inputPrice = Float.valueOf(textField_1.getText().trim()).floatValue();
                    }
                    rooms = DB.selectRooms(inputPrice, textField.getText());
                    
                    //NOTE: Process date input, make sure you can make a string in the exact format of YYYY-MM-DD, otherwise throw an exception and make the user do it right
                    String startDate = "1997-08-23";
                    String endDate = "1997-08-25";
                    //NOTE: Process this list and remove rooms that have bookings that conflict with inputed dates here
                    
                    guestBookRoom broom = new guestBookRoom(currentUser, rooms, startDate, endDate);
                    broom.setVisible(true);
                    close();
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(btnSearch, "Invalid Input");
                }
            }
        });
        btnSearch.setBounds(295, 350, 153, 25);
        contentPane.add(btnSearch);

    }

}
