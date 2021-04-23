package BBQ_DAO_jk;

import java.util.ArrayList;

import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OrderVO;


public class OrderDAO extends DBConn{
MemberVO member;
MenuVO menu;
OrderVO order;


	/** �ֹ� DB ��� ó��**/
	public boolean getOrderResult() {
		boolean result = false;
		
		try {
			String sql = "insert into bbq_order values(?,?,?,?,?,?,?,?,?,sysdate)";
			getPreparedStatement(sql);
			
			pstmt.setString(1, "1111");
			pstmt.setString(2, member.getId());
			pstmt.setString(3, "order.getMenulist()");
			pstmt.setInt(4, 3);
			pstmt.setString(5, order.getMessage());
			pstmt.setString(6, order.getAddr());
			pstmt.setInt(7, order.getDPrice());
			pstmt.setInt(8, order.getDiscount());
			pstmt.setInt(9, order.getPayment());
			

			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/** ��ü ���� ��ȸ **/
	public ArrayList<OrderVO> getShopBasket() {
		ArrayList<OrderVO> ordervo = new ArrayList<OrderVO>();
		
		try {
			String sql = " SELECT  ROWNUM RNO, B.ORDERID, M.NAME, M.PRICE, D.AMOUNT, D.OPTIONS "
					+ " FROM BBQ_MEMBER I,BBQ_ORDER B , BBQ_ORDER_DETAIL D, MENU_DATA M "
					+ " WHERE I.ID=B.USER_ID and B.ORDERID=D.ORDERID AND D.MID=M.MID  AND B.MID=M.MID " 
					+ " AND B.ORDERID = ?";
					
			getPreparedStatement(sql);
			pstmt.setString(1, "100"); //�ֹ���ȣ
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {	
				OrderVO vo = new OrderVO();
				vo.setRno(rs.getString(1));
				vo.setOrderid(rs.getString(2));
				vo.setMenu(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setAmt(rs.getInt(5));	
				vo.setOption(rs.getString(6));	
				
				ordervo.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordervo;
	}		
	
	/** ��ٱ��� �ֹ� ��ȸ**/
	public OrderVO getShopBasketResult(String id) {
		ArrayList<MenuVO> menulist = new ArrayList<MenuVO>();
		
		try {
			String sql = "SELECT, ROWNUM RNO, B_ORDER_NO, M_NAME, O_OPTION, M_PRICE,B_AMT " 
					+ " FROM BBQ_MEMBER I, BBQ_ORDER B, BBQ_MENU M, BBQ_OPTION O "
					+" WHERE  I.ID=B.B_USER_ID AND M_NAME = B_MENU "
					+ "AND I.ID = ? ";
					
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {					
				menulist.add(rs.getString(3));
				menulist.add(rs.getString(4));
				menulist.add(rs.getInt(5));
				menulist.add(rs.getInt(6));			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}		
		
	/** ���� ó��**/
	public void getPayResult() {
		
	}
}


//	/** �α��� ó�� **/
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
//	/** ȸ������ ó��  **/
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
