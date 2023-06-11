package DB2023188606_view.form;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DB2023188606_model.ReservedRoom;
import DB2023188606_modelManager.ReservedRoomManager;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Component;

public class Form_ViewMyReservDetails extends JPanel {

	private ReservedRoom rR;
	private ReservedRoomManager rRM;
	
	public Form_ViewMyReservDetails(int reservedNo) {
		
		rRM = new ReservedRoomManager();
		rR = rRM.getByReservedNo(reservedNo);
		
		initComponents();

	}

	private void initComponents() {
		setBackground(new java.awt.Color(242, 242, 242));
		panel = new javax.swing.JLayeredPane();
        panelBorder1 = new DB2023188606_view.swing.PanelBorder();
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        add(panel);
        add(panelBorder1);
        
        label_title = new JLabel("Reservation Details");
        label_title.setForeground(Color.GRAY);
        label_title.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JPanel panel_img = new JPanel(){
        	Image background = new ImageIcon(getClass().getResource("/DB2023188606_view/icon/호텔썸네일.jpg")).getImage();
        	public void paint(Graphics g) {
        		g.drawImage(background, 0, 0, null);
        	}
        };
        
        label_roomNameValue = new JLabel(rR.getRoomName());
        label_roomNameValue.setForeground(Color.DARK_GRAY);
        label_roomNameValue.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 15));
        
        label_roomTypeValue = new JLabel(rR.getRoomType());
        label_roomTypeValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_bedType = new JLabel("침대 타입");
        label_bedType.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_bedTypeValue = new JLabel(rR.getBedType());
        label_bedTypeValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        JLabel label_seperator = new JLabel("/");
        label_seperator.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel label_capacity = new JLabel("수용 인원");
        label_capacity.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        JLabel label_capacityValue = new JLabel(String.valueOf(rR.getCapacity())+" 명");
        label_capacityValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        JLabel label_reservNo = new JLabel("예약 번호");
        label_reservNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        JLabel label_reservDate = new JLabel("예약 날짜");
        label_reservDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_checkDate = new JLabel("숙박 기간");
        label_checkDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservGuest = new JLabel("숙박 인원");
        label_reservGuest.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservBreakfast = new JLabel("조식 신청 여부");
        label_reservBreakfast.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_message = new JLabel("요구사항");
        label_message.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        JTextArea textArea = new JTextArea();
        textArea.setEnabled(false);
        textArea.setEditable(false);
        textArea.setText(rR.getRequirement());
        
        label_roomNo = new JLabel(String.valueOf(rR.getRoomNo())+" 호");
        label_roomNo.setForeground(Color.DARK_GRAY);
        label_roomNo.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
        
        label_roomSize = new JLabel("객실 면적");
        label_roomSize.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_seperator_1 = new JLabel("/");
        label_seperator_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        String roomsize = String.valueOf(rR.getRoomSize())+"㎡ ";
        
        label_roomSizeValue = new JLabel(roomsize);
        label_roomSizeValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservNoValue = new JLabel(String.valueOf(rR.getReservedNo()));
        label_reservNoValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservDateValue = new JLabel(rR.getReservedDate());
        label_reservDateValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        
        label_checkDateValue = new JLabel(rR.getCheckIn()+" ~ "+rR.getCheckOut());
        label_checkDateValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservGuestValue = new JLabel(String.valueOf(rR.getGusetNo())+" 명");
        label_reservGuestValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        
        label_reservBreakfastValue = new JLabel(rR.getBreakfast());
        label_reservBreakfastValue.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(51)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_title, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(label_roomNameValue, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(label_roomNo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(label_bedType, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(label_bedTypeValue, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(label_seperator_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(label_roomSize, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(label_roomSizeValue))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(label_roomTypeValue, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(label_seperator, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(label_capacity)
        					.addGap(18)
        					.addComponent(label_capacityValue, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
        			.addGap(55)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(label_reservNo, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        						.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(label_reservBreakfast, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(label_reservGuest, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(label_checkDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(label_reservDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
        					.addGap(41)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(label_reservBreakfastValue, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_reservGuestValue, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_reservDateValue, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_reservNoValue, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_checkDateValue, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        				.addComponent(label_message))
        			.addGap(25))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(33)
        					.addComponent(label_title)
        					.addGap(26)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_reservNo)
        						.addComponent(label_reservNoValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(26)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_reservDate)
        						.addComponent(label_reservDateValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_checkDate)
        						.addComponent(label_checkDateValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(28)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_reservGuest)
        						.addComponent(label_reservGuestValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(27)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_reservBreakfast)
        						.addComponent(label_reservBreakfastValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
        					.addComponent(label_message)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(85)
        					.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        					.addGap(28)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(label_roomNameValue)
        						.addComponent(label_roomNo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_roomTypeValue, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_seperator)
        						.addComponent(label_capacity)
        						.addComponent(label_capacityValue))
        					.addGap(18)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label_bedType)
        						.addComponent(label_bedTypeValue, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_seperator_1)
        						.addComponent(label_roomSize)
        						.addComponent(label_roomSizeValue))))
        			.addGap(30))
        );
        panelBorder1.setLayout(panelBorder1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panelBorder1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
        			.addGap(20))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(35))
        );
        this.setLayout(layout);

	}
	
	private javax.swing.JLayeredPane panel;
    private DB2023188606_view.swing.PanelBorder panelBorder1;
    private JLabel label_title;
    private JLabel label_roomNameValue;
    private JLabel label_roomTypeValue;
    private JLabel label_bedType;
    private JLabel label_bedTypeValue;
    private JLabel label_checkDate;
    private JLabel label_reservGuest;
    private JLabel label_reservBreakfast;
    private JLabel label_message;
    private JLabel label_roomNo;
    private JLabel label_roomSize;
    private JLabel label_seperator_1;
    private JLabel label_roomSizeValue;
    private JLabel label_reservNoValue;
    private JLabel label_reservDateValue;
    private JLabel label_checkDateValue;
    private JLabel label_reservGuestValue;
    private JLabel label_reservBreakfastValue;
}