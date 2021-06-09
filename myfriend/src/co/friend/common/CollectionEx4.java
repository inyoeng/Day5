package co.friend.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import co.friend.access.FriendDAO;
import co.friend.model.Friend;

public class CollectionEx4 {
	public static void main(String[] args) {
		// 이름, 연락처를 출력하세요!
		FriendDAO dao = new FriendDAO();
		Map<String, String> map = dao.getNameTel();
		Set<Entry<String, String>> ent = map.entrySet();
		Iterator<Entry<String, String>> iter = ent.iterator();
		
		while (iter.hasNext()) {
			Entry<String, String> s = iter.next();
			System.out.println(s.getKey() + "," + s.getValue());
		}

	}
}
