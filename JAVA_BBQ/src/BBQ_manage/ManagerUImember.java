package BBQ_manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_SYSTEM.BBQ_System;
import BBQ_UI.Commons;
import BBQ_UI.JoinUI;
import BBQ_VO.MemberVO;

public class ManagerUImember implements ActionListener {

	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<JPanel> roomList, wpList;
	ArrayList<JButton> btnList;
	JButton searchbtn;
	JTextField jtf;
	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame;
	JPanel main;
	JPanel west_pn;
	BBQ_System system = new BBQ_System();
	JPanel contants_pn;
	ManagerUI ui;

	public ManagerUImember(ManagerUI ui) {
		this.ui = ui;
	}

	public JPanel init() {

//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 1000, 700);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		// test용
////		nameList.add("Owner_pn");
////		nameList.add("test");
////		nameList.add("test2");
//
//		JPanel panel = new JPanel(new BorderLayout());
//		panel.setBackground(new Color(255, 255, 255));
//		panel.setBounds(25, 20, 932, 617);
//
//		JPanel west_pn = new JPanel(new GridLayout(7, 1, 0, 0));
//		west_pn.setBackground(new Color(255, 255, 255));
//
//		ImageIcon modicon = new ImageIcon("images/정보수정.png");
//		ImageIcon modicon2 = new ImageIcon("images/정보수정2.png");
//		ImageIcon ordericon = new ImageIcon("images/주문확인.png");
//		ImageIcon ordericon2 = new ImageIcon("images/주문확인2.png");
//		ImageIcon chaticon = new ImageIcon("images/문의확인.png");
//		ImageIcon chaticon2 = new ImageIcon("images/문의확인2.png");
//
//		JPanel west_blank = new JPanel();
//		JLabel label = new JLabel("사장님 메뉴");
//		label.setFont(Commons.getFont(1, 32));
//		west_blank.add(label);
//		west_blank.setBackground(new Color(255, 255, 255));
//		west_pn.add(west_blank);
//
//		JPanel west_blank2 = new JPanel();
//		west_blank2.setBackground(new Color(255, 255, 255));
//		west_pn.add(west_blank2);
//
//		JPanel btn_modify_pn = new JPanel();
//		btn_modify_pn.setBackground(new Color(255, 255, 255));
//		btn_modify = new JButton();
//		btn_modify.setIcon(modicon);
//		btn_modify.setPressedIcon(modicon2);
//		btn_modify_pn.add(btn_modify);
//
//		JPanel btn_ordertake_pn = new JPanel();
//		btn_ordertake_pn.setBackground(new Color(255, 255, 255));
//		btn_ordertake = new JButton();
//		btn_ordertake.setIcon(ordericon);
//		btn_ordertake.setPressedIcon(ordericon2);
//		btn_ordertake_pn.add(btn_ordertake);
//
//		JPanel btn_chat_pn = new JPanel();
//		btn_chat_pn.setBackground(new Color(255, 255, 255));
//		btn_chat = new JButton();
//		btn_chat.setIcon(chaticon);
//		btn_chat.setPressedIcon(chaticon2);
//		btn_chat_pn.add(btn_chat);
//
//		btn_modify.setBorderPainted(false);
//		btn_modify.setFocusPainted(false);
//		btn_modify.setContentAreaFilled(false);
//		btn_ordertake.setBorderPainted(false);
//		btn_ordertake.setFocusPainted(false);
//		btn_ordertake.setContentAreaFilled(false);
//		btn_chat.setBorderPainted(false);
//		btn_chat.setFocusPainted(false);
//		btn_chat.setContentAreaFilled(false);
//
//		west_pn.add(btn_modify_pn);
//		west_pn.add(btn_ordertake_pn);
//		west_pn.add(btn_chat_pn);
//
		contants_pn = new JPanel(new BorderLayout());
		contants_pn.setBackground(new Color(255, 255, 255));
		// 컨텐츠 패널 멤버목록
		main = new JPanel();
		JPanel nmain = new JPanel();
		nmain.setLayout(new BoxLayout(nmain, BoxLayout.Y_AXIS));
		main.setBackground(new Color(255, 255, 255));
		roomList = new ArrayList<JPanel>();
		wpList = new ArrayList<JPanel>();
		btnList = new ArrayList<JButton>();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		int x = 500;
		int y = 35;

		// 목록 제목
		JPanel northblank = new JPanel();
		northblank.setPreferredSize(new Dimension(x, 10));
		northblank.setBackground(new Color(255, 255, 255));
		JPanel northname = new JPanel();
		northname.setPreferredSize(new Dimension(x, y));
		northname.setBackground(new Color(255, 255, 255));
		JLabel lb = new JLabel("고객 목록");
		lb.setFont(Commons.getFont(1, 28));
		northname.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		northname.add(lb);

		// 검색창
		JPanel search_pn = new JPanel(new BorderLayout());
		search_pn.setPreferredSize(new Dimension(x, 40));
		search_pn.setBackground(new Color(255, 255, 255));

		JPanel jtf_pn = new JPanel();
		jtf_pn.setBackground(new Color(255, 255, 255));
		jtf = new JTextField(12);
		jtf.setFont(Commons.getFont(17));
		searchbtn = new JButton("검색");
		searchbtn.setFont(Commons.getFont());
		jtf_pn.add(jtf);
		jtf_pn.add(searchbtn);

		search_pn.add(BorderLayout.CENTER, jtf_pn);

		nmain.add(northblank);
		nmain.add(northname);
		nmain.add(search_pn);

		searchbtn.addActionListener(this);

		// 목록 추가
		for (int i = 0; i < 30; i++) {
			JPanel chatroom = new JPanel();
			chatroom.setPreferredSize(new Dimension(x, y));
			chatroom.setBackground(new Color(255, 255, 255));
			chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 100), 2, true));
			main.add(chatroom);
			JPanel wp = new JPanel();
			JButton enter_btn = new JButton("수정");
			roomList.add(chatroom);
			wpList.add(wp);
			btnList.add(enter_btn);
		}
		ArrayList<MemberVO> member = system.getMemberList();
		for (int i = 0; i < member.size(); i++) {
			JPanel room = roomList.get(i);
			room.setLayout(new BorderLayout());
			JPanel wp = wpList.get(i);
			JButton roomBtn = new JButton("수정");
			JLabel roomlb = new JLabel(member.get(i).getId());
			roomlb.setFont(Commons.getFont(1, 20));
			wp.add(roomlb);
			room.add(BorderLayout.WEST, wp);
			room.add(BorderLayout.EAST, roomBtn);
			MemberVO member1 = member.get(i);

			roomBtn.addActionListener(new ActionListener() {
				boolean check = false;

				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if (obj == roomBtn) {
						new JoinUI(member1);
					}
				}
			});
		}

		JScrollPane scroll = new JScrollPane(main);
		scroll.setBounds(23, 20, 725, 580);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contants_pn.add(BorderLayout.NORTH, nmain);
		contants_pn.add(BorderLayout.CENTER, scroll);

