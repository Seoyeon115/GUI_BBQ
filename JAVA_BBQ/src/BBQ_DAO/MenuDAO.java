package BBQ_DAO;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;

public class MenuDAO extends DBConn{
	
	
	public MenuVO getMenu(int id) {
		MenuVO menu = new MenuVO();
		ArrayList<OptionVO> options = new ArrayList<OptionVO>();
		menu.setOptions(options);
		
		try {
			String sql_menu = "select name, description, price, image "
					+ " from menu_data where mid = ?";
			String sql_option = "select oid, name, price from option_data "
					+ " where mid = ?";
			
			getPreparedStatement(sql_menu);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu.setMid(id);
				menu.setName(rs.getString(1));
				menu.setDesc(rs.getString(2));
				menu.setPrice(rs.getInt(3));
				menu.setImage(new ImageIcon("images/"+ rs.getString(4)));
			}
			
			// 따로 OptionDAO로 빼야 할까?
			getPreparedStatement(sql_option);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OptionVO op = new OptionVO();
				
				op.setOid(rs.getInt(1));
				op.setName(rs.getString(2));
				op.setPrice(rs.getInt(3));
				
				options.add(op);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menu;
	}
}
