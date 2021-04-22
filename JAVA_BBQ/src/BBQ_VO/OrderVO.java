package BBQ_VO;

import java.util.ArrayList;

public class OrderVO {
	public static int PREPARING = 0;
	public static int DELIVERING = 1;
	public static int COMPLETE = 2;
	
	int state; // �ֹ� ���� 0:�غ���, 1:�����, 2:��޿Ϸ�
	int orderId;
	ArrayList<MenuVO> menulist; // �ֹ��� �޴� ����Ʈ
	String date; // �ֹ� ��¥
	String message; // ��û ����
	String addr; // ����ּ�
	int price; // �ֹ� �ݾ�
//	int dPrice; // ��޷�
//	int discount; // ���� �ݾ�
//	int payment; // �� ���� �ݾ�
	
	public ArrayList<MenuVO> getMenulist() {
		return menulist;
	}
	public void setMenulist(ArrayList<MenuVO> menulist) {
		this.menulist = menulist;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//	public int getDPrice() {
//		return dPrice;
//	}
//	public void setDPrice(int dPrice) {
//		this.dPrice = dPrice;
//	}
//	public int getDiscount() {
//		return discount;
//	}
//	public void setDiscount(int discount) {
//		this.discount = discount;
//	}
//	public int getPayment() {
//		return payment;
//	}
//	public void setPayment(int payment) {
//		this.payment = payment;
//	}
	
	
}
