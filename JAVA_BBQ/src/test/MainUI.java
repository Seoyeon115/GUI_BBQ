package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
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

import test.LoginUI;

public class MainUI implements ActionListener{
	//Field
	LoginUI login;
	
	JFrame f;
	JPanel top_panel, center_panel, bottom_panel;
	JLabel inform_label;
	JButton login_btn, order_btn;
	
	//Constructor
	public MainUI() {
		init();
	}
	public MainUI(LoginUI login) {
		this.login = login; 
		init();
	}
	
	//Method
	public void init() {
		f = new JFrame("BBQ");
		top_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top_panel.setBackground(new Color(255, 255, 255));
		center_panel = new JPanel();
		center_panel.setBackground(new Color(204, 0, 51));
		bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(204, 0, 51));
		inform_label = new JLabel("�α����� ���ּ���");
		top_panel.add(inform_label);
		
        
		ImageIcon adv_img = new ImageIcon("images/eventpage.png");
		Image img = adv_img.getImage();
		Image changeImg = img.getScaledInstance(500,300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel img_label = new JLabel(changeIcon);
		center_panel.add(img_label);
		
		login_btn = new JButton("�α���");
		order_btn = new JButton("�ֹ��ϱ�");
		bottom_panel.add(login_btn);
		bottom_panel.add(order_btn);
		

		f.add(BorderLayout.NORTH, top_panel);
		f.add(BorderLayout.CENTER, center_panel);
		f.add(BorderLayout.SOUTH, bottom_panel);
		
		f.setSize(500,450);
		
		Dimension fsize= f.getSize();
		Dimension scsize= Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height = (int)(scsize.getHeight()-fsize.getHeight())/2;
		
		f.setLocation(width,height);
		f.setVisible(true);		
	
		//������ �̺�Ʈ ȣ��-����
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, Commons.getMsg("���α׷��� �����մϴ�."));
					System.exit(0);
				
				}
		});
		login_btn.addActionListener(this);
		order_btn.addActionListener(this);
		
	}
	//�׼� �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String name =e.getActionCommand().trim();
			
			if(name.equals("�α���")) {
				new LoginUI();
			}else if(obj == order_btn) {
//				if(Login_Result = true) {
//					new OrderUI();
				JOptionPane.showMessageDialog(null, 
						Commons.getMsg("�ֹ� â"));
//			}else {
//						JOptionPane.showMessageDialog(null, 
//								Commons.getMsg("�α����� �ʿ��� ����Դϴ�."));
					}
				
			}
}