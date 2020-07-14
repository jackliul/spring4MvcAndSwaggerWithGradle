package com.jacliu.test.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jacliu.test.domain.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "用户列表", tags = { "用户列表接口" })
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@ApiResponses(value = { @ApiResponse(response = User.class, code = 200, message = "接口正常"),
			@ApiResponse(code = 405, message = "权限有问题"), @ApiResponse(code = 500, message = "后台报错了") })
	@ApiOperation(value = "/user/insert", httpMethod = "POST", notes = "根据id查找用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "锟矫伙拷Id", defaultValue = "30", dataType = "Long", paramType = "query", example = "100") })
	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	@ResponseBody
	public User insert(@ModelAttribute("user") User user,
			@ApiParam(required = true, name = "user", value = "user") Long Id, @Valid @RequestBody User userV,
			BindingResult result) {

		if (result.hasErrors()) {

		}
		return new User(100L, "name 1", "pwd 1", "email 1", "telephone 1", "address 1");
	}

	@ApiResponses(value = { @ApiResponse(response = User.class, code = 200, message = "接口正常"),
			@ApiResponse(code = 405, message = "权限有问题"), @ApiResponse(code = 500, message = "后台报错了") })
	@ApiOperation(value = "findUserById", httpMethod = "POST", notes = "根据id查找用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户Id", defaultValue = "30", dataType = "Long", paramType = "query", example = "100") })
	@RequestMapping(value = "/user/findUserById", method = RequestMethod.POST)
	@ResponseBody
	public User findUserById(@ApiParam(required = true, name = "id", value = "锟矫伙拷Id") Long Id,
			@Valid @RequestBody User user, BindingResult bingingresult) {
		return new User(100L, "name 1", "pwd 1", "email 1", "telephone 1", "address 1");
	}

	@ApiResponses(value = {
			@ApiResponse(responseContainer = "List", response = User.class, code = 200, message = "接口正常"),
			@ApiResponse(code = 401, message = ""), @ApiResponse(code = 405, message = "权限有问题"),
			@ApiResponse(code = 500, message = "后台报错了") })
	@ApiOperation(value = "listUsers", httpMethod = "GET", notes = "查找用户列表")
	@RequestMapping(value = "/user/listUsers", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listUsers() {

		/*String header = req.getHeader("x-access-token");

		logger.info("header " + header);*/
		List<User> users = new ArrayList<User>();
		User user01 = new User(100L, "name 1", "pwd 1", "email 1", "telephone 1", "address 1");
		User user02 = new User(100L, "name 2", "pwd 1", "email 1", "telephone 1", "address 1");

		if (users.size() == 0) {
			logger.error("没有用户数据");
		}
		users.add(user01);
		users.add(user02);
		return users;
	}

}
