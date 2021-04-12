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
import javax.swing.border.BevelBorder;

public class ShopBasketUI implements ActionListener {
	// Field
	JFrame f;
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // 옵션 선택 버튼
	JButton btn_check,btn_back,btn_alldel,btn_order,btn_pay,btn_all_delete,
			btn_mdelete, btn_madd, btn_minus;
	JPanel top_panel,content_panel,list_panel,menu_panel,total_panel,bottom_panel;
	JLabel total_label,price_label;
//	JTextField price;
	
	// Constructor
	public ShopBasketUI() {
		init();
	}

	// Method
	public void init() {
		f = new JFrame("장바구니");
		top_panel = new JPanel(new BorderLayout());
		content_panel = new JPanel(new BorderLayout());
//		content_panel.setBackground(new Color(255, 255, 255));
		content_panel.setBackground(Color.LIGHT_GRAY);   ///
		JScrollPane content = new JScrollPane(content_panel); // 회면에 스크롤 추가
		f.add(content);
		list_panel = new JPanel();
//		list_panel.setBackground(new Color(255, 255, 255));
		list_panel.setBackground(Color.pink);  ///
		bottom_panel = new JPanel();
		total_panel = new JPanel();
//		total_panel.setBackground(new Color(255, 255, 255));
		total_panel.setBackground(Color.MAGENTA);  ///
		
		//top_panel
		btn_back = new JButton("뒤로가기");
		btn_back.setBackground(new Color(255, 255, 255));
		btn_all_delete = new JButton("전체삭제");
		btn_all_delete.setBackground(new Color(255, 255, 255));
		top_panel.add(BorderLayout.WEST, new JPanel(new GridLayout(1, 1)).add(btn_back));
		top_panel.add(new JLabel("                                         장바구니"));
		top_panel.add(BorderLayout.EAST, new JPanel(new GridLayout(1, 1)).add(btn_all_delete));
		
		//content_panel
		menulist();
		content_panel.add(BorderLayout.CENTER,list_panel);
		content_panel.add(BorderLayout.SOUTH,total_panel);
		
		
		//total_panel
		total_label = new JLabel("총 주문 금액 : ");
		price_label = new JLabel(" 10000 원 ");
		total_panel.add(total_label);
		total_panel.add(price_label);
//		price = new JTextField();
//		total_panel.add(price);
		
		//bottom_panel
		btn_order = new JButton("추가 주문");
		btn_pay = new JButton("   결제    ");
		bottom_panel.add(btn_order);
		bottom_panel.add(btn_pay);
		
		//setting
		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, content_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);
		f.setBounds(100, 90, 600, 750);
		f.setVisible(true);

//		Dimension fsize = f.getSize();   //창 가운데 위치
//		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
//		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;
//		f.setLocation(width, height);

		btn_back.addActionListener(this);
		btn_order.addActionListener(this);
		btn_pay.addActionListener(this);
	}//init

	
	/** 메뉴 생성 GUI **/
	public void menulist() {
		JPanel pc = new JPanel();
		
		f.add(pc,BorderLayout.CENTER);
		
		menu_panel = new JPanel(new GridLayout(1,8)) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(50,100);
			}
		};
		menu_panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		pc.add(menu_panel);
		f.setVisible(true);

		JLabel menu_label = new JLabel("select menu");
		JLabel option_label = new JLabel("option");
		JLabel price_label = new JLabel("price");
		
		JPanel right_panel =new JPanel();
		JPanel left_panel =new JPanel(new GridLayout(3,1));
		btn_mdelete = new JButton("x");
		right_panel.setLayout(null);
		btn_mdelete.setBounds(245, 0, 40, 28);
		btn_madd = new JButton("+");
		btn_minus = new JButton("-");
		JTextField tf_madd = new JTextField(8);
		
		JPanel count_panel = new JPanel();
		count_panel.add(btn_minus);
		count_panel.add(tf_madd);
		count_panel.add(btn_madd);
		count_panel.setBounds(0,50, 300, 60);
		right_panel.add(btn_mdelete);
		right_panel.add(count_panel);
		left_panel.add(menu_label);
		left_panel.add(option_label);
		left_panel.add(price_label);
		
		menu_panel.add(BorderLayout.WEST, left_panel);
		menu_panel.add(BorderLayout.EAST, right_panel);
	
		list_panel.add(menu_panel);
		
		btn_mdelete.addActionListener(this);
		btn_madd.addActionListener(this);
		btn_minus.addActionListener(this);
	}//menulist

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn_back) {   //뒤로가기
			System.out.println("뒤로");
			new StartUI();
		}else if(obj == btn_order) {
			System.out.println("추가 주문");
//			new MenulistUI();
		}else if(obj == btn_pay) {
			System.out.println("결제하기");
			new PayUI();
		}else if(obj == btn_mdelete) {
			System.out.println("삭제");
			menu_panel.setVisible(false);
			list_panel.remove(menu_panel);
//		}else if(isInOption(obj)) {       //옵션
//			JCheckBox check = (JCheckBox) obj;
//			System.out.println(check.getText());
		}
	}//actionPerformed

}//ShopBasketUI
