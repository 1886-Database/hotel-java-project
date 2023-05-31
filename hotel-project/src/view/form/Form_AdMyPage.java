package view.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Employee;
import modelManager.EmployeeManager;
import view.swing.MyPagePanelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Form_AdMyPage extends JPanel {


	//생성자
    public Form_AdMyPage(String loginID) {
    	employeeManager= new EmployeeManager();
    	Employee employee=employeeManager.getByLoginID(loginID);
        initComponents(employee);

    
    }
    
    public void initComponents(Employee emp) {
    	setBackground(new java.awt.Color(242, 242, 242));
    	setLayout(null);
    	
    	//좌측 패널 ***********************************************************************
    	
    	leftPanel = new view.swing.MyPagePanelBorder();
    	leftPanel.setLocation(26, 73);
    	leftPanel.setSize(224, 500);
    	leftPanel.setBackground(new java.awt.Color(255, 255, 255));
    	add(leftPanel);
    	
    	//우측 패널 (1:내 정보 패널 / 2:비밀번호 변경 패널) ***********************
    	
    	MyPagePanelBorder rightPanel1 = new MyPagePanelBorder();
    	rightPanel1.setBackground(Color.WHITE);
    	rightPanel1.setBounds(295, 73, 615, 500);
    	add(rightPanel1);
    	rightPanel1.setLayout(null);
    	
    	MyPagePanelBorder rightPanel2 = new MyPagePanelBorder();
    	rightPanel2.setBackground(Color.WHITE);
    	rightPanel2.setBounds(295, 73, 615, 500);
    	add(rightPanel2);
    	
    	JSeparator leftPanel_seperator = new JSeparator();
    	leftPanel_seperator.setBounds(25, 240, 180, 10);
    	leftPanel.add(leftPanel_seperator);
    	
    	//좌측 패널 컴포넌트 ***********************************************************************************************
    	
    	JLabel leftPanel_userImg = new JLabel("");
    	leftPanel_userImg.setBounds(59, 48, 100, 100);
    	leftPanel_userImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/admin.png")));
    	leftPanel.add(leftPanel_userImg);
    	
    	JLabel leftPanel_userName = new JLabel(emp.getName());
    	leftPanel_userName.setHorizontalAlignment(SwingConstants.CENTER);
    	leftPanel_userName.setForeground(new Color(47, 79, 79));
    	leftPanel_userName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    	leftPanel_userName.setBounds(43, 158, 94, 31);
    	leftPanel.add(leftPanel_userName);
    	
    	JLabel leftPanel_label1 = new JLabel("님");
    	leftPanel_label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    	leftPanel_label1.setBounds(135, 158, 37, 31);
    	leftPanel.add(leftPanel_label1);
    	
    	JLabel leftPanel_label2 = new JLabel("부서");
    	leftPanel_label2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    	leftPanel_label2.setBounds(135, 199, 37, 15);
    	leftPanel.add(leftPanel_label2);
    	
    	JLabel leftPanel_userGrade = new JLabel(emp.getDepartment());
    	leftPanel_userGrade.setHorizontalAlignment(SwingConstants.CENTER);
    	leftPanel_userGrade.setFont(new Font("맑은 고딕", Font.BOLD, 14));
    	leftPanel_userGrade.setBounds(43, 199, 89, 15);
    	leftPanel.add(leftPanel_userGrade);
    	
    	JButton leftPanel_button1 = new JButton("내 정보");
    	leftPanel_button1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
    	leftPanel_button1.setBackground(Color.WHITE);
    	leftPanel_button1.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			rightPanel1.setVisible(true);
    			rightPanel2.setVisible(false);
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
    		}
    	});
    	leftPanel_button2.setBounds(25, 343, 180, 50);
    	leftPanel.add(leftPanel_button2);
    	leftPanel.setLayout(null);
    	leftPanel.add(leftPanel_userImg);
    	leftPanel.add(leftPanel_userName);
    	leftPanel.add(leftPanel_label1);
    	leftPanel.add(leftPanel_label2);
    	leftPanel.add(leftPanel_userGrade);
    	leftPanel.add(leftPanel_button1);
    	leftPanel.add(leftPanel_button2);
    	
    	
    	//구분선
    	JSeparator verticalSeparator = new JSeparator();
    	verticalSeparator.setOrientation(SwingConstants.VERTICAL);
    	verticalSeparator.setBounds(273, 73, 10, 500);
    	add(verticalSeparator);
    	
    	//우측 패널 : 내 정보 보기 패널 컴포넌트******************************************************************************
    	
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
    	rightPanel1_label4.setBounds(94, 285, 66, 15);
    	rightPanel1.add(rightPanel1_label4);
    	
    	JLabel rightPanel1_label5 = new JLabel("생일");
    	rightPanel1_label5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    	rightPanel1_label5.setBounds(122, 365, 34, 15);
    	rightPanel1.add(rightPanel1_label5);
    	
    	rightPanel1_ID = new JTextField();
    	rightPanel1_ID.setText(emp.getLoginID());
    	rightPanel1_ID.setBackground(Color.WHITE);
    	rightPanel1_ID.setEditable(false);
    	rightPanel1_ID.setEnabled(false);
    	rightPanel1_ID.setBounds(189, 199, 96, 24);
    	rightPanel1.add(rightPanel1_ID);
    	rightPanel1_ID.setColumns(10);
    	
    	rightPanel1_name = new JTextField();
    	rightPanel1_name.setText(emp.getName());
    	rightPanel1_name.setBackground(Color.WHITE);
    	rightPanel1_name.setEnabled(false);
    	rightPanel1_name.setEditable(false);
    	rightPanel1_name.setColumns(10);
    	rightPanel1_name.setBounds(394, 199, 96, 25);
    	rightPanel1.add(rightPanel1_name);
    	
    	String phone=emp.getPhone();
    	String phone1=phone.substring(0, 3);
    	String phone2=phone.substring(4, 8);
    	String phone3=phone.substring(9, 13);
    	
    	rightPanel1_phone1 = new JTextField();
    	rightPanel1_phone1.setText(phone1);
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
    	rightPanel1_phone2.setText(phone2);
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
    	rightPanel1_phone3.setText(phone3);
    	rightPanel1_phone3.setEditable(false);
    	rightPanel1_phone3.setEnabled(false);
    	rightPanel1_phone3.setColumns(10);
    	rightPanel1_phone3.setBackground(Color.WHITE);
    	rightPanel1_phone3.setBounds(426, 281, 66, 25);
    	rightPanel1.add(rightPanel1_phone3);
    	
    	
    	
    	JLabel rightPanel1_label5_1 = new JLabel("년");
    	rightPanel1_label5_1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_1.setBounds(274, 365, 19, 15);
    	rightPanel1.add(rightPanel1_label5_1);
    	
    	JLabel rightPanel1_label5_2 = new JLabel("월");
    	rightPanel1_label5_2.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_2.setBounds(395, 365, 19, 15);
    	rightPanel1.add(rightPanel1_label5_2);
    	
    	JLabel rightPanel1_label5_3 = new JLabel("일");
    	rightPanel1_label5_3.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel1_label5_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
    	rightPanel1_label5_3.setBounds(516, 365, 19, 15);
    	rightPanel1.add(rightPanel1_label5_3);
    	
    	String birthDate=emp.getBirthDate();
    	String birthYear=birthDate.substring(0, 4);
    	String birthMonth=birthDate.substring(5, 7);
    	String birthDay=birthDate.substring(8, 10);
    	
    	rightPanel1_birthYear = new JTextField();
    	rightPanel1_birthYear.setText(birthYear);
    	rightPanel1_birthYear.setEnabled(false);
    	rightPanel1_birthYear.setEditable(false);
    	rightPanel1_birthYear.setColumns(10);
    	rightPanel1_birthYear.setBackground(Color.WHITE);
    	rightPanel1_birthYear.setBounds(196, 360, 66, 25);
    	rightPanel1.add(rightPanel1_birthYear);
    	
    	rightPanel1_bithMonth = new JTextField();
    	rightPanel1_bithMonth.setText(birthMonth);
    	rightPanel1_bithMonth.setEnabled(false);
    	rightPanel1_bithMonth.setEditable(false);
    	rightPanel1_bithMonth.setColumns(10);
    	rightPanel1_bithMonth.setBackground(Color.WHITE);
    	rightPanel1_bithMonth.setBounds(316, 360, 66, 25);
    	rightPanel1.add(rightPanel1_bithMonth);
    	
    	rightPanel1_birthDay = new JTextField();
    	rightPanel1_birthDay.setText(birthDay);
    	rightPanel1_birthDay.setEnabled(false);
    	rightPanel1_birthDay.setEditable(false);
    	rightPanel1_birthDay.setColumns(10);
    	rightPanel1_birthDay.setBackground(Color.WHITE);
    	rightPanel1_birthDay.setBounds(436, 360, 66, 25);
    	rightPanel1.add(rightPanel1_birthDay);
    	
    	//우측 패널 : 비밀번호 변경 패널 컴포넌트 ******************************************************************************
    	
    	JLabel rightPanel2_label1 = new JLabel("비밀번호 변경");
    	rightPanel2_label1.setHorizontalAlignment(SwingConstants.CENTER);
    	rightPanel2_label1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
    	rightPanel2_label1.setBounds(189, 49, 237, 54);
    	rightPanel2.add(rightPanel2_label1);
    	rightPanel2.add(rightPanel2_label1);
    	
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
    	
       	JButton rightPanel2_button1 = new JButton("변경하기");
    	rightPanel2_button1.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			String oldPassword=String.valueOf(rightPanel2_input1.getPassword());
    			String newPassword=String.valueOf(rightPanel2_input2.getPassword());
    			String newPassword2 = String.valueOf(rightPanel2_input3.getPassword());
    			if(oldPassword.trim().equals("")) {
    				JOptionPane.showMessageDialog(rightPanel2,"현재 비밀번호를 입력해주세요.", "Empty current password",2);
    			}else if(newPassword.trim().equals("")) {
    				JOptionPane.showMessageDialog(rightPanel2,"새롭게 변경할 비밀번호를 입력해주세요.", "Empty new password",2);
    			}else if(!(newPassword.equals(newPassword2))) {
    				JOptionPane.showMessageDialog(rightPanel2,"새로 변경할 비밀번호를 다시 확인해주세요.", "Re-check your new pw",2);
    			}else {
    				if(!(oldPassword.equals(emp.getPassword()))) {
    					JOptionPane.showMessageDialog(rightPanel2,"현재 비밀번호가 틀렸습니다.", "Wrong current password",2);
    				}else {
    					try {
    						emp.setPassword(newPassword);
    						employeeManager.passwordChange(emp.getLoginID(), newPassword);
    						JOptionPane.showMessageDialog(rightPanel2,"비밀번호가 정상적으로 변경됐습니다.", "Change done",2);
    						rightPanel2_input1.setText("");
    						rightPanel2_input2.setText("");
    						rightPanel2_input3.setText("");
    						
    					}catch(Exception ex) {
    						JOptionPane.showMessageDialog(rightPanel2,"에러 발생", "exception error",2);
    					}
    				}
    			}
    		}
    	});
    	rightPanel2_button1.setBackground(Color.WHITE);
    	rightPanel2_button1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
    	rightPanel2_button1.setBounds(175, 388, 264, 54);
    	rightPanel2.add(rightPanel2_button1);
    	

    }
    private view.swing.MyPagePanelBorder leftPanel;
    private JPasswordField rightPanel2_input1;
    private JPasswordField rightPanel2_input2;
    private JPasswordField rightPanel2_input3;
    private JTextField rightPanel1_ID;
    private JTextField rightPanel1_name;
    private JTextField rightPanel1_phone1;
    private JTextField rightPanel1_phone2;
    private JTextField rightPanel1_phone3;
    private modelManager.EmployeeManager employeeManager;
    private JTextField rightPanel1_birthYear;
    private JTextField rightPanel1_bithMonth;
    private JTextField rightPanel1_birthDay;

}
