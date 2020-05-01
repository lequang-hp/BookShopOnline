package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/admin/user/list_user")
	public ModelAndView userAccountList() {
		ModelAndView mav = new ModelAndView("admin/user/list");
		UserDTO model = new UserDTO();
		model.setListResult(userService.findAllUser());
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping("admin/user/list_admin")
	public ModelAndView adminAccountList() {
		ModelAndView mav = new ModelAndView("admin/user/list");
		UserDTO model = new UserDTO();
		model.setListResult(userService.findAllAdmin());
		mav.addObject("model",model);
		return mav;
	}
}
