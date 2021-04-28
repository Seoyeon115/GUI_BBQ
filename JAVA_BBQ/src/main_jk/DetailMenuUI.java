package main_jk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;

// 상세 메뉴창 미완성
public class DetailMenuUI implements ActionListener{
	InnerMain main;
	MenulistUI prevPage;
//	JFrame frame;
	JPanel panel_content;
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // 옵션 선택 버튼
	JButton button_back; // 뒤로가기 버튼
	JButton button_onCart; // 담기 버튼
	int price_final; // 메뉴 결제 가격
	MenuVO vo; // 메뉴 정보
	//Constructor
	// 생성자, 메뉴 정보를 매개변수로 받는다
		public DetailMenuUI(InnerMain main, MenulistUI prevPage) {
			this.main = main;
			this.prevPage = prevPage;
			
//			init();
		}
		
	//Method	
	public JPanel init(MenuVO vo) {
		
		this.vo = vo;
		this.price_final = vo.getPrice();
		
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
		init_image();
		init_nameNprice();
		init_desc();
		init_option();
		init_onCart();
		
//		frame.add(panel_content);
//		frame.setVisible(true);
		
		panel_content.setVisible(true);
		
		return panel_content;
	}
	
	void init_upper() { // 맨 위 패널 생성
		JPanel panel_upper = new JPanel();
		panel_upper.setLayout(null);
		panel_upper.setBackground(new Color(255, 255, 255));
		panel_upper.setPreferredSize(new Dimension(520, 50));
		
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
		
		
		
//		JPanel panel_title = new JPanel();
//		JLabel label_title = new JLabel("메뉴 상세 정보");
//		label_title.setHorizontalAlignment(JLabel.CENTER);
//		label_title.setFont(Commons.getFont(30));
//		panel_title.add(label_title);
//		panel_upper.add(label_title);
		panel_content.add(panel_upper);
	}
	
	void init_image() { // 이미지 패널 생성
		JPanel panel_image = new JPanel();
		panel_image.setBackground(new Color(255, 255, 255));
		panel_image.setPreferredSize(new Dimension(520, 285));
		JLabel label_image = new JLabel(Commons.imageResize(vo.getImage(), 450, 255));
		label_image.setBorder(new LineBorder(new Color(204, 0, 51), 5, true));
		panel_image.add(label_image);
		panel_content.add(panel_image);
	}
	
	void init_nameNprice() { // 이름, 가격 패널 생성
		JPanel panel_nameNprice = new JPanel();
		panel_nameNprice.setBackground(new Color(255, 255, 255));
		panel_nameNprice.setPreferredSize(new Dimension(520, 50));
		JLabel label_name = new JLabel(vo.getName());
		label_name.setFont(Commons.getFont(30));
		panel_nameNprice.add(label_name);
		
		JLabel label_price = new JLabel(String.valueOf(vo.getPrice()+"원"));
		label_price.setFont(Commons.getFont(20));
		panel_nameNprice.add(label_price);
		
		panel_content.add(panel_nameNprice);
	}
	
	void init_desc() { // 설명 패널
		JPanel panel_desc = new JPanel();
		panel_desc.setBackground(new Color(255, 255, 255));
		panel_desc.setPreferredSize(new Dimension(520, 50));
		JLabel label_desc = new JLabel(vo.getDesc());
		label_desc.setFont(Commons.getFont(15));
		panel_desc.add(label_desc);
		panel_content.add(panel_desc);
	}
	
	void init_option() {
		JPanel panel_options = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel_options.setBackground(new Color(255, 255, 255));
		panel_options.setPreferredSize(new Dimension(500, 305));
		panel_options.setBorder(new LineBorder(new Color(204, 0, 51), 5, true));
		
		JLabel label_option = new JLabel(" 추가 옵션");
		label_option.setFont(Commons.getFont(20));
		panel_options.add(label_option);
		
		JPanel panel_check = new JPanel();
		panel_check.setBackground(new Color(255, 255, 255));
		panel_check.setLayout(null);
		panel_check.setPreferredSize(new Dimension(498, 5 + vo.getOptions().size()*45));
		
		// 스크롤 추가
		JScrollPane scroll = new JScrollPane(panel_check);
		scroll.setPreferredSize(new Dimension(490, 258));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scroll.setVerticalScrollBar(scroll.createVerticalScrollBar());
		scroll.setHorizontalScrollBar(null);
		scroll.setBorder(null);
		
		int h =5; // 체크박스 높이 조정용
		for(OptionVO option : vo.getOptions()) {
			JPanel panel_option = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel_option.setBounds(5, h, 473, 40);
			h += 45;
			panel_option.setBackground(new Color(255, 255, 255));
			JCheckBox check_option = new JCheckBox(option.getOption()
										+ "(+" + option.getPrice() + ")");
			check_option.setBackground(new Color(255, 255, 255));
			check_option.setFont(Commons.getFont(15));
			
			panel_option.add(check_option);
			check_options.add(check_option);
			panel_check.add(panel_option);
			
			check_option.addActionListener(this);
		}
		panel_options.add(scroll);
		
		panel_content.add(panel_options);
	}
	
	void init_onCart() {
		JPanel panel_onCart = new JPanel(new GridLayout(1, 1));
		panel_onCart.setPreferredSize(new Dimension(520, 50));
		
		ImageIcon image_cart = Commons.imageResize(new ImageIcon("images/cartr.png"), 50, 50);
		ImageIcon image_cartPressed = Commons.imageResize(new ImageIcon("images/carty.png"), 50, 50);
		
		button_onCart = new JButton("장바구니 담기("+ price_final+"원)", image_cart);
		button_onCart.setPressedIcon(image_cartPressed);
		button_onCart.setFont(Commons.getFont(25));
		button_onCart.setBorderPainted(false);
		button_onCart.addActionListener(this);
		panel_onCart.add(button_onCart);
		panel_content.add(panel_onCart);
	}
	
	
	int isInOption(Object obj) { // 옵션 메뉴 선택인지 확인
		for(int i=0;i<check_options.size();i++) {
			if(obj == check_options.get(i)) {
				return i;
			}
		}
		return -1;
	}
	
	void clickOption(int idx, boolean state) { // 옵션 클릭 시 담기 버튼에 표시된 가격이 바뀜
		if(state) { // 체크를 했을 때
			price_final += vo.getOptions().get(idx).getPrice();
		}else { // 체크를 해제했을 때
			price_final -= vo.getOptions().get(idx).getPrice();
		}
		button_onCart.setText("장바구니 담기("+ price_final+"원)");
	}
	
	// 이벤트 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_onCart) { // 담기 버튼 클릭
			System.out.println("장바구니 담기");
		}else if(obj == button_back) { // 뒤로가기 버튼 클릭
//			System.out.println("뒤로가기");
			panel_content.setVisible(false);
			main.frame.add(prevPage.initialize());
		}else { // 옵션 메뉴 선택
			int op = isInOption(obj);
			if(op != -1) {
				clickOption(op, check_options.get(op).isSelected());
			}
		}
	}
}
