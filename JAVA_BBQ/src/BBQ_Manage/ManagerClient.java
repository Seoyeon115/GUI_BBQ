package BBQ_Manage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import BBQ_VO.MemberVO;
import BBQ_VO.OrderVO;
import BBQ_VO.RequestVO;

public class ManagerClient {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	ManagerClient(Object[] vals){
		socket = (Socket)vals[0];
		oos = (ObjectOutputStream) vals[1];
		ois = (ObjectInputStream) vals[2];
//		try {
//			socket = new Socket("localhost", 9000);
//			oos = new ObjectOutputStream(socket.getOutputStream());
//			ois = new ObjectInputStream(socket.getInputStream());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
	
	public ArrayList<OrderVO> getOrderInfo(String uid) {
		ArrayList<OrderVO> orderlist = null;
		
		try {			
			oos.writeObject(new RequestVO(RequestVO.GET_ORDERLIST, uid));
			orderlist = (ArrayList<OrderVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public ArrayList<OrderVO> getOrderInfoNow() {
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		
		try {			
			oos.writeObject(new RequestVO(RequestVO.GET_ORDER_INFO_NOW));
			orderlist = (ArrayList<OrderVO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
}
