package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.service.MemberEditService;

@Controller
@RequestMapping("/member/memberEdit")
public class MemberEditController {
	
	@Autowired
	private MemberEditService editService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editForm(
			@RequestParam("memberId") int id,
			Model model
			) {
		
		MemberInfo memberInfo = editService.getEditFormData(id);
		
		model.addAttribute("editData", memberInfo);
		
		return "member/editForm";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String edit(RequestMemberEdit edit,
			HttpServletRequest request
			) {
		
		System.out.println("수정 :::::::" + edit);
		System.out.println("수정 이전 파일 : " + edit.getOldFile());
		
		int rCnt = 0;
		rCnt = editService.edit(edit, edit.getOldFile(), request);
		System.out.println(rCnt);
		
		return "redirect:/member/memberList";
		
	}
	
	
	
	
	

}
