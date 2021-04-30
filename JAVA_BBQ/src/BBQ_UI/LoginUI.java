package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BBQ_Manage.ManagerUI;
import BBQ_SYSTEM.BBQ_System;

public class LoginUI implements ActionListener {
	// Field
	JFrame f;
	JButton btn_login, btn_join;
	JTextField id_tf;
	JPasswordField pass_tf;
	JPanel title_panel, label_panel, tf_panel, btn_panel;
	JLabel blank_label, id_label, pass_label;
	StartUI main;
	BBQ_System system = new BBQ_System();

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
		f.getContentPane().setBackground(new Color(204, 0, 51));
		f.setBounds(100, 90, 450, 550);
		f.getContentPane().setLayout(null);
		f.setLocation(700, 200);;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel main = new JPanel(new BorderLayout());
		main.setBackground(new Color(255, 255, 255));
		main.setBounds(22, 21, 390, 468);
		main.setFocusable(true);
		
		ImageIcon logoIcon = new ImageIcon("images/bi_bbq.jpg");
		JLabel logo = new JLabel(logoIcon);

		JPanel logo_pn = new JPanel();
		logo_pn.setBackground(new Color(255, 255, 255));
		logo_pn.add(logo);

		JPanel login = new JPanel(new BorderLayout());

//		title_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		title_panel.setBackground(new Color(255, 255, 255));
		label_panel = new JPanel(new GridLayout(2, 1, 10, 20));
		label_panel.setBackground(new Color(255, 255, 255));
		btn_login = new JButton("로그인");
		btn_login.setFont(Commons.getFont(20));
		btn_login.setPreferredSize(new Dimension(100,83));
		btn_login.setBackground(new Color(227,25,55));
		btn_login.setForeground(new Color(255,255,255));
		btn_join = new JButton("회원가입");
		btn_join.setBorderPainted(false); 
		btn_join.setFocusPainted(false); 
		btn_join.setContentAreaFilled(false);
		btn_join.setFont(Commons.getFont(12));
		btn_join.setForeground(new Color(204, 0, 51, 170));
		
		
		JPanel blank3 = new JPanel();
		blank3.setBackground(new Color(255, 255, 255));
		btn_panel = new JPanel(new BorderLayout(3,1));
		btn_panel.setBackground(new Color(255, 255, 255));
		JPanel btn_join_pn = new JPanel();
		btn_join_pn.setBackground(new Color(255, 255, 255));
		btn_join_pn.add(btn_join);
		btn_panel.add(BorderLayout.CENTER,btn_join_pn);
		btn_panel.add(BorderLayout.SOUTH,blank3);

		
		JPanel logwholeup = new JPanel(new BorderLayout());
		logwholeup.setBackground(new Color(255, 255, 255));
		JPanel logwhole = new JPanel(new BorderLayout(5,5));
		logwhole.setBackground(new Color(255, 255, 255));
		JPanel btn_login_pn = new JPanel(new BorderLayout());
		btn_login_pn.setBackground(new Color(255, 255, 255));

		tf_panel = new JPanel(new GridLayout(2, 1, 10, 5));
		tf_panel.setBackground(new Color(255, 255, 255));
		
		id_tf = new JTextField(10);
		id_tf.setText("ID");
		id_tf.setForeground(new Color(0,0,0,100));
		id_tf.setFont(Commons.getFont(17));
		id_tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	id_tf.setText("");
            	id_tf.setForeground(new Color(0,0,0));
            	id_tf.setFont(Commons.getFont("s",17));
            }
        });
		
		pass_tf = new JPasswordField(10);
		pass_tf.setText("12345");
		pass_tf.setForeground(new Color(0,0,0,100));
		pass_tf.setFont(Commons.getFont("s",17));
		pass_tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	pass_tf.setText("");
            	pass_tf.setForeground(new Color(0,0,0));
            }
        });
		
		JPanel blank = new JPanel();
		blank.setBackground(new Color(255, 255, 255));
		JPanel blank1 = new JPanel();
		blank1.setBackground(new Color(255, 255, 255));
		JPanel blank2 = new JPanel();
		blank2.setBackground(new Color(255, 255, 255));
		
		JPanel btn_login_pn_pn = new JPanel(new BorderLayout());
		JPanel blank10 = new JPanel();
		blank10.setBackground(new Color(255,255,255));
		
		
		btn_login_pn.add(BorderLayout.NORTH,blank);
		btn_login_pn.add(BorderLayout.CENTER,btn_login);
		
		btn_login_pn_pn.add(BorderLayout.NORTH,blank10);
		btn_login_pn_pn.add(BorderLayout.CENTER,btn_login_pn);
		
		tf_panel.add(id_tf);
		tf_panel.add(pass_tf);
		
		logwhole.add(BorderLayout.NORTH,blank);
		logwhole.add(BorderLayout.CENTER,tf_panel);
		logwhole.add(BorderLayout.SOUTH,btn_login_pn_pn);
		
		logwholeup.add(BorderLayout.NORTH,blank1);
		logwholeup.add(BorderLayout.CENTER,logwhole);
		logwholeup.add(BorderLayout.SOUTH,blank2);
		
		JPanel blank12 = new JPanel();
		blank12.setBackground(new Color(255,255,255));
		login.add(BorderLayout.NORTH, blank12);
		login.add(BorderLayout.CENTER, logwholeup);
		login.add(BorderLayout.SOUTH, btn_panel);
		
		main.add(BorderLayout.NORTH, logo_pn);
		main.add(BorderLayout.CENTER, login);

		f.add(main);
		f.setVisible(true);

		btn_login.addActionListener(this);
		btn_join.addActionListener(this);

	}// init

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_login) {
			// 로그인
			login_proc();
		} else if (obj == btn_join) {
			// 회원가입 창
			new JoinUI();
		}
	}

	public void login_proc() {
		// 유효성 체크
		if (id_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("아이디를 입력해주세요"));
			id_tf.requestFocus();
		} else if (pass_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("패스워드를 입력해주세요"));
			pass_tf.requestFocus();
		}  else if(id_tf.getText().equals("manager") && pass_tf.getText().equals("123")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg("관리자 로그인 성공"));
			new ManagerUI(system.getConnection()); } else{
			// 로그인 체크 :system.loginCheck(아이디, 패스워드);
			boolean result = system.loginCheck(id_tf.getText(), pass_tf.getText());
			if (result) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("로그인 성공"));
				f.setVisible(false);
				new InnerMain(system, id_tf.getText());
				StartUI.LOGIN_RESULT = true;
			} else {
				JOptionPane.showMessageDialog(null, Commons.getMsg("로그인 실패"));

			}

		}
	}

}// class