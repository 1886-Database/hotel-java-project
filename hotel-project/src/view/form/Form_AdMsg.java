package view.form;

import java.awt.Color;

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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;


public class Form_AdMsg extends javax.swing.JPanel {


    /**
     * Creates new form Form_1
     */
    public Form_AdMsg() {
        initComponents();
    //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        table.addRow(new Object[]{"23031900001", "Ivan", "Single", "2023-03-19~2023-03-20", StatusType.PENDING});
        table.addRow(new Object[]{"23040100002", "Conan", "2023-04-01 13:20", "83821", StatusType.APPROVED});
        
    
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
        jLabel1.setText("MessageAdmin");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "발신자","수신자", "보낸 시간", "메시지"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);
        
        JLabel lblNewLabel = new JLabel("수신자");
        
        JLabel lblNewLabel_1 = new JLabel("메시지");
        
        JLabel lblNewLabel_1_1 = new JLabel("발신자");
        
        JButton btnNewButton = new JButton("Add");
        
        JButton btnEdit = new JButton("Edit");
        
        JButton btnNewButton_1_1 = new JButton("Delete");
        
        JButton btnNewButton_1_1_1 = new JButton("Clear");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        textField = new JTextField();
        textField.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addContainerGap(1054, Short.MAX_VALUE))
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_1)
        						.addComponent(lblNewLabel)
        						.addComponent(lblNewLabel_1_1))
        					.addGap(50)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(173)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addComponent(btnNewButton)
        							.addGap(64)
        							.addComponent(btnEdit)
        							.addGap(68)
        							.addComponent(btnNewButton_1_1)
        							.addGap(53)
        							.addComponent(btnNewButton_1_1_1))
        						.addGroup(panelBorder1Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)))
        					.addGap(245))))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addContainerGap(51, Short.MAX_VALUE)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(102)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1_1)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(45)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(47)
        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(161))
        				.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
        			.addGap(34)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNewButton)
        				.addComponent(btnEdit)
        				.addComponent(btnNewButton_1_1)
        				.addComponent(btnNewButton_1_1_1))
        			.addContainerGap(44, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JTextField textField_1;
    private JTextField textField;
    private JTextField textField_2;
}
