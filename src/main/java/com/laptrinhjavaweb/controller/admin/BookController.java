package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.util.MessageUtils;

@Controller(value = "bookControllerOfAdmin")
public class BookController {
	@Autowired
	private IBookService bookService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtils messageUtils;
	
	@RequestMapping(value = "/admin/book/list",method = RequestMethod.GET)
	public ModelAndView bookList() {
		ModelAndView mav = new ModelAndView("admin/book/list");
		BookDTO model = new BookDTO();
		model.setListResult(bookService.findAll());
		mav.addObject("model",model);
		return mav;
	}
	
	@RequestMapping(value = "/admin/book/edit", method = RequestMethod.GET)
	public ModelAndView editBook(@RequestParam(value = "id",required = false) Long id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/book/edit");
		BookDTO model = new BookDTO();	
		if(id != null) {
			model = bookService.findById(id);
		}
		if(request.getParameter("message") != null) {
			Map<String,String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));
		}
		
		mav.addObject("categories",categoryService.findAll());	
		mav.addObject("model",model);
		return  mav;
	}
}
