package BBQ_VO;

import java.io.Serializable;

public class RequestVO implements Serializable{
	public static int EXIT = -1; // ���� ���� ����
	public static int GET_MENU_INFO = 1; // �޴� ���� �ҷ�����
	public static int GET_ORDERLIST = 2; // �ֹ� ���� �ҷ�����
	public static int REQUEST_ORDER = 3; // �ֹ��ϱ�
	public static int REQUEST_LOGIN = 4; // �α����ϱ�
	public static int REQUEST_JOIN = 5; // ȸ�������ϱ�
	public static int SEND_MESSAGE = 6; // �޽��� ������
	public static int GET_MEMBER_INFO = 7; // ȸ������ ��������
	public static int REQUEST_UPDATE = 8; // ȸ������ ��������
	public static int GET_ORDER_INFO = 9; // �ֹ����� ��������
	public static int ORDER_UPDATE = 10; // �ֹ� ���� �ϱ�
	
	int request; // ��û ����
	Object obj; // ��ü ������
	
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
