package co.yedam.app;

public class Calc {

	
	public static int add(int a, int b)  {
		return a+b;
	}
	
	public static int div(int a, int b) throws Exception{
		int c =0;
		//메서드 안에서 하는 법
//		try {c = a/b;} 
//		catch (Exception e) {
//			c = a;
//		}
		c= a/b;
		return c;
	}
}
