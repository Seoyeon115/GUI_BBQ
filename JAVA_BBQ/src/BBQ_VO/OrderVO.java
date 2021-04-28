package BBQ_VO;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderVO implements Serializable{
	public static int PREPARING = 0;
	public static int DELIVERING = 1;
	public static int COMPLETE = 2;
	
	int state; // 주문 상태 0:준비중, 1:배달중, 2:배달완료
	int orderId; // 주문 번호
	ArrayList<MenuVO> menulist; // 주문한 메뉴 리스트
	String name; // 주문자 id
	String mname; // 메뉴 이름
	String date; // 주문 날짜
	String addr; // 배달주소
	String option; // 사이드메뉴
	String message; // 요청 사항
	int price; // 주문 금액
	int amount; //주문 수량
//	int dPrice; // 배달료
//	int discount; // 할인 금액
//	int payment; // 총 결제 금액
	
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
