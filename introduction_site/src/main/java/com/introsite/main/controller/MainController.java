package com.introsite.main.controller;

import com.introsite.main.service.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public MainService mainService;

	@RequestMapping("/go")
	public String goMain() {


		logger.trace("TRACE Level 테스트");
		logger.info("INFO Level 테스트");
		logger.debug("DEBUG Level 테스트");
		logger.warn("WARN Level 테스트");
		logger.error("ERROR Level 테스트");

		logger.debug("MainController.goMain : 정상 진입 성공");
		logger.debug("MainController.goMain : 데이터 조회");

		String userid ;

		try {
			userid = mainService.selectOneUserId();

			if ( !"".equals(userid) && userid != null ) {
				logger.debug("MainController.goMain : 데이터 조회 성공, id = " + userid);
			} else {
				logger.debug("MainController.goMain : 데이터 조회 실패");
			}
		} catch(Exception e) {
			logger.error("MainController.goMain : 데이터 조회 중 에러 발생");
			logger.error("[Exception] MainController.goMain : " + e.getMessage());
		}
		return "main/main";
	}
}
