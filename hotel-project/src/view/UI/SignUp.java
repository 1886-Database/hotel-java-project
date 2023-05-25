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
		
		/****************************************** 네비게이션 바 ********************************************/
		navigationBar = new LoginBackground(Color.decode("#283c86"), Color.decode("#45a247"), 3);
		navigationBar.setBounds(0, 0, 1194, 150);
		navigationBar.setDirection(2);
	    frame.getContentPane().add(navigationBar);
	    navigationBar.setLayout(null);
	    
	    //"회원가입"라벨
	    label_signUp = new JLabel("회원가입");
	    label_signUp.setForeground(Color.WHITE);
	    label_signUp.setFont(new Font("이화체", Font.BOLD, 40));
	    label_signUp.setBounds(114, 43, 332, 60);
	    navigationBar.add(label_signUp);
	    
	    	//뒤로가기 버튼
	    JLabel button_back = new JLabel("");
	    button_back.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Login login = new Login();
	    		frame.dispose();
	    	}
	    });
	    button_back.setBounds(28, 43, 60, 60);
	    button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/back.png")));
	    navigationBar.add(button_back);
	    
	    //프로그램 종료 버튼
	    button_exit = new JLabel("");
	    button_exit.setHorizontalAlignment(SwingConstants.CENTER);
	    button_exit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		frame.dispose();
	    	}
	    });
	    button_exit.setToolTipText("종료");
	    button_exit.setBounds(1132, 0, 62, 60);
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png")));
	    navigationBar.add(button_exit);
	    
	    /***************************************** 가입 정보 입력 패널 ***********************************************/
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 149, 1194, 521);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    /**************라벨***************/
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
	    
	    JLabel label_birthYear = new JLabel("년");
	    label_birthYear.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthYear.setBounds(354, 374, 35, 38);
	    panel.add(label_birthYear);   
	    
	    JLabel label_birthMonth = new JLabel("월");
	    label_birthMonth.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthMonth.setBounds(483, 374, 35, 38);
	    panel.add(label_birthMonth);
	    
	    JLabel label_birthDay = new JLabel("일");
	    label_birthDay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthDay.setBounds(612, 374, 35, 38);
	    panel.add(label_birthDay);
	    	    
	    JSeparator separator1 = new JSeparator();
	    separator1.setBounds(354, 312, 7, 2);
	    panel.add(separator1);
	    
	    JSeparator separator2 = new JSeparator();
	    separator2.setBounds(504, 312, 7, 2);
	    panel.add(separator2);
	    
	    /**************사용자 입력***************/
	    input_realName = new JTextField();
	    input_realName.setBounds(272, 54, 370, 38);
	    panel.add(input_realName);
	    input_realName.setColumns(10);
	    
	    input_loginName = new JTextField();
	    input_loginName.setColumns(10);
	    input_loginName.setBounds(272, 140, 370, 38);
	    panel.add(input_loginName);
	    
	    input_password = new JTextField();
	    input_password.setColumns(10);
	    input_password.setBounds(272, 214, 370, 38);
	    panel.add(input_password);
	    
	    input_phone1 = new JTextField();
	    input_phone1.setColumns(10);
	    input_phone1.setBounds(272, 294, 70, 38);
	    panel.add(input_phone1);
	    
	    input_phone2 = new JTextField();
	    input_phone2.setColumns(10);
	    input_phone2.setBounds(372, 294, 120, 38);
	    panel.add(input_phone2);
	    
	    input_phone3 = new JTextField();
	    input_phone3.setColumns(10);
	    input_phone3.setBounds(522, 294, 120, 38);
	    panel.add(input_phone3);

	    JComboBox input_birthYear = new JComboBox();
	    input_birthYear.setModel(new DefaultComboBoxModel(new String[] {"1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"}));
	    input_birthYear.setBounds(272, 376, 70, 38);
	    panel.add(input_birthYear);
	    
	    JComboBox input_birthMonth = new JComboBox();
	    input_birthMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	    input_birthMonth.setBounds(401, 376, 70, 38);
	    panel.add(input_birthMonth);
	    
	    JComboBox input_birthDay = new JComboBox();
	    input_birthDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	    input_birthDay.setBounds(530, 376, 70, 38);
	    panel.add(input_birthDay);
	    
	    /**************회원가입 버튼***************/
	    RoundedButton button_signUp = new RoundedButton("sign up");
	    button_signUp.setText("가입");
	    button_signUp.setForeground(Color.WHITE);
	    button_signUp.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_signUp.setBackground(new Color(40, 60, 134));
	    button_signUp.setBounds(950, 390, 208, 52);
	    panel.add(button_signUp);
	    
	    
	    

	}
	private view.component.LoginBackground navigationBar;
	private JLabel label_signUp;
	private JLabel button_exit;
	private JLabel label_realName;
	private JLabel label_loginName;
	private JLabel label_password;
	private JLabel label_phone;
	private JLabel label_birthday;
	private JTextField input_realName;
	private JTextField input_loginName;
	private JTextField input_password;
	private JTextField input_phone1;
	private JTextField input_phone2;
	private JTextField input_phone3;
}
