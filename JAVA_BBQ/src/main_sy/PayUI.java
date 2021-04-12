package main_sy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PayUI implements ActionListener {
	// Field
	StartUI main;
	ShopBasketUI sb; // Ȱ�� ����..?
	JFrame f;
	JPanel top_panel, center_panel, bottom_panel, total_panel, menu_panel, addr_panel;
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
		center_panel.setBackground(Color.LIGHT_GRAY);   ///
//		center_panel.setBackground(new Color(255, 255, 255));
		/** �ּ� �г� **/
		addr_panel = new JPanel(new BorderLayout(2,3));
		addr_panel.setBackground(Color.cyan);   ///
		addr_label = new JLabel("�ּ�");
		addr1_tf = new JTextField(50);
		addr2_tf = new JTextField(50);
		
		/** �޴�����Ʈ �г� **/
		menu_panel = new JPanel();
//		menu_panel.setBackground(new Color(255, 255, 255));
		menu_panel.setBackground(Color.pink);   ///
		/** �����ݾ� �г� **/
		total_panel = new JPanel();
//		total_panel.setBackground(new Color(255, 255, 255));
		total_label = new JLabel("�� �ֹ� �ݾ� : ");
		price_label = new JLabel(" 10000 �� ");
		bottom_panel = new JPanel();

		// top_panel
		btn_back = new JButton("�ڷΰ���");
		btn_back.setBackground(new Color(255, 255, 255));
		total_panel.setBackground(Color.MAGENTA); ///

		top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
		top_panel.add(new JLabel("                                         ���� ����"));

		// center_panel
		addr_panel.add(BorderLayout.WEST,addr_label);
		addr_panel.add(BorderLayout.EAST,addr1_tf);
		addr_panel.add(BorderLayout.EAST,addr2_tf);
		
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
			System.out.println("�ڷ�");
			//�ݱ�
			new ShopBasketUI();
		} else if (obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("�ֹ��� �Ϸ�Ǿ����ϴ�."));
			//�ݱ�
		}else if(obj == btn_cancel) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("������ ����մϴ�."));
			//�ݱ�
			new StartUI();
// 		}else if(isInOption(obj)) { //�ɼ�
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}// actionPerformed

}// PayUI
