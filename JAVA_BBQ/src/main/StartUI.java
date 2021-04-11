package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartUI {
	// Field
	JFrame f;
	JPanel top_panel, center_panel, bottom_panel;
	JLabel inform_label;
	JButton btn_login, btn_order;
	StartUIEvent eventobj = new StartUIEvent(this);

	// login 결과
	public static boolean LOGIN_RESULT = false;

	// Constructor
	public StartUI() {
		init();
	}

	// Method
	public void init() {
		f = new JFrame("BBQ");
		top_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top_panel.setBackground(new Color(255, 255, 255));
		center_panel = new JPanel();
		center_panel.setBackground(new Color(204, 0, 51));
		bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(204, 0, 51));
		inform_label = new JLabel("로그인을 해주세요");
		top_panel.add(inform_label);

		ImageIcon adv_img = new ImageIcon("images/eventpage.png");
		Image img = adv_img.getImage();
		Image changeImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);
		center_panel.add(img_label);

		btn_login = new JButton("로그인");
		btn_order = new JButton("주문하기");
		bottom_panel.add(btn_login);
		bottom_panel.add(btn_order);

		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, center_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);

		f.setSize(500, 450);

		Dimension fsize = f.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		f.setLocation(width, height);
		f.setVisible(true);

		// 윈도우 이벤트 호출-종료
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("프로그램을 종료합니다."));
				System.exit(0);

			}
		});
//		btn_login.addActionListener(this);
//		btn_order.addActionListener(this);
		btn_login.addActionListener(eventobj);
		btn_order.addActionListener(eventobj);

	}

//	//액션 이벤트
//		@Override
//		public void actionPerformed(ActionEvent e) {
//				Object obj = e.getSource();
//				String name =e.getActionCommand().trim();
//				
//				if(obj == btn_login) {
//					new LoginUI();
//				}else if(obj == btn_order) {
////					if(Login_Result = true) {
////						new OrderUI();
//					JOptionPane.showMessageDialog(null, 
//							Commons.getMsg("주문 창"));
////				}else {
////							JOptionPane.showMessageDialog(null, 
////									Commons.getMsg("로그인이 필요한 기능입니다."));
//						}
//					
//				}
}
