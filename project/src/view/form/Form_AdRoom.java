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


public class Form_AdRoom extends javax.swing.JPanel {

	private Room[] room;
	private RoomManager rM;
    /**
     * Creates new form Form_1
     */
    public Form_AdRoom() {
        initComponents();
        rM = new RoomManager();
		
		all();
		
    
    
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

        
    //  add row table
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
        
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Room");

        spTable.setBorder(null);

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
        
        JLabel lblNewLabel = new JLabel("배드 타입");
        
        JLabel lblNewLabel_1 = new JLabel("수용 인원");
        
        JLabel lblNewLabel_1_1 = new JLabel("객실 번호");
        
        JLabel lblNewLabel_1_1_1 = new JLabel("가격");
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("객실 타입");
        
        input_bedtype = new JTextField();
        input_bedtype.setColumns(10);
        
        JButton btn_add = new JButton("Add");
        btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		String roomno = input_roomno.getText();
        		String bedtype=input_price.getText();
        		String capacity=input_capacity.getText();
        		String price=input_roomtype.getText();
    			String roomtype = input_capacity.getText();
    			String roomsize = input_roomsize.getText();
    			String roomname = input_bedtype.getText();
        			
        			
        			if(roomno.equals("")||bedtype.equals("")||capacity.equals("")||price.equals("")||roomtype.equals("")||roomsize.equals("")||roomname.equals("")) {
        				JOptionPane.showMessageDialog(null,"추가할 객실의 정보를 모두 입력해주세요.", "Empty slot Exists",2);
        			}else {
        				int ans = JOptionPane.showConfirmDialog(null, "입력한 정보대로 객실을 추가하시겠습니까?","Add Room",JOptionPane.YES_NO_OPTION);
            			if(ans==JOptionPane.YES_OPTION) {
            				int result = rM.add(roomno,bedtype, capacity, price, roomtype,roomsize,roomname);
            				if(result==1) {
            					JOptionPane.showMessageDialog(null,"정상적으로 추가되었습니다.", "Added",2);
                				refresh();
                				clear();
                			}else if(result==-1) {
                				JOptionPane.showMessageDialog(null,"추가 실패", "Error",2);
                			}
            			}
        			}
        		
        	}
        });
        btn_add.setBounds(428, 492, 53, 23);
        
        JButton btn_edit = new JButton("Edit");
        btn_edit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        			String roomno = input_roomno.getText();
        			String bedtype = input_bedtype.getText();
        			String capacity = input_capacity.getText();
        			String price=input_price.getText();
        			String roomtype=input_roomtype.getText();
        			String roomsize=input_roomsize.getText();
        			String roomname=input_roomname.getText();
        			
        			int row = table.getSelectedRow();
        			
        			if(row==-1)
        				JOptionPane.showMessageDialog(null,"수정할 객실을 먼저 선택해주세요.", "Room is Not Selected",2);
        			else if(roomno.equals("")||bedtype.equals("")||capacity.equals("")||price.equals("")||roomtype.equals("")||roomsize.equals("")||roomname.equals("")) {
        				JOptionPane.showMessageDialog(null,"수정할 객실의 정보를 모두 입력해주세요.", "Room slot Exists",2);
        			}else {
        				int ans = JOptionPane.showConfirmDialog(null, "입력한대로 객실 정보를 수정하시겠습니까?","Edit Room",JOptionPane.YES_NO_OPTION);
            			if(ans==JOptionPane.YES_OPTION) {
            				int result = rM.edit(roomno,bedtype, capacity, price, roomtype,roomsize,roomname);
            				if(result==1) {
            					JOptionPane.showMessageDialog(null,"정상적으로 수정되었습니다.", "Edited",2);
                				refresh();
                				clear();
                			}else if(result==-1) {
                				JOptionPane.showMessageDialog(null,"수정 실패.", "Error",2);
                			}
            			}
        			}
        		
        	}
        });
        btn_edit.setBounds(537, 492, 51, 23);
        
        JButton btn_delete = new JButton("Delete");
        btn_delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = table.getSelectedRow();
        		if(row==-1)
        			JOptionPane.showMessageDialog(null,"삭제할 객실을 먼저 선택해주세요.", "Room is Not Selected",2);
        		else {
        			int ans = JOptionPane.showConfirmDialog(null, "해당 객실을 영구적으로 삭제하시겠습니까?","Delete Room",JOptionPane.YES_NO_OPTION);
        			if(ans==JOptionPane.YES_OPTION) {
        				int id = (int)table.getModel().getValueAt(row, 0);
	        			if(rM.delete(id)==1) {
		        			JOptionPane.showMessageDialog(null,"정상적으로 삭제되었습니다.", "Deleted",2);
		        			refresh();
		        			clear();
	        			}
        			}
        		}
        	}
        });
        btn_delete.setBounds(425, 492, 131, 23);
        
        JButton btn_refresh = new JButton("Refresh");
        btn_refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });
        btn_refresh.setBounds(709, 492, 131, 23);
        
        input_roomno = new JTextField();
        input_roomno.setColumns(10);
        
        input_capacity = new JTextField();
        input_capacity.setColumns(10);
        
        input_price = new JTextField();
        input_price.setColumns(10);
        
        input_roomtype = new JTextField();
        input_roomtype.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("객실 사이즈");
        
        input_roomsize = new JTextField();
        input_roomsize.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("객실 이름");
        
        input_roomname = new JTextField();
        input_roomname.setColumns(10);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addContainerGap(925, Short.MAX_VALUE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(16)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel)
        							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        							.addComponent(input_bedtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_1)
        							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        							.addComponent(input_capacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_1_1_1)
        							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
        							.addComponent(input_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_1_1_1_1)
        							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        							.addComponent(input_roomtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_2)
        							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
        							.addComponent(input_roomsize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_3)
        							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        							.addComponent(input_roomname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_1_1)
        							.addGap(45)
        							.addComponent(input_roomno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
        							.addComponent(btn_add)
        							.addGap(64)
        							.addComponent(btn_edit)
        							.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
        							.addComponent(btn_delete)
        							.addGap(71)
        							.addComponent(btn_refresh)
        							.addGap(38))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        							.addContainerGap())))))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(36)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1_1)
        						.addComponent(input_roomno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblNewLabel)
        						.addComponent(input_bedtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(55)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(input_capacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(45)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1_1_1)
        						.addComponent(input_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(43)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1_1_1_1)
        						.addComponent(input_roomtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(48)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblNewLabel_2)
        						.addComponent(input_roomsize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(38)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_3)
        						.addComponent(input_roomname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(40))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(spTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_add)
        				.addComponent(btn_edit)
        				.addComponent(btn_delete)
        				.addComponent(btn_refresh))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents
    private void clear() {
    	input_roomno.setText("");
    	input_bedtype.setText("");
    	input_capacity.setText("");
    	input_price.setText("");
    	input_roomtype.setText("");
    	input_roomsize.setText("");
    	input_roomname.setText("");
    }
    private void setInputText(String roomno,String bedtype, String capacity, String price, String roomtype, String roomsize,String roomname) {
    	

    	input_roomno.setText(roomno);
    	input_bedtype.setText(bedtype);
    	input_capacity.setText(capacity);
    	input_price.setText(price);
    	input_roomtype.setText(roomtype);
    	input_roomsize.setText(roomsize);
    	input_roomname.setText(roomname);
    }

    
    private void all() {
        room= rM.getAllRoom();
        for (int i = 0; i < room.length; ++i) {
          table.addRow(new Object[] {room[i].getRoomNo(),room[i].getBedType(),room[i].getCapacity(),room[i].getPrice(),room[i].getRoomType(),room[i].getRoomSize(),room[i].getRoomName()});
       }
        
         
     }
    
  //새로고침
    private void refresh() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();
    	model.setRowCount(0);
    	all();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
}