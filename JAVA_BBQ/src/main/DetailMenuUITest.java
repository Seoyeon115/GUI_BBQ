package main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO.MenuVO;

// DetailMenuUI 테스트용
public class DetailMenuUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		vo.setImage(new ImageIcon("images/test.jpg"));
		vo.setName("후라이드 치킨");
		vo.setDesc("갓 튀긴 후라이드 치킨입니다");
		vo.setPrice(14000);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("콜라");
		list.add("사이다");
		list.add("치킨무");
		vo.setOptions(list);
		new DetailMenuUI(vo);
	}

}