package co.pilates.model;

public class Course {
	
	
	//강의 관리
	String course;
	String level;
	String date;
	String teacher;
	String students;
	
	
	


	@Override
	public String toString() {
		return "Course [course=" + course + ", level=" + level + ", date=" + date + ", teacher=" + teacher
				+ ", students=" + students + "]";
	}


	public String getStudents() {
		return students;
	}


	public void setStudents(String students) {
		this.students = students;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	

}
