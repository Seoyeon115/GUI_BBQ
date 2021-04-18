package main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO.MenuVO;
import BBQ_VO.OptionVO;
import BBQ_VO.OrderVO;

// DetailMenuUI 테스트용
public class DetailMenuUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		vo.setImage(new ImageIcon("images/friedchicken.png"));
		vo.setName("후라이드 치킨");
		vo.setDesc("갓 튀긴 후라이드 치킨입니다");
		vo.setPrice(14000);
		
		ArrayList<OptionVO> list = new ArrayList<OptionVO>();
		list.add(new OptionVO("콜라", 2000));
		list.add(new OptionVO("사이다", 2000));
		list.add(new OptionVO("치킨무", 1000));
		list.add(new OptionVO("옵션4", 1000));
		list.add(new OptionVO("옵션5", 1000));
		list.add(new OptionVO("옵션6", 1000));
		list.add(new OptionVO("옵션7", 1000));
		list.add(new OptionVO("옵션8", 1000));
		vo.setOptions(list);
		
		OrderVO order = new OrderVO();
		order.setDate("2021년 04월 15일 18시 51분");
		order.setMessage("맛있게 튀겨주세요~");
		order.setAddr("서울특별시 강남구 ~~");
		order.setPrice(24000);
		ArrayList<MenuVO> menus = new ArrayList<MenuVO>();
		menus.add(vo);
//		menus.add(new MenuVO());
		order.setMenulist(menus);
		
//		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
//		for(int i=0;i>10;i++) {
//			OrderVO q = new OrderVO();
//			
//		}
		
//		new DetailMenuUI(vo);
//		new OrderDetailUI(order);
//		new OrderListUI(new ArrayList<OrderVO>());
	}

}