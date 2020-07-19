package com.introsite.main.controller;

import com.introsite.main.service.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// logger.info("INFO Level 테스트");
	// logger.debug("DEBUG Level 테스트");
	// logger.warn("WARN Level 테스트");
	// logger.error("ERROR Level 테스트");

	@Autowired
	public MainService mainService;

	@RequestMapping("/")
	public String goMain() {
		return "main/main";
	}

	@RequestMapping("/introduce/{kind}") 
	public String introduce (@PathVariable("kind") String kind) {
		logger.debug("introduce kind : " + kind);
		return "main/introduce" + kind;
	}

	@RequestMapping("/test")
	public String test() {
		
		logger.debug("데이터 조회");

		String userid ;

		try {
			userid = mainService.selectOneUserId();

			if ( !"".equals(userid) && userid != null ) {
				logger.debug("데이터 조회 성공, id = " + userid);
			} else {
				logger.debug("데이터 조회 실패");
			}
		} catch(Exception e) {
			logger.error("데이터 조회 중 에러 발생");
			logger.error("[Exception] " + e.getMessage());
		}
		
		return "main/main";
	}
}
