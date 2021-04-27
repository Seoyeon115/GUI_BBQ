package BBQ_UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_SYSTEM.BBQ_System;
import BBQ_VO.OrderVO;

// 상세 메뉴창 미완성
public class OrderListUI implements ActionListener{
//	JFrame frame;
	InnerMain main;
	BBQ_System system;
	JPanel panel_content;
	JButton button_back;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	ArrayList<OrderVO> orderlist; // 주문 내역 리스트
	
	
	
	//Constructor
	// 생성자, 메뉴 정보를 매개변수로 받는다
		public OrderListUI(InnerMain main) {
			this.main = main;
			this.system = main.system;
//			init();
		}
		
	//Method	
	public JPanel init() {
		orderlist = system.getOrderList();
		
		// 프레임
//		frame = new JFrame();
//		frame.setResizable(false); // 크기 조절 불가
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 600, 910);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);
		
//		this.orderlist = new ArrayList<OrderVO>(); // DB에서 주문 내역 리스트를 불러와서 orderlist에 저장하기
		
		panel_content = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
		panel_content.setBackground(new Color(255, 255, 255));
		panel_content.setBounds(30, 22, 520, 820);
		
		// 패널 생성
		init_upper();
		init_list();
//		init_summary();
//		init_detail();
//		init_bottom();
		//
		
//		frame.add(panel_content);
//		frame.setVisible(true);
		
		return panel_content;
	}
	
	void init_upper() { // 맨 위 패널 생성
		JPanel panel_upper = new JPanel();
		panel_upper.setLayout(null);
		panel_upper.setBackground(new Color(255, 255, 255));
		panel_upper.setPreferredSize(new Dimension(520, 35));
		
		// 뒤로가기 버튼
		ImageIcon image_back = Commons.imageResize(new ImageIcon("images/homer.png"), 50, 40);
		ImageIcon image_backPressed = Commons.imageResize(new ImageIcon("images/homey.png"), 50, 40);
		
		button_back = new JButton("", image_back);
		button_back.setPressedIcon(image_backPressed);
		button_back.setBorderPainted(false);
		button_back.setContentAreaFilled(false);
		button_back.setBounds(5, 0, 50, 40);
		button_back.setPreferredSize(new Dimension(50, 40));
		button_back.addActionListener(this);
		panel_upper.add(button_back);
		
		panel_content.add(panel_upper);
	}
	
	void init_list() {
		JPanel panel_list = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
//		panel_list.setLayout(null);
		panel_list.setBackground(new Color(255, 255, 255));
		panel_list.setPreferredSize(new Dimension(480, 750));
		panel_list.setBorder(new LineBorder(new Color(204, 0, 51), 5, true));
		
		JPanel panel_inner = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
//		panel_inner.setLayout(null);
		panel_inner.setBackground(new Color(210, 210, 210));
		panel_inner.setPreferredSize(new Dimension(460, 700));
		
		JScrollPane scroll = new JScrollPane(panel_inner);
		scroll.setPreferredSize(new Dimension(470, 740));		
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scroll.setVerticalScrollBar(scroll.createVerticalScrollBar());
		scroll.setHorizontalScrollBar(null);
		scroll.setBorder(null);
		
		for(OrderVO order : orderlist) {
			JPanel panel_order = new JPanel();
			panel_order.setLayout(null);
			panel_order.setBackground(new Color(255, 255, 255));
			panel_order.setPreferredSize(new Dimension(470, 100));
			
			JLabel[] labels = new JLabel[3];
			labels[0] = new JLabel(order.getDate());
			labels[1] = new JLabel(order.getMenulist().get(0).getName() + " 외 "+ order.getMenulist().size() +"건");
			labels[2] = new JLabel("주문금액: "+ order.getPrice() +"원");
			
			for(int i=0;i<labels.length;i++) {
				labels[i].setFont(Commons.getFont(18));
				labels[i].setBounds(5, 5 + i*30, 440, 25);
				panel_order.add(labels[i]);
			}
			
			JButton button_detail = new JButton("상세보기");
			button_detail.setFont(Commons.getFont(15));
			button_detail.setBounds(340, 50, 100, 30);
			
			button_detail.addActionListener(this);
			panel_order.add(button_detail);
			buttons.add(button_detail);
			
			panel_inner.add(panel_order);
		}
		
		panel_list.add(scroll);
		
		panel_content.add(panel_list);
	}
	
	int orderCheck(Object obj) {
		int result = -1;
		
		for(int i=0;i<buttons.size();i++) {
			if(obj == buttons.get(i)) {
				result = i;
				i = buttons.size();
			}
		}
		
		return result;
	}
	
	// 이벤트 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_back) { // 뒤로가기 버튼 클릭
//			System.out.println("뒤로가기");
			panel_content.setVisible(false);
//			main.panelinit();
			main.switchPanel(InnerMain.MAIN);
		}else {
			int order = orderCheck(obj);
			if(order != -1) {
				panel_content.setVisible(false);
				main.switchPanel(InnerMain.ORDERDETAIL, orderlist.get(order));
			}
		}
	}
}
