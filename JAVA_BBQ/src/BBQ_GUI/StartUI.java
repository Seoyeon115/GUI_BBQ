package BBQ_GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartUI {
	// Field
	JFrame f;
	JPanel center_panel, bottom_panel;
	JButton btn_login;
	StartUIEvent eventobj = new StartUIEvent(this);

	// login ���
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

		btn_login = new JButton("�α���");
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

		// ������ �̺�Ʈ ȣ��-����
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("���α׷��� �����մϴ�."));
				System.exit(0);

			}
		});
		btn_login.addActionListener(eventobj);

	}

}