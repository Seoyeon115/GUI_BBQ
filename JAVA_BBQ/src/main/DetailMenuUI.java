package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BBQ_VO.MenuVO;

// �� �޴�â �̿ϼ�
public class DetailMenuUI implements ActionListener{
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // �ɼ� ���� ��ư
	JButton button_onCart; // ��� ��ư
	JButton button_back; // �ڷΰ��� ��ư
	
	MenuVO vo; // �޴� ����
	
	///////////
	//Field
	
	JFrame frame = new JFrame();
	JPanel panel_content;
	
	//Constructor
	// ������, �޴� ������ �Ű������� �޴´�
		public DetailMenuUI(MenuVO vo) {
			this.vo = vo;
			init();
		}
	//Method
	
	public void init() {
		// ������
		frame = new JFrame();
		frame.setResizable(false); // ũ�� ���� �Ұ�
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 600, 910);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		panel_content = new JPanel();
		panel_content.setBackground(new Color(255, 255, 255));
		panel_content.setBounds(30, 22, 520, 820);
		
		// �г� ����
		init_upper();
		init_image();
		init_nameNprice();
		init_desc();
		init_option();
		init_onCart();
		
		frame.add(panel_content);
		frame.setVisible(true);
	}
	
	void init_upper() { // �� �� �г� ����
		JPanel panel_upper = new JPanel();
		panel_upper.setLayout(null);
		panel_upper.setBackground(new Color(255, 255, 255));
		panel_upper.setPreferredSize(new Dimension(520, 50));
		
		// �ڷΰ��� ��ư
		ImageIcon image_back = Commons.imageResize(new ImageIcon("images/921.png"), 50, 40);
		
		button_back = new JButton("", image_back);
		button_back.setBorderPainted(false);
		button_back.setContentAreaFilled(false);
		button_back.setBounds(5, 0, 50, 40);
		button_back.setPreferredSize(new Dimension(50, 40));
		button_back.addActionListener(this);
		
		panel_upper.add(button_back);
		
		
		
//		JPanel panel_title = new JPanel();
//		JLabel label_title = new JLabel("�޴� �� ����");
//		label_title.setHorizontalAlignment(JLabel.CENTER);
//		label_title.setFont(Commons.getFont(30));
//		panel_title.add(label_title);
//		panel_upper.add(label_title);
		panel_content.add(panel_upper);
	}
	
	void init_image() { // �̹��� �г� ����
		JPanel panel_image = new JPanel();
		panel_image.setBackground(new Color(255, 255, 255));
		panel_image.setPreferredSize(new Dimension(520, 285));
		JLabel label_image = new JLabel(Commons.imageResize(vo.getImage(), 300, 150));
		label_image.setBorder(new LineBorder(Color.red));
		panel_image.add(label_image);
		panel_content.add(panel_image);
	}
	
	void init_nameNprice() { // �̸�, ���� �г� ����
		JPanel panel_nameNprice = new JPanel();
		panel_nameNprice.setBackground(new Color(255, 255, 255));
		panel_nameNprice.setPreferredSize(new Dimension(520, 50));
		JLabel label_name = new JLabel(vo.getName());
		label_name.setFont(Commons.getFont(30));
		panel_nameNprice.add(label_name);
		
		JLabel label_price = new JLabel(String.valueOf(vo.getPrice()+"��"));
		label_price.setFont(Commons.getFont(20));
		panel_nameNprice.add(label_price);
		
		panel_content.add(panel_nameNprice);
	}
	
	void init_desc() { // ���� �г�
		JPanel panel_desc = new JPanel();
		panel_desc.setBackground(new Color(255, 255, 255));
		panel_desc.setPreferredSize(new Dimension(520, 50));
		JLabel label_desc = new JLabel(vo.getDesc());
		label_desc.setFont(Commons.getFont());
		panel_desc.add(label_desc);
		panel_content.add(panel_desc);
	}
	
	void init_option() {
		int option_size = vo.getOptions().size();
		JPanel panel_options = new JPanel(new GridLayout(option_size, 1));
		panel_options.setBackground(new Color(255, 255, 255));
		panel_options.setPreferredSize(new Dimension(520, 300));
		panel_options.setBorder(new LineBorder(Color.red, 1, true));
		for(String str : vo.getOptions()) {
			JPanel panel_option = new JPanel();
			JCheckBox check_option = new JCheckBox(str);
			check_option.setFont(Commons.getFont());
			
			panel_option.add(check_option);
			check_options.add(check_option);
			panel_options.add(panel_option);
			
			check_option.addActionListener(this);
		}
		panel_content.add(panel_options);
	}
	
	void init_onCart() {
		JPanel panel_onCart = new JPanel(new GridLayout(1, 1));
		panel_onCart.setPreferredSize(new Dimension(520, 50));
		
		ImageIcon image_cart = Commons.imageResize(new ImageIcon("images/593.png"), 50, 50);
		button_onCart = new JButton("��ٱ��� ���", image_cart);
		button_onCart.setFont(Commons.getFont());
		button_onCart.addActionListener(this);
		panel_onCart.add(button_onCart);
		panel_content.add(panel_onCart);
	}
	
	
	boolean isInOption(Object obj) { // �ɼ� �޴� �������� Ȯ��
		for(JCheckBox check : check_options) {
			if(obj == check) {
				return true;	
			}
		}
		return false;
	}
	
	// �̺�Ʈ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_onCart) { // ��� ��ư Ŭ��
			System.out.println("��ٱ��� ���");
		}else if(obj == button_back) { // �ڷΰ��� ��ư Ŭ��
			System.out.println("�ڷΰ���");
		}else if(isInOption(obj)) {
			JCheckBox check = (JCheckBox) obj;
			System.out.println(check.getText());
		}
	}
}
