/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form;

import java.awt.*;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Image;

import javax.swing.*;

import model.Room;
import modelManager.RoomManager;
import modelManager.MemberManager;
import modelManager.ReservationManager;
import view.UI.MemberMain;
import view.UI.SignUp;
import view.form.Form_RoomReservation;

import view.model.StatusType;
import view.swing.ScrollBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//객실 예약 페이지
public class Form_Reservation extends javax.swing.JPanel {

	private Room[] room;
	private RoomManager rM;
	private ReservationManager rsM;
	private Form_RoomReservation rr;
	private JButton button1 = new JButton("Button");
	private String checkin = null;
	private String checkout = null;

	public String[] dataArr() {
		int row = table.getSelectedRow();
		String roomnO = String.valueOf(table.getModel().getValueAt(row, 0));
		String roomno = roomnO;
		String[] arr = { roomno, checkin, checkout };
		for (int i = 0; i < arr.length; ++i)
			System.out.println("dataArr: " + arr[i]);
		return arr;
	}

	public Form_Reservation() {
		initComponents();
		rM = new RoomManager();
		add(button1);
		all();
	}

	@SuppressWarnings("unchecked")
	public void initComponents() {
		panel = new javax.swing.JLayeredPane();
		panelBorder1 = new view.swing.PanelBorder();
		Title = new javax.swing.JLabel();
		spTable = new javax.swing.JScrollPane();
		table = new view.swing.Table();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
		panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
		setBackground(new java.awt.Color(242, 242, 242));

		//페이지 제목
		Title.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		Title.setForeground(new java.awt.Color(127, 127, 127));
		Title.setText("Reservation");

		//체크인, 체크아웃 설정
		JLabel Label_checkin = new JLabel("체크인 날짜");
		Label_checkin.setHorizontalAlignment(SwingConstants.CENTER);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(new Date(System.currentTimeMillis())); // 오늘 날짜 이후로만 선택이 가능

		Label_checkout = new JLabel("체크아웃 날짜");
		Label_checkout.setHorizontalAlignment(SwingConstants.CENTER);
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setMinSelectableDate(new Date(System.currentTimeMillis())); // 오늘 날짜 이후로만 선택이 가능

		//체크인, 체크아웃 설정 후 예약 가능한 객실만을 보여주기 위한 적용 버튼
		JButton btn_apply = new JButton("적용");
		btn_apply.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//체크인, 체크아웃 날짜 형태 변환
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				checkin = simpleDateFormat.format(dateChooser.getDate());
				checkout = simpleDateFormat.format(dateChooser_1.getDate());
				int result = dateChooser.getDate().compareTo(dateChooser_1.getDate());
				if (result > 0) {
					JOptionPane.showMessageDialog(panelBorder1, "체크아웃 날짜가 잘못되었습니다", "CheckOut Error", 2);
				} else if (checkin.equals(checkout)) {
					JOptionPane.showMessageDialog(panelBorder1, "동일한 날짜로 예약이 불가합니다", "Date Error", 2);
				} else {
					RoomManager roomManager = new RoomManager();
					System.out.println("검색 성공");
					//날짜에 따라 필터링된 객실리스트
					refreshroom(checkin, checkout);
				}
			}
		});

		// 테이블 행 클릭 시 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkin == null || checkout == null)
					JOptionPane.showMessageDialog(panelBorder1, "체크인 날짜와 체크아웃 날짜를 먼저 선택해주세요.", "Date Not Selected", 2);
				else
					button1.doClick();
			}
		});
		
		//객실 테이블 설정
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spTable.setVerticalScrollBar(new ScrollBar());
		spTable.getVerticalScrollBar().setBackground(Color.WHITE);
		spTable.getViewport().setBackground(Color.WHITE);
		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
		spTable.setBorder(null);
		
		//객실 테이블 정보 설정
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ROOM NO", "ROOM NAME", "ROOM TYPE", "BED TYPE", "PRICE" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		spTable.setViewportView(table);

		//예약에 대한 설명
		Label_info = new JLabel("* 체크인 날짜와 체크아웃 날짜를 먼저 선택 후 예약할 방을 선택해주세요.");
		Label_info.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		//체크인, 체크아웃, 객실리스트 초기화 버튼
		btn_clear = new JButton("초기화");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser.setDate(null);
				dateChooser_1.setDate(null);
				all();
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
							.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(panelBorder1Layout.createSequentialGroup()
									.addGap(11)
									.addComponent(Label_checkin, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addComponent(Title))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(Label_info, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
								.addGroup(panelBorder1Layout.createSequentialGroup()
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(Label_checkout, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(btn_apply)
									.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
									.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(15))))
						.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
					.addGap(20))
		);
		panelBorder1Layout.setVerticalGroup(
			panelBorder1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup()
					.addGap(20)
					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Title)
						.addComponent(Label_info))
					.addGap(26)
					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(Label_checkin, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_apply, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btn_clear))
						.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(Label_checkout, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelBorder1.setLayout(panelBorder1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
						.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20).addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(20, 20, 20)));

	}

	// 체크인, 체크아웃 기준으로 예약 가능한 객실 리스트 반환
	private void refreshroom(String checkin, String checkout) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		room = rM.getRefreshRoom(checkin, checkout);
		for (int i = 0; i < room.length; ++i) {
			table.addRow(new Object[] { room[i].getRoomNo(), room[i].getRoomName(), room[i].getRoomType(),
					room[i].getBedType(), room[i].getPrice() });
		}
	}

	// 전체 객실 리스트 반환
	private void all() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		room = rM.getAllRoom();
		for (int i = 0; i < room.length; ++i) {
			table.addRow(new Object[] { room[i].getRoomNo(), room[i].getRoomName(), room[i].getRoomType(),
					room[i].getBedType(), room[i].getPrice() });
		}

	}

	public void addButton1ActionListener(ActionListener listener) {
		button1.addActionListener(listener);
	}

	// Variables declaration
	private javax.swing.JLabel Title;
	private javax.swing.JLayeredPane panel;
	private view.swing.PanelBorder panelBorder1;
	private javax.swing.JScrollPane spTable;
	private view.swing.Table table;
	private JLabel Label_checkout;
	private JLabel Label_info;
	private JButton btn_clear;
}
