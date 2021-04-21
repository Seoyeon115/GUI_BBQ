package BBQ_DAO_jk;

import java.awt.GridLayout;

import javax.swing.JPanel;

import BBQ_VO.MemberVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OrderVO;
import main_jk.ShopBasketUI;


public class OrderDAO extends DBConn{
MemberVO member;
MenuVO menu;
OrderVO order;

	/** 주문 DB 등록 처리**/
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
	
	/** 장바구니 주문 조회**/
	public JPanel getShopBasketResult() {
		ShopBasketUI shop =new ShopBasketUI();
		JPanel left_panel =new JPanel(new GridLayout(3,1));
		try {
			String sql = "SELECT, ROWNUM RNO, M_NAME, O_OPTION, M_PRICE,B_AMT " 
					+ " FROM BBQ_MEMBER I, BBQ_ORDER B, BBQ_MENU M, BBQ_OPTION O "
					+" WHERE  I.ID=B.B_USER_ID AND M_NAME = B_MENU "
					+ "AND I.ID = ? ";
			getPreparedStatement(sql);
			
			String id = member.getId();
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shop.menu_label.add(rs.getString("m_name"), null);
				shop.menu_label.add(rs.getString("o_option"), null);
				shop.menu_label.add(rs.getString("m_price"), null);
				
				left_panel.add(shop.menu_label);
				 left_panel.add(shop.option_label);
				  left_panel.add(shop.price_label);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return left_panel;
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
