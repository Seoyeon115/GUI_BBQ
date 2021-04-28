package BBQ_Manage;

import java.util.ArrayList;

import BBQ_VO.CartVO;
import BBQ_VO.MemberVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class ManagerSystem {
	ManagerClient client = new ManagerClient();
	
	
	/** 조회 **/
	public ArrayList<MemberVO> getMemberList(){
		return client.getMemberInfo();
		
	}
	/** 주문 확인 조회 **/
	public ArrayList<OrderVO> getOrdercheckList(){
		return client.getOrderInfo();
		
	}
	
	/** 수정 **/
	public boolean update(MemberVO member) {	
		return client.getUpdateResult(member);
	}	
	public boolean orderupdate(OrderVO order) {	
		return client.getOrderUpdateResult(order);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		ArrayList<OrderVO> orderlist = client.getOrderInfo();
		for(OrderVO order : orderlist) {
			order.setPrice(getOrderPrice(order));
		}
		
		return orderlist;
	}
	
	public ArrayList<OrderVO> getOrderList(String uid){
		ArrayList<OrderVO> orderlist = client.getOrderInfo(uid);
		for(OrderVO order : orderlist) {
			order.setPrice(getOrderPrice(order));
		}
		
		return orderlist;
	}
	
	public ArrayList<OrderVO> getOrderListNow(){
		ArrayList<OrderVO> orderlist = client.getOrderInfoNow();
		for(OrderVO order : orderlist) {
			order.setPrice(getOrderPrice(order));
		}
		
		return orderlist;
	}
	
	public int getOrderPrice(OrderVO order) {
		int price = 0;
		
		for(CartVO cart : order.getMenulist()) {
			cart.setPrice(cart.getMenu().getPrice());
			for(OptionVO op : cart.getOptions()) {
				cart.addPrice(op.getPrice());
			}
			price += cart.getPrice() * cart.getAmt();
		}
		
		return price;
	}
}
