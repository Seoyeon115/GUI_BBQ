package BBQ_UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


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
		f.setSize(740,590);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(204,0,51));
		
		Color backcolor = new Color(255,255,255);
		
		JPanel main = new JPanel(new BorderLayout(0,-5));
		main.setBackground(backcolor);
		main.setBounds(23, 24, 678, 500);
		
		center_panel = new JPanel();
		center_panel.setBackground(backcolor);
		
		
		JPanel copy_fin = new JPanel(new BorderLayout(15,15));
		copy_fin.setBackground(backcolor);
		
//		JPanel copy_pn = new JPanel(new GridLayout(2,1,0,-10));
		JPanel copy_pn = new JPanel(new BorderLayout(0,-5));
		
		JPanel copy_p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		copy_p.setBackground(backcolor);
		JLabel copy = new JLabel("     뭘 먹어도 맛있다");
		copy.setFont(Commons.getFont(1,42));
		copy.setForeground(new Color(0,0,0));
		copy_p.add(copy);
		
		JPanel copy2_p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		copy2_p.setBackground(backcolor);
//		JLabel copy2 = new JLabel("bbq     ");
		JLabel copy2 = new JLabel("bbq");
		copy2.setFont(Commons.getFont(1,65));
		copy2.setForeground(new Color(204,0,51));
		copy2_p.add(copy2);
		
//		copy_pn.add(BorderLayout.NORTH,copy_p);
		//copy_pn.add(BorderLayout.CENTER,copy2_p);
		
		JPanel blank = new JPanel();
		blank.setBackground(backcolor);
		blank.setPreferredSize(new Dimension(100,18));
		JPanel blank1 = new JPanel();
		blank1.setBackground(backcolor);
		
//		copy_fin.add(BorderLayout.NORTH,blank);
		copy_fin.add(BorderLayout.CENTER,copy_pn);
//		copy_fin.add(BorderLayout.SOUTH,blank1);
		
		bottom_panel = new JPanel(new BorderLayout());
		bottom_panel.setBackground(backcolor);
		
		btn_login = new JButton("BBQ 시작하기");
		btn_login.setFont(Commons.getFont(1,42));
		btn_login.setPreferredSize(new Dimension(635,65));
		btn_login.setBackground(new Color(217,25,45));
		btn_login.setForeground(new Color(255,255,255));
		btn_login.setBorderPainted(false); 
		btn_login.setFocusPainted(false); 
//		btn_login.setContentAreaFilled(false);
		
		JPanel sad = new JPanel();
		
		JPanel blank2 = new JPanel();
		blank2.setBackground(backcolor);
		blank2.setPreferredSize(new Dimension(100,14));
		JPanel blank3 = new JPanel();
		blank3.setBackground(backcolor);
		blank3.setPreferredSize(new Dimension(100,10));

		sad.setBackground(backcolor);
		sad.add(btn_login);
		
		bottom_panel.add(BorderLayout.NORTH,blank2);
		bottom_panel.add(BorderLayout.CENTER,sad);
		bottom_panel.add(BorderLayout.SOUTH,blank3);

		ImageIcon adv_img = new ImageIcon("images/mocechicken.gif");
		JLabel img_label = new JLabel(adv_img);
		center_panel.add(img_label);
		
		main.add(BorderLayout.NORTH, blank);
		main.add(BorderLayout.CENTER, center_panel);
		main.add(BorderLayout.SOUTH, bottom_panel);

		f.add(main);
		




		Dimension fsize = f.getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		f.setLocation(width, height);
		f.setVisible(true);

		// 윈도우 이벤트 호출-종료
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//JOptionPane.showMessageDialog(null, Commons.getMsg("프로그램을 종료합니다."));
				System.exit(0);

			}
		});
		btn_login.addActionListener(eventobj);

	}

}