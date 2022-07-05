package com.bkh.exam.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UsrHomeController {
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:usr/home/main";
	}
}