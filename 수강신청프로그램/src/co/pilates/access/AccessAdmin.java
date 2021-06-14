package co.pilates.access;

import java.util.ArrayList;

import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public interface AccessAdmin {
	//회원검색
	public ArrayList<Pilates> memberList();
	public void searchName(Pilates pilates);
	public ArrayList<Pilates> nameContains(Pilates pilates);
	
	//회원 등록
	public void enter(Pilates pilates);
	
	//수강권 횟수 변경
	public void updateSession(Pilates pilates);
	
	//이름으로 회원삭제
	public void delete(String name); 
	
	
	//강의 검색
	public ArrayList<Course> courseList();
	
	//강의 등록
	public void enterCourse(Course course);
	
	
	//강사 조회
	public ArrayList<Teacher> teacherList();
	public void seachTeacher(Teacher teacher);
	
	//강사 등록
	public void inputTeacher(Teacher teacher);
	
	//강사 수정
	public void editTeacher(Teacher teacher);
	//강사 삭제 
	public void deleteTeacher(String name);

}
