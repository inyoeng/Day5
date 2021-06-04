package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.friend.model.Friend;


public class FriendList implements FriendAccess{
	
	ArrayList<Friend> friends; //리스트는 인터패이스라 new키워드로 생성 불가.->arraylist로
	
	String path = "d:/temp/friend.txt";
	public void open () {
		try {
			//BufferedReader
			Scanner sc = new Scanner( new File(path));
			while(true) {
				if(! sc.hasNext()) break;
				String str = sc.next();
				String[]  arr = str.split(",");
				friends.add(new Friend(arr[0],arr[1],arr[2]));
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Friend f : friends) {
				fw.write(String.format("%s,%s,%s\n", f.getGubun(), f.getName(), f.getName()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public  FriendList (){
		friends = new ArrayList<Friend>();
		open();
	}

	@Override
	public  void insert(Friend Friend) {
		friends.add(Friend);
		save();
	}

	@Override
	public void update(Friend friend) {
		for(Friend f : friends) {
			if(f.getName().equals(f.getName())) {
				f.setTab(friend.getTab());
			}
		}
		save();
	}

	@Override
	public void delete(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) {
				friends.remove(f);
				break;
				}
		}save();
	}

	@Override
	public ArrayList<Friend> selectAll() {
		return friends;
	}

	@Override
	public Friend SelectOne(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public Friend findTab(String tab) {
		for(Friend f : friends) {
			if(f.getTab().contains(tab)) {
				return f;
			}
		}
		return null;
	}
	
	

	
	
}
