package view.UI;

import javax.swing.*; 
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;


import view.event.EventMenuSelected;
import view.form.Form_1;
import view.form.Form_2;
import view.form.Form_3;
import view.form.Form_Home;
import view.form.Form_EwhaHotel;
import view.form.Form_MemberMsg;
import view.form.Form_RoomReservation;
import view.form.Form_Reservation;
import view.form.Form_MyPage;
import view.form.Form_ViewMyReserv;

public class MemberMain extends javax.swing.JFrame {

	/**
     * Creates new form Main
     */
    private Form_Home home;
    private Form_RoomReservation form1;
    private Form_EwhaHotel form2;
    private Form_Reservation form3;
    private Form_MyPage form4;
    private Form_ViewMyReserv form5;
    private Form_MemberMsg form6;
    static String loginID="leda7"; 
    static int MemberID = 00001;//테스트를 위한 값 초기화... 마지막에 삭제해야함

    public MemberMain(String id) {
        initComponents();
        loginID = id;
        setBackground(new Color(0, 0, 0, 0));
        home = new Form_Home();
        
        form2 = new Form_EwhaHotel();
        form3 = new Form_Reservation();
        form4 = new Form_MyPage(loginID);
        form5 = new Form_ViewMyReserv(loginID);
        form6 = new Form_MemberMsg(MemberID);
        menu.initMoving(MemberMain.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(form1);
                } else if (index == 2) {
                    setForm(form2);
                } else if (index == 3) {
                    setForm(form3);
                } else if (index==7) { //마이페이지
                	setForm(form4);
                } else if (index==8) { //예약조회
                	setForm(form5);
                } else if (index==9) { //메시지
                	setForm(form6);
                } else if (index==11) 
                	System.exit(0);
       
                
            }
        });
        //  set when system open start with home form
        setForm(new Form_Home());
        
        form3.addButton1ActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String[] s = form3.dataArr();
               
               for(int i=0; i<s.length; ++i)
                   System.out.println(s[i]);
               form1 = new Form_RoomReservation(loginID,s);
               setForm(form1);
            }
         });
        
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new view.swing.PanelBorder();
        menu = new view.component.MemberMenu();   //메뉴
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	
    	System.out.println(loginID+" 회원으로 로그인하였습니다.");
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MemberMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberMain(loginID).setVisible(true);
            }
        });
    }

    private view.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private view.component.MemberMenu menu;
    private view.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
