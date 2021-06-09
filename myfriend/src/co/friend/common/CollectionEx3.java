package co.friend.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import co.friend.model.Friend;

public class CollectionEx3 {
	public static void main(String[] args) {
		Map<String, Friend> map = new HashMap<>();
		map.put("반장", new Friend("1반", "홍길동", "111-1111"));
		map.put("평범", new Friend("1반", "홍평범", "222-2222"));
		map.put("선생님", new Friend("1반", "홍두깨", "333-3333"));
		map.put("반장", new Friend("1반", "박길동", "112-1212"));

		System.out.println(map.get("선생님"));

		// 둘 중 하나만 하면 됨
		
		//1. key값 다 가져와서 실행. 중복x
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Friend val = map.get(key);
			System.out.println("key: " + key + ",  val:" + val.toString());
			System.out.println("==================");

			// friend : key, integer :value map에 담기
			Map<Friend, Integer> scores = new HashMap<>();
			scores.put(new Friend("1반", "홍길동", "111-1111"), 80);
			scores.put(new Friend("1반", "정인영", "222-1111"), 90);
			scores.put(new Friend("1반", "김효진", "333-1111"), 89);
			scores.put(new Friend("1반", "윤지민", "444-1111"), 91);
			scores.put(new Friend("1반", "홍길동", "111-1111"), 85);

			//2. entry 타입 가져오ㅏ서 리턴
			Set<Entry<Friend, Integer>> ent = scores.entrySet();
			Iterator<Entry<Friend, Integer>> eiter = ent.iterator();
			while (eiter.hasNext()) {
				Entry<Friend, Integer> e = eiter.next();
				System.out.println(e.getKey() + "," + e.toString());
			}
		}
		
	}
}
