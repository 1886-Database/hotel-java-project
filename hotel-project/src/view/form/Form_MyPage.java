package view.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.model.StatusType;
import view.swing.ScrollBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import view.swing.MyPagePanelBorder;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Form_MyPage extends JPanel {


    /**
     * Creates new form Form_1
     */
    public Form_MyPage() {
        initComponents();
    //  add row table
    
    }
    
    public void initComponents() {
    	setBackground(new java.awt.Color(242, 242, 242));
    	setLayout(null);
    	
    	//좌측 패널 ***********************************************************************
    	
    	leftPanel = new view.swing.MyPagePanelBorder();
    	leftPanel.setLocation(26, 73);
    	leftPanel.setSize(224, 500);
    	leftPanel.setBackground(new java.awt.Color(255, 255, 255));
    	add(leftPanel);
    	
    	//우측 패널 (1:개인정보 수정 패널 / 2:비밀번호 변경 패널 / 3:회원 탈퇴 패널) ***********************
    	
    	MyPagePanelBorder rightPanel1 = new MyPagePanelBorder();
    	rightPanel1.setBackground(Color.WHITE);
    	rightPanel1.setBounds(295, 73, 615, 500);
    	add(rightPanel1);
    	rightPanel1.setLayout(null);
    	
    	MyPagePanelBorder rightPanel2 = new MyPagePanelBorder();
    	rightPanel2.setBackground(Color.WHITE);
    	rightPanel2.setBounds(295, 73, 615, 500);
    	add(rightPanel2);
    	
    	MyPagePanelBorder rightPanel3 = new MyPagePanelBorder();
    	rightPanel3.setBackground(Color.WHITE);
    	rightPanel3.setBounds(295, 73, 615, 500);
    	add(rightPanel3);
    	
    	JSeparator leftPanel_seperator = new JSeparator();
    	leftPanel_seperator.setBounds(25, 240, 180, 10);
    	leftPanel.add(leftPanel_seperator);
    	
    	//좌측 패널 컴포넌트 ***********************************************************************************************
    	
    	JLabel leftPanel_userImg = new JLabel("");
    	leftPanel_userImg.setBounds(59, 48, 100, 100);
    	leftPanel_userImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/myUser.png")));
    	leftPanel.add(leftPanel_userImg);
    	
    	JLabel leftPanel_userName = new JLabel("홍길동");
    	leftPanel_userName.setForeground(new Color(47, 79, 79));
    	leftPanel_userName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    	leftPanel_userName.setBounds(69, 158, 68, 31);
    	leftPanel.add(leftPanel_userName);
    	
    	JLabel leftPanel_label1 = new JLabel("님");
    	leftPanel_label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    	leftPanel_label1.setBounds(135, 158, 37, 31);
    	leftPanel.add(leftPanel_label1);
    	
    	JLabel leftPanel_label2 = new JLabel("등급");
    	leftPanel_label2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    	leftPanel_label2.setBounds(122, 200, 37, 15);
    	leftPanel.add(leftPanel_label2);
    	
    	JLabel leftPanel_userGrade = new JLabel("SILVER");
    	leftPanel_userGrade.setFont(new Font("맑은 고딕", Font.BOLD, 14));
    	leftPanel_userGrade.setBounds(69, 200, 50, 15);
    	leftPanel.add(leftPanel_userGrade);
    	
    	JButton leftPanel_button1 = new JButton("내 정보");
    	leftPanel_button1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    	leftPanel_button1.setBackground(Color.WHITE);
    	leftPanel_button1.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			rightPanel1.setVisible(true);
    			rightPanel2.setVisible(false);
    			rightPanel3.setVisible(false);
    		}
    	});
    	leftPanel_button1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		}
    	});
    	leftPanel_button1.setBounds(25, 272, 180, 50);
    	leftPanel.add(leftPanel_button1);
    	
    	JButton leftPanel_button2 = new JButton("비밀번호 변경");
    	leftPanel_button2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    	leftPanel_button2.setBackground(Color.WHITE);
    	leftPanel_button2.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			rightPanel1.setVisible(false);
    			rightPanel2.setVisible(true);
    			rightPanel3.setVisible(false);
    		}
    	});
    	leftPanel_button2.setBounds(25, 343, 180, 50);
    	leftPanel.add(leftPanel_button2);
    	
    	JButton leftPanel_button3 = new JButton("회원 탈퇴");
    	leftPanel_button3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    	leftPanel_button3.setBackground(Color.WHITE);
    	leftPanel_button3.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			rightPanel1.setVisible(false);
    			rightPanel2.setVisible(false);
    			rightPanel3.setVisible(true);
    		}
    	});
    	leftPanel_button3.setBounds(25, 413, 180, 50);
    	leftPanel.add(leftPanel_button3);
    	leftPanel.setLayout(null);
    	leftPanel.add(leftPanel_userImg);
    	leftPanel.add(leftPanel_userName);
    	leftPanel.add(leftPanel_label1);
    	leftPanel.add(leftPanel_label2);
    	leftPanel.add(leftPanel_userGrade);
    	leftPanel.add(leftPanel_button1);
    	leftPanel.add(leftPanel_button2);
    	leftPanel.add(leftPanel_button3);
    	
    	
    	//구분선
    	JSeparator verticalSeparator = new JSeparator();
    	verticalSeparator.setOrientation(SwingConstants.VERTICAL);
    	verticalSeparator.setBounds(273, 73, 10, 500);
    	add(verticalSeparator);
    	
    	//우측 패널 : 개인 정보 수정 패널 컴포넌트******************************************************************************
    	
    	JLabel rightPanel1_label1 = new JLabel("내 정보");
    	rightPanel1_label1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
    	rightPanel1_label1.setBounds(189, 49, 237, 54);
    	rightPanel1.add(rightPanel1_label1);
    	
    	JLabel rightPanel1_label2 = new JLabel("ID");
    	rightPanel1_label2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel1_label2.setBounds(122, 199, 27, 15);
    	rightPanel1.add(rightPanel1_label2);
    	
    	JLabel rightPanel1_label3 = new JLabel("성함");
    	rightPanel1_label3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel1_label3.setBounds(332, 199, 50, 15);
    	rightPanel1.add(rightPanel1_label3);
    	
    	JLabel rightPanel1_label4 = new JLabel("전화번호");
    	rightPanel1_label4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel1_label4.setBounds(94, 283, 66, 15);
    	rightPanel1.add(rightPanel1_label4);
    	
    	JLabel rightPanel1_label5 = new JLabel("생일");
    	rightPanel1_label5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel1_label5.setBounds(122, 360, 34, 15);
    	rightPanel1.add(rightPanel1_label5);
    	
    	rightPanel1_ID = new JTextField();
    	rightPanel1_ID.setBackground(Color.WHITE);
    	rightPanel1_ID.setEditable(false);
    	rightPanel1_ID.setEnabled(false);
    	rightPanel1_ID.setBounds(189, 199, 96, 24);
    	rightPanel1.add(rightPanel1_ID);
    	rightPanel1_ID.setColumns(10);
    	
    	rightPanel1_name = new JTextField();
    	rightPanel1_name.setBackground(Color.WHITE);
    	rightPanel1_name.setEnabled(false);
    	rightPanel1_name.setEditable(false);
    	rightPanel1_name.setColumns(10);
    	rightPanel1_name.setBounds(394, 199, 96, 25);
    	rightPanel1.add(rightPanel1_name);
    	
    	rightPanel1_phone1 = new JTextField();
    	rightPanel1_phone1.setEditable(false);
    	rightPanel1_phone1.setEnabled(false);
    	rightPanel1_phone1.setBackground(Color.WHITE);
    	rightPanel1_phone1.setColumns(10);
    	rightPanel1_phone1.setBounds(204, 281, 66, 25);
    	rightPanel1.add(rightPanel1_phone1);
    	
    	JLabel rightPanel1_label4_1 = new JLabel("-");
    	rightPanel1_label4_1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label4_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
    	rightPanel1_label4_1.setBounds(282, 281, 19, 15);
    	rightPanel1.add(rightPanel1_label4_1);
    	
    	rightPanel1_phone2 = new JTextField();
    	rightPanel1_phone2.setEditable(false);
    	rightPanel1_phone2.setEnabled(false);
    	rightPanel1_phone2.setColumns(10);
    	rightPanel1_phone2.setBackground(Color.WHITE);
    	rightPanel1_phone2.setBounds(317, 281, 66, 25);
    	rightPanel1.add(rightPanel1_phone2);
    	
    	JLabel rightPanel1_label4_2 = new JLabel("-");
    	rightPanel1_label4_2.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label4_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
    	rightPanel1_label4_2.setBounds(395, 281, 19, 15);
    	rightPanel1.add(rightPanel1_label4_2);
    	
    	rightPanel1_phone3 = new JTextField();
    	rightPanel1_phone3.setEditable(false);
    	rightPanel1_phone3.setEnabled(false);
    	rightPanel1_phone3.setColumns(10);
    	rightPanel1_phone3.setBackground(Color.WHITE);
    	rightPanel1_phone3.setBounds(426, 281, 66, 25);
    	rightPanel1.add(rightPanel1_phone3);
    	
    	
    	
    	JLabel rightPanel1_label5_1 = new JLabel("년");
    	rightPanel1_label5_1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_1.setBounds(274, 360, 19, 15);
    	rightPanel1.add(rightPanel1_label5_1);
    	
    	
    	
    	JComboBox rightPanel1_dayChooser = new JComboBox();
    	rightPanel1_dayChooser.setEnabled(false);
    	rightPanel1_dayChooser.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
    	rightPanel1_dayChooser.setBounds(440, 358, 70, 25);
    	rightPanel1.add(rightPanel1_dayChooser);
    	
    	JLabel rightPanel1_label5_2 = new JLabel("월");
    	rightPanel1_label5_2.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_2.setBounds(397, 360, 19, 15);
    	rightPanel1.add(rightPanel1_label5_2);
    	
    	JLabel rightPanel1_label5_3 = new JLabel("일");
    	rightPanel1_label5_3.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_3.setBounds(521, 360, 19, 15);
    	rightPanel1.add(rightPanel1_label5_3);
    	
    	JComboBox input_birthYear = new JComboBox();
    	input_birthYear.setEnabled(false);
    	input_birthYear.setBounds(187, 358, 70, 25);
    	rightPanel1.add(input_birthYear);
    	
    	JComboBox input_birthMonth = new JComboBox();
    	input_birthMonth.setEnabled(false);
    	input_birthMonth.setBounds(316, 358, 70, 25);
    	rightPanel1.add(input_birthMonth);
    	
    	//우측 패널 : 비밀번호 변경 패널 컴포넌트 ******************************************************************************
    	
    	JLabel rightPanel2_label1 = new JLabel("비밀번호 변경");
    	rightPanel2_label1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel2_label1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
    	rightPanel2_label1.setBounds(189, 49, 237, 54);
    	rightPanel2.add(rightPanel2_label1);
    	rightPanel2.add(rightPanel2_label1);
    	
    	JButton rightPanel2_button1 = new JButton("변경하기");
    	rightPanel2_button1.setBackground(Color.WHITE);
    	rightPanel2_button1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
    	rightPanel2_button1.setBounds(175, 388, 264, 54);
    	rightPanel2.add(rightPanel2_button1);
    	
    	JLabel rightPanel2_label2 = new JLabel("현재 비밀번호");
    	rightPanel2_label2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel2_label2.setBounds(84, 182, 106, 15);
    	rightPanel2.add(rightPanel2_label2);
    	
    	JLabel rightPanel2_label3_ = new JLabel("변경할 비밀번호");
    	rightPanel2_label3_.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel2_label3_.setBounds(84, 230, 120, 15);
    	rightPanel2.add(rightPanel2_label3_);
    	
    	JLabel rightPanel2_label4 = new JLabel("변경할 비밀번호 확인");
    	rightPanel2_label4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel2_label4.setBounds(74, 278, 159, 15);
    	rightPanel2.add(rightPanel2_label4);
    	
    	rightPanel2_input1 = new JPasswordField();
    	rightPanel2_input1.setBounds(254, 181, 264, 27);
    	rightPanel2.add(rightPanel2_input1);
    	
    	rightPanel2_input2 = new JPasswordField();
    	rightPanel2_input2.setBounds(254, 229, 264, 27);
    	rightPanel2.add(rightPanel2_input2);
    	
    	rightPanel2_input3 = new JPasswordField();
    	rightPanel2_input3.setBounds(254, 277, 264, 27);
    	rightPanel2.add(rightPanel2_input3);
    	
    	//우측 패널 : 회원 탈퇴 패널 컴포넌트 ******************************************************************************
    	
    	JLabel rightPanel3_label1 = new JLabel("회원 탈퇴");
    	rightPanel3_label1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
    	rightPanel3_label1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel3_label1.setBounds(189, 49, 237, 54);
    	rightPanel3.add(rightPanel3_label1);
    	
    	JLabel rightPanel3_label2 = new JLabel("<html>* 회원 탈퇴를 원하신다면 아래 창에 비밀번호를 두번 입력해주세요.");
    	rightPanel3_label2.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel3_label2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
    	rightPanel3_label2.setBounds(87, 134, 440, 38);
    	rightPanel3.add(rightPanel3_label2);
    	
    	JLabel rightPanel3_label3 = new JLabel("비밀번호");
    	rightPanel3_label3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel3_label3.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel3_label3.setBounds(72, 248, 106, 15);
    	rightPanel3.add(rightPanel3_label3);
    	
    	JLabel rightPanel3_label4 = new JLabel("비밀번호 확인");
    	rightPanel3_label4.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel3_label4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel3_label4.setBounds(72, 291, 106, 15);
    	rightPanel3.add(rightPanel3_label4);
    	
    	rightPanel3_input1 = new JPasswordField();
    	rightPanel3_input1.setBounds(214, 242, 264, 27);
    	rightPanel3.add(rightPanel3_input1);
    	
    	rightPanel3_input2 = new JPasswordField();
    	rightPanel3_input2.setBounds(214, 288, 264, 27);
    	rightPanel3.add(rightPanel3_input2);
    	
    	JButton rightPanel3_button = new JButton("탈퇴하기");
    	rightPanel3_button.setBackground(Color.WHITE);
    	rightPanel3_button.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
    	rightPanel3_button.setBounds(175, 388, 264, 54);
    	rightPanel3.add(rightPanel3_button);
    	rightPanel3.setLayout(null);
    	rightPanel3.add(rightPanel3_label1);
    	rightPanel3.add(rightPanel3_label2);
    	rightPanel3.add(rightPanel3_label3);
    	rightPanel3.add(rightPanel3_label4);
    	rightPanel3.add(rightPanel3_input1);
    	rightPanel3.add(rightPanel3_input2);
    	rightPanel3.add(rightPanel3_button);
    	
    	

    }
    private view.swing.MyPagePanelBorder leftPanel;
    private JPasswordField rightPanel3_input1;
    private JPasswordField rightPanel3_input2;
    private JPasswordField rightPanel2_input1;
    private JPasswordField rightPanel2_input2;
    private JPasswordField rightPanel2_input3;
    private JTextField rightPanel1_ID;
    private JTextField rightPanel1_name;
    private JTextField rightPanel1_phone1;
    private JTextField rightPanel1_phone2;
    private JTextField rightPanel1_phone3;
}