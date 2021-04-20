package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BBQ_VO.MessageVO;

public class ChatUI implements ActionListener {

	// Field
	Socket s;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	JList jlist;
	JTextArea chatmain;
	JButton btn_send,btn_home;
	JTextField send_jtf;
	JPanel C_panel;
	InnerMain main;
	Orderstatus_on prev_Page;
	String[] msg_array;
	
	// Construct
	public ChatUI() {
		
	}
	public ChatUI(InnerMain main) {
		this.main = main;
		
	}
//	public ChatUI(InnerMain main,Orderstatus_on prev_Page) {
//		this.main = main;
//		this.prev_Page = prev_Page;
//	}
	
	public void createsocket(int idnum) {
		try {
		s = new Socket("localhost", 9000);

		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());

		// 1.처음접속
		MessageVO vo = new MessageVO();
		vo.setStatus(MessageVO.CONNECT);
		vo.setName("Client");
		vo.setIdnum(idnum);
		oos.writeObject(vo);

		//main.frame.add(init());

		// 수신작업 실행(무한루프) - inner class 형식의 쓰레드 객체 생성
		ClientThread ct = new ClientThread();
		ct.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	// Method
	public JPanel init() {
		
		jlist = new JList();
		
		
//		JFrame frame = new JFrame();
//		frame.setResizable(false);
//		frame.getContentPane().setBackground(new Color(204, 0, 51));
//		frame.getContentPane().setForeground(new Color(255, 255, 255));
//		frame.setBounds(100, 90, 600, 910);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);

		C_panel = new JPanel();
		C_panel.setBackground(new Color(255, 255, 255));
		C_panel.setBounds(30, 22, 520, 820);
		
		JPanel north_panel = new JPanel(new BorderLayout());
		north_panel.setPreferredSize(new Dimension(540, 45));
		north_panel.setBackground(new Color(255, 255, 255));
				
		ImageIcon home = new ImageIcon("images/leftr.png");
		ImageIcon home2 = new ImageIcon("images/lefty.png");
				
		JButton btn_home_blank = new JButton();
		btn_home_blank.setBackground(new Color(255, 255, 255));
		btn_home_blank.setPreferredSize(new Dimension(5, 35));
		JPanel btn_home_pn = new JPanel();
		btn_home_pn.setBackground(new Color(255, 255, 255));
		
		btn_home = new JButton();
		btn_home.setIcon(home);
		btn_home.setPressedIcon(home2);
		btn_home.setForeground(new Color(255, 255, 255));
		btn_home.setBackground(new Color(255, 255, 255));
		btn_home.setPreferredSize(new Dimension(40, 40));
		btn_home.setContentAreaFilled(false);

		// 이미지만 넣기
		btn_home.setBorderPainted(false);
		btn_home.setFocusPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_home_blank.setBorderPainted(false);
		btn_home_blank.setFocusPainted(false);
		btn_home_blank.setContentAreaFilled(false);
		btn_home_blank.addActionListener(this);
		
		//라벨 넣기
		JLabel t_label = new JLabel("주인님과 직접연결~  ");
		t_label.setFont(Commons.getFont(18));
		JPanel label_pn = new JPanel(new FlowLayout(FlowLayout.LEFT,125,10));
		label_pn.add(t_label);
		label_pn.setBackground(new Color(255,255,255));
		
		btn_home_pn.add(btn_home_blank);
		btn_home_pn.add(btn_home);
		north_panel.add(BorderLayout.WEST, btn_home_pn);
		north_panel.add(BorderLayout.CENTER, label_pn);
		C_panel.add(BorderLayout.NORTH, north_panel);
		JPanel chat = new JPanel(new BorderLayout());
		

		chatmain = new JTextArea();
		chatmain.setPreferredSize(new Dimension(470, 700));
		chatmain.setFont(Commons.getFont(16));
		JPanel middle_pn = new JPanel();
		middle_pn.add(chatmain);
		middle_pn.setBackground(new Color(204,0,51,180));
		
		JPanel South_pn = new JPanel();
		send_jtf = new JTextField(25);
		send_jtf.setFont(Commons.getFont(16));
		btn_send = new JButton("전송");
		South_pn.add(send_jtf);
		South_pn.add(btn_send);
		South_pn.setBackground(new Color(255,255,255));
		//chat.add(BorderLayout.WEST, jlist);
		chat.add(BorderLayout.CENTER, middle_pn);
		chat.add(BorderLayout.SOUTH, South_pn);
		
		C_panel.add(chat);

//		frame.add(panel);

//		frame.setVisible(true);
		
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				try {
//					MessageVO vo = new MessageVO();
//					vo.setStatus(MessageVO.EXIT);
//					vo.setName("Client");
//					oos.writeObject(vo);
//					frame.dispose();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
		
		btn_send.addActionListener(this);
		send_jtf.addActionListener(this);
		btn_home.addActionListener(this);
		C_panel.setVisible(true);
		return C_panel;
	}

	class ClientThread extends Thread {

		public void run() {

			try {
				while (true) {
					
					MessageVO vo = (MessageVO) ois.readObject();
					if(vo.getStatus() == MessageVO.CONNECT) {
						jlist.setListData(vo.getUsers());
						chatmain.append(vo.getContent() + "\n");
					}else if(vo.getStatus() == MessageVO.TALK) {
						
						chatmain.append(vo.getName()+" > "+vo.getContent() + "\n");
						
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
					vo.setName("Client");
					vo.setContent(send_jtf.getText());
					
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

		}else if(obj == btn_home) {
			C_panel.setVisible(false);
			
			String msg = chatmain.getText();
			msg_array = msg.split("\n");
			
			main.switchPanel(InnerMain.ORDERSTATUS);;
		}
	}

}
