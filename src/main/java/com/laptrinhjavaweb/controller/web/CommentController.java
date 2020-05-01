package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "commentOfWebController")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value = "/binh-luan",method = RequestMethod.POST)
	public ModelAndView showComment(@RequestParam("bookID") Long bookID,@RequestParam("cmt") String cmt) {
		String username = SecurityUtils.getPrincipal().getUsername();
		commentService.InsertComment(username, cmt, bookID);
		return new ModelAndView("redirect:/sach/chi-tiet?id=" + bookID);
	}
}
