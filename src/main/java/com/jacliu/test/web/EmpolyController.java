package com.jacliu.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jacliu.test.exception.ValidatorException;
import com.jacliu.test.testValidator.Employ;
import com.jacliu.test.testValidator.EmployInfo;
import com.jacliu.test.util.ValidationUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "员工接口", tags = { "员工列表" })
public class EmpolyController {

	private final Logger logger = LoggerFactory.getLogger(EmpolyController.class);
	
	@ApiResponses(value = { @ApiResponse(response = Employ.class, code = 200, message = "数据正确了"),
			@ApiResponse(code = 405, message = "请求权限"), @ApiResponse(code = 500, message = "后台报错") })
	@ApiOperation(value = "addOrUpdate", httpMethod = "POST", notes = "新增或修改")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "员工id", dataType = "Long", paramType = "query", example = "100") })
	@RequestMapping(value = "/employ/addOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Employ addOrUpdate(@ApiParam(required = true, name = "employ", value = "员工") Employ employ)
			throws ValidatorException {

		ValidationUtils.validate(employ);

		return new Employ("userName", "password 001", new EmployInfo("11616161", "dfdfd@123.com"));
	}

	@ApiResponses(value = { @ApiResponse(response = Employ.class, code = 200, message = "数据正确了"),
			@ApiResponse(code = 405, message = "请求权限不够"), @ApiResponse(code = 500, message = "后台报错") })
	@ApiOperation(value = "testException", httpMethod = "POST", notes = "新增或修改")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "员工id", dataType = "Long", paramType = "query", example = "100") })
	@RequestMapping(value = "/employ/testException", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void testException()
			throws ValidatorException {

		logger.info("错误进来了：：{}", "测试springMVC的统一异常处理");
		logger.debug("错误进来了：：{}", "测试springMVC的统一异常处理");

		throw new ValidatorException("测试springMVC的统一异常处理");
	}

}