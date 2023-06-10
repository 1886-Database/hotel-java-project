package DB2023188606_view.UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB2023188606_modelManager.EmployeeManager;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_view.component.LoginBackground;
import DB2023188606_view.swing.RoundedButton;

public class Init {
	
	private JFrame frame;

	public Init() {
		
		initialize();
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
	}

	//frame 초기화를 위한 메소드
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
	    hotelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DB2023188606_view/icon/logo.png")));
	    hotelIcon.setBounds(373, 122, 131, 139);
	    backgroundPanel.add(hotelIcon);
	    
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
	    button_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DB2023188606_view/icon/exit.png")));
	    backgroundPanel.add(button_exit);
	    
	    /**************************member 로그인 버튼************************/
	    button_memLogin = new RoundedButton("login");
	    button_memLogin.addActionListener(new ActionListener() { //버튼 클릭 이벤트
	    	public void actionPerformed(ActionEvent e) {
	    		new Login(0); //로그인 frame에 인자 0을 넘겨주며 호출 
	    		frame.dispose();
	    	}
	    });
	    button_memLogin.setForeground(new Color(255, 255, 255));
	    button_memLogin.setText("MEMBER LOGIN");
	    button_memLogin.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_memLogin.setBackground(new Color(40, 60, 134));
	    button_memLogin.setLocation(379, 370);
	    button_memLogin.setSize(435,61);
	    backgroundPanel.add(button_memLogin);
	    
	    /**************************employee 로그인 버튼************************/
	    button_empLogin = new RoundedButton("login");
	    button_empLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new Login(1); //로그인 frame에 인자 1을 넘겨주며 호출
	    		frame.dispose();
	    	}
	    });
	    button_empLogin.setText("ADMIN LOGIN");
	    button_empLogin.setForeground(Color.WHITE);
	    button_empLogin.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	    button_empLogin.setBackground(new Color(40, 60, 134));
	    button_empLogin.setBounds(379, 461, 435, 61);
	    backgroundPanel.add(button_empLogin);
	    
	}
	
	private DB2023188606_view.component.LoginBackground backgroundPanel;
	private JLabel hotelName;
	private JLabel hotelIcon;
	private JLabel button_exit;
	private DB2023188606_view.swing.RoundedButton button_memLogin;
	private DB2023188606_view.swing.RoundedButton button_empLogin;
}
