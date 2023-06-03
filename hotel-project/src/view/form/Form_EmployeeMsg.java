package view.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.UI.Login;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

import model.Member;
import modelManager.MemberManager;
import model.Message;
import modelManager.MessageManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class Form_EmployeeMsg extends javax.swing.JPanel {

	private Message[] mess;
	private MessageManager mM;
	private int employeeID;
   
	
    public Form_EmployeeMsg(int EmployeeID) {
    	this.employeeID=EmployeeID;
    	mM = new MessageManager();
    	   initComponents();
    
    sent();
    recieved();
    
    
    }
         
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(){

        panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(52, 44, 121, 22);
        sentmessage = new javax.swing.JScrollPane();
        sentmessage.setBounds(402, 78, 441, 202);
        recievemessage = new JScrollPane();
        recievemessage.setBounds(32, 78, 358, 416);
     
        table  = new view.swing.Table();
        table_1 = new view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));


        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("맑은 고딕 ", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("받은 메시지");

        sentmessage.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "보낸 시간","수신자", "메시지"
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
        jLabel1_1.setBounds(451, 44, 121, 22);
        panelBorder1.add(jLabel1_1);
        
        messagetxt = new JTextField();
        messagetxt.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        messagetxt.setBounds(415, 372, 428, 100);
        panelBorder1.add(messagetxt);
        messagetxt.setColumns(10);
        
        recieverIDtxt = new JTextField();
        recieverIDtxt.setBounds(477, 315, 130, 26);
        panelBorder1.add(recieverIDtxt);
        recieverIDtxt.setColumns(10);
        
        JButton btnNewButton = new JButton("메시지 보내기");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	    String message = messagetxt.getText();
        	    int memberID = Integer.parseInt(recieverIDtxt.getText());
        	    
        	    String timestamp = String.valueOf(System.currentTimeMillis()); // Current timestamp as a string
        	    if (message.trim().equals("")) {
        	        JOptionPane.showMessageDialog(panel, "메시지를 입력해주세요.", "Empty message", 2);
        	    } else {
        	        try {
        	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	            String formattedTimestamp = sdf.format(new Date(Long.parseLong(timestamp))); // Format the timestamp
        	            int result = mM.EmsendMessage(memberID, "memreceive", message, formattedTimestamp);
        	            if (result == 1) {
        	                JOptionPane.showMessageDialog(panel, "메시지를 보냈습니다.", "done", 2);
        	                DefaultTableModel model = (DefaultTableModel)table.getModel();
        	            	model.setRowCount(0);
        	            	sent();
        	            	recieved();
        	            	
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
        
        
        
        JLabel lblNewLabel = new JLabel("수신자 ID");
        lblNewLabel.setBounds(414, 320, 61, 16);
        panelBorder1.add(lblNewLabel);
    }// </editor-fold>//GEN-END:initComponents
    
    private void sent() {
    	mess = mM.getEmployeeSendMessage();
    	for (int i = 0; i < mess.length; ++i) {
        	table.addRow(new Object[] {mess[i].getSendtime(),mess[i].getMemberID(),mess[i].getContent()});
    	}
    }
       
    	
    private void recieved() {
    	mess = mM.getEmployeeRecieveMessage();
    	for (int i = 0; i < mess.length; ++i) {
        	table_1.addRow(new Object[] {mess[i].getMemberID(),mess[i].getSendtime(),mess[i].getContent()});
        }
    }
    	
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane sentmessage;
    private view.swing.Table table;
    private view.swing.Table table_1;
    private modelManager.MemberManager memberManager;
    private modelManager.MessageManager messageManager;
    private JScrollPane recievemessage;
    private JTextField messagetxt;
    private JTextField recieverIDtxt;
}
