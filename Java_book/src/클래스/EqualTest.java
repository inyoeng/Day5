package 클래스;

public class EqualTest {

	public static void main(String[] args) {
		
		Robot r1 = new Robot(2,4);
		Robot r2 =new Robot(2,4);
		Robot r3 =r1;
		
		//472p
		System.out.println(r1 == r2); //주소 비교함. 
		System.out.println(r1 == r3); //r3는 객체가 없이 주소가 같아서true
		System.out.println(r1.equals(r2)); //이건 다르다고 나옴. -> robot클래스 가서 오버라이딩ㅡ 캐스팅하면 같다. 
		//System.out.println(r1.toString());
		System.out.println(r1);
		
		String a =new String("hello");
		String b =new String("hello");
		System.out.println(a == b ); //이거도 주소비교!
		System.out.println( a.equals(b)); //String 내의 내용 비교라 같다고 나옴!
		
	}

}
