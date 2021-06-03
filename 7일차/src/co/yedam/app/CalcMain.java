package co.yedam.app;

public class CalcMain {

	public static void main(String[] args) {
		int a= 20;
		int b =0;
		int c = Calc.add(a, b);
		System.out.println(c);
		
		int d = 0;
		try {
			d = Calc.div(a, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(d);
	}

}
