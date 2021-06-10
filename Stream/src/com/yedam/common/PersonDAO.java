package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {

	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 1. 조회 2.입력 3. 수정 4. 삭제 5. 전체리스트 (각각기능 분리) => 메소드로 기능 분리

	// 전체 리스트
	public  ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // null값 담긴 객체 생성

		connect(); // 연결객체 사용, 객체 연결 꼭!! 해줘야 함.

		String sql = "select * from Person";
		try {
			// 요 두 개는 공식이라고 생각하자!
			psmt = conn.prepareStatement(sql); // PreparedStatment 쿼리 실행. 결과 받아 옴.
			rs = psmt.executeQuery(); // 쿼리 실행결과 가져오는 부분.
			while (rs.next()) {
				// System.out.println(rs.getInt("id")+","+rs.getString("name"));
				Person person = new Person(); // db에서 가져온 컬럼을 person필드에 담으려고 함.
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;

	}

	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close() { // connect한 후에는 꼭 close 해 줘야 함.
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
