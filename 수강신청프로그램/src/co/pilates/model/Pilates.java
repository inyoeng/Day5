package co.pilates.model;

public class Pilates {

	// 멤버돤리

	String id;
	String pw;
	String name;
	int age;
	String phone;
	int session;

	@Override
	public String toString() {
		return "Pilates [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", session=" + session + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}


}
