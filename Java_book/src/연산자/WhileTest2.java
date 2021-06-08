package 연산자;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		
		int a = 0;
		
		Scanner sc = new Scanner(System.in);
		
		
		do {
			a = sc.nextInt();
			System.out.println(a);
		}
		while(a != 0);
		
		System.out.println("end");
	}

}
