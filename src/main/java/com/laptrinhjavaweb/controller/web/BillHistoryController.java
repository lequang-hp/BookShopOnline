package com.laptrinhjavaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.HistoryDTO;
import com.laptrinhjavaweb.service.IHistoryService;
import com.laptrinhjavaweb.util.SecurityUtils;

@Controller(value = "billHistoryControllerOfWeb")
public class BillHistoryController {
	@Autowired
	private IHistoryService historyService;

	
	@RequestMapping(value = "/lich-su",method = RequestMethod.GET)
	public ModelAndView billHistory() {
		String username = SecurityUtils.getPrincipal().getUsername();
		ModelAndView mav = new ModelAndView("web/history");
		HistoryDTO model = new HistoryDTO();
		model.setListResult(historyService.findByUserId(username));
		mav.addObject("model",model);
		return mav;
	}
}
