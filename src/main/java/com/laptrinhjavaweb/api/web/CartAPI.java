package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.service.ICartService;

@RestController(value = "cartAPIOfWeb")
public class CartAPI {
	@Autowired
	private ICartService cartService;
	@DeleteMapping("/api/cart")
	public void deleteCart(@RequestBody long [] ids) {
		cartService.deleteCart(ids);
	}
}
