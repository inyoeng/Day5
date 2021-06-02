package pkg1;

public class AppMain {

	static void print() {
		System.out.println("===========");
	}
	
	public static void main(String[] args) {
		
		Count count1 = new Count();
		Count.cnt1++;
		count1.setCnt2(count1.getCnt2() +1);
		
		Count count2 = new Count();
		Count.cnt1++;
		count2.setCnt2(count1.getCnt2() +1);
		
		Count count3 = new Count();
		Count.cnt1++;
		count3.setCnt2(count1.getCnt2() +1);
		
		System.out.println(count1.cnt1+" : "+count1.cnt2);
		System.out.println(count2.cnt1+" : "+count2.cnt2);
		System.out.println(count3.cnt1+" : "+count3.cnt2);
		
		//ProjectInfo info = new ProjectInfo();
		//static이면 굳이 새로 생성 안해도 클래스 이름으로 접근 간으.
		
		System.out.println(ProjectInfo.name);
		
		
		ProjectInfo info = new ProjectInfo();
		System.out.println(info.version);
		AppMain.print();
		}

}
