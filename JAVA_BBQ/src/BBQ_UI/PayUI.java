package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import BBQ_DAO.OrderDAO;
import BBQ_SYSTEM.BBQ_System;
import BBQ_VO.CartVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class PayUI implements ActionListener {
	// Field
	InnerMain main;
	JFrame f;
	JPanel label_panel, tf_panel, top_panel, center_panel, bottom_panel, total_panel, menu_panel, addr_panel,
			panel_content,pn_panel;
	JButton btn_back, btn_pay, btn_cancel, btn_mdelete, btn_madd, btn_minus;
	JLabel addr_label, total_label, price_label, menu_label, option_label, m_price_label;
	JTextField addr1_tf, addr2_tf;
	int ttl_price;
	OrderDAO orderlist = new OrderDAO();
	BBQ_System system = new BBQ_System();
	OrderVO order = new OrderVO();
	ArrayList<CartVO> cart;

	int m_price;

	// Constructor
	public PayUI() {
		init();
	}

	public PayUI(InnerMain main) {
		this.main = main;
		init();
	}

	// Method
	public JPanel init() {

		panel_content = new JPanel(new BorderLayout());
		panel_content.setBackground(new Color(255, 255, 255));
//	    panel_content.setBackground(Color.pink);
		panel_content.setBounds(30, 22, 520, 650);

		top_panel = new JPanel();
		top_panel.setBackground(new Color(255, 255, 255));
		center_panel = new JPanel(new BorderLayout());
		center_panel.setBackground(new Color(255, 255, 255));
		bottom_panel = new JPanel();

		/** 주소 패널 **/
		addr_panel = new JPanel(new BorderLayout(2, 3));
		tf_panel = new JPanel(new GridLayout(2, 1));
		addr_label = new JLabel("           주소");
		addr1_tf = new JTextField(40);
		addr2_tf = new JTextField(40);

		/** 메뉴리스트 패널 **/
		menu_panel = new JPanel(new GridLayout(6, 1));
		menu_panel.setBackground(new Color(255, 255, 255));
		/** 결제금액 패널 **/
		total_panel = new JPanel();
		total_panel.setBackground(new Color(255, 255, 255));

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
		tf_panel.add(addr1_tf);
		tf_panel.add(addr2_tf);
		addr_panel.add(BorderLayout.WEST, addr_label);
		addr_panel.add(BorderLayout.EAST, tf_panel);

		menulist();

		JLabel total_label = new JLabel("총주문금액: " + m_price + "원");
		total_panel.add(total_label);

		center_panel.add(BorderLayout.NORTH, addr_panel);
		center_panel.add(BorderLayout.CENTER, menu_panel);
		center_panel.add(BorderLayout.SOUTH, total_panel);

		// bottom_panel
		btn_cancel = new JButton("취소");
		btn_cancel.setBackground(new Color(255, 255, 255));
		btn_pay = new JButton("결제");
		btn_pay.setBackground(new Color(255, 255, 255));

		bottom_panel.add(btn_cancel);
		bottom_panel.add(btn_pay);

		// setting
		panel_content.add(BorderLayout.NORTH, top_panel);
		panel_content.add(BorderLayout.CENTER, center_panel);
		panel_content.add(BorderLayout.SOUTH, bottom_panel);

		JScrollPane content = new JScrollPane(center_panel);
		panel_content.add(content);

		btn_back.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_pay.addActionListener(this);

		return panel_content;
	}// init

	/** 메뉴 생성 GUI **/
//	public JPanel menulist() {
	public void menulist() {
		cart = system.getCart();
		for (int i = 0; i < cart.size(); i++) {
//			JPanel pc = new JPanel();
//
//			f.add(pc, BorderLayout.CENTER);

			menu_panel = new JPanel(new GridLayout(1, 8)) {
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(50, 100);
				}
			};
			menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

			MenuVO menu = cart.get(i).getMenu();
			ArrayList<OptionVO> options = cart.get(i).getOptions();

//			menu_label = new JLabel();
			menu_label.setText("메뉴: " + menu.getName() + cart.get(i).getPrice());
			;
			System.out.println("2222");

			String optionInfo = "";
			for (OptionVO op : options) {
				if (optionInfo.equals(""))
					optionInfo = op.getName() + "(" + op.getPrice() + ")";
				else
					optionInfo += " / " + op.getName() + "(" + op.getPrice() + ")";
			}
			option_label = new JLabel();
			option_label.setText("옵션: " + optionInfo);
			m_price_label = new JLabel();
			m_price = ((cart.get(i).getPrice() * cart.get(i).getAmt()));
			m_price_label.setText("가격: " + m_price);
			JPanel left_panel = new JPanel(new GridLayout(3, 1));
			left_panel.add(menu_label);
			left_panel.add(option_label);
			left_panel.add(m_price_label);
			menu_panel.add(BorderLayout.WEST, left_panel);
//			center_panel.add(menu_panel);

		}
//		return menu_panel;
	}// menulist

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_back) { // 뒤로가기
			new ShopBasketUI();
		} else if (obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("주문이 완료되었습니다."));
		} else if (obj == btn_cancel) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("결제를 취소합니다."));
			new StartUI();
// 		}else if(isInOption(obj)) { //옵션
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}// actionPerformed

}// PayUI