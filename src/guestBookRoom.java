
//import static guestPortfolio.currentUser;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Integer;
import javax.swing.JOptionPane;
  
public class guestBookRoom extends JFrame {

    private JPanel contentPane;
    static User currentUser;
    static ArrayList<Room> currentRooms;
    static String startBooking;
    static String endBooking;
    static JTextField chosenRoom;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    guestBookRoom frame = new guestBookRoom(currentUser, currentRooms, startBooking, endBooking);
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
    
    
    public guestBookRoom(User user, ArrayList<Room> rooms, String startDate, String endDate) {
        currentUser = user;
        currentRooms = rooms;
        startBooking = startDate;
        endBooking = endDate;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1071, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBookARoom = new JLabel("Book A Room");
        lblBookARoom.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 75));
        contentPane.setBackground(SystemColor.activeCaption);

        lblBookARoom.setBounds(322, 0, 627, 102);
        contentPane.add(lblBookARoom);

        JButton btnGuestPortfolio = new JButton("Back To Search ");
        btnGuestPortfolio.setForeground(Color.RED);
        btnGuestPortfolio.setFont(new Font("Arial Black", Font.PLAIN, 20));
        btnGuestPortfolio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guestSearchRoom sroom = new guestSearchRoom(currentUser);
                sroom.setVisible(true);
                close();

            }
        });
        btnGuestPortfolio.setBounds(22, 19, 260, 25);
        contentPane.add(btnGuestPortfolio);

        //
        int startingX = 22;
        int startingY = 205;
        JPanel panel;
        JTextField textField;
        for (int i = 0; i < currentRooms.size() && i < 6; i++) {
            JLabel lblHotelId = new JLabel("Hotel Name");
            lblHotelId.setFont(new Font("Arial Black", Font.PLAIN, 20));
            lblHotelId.setBounds(startingX, startingY, 159, 37);
            contentPane.add(lblHotelId);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY, 150, 25);
            

            textField = new JTextField();
            textField.setText(currentRooms.get(i).getName());
            textField.setEditable(false);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
            textField.setFont(new Font("Arial Black",Font.PLAIN, 12));



            JLabel label_23 = new JLabel("Address");
            label_23.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_23.setBounds(startingX, startingY + 33, 166, 37);
            contentPane.add(label_23);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY + 33, 150, 25);
            textField = new JTextField();
            textField.setText(currentRooms.get(i).getAddress());
            textField.setEditable(true);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
                        textField.setFont(new Font("Arial Black",Font.PLAIN, 9));


            JLabel label_20 = new JLabel("Price ");
            label_20.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_20.setBounds(startingX, startingY + 66, 159, 25);
            contentPane.add(label_20);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY + 66, 150, 25);
            textField = new JTextField();
            textField.setText(Float.toString(currentRooms.get(i).getRoomPrice()));
            textField.setEditable(false);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
                        textField.setFont(new Font("Arial Black",Font.PLAIN, 12));


            JLabel label_29 = new JLabel("Features");
            label_29.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_29.setBounds(startingX, startingY + 99, 146, 25);
            contentPane.add(label_29);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY + 99, 150, 25);
            textField = new JTextField();
            textField.setText(currentRooms.get(i).getFeatures());
            textField.setEditable(true);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
                        textField.setFont(new Font("Arial Black",Font.PLAIN, 12));


            JLabel label_26 = new JLabel("Rating ");
            label_26.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_26.setBounds(startingX, startingY + 132, 146, 37);
            contentPane.add(label_26);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY + 132, 150, 25);
            textField = new JTextField();
            textField.setText(Integer.toString(currentRooms.get(i).getRating()));
            textField.setEditable(false);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
                        textField.setFont(new Font("Arial Black",Font.PLAIN, 12));


            JLabel label_36 = new JLabel("Room #  ");
            label_36.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_36.setBounds(startingX, startingY + 165, 146, 37);
            contentPane.add(label_36);

            panel = new JPanel();
            panel.setBounds(startingX + 150, startingY + 165, 150, 25);
            textField = new JTextField();
            textField.setText(Integer.toString(currentRooms.get(i).getRoomName()));
            textField.setEditable(false);
            panel.add(textField);
            textField.setColumns(12);
            contentPane.add(panel);
                        textField.setFont(new Font("Arial Black",Font.PLAIN, 12));


            JLabel label_55 = new JLabel("Choice #" + i);
            label_55.setFont(new Font("Arial Black", Font.PLAIN, 20));
            label_55.setBounds(startingX + 75, startingY + 200, 150, 25);
            contentPane.add(label_55);

            startingX += 350;
            if (i == 2) {
                startingX = 22;
                startingY += 300;
            }
        }

        JLabel label_50 = new JLabel("Choice:");
        label_50.setFont(new Font("Arial Black", Font.PLAIN, 20));
        label_50.setBounds(350, 750, 146, 25);
        contentPane.add(label_50);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(450, 750, 210, 26);
        contentPane.add(panel_1);
        chosenRoom = new JTextField();
        panel_1.add(chosenRoom);
        chosenRoom.setColumns(15);
                                chosenRoom.setFont(new Font("Arial Black",Font.PLAIN, 12));


        JButton button_5 = new JButton("Book");
        button_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    guestFinalBooking fbook = new guestFinalBooking(currentUser, currentRooms, startBooking, endBooking, Integer.valueOf(chosenRoom.getText().trim()));
                    fbook.setVisible(true);
                    close();
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(button_5, "Invalid Input");
                }
            }
        });
        button_5.setBounds(700, 750, 97, 25);
        contentPane.add(button_5);
    }
}
