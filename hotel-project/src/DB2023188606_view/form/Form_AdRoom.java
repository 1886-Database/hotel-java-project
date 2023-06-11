package DB2023188606_view.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import DB2023188606_model.Member;
import DB2023188606_model.Room;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_modelManager.RoomManager;
import DB2023188606_view.swing.ScrollBar;

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
        panelBorder1 = new DB2023188606_view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new DB2023188606_view.swing.Table();

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
        
        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        spTable.setBorder(null);

        //객실 테이블 정보 설정
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "객실 번호", "배드 타입", "수용 인원", "가격", "객실 타입", "객실 사이즈", "객실 이름","금연","주차"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false,false,false
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
        
        lblNewLabel = new JLabel("* 이화호텔에 존재하는 모든 객실 정보를 확인 가능합니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

        //레이아웃 설정
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(spTable, Alignment.TRAILING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
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
        			.addComponent(spTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
    //객실 테이블에 객실정보 가져와 행 추가
	/**
  	 * room의 모든 객체 가져와 테이블에 삽입하는 메소드입니다.
  	 */
    private void all() {
        room= rM.getAllRoom();
        for (int i = 0; i < room.length; ++i) {
        	
          table.addRow(new Object[] {room[i].getRoomNo(),room[i].getBedType(),room[i].getCapacity(),room[i].getPrice(),room[i].getRoomType(),room[i].getRoomSize(),room[i].getRoomName(),room[i].getNonSmoking(),room[i].getParking()});
       }
        for (int i = 0; i < table.getRowCount(); ++i) {
            if (table.getModel().getValueAt(i, 7).equals(true))
               table.getModel().setValueAt("금연", i, 7);
            else
               table.getModel().setValueAt("흡연 가능", i, 7);
            if (table.getModel().getValueAt(i, 7).equals(true))
               table.getModel().setValueAt("가능", i, 8);
            else
               table.getModel().setValueAt("불가능", i, 8);
         }
     }
    
    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private DB2023188606_view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private DB2023188606_view.swing.Table table;
    private JLabel lblNewLabel;
}
