package GuiTest;

import java.sql.Date;

public class ManagementDTO {
	private int seq;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String phone;
	private int sessions;
	private int age;
	private Date createDate;

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return pw;
	}

	public void setPassword(String password) {
		this.pw = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "ManagementDTO [seq=" + seq + ", id=" + id + ", password=" + pw + ", name=" + name + ", gender="
				+ gender + ", phone=" + phone + ", sessions=" + sessions + ", createDate=" + createDate + "]";
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSessions() {
		return sessions;
	}

	public void setSessions(int sessions) {
		this.sessions = sessions;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAge(String age2) {
		// TODO Auto-generated method stub
		
	}

	public void setSessions(String sessions2) {
		// TODO Auto-generated method stub
		
	}
}