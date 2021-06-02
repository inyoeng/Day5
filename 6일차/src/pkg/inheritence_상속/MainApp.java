package pkg.inheritence_상속;

public class MainApp {

	public static void main(String[] args) {
		
		a a= new d(); //자동형변환
		int temp = ((d)a).sd; //강제 형변환(348P) : a를 d로 캐스팅해서 접근 가능
		
		a o = new a();
		temp = ((d)o).sd; //실행오류 =runtime error o 안에 d가 없음. 그러나 이클립스는 d가 안에 있다고 생각해서 잡아내지는 못해따
		
//		a = new b();
//		a = new d();
//		
//		 b= new d();
//		
//		X x = new d(); //모두 d의 부모니까 누가 와도 ㄱㅊ
		
		
		System.out.println(a instanceof a);
		System.out.println(a instanceof b);
		System.out.println(a instanceof d); 
		System.out.println(a instanceof X); 
		b b= new b();
		b= new d();
		//b = new c(); 안됨!ㅋㅋ
		
		
	}

}
