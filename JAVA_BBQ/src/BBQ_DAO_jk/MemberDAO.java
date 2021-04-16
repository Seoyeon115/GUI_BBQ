package BBQ_DAO_jk;

import BBQ_VO.MemberVO;


public class MemberDAO extends DBConn{
	
	
	/** 로그인 처리 **/
	public boolean getLoginResult (String id, String pass) {
		boolean result = false;
		try {
			String sql ="SELECT COUNT(*) FROM SCORE_MEMBER "
					+ "WHERE ID =? AND PASS =?"; //DB 테이블생성전이라 임의로지정
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) ==1) result = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/** 회원가입 처리  **/
	public boolean getJoinResult(MemberVO member) {
		boolean result = false;
				
		try {
			String sql = "insert into score_member values(?,?,?,?,?,?,sysdate)";
			getPreparedStatement(sql);
			
			String hp = member.getHp1()+"-"+member.getHp2()+"-"+member.getHp3();
			String addr = member.getAddr1()+" " + member.getAddr2();
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getCpass());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, hp);
			pstmt.setString(6, addr);
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	

	
}












