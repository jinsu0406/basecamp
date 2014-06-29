package gbs.dao;

import gbs.vo.Guestbook;

import java.util.List;

public interface GuestbookDao {
	public List<Guestbook> selectList() throws Exception;
	public int insert(Guestbook guestbook) throws Exception;
	public int update(Guestbook guestbook) throws Exception;
}
