package co.friend.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import co.friend.model.Friend;
import co.friend.util.DAO;
import co.memo.access.ScannerUtil;

//friendAccess,->구현: friendList도 여기 있고
//

public class FriendDAO extends DAO implements FriendAccess {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	// name, tel 값을 담아주는 컬렉션.
	public Map<String, String> getNameTel() {
		Map<String, String> map = new HashMap<>();
		String sql = "select name, tel from freind";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getString("name"), rs.getString("tel"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public void insert(Friend Friend) {
		String sql = "insert into freind values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Friend.getGubun());
			psmt.setString(2, Friend.getName());
			psmt.setString(3, Friend.getTel());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Friend Friend) {
		// 동명이인 없다는 전제!
		String sql = "update freind set tel=? where name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Friend.getTel());
			psmt.setString(2, Friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String name) {
		String sql = "delete from freind where name =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement("select * from freind");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Friend friend = new Friend();
				friend.setGubun(rs.getString("Gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("Tel"));
				fList.add(friend);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fList;
	}

	@Override
	public Friend SelectOne(String name) {
		Friend friend = null;
		String sql = "select * from freind where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			if (rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("Gubun"));
				friend.setName(rs.getString("Name"));
				friend.setTel(rs.getString("Tel"));

			} else {
				System.out.println("없는 이름입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return friend;
	}

	@Override
	public Friend findTel(String tel) {
		Friend friend = new Friend();
		String sql = "select * from freind where tel =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tel);
			rs = psmt.executeQuery();
			if (rs.next()) {
				friend.setGubun(rs.getString("Gubun"));
				friend.setName(rs.getString("Name"));
				friend.setTel(rs.getString("Tel"));
			}

			else {
				System.out.println("없는 번호입니다. ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return friend;
	}


	

}
