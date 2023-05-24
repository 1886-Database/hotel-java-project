package view.UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import view.component.LoginBackground;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import view.swing.RoundedButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public SignUp() {
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
		frame.setShape(new RoundRectangle2D.Double(0, 0, 1195, 670, 20, 20));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		navigationBar = new LoginBackground(Color.decode("#283c86"), Color.decode("#45a247"), 3);
		navigationBar.setBounds(0, 0, 1194, 150);
		navigationBar.setDirection(2);
	    frame.getContentPane().add(navigationBar);
	    navigationBar.setLayout(null);
	    
	    hotelName = new JLabel("회원가입");
	    hotelName.setForeground(Color.WHITE);
	    hotelName.setFont(new Font("이화체", Font.BOLD, 40));
	    hotelName.setBounds(114, 43, 332, 60);
	    navigationBar.add(hotelName);
	    
	    JLabel button_back = new JLabel("");
	    button_back.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Login login = new Login();
	    	}
	    });
	    button_back.setBounds(28, 43, 60, 60);
	    button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/back.png")));
	    navigationBar.add(button_back);
	    
	    button_exit = new JLabel("");
	    button_exit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frame.dispose();
	    	}
	    });
	    button_exit.setToolTipText("종료");
	    button_exit.setBounds(1132, 10, 50, 50);
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png")));
	    navigationBar.add(button_exit);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 149, 1194, 521);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    label_realName = new JLabel("이름");
	    label_realName.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_realName.setBounds(122, 54, 115, 44);
	    panel.add(label_realName);
	    
	    label_loginName = new JLabel("ID");
	    label_loginName.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_loginName.setBounds(122, 134, 115, 44);
	    panel.add(label_loginName);
	    
	    label_password = new JLabel("password");
	    label_password.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_password.setBounds(122, 214, 115, 44);
	    panel.add(label_password);
	    
	    label_phone = new JLabel("전화번호");
	    label_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_phone.setBounds(122, 294, 115, 44);
	    panel.add(label_phone);
	    
	    label_birthday = new JLabel("생년월일");
	    label_birthday.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthday.setBounds(122, 374, 115, 44);
	    panel.add(label_birthday);
	    
	    textField = new JTextField();
	    textField.setBounds(272, 54, 370, 38);
	    panel.add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(272, 140, 370, 38);
	    panel.add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(272, 214, 370, 38);
	    panel.add(textField_2);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(272, 294, 70, 38);
	    panel.add(textField_3);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(372, 294, 120, 38);
	    panel.add(textField_4);
	    
	    textField_5 = new JTextField();
	    textField_5.setColumns(10);
	    textField_5.setBounds(522, 294, 120, 38);
	    panel.add(textField_5);
	    
	    JSeparator separator1 = new JSeparator();
	    separator1.setBounds(354, 312, 7, 2);
	    panel.add(separator1);
	    
	    JSeparator separator2 = new JSeparator();
	    separator2.setBounds(504, 312, 7, 2);
	    panel.add(separator2);
	    
	    RoundedButton button_signUp = new RoundedButton("login");
	    button_signUp.setText("가입");
	    button_signUp.setForeground(Color.WHITE);
	    button_signUp.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_signUp.setBackground(new Color(40, 60, 134));
	    button_signUp.setBounds(950, 390, 208, 52);
	    panel.add(button_signUp);
	    
	    JComboBox comboBox_year = new JComboBox();
	    comboBox_year.setModel(new DefaultComboBoxModel(new String[] {"1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"}));
	    comboBox_year.setBounds(272, 376, 70, 38);
	    panel.add(comboBox_year);
	    
	    JLabel lblNewLabel = new JLabel("년");
	    lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    lblNewLabel.setBounds(354, 374, 35, 38);
	    panel.add(lblNewLabel);
	    
	    JComboBox comboBox_year_1 = new JComboBox();
	    comboBox_year_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	    comboBox_year_1.setBounds(401, 376, 70, 38);
	    panel.add(comboBox_year_1);
	    
	    JLabel lblNewLabel_1 = new JLabel("월");
	    lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    lblNewLabel_1.setBounds(483, 374, 35, 38);
	    panel.add(lblNewLabel_1);
	    
	    JComboBox comboBox_year_2 = new JComboBox();
	    comboBox_year_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	    comboBox_year_2.setBounds(530, 376, 70, 38);
	    panel.add(comboBox_year_2);
	    
	    JLabel lblNewLabel_2 = new JLabel("일");
	    lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    lblNewLabel_2.setBounds(612, 374, 35, 38);
	    panel.add(lblNewLabel_2);
	}
	private view.component.LoginBackground navigationBar;
	private JLabel hotelName;
	private JLabel button_exit;
	private JLabel label_realName;
	private JLabel label_loginName;
	private JLabel label_password;
	private JLabel label_phone;
	private JLabel label_birthday;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
}
