package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BookDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IBookService;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private IBookService bookService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		BookDTO model = new BookDTO();	
		model.setListResult(bookService.findAll());
		mav.addObject("model",model);
		mav.addObject("categories",categoryService.findAll());
		return mav;
	}
	
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("/web/login");
		return mav;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public String registerPage(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new UserEntity());
		}
		return "web/register";
	}
	
	
	@RequestMapping(value = "/dang-ky",method = RequestMethod.POST)
	public ModelAndView doPostAddUser(@ModelAttribute("user") @Validated UserEntity userEntity, BindingResult result) {
		ModelAndView mav = new ModelAndView("/web/register");
		if (result.hasErrors()) {
			for (ObjectError objectError: result.getAllErrors()) {
				System.out.println(objectError);
				System.out.println(objectError.getCode());
			}
			return mav;
		}
		
		else {
			String username = userEntity.getUserName();
			String password = userEntity.getPassword();
			String address = userEntity.getAddress();
			String phone = userEntity.getPhone();
			String email = userEntity.getEmail();
			String hash = passwordEncoder.encode(password);
			if(userService.InsertAccountUser(username,hash,email,address,phone)) {
				mav.addObject("message","Đăng ký thành công");
				mav.addObject("alert","success");
			}
			else {
				mav.addObject("message","Đăng ký thất bại");
				mav.addObject("alert","danger");
			}
			return mav;
		}
	}
	
	
	@RequestMapping(value = "/thoat",method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Neu da dang nhap
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth); // trong logout se khoi tao session va remove key
		}
		return  new ModelAndView("web/login");
	}
	
	
	@RequestMapping(value = "/accessDenied",method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return  new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
