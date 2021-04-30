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
	public String uid;
	
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
//	public void close() {
//		mdao.close();
//		sdao.close();
//		System.out.println("-----------DB���� ����----------");
//	}
//	
	/** ��� **/
//	public boolean insert(ScoreVO score) {	
//		return sdao.getInsertResult(score);		
//	}
//	
	/** ��ȸ **/
//	public ArrayList<ScoreVO> getScoreList(){
//		return sdao.getSelectResult();
//		
//	}
	
	/** �˻� **/
//	public ScoreVO search(String name) {
//		return sdao.getSelectResult(name);
//	}
//	
	
	/** ���� **/
//	public int update(ScoreVO score, String name) {
//		return sdao.getUpdateResult(score, name);
//	}
//	
	
	/** ���� **/
//	public boolean delete(String name) {
//		return sdao.getDeleteResult(name);
//	}
	
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
	
	public void addCart(int idx) {
		cart.get(idx).add(1);
	}
	
	public void reduceCart(int idx) {
		cart.get(idx).add(-1);
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
		
		for(CartVO cart : order.getMenulist()) {
			cart.setPrice(cart.getMenu().getPrice());
			for(OptionVO op : cart.getOptions()) {
				cart.addPrice(op.getPrice());
			}
			price += cart.getPrice() * cart.getAmt();
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
	
	public boolean pushOrder(OrderVO order) {
		return client.pushOrder(order);
	}
	
	public String getAddress() {
		return client.getAddr(uid);
	}
	
	public OrderVO getLastOrder() {
		return client.getLastOrder(uid);
	}
	
	public Object[] getConnection() {
		Object[] vals = client.getConnection();
		return vals;
	}
}//class
