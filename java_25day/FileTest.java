package java_25day;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("c:\\dev\\test2.txt");
		
		if(file.exists()) {
			System.out.println("------>��������");
		}else {
			try {
			if(file.createNewFile()) {
				System.out.println("------>���� ���� �Ϸ�");
			}else {
				System.out.println("----->���� ���� ����");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(file.getAbsolutePath());
		if(file.delete())
		System.out.println("---->���ϻ����Ϸ�");
	}

}
