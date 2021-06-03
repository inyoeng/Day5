package 클래스;

public class Member1 {
	public String name;
	public String id;
	public String passwd;
	public int age;
	
	public Member1(String id,String name, String passwd, int age) {
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.age = age;	}
	//	basic constructor
	void Member1(){
		
	}
	// all field constructor
	public void Member1(String id,String name, String passwd, int age) {
		
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", passwd=" + passwd
				+ ", age=" + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Member1 s = ((Member1)obj);
		
		return this.id.equals(s.id) && this.name.equals(s.name);
	}
	
	
}