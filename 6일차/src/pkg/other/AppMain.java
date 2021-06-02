package pkg.other;

import pkg1.Car; 
import pkg1.Count;
import pkg1.DateUtil;
import pkg1.ProjectInfo;  //or pkg1.* 하면 전체 다 불러와짐!

public class AppMain {

	public static void main(String[] args) {
		
		Car car =  new Car(); // Car()는 생성자. Car에서 기본생성자 이용
		car.setModel("Hundai");
		car.setSpeed(100);
		
		Car car2 = new Car("Kia",100); //매개변수 두 개 짜리 생성자
		
		Car car3 = new Car("Hundai");
		
		System.out.println(DateUtil.curDate());
		System.out.println(ProjectInfo.name);
		

		Count count1 = new Count();
		Count.cnt1++;
		count1.setCnt2(count1.getCnt2() +1);
		
		
	}

}
