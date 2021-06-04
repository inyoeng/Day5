package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtil { //바이트 바이너리 파일(1바이트씩 읽어내면 됨. cf)한글은 2 바이트씩.

	public static void copy(String src, String des) { //2. 바꿨다. 파일 복사하기!
		//파일 복사
		try {
			FileInputStream fis = new FileInputStream(src); //읽어 들이고
			FileOutputStream fos = new FileOutputStream(des); //복사함.
			byte [] b = new byte[100]; //한 번에 100바이트씩 읽어냄 
			
			while(true) {
				int cnt = fis.read(b);
				if(cnt == -1) break;
				fos.write(b);
				
			}
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
