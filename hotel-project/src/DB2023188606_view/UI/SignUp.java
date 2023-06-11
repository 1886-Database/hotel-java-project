package DB2023188606_view.UI;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import DB2023188606_modelManager.EmployeeManager;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_view.component.LoginBackground;
import DB2023188606_view.swing.RoundedButton;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frame;


	public SignUp() {
		initialize();
	}

	//frame 초기화를 위한 메소드
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

		memberManager = new MemberManager();

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
	    button_back = new JLabel("");
	    button_back.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Login login = new Login(0);
	    		frame.dispose();
	    	}
	    });
	    button_back.setBounds(28, 43, 60, 60);
	    button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DB2023188606_view/icon/back.png")));
	    navigationBar.add(button_back);

	    //프로그램 종료 버튼
	    button_exit = new JLabel("");
	    button_exit.setHorizontalAlignment(SwingConstants.CENTER);
	    button_exit.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		System.exit(0);
	    	}
	    });
	    button_exit.setToolTipText("종료");
	    button_exit.setBounds(1132, 0, 62, 60);
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DB2023188606_view/icon/exit.png")));
	    navigationBar.add(button_exit);

	    /***************************************** 가입 정보 입력 패널 ***********************************************/
	    panel = new JPanel();
	    panel.setBounds(0, 149, 1194, 521);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);

	    /**************라벨***************/
	    label_name = new JLabel("이름");
	    label_name.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_name.setBounds(122, 54, 115, 44);
	    panel.add(label_name);

	    label_loginID = new JLabel("ID");
	    label_loginID.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_loginID.setBounds(122, 134, 115, 44);
	    panel.add(label_loginID);

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

	    label_birthYear = new JLabel("년");
	    label_birthYear.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthYear.setBounds(354, 374, 35, 38);
	    panel.add(label_birthYear);

	    label_birthMonth = new JLabel("월");
	    label_birthMonth.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthMonth.setBounds(483, 374, 35, 38);
	    panel.add(label_birthMonth);

	    label_birthDay = new JLabel("일");
	    label_birthDay.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_birthDay.setBounds(612, 374, 35, 38);
	    panel.add(label_birthDay);

	    input_name = new JFormattedTextField((AbstractFormatter) null);
	    input_name.addKeyListener(new KeyAdapter() {  //숫자는 입력할 수 없도록 제한 + 글자 수 제한
	    	public void keyTyped(KeyEvent e) {
	    		char c = e.getKeyChar();
	    		if ((Character.isDigit(c)) ||(c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)||input_name.getText().length()>=15) {
	    			e.consume();
	    		}
	    	}
	    });
	    input_name.setBounds(272, 54, 370, 38);
	    panel.add(input_name);

	    input_loginID = new JTextField();
	    input_loginID.setColumns(10);
	    input_loginID.setBounds(272, 140, 370, 38);
	    input_loginID.addKeyListener(new KeyAdapter() {  //숫자는 입력할 수 없도록 제한 + 글자 수 제한
	    	public void keyTyped(KeyEvent e) {
	    		if (input_loginID.getText().length()>=15) {
	    			e.consume();
	    		}
	    	}
	    });
	    panel.add(input_loginID);

	    input_password = new JTextField();
	    input_password.setColumns(10);
	    input_password.setBounds(272, 214, 370, 38);
	    input_password.addKeyListener(new KeyAdapter() {  //글자 수 제한
	    	public void keyTyped(KeyEvent e) {
	    		if (input_password.getText().length()>=15) {
	    			e.consume();
	    		}
	    	}
	    });
	    panel.add(input_password);

	    MaskFormatter formatter=null;
	    try {
	    	formatter = new MaskFormatter("###########"); //전화번호 입력형식 제한
	    }catch(ParseException ex) {
	    }
	    input_phone = new JFormattedTextField(formatter);
	    input_phone.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) { //창 클릭시 입력값 초기화
	    		input_phone.setText("");
	    	}
	    });
	    input_phone.setBounds(272, 293, 370, 38);
	    panel.add(input_phone);


	    input_birthYear = new JComboBox();
	    input_birthYear.setModel(new DefaultComboBoxModel(new String[] {"", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"}));
	    input_birthYear.setBounds(272, 376, 70, 38);
	    panel.add(input_birthYear);

	    input_birthMonth = new JComboBox();
	    input_birthMonth.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
	    input_birthMonth.setBounds(401, 376, 70, 38);
	    panel.add(input_birthMonth);

	    input_birthDay = new JComboBox();
	    input_birthDay.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	    input_birthDay.setBounds(530, 376, 70, 38);
	    panel.add(input_birthDay);


	    /**************ID 중복 확인 버튼***************/

	    button_checkID = new JButton("중복 확인");
	    button_checkID.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String loginID = input_loginID.getText();
	    		if(loginID.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"ID를 입력해주세요.", "Empty id",2);
	    		}else {
	    			try {
			    		if(memberManager.checkID(loginID)==0) {
			    			JOptionPane.showMessageDialog(frame,"이미 존재하는 ID입니다.", "ID duplicate",2);
			    		}else {
			    			checkedID=loginID;
			    			JOptionPane.showMessageDialog(frame,"사용할 수 있는 ID입니다", "possible ID",2);
			    		}
	    			}catch(Exception ex) {
	    				JOptionPane.showMessageDialog(frame,"error", "Error",2);
	    			}
	    		}
	    	}
	    });
	    button_checkID.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
	    button_checkID.setBounds(654, 142, 104, 38);
	    panel.add(button_checkID);



	    /**************회원가입 버튼***************/
	    button_signUp = new RoundedButton("sign up");
	    button_signUp.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String name = input_name.getText();
	    		String loginID = input_loginID.getText();
	    		String password = input_password.getText();
	    		String phone = input_phone.getText();
	    		String birthYear=input_birthYear.getSelectedItem().toString();
	    		String birthMonth=input_birthMonth.getSelectedItem().toString();
	    		String birthDay=input_birthDay.getSelectedItem().toString();
	    		if(name.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"이름을 입력해주세요.", "Empty name",2);
	    		}
	    		else if(loginID.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"ID를 입력해주세요.", "Empty id",2);
	    		}
	    		else if(password.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"비밀번호를 입력해주세요.", "Empty password",2);
	    		}
	    		else if(phone.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"전화번호 11자리를 입력해주세요.", "Empty phoneNum",2);
	    		}
	    		else if(birthYear.trim().equals("")||birthMonth.trim().equals("")||birthDay.trim().equals("")) {
	    			JOptionPane.showMessageDialog(frame,"생일을 입력해주세요.", "Empty birthday",2);
	    		}else if(!(loginID.equals(checkedID))) {
	    			JOptionPane.showMessageDialog(frame,"ID 중복 확인을 해주세요.", "you should check your ID",2);
	    		}else {
	    			String phoneNum = phone.substring(0, 3)+"-"+phone.substring(3, 7)+"-"+phone.substring(7, 11);
	    			String birthDate = birthYear+"-"+birthMonth+"-"+birthDay;
	    			try {
	    				int result = memberManager.signUp(name,loginID,password,phoneNum,birthDate);
	    				if(result==1) {
	    					JOptionPane.showMessageDialog(frame,"회원가입이 완료되었습니다.", "done",2);
	    					new Login(0);
	    					frame.dispose();
	    				}else {
	    					JOptionPane.showMessageDialog(frame,"error.", "signUp error",2);
	    				}
	    			}catch(Exception ex) {
	    				JOptionPane.showMessageDialog(frame,"error", "Error",2);
	    			}

	    		}
	    	}
	    });
	    button_signUp.setText("가입");
	    button_signUp.setForeground(Color.WHITE);
	    button_signUp.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_signUp.setBackground(new Color(40, 60, 134));
	    button_signUp.setBounds(950, 390, 208, 52);
	    panel.add(button_signUp);

	    JLabel lblNewLabel = new JLabel("* 패스워드를 제외한 나머지 정보는 한번 가입한 후로는 수정이 불가하니 신중히 작성해주시길 바랍니다.");
	    lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	    lblNewLabel.setBounds(122, 465, 604, 15);
	    panel.add(lblNewLabel);

	    JLabel lblEx = new JLabel("입력예시) 01012345678");
	    lblEx.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	    lblEx.setBounds(654, 312, 141, 15);
	    panel.add(lblEx);







	}
	private DB2023188606_view.component.LoginBackground navigationBar;
	private JLabel button_back;
	private JLabel label_signUp;
	private JLabel button_exit;
	private JPanel panel;
	private JLabel label_name;
	private JLabel label_loginID;
	private JLabel label_password;
	private JLabel label_phone;
	private JLabel label_birthday;
	private JLabel label_birthYear;
	private JLabel label_birthMonth;
	private JLabel label_birthDay;
	private JFormattedTextField input_name;
	private JTextField input_loginID;
	private JTextField input_password;
	private JFormattedTextField input_phone;
	private JComboBox input_birthYear;
	private JComboBox input_birthMonth;
	private JComboBox input_birthDay;
	private JButton button_checkID;
	private RoundedButton button_signUp;
	private MemberManager memberManager;
	private String checkedID;
}
