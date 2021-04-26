package BBQ_SYSTEM;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import BBQ_VO.MessageVO;

public class ChatServer {
	// Field
	ServerSocket server;
	ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	ArrayList<String> idlist = new ArrayList<String>();
	Vector<String> users = new Vector<String>();

	// Constructor
	public ChatServer() {
		init();

	}

	public void init() {
		try {
			server = new ServerSocket(9000);
			System.out.println("-------->> 서버 실행중");

			while (true) {
				Socket s = server.accept();
				ServerThread st = new ServerThread(s);
				st.start();

				list.add(st);

				System.out.println("-------->> 클라이언트 접속완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// init

	
	public void broadcast(MessageVO vo) {
		try {
			if (vo.getStatus() == MessageVO.CONNECT) {
				//vo.setContent("님 입장");
				idlist.add(String.valueOf(vo.getIdnum()));
				users.add(vo.getName());

				Vector<String> user2 = (Vector<String>) users.clone();

				vo.setUsers(user2);

			} else if (vo.getStatus() == MessageVO.TALK) {

				Vector<String> users2 = (Vector<String>)users.clone();
				vo.setUsers(users2);

			} else if (vo.getStatus() == MessageVO.EXIT) {
				int idx = idlist.indexOf(String.valueOf(vo.getIdnum()));
				ServerThread st = list.get(idx);
				Iterator<ServerThread> ie = list.iterator();

				while (ie.hasNext()) {
					if (ie.next() == st) {
						ie.remove();
					}
				}

				idlist.remove(String.valueOf(vo.getIdnum()));
				users.remove(vo.getName());
				Vector<String> users2 = (Vector<String>) users.clone();
				vo.setUsers(users2);

				vo.setContent("Client 퇴장");
			}

			for (ServerThread st : list) {
				st.oos.writeObject(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class ServerThread extends Thread {

		// Field
		ObjectInputStream ois;
		ObjectOutputStream oos;

		// Constructor
		public ServerThread(Socket s) {
			try {
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void run() {
			try {
				while (true) {
					MessageVO vo = (MessageVO) ois.readObject();
					broadcast(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}// class
