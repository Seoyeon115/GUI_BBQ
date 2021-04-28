package BBQ_VO;

import java.util.ArrayList;

public class CartVO {
	MenuVO menu; // �޴�id
	int price; // ����(�ɼ� ����)
	int amt; // ����
	ArrayList<OptionVO> options; // �ɼ�
	
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