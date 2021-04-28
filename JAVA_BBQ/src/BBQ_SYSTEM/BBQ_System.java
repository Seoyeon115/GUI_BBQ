package BBQ_SYSTEM;

import java.util.ArrayList;

import BBQ_VO.CartVO;
import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;


public class BBQ_System {
	//Field
	BBQ_Client client;
	ArrayList<CartVO> cart = new ArrayList<CartVO>(); // ��ٱ���
	String uid;
	
	//login ���
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public BBQ_System() {		
		client = new BBQ_Client();
	}
	
	
	/** �α��� **/
	public boolean loginCheck(String id, String pass) {
		boolean result = client.getLoginResult(id, pass);
		if(result) {
			uid = id;
		}
		return result;
	}

	
	/** ȸ������ **/
	public boolean join(MemberVO member) {	
		return client.getJoinResult(member);
	}
	
	/** ���̵� �ߺ�üũ **/
	public boolean idcheck(String id) {	
		return client.idCheck(id);
	}
	/** ���� **/
	public boolean addCart(MenuVO menu, int price, ArrayList<OptionVO> optionlist) {
		boolean result = false;
		boolean isIn = false;
		int idx = 0;
		String options = optionToStr(optionlist);
		
		for(int i=0;i<cart.size();i++) {
			String cartOptions = optionToStr(cart.get(i).getOptions());
			if(cart.get(i).getMenu().getMid() == menu.getMid() && cartOptions.equals(options)) {
				isIn = true;
				idx = i;
				i = cart.size();
			}
		}
		if(isIn) { // ���� �ɼ��� ���� �޴��� ���� ��� ���� �߰��� ��
			cart.get(idx).add(1);
			result = true;
		}else {
			result = cart.add(new CartVO(menu, price, optionlist));
		}
		
		return result;
	}
	
	public String optionToStr(ArrayList<OptionVO> optionlist) {
		String ops = "";
		for(OptionVO op : optionlist) {
			if(ops.equals("")) ops = String.valueOf(op.getOid());
			else ops += "/" + op.getOid();
		}
		return ops;
	}
	
	public MenuVO getMenuInfo(int mid) {
		return client.getMenuInfo(mid);
	}
	
	public ArrayList<OrderVO> getOrderList(){
		ArrayList<OrderVO> orderlist = client.getOrderList(uid);
		for(OrderVO order : orderlist) {
			order.setPrice(getOrderPrice(order));
		}
		
		return orderlist;
	}
	
	public int getOrderPrice(OrderVO order) {
		int price = 0;
		
		for(MenuVO menu : order.getMenulist()) {
			price += menu.getPrice();
			
			for(OptionVO option : menu.getOptions()) {
				price += option.getPrice();
			}
			
		}
		
		return price;
	}

	public ArrayList<CartVO> getCart(){
		return cart;
	}
	
	public void deleteCartMenu(int idx) {
		cart.remove(idx);
	}
	
	public void deleteCartAll() {
		cart = new ArrayList<CartVO>();
	}
}//class
