package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	

	public static void main(String[] args) throws IOException {
		//filecreate()
		//makefolder();
		//fileinfo();
		folderlist();
	}
	
	public static void filecreate()throws IOException {
		//파일 생성
		File file = new File("d:/temp/diart.txt");
		boolean result =  file.createNewFile();//true이면 새로은 파일 만들어내고 false이면 있으니까 안만든다.
		System.out.println(result);
	}

	private static void makefolder() {
		File file = new File("d:/temp/images");
		file.mkdir(); //creating images floder 
	}

	private static void fileinfo() {
		File file = new File("d:/temp/image.jpg");
		
		System.out.println("파일크기"+file.length());
		System.out.println("파일이름"+file.getName());
	}

	private static void folderlist() {
		File file = new File("d:/temp");	
		if(file.isDirectory()) {
			File[] list =file.listFiles();
			for(File file1: list) {
				
				if(StringUtil.getExtention(file1.getName()).equals("jpg")) {
				System.out.println(file1.getName());//전체 파일 다 불러옴
				FileUtil.copy(file1.getAbsolutePath(), "d:/temp/images/"+file1.getName());
				}
			}
		}
	}
}
	
