package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import BBQ_VO.MenuVO;

// 상세 메뉴창 미완성
public class DetailMenuUI implements ActionListener{
	JFrame frame; // 창
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // 옵션 선택 버튼
	JButton button_onCart; // 담기 버튼
	JButton button_back; // 뒤로가기 버튼
	
	MenuVO vo; // 메뉴 정보
	
	// 생성자, 메뉴 정보를 매개변수로 받는다
	DetailMenuUI(MenuVO vo) {
		this.vo = vo;
		init();
	}
	
	void init() { // UI 초기화
		frame = new JFrame();
		frame.setBackground(new Color(204, 0, 51));
		frame.setResizable(false);
		
		// 메인 패널
		JPanel panel_content = new JPanel();
//		panel_content.setBackground(new Color(0, 0, 0));
		panel_content.setLayout(new BoxLayout(panel_content, BoxLayout.Y_AXIS));
//		panel_content.setBorder(new LineBorder(Color.red));
		
		// 맨 위 패널
		JPanel panel_upper = new JPanel(new BorderLayout());
		panel_upper.setBackground(new Color(255, 255, 255));
		button_back = new JButton("뒤로가기");
		button_back.setBackground(new Color(255, 255, 255));
		panel_upper.add(BorderLayout.WEST,
				new JPanel(new GridLayout(1, 1)).add(button_back));
		JPanel panel_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label_title = new JLabel("메뉴 상세 정보");
		panel_title.add(label_title);
		panel_upper.add(BorderLayout.CENTER, panel_title);
		frame.add(BorderLayout.NORTH, panel_upper);
		
		// 이미지 패널
		JPanel panel_image = new JPanel();
		JLabel label_image = new JLabel(imageResize(vo.getImage()));
		label_image.setBorder(new LineBorder(Color.red));
		panel_image.add(label_image);
		panel_content.add(panel_image);
		
		// 메뉴명&가격 패널
		JPanel panel_nameNprice = new JPanel();
		JLabel label_name = new JLabel(vo.getName());
		label_name.setFont(Commons.getFont());
		panel_nameNprice.add(BorderLayout.WEST, label_name);
		panel_content.add(panel_nameNprice);
		
		JLabel label_price = new JLabel(String.valueOf(vo.getPrice()+"원"));
		label_price.setFont(Commons.getFont());
		panel_nameNprice.add(BorderLayout.EAST, label_price);
		
		// 메뉴 설명 패널
		JPanel panel_desc = new JPanel();
		JLabel label_desc = new JLabel(vo.getDesc());
		label_desc.setFont(Commons.getFont());
		panel_desc.add(label_desc);
		panel_content.add(panel_desc);
		
		// 옵션 패널
		int option_size = vo.getOptions().size();
		JPanel panel_options = new JPanel(new GridLayout(option_size, 3));
//		panel_options.setBackground(new Color(0,0,0));
		panel_options.setBorder(new LineBorder(Color.red, 1, true));
		for(String str : vo.getOptions()) {
			JPanel panel_option = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JCheckBox check_option = new JCheckBox(str);
			check_option.setFont(Commons.getFont());
			
			panel_option.add(check_option);
			check_options.add(check_option);
			panel_options.add(panel_option);
			
			check_option.addActionListener(this);
		}
		panel_content.add(panel_options);
		
		// 담기 버튼
		JPanel panel_onCart = new JPanel(new GridLayout(1, 1));
		button_onCart = new JButton("장바구니 담기");
		button_onCart.setFont(Commons.getFont());
		button_onCart.addActionListener(this);
		panel_onCart.add(button_onCart);
		panel_content.add(BorderLayout.SOUTH, panel_onCart);
		
		// 스크롤 추가
		JScrollPane content = new JScrollPane(panel_content); // 회면에 스크롤 추가
		frame.add(content);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	ImageIcon imageResize(ImageIcon icon) { // 이미지 크기 조절
		Image image = icon.getImage();
		image = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		return new ImageIcon(image);
	}
	
	
	boolean isInOption(Object obj) { // 옵션 메뉴 선택인지 확인
		for(JCheckBox check : check_options) {
			if(obj == check) {
				return true;	
			}
		}
		return false;
	}
	
	// 이벤트 동작
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_onCart) { // 담기 버튼 클릭
			System.out.println("장바구니 담기");
		}else if(obj == button_back) { // 뒤로가기 버튼 클릭
			//
		}else if(isInOption(obj)) {
			JCheckBox check = (JCheckBox) obj;
			System.out.println(check.getText());
		}
	}
}
