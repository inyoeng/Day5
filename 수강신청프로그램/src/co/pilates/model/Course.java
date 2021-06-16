package co.pilates.model;

public class Course {
	
	
	//강의 관리
	String course;
	String level;
	String date;
	String teacher;
	
	
	
	


	@Override
	public String toString() {
		return "Course [course=" + course + ", level=" + level + ", date=" + date + ", teacher=" + teacher
				+  "]";
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
