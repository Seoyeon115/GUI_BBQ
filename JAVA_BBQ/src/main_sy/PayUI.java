package main_sy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PayUI implements ActionListener{
	// Field
	StartUI main;
	ShopBasketUI sb;        //활용 가능..?
	JFrame f;
	JPanel top_panel,content_panel,bottom_panel,total_panel,menu_panel,addr_panel;
	JButton btn_back,btn_pay;
	JLabel total_label,price_label;
	JTextField addr;

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
		f = new JFrame("결제창");
		top_panel = new JPanel(new BorderLayout());
		content_panel =  new JPanel(new BorderLayout());
		content_panel.setBackground(Color.LIGHT_GRAY);  
		bottom_panel =  new JPanel();
		btn_back = new JButton("뒤로가기");
		btn_back.setBackground(new Color(255, 255, 255));
		btn_pay = new JButton("결제");
		btn_pay.setBackground(new Color(255, 255, 255));
		
		/** 주소 패널 **/
		addr_panel = new JPanel();
		addr_panel.setBackground(Color.cyan);  
		/** 메뉴리스트 패널 **/
		menu_panel = new JPanel();
//		menu_panel.setBackground(new Color(255, 255, 255));
		menu_panel.setBackground(Color.pink);
		/** 결제버튼 패널 **/
		total_panel = new JPanel();
//		total_panel.setBackground(new Color(255, 255, 255));
		total_label = new JLabel("총 주문 금액 : ");
		price_label = new JLabel(" 10000 원 ");
		
		total_panel.setBackground(Color.MAGENTA);
		content_panel.add(BorderLayout.NORTH,addr_panel);
		content_panel.add(BorderLayout.CENTER,menu_panel);
		content_panel.add(BorderLayout.SOUTH,total_panel);
		
		
		
		
		total_panel.add(total_label);
		total_panel.add(price_label);
		top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
		top_panel.add(new JLabel("                                         최종 결제"));
//		top_panel.add(btn_back);
		f.add(top_panel);
		bottom_panel.add(btn_pay);
		f.add(bottom_panel);
		
		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, content_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);
		
		
		f.setSize(500, 450);
		f.setVisible(true);
		
		btn_back.addActionListener(this);
		btn_pay.addActionListener(this);
		
	}//init
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn_back) {   //뒤로가기
			System.out.println("뒤로");
			
		}else if(obj == btn_pay) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("주문이 완료되었습니다."));
//		}else if(isInOption(obj)) {       //옵션
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}//actionPerformed
	
	
	
}//PayUI
