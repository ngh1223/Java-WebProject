package com.bitcamp.mm.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;

@Service("deleteService")
public class MemberDeleteService implements MemberService {

	@Autowired
	private MemberJdbcTemplateDao dao;

	public int memberDelete(int id) {
		return dao.memberDelete(id);
	}

	
	
	
	
	
	
	
	
	
	
	
}
