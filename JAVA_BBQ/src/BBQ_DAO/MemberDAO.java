package BBQ_DAO;

import java.util.ArrayList;

import BBQ_VO.MemberVO;

public class MemberDAO extends DBConn{
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
			String sql = "insert into bbq_member values(?,?,?,?,?,sysdate)";
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
	/**정보 수정**/
	public boolean getUpdateResult(MemberVO member) {
		boolean result = false;

		try {
			String sql = " UPDATE BBQ_MEMBER " + 
					" set PASS=?,NAME=?,HP=?,ADDR=? " +
					" WHERE ID=?";
			getPreparedStatement(sql);

			String hp = member.getHp1() + "-" + member.getHp2() + "-" + member.getHp3();
			String addr = member.getAddr1() + " " + member.getAddr2();
			pstmt.setString(1, member.getPass());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, hp);
			pstmt.setString(4, addr);
			pstmt.setString(5, member.getId());

			int val = pstmt.executeUpdate();
			if (val != 0) result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/** 회원 데이터 가져오기 **/
	public ArrayList<MemberVO> getmemberlist() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		//id,pass,cpass,name,hp1,hp2,hp3,addr1,addr2;	
		try {
			String sql ="SELECT ID,PASS,NAME,HP,ADDR FROM BBQ_MEMBER ORDER BY orderday";
			getPreparedStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPass(rs.getString(2));
				member.setName(rs.getString(3));
				String HP = rs.getString(4);
				String[] hpsplit = HP.split("-");
				member.setHp1(hpsplit[0]);
				member.setHp2(hpsplit[1]);
				member.setHp3(hpsplit[2]);
				String addr = rs.getString(5);
				String[] addrsplit = addr.split(" ");
				member.setAddr1(addrsplit[0]);
				member.setAddr2(addrsplit[1]);
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}