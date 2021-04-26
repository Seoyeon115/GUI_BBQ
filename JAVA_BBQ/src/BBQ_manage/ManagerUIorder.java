package BBQ_manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_UI.Commons;
import BBQ_VO.MessageVO;

public class ManagerUIorder implements ActionListener {

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
		
		main.add(northblank);
		main.add(northname);
		main.add(search_pn);

		// 목록 추가
		for (int i = 0; i < 30; i++) {
			JPanel chatroom = new JPanel();
			chatroom.setPreferredSize(new Dimension(x, y));
			chatroom.setBackground(new Color(255, 255, 255));
			chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 150), 2, true));
			roomList.add(chatroom);
			main.add(chatroom);
			JPanel wp = new JPanel();
			JButton enter_btn = new JButton();
			wpList.add(wp);
			btnList.add(enter_btn);
		}

		JScrollPane scroll = new JScrollPane(main);
		scroll.setBounds(23, 20, 725, 580);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contants_pn.add(BorderLayout.CENTER, scroll);

		return contants_pn;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		

	}

}
