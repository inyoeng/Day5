package co.micol.tv;

public class BeanFactory {

	//object :최상위 클래스
	//모든 클래스는 object의 상속을 받고 있다.
	
	public static Object getBean(String beanName) {
		if( beanName.equals("Samsung")) {
			return new SamsungTv();
		}
		else if(beanName.equals("lg")) {
			return new LgTv();
		}
		return null;
	}
}
