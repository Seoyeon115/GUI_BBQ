package BBQ_VO;

import java.util.Vector;

public class RequestVO {
	public static int EXIT = -1; // 서버 접속 종료
	public static int GET_MENU_INFO = 1; // 메뉴 정보 불러오기
	public static int GET_ORDERLIST = 2; // 주문 내역 불러오기
	public static int REQUEST_ORDER = 3; // 주문하기
	public static int REQUEST_LOGIN = 4; // 로그인하기
	public static int REQUEST_JOIN = 5; // 회원가입하기
	
	int request; // 요청 정보
//	int iVal; // int형 데이터
//	Vector<String> sVals; // 문자열 데이터(여러 개 가능)
	Object obj; // 객체 데이터
	
	public RequestVO() {
		
	}
	
	public RequestVO(int request, Object obj) {
		this.request = request;
		this.obj = obj;
	}
	
//	public RequestVO(int request, int iVal) {
//		this.request = request;
//		this.iVal = iVal;
//	}
//	
//	public RequestVO(int request, String sVal) {
//		this.request = request;
//		sVals = new Vector<String>();
//		this.sVals.add(sVal);
//	}
//	
//	public RequestVO(int request, String[] slist) {
//		this.request = request;
//		this.sVals = new Vector<String>();
//		for(String s : slist) {
//			this.sVals.add(s);
//		}
//	}
	
	public int getRequest() {
		return request;
	}
	public void setRequest(int request) {
		this.request = request;
	}
//	public int getiVal() {
//		return iVal;
//	}
//	public void setiVal(int iVal) {
//		this.iVal = iVal;
//	}
//	public Vector<String> getsVal() {
//		return sVals;
//	}
//	public void setsVal(Vector<String> sVals) {
//		this.sVals = sVals;
//	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
