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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;


public class Form_AdEmployee extends javax.swing.JPanel {


    /**
     * Creates new form Form_1
     */
    public Form_AdEmployee() {
        initComponents();
    //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        add(panelBorder1);
        panelBorder1.setLayout(null);
        panelBorder1.add(jLabel1);
        panelBorder1.add(lblNewLabel_1_1);
        panelBorder1.add(lblNewLabel_1_1_1);
        panelBorder1.add(lblNewLabel_1_1_1_1);
        panelBorder1.add(lblNewLabel);
        panelBorder1.add(lblNewLabel_1);
        panelBorder1.add(textField_1);
        panelBorder1.add(comboBox);
        panelBorder1.add(textField);
        panelBorder1.add(textField_2);
        panelBorder1.add(dateChooser);
        panelBorder1.add(spTable);
        panelBorder1.add(btnNewButton);
        panelBorder1.add(btnEdit);
        panelBorder1.add(btnNewButton_1);
        panelBorder1.add(btnNewButton_1_1);
        add(panel);
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
        panel.setBounds(20, 20, 907, 0);
        panelBorder1 = new view.swing.PanelBorder();
        panelBorder1.setBounds(20, 40, 907, 557);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(20, 20, 263, 26);
        spTable = new javax.swing.JScrollPane();
        spTable.setBounds(371, 104, 484, 378);
        table = new view.swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));


        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Employee Management");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "고유번호","부서", "이름", "ID", "휴대폰 번호", "생년월일"
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
        
        lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(20, 237, 26, 19);
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        lblNewLabel_1 = new JLabel("아이디");
        lblNewLabel_1.setBounds(20, 307, 38, 19);
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        lblNewLabel_1_1 = new JLabel("부서");
        lblNewLabel_1_1.setBounds(20, 168, 26, 19);
        lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        lblNewLabel_1_1_1 = new JLabel("휴대폰 번호");
        lblNewLabel_1_1_1.setBounds(20, 385, 84, 19);
        lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        lblNewLabel_1_1_1_1 = new JLabel("생년월일");
        lblNewLabel_1_1_1_1.setBounds(20, 458, 84, 19);
        lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        textField = new JTextField();
        textField.setBounds(122, 238, 195, 21);
        textField.setColumns(10);
        
        comboBox = new JComboBox();
        comboBox.setBounds(122, 168, 195, 23);
        
        btnNewButton = new JButton("Add");
        btnNewButton.setBounds(428, 492, 53, 23);
        
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(537, 492, 51, 23);
        
        btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.setBounds(638, 492, 65, 23);
        
        btnNewButton_1_1 = new JButton("Clear");
        btnNewButton_1_1.setBounds(742, 492, 59, 23);
        
        textField_1 = new JTextField();
        textField_1.setBounds(122, 308, 195, 21);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(122, 381, 195, 21);
        textField_2.setColumns(10);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(122, 456, 195, 21);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblNewLabel_1_1;
    private JLabel lblNewLabel_1_1_1;
    private JLabel lblNewLabel_1_1_1_1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JComboBox comboBox;
    private JDateChooser dateChooser;
    private JButton btnNewButton;
    private JButton btnEdit;
    private JButton btnNewButton_1;
    private JButton btnNewButton_1_1;
}
