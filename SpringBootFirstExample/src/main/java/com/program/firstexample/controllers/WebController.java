package com.program.firstexample.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	private String message = "sandy";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println(message);
		model.put("message", this.message);
		return "welcome";
	}

}
