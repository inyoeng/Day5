package co.pilates.access;

import java.util.ArrayList;

import co.pilates.model.Course;
import co.pilates.model.Pilates;
import co.pilates.model.Teacher;

public interface AccessMember {
	public Pilates logIn(String id, String pw); //로그인
	public void logout();//로그아웃하고 종료 물어보기
	
	
	//정보 업데이트
	public void update(Pilates pilates);
	public void updateAge(Pilates pilates);
	public void updatePhone(Pilates pilates);
	
	//search and show
	public ArrayList<Course> searchAll();
	public ArrayList<Course> searchLevel(String level);
	public ArrayList<Course> SearchDate(String date);
	public ArrayList<Course> searchTeacher(String teacher);
	
	//선생님 정보 검색
	public void teacherInfo(Teacher teacher);
	
	//수강신청 : course db student에 이름 추가하기.
	public void enroll(Course course);
	
	//수강신청 내역 조회
	public ArrayList<Course> history(Course course);
	
}
