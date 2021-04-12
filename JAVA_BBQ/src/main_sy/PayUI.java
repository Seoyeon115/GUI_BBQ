package main_sy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayUI implements ActionListener {
	// Field
	StartUI main;
	ShopBasketUI sb; // Ȱ�� ����..?
	JFrame f;
	JPanel label_panel,tf_panel,top_panel,center_panel,bottom_panel,total_panel,menu_panel,addr_panel;
	JButton btn_back, btn_pay, btn_cancel;
	JLabel addr_label,total_label,price_label;
	JTextField addr1_tf,addr2_tf;

	// Constructor
	public PayUI() {
		init();
	}

	public PayUI(StartUI main) {
		this.main = main;
		init();
	}

	// Method
	public void init() {
		f = new JFrame("����â");
		top_panel = new JPanel(new BorderLayout());
		center_panel = new JPanel(new BorderLayout());
//		center_panel.setBackground(new Color(255, 255, 255));
		/** �ּ� �г� **/
		addr_panel = new JPanel(new GridLayout(1,2));
		tf_panel = new JPanel(new GridLayout(2,1));
		label_panel = new JPanel();
		JPanel l_panel = new JPanel();
		addr_label = new JLabel("�ּ�");
		addr1_tf = new JTextField(25);
		addr2_tf = new JTextField(25);
		l_panel.add(addr_label);
		label_panel.add(BorderLayout.WEST,l_panel);
		JPanel t_panel = new JPanel(new GridLayout(2,1));
		t_panel.add(addr1_tf);
		t_panel.add(addr2_tf);
		tf_panel.add(BorderLayout.EAST,t_panel);
		
		/** �޴�����Ʈ �г� **/
		menu_panel = new JPanel();
//		menu_panel.setBackground(new Color(255, 255, 255));
		menu_panel.setBackground(Color.pink);   ///
//		sb.menulist();
		/** �����ݾ� �г� **/
		total_panel = new JPanel();
//		total_panel.setBackground(new Color(255, 255, 255));
		total_label = new JLabel("�� �ֹ� �ݾ� : ");
		price_label = new JLabel(" 10000 �� ");
		bottom_panel = new JPanel();

		// top_panel
		btn_back = new JButton("<");
		btn_back.setBackground(new Color(255, 255, 255));
		total_panel.setBackground(Color.MAGENTA); ///

		top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
		top_panel.add(new JLabel("     			                      		                                          ���� ����"));

		// center_panel
		addr_panel.add(label_panel);
		addr_panel.add(tf_panel);
		
		total_panel.add(price_label);
		total_panel.add(total_label);
		
		center_panel.add(BorderLayout.NORTH, addr_panel);
		center_panel.add(BorderLayout.CENTER, menu_panel);
		center_panel.add(BorderLayout.SOUTH, total_panel);

		// bottom_panel
		btn_cancel = new JButton("���");
		btn_cancel.setBackground(new Color(255, 255, 255));
		btn_pay = new JButton("����");
		btn_pay.setBackground(new Color(255, 255, 255));

		bottom_panel.add(btn_cancel);
		bottom_panel.add(btn_pay);

		// setting
		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, center_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);

		f.setBounds(90, 90, 600, 750);
		f.setVisible(true);

		btn_back.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_pay.addActionListener(this);

	}// init

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_back) { // �ڷΰ���
			f.setVisible(false);
			new ShopBasketUI();
		} else if (obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("�ֹ��� �Ϸ�Ǿ����ϴ�."));
			f.setVisible(false);
		}else if(obj == btn_cancel) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("������ ����մϴ�."));
			f.setVisible(false);
			new StartUI();
// 		}else if(isInOption(obj)) { //�ɼ�
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}// actionPerformed

}// PayUI
