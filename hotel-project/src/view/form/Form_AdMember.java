package view.form;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class Form_AdMember extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Form_AdMember() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(293, 45, 579, 458);
		add(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 123, 129, 27);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("등급");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel.setBounds(35, 127, 61, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성함");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(35, 206, 61, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("아이디");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(35, 276, 61, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("휴대폰 번호");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(35, 338, 61, 16);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("생년월일");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(35, 402, 61, 16);
		add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(127, 201, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 271, 130, 26);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 333, 130, 26);
		add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(128, 392, 129, 26);
		add(dateChooser);

	}
}
