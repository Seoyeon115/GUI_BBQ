package BBQ_DVO;

import BBQ_VO1.MemberVO;

public class MemberDVO extends DBConn{
	/** 로그인 처리 **/
	public boolean getLoginResult(String id,String pass) {
		boolean result = false;
		
		try {
			String sql = " SELECT COUNT(*) FROM BBQ_MEMBER " + 
					" WHERE ID=? AND PASS=?";
			
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	/** 회원가입 처리 **/
	public boolean getJoinResult(MemberVO member) {
		boolean result = false;

		try {
			String sql = "insert into bbq_member values(?,?,?,?,?,?,sysdate)";
			getPreparedStatement(sql);

			String hp = member.getHp1() + "-" + member.getHp2() + "-" + member.getHp3();
			String addr = member.getAddr1() + " " + member.getAddr2();
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, hp);
			pstmt.setString(5, addr);

			int val = pstmt.executeUpdate();
			if (val != 0) result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}// getJoinResult
	
}