package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinUI implements ActionListener {
	// Field
	JFrame f;
	JPanel title_panel, label_panel, tf_panel, btn_panel;
	JButton btn_join, btn_reset, btn_id_chk;
	String[] namelist = { "아이디", "비밀번호", "비밀번호확인", "이름", "핸드폰", "주소" };
	LoginUI log;
//	StartUIEvent eventobj = new StartUIEvent(this);
	
	// Constructor
	public JoinUI() {
		init();
	}

	public JoinUI(LoginUI log) {
		this.log = log;
		init();
	}
	
	// Method
	public void init() {
		f = new JFrame("BBQ");
		title_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		title_panel.setBackground(new Color(204, 0, 51));
		label_panel = new JPanel(new GridLayout(6, 1));
		label_panel.setBackground(new Color(255, 255, 255));
		tf_panel = new JPanel(new GridLayout(6, 1));
		tf_panel.setBackground(new Color(255, 255, 255));
		btn_panel = new JPanel();
		btn_panel.setBackground(new Color(255, 255, 255));

		ImageIcon logo_img = new ImageIcon("images/BBQ LOGO.png");
		Image img = logo_img.getImage();
		Image changeImg = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);

		title_panel.add(new JLabel("회원가입                                       "));
		title_panel.add(img_label);

		btn_join = new JButton("회원가입");
		btn_reset = new JButton("취소하기");
		btn_panel.add(btn_join);
		btn_panel.add(btn_reset);

		for (String name : namelist) {
			JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel(name);
			l_panel.add(label);
			label_panel.add(l_panel);

			JPanel t_panel = new JPanel();

			if (name.equals("아이디")) {
				JTextField id = new JTextField(12);
				btn_id_chk = new JButton("중복확인");
				t_panel.add(id);
				t_panel.add(btn_id_chk);
				tf_panel.add(t_panel);

			} else if (name.equals("핸드폰")) {
				JTextField hp1 = new JTextField(6);
				JTextField hp2 = new JTextField(6);
				JTextField hp3 = new JTextField(6);
				t_panel.add(hp1);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp2);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp3);
				tf_panel.add(t_panel);
			} else if (name.equals("주소")) {
				JTextField addr1 = new JTextField(28);
				JTextField addr2 = new JTextField(28);
				t_panel.add(addr1);
				t_panel.add(addr2);
				tf_panel.add(t_panel);
			} else if (name.equals("비밀번호") || name.equals("비밀번호확인")) {
				JPasswordField tf = new JPasswordField(20);
				t_panel.add(tf);
				tf_panel.add(t_panel);
			} else {
				JTextField tf = new JTextField(20);
				t_panel.add(tf);
				tf_panel.add(t_panel);
			}
		} // for

		f.add(BorderLayout.NORTH, title_panel);
		f.add(BorderLayout.WEST, label_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, btn_panel);

		f.setSize(400, 500);
		f.setLocation(100, 100);
		f.setVisible(true);

		// 윈도우 이벤트 호출-종료
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});
		
		btn_join.addActionListener(this);
		btn_reset.addActionListener(this);
		btn_id_chk.addActionListener(this);
//		btn_join.addActionListener(eventobj);
//		btn_reset.addActionListener(eventobj);
//		btn_id_chk.addActionListener(eventobj);

	}

	// 액션 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String name = e.getActionCommand().trim();

		if (obj == btn_join) {
			// 가입정보 DB 등록
		} else if (obj == btn_reset) {
			
		} else if (obj == btn_id_chk) {
			// DB아이디 중복체크

		}
	}

}
