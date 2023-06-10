package view.form;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.UI.EmployeeMain;
import view.swing.ScrollBar;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDateChooser;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import model.Employee;
import modelManager.EmployeeManager;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableCellRenderer;


public class Form_AdEmployee extends javax.swing.JPanel {

	private Employee[] empList;
	private EmployeeManager eM;
	private Employee emp;
	
	//loginID를 인수로 받아오는 생성자
    public Form_AdEmployee(String loginID) {
    	
        eM = new EmployeeManager();
        emp = eM.getByLoginID(loginID);
        initComponents(emp);
        
        all();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Employee emp) {
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        panel = new javax.swing.JLayeredPane();
        panel.setBounds(20, 20, 907, 0);
        panelBorder1 = new view.swing.PanelBorder();
        panelBorder1.setBounds(20, 40, 907, 557);
        label_title = new javax.swing.JLabel();
        label_title.setBounds(20, 20, 263, 26);
        spTable = new javax.swing.JScrollPane();
        spTable.setBounds(371, 104, 484, 378);
        table = new view.swing.Table();
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
        		
        		String dept = (String) table.getModel().getValueAt(row, 1 );
        		String name = (String) table.getModel().getValueAt(row, 2 );
        		String loginID = (String) table.getModel().getValueAt(row, 3 );
        		String phone = (String) table.getModel().getValueAt(row, 4 );
        		Date date =  strToDate;
        		
        		setInputText(name,loginID,dept,phone,date);
        		
        	}
        });
        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));


        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        label_title.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        label_title.setForeground(new java.awt.Color(127, 127, 127));
        label_title.setText("Employee Management");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "고유번호","부서", "이름", "ID", "휴대폰 번호", "생년월일"
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
        
        label_name = new JLabel("이름");
        label_name.setBounds(20, 237, 26, 19);
        label_name.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_loginID = new JLabel("아이디");
        label_loginID.setBounds(20, 307, 38, 19);
        label_loginID.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_dept = new JLabel("부서");
        label_dept.setBounds(20, 168, 26, 19);
        label_dept.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_phone = new JLabel("휴대폰 번호");
        label_phone.setBounds(20, 385, 84, 19);
        label_phone.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        label_birthDate = new JLabel("생년월일");
        label_birthDate.setBounds(20, 458, 84, 19);
        label_birthDate.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        
        input_name = new JTextField();
        input_name.setBounds(122, 238, 195, 26);
        input_name.setColumns(10);
        
        input_dept = new JComboBox();
        input_dept.setModel(new DefaultComboBoxModel(new String[] {"front office", "housekeeping", "security", "hr"}));
        input_dept.setBounds(122, 168, 195, 26);
        input_dept.setSelectedIndex(-1);
        
        input_loginID = new JTextField();
        input_loginID.setBounds(122, 308, 195, 26);
        input_loginID.setColumns(10);
        
        MaskFormatter formatter=null;
	    try {
	    	formatter = new MaskFormatter("###-####-####");
	    }catch(ParseException ex) {
	    	ex.printStackTrace();
	    }
	    input_phoneNum = new JFormattedTextField(formatter);
	    input_phoneNum.setBounds(122, 381, 195, 26);
        
        
        input_birthDate = new JDateChooser();
        input_birthDate.setBounds(122, 456, 195, 26);
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        //추가 버튼
        btn_add = new JButton("Add");
        btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(emp.getDepartment().equals("hr")) {   //로그인한 직원의 부서가 hr 이라면 삽입 과정 진행
        			String loginID = input_loginID.getText();
        			String name = input_name.getText();
        			String phone = input_phoneNum.getText();
        			String birthDate=""; 
        			try {
        				birthDate = dateFormatter.format(input_birthDate.getDate());
        			}catch(Exception ex) {
        				
        			}
        			String dept = (String) input_dept.getSelectedItem();
        			
        			if(name.equals("")||loginID.equals("")||dept.equals("")||phone.equals("")||birthDate.equals("")) {
        				JOptionPane.showMessageDialog(null,"추가할 직원의 정보를 모두 입력해주세요.", "Empty slot Exists",2);
        			}else {
        				int ans = JOptionPane.showConfirmDialog(null, "입력한 정보대로 직원을 추가하시겠습니까?","Add Employee",JOptionPane.YES_NO_OPTION);
            			if(ans==JOptionPane.YES_OPTION) {
            				if(eM.checkID(loginID)==1) {
	            				int result = eM.add(loginID, name, phone, birthDate, dept);
	            				if(result==1) {
	            					JOptionPane.showMessageDialog(null,"정상적으로 추가되었습니다.", "Added",2);
	                				refresh();
	                				clear();
	                			}else if(result==-1) {
	                				JOptionPane.showMessageDialog(null,"sql 에러.", "Error",2);
	                			}
            				}else JOptionPane.showMessageDialog(null,"로그인 ID가 중복되는지 확인해주세요.", "Error",2);
            			}
        			}
        		}else { //로그인한 직원의 부서가 hr 이 아니라면 경고 메시지 출력
        			JOptionPane.showMessageDialog(null,"권한이 없습니다.", "Not Allowed",2);
        		}
        	}
        });
        btn_add.setBounds(428, 492, 53, 23);
        
        //수정 버튼
        btn_edit = new JButton("Edit");
        btn_edit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(emp.getDepartment().equals("hr")) {   //로그인한 직원의 부서가 hr 이라면 수정 과정 진행
        			String loginID = input_loginID.getText();
        			String name = input_name.getText();
        			String phone = input_phoneNum.getText();
        			String birthDate=""; 
        			try {
        				birthDate = dateFormatter.format(input_birthDate.getDate());
        			}catch(Exception ex) {
        				
        			}
        			String dept = (String) input_dept.getSelectedItem();
        			int row = table.getSelectedRow();
        			
        			if(row==-1)
        				JOptionPane.showMessageDialog(null,"수정할 직원을 먼저 선택해주세요.", "Employee is Not Selected",2);
        			else if(name.equals("")||loginID.equals("")||dept.equals("")||phone.equals("")||birthDate.equals("")) {
        				JOptionPane.showMessageDialog(null,"수정할 직원의 정보를 모두 입력해주세요.", "Empty slot Exists",2);
        			}else {
        				int ans = JOptionPane.showConfirmDialog(null, "입력한대로 직원 정보를 수정하시겠습니까?","Edit Employee",JOptionPane.YES_NO_OPTION);
            			if(ans==JOptionPane.YES_OPTION) {
            				int id = (int)table.getModel().getValueAt(row, 0);
            				int result = eM.edit(id,loginID, name, phone, birthDate, dept);
            				if(result==1) {
            					JOptionPane.showMessageDialog(null,"정상적으로 수정되었습니다.", "Edited",2);
                				refresh();
                				clear();
                			}else if(result==-1) {
                				JOptionPane.showMessageDialog(null,"로그인 ID가 중복되는지 확인해주세요.", "Error",2);
                			}
            			}
        			}
        		}else { //로그인한 직원의 부서가 hr 이 아니라면 경고 메시지 출력
        			JOptionPane.showMessageDialog(null,"권한이 없습니다.", "Not Allowed",2);
        		}
        	}
        });
        btn_edit.setBounds(537, 492, 51, 23);
        
        //삭제 버튼
        btn_del = new JButton("Delete");
        btn_del.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(emp.getDepartment().equals("hr")) {   //로그인한 직원의 부서가 hr 이라면 삭제 과정 진행
	        		int row = table.getSelectedRow();
	        		if(row==-1)
	        			JOptionPane.showMessageDialog(null,"삭제할 직원을 먼저 선택해주세요.", "Employee is Not Selected",2);
	        		else {
	        			int ans = JOptionPane.showConfirmDialog(null, "해당 직원을 영구적으로 삭제하시겠습니까?","Delete Employee",JOptionPane.YES_NO_OPTION);
	        			if(ans==JOptionPane.YES_OPTION) {
	        				int id = (int)table.getModel().getValueAt(row, 0);
							if(emp.getEmployeeID()==id) { //로그인한 직원의 id 와 선택한 테이블 행의 id 가 동일하면 경고 메시지 출력 후 삭제 과정 중단
								JOptionPane.showMessageDialog(null,"본인의 정보를 삭제할 수는 없습니다.", "Not allowed",2);
							}
							else {
		        				if(eM.delete(id)==1) {
			        				JOptionPane.showMessageDialog(null,"정상적으로 삭제되었습니다.", "Deleted",2);
			        				refresh();
			        				clear();
		        				}
	        				}
	        			}
	        		}
        		}else { //로그인한 직원의 부서가 hr 이 아니라면 경고 메시지 출력
        			JOptionPane.showMessageDialog(null,"권한이 없습니다.", "Not Allowed",2);
        		}
        	}
        });
        btn_del.setBounds(638, 492, 65, 23);
        
        //새로고침 버튼
        btn_refresh = new JButton("Refresh");
        btn_refresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refresh();
        	}
        });
        btn_refresh.setBounds(742, 492, 73, 23);
        
        //초기화 버튼
        btn_clear = new JButton("Clear");
        btn_clear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clear();
        	}
        });
        btn_clear.setBounds(12, 115, 65, 23);
        
        
        add(panelBorder1);
        panelBorder1.setLayout(null);
        panelBorder1.add(label_title);
        panelBorder1.add(label_dept);
        panelBorder1.add(label_phone);
        panelBorder1.add(label_birthDate);
        panelBorder1.add(label_name);
        panelBorder1.add(label_loginID);
        panelBorder1.add(input_loginID);
        panelBorder1.add(input_dept);
        panelBorder1.add(input_name);
        panelBorder1.add(input_phoneNum);
        panelBorder1.add(input_birthDate);
        panelBorder1.add(spTable);
        panelBorder1.add(btn_add);
        panelBorder1.add(btn_edit);
        panelBorder1.add(btn_del);
        panelBorder1.add(btn_refresh);
        panelBorder1.add(btn_clear);
        
        lblNewLabel = new JLabel("* 이화호텔에 근무하는 직원들의 목록을 확인 가능합니다.");
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel.setBounds(257, 28, 484, 15);
        panelBorder1.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("* 직원 정보 추가(add) 및 수정(edit), 삭제(delete)에 대한 권한은 hr 부서 직원에게만 존재합니다.");
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(257, 48, 545, 15);
        panelBorder1.add(lblNewLabel_1);
        add(panel);
        
    }// </editor-fold>//GEN-END:initComponents
   
    
    // employee의 모든 객체 가져와 테이블에 삽입하는 메소드
  	/**
  	 * employee의 모든 객체 가져와 테이블에 삽입하는 메소드입니다.
  	 */
    private void all() {
    	empList = eM.getAllEmployee();
    	for (int i = 0; i < empList.length; ++i) {
        	table.addRow(new Object[] {empList[i].getEmployeeID(),empList[i].getDepartment(),empList[i].getName(),empList[i].getLoginID(),empList[i].getPhone(),empList[i].getBirthDate()});
        }
    }
    
    //employee 테이블 새로고침 하는 메소드
  	/**
  	 * employee 테이블을 새로고침하여 가져오는 메소드입니다.
  	 */
    private void refresh() {
    	DefaultTableModel model = (DefaultTableModel)table.getModel();
    	model.setRowCount(0);
    	all();
    }
   
    
    //텍스트 박스를 비우는 메소드입니다.
  	/**
  	 *텍스트 박스를 비우는 메소드입니다.
  	 */
    private void clear() {
    	input_name.setText("");
    	input_loginID.setText("");
    	input_dept.setSelectedIndex(-1);
    	input_phoneNum.setText("");
    	input_birthDate.setDate(null);
    	table.clearSelection();
    }
    
    //input 텍스트박스에 입력된 값을 세팅하는 메소드.
  	/**
  	 *input 텍스트박스에 입력된 값을 세팅하는 메소드입니다.
  	 */
    private void setInputText(String name,String loginID, String dept, String phone, Date date) {
    	int i=-1;
    	if(dept.equals("front office"))
    		i=0;
    	else if(dept.equals("housekeeping"))
    		i=1;
    	else if(dept.equals("security"))
    		i=2;
    	else if(dept.equals("hr"))
    		i=3;
    	
    	input_name.setText(name);
    	input_loginID.setText(loginID);
    	input_dept.setSelectedIndex(i);
    	input_phoneNum.setText(phone);
    	input_birthDate.setDate(date);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_title;
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private view.swing.Table table;
    private JTextField input_name;
    private JTextField input_loginID;
    private JFormattedTextField input_phoneNum;
    private JLabel label_dept;
    private JLabel label_phone;
    private JLabel label_birthDate;
    private JLabel label_name;
    private JLabel label_loginID;
    private JComboBox input_dept;
    private JDateChooser input_birthDate;
    private JButton btn_add;
    private JButton btn_edit;
    private JButton btn_del;
    private JButton btn_refresh;
    private JButton btn_clear;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
}