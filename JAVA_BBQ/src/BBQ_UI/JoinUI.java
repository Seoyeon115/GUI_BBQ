package BBQ_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BBQ_SYSTEM.BBQ_System;
import BBQ_VO.MemberVO;

public class JoinUI implements ActionListener {
	// Field
	JFrame f;
	JPanel title_panel, label_panel, tf_panel, btn_panel;
	JButton join_btn, reset_btn, id_chk_btn, join_btn2, reset_btn2;
	String[] namelist = { "아이디", "비밀번호", "비밀번호확인", "이름", "핸드폰", "주소" };
	String[] namelist2 = { "아이디", "비밀번호", "비밀번호확인", "이름", "핸드폰1", "핸드폰2", "핸드폰3", "주소1", "주소2" };
	ArrayList<Object> list = new ArrayList<Object>(); // 데이터 저장할 곳(배열)
	LoginUI log;
	BBQ_System system;
	JTextField tf_id;

	// Constructor
	public JoinUI() {
		system = new BBQ_System();
		init();

	}
	
	public JoinUI(MemberVO member) {
		init(member);
	}

	public JoinUI(LoginUI log) {
		system = new BBQ_System();
		this.log = log;
		init();
	}

	// Method
	public void init() {
		f = new JFrame("회원가입");
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

		join_btn = new JButton("회원가입");
		reset_btn = new JButton("취소하기");
		btn_panel.add(join_btn);
		btn_panel.add(reset_btn);

		for (String name : namelist) {
			JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel(name);
			l_panel.add(label);
			label_panel.add(l_panel);

			JPanel t_panel = new JPanel();

			if (name.equals("아이디")) {
				tf_id = new JTextField(12);
				id_chk_btn = new JButton("중복확인");
				t_panel.add(tf_id);
				t_panel.add(id_chk_btn);
				tf_panel.add(t_panel);
				list.add(tf_id);

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
				list.add(tf);
			} else {
				JTextField tf = new JTextField(20);
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
			}
		} // for

		f.add(BorderLayout.NORTH, title_panel);
		f.add(BorderLayout.WEST, label_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, btn_panel);

		f.setSize(400, 500);
		f.setLocation(100, 100);
		f.setVisible(true);

		join_btn.addActionListener(this);
		reset_btn.addActionListener(this);
		id_chk_btn.addActionListener(this);

	}
	
	/**회원 수정**/
	public void init(MemberVO member) {
		f = new JFrame("회원수정");
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

		title_panel.add(new JLabel("회원수정                                       "));
		title_panel.add(img_label);

		join_btn2 = new JButton("회원수정");
		reset_btn2 = new JButton("취소하기");
		btn_panel.add(join_btn2);
		btn_panel.add(reset_btn2);

		for (String name : namelist) {
			JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel(name);
			l_panel.add(label);
			label_panel.add(l_panel);

			JPanel t_panel = new JPanel();

			if (name.equals("아이디")) {
				JTextField id = new JTextField(20);
				id.setText(member.getId());
				id.setEnabled(false);
				t_panel.add(id);
				tf_panel.add(t_panel);
				list.add(id);
			}else if (name.equals("비밀번호") || name.equals("비밀번호확인")) {
				JPasswordField tf = new JPasswordField(20);
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
			} else if (name.equals("이름")) {
				JTextField tf = new JTextField(20);
				tf.setText(member.getName());
				t_panel.add(tf);
				tf_panel.add(t_panel);
				list.add(tf);
			}else if (name.equals("핸드폰")) {
				JTextField hp1 = new JTextField(6);
				hp1.setText(member.getHp1());
				JTextField hp2 = new JTextField(6);
				hp2.setText(member.getHp2());
				JTextField hp3 = new JTextField(6);
				hp3.setText(member.getHp3());
				t_panel.add(hp1);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp2);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp3);
				tf_panel.add(t_panel);
				list.add(hp1);
				list.add(hp2);
				list.add(hp3);
			} else if (name.equals("주소")) {
				JTextField addr1 = new JTextField(22);
				addr1.setText(member.getAddr1());
				t_panel.add(addr1);
				JTextField addr2 = new JTextField(22);
				addr2.setText(member.getAddr2());
				t_panel.add(addr2);
				tf_panel.add(t_panel);
				list.add(addr1);
				list.add(addr2);
			} 
		} // for
		f.add(BorderLayout.NORTH, title_panel);
		f.add(BorderLayout.WEST, label_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, btn_panel);

		f.setSize(400, 500);
		f.setLocation(100, 100);
		f.setVisible(true);

		join_btn2.addActionListener(this);
		reset_btn2.addActionListener(this);
	}

	// 윈도우 이벤트 처리
	public void windowClosing(WindowEvent e) {
		System.out.println("--- 회원가입 프로그램을 종료합니다 ---");
	}

	// 액션 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().trim();
		Object obj = e.getSource();

		if (obj == join_btn) {
			// 유효성체크
			if (form_check()) {
				ArrayList<JTextField> jlist = new ArrayList<JTextField>();
				for (Object tf : list) {
					JTextField jtf = (JTextField) tf; // tf데이터를 형변환시켜서 jtf에 넣어준다
					jlist.add(jtf);
				}

				MemberVO member = new MemberVO();
				member.setId(jlist.get(0).getText());
				member.setPass(jlist.get(1).getText());
				member.setCpass(jlist.get(2).getText());
				member.setName(jlist.get(3).getText());

				boolean result = system.join(member);

				if (result) {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입 성공"));
					for (Object obj2 : list) {
						JTextField tf = (JTextField) obj2;
						tf.setText("");
					}
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, Commons.getMsg("회원가입 실패"));
				}
			}
		} else if (obj == reset_btn) {
			for (Object obj2 : list) {
				JTextField tf = (JTextField) obj2;
				tf.setText("");
			}
		} else if (obj == id_chk_btn) {
			if(tf_id.getText().equals("")) {
	            JOptionPane.showMessageDialog(null, Commons.getMsg("아이디를 입력해주세요."));
			
			}else if(system.idcheck(tf_id.getText())) {
				JOptionPane.showMessageDialog(null, 
						Commons.getMsg("사용가능 한 아이디입니다."));
				
			}else {
				JOptionPane.showMessageDialog(null, 
						Commons.getMsg("이미 사용중인 아이디입니다.."));
			}
			// DB아이디 중복체크
			System.out.println("아이디 중복체크");

		}
	}

	/** 회원가입 폼 체크 **/

	public boolean form_check() {
		boolean result = false;

		for (int i = 0; i < namelist.length - 2; i++) {
			JTextField tf = (JTextField) list.get(i);

			if (tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, Commons.getMsg(namelist[i] + "를 입력해주세요"));
				tf.requestFocus();
				i = namelist.length - 2;
			} else if (i == namelist.length - 3) {
				result = true;
			}
		}

		return result;
	}

}
