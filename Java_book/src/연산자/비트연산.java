package 연산자;

public class 비트연산 {

	
	// ^ : xor -서로 다르면 1
	// | :or - 암호화에서 주로 쓰임
	// & :and - 마스크 씌움,
	
	public static void main(String[] args) {
		//암호화 , 복호화 할 때 
		//8진수로~
		int a = 04474;
		int key = 01111;
		System.out.println("원본"+a);
		
		int b = a ^key;
		System.out.println("암호화"+b);
		
		
		int c = b^key;
		System.out.println("복호화"+c);
		
		
		//맨 끝 자리가 0인지 1인지 -> &연산
		int d = 0b10101110;
		int e = 0b00000001;
		
		System.out.println(Integer.toBinaryString(d&e));
		
		
		//쉬프트 연산
		int f = 8; //1000 (2진수)
		System.out.println(f >>1); //0100 == %2한거랑 같지만 속도가 빠름!
		System.out.println(f<<1);  //10000 ==*2
		System.out.println(f >>2); //나누기 2 두 번 -> %4
	}

}
