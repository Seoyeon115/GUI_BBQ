package BBQ_VO;

// 메뉴 옵션 vo
public class OptionVO {
	String option;
	int price;
	
	public OptionVO(String option, int price) {
		setOption(option);
		setPrice(price);
	}
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
