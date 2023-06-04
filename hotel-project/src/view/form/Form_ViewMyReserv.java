package view.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

import model.Reservation;
import modelManager.ReservationManager;

import javax.swing.JScrollPane;
import view.model.StatusType;
import view.swing.ScrollBar;

import view.event.EventMenuSelected;
import view.model.Model_Menu;
import view.swing.MenuItem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import view.swing.RoundedButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Form_ViewMyReserv extends JPanel {

    private String loginID;
    private Reservation[] reserv;
    private ReservationManager rM;
    private JButton button1 = new JButton("Button");
    
    public Form_ViewMyReserv(String id) {
    	
    	loginID = id;
    	
    	rM = new ReservationManager();
        initComponents();
        
        getMyReserv();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Reservation History");

        spTable.setBorder(null);
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "예약번호", "예약 객실 번호", "예약 날짜", "체크인 날짜", "체크아웃 날짜", "처리현황"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        spTable.setViewportView(table);
        
      //테이블 행을 클릭하면 해당 행의 정보가 옆의 박스에 자동 입력되도록 하는 이벤트 리스너
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount()==2) {
        			JOptionPane.showMessageDialog(null,"test.", "Select your reservation",2);
        			button1.doClick();
        		}
        	}
        });
        
        
        
        JLabel lblNewLabel_1 = new JLabel("* 예약 내역을 더블 클릭하면 예약에 대한 상세정보를 보실 수 있습니다.");
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(45)
        					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))
        				.addComponent(spTable))
        			.addGap(24))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        			.addGap(20))
        );
        panelBorder1.setLayout(panelBorder1Layout);
        
        button_cancel = new JButton("예약 취소");
        button_cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = table.getSelectedRow();
    			if(row==-1)
    				JOptionPane.showMessageDialog(null,"취소할 예약내역을 먼저 선택해주세요.", "Select your reservation",2);
    			else {
    				
    			}
        	}
        });
        
        JLabel lblNewLabel = new JLabel("* 체크인 날짜로부터 3일 이전에만 예약 취소가 가능합니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        button_refresh = new JButton("새로고침");
        button_refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE))
        			.addGap(20))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(59)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 830, Short.MAX_VALUE)
        			.addGap(58))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(150)
        			.addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
        			.addGap(43)
        			.addComponent(button_refresh, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(button_refresh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(lblNewLabel)
        			.addGap(16))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents
    
    //사용자의 예약내역 불러오기
    private void getMyReserv() {
    	reserv = rM.getMyReserv(loginID);
    	for (int i = 0; i < reserv.length; ++i) {
			table.addRow(new Object[] {reserv[i].getReservedNo(),reserv[i].getRoomNo(),reserv[i].getReservedDate(),reserv[i].getCheckIn(),reserv[i].getCheckOut(),reserv[i].getReservedStatus()});
		}
    }
    
    private void refresh() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();
    	model.setRowCount(0);
    	getMyReserv();
    }
    
    public void addButton1ActionListener(ActionListener listener) {
        button1.addActionListener(listener);
     }
    public String getReservedNo() {
    	int row = table.getSelectedRow();
    	String reservedNo = (String) table.getModel().getValueAt(row, 0 );
    	return reservedNo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JButton button_cancel;
    private JButton button_refresh;
}
