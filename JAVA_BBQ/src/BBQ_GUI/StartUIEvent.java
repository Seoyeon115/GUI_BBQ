package BBQ_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUIEvent implements ActionListener{
	StartUI main;
	LoginUI log;
	
	public StartUIEvent(StartUI main) {
		this.main = main;
	}
	
	public StartUIEvent(LoginUI log) {
		this.log = log;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == main.btn_login) {
			new LoginUI(main);
		}else if(obj == log.btn_login) {
			new JoinUI(log);
		}else if(obj == log.btn_join) {
			new JoinUI(log);
			
		}
	}
	
	
	
	
	
	
	
}
