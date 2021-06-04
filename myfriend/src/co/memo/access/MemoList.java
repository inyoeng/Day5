package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo;

public class MemoList implements MemoAccess{
	
	ArrayList<Memo> mm;
	
	String path = "d:/temp/memo.txt";
	
	public void open () {
		try {
			//BufferedReader
			Scanner sc = new Scanner( new File(path));
			while(true) {
				if(! sc.hasNext()) break;
				String str = sc.next();
				String[]  arr = str.split(",");
				mm.add(new Memo(arr[0],arr[1]));
			}
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Memo m : mm) {
				fw.write(String.format("%s,%s\n",m.getContent(),m.getDate()));
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemoList() {
		mm = new ArrayList<Memo>();
		open();
	}
	
	@Override
	public void insert(Memo memo) {
		mm.add(memo);
		save();
		
	}

	@Override
	public void update(Memo memo) {
		for (Memo m : mm) {
			if(m.getDate().equals(memo.getDate())) {
				m.setDate(memo.getDate());
			}
		}save();
	}

	
	@Override
	public void delete(String date) {
		for (Memo m : mm) {
			if(m.getDate().equals(date)) {
				mm.remove(m);
				break;
			}
		}save();
	}

	@Override
	public ArrayList<Memo> selectAll() {
		return mm;
	}

	@Override
	public Memo SelectOne(String content) {
		for(Memo m : mm) {
			if(m.getContent().contains(content)) {
				return m;
			}
		}
		
		return null;
	}

	@Override
	public Memo dateSearch(String date) {
		for(Memo m : mm) {
			if(m.getDate().contains(date)) {
				return m;
			}
		}
		return null;
	}

}
