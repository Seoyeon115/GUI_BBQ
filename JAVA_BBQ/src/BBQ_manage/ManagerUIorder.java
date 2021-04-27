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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_SYSTEM.BBQ_System;
import BBQ_UI.Commons;
import BBQ_VO.OrderVO;

public class ManagerUIorder implements ActionListener {

	BBQ_System system = new BBQ_System();
	
	ArrayList<String> namelist = new ArrayList<String>();
	ArrayList<JPanel> roomList, wpList;
	ArrayList<JButton> btnList;
	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame;
	JPanel panel;
	JPanel west_pn;
	
	public JPanel init() {

//
		JPanel contants_pn = new JPanel(new BorderLayout());
		JPanel nmain = new JPanel();
		nmain.setLayout(new BoxLayout(nmain, BoxLayout.Y_AXIS));
		contants_pn.setBackground(new Color(255,255,255));
		// 컨텐츠 패널 멤버목록
		JPanel main = new JPanel();
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
		JTextField jtf = new JTextField(12);
		jtf.setFont(Commons.getFont(17));
		JButton btn = new JButton("검색");
		btn.setFont(Commons.getFont());
		jtf_pn.add(jtf);
		jtf_pn.add(btn);
		
		search_pn.add(BorderLayout.CENTER,jtf_pn);
		
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
		ArrayList<OrderVO> orderlist = system.getOrdercheckList();
		
		System.out.println(orderlist.size());
		System.out.println(orderlist.get(2).getOrderId());
		
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
		

	}

}
