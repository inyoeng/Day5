package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		//String str = "1 hi";
		Scanner sc =new Scanner(new FileInputStream("d:/temp/f.dat"));
		
		//int a = sc.nextInt(); //str로 부터 숫자 하나
		
		while(true) {
			try {
			String b = sc.next();//String값 가지고 옴..? (nextInt하고 나면 알아서 공백으로 잘라진다.)
			System.out.println(b); 
			}catch(Exception e) {
				break;
			}
		
		}
		
	}

}
