package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView doGetRegister() {
		ModelAndView mav = new ModelAndView("admin/register");
		UserEntity userEntity = new UserEntity();
		mav.addObject("user", userEntity);
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doPostRegister(@ModelAttribute("user") UserEntity userEntity) {
		String username = userEntity.getUserName();
		String password = userEntity.getPassword();
		String address = userEntity.getAddress();
		String phone = userEntity.getPhone();
		String email = userEntity.getEmail();
		String hash = passwordEncoder.encode(password);
		if (userService.InsertAccountAdmin(username, hash, email, address, phone)) {
			return new ModelAndView("redirect: admin/user/list");
		} else {
			return new ModelAndView("redirect: admin/home");
		}
	}
}
