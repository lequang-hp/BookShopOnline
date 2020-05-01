package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CartDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBillService;
import com.laptrinhjavaweb.service.ICartService;
import com.laptrinhjavaweb.service.IHistoryService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "orderControllerOfWeb")
public class OrderController {
	@Autowired
	private IUserService userService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IBillService billService;
	@Autowired
	private IHistoryService historyService;
	
	
	@RequestMapping(value = "/dat-hang",method = RequestMethod.GET)
	public ModelAndView doGetOrder(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/order");
		String username = SecurityUtils.getPrincipal().getUsername();
		UserDTO myUser  = userService.findUserByUserName(username); 
		mav.addObject("myUser",myUser);
		return mav;
	}
	
	// Chuyen den trang in thong tin hoa don
	@RequestMapping(value = "/dat-hang",method = RequestMethod.POST)
	public ModelAndView doPostOrder(@RequestParam("deliveryAddress") String deliveryAddress,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/bill");
		
		String username = SecurityUtils.getPrincipal().getUsername();	
		float total = cartService.totalPriceByUserId(username);
		
		billService.InsertBill(username, total, deliveryAddress);
		/*Lay thong id bill vua ms insert*/
		long billId = billService.findBillIdLatest();
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setListResult(cartService.findByUserId(username));
		mav.addObject("cartDTO",cartDTO); // Lay ra danh sach cac mat hang
		
		UserDTO myUser  = userService.findUserByUserName(username); 
		mav.addObject("myUser",myUser); // Lay ra thong tin ng mua
		
		mav.addObject("total",total); // Lay ra tong so tien
		mav.addObject("deliveryAddress", deliveryAddress); // Lay ra dia chi giao hang
		
		for(CartDTO dto: cartDTO.getListResult()) {
			historyService.InsertHistory(username, dto.getBook_id(), dto.getCount(),billId);
		}
		
		// Sau khi insert vao bill xong thi xoa gio hang
		cartService.deleteCart(username);
		return mav;
	}
}
