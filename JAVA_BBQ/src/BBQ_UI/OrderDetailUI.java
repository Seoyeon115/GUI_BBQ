package BBQ_UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

// 상세 메뉴창 미완성
public class OrderDetailUI implements ActionListener{
	InnerMain main;
//	JFrame frame;
	JPanel panel_content;
	JButton button_back, button_prev, button_next;
	
	OrderVO vo; // 주문 정보
	
	
	
	//Constructor
	// 생성자, 메뉴 정보를 매개변수로 받는다
		public OrderDetailUI(InnerMain main) {
			this.main = main;
		}
		
	//Method	
	public JPanel init(OrderVO vo) {
		this.vo = vo;
		// 프레임
//		frame = new JFrame();
//		frame.setResizable(false); // 크기 조절 불가
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 600, 910);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(null);
		
		panel_content = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
		panel_content.setBackground(new Color(255, 255, 255));
		panel_content.setBounds(30, 22, 520, 820);
		
		// 패널 생성
		init_upper();
		init_summary();
		init_detail();
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
	
	void init_summary() { // 주문 개요
		JPanel panel_space = new JPanel();
		panel_space.setLayout(null);
		panel_space.setBackground(new Color(255, 255, 255));
		panel_space.setPreferredSize(new Dimension(520, 25));
		
		JLabel label_title = new JLabel("주문 개요");
		label_title.setFont(Commons.getFont(15));
		label_title.setBounds(25, 5, 100, 20);
		panel_space.add(label_title);
		
		JPanel panel_summary = new JPanel();
//		panel_summary.setLayout(new BoxLayout(panel_summary, BoxLayout.Y_AXIS));
		panel_summary.setLayout(null);
		panel_summary.setBackground(new Color(255, 255, 255));
		panel_summary.setPreferredSize(new Dimension(480, 300));
		panel_summary.setBorder(new LineBorder(new Color(204, 0, 51), 5, true));
		
		// 주문일시, 배달주소, 주문금액, 할인금액, 배달료, 결제금액, 요청사항
		String[] titles = {"주문일시", "배달주소", "결제금액", "요청사항"};
		String[] contents = {vo.getDate(), vo.getAddr(), 
				String.valueOf(vo.getPrice()), vo.getMessage()};
		for(int i=0;i<titles.length;i++) {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.setBackground(new Color(255, 255, 255));
			panel.setPreferredSize(new Dimension(460, 40));
			panel.setBounds(10, 10 + i*40, 460, 40);
			JLabel label = new JLabel(titles[i] +": "+contents[i]);
			label.setFont(Commons.getFont(15));
			panel.add(label);
			panel_summary.add(panel);
		}
		
		panel_content.add(panel_space);
		panel_content.add(panel_summary);
	}
	
	void init_detail() {
		JPanel panel_space = new JPanel();
		panel_space.setLayout(null);
		panel_space.setBackground(new Color(255, 255, 255));
		panel_space.setPreferredSize(new Dimension(520, 25));
		
		JLabel label_title = new JLabel("상세 주문 내용");
		label_title.setFont(Commons.getFont(15));
		label_title.setBounds(25, 5, 100, 20);
		panel_space.add(label_title);
		
		JPanel panel_detail = new JPanel();
		panel_detail.setBackground(new Color(255, 255, 255));
		panel_detail.setPreferredSize(new Dimension(480, 385));
		panel_detail.setBorder(new LineBorder(new Color(204, 0, 51), 5, true));
		
		int height = 5;
		for(MenuVO menu : vo.getMenulist()) {
			int size_panel = 25 + 17 * menu.getOptions().size();
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.setBackground(new Color(255, 255, 255));
			panel.setPreferredSize(new Dimension(460, size_panel));
//			panel.setLayout(null);
			JLabel label_menu = new JLabel(menu.getName() +"("+ menu.getPrice() +")");
			label_menu.setFont(Commons.getFont(12));
			label_menu.setPreferredSize(new Dimension(460, 15));
//			label_menu.setBounds(0, height, 460, 50);
			panel.add(label_menu);
			
			for(OptionVO option : menu.getOptions()) {
				height += 10;
				JLabel label_option = new JLabel(" + "+ option.getName() +"("+ option.getPrice() +")");
				label_option.setFont(Commons.getFont(10));
				label_option.setPreferredSize(new Dimension(460, 12));
//				label_option.setBounds(5, height, 460, 50);
				panel.add(label_option);
			}
			panel_detail.add(panel);
		}
		
		panel_content.add(panel_space);
		panel_content.add(panel_detail);
	}
	
	void init_bottom() {
		JPanel panel_bottom = new JPanel();
		panel_bottom.setLayout(null);
		panel_bottom.setBackground(new Color(255, 255, 255));
		panel_bottom.setPreferredSize(new Dimension(520, 35));
		
		ImageIcon image_prev = Commons.imageResize(new ImageIcon("images/leftr.png"), 50, 40);
		ImageIcon image_prevPressed = Commons.imageResize(new ImageIcon("images/lefty.png"), 50, 40);
		
		button_prev = new JButton("", image_prev);
		button_prev.setPressedIcon(image_prevPressed);
		button_prev.setBorderPainted(false);
		button_prev.setContentAreaFilled(false);
		button_prev.setBounds(210, 0, 50, 40);
		button_prev.setPreferredSize(new Dimension(50, 40));
		button_prev.addActionListener(this);		
		panel_bottom.add(button_prev);
		
		ImageIcon image_next = Commons.imageResize(new ImageIcon("images/rightr.png"), 50, 40);
		ImageIcon image_nextPressed = Commons.imageResize(new ImageIcon("images/righty.png"), 50, 40);
		
		button_next = new JButton("", image_next);
		button_next.setPressedIcon(image_nextPressed);
		button_next.setBorderPainted(false);
		button_next.setContentAreaFilled(false);
		button_next.setBounds(260, 0, 50, 40);
		button_next.setPreferredSize(new Dimension(50, 40));
		button_next.addActionListener(this);
		panel_bottom.add(button_next);
		
		panel_content.add(panel_bottom);
	}
	
	
	// 이벤트 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_back) { // 뒤로가기 버튼 클릭
//			System.out.println("뒤로가기");
			panel_content.setVisible(false);
			main.switchPanel(InnerMain.ORDERLIST);
		}
	}
}
