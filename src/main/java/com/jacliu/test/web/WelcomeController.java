package com.jacliu.test.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping(value = "/docs")
	public String index() {
		return "redirect:swagger-ui.html";
	}

	@ApiOperation(value = "/", httpMethod = "GET", notes = "������ҳ")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		logger.debug("index() is executed!");

		model.put("title", "title");
		model.put("msg", "msg");

		return "index";
	}

}