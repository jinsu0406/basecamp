package gbs.dao;

import gbs.vo.Guestbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("guestbookDao")
public class CubridGuestbookDao implements GuestbookDao {
	SqlSessionFactory sqlSessionFactory;

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Guestbook> selectList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("gbs.dao.GuestbookDao.selectList");
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int insert(Guestbook guestbook) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("gbs.dao.GuestbookDao.insert", guestbook);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(Guestbook guestbook) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update("gbs.dao.GuestbookDao.update", guestbook);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}
}
