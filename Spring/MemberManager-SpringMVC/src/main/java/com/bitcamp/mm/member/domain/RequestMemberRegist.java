package com.bitcamp.mm.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class RequestMemberRegist {

	private String uId;
	private String uPW;
	private String uName;
	private MultipartFile uPhoto;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPW() {
		return uPW;
	}

	public void setuPW(String uPW) {
		this.uPW = uPW;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public MultipartFile getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(MultipartFile uPhoto) {
		this.uPhoto = uPhoto;
	}

	@Override
	public String toString() {
		return "RequestMemberRegist [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhoto=" + uPhoto.getOriginalFilename() + "]";
	}
	
	public MemberInfo toMemberInfo() {
		
		MemberInfo info = new MemberInfo();
		info.setuId(uId);
		info.setuName(uName);
		info.setuPW(uPW);
		
		return info;
		
	}
	
	
	
	
	
	
	
	
	
	

}
