package com.introsite.main.controller;

import com.introsite.main.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	public MainService mainService;

	@RequestMapping("/go")
	public String goMain() {
		System.out.println("############MainController.goMain : 정상 진입 성공");
		System.out.println("############MainController.goMain : 데이터 조회");

		String userid ;

		try {
			userid = mainService.selectOneUserId();

			if ( !"".equals(userid) && userid != null ) {
				System.out.println("############MainController.goMain : 데이터 정상 조회 : " + userid);
			} else {
				System.out.println("############MainController.goMain : 데이터 조회 실패 : 공백 or null");
			}

		} catch(Exception e) {
			System.out.println("############MainController.goMain : 데이터 조회 중 에러 발생");
			System.out.println(e.getMessage());
		}
		return "main/main";
	}
}
