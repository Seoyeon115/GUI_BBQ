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
import BBQ_VO.MessageVO;
import BBQ_VO.OrderVO;
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
//			System.out.println("서버 생성");
			
//			mt = new ManagerThread(server.accept());
//			mt.start();
			
			while(true) {				
				Socket s = server.accept();
//				System.out.println("클라이언트 입장");
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
		String uid = "";
		
		ServerThread(Socket s){
			try {
				this.socket = s;
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServerThread(Socket s, String uid){
			this(s);
			this.uid = uid;
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
					oos.writeObject(odao.pushOrder(uid, (OrderVO)req.getObj()));
				}else if(req.getRequest() == RequestVO.CHECK_ID_PRIMARY) {
					oos.writeObject(mdao.getJoinIdResult((String)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_MEMBER_INFO) {// 멤버정보 가져오기
					oos.writeObject(mdao.getmemberlist());
				}else if(req.getRequest() == RequestVO.REQUEST_UPDATE) { // 회원가입
					oos.writeObject(mdao.getUpdateResult((MemberVO)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_ORDER_INFO) {// 주문정보 가져오기
					oos.writeObject(odao.getOrderList());
				}else if(req.getRequest() == RequestVO.ORDER_UPDATE) { // 회원가입
					oos.writeObject(odao.getOrderUpdateResult((OrderVO)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_ADDRESS) { // 주소 불러오기
					oos.writeObject(mdao.getAddress((String)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_LAST_ORDER) {
					oos.writeObject(odao.getLastOrder((String)req.getObj()));
				}else if(req.getRequest() == RequestVO.GET_ORDER_INFO_NOW) {// 주문정보 가져오기
					oos.writeObject(odao.getOrderListNow());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		void chatLoop() {
			boolean flag = true;
			MessageVO message;
			try {
				while(flag) {
					message = (MessageVO) ois.readObject();
//					mt.chatting(message);
					if(message.getStatus() == MessageVO.EXIT) {
						flag = false;
					}
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
					}else {
						response(req);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					ois.close();
					oos.close();
					socket.close();
					stlist.remove(this);
//					System.out.println(uid +" 종료");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
//			System.out.println("클라이언트 종료");
		}
	}
	
	class ManagerThread extends ServerThread{
		
		ManagerThread(Socket socket){
			super(socket, "MANAGER");
		}
		
//		void recieveOrder(RequestVO req) {
//			try {				
//				oos.writeObject(req);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		void notifyChat(RequestVO req) {
//			try {
//				oos.writeObject(req);
//				111
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		void chatting(MessageVO msg) {
//			try {
//				oos.writeObject(msg);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
}
