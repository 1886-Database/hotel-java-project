package view.form;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Form_ViewMyReservDetails extends JPanel {

	
	public Form_ViewMyReservDetails(int reservedNo) {
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
        
        lblReservationDetails = new JLabel("Reservation Details");
        lblReservationDetails.setForeground(Color.GRAY);
        lblReservationDetails.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        JPanel panel_img = new JPanel();

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(51)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblReservationDetails, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(447, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addGap(33)
        			.addComponent(lblReservationDetails)
        			.addGap(37)
        			.addComponent(panel_img, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(142, Short.MAX_VALUE))
        );
        panelBorder1.setLayout(panelBorder1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panelBorder1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
        			.addGap(20))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        			.addGap(35))
        );
        this.setLayout(layout);

	}
	
	private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private JLabel lblReservationDetails;
}