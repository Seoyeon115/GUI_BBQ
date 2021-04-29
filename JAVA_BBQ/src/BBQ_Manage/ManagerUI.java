package BBQ_Manage;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import BBQ_UI.Commons;
import BBQ_VO.MessageVO;
import BBQ_VO.RequestVO;

public class ManagerUI implements ActionListener {
	ManagerUImember memberui;
	ManagerUIorder orderui;

	ArrayList<String> namelist = new ArrayList<String>();
	JButton btn_modify, btn_ordertake, btn_chat;
	int idnum = 10000;
	Socket s;
	ArrayList<JPanel> roomList, wpList;
	ArrayList<JButton> btnList;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ArrayList<String> nameList = new ArrayList<String>();
	JFrame frame;
	JPanel panel;
	JPanel contents = new JPanel(new BorderLayout());
	JPanel west_pn;
	ChatUIForManager ui;
	ArrayList<MessageVO> msglist = new ArrayList<MessageVO>();
	ManagerSystem system;
	

	public ManagerUI() {
//		createsocket(0);
		system = new ManagerSystem();
		memberui = new ManagerUImember(this);
		orderui = new ManagerUIorder(this);
		init();
	}

//	public void createsocket(int idnum) {
//		try {
//			s = new Socket("127.0.0.1", 9090);
//
//			oos = new ObjectOutputStream(s.getOutputStream());
//			ois = new ObjectInputStream(s.getInputStream());
//
//			// 1.처음접속
//			MessageVO vo = new MessageVO();
//			vo.setStatus(MessageVO.CONNECT);
//			vo.setName("Owner_pn");
//			vo.setIdnum(idnum);
//			oos.writeObject(vo);
//
//			// 수신작업 실행(무한루프) - inner class 형식의 쓰레드 객체 생성
//			ClientThread1 ct = new ClientThread1();
//			ct.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	public void init() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 20, 932, 617);

		JPanel west_pn = new JPanel(new GridLayout(7, 1, 0, 0));
		west_pn.setBackground(new Color(255, 255, 255));

		ImageIcon modicon = new ImageIcon("images/정보수정.png");
		ImageIcon modicon2 = new ImageIcon("images/정보수정2.png");
		ImageIcon ordericon = new ImageIcon("images/주문확인.png");
		ImageIcon ordericon2 = new ImageIcon("images/주문확인2.png");
		ImageIcon chaticon = new ImageIcon("images/문의확인.png");
		ImageIcon chaticon2 = new ImageIcon("images/문의확인2.png");

		JPanel west_blank = new JPanel();
		JLabel label = new JLabel("사장님 메뉴");
		label.setFont(Commons.getFont(1, 32));
		west_blank.add(label);
		west_blank.setBackground(new Color(255, 255, 255));
		west_pn.add(west_blank);

		JPanel west_blank2 = new JPanel();
		west_blank2.setBackground(new Color(255, 255, 255));
		west_pn.add(west_blank2);

		JPanel btn_modify_pn = new JPanel();
		btn_modify_pn.setBackground(new Color(255, 255, 255));
		btn_modify = new JButton();
		btn_modify.setIcon(modicon);
		btn_modify.setPressedIcon(modicon2);
		btn_modify_pn.add(btn_modify);

		JPanel btn_ordertake_pn = new JPanel();
		btn_ordertake_pn.setBackground(new Color(255, 255, 255));
		btn_ordertake = new JButton();
		btn_ordertake.setIcon(ordericon);
		btn_ordertake.setPressedIcon(ordericon2);
		btn_ordertake_pn.add(btn_ordertake);

		JPanel btn_chat_pn = new JPanel();
		btn_chat_pn.setBackground(new Color(255, 255, 255));
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

		contents.setBackground(new Color(255, 255, 255));

		JPanel firstmain = new JPanel();
		firstmain.setBackground(new Color(255, 255, 255));
		
		contents.add(firstmain);

		panel.add(BorderLayout.CENTER, contents);
		panel.add(BorderLayout.WEST, west_pn);
		
		btn_modify.addActionListener(this);
		btn_ordertake.addActionListener(this);
		btn_chat.addActionListener(this);

		frame.add(panel);

