package gbs.vo;

import java.util.Date;

public class Guestbook {
	protected int no;
	protected String email;
	protected String pwd;
	protected String content;
	protected Date createdDate;
	protected Date modifiedDate;
	
	public int getNo() {
		return no;
	}
	public Guestbook setNo(int no) {
		this.no = no;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Guestbook setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public Guestbook setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Guestbook setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;		
	}
	public Guestbook setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public Guestbook setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}

}
