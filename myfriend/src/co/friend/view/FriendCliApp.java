package co.friend.view;

import java.util.ArrayList;

import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {
	FriendList fl = new FriendList();

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
	            case 5: findName(); break;
	            case 6: findTab(); break;
	            
	         }
	      }while (menuNum !=0);
	}

	public void menuTitle() {
		System.out.println("===친구관리=");
		System.out.println("=1. 친구 추가=");
		System.out.println("=2. 친구수정=");
		System.out.println("=3. 친구삭제=");
		System.out.println("=4. 전체조회=");
		System.out.println("=5. 이름으로조회=");
		System.out.println("=6. 전화번호 검색=");
		System.out.println("=0.종료=");
	}

	public void insert() {
		Friend fr = ScannerUtil.readFriend();
		fl.insert(fr);
	}

	public void update() {
		Friend fr = new Friend();
		fr.setName(ScannerUtil.readStr());
		fr.setTab(ScannerUtil.readStr());
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
		ArrayList<Friend> list = fl.selectAll();
		for (Friend friend : list) {
			System.out.println(friend);
		}
	}
	
	public void findTab() {
		String tab = ScannerUtil.readStr();
		Friend friend = fl.findTab(tab);
		System.out.println(friend);
		}
	}

