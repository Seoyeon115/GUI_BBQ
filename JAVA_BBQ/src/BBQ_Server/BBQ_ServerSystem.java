package BBQ_Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import BBQ_DAO.MemberDAO;
import BBQ_DAO.MenuDAO;
import BBQ_DAO.OrderDAO;
import BBQ_VO.MemberVO;
import BBQ_VO.RequestVO;

public class BBQ_ServerSystem {
	ServerSocket server;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	MemberDAO mdao = new MemberDAO();
	MenuDAO mndao = new MenuDAO();
	OrderDAO odao = new OrderDAO();
	ArrayList<ServerThread> stlist = new ArrayList<ServerThread>();
	ManagerThread mt;
	
	BBQ_ServerSystem(){
		try {
			server = new ServerSocket(9000);
			System.out.println("서버 생성");
			
			mt = new ManagerThread(server.accept());
			mt.start();
			
			while(true) {				
				Socket s = server.accept();
				System.out.println("클라이언트 입장");
				ServerThread st = new ServerThread(s);
				stlist.add(st);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class ServerThread extends Thread {
		Socket socket;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		String uid = null;
		
		ServerThread(Socket s){
			try {
				this.socket = s;
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		void response(RequestVO req) { // 클라이언트 요청에 대한 응답 송신
			try {				
				if(req.getRequest() == RequestVO.GET_MENU_INFO) { // 메뉴 정보 불러오기
					oos.writeObject(mndao.getMenu((int)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_ORDERLIST) { // 주문 내역 불러오기
					oos.writeObject(odao.getOrderList(uid));
				}else if(req.getRequest() == RequestVO.REQUEST_JOIN) { // 회원가입
					oos.writeObject(mdao.getJoinResult((MemberVO)req.getObj()));
				}else if(req.getRequest() == RequestVO.REQUEST_LOGIN) { // 로그인
					String id = ((MemberVO)req.getObj()).getId();
					String pass = ((MemberVO)req.getObj()).getPass();
					boolean result = mdao.getLoginResult(id, pass);
					if(result) uid = id;
					oos.writeObject(result);
				}else if(req.getRequest() == RequestVO.REQUEST_ORDER) { // 주문 요청
					// 여기에 DB에 주문 데이터 입력하는 코드 넣기!
					mt.recieveOrder(req);
					oos.writeBoolean(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				boolean flag = true;
				while(flag) {
					RequestVO req = (RequestVO) ois.readObject();
					if(req.getRequest() == RequestVO.EXIT) { // 종료 신호 수신
						flag = false;
						ois.close();
						oos.close();
						socket.close();
						stlist.remove(this);
					}else {
						response(req);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("클라이언트 종료");
		}
	}
	
	class ManagerThread extends ServerThread{
		
		ManagerThread(Socket socket){
			super(socket);
			uid = "manager";
		}
		
		void recieveOrder(RequestVO req) {
			try {				
				oos.writeObject(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		@Override
//		public void run() {
//			boolean flag = true;
//			while(flag) {
//				
//			}
//		}
	}
}
