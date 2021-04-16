package main_sy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main_jk.Commons;
import main_jk.ShopBasketUI;
import main_jk.StartUI;

public class PayUI implements ActionListener {
	// Field
	StartUI main;
	ShopBasketUI sb; // 활용 가능..?
	JFrame f;
	JPanel label_panel, tf_panel, top_panel, center_panel, bottom_panel, total_panel, menu_panel, addr_panel,
			panel_content;
	JButton btn_back, btn_pay, btn_cancel;
	JLabel addr_label, total_label, price_label;
	JTextField addr1_tf, addr2_tf;

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
		f = new JFrame("결제");
		f.getContentPane().setBackground(new Color(204, 0, 51));
		f.getContentPane().setForeground(new Color(255, 255, 255));
		f.setBounds(100, 90, 600, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);

		panel_content = new JPanel(new BorderLayout());
		panel_content.setBackground(new Color(255, 255, 255));
		panel_content.setBounds(30, 22, 520, 650);

		f.add(panel_content);
		f.setVisible(true);

		top_panel = new JPanel(new BorderLayout());
		top_panel.setBackground(new Color(255, 255, 255));
		center_panel = new JPanel(new BorderLayout());
		center_panel.setBackground(new Color(255, 255, 255));

		/** 주소 패널 **/
		addr_panel = new JPanel(new BorderLayout(2, 3));
		addr_label = new JLabel("        주소");
		addr1_tf = new JTextField(43);
		addr2_tf = new JTextField(43);
		/** 메뉴리스트 패널 **/
		menu_panel = new JPanel();
		menu_panel.setBackground(new Color(255, 255, 255));
		/** 결제금액 패널 **/
		total_panel = new JPanel();
		total_panel.setBackground(new Color(255, 255, 255));
		total_label = new JLabel("총 주문 금액 : ");
		price_label = new JLabel(" 10000 원 ");
		bottom_panel = new JPanel();

		// top_panel
		ImageIcon image_back = Commons.imageResize(new ImageIcon("images/homer.png"), 50, 40);
		ImageIcon image_backPressed = Commons.imageResize(new ImageIcon("images/homey.png"), 50, 40);
		btn_back = new JButton("", image_back);
		btn_back.setPressedIcon(image_backPressed);
		btn_back.setBorderPainted(false);
		btn_back.setContentAreaFilled(false);
		btn_back.setBounds(5, 0, 50, 40);
		btn_back.setPreferredSize(new Dimension(50, 40));

		ImageIcon logo_img = new ImageIcon("images/BBQ LOGO.png");
		Image img = logo_img.getImage();
		Image changeImg = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);

		top_panel.add(BorderLayout.WEST, btn_back);
		top_panel.add(new JLabel("                                         " + "          최종 결제"));
		top_panel.add(BorderLayout.EAST, img_label);

		// center_panel
		addr_panel.add(BorderLayout.WEST, addr_label);
		addr_panel.add(BorderLayout.EAST, addr1_tf);
		addr_panel.add(BorderLayout.EAST, addr2_tf);

		addr_panel.add(BorderLayout.WEST,addr_label);
		addr_panel.add(BorderLayout.EAST,addr1_tf);
		addr_panel.add(BorderLayout.EAST,addr2_tf);
		
		total_panel.add(total_label);
		total_panel.add(price_label);

		
		center_panel.add(BorderLayout.NORTH, addr_panel);
		center_panel.add(BorderLayout.CENTER, menu_panel);
		center_panel.add(BorderLayout.SOUTH, total_panel);

		// bottom_panel
		btn_cancel = new JButton("취소");
		btn_cancel.setBackground(new Color(255, 255, 255));
		btn_pay = new JButton("결제");
		btn_pay.setBackground(new Color(255, 255, 255));

		bottom_panel.add(btn_pay);
		bottom_panel.add(btn_cancel);

		// setting
		panel_content.add(BorderLayout.NORTH, top_panel);
		panel_content.add(BorderLayout.CENTER, center_panel);
		panel_content.add(BorderLayout.SOUTH, bottom_panel);

		f.setBounds(90, 90, 600, 750);
		f.setVisible(true);

		btn_back.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_pay.addActionListener(this);

	}// init

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_back) { // 뒤로가기
			System.out.println("뒤로");
			// 닫기
			new ShopBasketUI();
		} else if (obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("주문이 완료되었습니다."));
			// 닫기
		} else if (obj == btn_cancel) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("결제를 취소합니다."));
			// 닫기
			new StartUI();
//       }else if(isInOption(obj)) { //옵션
//         JCheckBox check = (JCheckBox) obj;
//         System.out.println(check.getText());
		}
	}// actionPerformed

}// PayUI