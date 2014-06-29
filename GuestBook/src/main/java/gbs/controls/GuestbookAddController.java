package gbs.controls;

import gbs.bind.DataBinding;
import gbs.dao.GuestbookDao;
import gbs.vo.Guestbook;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/guestbook/add.do")
public class GuestbookAddController implements Controller, DataBinding {
	GuestbookDao guestbookDao;

	@Autowired
	public GuestbookAddController setGuestbookDao(GuestbookDao guestbookDao) {
		this.guestbookDao = guestbookDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Guestbook guestbook = (Guestbook) model.get("guestbook");
		System.out.println(guestbook.getEmail());
		if (guestbook.getEmail() == null) { // 입력폼을 요청할 때
			return "/guestbook/list.do";
		} else { // 회원 등록을 요청할 때
			guestbookDao.insert(guestbook);
			return "redirect:list.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "guestbook", gbs.vo.Guestbook.class };
	}
}
