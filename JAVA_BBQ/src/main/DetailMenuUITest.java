package main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO.MenuVO;

// DetailMenuUI �׽�Ʈ��
public class DetailMenuUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		vo.setImage(new ImageIcon("images/test.jpg"));
		vo.setName("�Ķ��̵� ġŲ");
		vo.setDesc("�� Ƣ�� �Ķ��̵� ġŲ�Դϴ�");
		vo.setPrice(14000);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("�ݶ�");
		list.add("���̴�");
		list.add("ġŲ��");
		vo.setOptions(list);
		new DetailMenuUI(vo);
	}

}