package BBQ_VO;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderVO implements Serializable{
	public static int PREPARING = 0;
	public static int DELIVERING = 1;
	public static int COMPLETE = 2;
	
	int state; // �ֹ� ���� 0:�غ���, 1:�����, 2:��޿Ϸ�
	int orderId; // �ֹ� ��ȣ
	ArrayList<MenuVO> menulist; // �ֹ��� �޴� ����Ʈ
	String name; // �ֹ��� id
	String mname; // �޴� �̸�
	String date; // �ֹ� ��¥
	String addr; // ����ּ�
	String option; // ���̵�޴�
	String message; // ��û ����
	int price; // �ֹ� �ݾ�
	int amount; //�ֹ� ����
//	int dPrice; // ��޷�
//	int discount; // ���� �ݾ�
//	int payment; // �� ���� �ݾ�
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
