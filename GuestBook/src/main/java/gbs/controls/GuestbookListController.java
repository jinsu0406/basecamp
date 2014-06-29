package gbs.controls;

import gbs.bind.DataBinding;
import gbs.dao.GuestbookDao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/guestbook/list.do")
public class GuestbookListController implements Controller, DataBinding {
	GuestbookDao guestbookDao;

	@Autowired
	public GuestbookListController setGuestbookDao(GuestbookDao guestbookDao) {
		this.guestbookDao = guestbookDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("guestbooks", guestbookDao.selectList());
		return "/guestbook/GuestbookList.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "orderCond", String.class };
	}
}
