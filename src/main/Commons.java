package main;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;

public class Commons {
	//Field
	
	
	
	//Constructor
	
	
	
	//Method
	
	public static Font getFont() {
		Font font = new Font("���� ���",Font.BOLD,10);   //String�� UI�� �ƴϱ� ������ setFont��� �Ұ�
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
	
	
	
}
