package BBQ_VO;

import java.util.ArrayList;

public class OrderVO {
	public static int PREPARING = 0;
	public static int DELIVERING = 1;
	public static int COMPLETE = 2;
	
	int state; // �ֹ� ���� 0:�غ���, 1:�����, 2:��޿Ϸ�
	ArrayList<MenuVO> menulist; // �ֹ��� �޴� ����Ʈ
	String rno; // �׸� ��ȣ
	String orderid; // �ֹ� ��ȣ
	String menu; // �ֹ� �޴�
	String date; // �ֹ� ��¥
	String message; // ��û ����
	String addr; // ����ּ�
	String option; // �ɼ�
	int price; // �ֹ� �ݾ�
	int amt; // �ֹ� ����
	int dPrice; // ��޷�
	int discount; // ���� �ݾ�
	int payment; // �� ���� �ݾ�
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getdPrice() {
		return dPrice;
	}
	public void setdPrice(int dPrice) {
		this.dPrice = dPrice;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
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
	public int getDPrice() {
		return dPrice;
	}
	public void setDPrice(int dPrice) {
		this.dPrice = dPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	
}
