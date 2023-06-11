/**
 * 관리자 로그인 했을 때 관리자에게 보여지는 화면입니다.
 */

package DB2023188606_view.UI;

import java.awt.Color;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import DB2023188606_model.Employee;
import DB2023188606_modelManager.EmployeeManager;
import DB2023188606_view.event.EventMenuSelected;
import DB2023188606_view.form.Form_AdEmployee;
import DB2023188606_view.form.Form_AdMember;
import DB2023188606_view.form.Form_AdMyPage;
import DB2023188606_view.form.Form_AdReserv;
import DB2023188606_view.form.Form_AdRoom;
import DB2023188606_view.form.Form_EmployeeMsg;
import DB2023188606_view.form.Form_Home;

import javax.swing.GroupLayout;

public class EmployeeMain extends javax.swing.JFrame {

	/**
     * Creates new form EmployeeMain
     */
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
    
    /**
     * Creates new form EmployeeMain
     */
    public EmployeeMain(String id) {
    	eM = new EmployeeManager();
        initComponents();
        loginID = id;
        EmployeeID = eM.getEmployeeIDbyloginID(id);
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

    //메뉴 선택시 화면 전환
    /**
  	 * 메뉴 선택시 화면 전환하는 메소드입니다.
  	 */
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

   
    @SuppressWarnings("unchecked")
    /**
  	 * form을 초기 세팅하는 메소드입니다.
  	 */
    private void initComponents() {

        panelBorder1 = new DB2023188606_view.swing.PanelBorder();
        menu = new DB2023188606_view.component.EmployeeMenu();   //메뉴
        header2 = new DB2023188606_view.component.Header();
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
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
    	
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

    private DB2023188606_view.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private DB2023188606_view.component.EmployeeMenu menu;
    private DB2023188606_view.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}

