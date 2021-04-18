package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Orderstatus_on implements ActionListener {
	InnerMain main;

	JFrame frame;
	JPanel panel;
	JButton btn_home, btn_cart;

//	public Orderstatus_on() {
//		init();
//	}

	public Orderstatus_on(InnerMain main) {
		this.main = main;
		init();
	}

	public JPanel init() {

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

//		frame.add(panel);

		// north_panel
		ImageIcon icon1 = new ImageIcon("images/normal.png");

		JPanel menu1 = new JPanel(new BorderLayout());
		menu1.setBounds(0, 0, 520, 273);
		menu1.setBackground(new Color(255, 255, 255));

		JPanel north_panel = new JPanel(new BorderLayout());
		north_panel.setPreferredSize(new Dimension(510, 45));
		north_panel.setBackground(new Color(255, 255, 255));

		// 홈버튼 장바구니버튼 넣기
		ImageIcon home = new ImageIcon("images/homer.png");
		ImageIcon home2 = new ImageIcon("images/homey.png");
		
		
		JButton btn_home_blank = new JButton();
		btn_home_blank.setBackground(new Color(255, 255, 255));
		btn_home_blank.setPreferredSize(new Dimension(35, 40));
		JPanel btn_home_pn = new JPanel();
		btn_home_pn.setBackground(new Color(255, 255, 255));
		
		btn_home = new JButton();
		btn_home.setIcon(home);
		btn_home.setPressedIcon(home2);
		btn_home.setForeground(new Color(255, 255, 255));
		btn_home.setBackground(new Color(255, 255, 255));
		btn_home.setPreferredSize(new Dimension(40, 40));
		btn_home.setContentAreaFilled(false);

		// 이미지만 넣기
		btn_home.setBorderPainted(false);
		btn_home.setFocusPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_home.addActionListener(this);
		btn_home_blank.setBorderPainted(false);
		btn_home_blank.setFocusPainted(false);
		btn_home_blank.setContentAreaFilled(false);
		btn_home_blank.addActionListener(this);

		btn_home_pn.add(btn_home_blank);
		btn_home_pn.add(btn_home);
		north_panel.add(BorderLayout.WEST, btn_home_pn);
		menu1.add(BorderLayout.NORTH, north_panel);

		// middle panel
		JPanel middle_out = new JPanel(new BorderLayout());
		middle_out.setBackground(new Color(255, 255, 255));
		JPanel blank_m = new JPanel();
		blank_m.setBackground(new Color(255, 255, 255));
		blank_m.setPreferredSize(new Dimension(20, 50));

		JPanel middle = new JPanel(new GridLayout(2, 1, 0, -10));
		middle.setBackground(new Color(255, 255, 255));
		JPanel middle_in = new JPanel(new BorderLayout(0, -8));
		middle_in.setBackground(new Color(255, 255, 255));
		JPanel flow_gone = new JPanel(new FlowLayout());
		flow_gone.setBackground(new Color(255, 255, 255));
		JPanel flow_arrive = new JPanel(new FlowLayout());
		flow_arrive.setBackground(new Color(255, 255, 255));

		ImageIcon gone = new ImageIcon("images/gone.png");
		JLabel goneimg = new JLabel(gone);

		JLabel havegone = new JLabel("후라이드 치킨 외1");
		havegone.setFont(Commons.getFont(16));
		havegone.setForeground(new Color(0, 0, 0, 150));
		JLabel arrive = new JLabel("30분 후에 도착할 예정입니다.");
		arrive.setFont(Commons.getFont(16));
		arrive.setForeground(new Color(0, 0, 0, 150));

		flow_gone.add(havegone);
		flow_arrive.add(arrive);

		ImageIcon autoicon = new ImageIcon("images/autoicon.png");
		JLabel auto = new JLabel(autoicon);

		// 채팅 버튼 넣기
		ImageIcon chat_icon = new ImageIcon("images/chat.png");
		ImageIcon chat_icon2 = new ImageIcon("images/chat2.png");
		
		JButton btn_chat = new JButton();
		btn_chat = new JButton();
		btn_chat.setIcon(chat_icon2);
		btn_chat.setPressedIcon(chat_icon);
		btn_chat.setForeground(new Color(255, 255, 255));
		btn_chat.setBackground(new Color(255, 255, 255));
		btn_chat.setPreferredSize(new Dimension(40, 40));
				
		// 이미지만 넣기
		btn_chat.setBorderPainted(false);
		btn_chat.setFocusPainted(false);
		btn_chat.setContentAreaFilled(false);
		
		JPanel blank_btn = new JPanel();
		blank_btn.setBackground(new Color(255, 255, 255));
		blank_btn.setPreferredSize(new Dimension(20, 65));
		
		JPanel btn_panel = new JPanel(new BorderLayout(0,85));
		btn_panel.setBackground(new Color(255,255,255));
		
		//라인 넣기
		
		ImageIcon line_icon = new ImageIcon("images/line2.png");
		JLabel line = new JLabel(line_icon);
		JPanel line_pn = new JPanel();
		line_pn.add(line);
		line_pn.setBackground(new Color(255,255,255));
		
		btn_panel.add(BorderLayout.NORTH,blank_btn);
		btn_panel.add(BorderLayout.CENTER,line_pn);
		btn_panel.add(BorderLayout.SOUTH,btn_chat);
		
		
		middle_in.add(BorderLayout.NORTH, flow_gone);
		middle_in.add(BorderLayout.CENTER, flow_arrive);
		middle_in.add(BorderLayout.SOUTH, auto);

		middle.add(goneimg);
		middle.add(middle_in);

		middle_out.add(BorderLayout.NORTH, blank_m);
		middle_out.add(BorderLayout.CENTER, middle);

		menu1.add(BorderLayout.CENTER, middle_out);
		menu1.add(BorderLayout.SOUTH, btn_panel);

		panel.add(menu1);
//		frame.setVisible(true);

		return panel;

	}

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == btn_home) {
			panel.setVisible(false);
			main.panelinit();
		}

	}

}
