package BBQ_UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Commons {
	//Field
	
	
	
	//Constructor
	
	
	
	//Method
	
	public static Font getFont() {
		Font font = new Font("���� ���",Font.BOLD,10);   //String�� UI�� �ƴϱ� ������ setFont��� �Ұ�
		return font;
	}
	
	public static Font getFont(int size) { // ũ�⸦ �����Ͽ� ��Ʈ ����
		Font font = new Font("���� ���",Font.BOLD, size);
		return font;
	}
	
	public static Font getFont(String s,int size) { // ũ�⸦ �����Ͽ� ��Ʈ ����
		Font font = new Font("���� ���",Font.PLAIN, size);
		return font;
	}
	
	public static Font getFont(int order,int size) { // ũ�⸦ �����Ͽ� ��Ʈ ����
		Font font = new Font("����ǹ��� ����",Font.PLAIN, size);
		return font;
	}
	
	public static JButton getJButton(String name) {
		Font font = new Font("���� ���",Font.BOLD,10);   //String�� UI�� �ƴϱ� ������ setFont��� �Ұ�
		JButton button = new JButton(name);
		button.setFont(font);
		return button;
	}
	
	
	/** �޽��� ���  **/
	public static Label/*���Ÿ��*/ getMsg(String msg) { //��𼭵� ��µǾ�� ��(static ���)
		Font font = new Font("���� ���",Font.BOLD,15);   //String�� UI�� �ƴϱ� ������ setFont��� �Ұ�
		Label label = new Label(msg);
		label.setFont(font);     //������ ������ font�� �־ ���ο� ��Ʈ ���
		
		return label;
	}
	
	// ImageIcon ���ϴ� ������� ũ�� ����
	public static ImageIcon imageResize(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image resized = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		return new ImageIcon(resized);
	}
	
}
