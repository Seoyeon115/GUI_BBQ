package main;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import BBQ_VO1.MenuVO;
import BBQ_VO1.OptionVO;

// DetailMenuUI �׽�Ʈ��
public class DetailMenuUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuVO vo = new MenuVO();
		vo.setImage(new ImageIcon("images/BBQ.png"));
		vo.setName("�Ķ��̵� ġŲ");
		vo.setDesc("�� Ƣ�� �Ķ��̵� ġŲ�Դϴ�");
		vo.setPrice(14000);
		
		ArrayList<OptionVO> list = new ArrayList<OptionVO>();
		list.add(new OptionVO("�ݶ�", 2000));
		list.add(new OptionVO("���̴�", 2000));
		list.add(new OptionVO("ġŲ��", 1000));
		list.add(new OptionVO("ġŲ��", 1000));
		list.add(new OptionVO("ġŲ��", 1000));
		list.add(new OptionVO("ġŲ��", 1000));
		list.add(new OptionVO("ġŲ��", 1000));
		list.add(new OptionVO("ġŲ��", 1000));
		vo.setOptions(list);
		new DetailMenuUI(vo);
	}

}