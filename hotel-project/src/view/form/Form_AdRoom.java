package view.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.model.StatusType;
import view.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.model.StatusType;
import view.swing.ScrollBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import model.Member;
import model.Room;
import modelManager.MemberManager;
import modelManager.RoomManager;

import javax.swing.JButton;
import java.awt.Font;

//객실 관리 페이지
public class Form_AdRoom extends javax.swing.JPanel {

	private Room[] room;
	private RoomManager rM;
    /**
     * Creates new form Form_AdRoom (객실 관리)
     */
    public Form_AdRoom() {
        initComponents();
        rM = new RoomManager();
		
        //전체 객실리스트 호출
		all();
    
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        
        //객실 테이블 설정
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        //테이블 행을 클릭하면 해당 행의 정보가 옆의 박스에 자동 입력되도록 하는 이벤트 리스너
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = table.getSelectedRow();
                String roomno = String.valueOf(table.getModel().getValueAt(row, 0 ));
                String bedtype = (String) table.getModel().getValueAt(row, 1 );
                String capacity = String.valueOf(table.getModel().getValueAt(row, 2 ));
                String price = String.valueOf(table.getModel().getValueAt(row, 3 ));
                String roomtype = String.valueOf(table.getModel().getValueAt(row, 4 ));
                String roomsize = String.valueOf(table.getModel().getValueAt(row, 5 ));
                String roomname = String.valueOf(table.getModel().getValueAt(row, 6 ));
               
                
        		setInputText(roomno,bedtype,capacity,price,roomtype,roomsize,roomname);

        	}
        });
        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        spTable.setBorder(null);

        //객실 테이블 정보 설정
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "객실 번호", "배드 타입", "수용 인원", "가격", "객실 타입", "객실 사이즈", "객실 이름"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);
        
        
        //페이지 제목
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Room Management");
        
        //왼쪽 박스에 표시될 객실정보이름
        JLabel Label_bedtype = new JLabel("배드 타입");
        JLabel Label_capacity = new JLabel("수용 인원");
        JLabel Label_roomno = new JLabel("객실 번호");
        JLabel Label_price = new JLabel("가격");
        JLabel Label_roomtype = new JLabel("객실 타입");
        JLabel Label_roomsize = new JLabel("객실 사이즈");
        JLabel Label_roomname = new JLabel("객실 이름");
        
        //왼쪽 박스에 표시될 객실정보
        input_bedtype = new JTextField();
        input_bedtype.setColumns(10);
        input_roomno = new JTextField();
        input_roomno.setColumns(10);
        input_capacity = new JTextField();
        input_capacity.setColumns(10);
        input_price = new JTextField();
        input_price.setColumns(10);
        input_roomtype = new JTextField();
        input_roomtype.setColumns(10);
        input_roomsize = new JTextField();
        input_roomsize.setColumns(10);
        input_roomname = new JTextField();
        input_roomname.setColumns(10);
        
        lblNewLabel = new JLabel("* 이화호텔에 존재하는 모든 객실 정보를 확인 가능합니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

        //레이아웃 설정
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(36)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(Label_roomtype)
        						.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(panelBorder1Layout.createSequentialGroup()
        								.addComponent(Label_roomname)
        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(input_roomname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGroup(panelBorder1Layout.createSequentialGroup()
        								.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(Label_roomno)
        									.addComponent(Label_bedtype)
        									.addComponent(Label_capacity)
        									.addComponent(Label_roomsize))
        								.addGap(51)
        								.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(input_roomsize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(input_capacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(input_bedtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(input_roomno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(input_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(input_roomtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        						.addComponent(Label_price))
        					.addGap(45)
        					.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(19)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(lblNewLabel))
        			.addGap(27)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(spTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Label_roomno)
        						.addComponent(input_roomno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Label_bedtype)
        						.addComponent(input_bedtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(43)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Label_capacity)
        						.addComponent(input_capacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(21)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Label_price)
        						.addComponent(input_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(37)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Label_roomtype)
        						.addComponent(input_roomtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addGap(90)
        							.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(Label_roomname)
        								.addComponent(input_roomname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addGap(35)
        							.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(Label_roomsize)
        								.addComponent(input_roomsize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        					.addGap(132))))
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
    
    //왼쪽 박스에 표시될 객실정보
    private void setInputText(String roomno,String bedtype, String capacity, String price, String roomtype, String roomsize,String roomname) {
    	

    	input_roomno.setText(roomno);
    	input_bedtype.setText(bedtype);
    	input_capacity.setText(capacity);
    	input_price.setText(price);
    	input_roomtype.setText(roomtype);
    	input_roomsize.setText(roomsize);
    	input_roomname.setText(roomname);
    }

    //객실 테이블에 객실정보 가져와 행 추가
    private void all() {
        room= rM.getAllRoom();
        for (int i = 0; i < room.length; ++i) {
          table.addRow(new Object[] {room[i].getRoomNo(),room[i].getBedType(),room[i].getCapacity(),room[i].getPrice(),room[i].getRoomType(),room[i].getRoomSize(),room[i].getRoomName()});
       }
     }
    
    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JTextField input_bedtype;
    private JTextField input_roomno;
    private JTextField input_capacity;
    private JTextField input_price;
    private JTextField input_roomtype;
    private JTextField input_roomsize;
    private JTextField input_roomname;
    private JLabel lblNewLabel;
}
