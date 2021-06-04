package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	public void insert(Memo memo);
	public void update(Memo memo);
	public void delete(String date);
	
	//전체조회
	public ArrayList<Memo> selectAll();
	
	//선택조회
	public Memo SelectOne(String content);
	public Memo dateSearch(String date);
	
	
}
