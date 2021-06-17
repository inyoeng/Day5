package co.pilates.model;

public class Course {
	
	
	//강의 관리
	int no;
	String course;
	String level;
	String date;
	String teacher;
	
	
	
	





	@Override
	public String toString() {
		return "Course [no=" + no + ", course=" + course + ", level=" + level + ", date=" + date + ", teacher="
				+ teacher + "]";
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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
