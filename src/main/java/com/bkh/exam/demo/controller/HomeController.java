package com.bkh.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.Article;

@Controller
public class HomeController {
	@RequestMapping("/usr/home/getString")
	@ResponseBody
	public String getString() {
		return "Hi";
	}
}