package BBQ_manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BBQ_VO.MessageVO;

public class ChatUIForManager implements ActionListener {

	// Field
	Socket s;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	JList jlist;
	JTextArea chatmain;
	JButton btn_send;
	JTextField send_jtf;
	String name;
	int idnum;
	String[] msgArray;
	JFrame frame;
	ArrayList<MessageVO> currentmsg;

	// Construct
	public ChatUIForManager(int idnum, String name, ArrayList<MessageVO> currentmsg) {
		try {
			this.name = name;
			this.idnum = idnum;
			this.currentmsg = currentmsg;
			s = new Socket("127.0.0.1", 15151);

			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());

			// 1.처음접속
			MessageVO vo = new MessageVO();
			vo.setStatus(MessageVO.CONNECT);
			vo.setName(name);
			vo.setIdnum(idnum);
			oos.writeObject(vo);
			init();

			// 수신작업 실행(무한루프) - inner class 형식의 쓰레드 객체 생성
			ClientThread ct = new ClientThread();
			ct.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method
	public void init() {

		jlist = new JList();

		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 0, 51));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 90, 450, 605);
		frame.getContentPane().setLayout(null);
		frame.setLocation(1100, 100);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 20, 384, 520);

		JPanel chat = new JPanel(new BorderLayout());

		chatmain = new JTextArea();
		chatmain.setPreferredSize(new Dimension(360, 470));
		JPanel middle_pn = new JPanel();
		for (int i = 0; i < currentmsg.size(); i++) {
			if (currentmsg.get(i).getName().equals(name))
				if (currentmsg.get(i).getContent() != null) {
					if(currentmsg.get(i).getIdnum()<10000) {
						chatmain.append(name + " > " + currentmsg.get(i).getContent() + "\n");
					}else {
						chatmain.append("Owner" + " > " + currentmsg.get(i).getContent() + "\n");
					}
				}
		}
		middle_pn.add(chatmain);

		JPanel South_pn = new JPanel();
		send_jtf = new JTextField(25);
		btn_send = new JButton("전송");
		South_pn.add(send_jtf);
		South_pn.add(btn_send);

		// chat.add(BorderLayout.WEST, jlist);
		chat.add(BorderLayout.CENTER, middle_pn);
		chat.add(BorderLayout.SOUTH, South_pn);

		panel.add(chat);

		frame.add(panel);

		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
//					MessageVO vo = new MessageVO();
//					vo.setStatus(MessageVO.EXIT);
//					vo.setName(name);
//					vo.setIdnum(idnum);
//					oos.writeObject(vo);
//					String msg = chatmain.getText();
//					msgArray = msg.split("\n");
					frame.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		btn_send.addActionListener(this);
		send_jtf.addActionListener(this);

	}

	class ClientThread extends Thread {

		public void run() {

			try {
				while (true) {

					MessageVO vo = (MessageVO) ois.readObject();
					if (vo.getStatus() == MessageVO.CONNECT) {
//						jlist.setListData(vo.getUsers());
						if (vo.getName().equals(name) && vo.getIdnum() == idnum) {
							// chatmain.append("사장님이 입장하셨습니다." + "\n");
						} else if (vo.getName().equals(name)) {
							// chatmain.append(vo.getName() + vo.getContent() + "\n");
						}
					} else if (vo.getStatus() == MessageVO.TALK) {

						if (vo.getName().equals(name) && vo.getIdnum() == idnum) {
							chatmain.append("Owner > " + vo.getContent() + "\n");
						} else if (vo.getName().equals(name)) {
							chatmain.append(vo.getName() + " > " + vo.getContent() + "\n");
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn_send || obj == send_jtf) {
			if (!send_jtf.getText().equals("")) {
				try {
					MessageVO vo = new MessageVO();
					vo.setStatus(MessageVO.TALK);
					vo.setName(name);
					vo.setContent(send_jtf.getText());
					vo.setIdnum(idnum);

//					chatmain.append("Owner > "+send_jtf.getText() + "\n");

					oos.writeObject(vo);
					send_jtf.setText("");
					send_jtf.requestFocus();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "메시지를 입력해주세요");
				send_jtf.requestFocus();
			}

		}
	}

}
