package com.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guestbook.domain.MessageListView;
import com.guestbook.service.GetMessageListService;

@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService listService;
	
	@RequestMapping("/guest/list")
	public String getList(@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model) {
		
		MessageListView listview = listService.getMessageListView(pageNumber);
		model.addAttribute("viewData",listview);
		
		return "guest/list";
	}
	
}
