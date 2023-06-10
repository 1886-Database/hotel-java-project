package view.form;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Member;
import view.form.Form_Reservation;
import modelManager.MemberManager;
import modelManager.ReservationManager;
import modelManager.RoomManager;

//객실상세 예약 페이지
public class Form_RoomReservation extends javax.swing.JPanel {
	
	private Member mem;
	private MemberManager mM;
	private ReservationManager rsM;
	private Form_Reservation r;
	private int memberID;
	private String reserveddate = null;
	private String requirement = null;
	private String Breakfast = null;
	private String reservedstatus = null;
	private String guestno = null;
	private String roomno;
	private String checkin;
	private String checkout;
	
	
	//객실 예약 Form_Reservation 페이지에서 객실 번호, 체크인 날짜, 체크아웃 날짜, 멤버아이디 값을 가져옴.
	public Form_RoomReservation(String loginID,String[] s) {
		mM = new MemberManager();
        rsM = new ReservationManager();
        r = new Form_Reservation();
        
        roomno = s[0];
        checkin = s[1];
        checkout = s[2];
        memberID = mM.getByLoginID(loginID).getMemberID();
        
        initComponents();
    }
	
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        Title = new javax.swing.JLabel();
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(242, 242, 242));
        
        //페이지 제목
        Title.setFont(new java.awt.Font("sansserif", 1, 18));
        Title.setForeground(new java.awt.Color(127, 127, 127));
        Title.setText("Reservation");
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        
        //예약 상세 페이지에서 보여지는 객실 이미지
        ROOMIMG= new JPanel() {
        	Image background = new ImageIcon(getClass().getResource("/view/icon/더블-슈페리어룸(시티뷰)3.jpg")).getImage();
        	public void paint(Graphics g) {
        		g.drawImage(background, 0, 0, null);
        	}
        };
        ROOMIMG.setLayout(null);
        ROOMIMG.setVisible(true);
        
        //인원수 설정
        String person[] = {"1","2","3","4"};
        JComboBox PSELECT = new JComboBox(person);
        JLabel PERSON = new JLabel("인원");
        PERSON.setHorizontalAlignment(SwingConstants.CENTER);
        
        //조식신청 여부 설정
        JLabel BREAKFAST = new JLabel("조식 신청");
        BREAKFAST.setHorizontalAlignment(SwingConstants.CENTER);
        String breakfast[] = {"조식신청 안함","조식신청"};
        JComboBox BSELECT = new JComboBox(breakfast);
        
        //요청사항 설정
        JLabel REQUIREMENT = new JLabel("요청 사항");
        REQUIREMENT.setHorizontalAlignment(SwingConstants.CENTER);
        textField = new JTextField();
        textField.setColumns(10);
        
        
        /**************예약 버튼***************/
        JButton RButton = new JButton("예약하기");
        RButton.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
        		Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
        		SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        		reserveddate = fourteen_format.format(date_now);
        		requirement = textField.getText();
        		guestno = PSELECT.getSelectedItem().toString();
        		Breakfast = BSELECT.getSelectedItem().toString();
        		reservedstatus="대기";
        		
        		int ans = JOptionPane.showConfirmDialog(null, "입력한 정보대로 객실을 예약하시겠습니까?","Reserve Room",JOptionPane.YES_NO_OPTION);
    			if(ans==JOptionPane.YES_OPTION) {
    				rsM.reservation(roomno,checkin,checkout,reserveddate,requirement,Breakfast,reservedstatus,guestno);
    				JOptionPane.showMessageDialog(panelBorder1, "예약 신청이 완료되었습니다.", "done", 2);
    			}
        	
        	}
        });
        
        
        //레이아웃
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(ROOMIMG, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(REQUIREMENT, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        						.addComponent(PERSON, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        						.addComponent(BREAKFAST, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addGap(59)
        							.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(panelBorder1Layout.createSequentialGroup()
        									.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(BSELECT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        										.addComponent(PSELECT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        									.addGap(91))
        								.addComponent(RButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addGap(42)
        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
        					.addGap(53))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(Title)
        					.addContainerGap(723, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(Title)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(53)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(PERSON, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(PSELECT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(BREAKFAST, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(BSELECT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(26)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(REQUIREMENT, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        					.addGap(33)
        					.addComponent(RButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(16)
        					.addComponent(ROOMIMG, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        panelBorder1.setLayout(panelBorder1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }
    
    // Variables declaration
    private javax.swing.JLabel Title;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private JPanel ROOMIMG;
    private JTextField textField;
}
