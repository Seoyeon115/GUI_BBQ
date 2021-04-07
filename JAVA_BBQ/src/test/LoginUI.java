package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame{
	//Field
	JFrame login_f;
	JPanel title_panel, label_panel, tf_panel,btn_panel;
	JButton login_btn, join_btn;
	JTextField jtf_id;
	JPasswordField jpf_pass;
		
	//Constructor
	public LoginUI() {
		init();
	}
	
	//Method
	public void init() {
		String[] namelist= {"   ID","   PW"};
		title_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		title_panel.setBackground(new Color(204, 0, 51));
		label_panel = new JPanel(new GridLayout(3,1,10,20));
		label_panel.setBackground(new Color(204, 0, 51));
		tf_panel = new JPanel(new GridLayout(3,1,10,20));
		tf_panel.setBackground(new Color(204, 0, 51));
		btn_panel = new JPanel();
		btn_panel.setBackground(new Color(204, 0, 51));
		login_btn = new JButton("로그인");
		join_btn = new JButton("회원가입");
		btn_panel.add(login_btn);	btn_panel.add(join_btn);
		
		ImageIcon logo_img = new ImageIcon("images/BBQ LOGO.png");
		Image img = logo_img.getImage();
		Image changeImg = img.getScaledInstance(50,30, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);
		
		title_panel.add(new JLabel("로그인                "));
		title_panel.add(img_label);
		
		for(String name : namelist) {
			Panel l_panel = new Panel(new FlowLayout(FlowLayout.LEFT));
			Panel t_panel = new Panel(new FlowLayout(FlowLayout.LEFT));

			label_panel.add(l_panel.add(new Label(name)));
			
			if(name.equals("PW")) {
				jpf_pass = new JPasswordField(15);
				tf_panel.add(t_panel.add(jpf_pass));
			}else {	
				jtf_id = new JTextField(15);
				tf_panel.add(t_panel.add(jtf_id));
			}
					
		}//for
		
		add(BorderLayout.NORTH, title_panel);
		add(BorderLayout.WEST, label_panel);
		add(BorderLayout.CENTER, tf_panel);
		add(BorderLayout.SOUTH, btn_panel);
		
		
		setSize(250,230);
		setVisible(true);	
		
		
	}//init
	
	
	
}//class


