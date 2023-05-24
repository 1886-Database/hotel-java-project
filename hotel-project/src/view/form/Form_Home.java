package view.form;

import javax.swing.ImageIcon;
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
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Form_Home extends JPanel {

	 public Form_Home() {
	        initComponents();
	        JPanel p = new JPanel();
	        p.setBackground(Color.WHITE);   
	        }

	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	    	panel = new javax.swing.JLayeredPane();
	        panelBorder1 = new view.swing.PanelBorder();
	        jLabel1 = new javax.swing.JLabel();
	        
	        setBackground(new java.awt.Color(242, 242, 242));
	        
	        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
	        
	        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

	        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
	        jLabel1.setText("Rooms");
	        
	        JButton btnNewButton_1 = new JButton("New button");
	        
	        btnNewButton = new JButton("New button");
	        
	        JScrollBar scrollBar = new JScrollBar();
	        
	        JButton btnNewButton_1_1 = new JButton("New button");
	        
	        JButton btnNewButton_1_2 = new JButton("New button");
	        
	        
	        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
	        panelBorder1Layout.setHorizontalGroup(
	        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(panelBorder1Layout.createSequentialGroup()
	        			.addGap(20)
	        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(panelBorder1Layout.createSequentialGroup()
	        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING, false)
	        						.addGroup(panelBorder1Layout.createSequentialGroup()
	        							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.UNRELATED)
	        							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
	        						.addGroup(panelBorder1Layout.createSequentialGroup()
	        							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        							.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)))
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(jLabel1))
	        			.addContainerGap())
	        );
	        panelBorder1Layout.setVerticalGroup(
	        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(panelBorder1Layout.createSequentialGroup()
	        			.addGap(20)
	        			.addComponent(jLabel1)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING, false)
	        				.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        				.addGroup(panelBorder1Layout.createSequentialGroup()
	        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING, false)
	        						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(btnNewButton_1_2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
	        					.addContainerGap())))
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
	    private JButton btnNewButton;
}
