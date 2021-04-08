package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import BBQ_VO.MenuVO;

// �� �޴�â �̿ϼ�
public class DetailMenuUI implements ActionListener{
	JFrame frame; // â
	ArrayList<JCheckBox> check_options = new ArrayList<JCheckBox>(); // �ɼ� ���� ��ư
	JButton button_onCart; // ��� ��ư
	JButton button_back; // �ڷΰ��� ��ư
	
	MenuVO vo; // �޴� ����
	
	// ������, �޴� ������ �Ű������� �޴´�
	DetailMenuUI(MenuVO vo) {
		this.vo = vo;
		init();
	}
	
	void init() { // UI �ʱ�ȭ
		frame = new JFrame();
		frame.setBackground(new Color(204, 0, 51));
		frame.setResizable(false);
		
		// ���� �г�
		JPanel panel_content = new JPanel();
//		panel_content.setBackground(new Color(0, 0, 0));
		panel_content.setLayout(new BoxLayout(panel_content, BoxLayout.Y_AXIS));
//		panel_content.setBorder(new LineBorder(Color.red));
		
		// �� �� �г�
		JPanel panel_upper = new JPanel(new BorderLayout());
		panel_upper.setBackground(new Color(255, 255, 255));
		button_back = new JButton("�ڷΰ���");
		button_back.setBackground(new Color(255, 255, 255));
		panel_upper.add(BorderLayout.WEST,
				new JPanel(new GridLayout(1, 1)).add(button_back));
		JPanel panel_title = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label_title = new JLabel("�޴� �� ����");
		panel_title.add(label_title);
		panel_upper.add(BorderLayout.CENTER, panel_title);
		frame.add(BorderLayout.NORTH, panel_upper);
		
		// �̹��� �г�
		JPanel panel_image = new JPanel();
		JLabel label_image = new JLabel(imageResize(vo.getImage()));
		label_image.setBorder(new LineBorder(Color.red));
		panel_image.add(label_image);
		panel_content.add(panel_image);
		
		// �޴���&���� �г�
		JPanel panel_nameNprice = new JPanel();
		JLabel label_name = new JLabel(vo.getName());
		label_name.setFont(Commons.getFont());
		panel_nameNprice.add(BorderLayout.WEST, label_name);
		panel_content.add(panel_nameNprice);
		
		JLabel label_price = new JLabel(String.valueOf(vo.getPrice()+"��"));
		label_price.setFont(Commons.getFont());
		panel_nameNprice.add(BorderLayout.EAST, label_price);
		
		// �޴� ���� �г�
		JPanel panel_desc = new JPanel();
		JLabel label_desc = new JLabel(vo.getDesc());
		label_desc.setFont(Commons.getFont());
		panel_desc.add(label_desc);
		panel_content.add(panel_desc);
		
		// �ɼ� �г�
		int option_size = vo.getOptions().size();
		JPanel panel_options = new JPanel(new GridLayout(option_size, 3));
//		panel_options.setBackground(new Color(0,0,0));
		panel_options.setBorder(new LineBorder(Color.red, 1, true));
		for(String str : vo.getOptions()) {
			JPanel panel_option = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JCheckBox check_option = new JCheckBox(str);
			check_option.setFont(Commons.getFont());
			
			panel_option.add(check_option);
			check_options.add(check_option);
			panel_options.add(panel_option);
			
			check_option.addActionListener(this);
		}
		panel_content.add(panel_options);
		
		// ��� ��ư
		JPanel panel_onCart = new JPanel(new GridLayout(1, 1));
		button_onCart = new JButton("��ٱ��� ���");
		button_onCart.setFont(Commons.getFont());
		button_onCart.addActionListener(this);
		panel_onCart.add(button_onCart);
		panel_content.add(BorderLayout.SOUTH, panel_onCart);
		
		// ��ũ�� �߰�
		JScrollPane content = new JScrollPane(panel_content); // ȸ�鿡 ��ũ�� �߰�
		frame.add(content);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	ImageIcon imageResize(ImageIcon icon) { // �̹��� ũ�� ����
		Image image = icon.getImage();
		image = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		return new ImageIcon(image);
	}
	
	
	boolean isInOption(Object obj) { // �ɼ� �޴� �������� Ȯ��
		for(JCheckBox check : check_options) {
			if(obj == check) {
				return true;	
			}
		}
		return false;
	}
	
	// �̺�Ʈ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == button_onCart) { // ��� ��ư Ŭ��
			System.out.println("��ٱ��� ���");
		}else if(obj == button_back) { // �ڷΰ��� ��ư Ŭ��
			//
		}else if(isInOption(obj)) {
			JCheckBox check = (JCheckBox) obj;
			System.out.println(check.getText());
		}
	}
}
