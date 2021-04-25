package BBQ_VO;

import java.util.Vector;

public class RequestVO {
	public static int EXIT = -1; // ���� ���� ����
	public static int GET_MENU_INFO = 1; // �޴� ���� �ҷ�����
	public static int GET_ORDERLIST = 2; // �ֹ� ���� �ҷ�����
	public static int REQUEST_ORDER = 3; // �ֹ��ϱ�
	public static int REQUEST_LOGIN = 4; // �α����ϱ�
	public static int REQUEST_JOIN = 5; // ȸ�������ϱ�
	
	int request; // ��û ����
//	int iVal; // int�� ������
//	Vector<String> sVals; // ���ڿ� ������(���� �� ����)
	Object obj; // ��ü ������
	
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
