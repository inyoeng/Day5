package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileSaveTest {

	public static void main(String[] args) {
		//파일리더
		//한 줄씩 읽어 내겠다. 할때 Buffered...한 줄 통째로 기억해
		try {
		BufferedReader isr=  new BufferedReader(new InputStreamReader(System.in));
		//여러 줄을 읽고싶다? 파일에 저장.
		BufferedWriter br = new BufferedWriter(new FileWriter("d:/temp/f.dat1.txt"));
		
		while(true) {
		String c = isr.readLine();
		if(c ==null) break; //여러문장 한 번에 읽을 수 있다. 
		br.write(c);
		br.write("\n");
		}
		br.close();
		//화면에 출력
		//System.out.println(c);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
