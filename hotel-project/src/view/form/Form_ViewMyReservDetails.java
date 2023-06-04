package view.form;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Form_ViewMyReservDetails extends JPanel {


	public Form_ViewMyReservDetails(String reservedNo) {
		initComponents();
		
	}
	
	private void initComponents() {
		setBackground(new java.awt.Color(242, 242, 242));
		panel = new javax.swing.JLayeredPane();
        panelBorder1 = new view.swing.PanelBorder();
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        
        add(panel);
        add(panelBorder1);
        
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(panelBorder1Layout.createSequentialGroup()
        					.addGap(45)
        			.addGap(24))
        )));
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(20)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGap(20))
        );
        panelBorder1.setLayout(panelBorder1Layout);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE))
        			.addGap(20))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(59)
        			.addGap(58))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(150)
        			.addGap(43)
        			.addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        			.addGap(18)
        			.addGap(16)))
        );
        this.setLayout(layout);
        
	}
	private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
}