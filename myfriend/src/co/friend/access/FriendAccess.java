package co.friend.access;
/*
 * 인터페이스 : 상수필드 +추상메서드({}바디 없는 메서드~)
 * 상수필드: public static final 이 생략되어 있다. 
 * 메서드: public abstract
 */

import java.util.ArrayList;

import co.friend.model.Friend;

//친구관리 개발시 데이터 개발 '표준'

public interface FriendAccess {
	//String model; (x) 인스턴스, 정적필드 안대!
	//final String model= "";(o) 상수 필드는 초기값과 함께 가능!
	
	// 등록
	public void insert(Friend Friend);
	
	//수정
	public void update(Friend Friend);
	
	//삭제
	public void delete(String name);
	
	//전체조회
	public ArrayList<Friend> selectAll();
	
	//단건조회
	public Friend SelectOne(String name);
	
	public Friend findTab(String tab);
	
}
