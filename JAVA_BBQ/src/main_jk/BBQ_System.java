package main_jk;


import BBQ_DAO_jk.MemberDAO;
import BBQ_DAO_jk.OrderDAO;
import BBQ_VO.MemberVO;


public class BBQ_System {
	//Field
	MemberDAO mdao = new MemberDAO();	
	OrderDAO odao = new OrderDAO();
	//login ���
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public BBQ_System() {		
		
	}
	
	
	/** �α��� **/
	public boolean loginCheck(String id, String pass) {
		return mdao.getLoginResult(id, pass);
	}

	
	/** ȸ������ **/
	public boolean join(MemberVO member) {	
		return mdao.getJoinResult(member);
	}
	
	/** ���̵� �ߺ�üũ **/
	public boolean idcheck(String id) {	
		return mdao.getJoinIdResult(id);
	}
	
	/** ��ٱ��� �޴����� **/
//	public	ArrayList<CartVO> shopBasketMenu(String id) {	
//		return odao.getShopBasketResult(id);
//		}
//	public	ArrayList<OptionVO> shopBasketOption() {	
//		return odao.getShopBasketOption();
//		}
	
	
	/** ���� **/
//	public void close() {
//		mdao.close();
//		sdao.close();
//		System.out.println("-----------DB���� ����----------");
//	}

	
}//class
















