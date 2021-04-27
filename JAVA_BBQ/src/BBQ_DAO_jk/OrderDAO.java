package BBQ_DAO_jk;

import java.util.ArrayList;

import BBQ_VO.CartVO;
import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;


public class OrderDAO extends DBConn{
public ArrayList<OrderVO> ordervo;
public ArrayList<CartVO> cartvo;
public ArrayList<OptionVO> optionvo;




/** 장바구니 주문 조회**/
	public ArrayList<CartVO> getShopBasketResult(String id) {
		cartvo = new ArrayList<CartVO>();
		
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
				vo.setAmt(rs.getInt(4));
				
				cartvo.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartvo;
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
	/** 메뉴 삭제시 DB 삭제 **/
	public boolean getcartdeleteResult(int rno) {
		boolean result =false;
		try {
			String sql = " DELETE FROM BBQ_CART  "
					+ " WHERE RNO=? ";
			
			getPreparedStatement(sql);
			pstmt.setInt(1, rno);
			
		
			while(rs.next()) {	
				int val = pstmt.executeUpdate();
				if(val == 0) result= true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
		
	/** 주문내역 결제 **/
	public ArrayList<OrderVO> getPayResult(String id) {
			ordervo = new ArrayList<OrderVO>();
		
		try {
			String sql = " SELECT ROWNUM RNO, B.ORDERID, M.NAME, M.PRICE, D.OPTIONS, B.ADDR" 
					+ " FROM BBQ_MEMBER I, BBQ_ORDER B, BBQ_ORDER_DETAIL D, MENU_DATA M "
					+ " WHERE I.ID=B.USER_ID AND B.ORDERID=D.ORDERID  AND M.MID=D.MID " 
					+ " AND I.ID = ? " ;
					
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {	
				OrderVO vo = new OrderVO();
				vo.setRno(rs.getString(1));
				vo.setOrderid(rs.getString(2));
				vo.setMenu(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				vo.setOption(rs.getString(5));
				vo.setAddr(rs.getString(6));
				
				ordervo.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordervo;
	}		
}



