package 클래스;

public class StringEqual {
	public static void main(String[] args) {
		String s1 ="hello";  //상수 저장 공간 따로 있음.(new가 아니면 상수)
		String s2 = "hello";
		
		String s3 = new String("hello");
		String s4 = new String("hello"); //힙
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		
		
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));
		
		//String 추가 수정 삭제시 StringBuffer써라
		//String buffer ->toString으로 바꾼 후 비교해야 함. 
		StringBuffer sb = new StringBuffer("Hello World!");
		sb.insert(5, "!!!");
		System.out.println(sb.toString());// toString 생략가능
		sb.replace(0, 5, "hi");
		System.out.println(sb);
		
	}
}
