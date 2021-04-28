package BBQ_SYSTEM;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OrderVO;
import BBQ_VO.RequestVO;

public class BBQ_Client {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	BBQ_Client(){
		try {
			socket = new Socket("localhost", 9000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean getJoinResult(MemberVO member) {
		boolean result = false;
		try {
			oos.writeObject(new RequestVO(RequestVO.REQUEST_JOIN, member));
			result = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		
		try {
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPass(pass);
			oos.writeObject(new RequestVO(RequestVO.REQUEST_LOGIN, member));
			result = (boolean)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean idCheck(String id) {
		boolean result = false;
		
		try {
			oos.writeObject(new RequestVO(RequestVO.CHECK_ID_PRIMARY, id));
			result = (boolean)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MenuVO getMenuInfo(int mid) {
		MenuVO menu = null;
		
		try {			
			oos.writeObject(new RequestVO(RequestVO.GET_MENU_INFO, mid));
			menu = (MenuVO) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menu;
	}
	
	public ArrayList<OrderVO> getOrderList(String uid){
		ArrayList<OrderVO> orderlist = null;
		
		try {
			oos.writeObject(new RequestVO(RequestVO.GET_ORDERLIST, uid));
			orderlist = (ArrayList<OrderVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public String getAddr(String uid) {
		String addr = "";
		
		try {
			oos.writeObject(new RequestVO(RequestVO.GET_ADDRESS, uid));
			addr = (String) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return addr;
	}
	
	public boolean pushOrder(OrderVO order) {
		boolean result = false;
		
		try {
			oos.writeObject(new RequestVO(RequestVO.REQUEST_ORDER, order));
			result = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
