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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class JoinUI implements ActionListener {
	// Field
	JFrame f;
	JPanel title_panel, label_panel, tf_panel, btn_panel;
	JButton join_btn, reset_btn, id_chk_btn;
	String[] namelist = { "���̵�", "��й�ȣ", "��й�ȣȮ��", "�̸�", "�ڵ���", "�ּ�" };
	ArrayList<Object> list =new ArrayList<Object>();
	LoginUI log;
	
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

		title_panel.add(new JLabel("ȸ������                                       "));
		title_panel.add(img_label);

		join_btn = new JButton("ȸ������");
		reset_btn = new JButton("����ϱ�");
		btn_panel.add(join_btn);
		btn_panel.add(reset_btn);

		for (String name : namelist) {
			JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel(name);
			l_panel.add(label);
			label_panel.add(l_panel);

			JPanel t_panel = new JPanel();

			if (name.equals("���̵�")) {
				JTextField id = new JTextField(12);
				id_chk_btn = new JButton("�ߺ�Ȯ��");
				t_panel.add(id);
				t_panel.add(id_chk_btn);
				tf_panel.add(t_panel);
				list.add(id);

			} else if (name.equals("�ڵ���")) {
				JTextField hp1 = new JTextField(6);
				JTextField hp2 = new JTextField(6);
				JTextField hp3 = new JTextField(6);
				t_panel.add(hp1);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp2);
				t_panel.add(new JLabel("-"));
				t_panel.add(hp3);
				tf_panel.add(t_panel);
			} else if (name.equals("�ּ�")) {
				JTextField addr1 = new JTextField(28);
				JTextField addr2 = new JTextField(28);
				t_panel.add(addr1);
				t_panel.add(addr2);
				tf_panel.add(t_panel);
			} else if (name.equals("��й�ȣ") || name.equals("��й�ȣȮ��")) {
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

		// ������ �̺�Ʈ ȣ��-����
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});
		join_btn.addActionListener(this);
		reset_btn.addActionListener(this);
		id_chk_btn.addActionListener(this);

	}

	// �׼� �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String name = e.getActionCommand().trim();
		
		
		if (obj == join_btn) {
			form_check();
			// �������� DB ���
			
		} else if (obj == reset_btn) {
			
			for(Object obj2 : list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");}

		} else if (obj == id_chk_btn) {
			// DB���̵� �ߺ�üũ
			System.out.println("���̵� �ߺ�üũ");

		}
	}
	


/**ȸ������ �� üũ**/

	public boolean form_check() {
	boolean result = false;
	
	for(int i=0;i<namelist.length-2;i++) {
		JTextField tf = (JTextField)list.get(i);
		
		if(tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, Commons.getMsg(namelist[i]+"�� �Է����ּ���"));
			tf.requestFocus();
			i=namelist.length-2;
		}else if(i== namelist.length-3){
			result= true;
		}
}
	
	return result;
}

}
