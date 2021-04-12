package main_sy;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;

public class Commons {
	//Field
	
	
	
	//Constructor
	
	
	
	//Method
	
	public static Font getFont() {
		Font font = new Font("맑은 고딕",Font.BOLD,10);   //String은 UI가 아니기 때문에 setFont출력 불가
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
	
	
	
}
