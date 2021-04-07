package main;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI {
	// Field
	Frame f;
	JButton btn_login,btn_join;
	JTextField id_tf;
	JPasswordField pass_tf;
	Panel ad_panel,center_panel,label_panel,tf_panel,btn_panel;
	JLabel blank_label,id_label,pass_label;
	StartUI main;
	
	// Constructor
	public LoginUI() {
		init();
	}

	public LoginUI(StartUI main) {
		this.main = main;
		init();
	}

	// Method
	public void init() {
		f = new Frame("login system");
		ImageIcon icon = new ImageIcon("images/BBQ.png");
		JLabel img_label = new JLabel(icon);
		
//		center_panel = new Panel();
//		center_panel.setLayout(new BorderLayout());
		ad_panel = new Panel();
		label_panel = new Panel(new GridLayout(4, 1, 0, 5));
		tf_panel = new Panel(new GridLayout(4, 1, 0, 5));
		btn_panel = new Panel();
		
		btn_login = new JButton("로그인");
		btn_join = new JButton("회원가입");
		btn_login.setFont(Commons.getFont());
		btn_join.setFont(Commons.getFont());
		btn_panel.add(btn_login);  btn_panel.add(btn_join);
		
		id_label = new JLabel("아이디");
		pass_label = new JLabel("패스워드");
		id_tf = new JTextField(10);
		pass_tf = new JPasswordField(10);
		id_label.setFont(Commons.getFont());
		pass_label.setFont(Commons.getFont());
		id_tf.setFont(Commons.getFont());
		pass_tf.setFont(Commons.getFont());

		label_panel.add(id_label);
		label_panel.add(pass_label);
		tf_panel.add(id_tf);
		tf_panel.add(pass_tf);
		
//		center_panel.add(BorderLayout.WEST, label_panel);
//		center_panel.add(BorderLayout.CENTER, tf_panel);
//		f.add(BorderLayout.CENTER, center_panel);
		f.add(BorderLayout.NORTH, img_label);
		f.add(BorderLayout.WEST, label_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, btn_panel);

		f.setSize(450, 500);
		f.setLocation(100, 100);
		f.setVisible(true);

		// 윈도우 종료 이벤트
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}// init
}
