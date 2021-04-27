package BBQ_VO;

import java.io.Serializable;

public class RequestVO implements Serializable{
	public static int EXIT = -1; // 서버 접속 종료
	public static int GET_MENU_INFO = 1; // 메뉴 정보 불러오기
	public static int GET_ORDERLIST = 2; // 주문 내역 불러오기
	public static int REQUEST_ORDER = 3; // 주문하기
	public static int REQUEST_LOGIN = 4; // 로그인하기
	public static int REQUEST_JOIN = 5; // 회원가입하기
	public static int SEND_MESSAGE = 6; // 메시지 보내기
	public static int GET_MEMBER_INFO = 7; // 회원정보 가져오기
	public static int REQUEST_UPDATE = 8; // 회원정보 가져오기
	public static int GET_ORDER_INFO = 9; // 주문정보 가져오기
	public static int ORDER_UPDATE = 10; // 주문 접수 하기
	
	int request; // 요청 정보
	Object obj; // 객체 데이터
	
	public RequestVO() {
		
	}
	public RequestVO(int request) {
		this.request = request;
	}
	
	public RequestVO(int request, Object obj) {
		this.request = request;
		this.obj = obj;
	}
	
	public int getRequest() {
		return request;
	}
	public void setRequest(int request) {
		this.request = request;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
