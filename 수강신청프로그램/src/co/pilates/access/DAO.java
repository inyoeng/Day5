package co.pilates.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
public Connection conn;//connectuion 필드 추가
	
	protected  DAO(){//dao 생성자 추가
		String url = "jdbc:sqlite:C:/sqlite/db/pilates.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
