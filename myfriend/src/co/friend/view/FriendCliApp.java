package co.friend.view;

import java.util.ArrayList;
import java.util.List;

import co.friend.access.FriendAccess;
import co.friend.access.FriendDAO;
import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {
	//FriendList fl = new FriendList();
	FriendAccess fl = new FriendDAO();
	
	public void start() {
		int menuNum;
		do {
	         //print menu
	         menuTitle();
	         //select menu
	         menuNum = ScannerUtil.readInt();
	         switch(menuNum) {
	            case 1: insert(); break;
	            case 2: update(); break;
	            case 3: delete(); break;
	            case 4: selectAll(); break;
	            case 5: SelectOne(); break;
	            case 6: findTel(); break;
	            
	         }
	      }while (menuNum !=0);
	}

	private void SelectOne() {
		String name = ScannerUtil.readStr();
		Friend friend = fl.SelectOne(name);
		System.out.println(friend);
	}

	public void menuTitle() {
		System.out.println("===친구관리===");
		System.out.println("=1. 친구 추가=");
		System.out.println("=2. 친구수정=");
		System.out.println("=3. 친구삭제=");
		System.out.println("=4. 전체조회=");
		System.out.println("=5. 이름조회=");
		System.out.println("=6. 번호검색=");
		System.out.println("===0.종료===");
	}

	public void insert() {
		Friend fr = ScannerUtil.readFriend();
		fl.insert(fr);
	}

	public void update() {
		Friend fr = new Friend();
		System.out.println("바꿀 사람의 이름을 입력하세요");
		fr.setName(ScannerUtil.readStr());
		System.out.println("바꿀 전화번호를 입력하세요!");
		fr.setTel(ScannerUtil.readStr());
		fl.update(fr);
	}

	private void delete() {
		String name = ScannerUtil.readStr();
		fl.delete(name);

	}

	public void findName() {
		String name = ScannerUtil.readStr();
		Friend friend = fl.SelectOne(name);
		System.out.println(friend);
	}

	public void selectAll() {
		List<Friend> list = fl.selectAll();
		for (Friend friend : list) {
			System.out.println(friend);
		}
	}
	
	public void findTel() {
		String tel = ScannerUtil.readStr();
		Friend friend = fl.findTel(tel);
		System.out.println(friend);
		}
	}

