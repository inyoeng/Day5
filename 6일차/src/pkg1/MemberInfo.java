package pkg1;

public class MemberInfo {
	
	//싱글톤
	
	static MemberInfo memberinfo = new MemberInfo(); //new는 딱 한번하고 스테틱에 넣어둠. 
	static MemberInfo getInstance() {
		return memberinfo;
	}
	private MemberInfo() {}

	String [] names = new String[10];
	
	void print() {
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("");
	}
}
