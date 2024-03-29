package DB2023188606_view.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import DB2023188606_model.Member;
import DB2023188606_model.Message;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_modelManager.MessageManager;
import DB2023188606_view.UI.Login;
import DB2023188606_view.swing.ScrollBar;

import javax.swing.JButton;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form_EmployeeMsg extends javax.swing.JPanel {

	private Message[] mess;
	private MessageManager mM;
	private MemberManager member;
	private int employeeID;

	public Form_EmployeeMsg(int EmployeeID) {
		this.employeeID = EmployeeID;
		mM = new MessageManager();
		member = new MemberManager();
		initComponents();

		sent();
		recieved();

	}

	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panel = new javax.swing.JLayeredPane();
		panelBorder1 = new DB2023188606_view.swing.PanelBorder();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(52, 44, 121, 22);
		sentmessage = new javax.swing.JScrollPane();
		sentmessage.setBounds(428, 79, 366, 202);
		recievemessage = new JScrollPane();
		recievemessage.setBounds(52, 79, 353, 416);

		table = new DB2023188606_view.swing.Table();
		table_1 = new DB2023188606_view.swing.Table();

		setBackground(new java.awt.Color(242, 242, 242));

		panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

		panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("맑은 고딕 ", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(127, 127, 127));
		jLabel1.setText("받은 메시지");

		sentmessage.setBorder(null);

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "보낸 시간", "수신자", "메시지" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		// 테이블 행 클릭 시 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				recieverIDtxt.setText((String) table.getModel().getValueAt(row, 1));
			}
		});

		sentmessage.setViewportView(table);

		sentmessage.setVerticalScrollBar(new ScrollBar());
		sentmessage.getVerticalScrollBar().setBackground(Color.WHITE);
		sentmessage.getViewport().setBackground(Color.WHITE);

		recievemessage.setVerticalScrollBar(new ScrollBar());
		recievemessage.getVerticalScrollBar().setBackground(Color.WHITE);
		recievemessage.getViewport().setBackground(Color.WHITE);

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		sentmessage.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
		panelBorder1.setLayout(null);
		panelBorder1.add(recievemessage);
		panelBorder1.add(jLabel1);
		panelBorder1.add(sentmessage);

		JLabel jLabel1_1 = new JLabel();
		jLabel1_1.setText("보낸 메시지");
		jLabel1_1.setForeground(new Color(127, 127, 127));
		jLabel1_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jLabel1_1.setBounds(428, 44, 121, 22);
		panelBorder1.add(jLabel1_1);

		messagetxt = new JTextField();
		messagetxt.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		messagetxt.setBounds(428, 378, 366, 100);
		panelBorder1.add(messagetxt);
		messagetxt.setColumns(10);

		recieverIDtxt = new JTextField();
		recieverIDtxt.setBounds(530, 315, 130, 26);
		panelBorder1.add(recieverIDtxt);
		recieverIDtxt.setColumns(10);

		JButton btnNewButton = new JButton("메시지 보내기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = messagetxt.getText();
				String loginID = recieverIDtxt.getText();
				int memberID = member.getMemberIDbyLoginID(loginID);

				String timestamp = String.valueOf(System.currentTimeMillis()); // Current timestamp as a string
				if (message.trim().equals("")) {
					JOptionPane.showMessageDialog(panelBorder1, "메시지를 입력해주세요.", "Empty message", 2);
				} else {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String formattedTimestamp = sdf.format(new Date(Long.parseLong(timestamp))); // Format the
																										// timestamp
						int result = mM.EmsendMessage(memberID, "memreceive", message, formattedTimestamp);
						if (result == 1) {
							JOptionPane.showMessageDialog(panelBorder1, "메시지를 보냈습니다.", "done", 2);
							refresh();

						} else {
							JOptionPane.showMessageDialog(panelBorder1, "존재하는 수신자 ID인지 확인해주세요.", "send error", 2);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(panelBorder1, "error", "Error", 2);
					}
				}
			}

		});
		btnNewButton.setBounds(677, 484, 117, 29);
		panelBorder1.add(btnNewButton);

		recievemessage.setBorder(null);

		table_1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "발신자", "보낸 시간", "메시지" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		recievemessage.setViewportView(table_1);

		// 테이블 행 클릭 시 이벤트
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				recieverIDtxt.setText((String) table_1.getModel().getValueAt(row, 0));
			}
		});
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

		JLabel lblNewLabel = new JLabel("수신자 ID");
		lblNewLabel.setBounds(446, 320, 61, 16);
		panelBorder1.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("새로고침");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnNewButton_1.setBounds(549, 484, 98, 29);
		panelBorder1.add(btnNewButton_1);
	}// </editor-fold>//GEN-END:initComponents

	//message 객체에서 employee가 보낸 메시지를 가져와 테이블에 삽입하는 메소드
	/**
  	 *message 객체에서 employee가 보낸 메시지를 가져와 테이블에 삽입하는 메소드입니다.
  	 */
	private void sent() {
		mess = mM.getEmployeeSendMessage();
		for (int i = 0; i < mess.length; ++i) {
			table.addRow(new Object[] { mess[i].getSendtime(), member.getLoginIDbyMemberID(mess[i].getMemberID()),
					mess[i].getContent() });
		}
	}
	//message 객체에서 employee가 받은 메시지를 가져와 테이블에 삽입하는 메소드
	/**
	 *message 객체에서 employee가 받은 메시지를 가져와 테이블에 삽입하는 메소드입니다.
	 */
	private void recieved() {
		mess = mM.getEmployeeRecieveMessage();
		for (int i = 0; i < mess.length; ++i) {
			table_1.addRow(new Object[] { member.getLoginIDbyMemberID(mess[i].getMemberID()), mess[i].getSendtime(),
					mess[i].getContent() });
		}
	}
	
	 //message 테이블 새로고침 하는 메소드
  	/**
  	 * message 테이블을 새로고침하여 가져오는 메소드입니다.
  	 */
	public void refresh() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();
		model_1.setRowCount(0);
		model.setRowCount(0);
		sent();
		recieved();
		for(int i=0; i<table.getRowCount(); ++i)
			if(table.getModel().getValueAt(i, 1).equals(""))
				table.getModel().setValueAt("(알 수 없음)", i, 1);
		for(int i=0; i<table_1.getRowCount(); ++i)
			if(table_1.getModel().getValueAt(i, 0).equals(""))
				table_1.getModel().setValueAt("(알 수 없음)", i, 0);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLayeredPane panel;
	private DB2023188606_view.swing.PanelBorder panelBorder1;
	private javax.swing.JScrollPane sentmessage;
	private DB2023188606_view.swing.Table table;
	private DB2023188606_view.swing.Table table_1;
	private DB2023188606_modelManager.MemberManager memberManager;
	private DB2023188606_modelManager.MessageManager messageManager;
	private JScrollPane recievemessage;
	private JTextField messagetxt;
	private JTextField recieverIDtxt;
	private JButton btnNewButton_1;
}
