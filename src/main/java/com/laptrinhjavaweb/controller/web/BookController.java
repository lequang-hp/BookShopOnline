package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.ICommentService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "bookControllerOfWeb")
public class BookController {
	@Autowired
	private IBookService bookService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private ICartService cartService;

	@RequestMapping(value = "/sach/the-loai",method = RequestMethod.GET)
	public ModelAndView searchByCategory(@RequestParam("categoryID") Long categoryID) {
		ModelAndView mav = new ModelAndView("/web/home");
		BookDTO model = new BookDTO();
		model.setListResult(bookService.findByCategoryId(categoryID));
		mav.addObject("model",model);
		mav.addObject("categories",categoryService.findAll());
		return mav;
	}
	
	// tim kiem theo title
	@RequestMapping(value = "sach/tim-kiem", method = RequestMethod.POST)
	public ModelAndView searchByBookName(@RequestParam("searchValue") String searchValue) {
		ModelAndView mav = new ModelAndView("web/home");
		BookDTO model = new BookDTO();
		model.setListResult(bookService.findByTitle(searchValue));
		mav.addObject("model",model);
		mav.addObject("categories",categoryService.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/sach/chi-tiet",method = RequestMethod.GET)
	public ModelAndView showBook(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("/web/book");
		BookDTO model = new BookDTO();
		if(id != null) {
			model = bookService.findById(id);
		}
		
		mav.addObject("comments",commentService.findByBookId(id));
		mav.addObject("categories",categoryService.findAll());
		mav.addObject("model",model);
		return mav;
	}
	
	
	//Them san pham vao cart
	@RequestMapping(value = "/sach/chi-tiet", method = RequestMethod.POST)
	public ModelAndView addCart(@RequestParam("bookID") Long bookID,@RequestParam("count") int count) {
		ModelAndView mav = new ModelAndView("web/home");
		String username = SecurityUtils.getPrincipal().getUsername();
		if(cartService.InsertCart(username, bookID, count)) {
			return new ModelAndView("redirect:/trang-chu");
		} 
		return mav;
	}
}
