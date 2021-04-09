package main_jk;

public class OrderUI {
	//Field
	StartUI main;
	
	//Constructor
	public OrderUI() {
		init();
	}
	
	public OrderUI(StartUI main) {
		this.main = main;
		init();
	}
	
	//Method
	public void init() {
		System.out.println("주문하기");
		
	}
}
