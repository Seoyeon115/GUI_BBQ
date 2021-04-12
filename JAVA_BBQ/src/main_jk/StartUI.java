package main_jk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class StartUI {
	// Field
	JFrame f;
	JPanel center_panel, bottom_panel;
	JButton btn_login;
	StartUIEvent eventobj = new StartUIEvent(this);

	// login 결과
	public static boolean LOGIN_RESULT = false;

	// Constructor
	public StartUI() {
		init();
		
	}

	// Method
	public void init() {
		f = new JFrame("BBQ");
		center_panel = new JPanel();
		center_panel.setBackground(new Color(204, 0, 51));
		bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(204, 0, 51));

		ImageIcon adv_img = new ImageIcon("images/eventpage.png");
		Image img = adv_img.getImage();
		Image changeImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);
		center_panel.add(img_label);

		btn_login = new JButton("로그인");
		bottom_panel.add(btn_login);

		f.add(BorderLayout.CENTER, center_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);

		f.setSize(500, 450);

		Dimension fsize = f.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		f.setLocation(width, height);
		f.setVisible(true);

		// 윈도우 이벤트 호출-종료
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("프로그램을 종료합니다."));
				System.exit(0);

			}
		});
		btn_login.addActionListener(eventobj);

	}

}
