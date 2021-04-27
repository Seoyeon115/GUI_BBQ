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
			socket = new Socket("localhost", 12345);
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
	public boolean getUpdateResult(MemberVO member) {
		boolean result = false;
		try {
			oos.writeObject(new RequestVO(RequestVO.REQUEST_UPDATE, member));
			result = (boolean) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean getOrderUpdateResult(OrderVO order) {
		boolean result = false;
		try {
			oos.writeObject(new RequestVO(RequestVO.ORDER_UPDATE, order));
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
	public ArrayList<MemberVO> getMemberInfo() {
		ArrayList<MemberVO> memberlist = new ArrayList<MemberVO>();
		
		try {			
			oos.writeObject(new RequestVO(RequestVO.GET_MEMBER_INFO));
			memberlist = (ArrayList<MemberVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memberlist;
	}
	public ArrayList<OrderVO> getOrderInfo() {
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		
		try {			
			oos.writeObject(new RequestVO(RequestVO.GET_ORDER_INFO));
			orderlist = (ArrayList<OrderVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
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
}
