package BBQ_DAO;

import java.util.ArrayList;

import BBQ_VO.CartVO;
import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class OrderDAO extends DBConn {
	
	public OrderDAO(){
		
	}
	
	public boolean pushOrder(String uid, OrderVO order) {
		boolean result = false;
		String orderId = "";
		
		try {
			String sql = "insert into bbq_order(orderId, user_id, request, addr, odate, state) "
					+ "values('order_'||seq_bbq_order_orderId.nextval, ?, ?, ?, sysdate, ?)";
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, order.getMessage());
			pstmt.setString(3, order.getAddr());
			pstmt.setInt(4, 0);
			
			if(pstmt.executeUpdate() != 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) orderId = getLastOrderId(uid);
		if(!orderId.equals("")) result = pushOrderDetail(orderId, order.getMenulist());
		
		return result;
	}
	
	public String getLastOrderId(String uid) {
		String orderId = "";
		
		try {
			String sql = "select orderId "
					+ " from (select orderId from bbq_order "
					+ " where user_id = ? order by orderId desc) "
					+ " where rownum = 1";
			
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderId = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderId;
	}
	
	public boolean pushOrderDetail(String orderId, ArrayList<CartVO> menulist) {
		boolean result = false;
		
		try {
			String sql = "insert into bbq_order_detail values("
					+ " ?, ?, ?, ?)";
			
			getPreparedStatement(sql);
			
			for(CartVO cart : menulist) {
				MenuVO menu = cart.getMenu();
				String ops = "";
				for(OptionVO op : cart.getOptions()) {
					if(ops.equals("")) ops = String.valueOf(op.getOid());
					else ops += "/" + op.getOid();
				}
				
				pstmt.setString(1, orderId);
				pstmt.setInt(2, menu.getMid());
				pstmt.setString(3, ops);
				pstmt.setInt(4, cart.getAmt());
				
				pstmt.executeUpdate();
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public OrderVO getLastOrder(String uid) {
		OrderVO order = new OrderVO();
		
		try {
			String sql = "select * from (select orderId, user_id, request, addr, odate, delitime, state "
					+ " from bbq_order where user_id = ? order by odate desc) "
					+ " where rownum = 1";
			getPreparedStatement(sql);
			pstmt.setString(1,  uid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
				order.setMessage(rs.getString(3));
				order.setAddr(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setDelitime(rs.getString(6));
				order.setState(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		order.setMenulist(getOrderDetail(order.getOrderId()));
		
		return order;
	}
	
	public ArrayList<OrderVO> getOrderList(String uid){
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		ArrayList<String> orderIdList = new ArrayList<String>();
		
		try {
			String sql = "select orderid, user_id, request, addr, odate, delitime, state "
					+ " from bbq_order where user_id = ? order by odate desc";
			
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				
				orderIdList.add(rs.getString(1));
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
//				order.setMenulist(getOrderDetail(rs.getInt(1)));
				order.setMessage(rs.getString(3));
				order.setAddr(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setDelitime(rs.getString(6));
				order.setState(rs.getInt(7));
				
				orderlist.add(order);
			}
			
			for(int i=0;i<orderlist.size();i++) {
				ArrayList<CartVO> menulist = getOrderDetail(orderIdList.get(i));
				orderlist.get(i).setMenulist(menulist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public ArrayList<OrderVO> getOrderList(){
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		ArrayList<String> orderIdList = new ArrayList<String>();
		
		try {
			String sql = "select orderid, user_id, request, addr, odate, delitime, state "
					+ " from bbq_order";
			
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				
				orderIdList.add(rs.getString(1));
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
//				order.setMenulist(getOrderDetail(rs.getInt(1)));
				order.setMessage(rs.getString(3));
				order.setAddr(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setDelitime(rs.getString(6));
				order.setState(rs.getInt(7));
				
				orderlist.add(order);
			}
			
			for(int i=0;i<orderlist.size();i++) {
				ArrayList<CartVO> menulist = getOrderDetail(orderIdList.get(i));
				orderlist.get(i).setMenulist(menulist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public ArrayList<OrderVO> getOrderListNow(){
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		ArrayList<String> orderIdList = new ArrayList<String>();
		
		try {
			String sql = "select orderid, user_id, request, addr, odate, delitime, state "
					+ " from bbq_order where state = 0";
			
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				
				orderIdList.add(rs.getString(1));
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
//				order.setMenulist(getOrderDetail(rs.getInt(1)));
				order.setMessage(rs.getString(3));
				order.setAddr(rs.getString(4));
				order.setDate(rs.getString(5));
				order.setDelitime(rs.getString(6));
				order.setState(rs.getInt(7));
				
				orderlist.add(order);
			}
			
			for(int i=0;i<orderlist.size();i++) {
				ArrayList<CartVO> menulist = getOrderDetail(orderIdList.get(i));
				orderlist.get(i).setMenulist(menulist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public boolean getOrderUpdateResult(OrderVO order) {
		boolean result = false;
		try {
			String sql = " UPDATE BBQ_ORDER " + 
					" SET delitime = To_Date(?,'YYYY/MM/DD HH24:MI:SS'),STATE=? " +
					" WHERE ORDERID= ? "; 
			
			getPreparedStatement(sql);
				
			pstmt.setString(1, order.getDate());
			pstmt.setInt(2, order.getState());
			pstmt.setString(3, order.getOrderId());
				
			pstmt.executeUpdate();
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	public ArrayList<OrderVO> getOrderchecklist(){
//		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
//		try {
//			String sql = " SELECT A.ORDERID, USER_ID, C.NAME, REQUEST, ADDR, ODATE, B.AMOUNT, OPTIONS, ORDERCHECK "  
//					+ " FROM BBQ_ORDER A, bbq_order_detail B, MENU_DATA C " 
//					+ "WHERE A.ORDERID = B.ORDERID AND B.MID=C.MID ";
//			
//			getPreparedStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				OrderVO order = new OrderVO();
//				
//				order.setOrderId(rs.getString(1));
//				order.setName(rs.getString(2));
//				order.setMname(rs.getString(3));
//				order.setMessage(rs.getString(4));
//				order.setAddr(rs.getString(5));
//				order.setDate(rs.getString(6));
//				order.setAmount(rs.getInt(7));
//				order.setOption(rs.getString(8));
//				order.setState(rs.getInt(9));
//				
//				orderlist.add(order);
//			}
//			
//			
//	
//
//
//
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return orderlist;
//	}
	
	public ArrayList<CartVO> getOrderDetail(String orderId){
		ArrayList<CartVO> orderDetail = new ArrayList<CartVO>();
		ArrayList<Integer> midList = new ArrayList<Integer>();
		ArrayList<String[]> oidList = new ArrayList<String[]>();
		
		try {
			String sql = "select name, price, d.mid, options, amount "
					+ " from bbq_order_detail d, menu_data m "
					+ " where orderid = ? and d.mid = m.mid ";
			
			getPreparedStatement(sql);
			pstmt.setString(1, orderId);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartVO cart = new CartVO();
				MenuVO menu = new MenuVO();
				
				menu.setName(rs.getString(1));
				menu.setPrice(rs.getInt(2));
				
				midList.add(rs.getInt(3));
				String ops = rs.getString(4);
				if(ops == null) ops = "";
				oidList.add(ops.split("/"));
				cart.setAmt(rs.getInt(5));
				
				cart.setMenu(menu);
				cart.setPrice(menu.getPrice());
				
				orderDetail.add(cart);
			}
			
			for(int i=0;i<orderDetail.size();i++) {
				int mid = midList.get(i);
				String[] options = oidList.get(i);
				orderDetail.get(i).setOptions(getOptions(mid, options));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderDetail;
	}
	
	ArrayList<OptionVO> getOptions(int mid, String[] oidlist){
		ArrayList<OptionVO> optionlist = new ArrayList<OptionVO>();
		
		try {
			String sql = "select name, price from option_data "
					+ " where mid = ? and oid = ?";
			
			for(String oid : oidlist) {
				if(oid.equals("")) continue;
//				System.out.println(oid);
				getPreparedStatement(sql);
				pstmt.setInt(1, mid);
				pstmt.setInt(2, Integer.parseInt(oid));
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					OptionVO op = new OptionVO();
					
					op.setOid(Integer.parseInt(oid));
					op.setName(rs.getString(1));
					op.setPrice(rs.getInt(2));
					
					optionlist.add(op);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return optionlist;
	}
}