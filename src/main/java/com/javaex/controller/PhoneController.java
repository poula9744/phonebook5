package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class PhoneController {

	@RequestMapping(value = "/phone", method = RequestMethod.GET)

	public String phone() {

		System.out.println("/phonespring/phone");

		return "/WEB-INF/views/index.jsp";

	}

}
