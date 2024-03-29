package DB2023188606_view.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DB2023188606_model.Reservation;
import DB2023188606_modelManager.ReservationManager;
import DB2023188606_view.event.EventMenuSelected;
import DB2023188606_view.model.Model_Menu;
import DB2023188606_view.swing.MenuItem;
import DB2023188606_view.swing.RoundedButton;
import DB2023188606_view.swing.ScrollBar;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Form_ViewMyReserv extends JPanel {

	private String loginID;
	private Reservation[] reserv;
	private ReservationManager rM;

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
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panel = new javax.swing.JLayeredPane();
		panelBorder1 = new DB2023188606_view.swing.PanelBorder();
		jLabel1 = new javax.swing.JLabel();
		spTable = new javax.swing.JScrollPane();
		table = new DB2023188606_view.swing.Table();

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

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "예약번호", "예약 객실 번호", "예약 날짜", "체크인 날짜", "체크아웃 날짜", "처리현황" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		spTable.setViewportView(table);

		// 테이블 행 더블 클릭 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					int reservedNo = (int) table.getModel().getValueAt(row, 0);
					
					JFrame popup = new JFrame();
					JPanel dPanel = new Form_ViewMyReservDetails(reservedNo);
					popup.getContentPane().add(dPanel);
					popup.setVisible(true);
					popup.setSize(840, 550);					
					popup.setLocationRelativeTo(panelBorder1);  
					popup.setResizable(false);  				
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("* 예약 내역을 더블 클릭하면 예약에 대한 상세정보를 보실 수 있습니다.");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
				button_refresh = new JButton("새로고침");
				button_refresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						refresh();
					}
				});

		javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
		panelBorder1Layout.setHorizontalGroup(
			panelBorder1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup()
					.addGap(20)
					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(spTable, Alignment.LEADING)
						.addGroup(Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
							.addComponent(jLabel1)
							.addGap(45)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(button_refresh, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panelBorder1Layout.setVerticalGroup(
			panelBorder1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup()
					.addGap(20)
					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1)
						.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addComponent(button_refresh, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
					.addGap(20))
		);
		panelBorder1.setLayout(panelBorder1Layout);

		button_cancel = new JButton("예약 취소");
		button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1)
					JOptionPane.showMessageDialog(null, "취소할 예약내역을 먼저 선택해주세요.", "Select your reservation", 2);
				else {
					String checkInDate = (String) table.getModel().getValueAt(row, 3);
					String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					int dateCheck = -1;
					try {
						Date date = new Date(dateFormat.parse(checkInDate).getTime());
						Date today = new Date(dateFormat.parse(todayfm).getTime());
						int compare = date.compareTo(today); 
						if(compare>0)
							dateCheck=1;
						else if(compare==0)
							dateCheck=0;
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
					} 
					
					if(dateCheck==1) {
						int reservedNo = (int) table.getModel().getValueAt(row, 0);
						if(rM.cancel(reservedNo)==1) {
							JOptionPane.showMessageDialog(null, "정상적으로 취소되었습니다.", "Canceled", 2);
							refresh();
						}
					}
					else if(dateCheck==0)
						JOptionPane.showMessageDialog(null, "체크인 날짜 당일에는 예약 취소가 불가합니다.", "Not Allowed", 2);
					else 
						JOptionPane.showMessageDialog(null, "이미 체크인 날짜가 지난 예약에 대해서는 취소가 불가합니다.", "Not Allowed", 2);
					
					
					
				}
			}
		});
		
		lblNewLabel = new JLabel("* 체크인 날짜 당일에는 예약 취소가 불가능합니다.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(20)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE))
					.addGap(20))
				.addGroup(layout.createSequentialGroup()
					.addGap(200)
					.addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(201, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addGap(202)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(202, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(20)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(18))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// 사용자의 예약내역 불러오기
	/**
  	 * 사용자의 예약내역을 불러와 테이블에 삽입하는 메소드입니다.
  	 */
	private void getMyReserv() {
		reserv = rM.getMyReserv(loginID);
		for (int i = 0; i < reserv.length; ++i) {
			table.addRow(new Object[] { reserv[i].getReservedNo(), reserv[i].getRoomNo(), reserv[i].getReservedDate(),
					reserv[i].getCheckIn(), reserv[i].getCheckOut(), reserv[i].getReservedStatus() });
		}
	}

	 //table refresh
		/**
	  	 * 테이블을 새로고침하여 가져오는 메소드입니다.
	  	 */
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		getMyReserv();
	}

	//선택된 테이블의 row에서 reservedNo를 가져오기
	/**
  	 * 선택된 테이블의 row에서 reservedNo를 가져오는 메소드입니다.
  	 * @return reservedNo
  	 */
	
	public int getReservedNo() {
		int row = table.getSelectedRow();
		int reservedNo = (int) table.getModel().getValueAt(row, 0);
		return reservedNo;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLayeredPane panel;
	private DB2023188606_view.swing.PanelBorder panelBorder1;
	private javax.swing.JScrollPane spTable;
	private DB2023188606_view.swing.Table table;
	private JButton button_cancel;
	private JButton button_refresh;
	private JLabel lblNewLabel;
}
