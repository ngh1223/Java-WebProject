package member;

import java.util.Date;

public class Member {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uPhoto;
	private Date regDate;
	
	public Member() {
		this.regDate = new Date();
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	@Override
	public String toString() {
		return "Member [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + "]";
	}
	
	public LoginInfo toLoginInfo() {
		return new LoginInfo(uId,uName,uPhoto, regDate);
	}
	
}
