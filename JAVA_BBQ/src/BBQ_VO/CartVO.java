package BBQ_VO;

import java.io.Serializable;
import java.util.ArrayList;

public class CartVO implements Serializable{
	MenuVO menu; // 메뉴id
	int price; // 가격(옵션 포함)
	int amt; // 수량
	ArrayList<OptionVO> options; // 옵션
	
	public CartVO() {
		
	}
	
	public CartVO(MenuVO menu, int price, ArrayList<OptionVO> options) {
		this.menu = menu;
		this.price = price;
		this.options = options;
		this.amt = 1;
	}
	
	public void add(int amt) {
		this.amt += amt;
	}
	
	public void addPrice(int price) {
		this.price += price;
	}
	
	public MenuVO getMenu() {
		return menu;
	}
	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public ArrayList<OptionVO> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<OptionVO> options) {
		this.options = options;
	}
	
}