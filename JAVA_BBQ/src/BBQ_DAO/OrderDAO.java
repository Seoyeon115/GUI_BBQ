package BBQ_DAO;

import java.util.ArrayList;

import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

public class OrderDAO extends DBConn {
	
	public OrderDAO(){
		
	}
	
	public ArrayList<OrderVO> getOrderList(String uid){
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
		ArrayList<Integer> orderIdList = new ArrayList<Integer>();
		
		try {
			String sql = "select orderid, request, addr, odate "
					+ "from bbq_order where user_id = ?";
			
			getPreparedStatement(sql);
			pstmt.setString(1, uid);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderVO order = new OrderVO();
				
				orderIdList.add(rs.getInt(1));
				
//				order.setMenulist(getOrderDetail(rs.getInt(1)));
				order.setMessage(rs.getString(2));
				order.setAddr(rs.getString(3));
				order.setDate(rs.getString(4));
				
				orderlist.add(order);
			}
			
			for(int i=0;i<orderlist.size();i++) {
				ArrayList<MenuVO> menulist = getOrderDetail(orderIdList.get(i));
				orderlist.get(i).setMenulist(menulist);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public ArrayList<MenuVO> getOrderDetail(int orderId){
		ArrayList<MenuVO> orderDetail = new ArrayList<MenuVO>();
		ArrayList<Integer> midList = new ArrayList<Integer>();
		ArrayList<String[]> oidList = new ArrayList<String[]>();
		
		try {
			String sql = "select name, price, d.mid, options "
					+ " from bbq_order_detail d, menu_data m "
					+ " where orderid = ? and d.mid = m.mid ";
			
			getPreparedStatement(sql);
			pstmt.setInt(1, orderId);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO menu = new MenuVO();
				
				menu.setName(rs.getString(1));
				menu.setPrice(rs.getInt(2));
				
				midList.add(rs.getInt(3));
				oidList.add(rs.getString(4).split("/"));
				
				orderDetail.add(menu);
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
