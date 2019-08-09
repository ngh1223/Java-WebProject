package com.guestbook.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.service.DeleteMessageSrvice;
import com.guestbook.service.InvalidMessagePasswordException;
import com.guestbook.service.MessageNotFoundException;

@Controller
@RequestMapping("/guest/delete")
public class GuestDeleteController {
	
	@Autowired
	private DeleteMessageSrvice deleteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm() {
		return "guest/deleteForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String delete(
			@RequestParam("messageId") int messageId,
			@RequestParam("password") String password,
			Model model
			) {
		
		boolean chk = false;
		int resultCnt = 0;
		String msg = "";
		
		try {
			resultCnt=deleteService.deleteMessage(messageId, password);
			chk=true;
		} catch (SQLException e) {
			msg = e.getMessage();
			e.printStackTrace();
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidMessagePasswordException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		model.addAttribute("chk",chk);
		model.addAttribute("resultCnt", resultCnt);
		model.addAttribute("msg", msg);
		
		return "guest/delete";
	}
	
}
