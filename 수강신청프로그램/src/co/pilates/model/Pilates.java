package co.pilates.model;

public class Pilates {
	
	//멤버돤리
	
	
	static String id;
	static String pw;
	static String name;
	static int age;
	static String phone;
	static int session;

	

	
	



	@Override
	public String toString() {
		return "Pilates [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", phone=" + phone
				+ ", session=" + session + "]";
	}
	
	
	

	public static String getId() {
		return id;
	}


	public void setId(String id) {
		Pilates.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		Pilates.pw = pw;
	}


	public static String getName() {
		return name;
	}


	public void setName(String name) {
		Pilates.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		Pilates.age = age;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		Pilates.phone = phone;
	}


	public static int getSession() {
		return session;
	}


	public void setSession(int session) {
		Pilates.session = session;
	}




	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}



}
