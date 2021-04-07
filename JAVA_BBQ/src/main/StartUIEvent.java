package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUIEvent implements ActionListener{
	StartUI main;
	
	public StartUIEvent(StartUI main) {
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
