package com.introsite.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping("/go")
	public String goMain() {
		System.out.println("############MainController.goMain : 정상 진입 성공");
		return "정상 진입 성공";
	}

}
