package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUIEvent implements ActionListener{
	MainUI main;
	
	public MainUIEvent(MainUI main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == main.btn_login) {
			new LoginUI(main);
		}else if(obj == main.btn_order) {
//			new OrderUI(main);
		}
	}
	
	
	
	
	
	
	
}
