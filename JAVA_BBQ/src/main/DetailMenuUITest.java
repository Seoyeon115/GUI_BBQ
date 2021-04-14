package main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO1.MenuVO;
import BBQ_VO1.OptionVO;

// DetailMenuUI 테스트용
public class DetailMenuUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		vo.setImage(new ImageIcon("images/BBQ.png"));
		vo.setName("후라이드 치킨");
		vo.setDesc("갓 튀긴 후라이드 치킨입니다");
		vo.setPrice(14000);
		
		ArrayList<OptionVO> list = new ArrayList<OptionVO>();
		list.add(new OptionVO("콜라", 2000));
		list.add(new OptionVO("사이다", 2000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("치킨무", 1000));
		vo.setOptions(list);
		new DetailMenuUI(vo);
	}

}