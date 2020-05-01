package com.laptrinhjavaweb.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.util.MessageUtils;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	@Autowired
	private MessageUtils messageUtils;
	
	
	@RequestMapping(value = "/gio-hang",method = RequestMethod.GET)
	public ModelAndView doGetShowCart(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/cart");
		String username = SecurityUtils.getPrincipal().getUsername();
		CartDTO model = new CartDTO();
		model.setListResult(cartService.findByUserId(username));
		
		if(request.getParameter("message") != null) {
			Map<String,String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message",message.get("message"));
			mav.addObject("alert",message.get("alert"));
		}
		
		mav.addObject("model",model);
		mav.addObject("total",cartService.totalPriceByUserId(username));
		return mav;
	}
}
