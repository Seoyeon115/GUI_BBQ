package main_sy;

import java.util.ArrayList;

import BBQ_DAO.MemberDAO;
import BBQ_VO.MemberVO;


public class BBQ_System {
	//Field
	MemberDAO mdao = new MemberDAO();	
	
	//login ���
	public static boolean LOGIN_RESULT = false;
	
	//Constructor
	public BBQ_System() {		
		
	}
	
	
	/** �α��� **/
	public boolean loginCheck(String id, String pass) {
		return mdao.getLoginResult(id, pass);
	}

	
	/** ȸ������ **/
	public boolean join(MemberVO member) {	
		return mdao.getJoinResult(member);
	}
	/** ���� **/
//	public void close() {
//		mdao.close();
//		sdao.close();
//		System.out.println("-----------DB���� ����----------");
//	}
//	
	/** ��� **/
//	public boolean insert(ScoreVO score) {	
//		return sdao.getInsertResult(score);		
//	}
//	
	/** ��ȸ **/
//	public ArrayList<ScoreVO> getScoreList(){
//		return sdao.getSelectResult();
//		
//	}
	
	/** �˻� **/
//	public ScoreVO search(String name) {
//		return sdao.getSelectResult(name);
//	}
//	
	
	/** ���� **/
//	public int update(ScoreVO score, String name) {
//		return sdao.getUpdateResult(score, name);
//	}
//	
	
	/** ���� **/
//	public boolean delete(String name) {
//		return sdao.getDeleteResult(name);
//	}
	
	
}//class
















