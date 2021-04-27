package BBQ_SYSTEM;

import java.util.ArrayList;

import BBQ_DAO.MemberDAO;
import BBQ_DAO.MenuDAO;
import BBQ_DAO.OrderDAO;
import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;


public class BBQ_System {
	//Field
	BBQ_Client client;
	ArrayList<MenuVO> cart; // 장바구니
	
	String uid = "test";
	
	//login 결과
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public BBQ_System() {		
		client = new BBQ_Client();
	}
	
	
	/** 로그인 **/
	public boolean loginCheck(String id, String pass) {
		return client.getLoginResult(id, pass);
	}

	
	/** 회원가입 **/
	public boolean join(MemberVO member) {	
		return client.getJoinResult(member);
	}
	/** 종료 **/
//	public void close() {
//		mdao.close();
//		sdao.close();
//		System.out.println("-----------DB연결 종료----------");
//	}
//	
	/** 등록 **/
//	public boolean insert(ScoreVO score) {	
//		return sdao.getInsertResult(score);		
//	}
//	
	/** 조회 **/
	public ArrayList<MemberVO> getMemberList(){
		return client.getMemberInfo();
		
	}
	/** 검색 **/
//	public ScoreVO search(String name) {
//		return sdao.getSelectResult(name);
//	}
//	
	
	/** 수정 **/
	public boolean update(MemberVO member) {	
		return client.getUpdateResult(member);
	}	
	/** 삭제 **/
//	public boolean delete(String name) {
//		return sdao.getDeleteResult(name);
//	}
	
	public boolean addCart(MenuVO menu) {
		return cart.add(menu);
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
}//class
















