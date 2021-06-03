package 클래스;


public class MemberEqualTest {

	public static void main(String[] args) {
		Member1 m1 = new Member1("im","jiy","111",23);
		Member1 m2 = new Member1("im","jiy","113",24);
		System.out.println(m1 == m2);
		System.out.println();
		
		//memeber의 equals메서그 오버라이딩 :id와 name 비교.
		//System.out.println(m1.equals(m2));
	}

}
