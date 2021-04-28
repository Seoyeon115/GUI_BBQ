package main_jk;


import BBQ_DAO_jk.MemberDAO;
import BBQ_DAO_jk.OrderDAO;
import BBQ_VO.MemberVO;


public class BBQ_System {
	//Field
	MemberDAO mdao = new MemberDAO();	
	OrderDAO odao = new OrderDAO();
	//login 결과
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public BBQ_System() {		
		
	}
	
	
	/** 로그인 **/
	public boolean loginCheck(String id, String pass) {
		return mdao.getLoginResult(id, pass);
	}

	
	/** 회원가입 **/
	public boolean join(MemberVO member) {	
		return mdao.getJoinResult(member);
	}
	
	/** 아이디 중복체크 **/
	public boolean idcheck(String id) {	
		return mdao.getJoinIdResult(id);
	}
	
	/** 장바구니 메뉴생성 **/
//	public	ArrayList<CartVO> shopBasketMenu(String id) {	
//		return odao.getShopBasketResult(id);
//		}
//	public	ArrayList<OptionVO> shopBasketOption() {	
//		return odao.getShopBasketOption();
//		}
	
	
	/** 종료 **/
//	public void close() {
//		mdao.close();
//		sdao.close();
//		System.out.println("-----------DB연결 종료----------");
//	}

	
}//class
















