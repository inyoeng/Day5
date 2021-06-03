package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInput {

	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader( new FileReader("d:/temp/score.txt"));
			//모니터로 출력하기
			PrintStream out = System.out;
			String a;
			while(true) {
				a=fr.readLine();
				String [] score = a.split(" ");//스트링을 int로 해서 []에 넣어서 두개 값들 출력해서..
				score = Integer.parseInt(a);
				
				if(a == null) break;
				out.println(a);
			}
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
