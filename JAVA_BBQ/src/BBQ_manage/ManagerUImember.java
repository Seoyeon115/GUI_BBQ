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

public class ManagerUImember implements ActionListener {

	ArrayList<String> namelist = new ArrayList<String>();
//	JButton btn_modify, btn_ordertake, btn_chat;
//	int idnum = 10000;
//	Socket s;
	ArrayList<JPanel> roomList, wpList;
	ArrayList<JButton> btnList;
//	ObjectOutputStream oos;
//	ObjectInputStream ois;
	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame;
	JPanel panel;
	JPanel west_pn;
//	ChatUIForManager ui;
//	ArrayList<MessageVO> msglist = new ArrayList<MessageVO>();

//	public ManagerUImember() {
//	}

	public JPanel init() {

//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 1000, 700);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//
//		// test��
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
//		ImageIcon modicon = new ImageIcon("images/��������.png");
//		ImageIcon modicon2 = new ImageIcon("images/��������2.png");
//		ImageIcon ordericon = new ImageIcon("images/�ֹ�Ȯ��.png");
//		ImageIcon ordericon2 = new ImageIcon("images/�ֹ�Ȯ��2.png");
//		ImageIcon chaticon = new ImageIcon("images/����Ȯ��.png");
//		ImageIcon chaticon2 = new ImageIcon("images/����Ȯ��2.png");
//
//		JPanel west_blank = new JPanel();
//		JLabel label = new JLabel("����� �޴�");
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
		JPanel contants_pn = new JPanel(new BorderLayout());
		contants_pn.setBackground(new Color(255,255,255));
		// ������ �г� ������
		JPanel main = new JPanel();
		main.setBackground(new Color(255, 255, 255));
		roomList = new ArrayList<JPanel>();
		wpList = new ArrayList<JPanel>();
		btnList = new ArrayList<JButton>();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		int x = 500;
		int y = 35;

		// ��� ����
		JPanel northblank = new JPanel();
		northblank.setPreferredSize(new Dimension(x, 10));
		northblank.setBackground(new Color(255, 255, 255));
		JPanel northname = new JPanel();
		northname.setPreferredSize(new Dimension(x, y));
		northname.setBackground(new Color(255, 255, 255));
		JLabel lb = new JLabel("�� ���");
		lb.setFont(Commons.getFont(1, 28));
		northname.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		northname.add(lb);
		
		// �˻�â
		JPanel search_pn = new JPanel(new BorderLayout());
		search_pn.setPreferredSize(new Dimension(x, 40));
		search_pn.setBackground(new Color(255, 255, 255));
		
		JPanel jtf_pn = new JPanel();
		jtf_pn.setBackground(new Color(255, 255, 255));
		JTextField jtf = new JTextField(12);
		jtf.setFont(Commons.getFont(17));
		JButton btn = new JButton("�˻�");
		btn.setFont(Commons.getFont());
		jtf_pn.add(jtf);
		jtf_pn.add(btn);
		
		search_pn.add(BorderLayout.CENTER,jtf_pn);
		
		main.add(northblank);
		main.add(northname);
		main.add(search_pn);

		// ��� �߰�
		for (int i = 0; i < 30; i++) {
			JPanel chatroom = new JPanel();
			chatroom.setPreferredSize(new Dimension(x, y));
			chatroom.setBackground(new Color(255, 255, 255));
			chatroom.setBorder(new LineBorder(new Color(0, 0, 0, 100), 2, true));
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
		

	}

}
