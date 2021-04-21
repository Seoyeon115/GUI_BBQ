package BBQ_manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BBQ_UI.Commons;


public class ChatResponse {

	JButton btn_modify,btn_ordertake,btn_chat;
	
	
	public ChatResponse() {
		
		init();
		
	}
	
	public void init() {
		
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 20, 932, 617);
		
		JPanel west_pn = new JPanel(new GridLayout(7,1,0,0));
		west_pn.setBackground(new Color(255,255,255));
		JPanel contants_pn = new JPanel();
//		contants_pn.setBackground(new Color(204,0,51));
//		contants_pn.setBackground(new Color(255,255,255));
		
		ImageIcon modicon = new ImageIcon("images/정보수정.png");
		ImageIcon modicon2 = new ImageIcon("images/정보수정2.png");
		ImageIcon ordericon = new ImageIcon("images/주문확인.png");
		ImageIcon ordericon2 = new ImageIcon("images/주문확인2.png");
		ImageIcon chaticon = new ImageIcon("images/문의확인.png");
		ImageIcon chaticon2 = new ImageIcon("images/문의확인2.png");
		
		JPanel west_blank = new JPanel();
		JLabel label = new JLabel("사장님 메뉴");
		label.setFont(Commons.getFont(1,32));
		west_blank.add(label);
		west_blank.setBackground(new Color(255,255,255));
		west_pn.add(west_blank);
		
		
		
		JPanel west_blank2 = new JPanel();
		west_blank2.setBackground(new Color(255,255,255));
		west_pn.add(west_blank2);
		
		JPanel btn_modify_pn = new JPanel(); 
		btn_modify_pn.setBackground(new Color(255,255,255));
		btn_modify = new JButton();
		btn_modify.setIcon(modicon);
		btn_modify.setPressedIcon(modicon2);
		btn_modify_pn.add(btn_modify);
				
		JPanel btn_ordertake_pn = new JPanel();
		btn_ordertake_pn.setBackground(new Color(255,255,255));
		btn_ordertake = new JButton();
		btn_ordertake.setIcon(ordericon);
		btn_ordertake.setPressedIcon(ordericon2);
		btn_ordertake_pn.add(btn_ordertake);
		
		JPanel btn_chat_pn = new JPanel(); 
		btn_chat_pn.setBackground(new Color(255,255,255));
		btn_chat = new JButton();
		btn_chat.setIcon(chaticon);
		btn_chat.setPressedIcon(chaticon2);
		btn_chat_pn.add(btn_chat);
		
		
		btn_modify.setBorderPainted(false);
		btn_modify.setFocusPainted(false);
		btn_modify.setContentAreaFilled(false);
		btn_ordertake.setBorderPainted(false);
		btn_ordertake.setFocusPainted(false);
		btn_ordertake.setContentAreaFilled(false);
		btn_chat.setBorderPainted(false);
		btn_chat.setFocusPainted(false);
		btn_chat.setContentAreaFilled(false);
				
		west_pn.add(btn_modify_pn);
		west_pn.add(btn_ordertake_pn);
		west_pn.add(btn_chat_pn);
		
		
		JPanel main = new JPanel();
		main.setBackground(new Color(255,255,255));
		contants_pn.setLayout(null);
		main.setBounds(23,20,725,580);
		contants_pn.add(main);
		
		
		panel.add(BorderLayout.CENTER,contants_pn);
		panel.add(BorderLayout.WEST,west_pn);
		
		frame.add(panel);

		frame.setVisible(true);
		
	}
	
}
