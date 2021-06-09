package co.friend.model;

public class Friend {

	protected String gubun;
	protected String name;
	protected String tel;

	public Friend() {
	}

	public Friend(String gubun, String name, String tel) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return this.getGubun().hashCode()+this.getName().hashCode()+this.getTel().hashCode();
	}//동일한 문자열 해시코드 값 같다. 

	@Override
	public boolean equals(Object obj) {
		Friend f = (Friend) obj;//obj는 어느 형태로든 변환 가능. 
		
		return this.getGubun().equals(f.getGubun()) && this.getName().equals(f.getName()) 
				&& this.getTel().equals(f.getTel());
	}//세개가 같으면 논리적으로 같다고 만들어줌. 뻬거나 더헤서 논리 바꿀 수 있다. 

	@Override
	public String toString() {
		return "Friend [gubun=" + gubun + ", name=" + name + ", tel=" + tel + "]";
	}

	public void print() {
		System.out.printf("친구: %20s %20s %20s\n", gubun, name, tel);
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
