package java_25day;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("c:\\dev\\test2.txt");
		
		if(file.exists()) {
			System.out.println("------>파일있음");
		}else {
			try {
			if(file.createNewFile()) {
				System.out.println("------>파일 생성 완료");
			}else {
				System.out.println("----->파일 생성 실패");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(file.getAbsolutePath());
		if(file.delete())
		System.out.println("---->파일삭제완료");
	}

}
