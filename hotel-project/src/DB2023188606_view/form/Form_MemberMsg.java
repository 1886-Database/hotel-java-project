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


public class Form_MemberMsg extends javax.swing.JPanel {

	private Message[] mess;
	private MessageManager mM;
	private int memberID;
   
	//기본 Form_MemberMsg 생성자
    public Form_MemberMsg(int memberID) {
    	this.memberID=memberID;
    	mM = new MessageManager();
    	   initComponents();
    
    sent(memberID);
    recieved(memberID);
    
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(){

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new DB2023188606_view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(52, 44, 121, 22);
        sentmessage = new javax.swing.JScrollPane();
        sentmessage.setBounds(428, 79, 366, 267);
        recievemessage = new JScrollPane();
        recievemessage.setBounds(52, 79, 353, 416);
     
        table  = new DB2023188606_view.swing.Table();
        table_1 = new DB2023188606_view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("맑은 고딕 ", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("받은 메시지");

        sentmessage.setBorder(null);
        
        
        //보낸 메시지 table model set 
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "보낸 시간", "메시지"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
        
        
        //메시지 보내기 button
        JButton btnNewButton = new JButton("메시지 보내기");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	    String message = messagetxt.getText();
        	    int clickedMemberID = memberID;
        	    String timestamp = String.valueOf(System.currentTimeMillis()); // Current timestamp as a string
        	    if (message.trim().equals("")) {
        	        JOptionPane.showMessageDialog(null, "메시지를 입력해주세요.", "Empty message", 2);
        	    } else {
        	        try {
        	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	            String formattedTimestamp = sdf.format(new Date(Long.parseLong(timestamp))); // Format the timestamp
        	            int result = mM.sendMessage(clickedMemberID, "memsend", message, formattedTimestamp);
        	            if (result == 1) {
        	                JOptionPane.showMessageDialog(null, "메시지를 보냈습니다.", "done", 2);
        	                DefaultTableModel model = (DefaultTableModel)table.getModel();
        	            	model.setRowCount(0);
        	            	sent(memberID);
        	            } else {
        	                JOptionPane.showMessageDialog(panel, "error.", "send error", 2);
        	            }
        	        } catch (Exception ex) {
        	            JOptionPane.showMessageDialog(panel, "error", "Error", 2);
        	        }
        	    }
        	}

        
        });
        btnNewButton.setBounds(677, 484, 117, 29);
        panelBorder1.add(btnNewButton);
      
        
        recievemessage.setBorder(null);
        
        //받은 메시지 table set model 
        table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "발신자", "보낸 시간","메시지"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        recievemessage.setViewportView(table_1);
        
      

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
        
        
        //새로고침 버튼
        JButton btnNewButton_1 = new JButton("새로고침");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });
        btnNewButton_1.setBounds(539, 484, 117, 29);
        panelBorder1.add(btnNewButton_1);
    }
    
   //보낸 메시지 table에 받아와서 추가 
  	/**
  	 * member ID를 인수로 받아와 member가 보낸 메시지를 레코드에서 가져와 테이블에 입력하는 메소드입니다.
  	 */
    private void sent(int memberID) {
    	mess = mM.getMemberSendMessage(memberID);
    	for (int i = 0; i < mess.length; ++i) {
        	table.addRow(new Object[] {mess[i].getSendtime(),mess[i].getContent()});
        }}
   
    //보낸 메시지 table에 받아와서 추가
	/**
  	 * member ID를 인수로 받아와 member가 받은 메시지를 레코드에서 가져와 테이블에 입력하는 메소드입니다.
  	 */
    private void recieved(int memberID) {
    	mess = mM.getMemberRecieveMessage(memberID);
    	for (int i = 0; i < mess.length; ++i) {
        	table_1.addRow(new Object[] {"호텔",mess[i].getSendtime(),mess[i].getContent()});
        }
    }
    
    //table refresh
	/**
  	 * 두 테이블을 새로고침하여 가져오는 메소드입니다.
  	 */
    public void refresh() {
    	DefaultTableModel model1 = (DefaultTableModel)table.getModel();
    	model1.setRowCount(0);
    	DefaultTableModel model2 = (DefaultTableModel)table_1.getModel();
    	model2.setRowCount(0);
    	sent(memberID);
    	recieved(memberID);
    }
    


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
}