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
		Font font = new Font("맑은 고딕",Font.BOLD,10);   //String은 UI가 아니기 때문에 setFont출력 불가
		return font;
	}
	
	public static Font getFont(int size) { // 크기를 지정하여 폰트 생성
		Font font = new Font("맑은 고딕",Font.BOLD, size);
		return font;
	}
	
	public static Font getFont(String s,int size) { // 크기를 지정하여 폰트 생성
		Font font = new Font("맑은 고딕",Font.PLAIN, size);
		return font;
	}
	
	public static Font getFont(int order,int size) { // 크기를 지정하여 폰트 생성
		Font font = new Font("배달의민족 연성",Font.PLAIN, size);
		return font;
	}
	
	public static JButton getJButton(String name) {
		Font font = new Font("맑은 고딕",Font.BOLD,10);   //String은 UI가 아니기 때문에 setFont출력 불가
		JButton button = new JButton(name);
		button.setFont(font);
		return button;
	}
	
	
	/** 메시지 출력  **/
	public static Label/*출력타입*/ getMsg(String msg) { //어디서든 출력되어야 함(static 사용)
		Font font = new Font("맑은 고딕",Font.BOLD,15);   //String은 UI가 아니기 때문에 setFont출력 불가
		Label label = new Label(msg);
		label.setFont(font);     //위에서 정의한 font를 넣어서 새로운 폰트 출력
		
		return label;
	}
	
	// ImageIcon 원하는 사이즈로 크기 조절
	public static ImageIcon imageResize(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image resized = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		return new ImageIcon(resized);
	}
	
}
