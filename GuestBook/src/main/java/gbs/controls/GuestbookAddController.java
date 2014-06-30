package gbs.controls;

import gbs.bind.DataBinding;
import gbs.dao.GuestbookDao;
import gbs.vo.Guestbook;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (isValidEmail(guestbook.getEmail()) == false) {
			return "/guestbook/list.do";
		} else {
			guestbookDao.insert(guestbook);
			return "redirect:list.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "guestbook", gbs.vo.Guestbook.class };
	}

	private boolean isValidEmail(String email) {
		boolean err = false;
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			err = true;
		}
		return err;
	}

}
