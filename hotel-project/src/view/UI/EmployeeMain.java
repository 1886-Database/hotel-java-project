package view.UI;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

import model.Employee;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

import view.event.EventMenuSelected;
import view.form.Form_1;
import view.form.Form_2;
import view.form.Form_3;
import view.form.Form_AdEmployee;
import view.form.Form_AdMember;
import view.form.Form_EmployeeMsg;
import view.form.Form_AdMyPage;
import view.form.Form_AdReserv;
import view.form.Form_AdRoom;
import view.form.Form_Home;

import modelManager.EmployeeManager;
import model.Employee;

public class EmployeeMain extends javax.swing.JFrame {


	private JFrame frame;
    private Form_Home home;
    private Form_AdRoom form1;
    private Form_AdReserv form2;
    private Form_AdEmployee form3;
    private Form_AdMember form4;
    private Form_AdMyPage form5;
    private Form_EmployeeMsg form6;
    private EmployeeManager eM;
    static String loginID = "wcampbell"; 
    static int EmployeeID = 2; //값 초기화
    
    
    public EmployeeMain(String id) {
    	eM = new EmployeeManager();
        initComponents();
        loginID = id;
        EmployeeID = eM.getEmployeeIDbyloginID(id);//messageform으로 employeeID 보내기 위해 변환
        
        setBackground(new Color(0, 0, 0, 0));
        home = new Form_Home();
        form1 = new Form_AdRoom();
        form2 = new Form_AdReserv();
        form3 = new Form_AdEmployee(loginID);
        form4 = new Form_AdMember();
        form5 = new Form_AdMyPage(loginID);
        form6 = new Form_EmployeeMsg(EmployeeID);
        menu.initMoving(EmployeeMain.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            //각 메뉴 눌렀을 때 form 변환
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 2) {
                    setForm(form1);
                } else if (index == 3) {
                    setForm(form2);
                    form2.refresh();
                } else if (index == 4) {
                    setForm(form3);
                } else if (index == 5) {
                    setForm(form4);
                } else if (index == 9) {
                    setForm(form5);
                }else if (index ==10) {
                    setForm(form6);
                    form6.refresh();
                }else if (index ==12) {
                    System.exit(0);
                }
            }
        });
        //  set when system open start with home form
        setForm(new Form_Home());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new view.swing.PanelBorder();
        menu = new view.component.EmployeeMenu();   //메뉴
        header2 = new view.component.Header();
        mainPanel = new javax.swing.JPanel();
        	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));
        
        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(6)
        			.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(menu, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(51)
        			.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panelBorder1.setLayout(panelBorder1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
    	//로그인 시 관리자 loginID와 함께 로그인 메시지 console에 print
    	System.out.println(loginID+" 관리자로 로그인하였습니다.");
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeMain(loginID).setVisible(true);
            }
        });
    }

    private view.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private view.component.EmployeeMenu menu;
    private view.swing.PanelBorder panelBorder1;
   
}

