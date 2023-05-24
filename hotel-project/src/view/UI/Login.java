package view.UI;

import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.border.Border;
import view.component.LoginBackground;
import view.swing.RoundedButton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JButton;

public class Login {

	private JFrame frame;

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
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1194, 670);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setShape(new RoundRectangle2D.Double(0, 0, 1195, 670, 20, 20)); //frame 코너 둥글게
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	    
		backgroundPanel = new LoginBackground(Color.decode("#283c86"), Color.decode("#45a247"), 3);
		backgroundPanel.setBounds(0, 0, 1194, 670);
		backgroundPanel.setDirection(2);
	    frame.getContentPane().add(backgroundPanel);
	    backgroundPanel.setLayout(null);
	    
	    JLabel hotelName = new JLabel("EWHA HOTEL");
	    hotelName.setFont(new Font("이화체", Font.BOLD, 46));
	    hotelName.setForeground(new Color(255, 255, 255));
	    hotelName.setBounds(494, 122, 332, 139);
	    backgroundPanel.add(hotelName);
	    
	    hotelIcon = new JLabel("");
	    hotelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/logo.png")));
	    hotelIcon.setBounds(373, 122, 131, 139);
	    backgroundPanel.add(hotelIcon);
	    
	    label_userName = new JLabel("USERNAME");
	    label_userName.setHorizontalAlignment(SwingConstants.CENTER);
	    label_userName.setBackground(new Color(255, 255, 255));
	    label_userName.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_userName.setForeground(new Color(255, 255, 255));
	    label_userName.setBounds(373, 309, 141, 41);
	    backgroundPanel.add(label_userName);
	    
	    label_password = new JLabel("PASSWORD");
	    label_password.setHorizontalAlignment(SwingConstants.CENTER);
	    label_password.setForeground(new Color(255, 255, 255));
	    label_password.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_password.setBounds(373, 371, 141, 41);
	    backgroundPanel.add(label_password);
	    
	    input_userName = new JTextField() {
	    	@Override
            public void setBorder(Border border) {}
	    };
	    input_userName.setForeground(new Color(0, 0, 0));
	    input_userName.setBounds(526, 312, 300, 35);
	    backgroundPanel.add(input_userName);
	    input_userName.setColumns(10);
	    input_userName.setOpaque(false);
	    
	    input_password = new JPasswordField(){
	    	@Override
            public void setBorder(Border border) {}
	    };
	    input_password.setBounds(526, 374, 300, 35);
	    backgroundPanel.add(input_password);
	    input_password.setOpaque(false);
	    
	    button_login = new RoundedButton("login");
	    button_login.setForeground(new Color(255, 255, 255));
	    button_login.setText("LOGIN");
	    button_login.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_login.setBackground(new Color(40, 60, 134));
	    button_login.setLocation(386, 439);
	    button_login.setSize(435,61);
	    backgroundPanel.add(button_login);
	    
	    button_signUp = new JLabel("아직 회원이 아니신가요?");
	    button_signUp.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseEntered(MouseEvent e) {
	    		button_signUp.setText("회원가입 하러가기");
	    	}
	    	@Override
	    	public void mouseExited(MouseEvent e) {
	    		button_signUp.setText("아직 회원이 아니신가요?");
	    	}
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		SignUp signUp = new SignUp();
	    		frame.dispose();
	    		
	    	}
	    });
	    button_signUp.setHorizontalAlignment(SwingConstants.CENTER);
	    button_signUp.setToolTipText("");
	    button_signUp.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
	    button_signUp.setForeground(new Color(255, 255, 255));
	    button_signUp.setBounds(373, 506, 448, 35);
	    backgroundPanel.add(button_signUp);
	    
	    Label line1 = new Label("");
	    line1.setBackground(new Color(255, 255, 255));
	    line1.setBounds(380, 350, 450, 1);
	    backgroundPanel.add(line1);
	    
	    line2 = new Label("");
	    line2.setBackground(Color.WHITE);
	    line2.setBounds(380, 412, 450, 1);
	    backgroundPanel.add(line2);
	    
	    JLabel button_exit = new JLabel("");
	    button_exit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frame.dispose();
	    	}
	    });
	    button_exit.setToolTipText("종료");
	    button_exit.setBounds(1144, 10, 50, 50);
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png")));
	    backgroundPanel.add(button_exit);
	    
	    
	}
	private view.component.LoginBackground backgroundPanel;
	private view.swing.RoundedButton button_login;
	private JLabel hotelIcon;
	private JLabel label_userName;
	private JLabel label_password;
	private JTextField input_userName;
	private JPasswordField input_password;
	private JLabel button_signUp;
	private Label line2;
}
