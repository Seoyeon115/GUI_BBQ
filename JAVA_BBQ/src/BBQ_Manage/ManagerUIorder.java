package BBQ_Manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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
import BBQ_VO.OrderVO;

public class ManagerUIorder implements ActionListener {

	ManagerSystem system = new ManagerSystem();
	ManagerUI ui;

	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<JPanel> roomList, wpList;
	ArrayList<JButton> btnList;
//	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame;
	JPanel panel;
	JPanel west_pn;
	JTextField jtf;
	JButton btn;
	JPanel main;
	JPanel contants_pn;
	
	
	public ManagerUIorder(ManagerUI ui) {
		this.ui = ui;
	}
	
	
	public JPanel init() {

//
		contants_pn = new JPanel(new BorderLayout());
		JPanel nmain = new JPanel();
		nmain.setLayout(new BoxLayout(nmain, BoxLayout.Y_AXIS));
		contants_pn.setBackground(new Color(255, 255, 255));
		// 컨텐츠 패널 멤버목록
		main = new JPanel();
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
		JLabel lb = new JLabel("주문 목록");
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
		btn = new JButton("검색");
		btn.setFont(Commons.getFont());
		jtf_pn.add(jtf);
		jtf_pn.add(btn);
		btn.addActionListener(this);

		search_pn.add(BorderLayout.CENTER, jtf_pn);

		nmain.add(northblank);
		nmain.add(northname);
		nmain.add(search_pn);

		// 목록 추가
		for (int i = 0; i < 30; i++) {
			JPanel chatroom = new JPanel();
			chatroom.setPreferredSize(new Dimension(x, y));
			chatroom.setBackground(new Color(255, 255, 255));
			chatroom.setBorder(new LineBorder(new Color(214, 164, 41, 150), 2, true));
			roomList.add(chatroom);
			main.add(chatroom);
			JPanel wp = new JPanel();
			JButton enter_btn = new JButton();
			wpList.add(wp);
			btnList.add(enter_btn);
		}
		ArrayList<OrderVO> orderlist = system.getOrderListNow();

		ArrayList<String> idlist = new ArrayList<String>();
		
		for(OrderVO order : orderlist) {
			idlist.add(order.getOrderId());
		}
		
//		HashSet<String> nameset = new HashSet<String>();
//		for(int i =0; i<orderlist.size();i++) {
//			nameset.add(orderlist.get(i).getOrderId());
//		}
//		System.out.println(nameset);
//		
//		ArrayList<String> idlist = new ArrayList<String>();
//		Iterator<String> it = nameset.iterator(); // Iterator(반복자) 생성
//
//		while (it.hasNext()) { 
//			idlist.add(it.next());
//		}
		
		
		
		
		for (int i = 0; i < idlist.size(); i++) {
			JPanel room = roomList.get(i);
			room.setLayout(new BorderLayout());
			JPanel wp = wpList.get(i);
			JButton roomBtn = new JButton("접수");
			String id = idlist.get(i);
			JLabel roomlb = new JLabel(idlist.get(i));
			String name = orderlist.get(i).getName();
//			String name = "";
//			for(int j=0; j<orderlist.size();j++) {
//				if(idlist.get(i).equals((orderlist.get(j).getOrderId()))) {
//					name = orderlist.get(j).getName();
//				}
//			}
			JLabel roomname = new JLabel(name);
			roomlb.setFont(Commons.getFont(1, 20));
			roomname.setFont(Commons.getFont(1, 20));
			wp.add(roomlb);
			wp.add(roomname);
			room.add(BorderLayout.WEST, wp);
			room.add(BorderLayout.EAST, roomBtn);
			OrderVO order = orderlist.get(i);

			roomBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if (obj == roomBtn) {
						new OrderCheckUI(id,orderlist, system);
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

		return contants_pn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn) {
			System.out.println("검색버튼");
			int x = 500;
			int y = 35;
			ArrayList<OrderVO> orderlist = system.getOrdercheckList();
			String name = jtf.getText();
			int check = 0;
			for (int i = 0; i < orderlist.size(); i++) {

				if (orderlist.get(i).getName().equals(name)) {
					for (int j = 1; j < 30; j++) {
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
					String id2 = "";
					for(int j =0; j<orderlist.size();j++) {
						if(name.equals(orderlist.get(j).getName())) {
							id2 = orderlist.get(j).getOrderId();
						}
					}
					String name1 = String.valueOf(id2);
					JLabel roomlb = new JLabel(String.valueOf(name1));
					JButton roomBtn = new JButton("접수");
					JLabel roomname = new JLabel(name);
					roomlb.setFont(Commons.getFont(1, 20));
					wp.add(roomlb);
					wp.add(roomname);
					room.add(BorderLayout.WEST, wp);
					room.add(BorderLayout.EAST, roomBtn);

					OrderVO order = orderlist.get(i);

					roomBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Object obj = e.getSource();
							if (obj == roomBtn) {
								new OrderCheckUI(name1,orderlist);
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
					chatroom.setBorder(new LineBorder(new Color(214, 164, 41, 150), 2, true));
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