		frame.setVisible(true);

	}

	public JPanel chatPanel() {

		JPanel contants_pn = new JPanel(new BorderLayout());
		JPanel nmain = new JPanel();
		nmain.setLayout(new BoxLayout(nmain, BoxLayout.Y_AXIS));
		JPanel main = new JPanel();
		main.setBackground(new Color(255, 255, 255));
		roomList = new ArrayList<JPanel>();
		wpList = new ArrayList<JPanel>();
		btnList = new ArrayList<JButton>();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		int x = 500;
		int y = 50;

		// 목록 제목
		JPanel northblank = new JPanel();
		northblank.setPreferredSize(new Dimension(x, 20));
		northblank.setBackground(new Color(255, 255, 255));
		nmain.add(northblank);
		JPanel northname = new JPanel();
		northname.setPreferredSize(new Dimension(x, y));
		northname.setBackground(new Color(255, 255, 255));
		nmain.add(northname);
		JLabel lb = new JLabel("채팅 대화 목록");
		lb.setFont(Commons.getFont(1, 28));
		northname.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		northname.add(lb);

		// 목록 추가
		for (int i = 0; i < 30; i++) {
			JPanel chatroom = new JPanel();
			chatroom.setPreferredSize(new Dimension(x, y));
			chatroom.setBackground(new Color(255, 255, 255));
			chatroom.setBorder(new LineBorder(new Color(204, 0, 51, 100), 2, true));
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

		contants_pn.add(BorderLayout.NORTH, nmain);
		contants_pn.add(BorderLayout.CENTER, scroll);

		return contants_pn;
	}

	class ClientThread1 extends Thread {

		public void run() {

			try {
				while (true) {
					RequestVO req = (RequestVO) ois.readObject();
//					
//					if(req.getRequest() == RequestVO.REQUEST_ORDER) { // 클라이언트의 주문 요청
//						111
//					}else if(req.getRequest() == RequestVO.ENTER_CHAT) { // 클라이언트의 채팅 입장
//						123
//					}
					MessageVO vo = (MessageVO) ois.readObject();
					if (vo.getStatus() == MessageVO.CONNECT) {
						int check = 0;
						for (int i = 0; i < nameList.size(); i++) {
							if (nameList.get(i).equals(vo.getName())) {
								check += 1;
							}
						}
						if (check == 0) {
							if (!vo.getName().equals("Owner_pn")) {
								nameList.add(vo.getName());
							}
						}
					} else if (vo.getStatus() == MessageVO.TALK) {
						int check1 = 0;
						for (int i = 0; i < nameList.size(); i++) {
							if (nameList.get(i).equals(vo.getName())) {
								check1 += 1;
							}
						}
						if (check1 == 0) {
							if (!vo.getName().equals("Owner_pn")) {
								nameList.add(vo.getName());
							}
						}
					}
					msglist.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_modify) {
//			System.out.println("수정버튼");
			contents.removeAll();			
			contents.add(BorderLayout.CENTER, memberui.init());
//			contents.setVisible(true);
			
		} else if (obj == btn_ordertake) {
			System.out.println("주문버튼");
			contents.removeAll();			
			contents.add(BorderLayout.CENTER, orderui.init());
			
		} else if (obj == btn_chat) {
			// 챗 패널 바꾸기
			contents.removeAll();
			contents.add(BorderLayout.CENTER, chatPanel());

			// 새로고침
			if (nameList.size() != 0) {
				for (int j = 0; j < nameList.size(); j++) {
					JPanel room = roomList.get(j);
					String name = nameList.get(j);
					JPanel west_pn = wpList.get(j);

					JLabel roomname = new JLabel(name);
					String currentmsg = new String();
					for (int l = 0; l < msglist.size(); l++) {
						if (msglist.get(l).getName().equals(name)) {
							if (msglist.get(l).getContent() != null) {
								if (msglist.get(l).getIdnum() < 10000) {
									currentmsg = "  " + msglist.get(l).getName() + " > " + msglist.get(l).getContent();
								} else {
									currentmsg = "  " + "Owner" + " > " + msglist.get(l).getContent();
								}
							} else {
								currentmsg = null;
							}
						}
					}
					if (currentmsg != null) {
						west_pn.removeAll();
						JLabel ctmsg = new JLabel(currentmsg);
						ctmsg.setFont(Commons.getFont(1, 20));
						west_pn.add(roomname);
						west_pn.add(ctmsg);
					}

					JButton enterroom = new JButton("입장");
					enterroom.setFont(Commons.getFont());
					roomname.setFont(Commons.getFont(1, 30));
					room.setLayout(new BorderLayout());
					room.add(BorderLayout.WEST, west_pn);
					room.add(BorderLayout.EAST, enterroom);
					enterroom.addActionListener(new ActionListener() {
						boolean check = false;

						@Override
						public void actionPerformed(ActionEvent e) {
							Object obj = e.getSource();
							if (obj == enterroom) {
								// 채팅창 열기
								if (check == false) {
									idnum += 1;
									ui = new ChatUIForManager(idnum, name, msglist);
								}
							}
						}
					});
				}
			}

		}
		frame.revalidate();

	}

}
