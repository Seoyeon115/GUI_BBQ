package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Commons;
import main.StartUI;

public class LoginUI {
	// Field
	JFrame f;
	JButton btn_login, btn_join;
	JTextField id_tf;
	JPasswordField pass_tf;
	JPanel title_panel, label_panel, tf_panel, btn_panel;
	JLabel blank_label, id_label, pass_label;
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
		f = new JFrame("login system");
		String[] namelist = { "   ID", "   PW" };
		title_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		title_panel.setBackground(new Color(204, 0, 51));
		label_panel = new JPanel(new GridLayout(3, 1, 10, 20));
		label_panel.setBackground(new Color(204, 0, 51));
		tf_panel = new JPanel(new GridLayout(3, 1, 10, 20));
		tf_panel.setBackground(new Color(204, 0, 51));
		btn_panel = new JPanel();
		btn_panel.setBackground(new Color(204, 0, 51));
		btn_login = new JButton("로그인");
		btn_join = new JButton("회원가입");
		btn_login.setFont(Commons.getFont());
		btn_join.setFont(Commons.getFont());
		btn_panel.add(btn_login);
		btn_panel.add(btn_join);

		ImageIcon logo_img = new ImageIcon("images/BBQ LOGO.png");
		Image img = logo_img.getImage();
		Image changeImg = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);

		title_panel.add(new JLabel("로그인                "));
		title_panel.add(img_label);

		for (String name : namelist) {
			Panel l_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel t_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

			label_panel.add(l_panel.add(new Label(name)));

			if (name.equals("PW")) {
				pass_tf = new JPasswordField(15);
				tf_panel.add(t_panel.add(pass_tf));
			} else {
				id_tf = new JTextField(15);
				tf_panel.add(t_panel.add(id_tf));
			}

		} // for

		f.add(BorderLayout.NORTH, title_panel);
		f.add(BorderLayout.WEST, label_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, btn_panel);

		f.setSize(250, 230);
		f.setVisible(true);

		// 윈도우 종료 이벤트
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}// init

}// class
