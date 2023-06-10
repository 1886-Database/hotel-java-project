package view.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.swing.ScrollBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import model.Reservation;
import modelManager.ReservationManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;


public class Form_AdReserv extends javax.swing.JPanel {

	private Reservation[] resList;
	private ReservationManager rM;
	private Reservation res;
  
	
	//기본 생성자
    public Form_AdReserv() {
    	
    	rM = new ReservationManager();
    	initComponents();
    	
    	all();
    }
    	
    	            
    

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(20, 20, 259, 22);
        spTable = new javax.swing.JScrollPane();
        spTable.setBounds(65, 69, 750, 420);
        table = new view.swing.Table();
        
        //table row 클릭 시 reservedstatus combobox에 선택된 status 반영
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = table.getSelectedRow();
        		
        		String reservedStatus = (String)table.getModel().getValueAt(row, 7);
        		
        		setReservedStatus(reservedStatus);    		
        	}
        });
        	

        setBackground(new java.awt.Color(242, 242, 242));
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Reservation Management");
        spTable.setBorder(null);
        
        
        //table model setting
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "예약번호", "예약자", "전화번호", "방 번호", "체크인 날짜","체크아웃 날짜","예약한 날짜","처리현황"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);
        
        
        lblNewLabel_1_1_1 = new JLabel("처리현황");
        lblNewLabel_1_1_1.setBounds(65, 517, 75, 16);
        
        //reservedstatus combobox 설정
        ReserveState = new JComboBox();
        ReserveState.setModel(new DefaultComboBoxModel(new String[] {"승인", "대기", "거절"}));
        ReserveState.setBounds(131, 512, 130, 27);
        ReserveState.setSelectedIndex(-1);
        
        //edit button
        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = table.getSelectedRow();
        		String reservedStatus = (String)ReserveState.getSelectedItem();
        		
        		if(row==-1)//row 선택 안했을 때
        			JOptionPane.showMessageDialog(null,"수정할 예약현황을 먼저 선택해주세요.", "Reservation is Not Selected",2);
        		else if(table.getModel().getValueAt(row, 7).equals("취소"))
        			JOptionPane.showMessageDialog(null,"고객이 취소한 예약에 대해서는 예약 상태 변경이 불가능합니다.", "Not Allowed",2);
        		else {
        			int reservedNo =  (int)table.getModel().getValueAt(row,0);
        			int result = rM.edit(reservedNo, reservedStatus);
        			if(result==1) {
    					JOptionPane.showMessageDialog(null,"정상적으로 수정되었습니다.", "Edited",2);
        				refresh();
        				}
        			}}});	
        
        btnEdit.setBounds(301, 511, 75, 29);
        
        
        //refresh button
        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(707, 518, 76, 29);
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });

        
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
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        panelBorder1.setLayout(null);
        panelBorder1.add(jLabel1);
        panelBorder1.add(lblNewLabel_1_1_1);
        panelBorder1.add(ReserveState);
        panelBorder1.add(spTable);
        panelBorder1.add(btnEdit);
        panelBorder1.add(btnRefresh);
        
        JLabel lblNewLabel = new JLabel("* 고객의 예약 신청 내역을 확인하고, 특정 예약 신청에 대한 처리현황을 변경할 수 있습니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel.setBounds(277, 28, 548, 15);
        panelBorder1.add(lblNewLabel);
       
    
    }
    // reservation의 모든 객체 가져와 테이블에 삽입하는 메소드
  	/**
  	 * reservation의 모든 객체 가져와 테이블에 삽입하는 메소드입니다.
  	 */
    private void all() {
    	resList = rM.getReservationView();
    	for (int i = 0; i < resList.length; ++i) {
        	table.addRow(new Object[] {resList[i].getReservedNo(),resList[i].getMemberName(),resList[i].getMemberPhone(),resList[i].getRoomNo(),resList[i].getCheckIn(),resList[i].getCheckOut(),resList[i].getReservedDate(),resList[i].getReservedStatus()});
        }
    }
    
    //reservedStatus를 string으로 받아와 combobox의 index로 바꿔 reserved status를 바꿔주는 메소드
	/**
  	reservedStatus를 string으로 받아와 combobox의 index로 바꿔 reserved status를 바꿔주는 메소드
  	 */
    public void setReservedStatus(String reservedStatus) {
    	int i = -1;
    	if(reservedStatus.equals("승인"))
    		i=0;
    	else if (reservedStatus.equals("대기"))
    		i=1;
    	else if (reservedStatus.equals("거절"))
    		i=2;
    	
    	ReserveState.setSelectedIndex(i);
    	
    }
    
    //reservation 테이블 새로고침 하는 메소드
  	/**
  	 * reservation 테이블을 새로고침하여 가져오는 메소드입니다.
  	 */
    public void refresh() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();
    	model.setRowCount(0);
    	all();
    }
    
    // Variables declaration 
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JComboBox ReserveState;
    private JLabel lblNewLabel_1_1_1;
    private JButton btnEdit;
    private JButton btnRefresh;
}
