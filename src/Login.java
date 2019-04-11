import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JTextField usernamefield;
	private JPasswordField passwordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 774, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblusername.setBounds(237, 128, 218, 93);
		frame.getContentPane().add(lblusername);
		
		JLabel lblpaassword = new JLabel("Password\r\n");
		lblpaassword.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblpaassword.setBounds(237, 216, 157, 67);
		frame.getContentPane().add(lblpaassword);
		
		JLabel lblSleepingSheep = new JLabel("Counting Sheep");
		lblSleepingSheep.setFont(new Font("Showcard Gothic", Font.BOLD, 80));
		lblSleepingSheep.setBounds(12, 32, 732, 103);
		frame.getContentPane().add(lblSleepingSheep);
		
		usernamefield = new JTextField();
		usernamefield.setFont(new Font("Arial Black", Font.PLAIN, 20));
		usernamefield.setBounds(467, 146, 225, 62);
		frame.getContentPane().add(usernamefield);
		usernamefield.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 25));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                               
                                //custom login user name and password
				String uname = usernamefield.getText();
				String pds = passwordfield.getText();
                                try{
                                 
                                if(UserLogIn.checkLogIn(uname, pds).ID=='M'){
                                    User currentUser = DB.selectTargetUser(uname);
                                    frame.dispose();
				    managerMain mm = new managerMain(currentUser);
			            mm.setVisible(true);
                                }
                                else if(UserLogIn.checkLogIn(uname, pds).ID=='C'){
                                    User currentUser = DB.selectTargetUser(uname);
                                    frame.dispose();
                                    guestPortfolio guest1 = new guestPortfolio(currentUser);
                                    guest1.setVisible(true);
                                }
                                else{
                                    throw new NullPointerException();
                                }
                                }
                                catch(NullPointerException npe){
                                    JOptionPane.showMessageDialog(frame,"Incorrect Login Information");
                                }
			}
		});
		btnLogin.setBounds(279, 343, 287, 62);
		frame.getContentPane().add(btnLogin);
		
		passwordfield = new JPasswordField();
		passwordfield.setFont(new Font("Arial Black", Font.PLAIN, 20));
		passwordfield.setBounds(467, 221, 225, 61);
		frame.getContentPane().add(passwordfield);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("bigsheep.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-15, 130, 225, 250);
		frame.getContentPane().add(label);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
