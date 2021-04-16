package main_sy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BBQ_GUI.Commons;

public class MenulistUI implements ActionListener {
//	JFrame frame = new JFrame();
	JButton btn_sidepage;
	JButton btn_home;
	JButton btn_cart;
	JPanel panel;
	InnerMain main;
	MenulistUI2 list2;
	
	public MenulistUI() {
		
	}
	public MenulistUI(InnerMain main) {
		this.main = main;
		initialize();
		list2 = new MenulistUI2(this,main);
	}
	
	public JPanel initialize() {
//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 600, 910);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 22, 520, 820);
		
		
		ImageIcon icon1 = new ImageIcon("images/normal.png");
		ImageIcon icon2 = new ImageIcon("images/half.png");
		ImageIcon icon3 = new ImageIcon("images/rip.png");
		
		
		//menu1
		
		
		JPanel menu1 = new JPanel(new BorderLayout());
		menu1.setBounds(0, 0, 520, 273);
		menu1.setBackground(new Color(255, 255, 255));
		JLabel menu1_image = new JLabel(icon1);
		JLabel menu1_lb = new JLabel("황금올리브 치킨 17000원");
		menu1_lb.setFont(Commons.getFont(16));
		
		JPanel menu1_btn_panel = new JPanel();
		menu1_btn_panel.setBackground(new Color(255, 255, 255));
		menu1_btn_panel.add(menu1_lb);
		
		//홈버튼 장바구니버튼 넣기
		ImageIcon home = new ImageIcon("images/homer.png");
		ImageIcon home2 = new ImageIcon("images/homey.png");
		ImageIcon cart = new ImageIcon("images/cartr.png");
		ImageIcon cart2 = new ImageIcon("images/carty.png");
		
		
		btn_home = new JButton();
		btn_home.setIcon(home);
		btn_home.setPressedIcon(home2);
		btn_home.setForeground(new Color(255, 255, 255));
		btn_home.setBackground(new Color(255, 255, 255));
		btn_home.setPreferredSize(new Dimension(40,40));;
		btn_home.setContentAreaFilled(false);
		
		//이미지만 넣기
		btn_home.setBorderPainted(false); 
		btn_home.setFocusPainted(false); 
		btn_home.setContentAreaFilled(false);
		
		btn_cart = new JButton();
		btn_cart.setIcon(cart);
		btn_cart.setPressedIcon(cart2);
		btn_cart.setForeground(new Color(255, 255, 255));
		btn_cart.setBackground(new Color(255, 255, 255));
		btn_cart.setPreferredSize(new Dimension(40,40));;
		btn_cart.setContentAreaFilled(false);
		
		//이미지만 넣기
		btn_cart.setBorderPainted(false); 
		btn_cart.setFocusPainted(false); 
		btn_cart.setContentAreaFilled(false);
		
		
		JPanel p1_north = new JPanel(new GridLayout(4,0));
		p1_north.setBackground(new Color(255, 255, 255));
		JPanel p1_w = new JPanel(new GridLayout(0,2));
		p1_w.setBackground(new Color(255, 255, 255));
		p1_w.setPreferredSize(new Dimension(100,10));
		p1_w.add(btn_home);
		p1_w.add(btn_cart);
		JPanel p1_e = new JPanel();
		p1_e.setBackground(new Color(255, 255, 255));
		p1_e.setPreferredSize(new Dimension(100,10));
		p1_north.add(p1_w);
		
		btn_home.addActionListener(this);
		btn_cart.addActionListener(this);
		
		menu1.add(BorderLayout.WEST,p1_north);
		menu1.add(BorderLayout.EAST,p1_e);
		
		
		menu1.add(BorderLayout.CENTER,menu1_image);
		menu1.add(BorderLayout.SOUTH,menu1_btn_panel);
		
		
		
		//menu2
		JPanel menu2 = new JPanel(new BorderLayout());
		menu2.setBounds(0, 273, 520, 273);
		menu2.setBackground(new Color(255, 255, 255));
		JLabel menu2_image = new JLabel(icon2);
		menu2_image.setBackground(new Color(255, 255, 255));
		JLabel menu2_lb = new JLabel("황금 올리브 콤보 반반 20000원");
		menu2_lb.setFont(Commons.getFont(16));
		
		JPanel menu2_btn_panel = new JPanel();
		menu2_btn_panel.setBackground(new Color(255, 255, 255));
		menu2_btn_panel.add(menu2_lb);
		//버튼 공간 만들기 및 버튼 이미지 세팅
		ImageIcon point = new ImageIcon("images/rightr.png");
		ImageIcon point2 = new ImageIcon("images/righty.png");
		
		
		btn_sidepage = new JButton();
		btn_sidepage.setIcon(point);
		btn_sidepage.setPressedIcon(point2);
		btn_sidepage.setForeground(new Color(255, 255, 255));
		btn_sidepage.setBackground(new Color(255, 255, 255));
		btn_sidepage.setPreferredSize(new Dimension(40,230));;
		btn_sidepage.setContentAreaFilled(false);
		
		//이미지만 넣기
		btn_sidepage.setBorderPainted(false); 
		btn_sidepage.setFocusPainted(false); 
		btn_sidepage.setContentAreaFilled(false);
		JPanel btn_sidepage2 = new JPanel();

		JPanel pp_w = new JPanel();
		pp_w.setBackground(new Color(255, 255, 255));
		JPanel pp_e = new JPanel();
		pp_e.setBackground(new Color(255, 255, 255));
		pp_e.add(btn_sidepage);
		pp_w.add(btn_sidepage2);
		
		btn_sidepage2.setBackground(new Color(255, 255, 255));
		btn_sidepage2.setPreferredSize(new Dimension(40,230));;
		
		menu2.add(BorderLayout.CENTER,menu2_image);
		menu2.add(BorderLayout.SOUTH,menu2_btn_panel);
		menu2.add(BorderLayout.WEST,pp_w);
		menu2.add(BorderLayout.EAST,pp_e);
		
		
		//사이드 버튼
		
		btn_sidepage.addActionListener(this);
		menu2_image.setOpaque(true);
		JLabel lb = new JLabel();
		lb.setBackground(Color.BLACK);
		lb.setOpaque(true);
		lb.setBounds(100, 100, 150, 150);
		
		JPanel menu3 = new JPanel(new BorderLayout());
		menu3.setBounds(0, 546, 520, 273);
		menu3.setBackground(new Color(255, 255, 255));
		JLabel menu3_image = new JLabel(icon3);
		JLabel menu3_lb = new JLabel("수원 왕갈비 양념 치킨 22000원");
		menu3_lb.setFont(Commons.getFont(16));
		
		JPanel menu3_btn_panel = new JPanel();
		menu3_btn_panel.setBackground(new Color(255, 255, 255));
		menu3_btn_panel.add(menu3_lb);
		
		
		menu3.add(BorderLayout.CENTER,menu3_image);
		menu3.add(BorderLayout.SOUTH,menu3_btn_panel);
		panel.setLayout(null);
		
		
		
		panel.add(menu1);
		panel.add(menu2);
		panel.add(menu3);
		
		//그림 이름 클릭 이벤트
		
		menu1_lb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("메뉴1 클릭");
            }
        });
		menu2_lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메뉴2 클릭");
			}
		});
		menu3_lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("메뉴3 클릭");
			}
		});
		
		menu1_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("그림1 클릭");
			}
		});
		menu2_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("그림2 클릭");
			}
		});
		menu3_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("그림3 클릭");
			}
		});
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btn_sidepage) {
			panel.setVisible(false);
			main.frame.add(list2.initialize());
			
			
		}else if(obj == btn_home){
			panel.setVisible(false);
			main.panelinit();
			
		}else if(obj == btn_cart) {
			System.out.println("cart");
			
		}
		
	}
	
	
}
