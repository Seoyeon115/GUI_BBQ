package main_jk;

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

import BBQ_DAO_jk.MemberDAO;
import BBQ_DAO_jk.OrderDAO;
import BBQ_VO.CartVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class PayUI implements ActionListener {
	// Field
	StartUI main;
	JFrame f;
	JPanel label_panel, tf_panel, top_panel, center_panel, bottom_panel, total_panel, menu_panel, addr_panel,
			panel_content;
	JButton btn_back, btn_pay, btn_cancel, btn_mdelete, btn_madd, btn_minus;
	JLabel addr_label, total_label, price_label, menu_label, option_label, m_price_label;
	JTextField addr1_tf, addr2_tf;
	int ttl_price;
	OrderDAO orderlist = new OrderDAO();
	MemberDAO mdao = new MemberDAO();
	BBQ_System system;
	OrderVO order = new OrderVO();
	ArrayList<JPanel> m_panel;
	

	int m_price;

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
		//예시값
		order.setOrderid("1001");
		order.setMenu("후라이드 치킨");
		order.setPrice(16000);
		order.setAmt(2);
		
		
		f = new JFrame("결제");
		f.getContentPane().setBackground(new Color(204, 0, 51));
		f.getContentPane().setForeground(new Color(255, 255, 255));
		f.setBounds(100, 90, 600, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);

		panel_content = new JPanel(new BorderLayout());
		panel_content.setBackground(new Color(255, 255, 255));
//	    panel_content.setBackground(Color.pink);
		panel_content.setBounds(30, 22, 520, 650);

		f.add(panel_content);
		f.setVisible(true);

		top_panel = new JPanel(new BorderLayout());
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
		
		/** menulist **/
		String
		
		

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
		
		//메뉴리스트
		JPanel pn = new JPanel(new GridLayout(3,1));
		JLabel name = new JLabel(order.getMenu());
		JLabel price = new JLabel(String.valueOf(order.getPrice()));
		JLabel amt = new JLabel(String.valueOf(order.getAmt()));
		pn.add(name);
		pn.add(price);
		pn.add(amt);
		menu_panel.add(pn);
		
		int totalprice = order.getPrice() * order.getAmt();
		JLabel total_label = new JLabel("총주문금액: " + totalprice + "원");
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

		f.setBounds(90, 90, 600, 750);
		f.setVisible(true);

		btn_back.addActionListener(this);
		btn_cancel.addActionListener(this);
		btn_pay.addActionListener(this);

	}// init

	/** 메뉴 생성 GUI **/
	public JPanel menulist() {
//		cvo = orderlist.getShopBasketResult(login.id);
//		ovo = orderlist.getShopBasketOption();
		
		m_panel = new ArrayList<JPanel>();
		
		int i;
		for (i = 0; i < cvo.size(); i++) {
			JPanel pc = new JPanel();

			f.add(pc, BorderLayout.CENTER);

			menu_panel = new JPanel(new GridLayout(1, 8)) {
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(50, 100);
				}
			};
			menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			pc.add(menu_panel);
			f.setVisible(true);
			
			
			menu_label = new JLabel();
			menu_label.setText(cvo.get(i).getRno() + ". 메뉴: " + cvo.get(i).getMenu() + cvo.get(i).getPrice());
			option_label = new JLabel();
			option_label.setText("옵션: " + ovo.get(i).getOption() + ovo.get(i).getPrice());
			m_price_label = new JLabel();
			m_price = ((cvo.get(i).getPrice() * cvo.get(i).getAmt()) + ovo.get(i).getPrice());
			m_price_label.setText("가격: " + m_price);
			ttl_price += m_price;
			int a = ((cvo.get(i).getPrice() * cvo.get(i).getAmt()) + ovo.get(i).getPrice());
			JLabel price_label = new JLabel(String.valueOf(a));
			price_label.setText("가격: " + price_label);
			ttl_price += a;

			JPanel left_panel = new JPanel(new GridLayout(3, 1));
			left_panel.add(menu_label);
			left_panel.add(option_label);
			left_panel.add(m_price_label);
			menu_panel.add(BorderLayout.WEST, left_panel);
		}
		return menu_panel;
	}// menulist

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_back) { // 뒤로가기
			f.setVisible(false);
			new ShopBasketUI();
		} else if (obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("주문이 완료되었습니다."));
			f.setVisible(false);
		} else if (obj == btn_cancel) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("결제를 취소합니다."));
			f.setVisible(false);
			new StartUI();
// 		}else if(isInOption(obj)) { //옵션
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}// actionPerformed

}// PayUI