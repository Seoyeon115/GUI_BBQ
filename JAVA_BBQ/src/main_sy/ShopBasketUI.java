package main_sy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

public class ShopBasketUI implements ActionListener {
	// Field
	JFrame f;
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // �ɼ� ���� ��ư
	JButton btn_check, btn_back, btn_alldel, btn_order;
	JPanel top_panel, content_panel, menu_panel, total_panel, bottom_panel;
	JLabel total_label,price_label;
//	JTextField price;
	

	// Constructor
	public ShopBasketUI() {
		init();
	}

	// Method
	public void init() {
		f = new JFrame("��ٱ���");
		top_panel = new JPanel(new BorderLayout());
		content_panel = new JPanel(new BorderLayout());
//		content_panel.setBackground(new Color(255, 255, 255));
		content_panel.setBackground(Color.LIGHT_GRAY);
		JScrollPane content = new JScrollPane(content_panel); // ȸ�鿡 ��ũ�� �߰�
		f.add(content);
		menu_panel = new JPanel();
//		menu_panel.setBackground(new Color(255, 255, 255));
		menu_panel.setBackground(Color.pink);
		bottom_panel = new JPanel();
		total_panel = new JPanel();
//		total_panel.setBackground(new Color(255, 255, 255));
		total_panel.setBackground(Color.MAGENTA);
		content_panel.add(BorderLayout.CENTER,menu_panel);
		content_panel.add(BorderLayout.SOUTH,total_panel);
		
		total_label = new JLabel("�� �ֹ� �ݾ� : ");
		price_label = new JLabel(" 10000 �� ");
		total_panel.add(total_label);
		total_panel.add(price_label);
//		price = new JTextField();
//		total_panel.add(price);

		btn_back = new JButton("�ڷΰ���");
		btn_back.setBackground(new Color(255, 255, 255));
		btn_order = new JButton("   ����   ");
		top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
		top_panel.add(new JLabel("                                         ��ٱ���"));
		bottom_panel.add(btn_order);

		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, content_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);

		f.setSize(500, 450);

		Dimension fsize = f.getSize();   //â ��� ��ġ
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		f.setLocation(width, height);
		f.setVisible(true);

		btn_back.addActionListener(this);
		btn_order.addActionListener(this);
	}//init

	
	/** �����г� **/
	public void food() {
		
	}//food

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn_back) {   //�ڷΰ���
			System.out.println("�ڷ�");
			
		}else if(obj == btn_order) {
			System.out.println("�����ϱ�");
			new PayUI();
//		}else if(isInOption(obj)) {       //�ɼ�
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}//actionPerformed

}//ShopBasketUI
