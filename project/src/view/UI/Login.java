package view.UI;

import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.border.Border;
import view.component.LoginBackground;
import view.swing.RoundedButton;
import modelManager.MemberManager;
import modelManager.EmployeeManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private int role;


	public Login(int num) {
		role=num;
		initialize();
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
		
		if(role==1)
			button_signUp.setVisible(false);
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
	    
		backgroundPanel = new LoginBackground(Color.decode("#283c86"), Color.decode("#45a247"), 3);
		backgroundPanel.setBounds(0, 0, 1194, 670);
		backgroundPanel.setDirection(2);
	    frame.getContentPane().add(backgroundPanel);
	    backgroundPanel.setLayout(null);
	    
	    //호텔 이름 라벨
	    hotelName = new JLabel("EWHA HOTEL");
	    hotelName.setFont(new Font("이화체", Font.BOLD, 46));
	    hotelName.setForeground(new Color(255, 255, 255));
	    hotelName.setBounds(494, 122, 332, 139);
	    backgroundPanel.add(hotelName);
	    
	    //호텔 아이콘 라벨
	    hotelIcon = new JLabel("");
	    hotelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/logo.png")));
	    hotelIcon.setBounds(373, 122, 131, 139);
	    backgroundPanel.add(hotelIcon);
	    
	    //USERNAME 라벨
	    label_ID = new JLabel("ID");
	    label_ID.setHorizontalAlignment(SwingConstants.CENTER);
	    label_ID.setBackground(new Color(255, 255, 255));
	    label_ID.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_ID.setForeground(new Color(255, 255, 255));
	    label_ID.setBounds(373, 309, 141, 41);
	    backgroundPanel.add(label_ID);
	    
	    //PASSWORD 라벨
	    label_password = new JLabel("PASSWORD");
	    label_password.setHorizontalAlignment(SwingConstants.CENTER);
	    label_password.setForeground(new Color(255, 255, 255));
	    label_password.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
	    label_password.setBounds(373, 371, 141, 41);
	    backgroundPanel.add(label_password);
	    
	    //로그인 ID 입력 창
	    input_loginID = new JTextField() {
	    	@Override
            public void setBorder(Border border) {}
	    };
	    input_loginID.setForeground(new Color(0, 0, 0));
	    input_loginID.setBounds(526, 312, 300, 35);
	    backgroundPanel.add(input_loginID);
	    input_loginID.setColumns(10);
	    input_loginID.setOpaque(false);
	    
	    //로그인 비밀번호 입력 창
	    input_password = new JPasswordField(){
	    	@Override
            public void setBorder(Border border) {}
	    };
	    input_password.setBounds(526, 374, 300, 35);
	    backgroundPanel.add(input_password);
	    input_password.setOpaque(false);
	    
	    //로그인 버튼
	    button_login = new RoundedButton("login");
	    button_login.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		String loginID = input_loginID.getText(); //유저가 입력한 id를 loginID 변수에 저장
	            String password = String.valueOf(input_password.getPassword()); //유저가 입력한 패스워드를 password 변수에 저장
	            if(loginID.trim().equals("")){ //유저가 아이디 창을 입력하지 않았다면
	                JOptionPane.showMessageDialog(backgroundPanel,"ID를 입력해주세요.", "Empty ID",2);
	            }
	            else if(password.trim().equals("")){ //유저가 패스워드 창을 입력하지 않았다면
	                JOptionPane.showMessageDialog(backgroundPanel,"패스워드를 입력해주세요.", "Empty Password",2);
	            }
	            else{ //유저가 아이디와 패스워드를 모두 입력한 경우
	            	if(role==0) 
	            		memLogin(loginID,password);
	            	if(role==1)
	            		empLogin(loginID,password);
	            }
	    	}
	    });
	    button_login.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    button_login.setForeground(new Color(255, 255, 255));
	    button_login.setText("LOGIN");
	    button_login.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_login.setBackground(new Color(40, 60, 134));
	    button_login.setLocation(386, 439);
	    button_login.setSize(435,61);
	    backgroundPanel.add(button_login);
	    
	    //회원가입 하러 가기 버튼
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
	    
	    //구분선
	    line1 = new Label("");
	    line1.setBackground(new Color(255, 255, 255));
	    line1.setBounds(380, 350, 450, 1);
	    backgroundPanel.add(line1);
	    
	    line2 = new Label("");
	    line2.setBackground(Color.WHITE);
	    line2.setBounds(380, 412, 450, 1);
	    backgroundPanel.add(line2);
	    
	    //종료 버튼
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
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png")));
	    backgroundPanel.add(button_exit);
	    
	    //뒤로가기 버튼
	    button_back = new JLabel("");
	    button_back.setHorizontalAlignment(SwingConstants.CENTER);
	    button_back.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		new Init();
	    		frame.dispose();
	    	}
	    });
	    button_back.setBounds(24, 24, 62, 60);
	    button_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/back.png")));
	    backgroundPanel.add(button_back);
	    
	}
	
	//회원 로그인
	private void memLogin(String id, String pw) {
		MemberManager memberManager = new MemberManager();
		try {
			if(memberManager.login(id,pw)==1) {
				MemberMain memberMain = new MemberMain(id);
				memberMain.main(null);
				frame.dispose();
			}else
				JOptionPane.showMessageDialog(backgroundPanel,"ID나 패스워드가 잘못되었습니다.", "Login Error",2);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//직원 로그인
	private void empLogin(String id, String pw) {
		EmployeeManager employeeManager = new EmployeeManager();
		try {
			if(employeeManager.login(id,pw)==1) {
    			EmployeeMain employeeMain = new EmployeeMain(id);
    			employeeMain.main(null);
    			frame.dispose();
			}else
				JOptionPane.showMessageDialog(backgroundPanel,"ID나 패스워드가 잘못되었습니다.", "Login Error",2);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private view.component.LoginBackground backgroundPanel;
	private view.swing.RoundedButton button_login;
	private JLabel hotelName;
	private JLabel hotelIcon;
	private JLabel label_ID;
	private JLabel label_password;
	private JTextField input_loginID;
	private JPasswordField input_password;
	private JLabel button_signUp;
	private JLabel button_exit;
	private JLabel button_back;
	private Label line1;
	private Label line2;
}