package BBQ_DAO_jk;

import java.util.ArrayList;

import BBQ_VO.CartVO;
import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;


public class OrderDAO extends DBConn{
MemberVO member;
public ArrayList<CartVO> ordervo;
public ArrayList<OptionVO> optionvo;



	/** 주문 DB 등록 처리**/
//	public boolean getOrderResult() {
//		boolean result = false;
//		
//		try {
//			String sql = "insert into bbq_order values(?,?,?,?,?,?,?,?,?,sysdate)";
//			getPreparedStatement(sql);
//			
//			pstmt.setString(1, "1111");
//			pstmt.setString(2, member.getId());
//			pstmt.setString(3, "order.getMenulist()");//menu리스트 고민중
//			pstmt.setInt(4, 3);
//			pstmt.setString(5, order.getMessage());
//			pstmt.setString(6, order.getAddr());
//			pstmt.setInt(7, order.getDPrice());
//			pstmt.setInt(8, order.getDiscount());
//			pstmt.setInt(9, order.getPayment());
//			
//
//			
//			int val = pstmt.executeUpdate();
//			if(val != 0) result = true;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}

/** 장바구니 주문 조회**/
	public ArrayList<CartVO> getShopBasketResult(String id) {
		ordervo = new ArrayList<CartVO>();
		
		try {
			String sql = " SELECT ROWNUM RNO, M.NAME, M.PRICE, C.AMOUNT "
					+ " FROM BBQ_MEMBER I, BBQ_CART C, MENU_DATA M "
					+ " WHERE I.ID=C.USER_ID AND M.MID=C.MID "
					+ " AND I.ID =? ";
					
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {	
				CartVO vo = new CartVO();
				vo.setRno(rs.getInt(1));
				vo.setMenu(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setAmt(rs.getString(4));
				
				ordervo.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordervo;
	}		
	/** 장바구니 옵션 조회**/
	public ArrayList<OptionVO> getShopBasketOption() {
		optionvo = new ArrayList<OptionVO>();
		
		try {
			String sql = " SELECT  distinct M.NAME, O.NAME, O.PRICE "
					+ " FROM OPTION_DATA O , MENU_DATA M "
					+ " WHERE O.MID=M.MID ";
					
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {	
				OptionVO vo = new OptionVO();
				vo.setMenu(rs.getString(1));
				vo.setOption(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				
				optionvo.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return optionvo;
	}	
	
		
	/** 결제 처리**/
	public void getPayResult() {
		
	}
}


//	/** 로그인 처리 **/
//	public boolean getLoginResult (String id, String pass) {
//		boolean result = false;
//		try {
//			String sql ="SELECT COUNT(*) FROM BBQ_MEMBER "
//					+ "WHERE ID =? AND PASS =?"; 
//			getPreparedStatement(sql);
//			
//			pstmt.setString(1, id);
//			pstmt.setString(2, pass);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				if(rs.getInt(1) ==1) result = true;
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	
//	/** 회원가입 처리  **/
//	public boolean getJoinResult(MemberVO member) {
//		boolean result = false;
//				
//		try {
//			String sql = "insert into bbq_member values(?,?,?,?,?,sysdate)";
//			getPreparedStatement(sql);
//			
//			String hp = member.getHp1()+"-"+member.getHp2()+"-"+member.getHp3();
//			String addr = member.getAddr1()+" " + member.getAddr2();
//			pstmt.setString(1, member.getId());
//			pstmt.setString(2, member.getPass());
//			pstmt.setString(3, member.getName());
//			pstmt.setString(4, hp);
//			pstmt.setString(5, addr);
//
//			
//			int val = pstmt.executeUpdate();
//			if(val != 0) result = true;
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	
//}
