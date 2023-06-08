package view.form;

import javax.swing.ImageIcon;
import java.awt.image.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.model.StatusType;
import view.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.model.StatusType;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Form_EwhaHotel extends javax.swing.JPanel {
	
	
    public Form_EwhaHotel() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);   
        
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	panel = new javax.swing.JLayeredPane();
    	setBackground(new java.awt.Color(242, 242, 242));
        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        
        panelBorder1 = new view.swing.PanelBorder();
        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        JScrollPane scroll = new JScrollPane(panelBorder1);
        
        //호텔INFO 부분
        INFOIMG= new JPanel() {
        	Image background = new ImageIcon(getClass().getResource("/view/icon/호텔썸네일.jpg")).getImage();
        	public void paint(Graphics g) {
        		g.drawImage(background, 0, 0, null);
        	}
        };
        INFOIMG.setLayout(null);
        INFOIMG.setVisible(true);
        InfoLabel = new JLabel("<html><body><center>국내 최고의 럭셔리 비즈니스 호텔인 이화호텔 서울은 <br> 최고급 서비스를 제공하며 서울 아현동에 자리잡고 있습니다. <br> 1886년도에 설립된 전통있는 호텔로, 이화의 정신이 담겨있습니다.</center></body></html>");
        InfoLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        InfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        //ROOMS&SUITE 부분
        JPanel RSIMG = new JPanel() {
        	Image background = new ImageIcon(getClass().getResource("/view/icon/조식.png")).getImage();
        	public void paint(Graphics g) {
        		g.drawImage(background, 0, 0, null);
        	}
        };
        RSIMG.setLayout(null);
        RSIMG.setVisible(true);
        JLabel RSLabel = new JLabel();
        RSLabel.setText("ROOMS&SUITE");
        RSLabel.setHorizontalAlignment(SwingConstants.CENTER);
        RSLabel.setForeground(new Color(127, 127, 127));
        RSLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        RSLabel_1 = new JLabel("고객님의 여유로운 호텔스테이를 위해 조식서비스를 제공해드립니다");
        RSLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        RSLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        
        
        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1Layout.setHorizontalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(INFOIMG, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
        					.addComponent(RSIMG, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(RSLabel_1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
        				.addComponent(InfoLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        				.addComponent(RSLabel, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
        			
        			.addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
        	panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelBorder1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(INFOIMG, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(InfoLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addComponent(RSLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(panelBorder1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(RSLabel_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        				.addComponent(RSIMG, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        			
        			
        			.addContainerGap())
        );
        panelBorder1.setLayout(panelBorder1Layout);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panelBorder1, GroupLayout.PREFERRED_SIZE, 860, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panelBorder1, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JLayeredPane panel;
    private view.swing.PanelBorder panelBorder1;
    private JLabel InfoLabel;
    private JLabel RSLabel_1;
    private JPanel INFOIMG;
}
