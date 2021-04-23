package BBQ_UI;

public class OrderUI {
	//Field
	InnerMain main;
	
	//Constructor
	public OrderUI() {
		init();
	}
	public OrderUI(InnerMain main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		System.out.println("주문하기");
	}
}
