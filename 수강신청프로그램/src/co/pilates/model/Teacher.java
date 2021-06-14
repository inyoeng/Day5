package co.pilates.model;

public class Teacher {
	String name;
	int age;
	String experience;
	String speciality;
	String phone;
	
	@Override
	public String toString() {
		return "teacher [name=" + name + ", age=" + age + ", experience=" + experience + ", speciality=" + speciality
				+ ", phone=" + phone + "]";
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
