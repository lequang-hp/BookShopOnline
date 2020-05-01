package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.BillDTO;
import com.laptrinhjavaweb.dto.HistoryDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IBillService;
import com.laptrinhjavaweb.service.IHistoryService;
import com.laptrinhjavaweb.service.IUserService;

@Controller(value = "billControllerOfAdmin")
public class BillController {
	@Autowired
	private IBillService billService;
	@Autowired
	private IHistoryService historyService;
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/admin/bill/list",method = RequestMethod.GET)
	public ModelAndView showBill() {
		ModelAndView mav = new ModelAndView("admin/bill/list");
		BillDTO model = new BillDTO();
		model.setListResult(billService.findAll());
		mav.addObject("model",model);
		return mav;
	}
	
	@RequestMapping(value = "/admin/bill/detail",method = RequestMethod.GET)
	public ModelAndView billDetail(@RequestParam("createdBy") String createdBy,@RequestParam("billId") Long billId) {
		ModelAndView mav = new ModelAndView("admin/bill/detail");
		HistoryDTO model = new HistoryDTO();
		UserDTO user = userService.findUserByUserName(createdBy);
		model.setListResult(historyService.findByBillId(billId));
		mav.addObject("model", model);
		mav.addObject("user", user);
		return mav;
	}
}
