package DB2023188606_view.form;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import DB2023188606_model.Member;
import DB2023188606_modelManager.MemberManager;
import DB2023188606_view.swing.ScrollBar;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

public class Form_AdMember extends JPanel {
	
	private Member[] mem;
	private MemberManager mM;
	
	// 기본 생성자
	public Form_AdMember() {
		
		initComponents();
		mM = new MemberManager();
		
		all();
    }

 
    @SuppressWarnings("unchecked")
  
    // Admember 판넬 초기 생성 메소드.
 	/**
 	 * Admember 판넬 초기 생성 메소드입니다.
 	 */
    private void initComponents() {
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        panel = new javax.swing.JLayeredPane();
        panel.setBounds(20, 20, 907, 0);
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1 = new DB2023188606_view.swing.PanelBorder();
        panelBorder1.setBounds(20, 40, 907, 557);
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        setBackground(new java.awt.Color(242, 242, 242));
 
        spTable = new javax.swing.JScrollPane();
        spTable.setBounds(371, 104, 484, 378);
        table = new DB2023188606_view.swing.Table();
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        //테이블 행을 클릭하면 해당 행의 정보가 옆의 박스에 자동 입력되도록 하는 이벤트 리스너
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = table.getSelectedRow();

        		String str = (String) table.getModel().getValueAt(row, 5);
        		Date strToDate = null;
        		try {
        		    strToDate = dateFormatter.parse(str);
        		} catch (Exception ex) {
        		    throw new RuntimeException(ex);
        		}

        		String grade = (String) table.getModel().getValueAt(row, 1 );
        		String name = (String) table.getModel().getValueAt(row, 2 );
        		String loginID = (String) table.getModel().getValueAt(row, 3 );
        		String phone = (String) table.getModel().getValueAt(row, 4 );
        		Date date =  strToDate;

        		setInputText(name,loginID,grade,phone,date);

        	}
        });
        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        spTable.setBorder(null);


        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "고유번호","등급", "이름", "ID", "휴대폰 번호", "생년월일"
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
        table.getColumn("고유번호").setPreferredWidth(70);
        table.getColumn("휴대폰 번호").setPreferredWidth(100);
        
        label_title = new javax.swing.JLabel();
        label_title.setBounds(20, 20, 263, 26);
        label_title.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        label_title.setForeground(new java.awt.Color(127, 127, 127));
        label_title.setText("Member Management");
        
        label_name = new JLabel("이름");
        label_name.setBounds(20, 237, 26, 19);
        label_name.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_loginID = new JLabel("아이디");
        label_loginID.setBounds(20, 307, 38, 19);
        label_loginID.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_grade = new JLabel("등급");
        label_grade.setBounds(20, 168, 26, 19);
        label_grade.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_phoneNum = new JLabel("휴대폰 번호");
        label_phoneNum.setBounds(20, 385, 84, 19);
        label_phoneNum.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_birthDate = new JLabel("생년월일");
        label_birthDate.setBounds(20, 458, 84, 19);
        label_birthDate.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        input_name = new JTextField();
        input_name.setBounds(122, 238, 195, 26);
        input_name.setColumns(10);
        
        input_grade = new JComboBox();
        input_grade.setModel(new DefaultComboBoxModel(new String[] {"bronze", "silver", "gold", "VIP"}));
        input_grade.setBounds(122, 168, 195, 26);
        input_grade.setSelectedIndex(-1);
        
        input_loginID = new JTextField();
        input_loginID.setBounds(122, 308, 195, 26);
        input_loginID.setColumns(10);
        
        MaskFormatter formatter=null;
	    try {
	    	formatter = new MaskFormatter("###-####-####");
	    }catch(ParseException ex) {
	    }
	    input_phoneNum = new JFormattedTextField(formatter);
	    input_phoneNum.setBounds(122, 381, 195, 26);
        
        input_birthDate = new JDateChooser();
        input_birthDate.setBounds(122, 456, 195, 26);
        
        //삭제 버튼
        btn_del = new JButton("Delete");
        btn_del.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = table.getSelectedRow();
        		if(row==-1)
        			JOptionPane.showMessageDialog(null,"삭제할 회원을 먼저 선택해주세요.", "Member is Not Selected",2);
        		else {
        			int ans = JOptionPane.showConfirmDialog(null, "해당 회원을 영구적으로 삭제하시겠습니까?","Delete Member",JOptionPane.YES_NO_OPTION);
        			if(ans==JOptionPane.YES_OPTION) {
        				int id = (int)table.getModel().getValueAt(row, 0);
	        			if(mM.delete(id)==1) {
		        			JOptionPane.showMessageDialog(null,"정상적으로 삭제되었습니다.", "Deleted",2);
		        			refresh();
		        			clear();
	        			}
        			}
        		}
        	}
        });
        btn_del.setBounds(425, 492, 131, 23);
        
        //새로고침 버튼
        btn_refresh = new JButton("Refresh");
        btn_refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });
        btn_refresh.setBounds(709, 492, 131, 23);
        
        
        add(panelBorder1);
        panelBorder1.setLayout(null);
        panelBorder1.add(label_title);
        panelBorder1.add(label_grade);
        panelBorder1.add(label_phoneNum);
        panelBorder1.add(label_birthDate);
        panelBorder1.add(label_name);
        panelBorder1.add(label_loginID);
        panelBorder1.add(input_loginID);
        panelBorder1.add(input_grade);
        panelBorder1.add(input_name);
        panelBorder1.add(input_phoneNum);
        panelBorder1.add(input_birthDate);
        panelBorder1.add(spTable);
        panelBorder1.add(btn_del);
        panelBorder1.add(btn_refresh);
        
        JButton btn_clear = new JButton("Clear");
        btn_clear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clear();
        	}
        });
        btn_clear.setBounds(12, 115, 65, 23);
        panelBorder1.add(btn_clear);
        
        lblNewLabel = new JLabel("* 이화호텔에 가입한 회원들의 목록을 확인가능하며, 특정 회원을 강제로 탈퇴시키는 것이 가능합니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel.setBounds(260, 28, 555, 15);
        panelBorder1.add(lblNewLabel);
        add(panel);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    //텍스트 박스를 비우는 메소드
  	/**
  	 *텍스트 박스를 비우는 메소드입니다.
  	 */
    private void clear() {
    	input_name.setText("");
    	input_loginID.setText("");
    	input_grade.setSelectedIndex(-1);
    	input_phoneNum.setText("");
    	input_birthDate.setDate(null);
    }
    
    //텍스트 박스를 입력받은 값으로 채우는 메소드
  	/**
  	 *텍스트 박스를 입력받은 값으로 채우는 메소드입니다.
  	 */
    private void setInputText(String name,String id, String grade, String phone, Date date) {
    	int i=-1;
    	if(grade.equals("bronze"))
    		i=0;
    	else if(grade.equals("silver"))
    		i=1;
    	else if(grade.equals("gold"))
    		i=2;
    	else if(grade.equals("VIP"))
    		i=3;

    	input_name.setText(name);
    	input_loginID.setText(id);
    	input_grade.setSelectedIndex(i);
    	input_phoneNum.setText(phone);
    	input_birthDate.setDate(date);
    }

    //Member의 모든 객체 가져와 테이블에 삽입하는 메소드
  	/**
  	 * member의 모든 객체 가져와 테이블에 삽입하는 메소드입니다.
  	 */
    private void all() {
    	mem = mM.getAllMember();
    	for (int i = 0; i < mem.length; ++i) {
			table.addRow(new Object[] {mem[i].getMemberID(),mem[i].getGrade(),mem[i].getName(),mem[i].getLoginID(),mem[i].getPhone(),mem[i].getBirthDate()});
		}
    }
    
    //새로고침
    //member 테이블 새로고침 하는 메소드
  	/**
  	 * member 테이블을 새로고침하여 가져오는 메소드입니다.
  	 */
    private void refresh() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();
    	model.setRowCount(0);
    	all();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_title;
    private javax.swing.JLayeredPane panel;
    private DB2023188606_view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private DB2023188606_view.swing.Table table;
    private JTextField input_name;
    private JTextField input_loginID;
    private JTextField input_phoneNum;
    private JLabel label_grade;
    private JLabel label_phoneNum;
    private JLabel label_birthDate;
    private JLabel label_name;
    private JLabel label_loginID;
    private JComboBox input_grade;
    private JDateChooser input_birthDate;
    private JButton btn_del;
    private JButton btn_refresh;
    private JLabel lblNewLabel;
}
