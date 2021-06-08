package 연산자;

public class 관계연산 {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		// **첫번째 꼐산식이 false면 두 번쨰 계산식은 안함. 
		if(y++ > 10 && x++>10) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
		
		System.out.println(x); 
		//and연산이라서 뒤어꺼 계산 할 필요가 없어서 x가 늘어나지 않았다.
		System.out.println(y);
		
		
		
	}

}
