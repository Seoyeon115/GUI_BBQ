package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StartUI{
	//Field
	Frame f;
	Panel top_panel,ad_panel,bottom_panel;
	Label first_label,last_label;
	JButton btn_login, btn_order;
	StartUIEvent eventobj = new StartUIEvent(this);
	
	//Constructor
	public StartUI() {
		init();
	}
	
	//Method
	public void init() {
		f = new Frame("BBQ");
		top_panel = new Panel();
		ad_panel = new Panel();
		bottom_panel = new Panel();
		
		ImageIcon icon = new ImageIcon("images/BBQ.png");
		JLabel img_label = new JLabel(icon);
		ad_panel.add(img_label);
		
		btn_login = new JButton(" 로그인 ");
		btn_order = new JButton(" 주문하기 ");
		btn_login.setFont(Commons.getFont());
		btn_order.setFont(Commons.getFont());
		bottom_panel.add(btn_login);
		bottom_panel.add(btn_order);
		
		f.add(BorderLayout.NORTH,top_panel);
		f.add(BorderLayout.CENTER,ad_panel);
		f.add(BorderLayout.SOUTH,bottom_panel);
		
		f.setSize(500,400);
		
		Dimension fsize = f.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth() - fsize.getWidth())/2;
		int height = (int)(scsize.getHeight() - fsize.getHeight())/2;
		
		f.setLocation(width, height);
		f.setVisible(true);
		
		//윈도우 종료 이벤트
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn_login.addActionListener(eventobj);
		btn_order.addActionListener(eventobj);
		
		
	}//init

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		
//		if (obj == btn_login) {
//			// 로그인
//			new LoginUI(main);
//		} else if (obj == btn_order) {
//			
//		}
//		
//		
//	}
	
	
	
}