//		panel.add(BorderLayout.CENTER, contants_pn);
//		panel.add(BorderLayout.WEST, west_pn);
//
//		btn_chat.addActionListener(this);
//		btn_ordertake.addActionListener(this);
//
//		frame.add(panel);
//
//		frame.setVisible(true);

		return contants_pn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchbtn) {
//			main.removeAll();
			int x = 500;
			int y = 35;
//			String name = jtf.getText();
//			ArrayList<MemberVO> member = system.getMemberList();
//			for (int i = 0; i < 30; i++) {
//				if (i == 0) {
//					JPanel chatroom = new JPanel();
//					chatroom.setPreferredSize(new Dimension(x, y));
//					chatroom.setBackground(new Color(255, 255, 255));
//					chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 100), 2, true));
//					JPanel wp = new JPanel();
//					
//					chatroom.setLayout(new BorderLayout());
//					wp.removeAll();
//					JButton roomBtn = new JButton("수정");
//					JLabel roomlb = new JLabel(name);
//					roomlb.setFont(Commons.getFont(1, 20));
//					wp.add(roomlb);
//					chatroom.add(BorderLayout.WEST, wp);
//					chatroom.add(BorderLayout.EAST, roomBtn);
//					
//					MemberVO member1 = member.get(0);
//
//					roomBtn.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							Object obj = e.getSource();
//							if (obj == roomBtn) {
//								new JoinUI(member1);
//							}
//						}
//					});
//					main.add(chatroom);
//					roomList.add(chatroom);
//					wpList.add(wp);
//					btnList.add(roomBtn);
//				} else {
//					JPanel chatroom = new JPanel();
//					chatroom.setPreferredSize(new Dimension(x, y));
//					chatroom.setBackground(new Color(255, 255, 255));
//					chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 100), 2, true));
//					main.add(chatroom);
//					JPanel wp = new JPanel();
//					JButton enter_btn = new JButton("수정");
//					roomList.add(chatroom);
//					wpList.add(wp);
//					btnList.add(enter_btn);
//				}
//			}
			ArrayList<MemberVO> member = system.getMemberList();
			

			String name = jtf.getText();
			int check = 0;
			for (int i = 0; i < member.size(); i++) {

				if (member.get(i).getId().equals(name)) {
					for (int j = 1; j < 30;j++) {
						JPanel room = roomList.get(j);
						room.removeAll();
						JPanel wp = wpList.get(j);
						wp.removeAll();
						wp.revalidate();
						wp.setVisible(false);
						room.revalidate();
						room.setVisible(false);
					}
					check = +1;
					JPanel room = roomList.get(0);
					room.removeAll();
					room.setLayout(new BorderLayout());
					JPanel wp = wpList.get(0);
					wp.removeAll();
					JButton roomBtn = new JButton("수정");
					JLabel roomlb = new JLabel(name);
					roomlb.setFont(Commons.getFont(1, 20));
					wp.add(roomlb);
					room.add(BorderLayout.WEST, wp);
					room.add(BorderLayout.EAST, roomBtn);

					MemberVO member1 = member.get(i);

					roomBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Object obj = e.getSource();
							if (obj == roomBtn) {
								new JoinUI(member1);
							}
						}
					});
				}
			}
			if (check == 0) {

				JOptionPane.showMessageDialog(null, Commons.getMsg("해당하는 데이터가 없습니다."));

			}
			if (check != 0) {
				for (int i = 0; i < 29; i++) {
					JPanel chatroom = new JPanel();
					chatroom.setPreferredSize(new Dimension(x, y));
					chatroom.setBackground(new Color(255, 255, 255));
					chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 100), 2, true));
					main.add(chatroom);
					JPanel wp = new JPanel();
					JButton enter_btn = new JButton("수정");
					roomList.add(chatroom);
					wpList.add(wp);
					btnList.add(enter_btn);
				}
				main.revalidate();
				contants_pn.revalidate();
				ui.frame.revalidate();
			}
		}

	}

}
