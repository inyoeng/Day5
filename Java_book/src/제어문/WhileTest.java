package 제어문;

public class WhileTest {

	public static void main(String[] args) {
		
		//1~10까지 합계 구하는 for
		
		int sum = 0;
		
		for (int i =0; i <11; i++) {
			sum +=i;
			
		}
		System.out.println(sum);
		System.out.println();
		
		
		int i = 1;
		int sum1 = 0;
		while(i<11) {
			sum1 += i;
			i++;
		}
		System.out.println(sum1);
		
		
		sum = 0;
		i =0;
		do {
			sum += i;
			i++;
		}while(i<11);
		System.out.println(sum);
		
	}

}
