package com.jacliu.test.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jacliu.test.domain.Order;
import com.jacliu.test.domain.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "订单列表", tags = { "订单接口" })
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@ApiResponses(value = { @ApiResponse(response = User.class, code = 200, message = "数据正确"),
			@ApiResponse(code = 405, message = "权限问题"), @ApiResponse(code = 500, message = "后台报错了") })
	@ApiOperation(value = "findOrderById", httpMethod = "POST", notes = "查找订单信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "�û�Id", dataType = "Long", paramType = "query", example = "100") })
	@RequestMapping(value = "/order/findOrderById", method = RequestMethod.POST)
	@ResponseBody
	public Order findUserById(@ApiParam(required = true, name = "id", value = "订单Id") Long Id) {
		return new Order(100L, "order 1");
	}

	@ApiResponses(value = {
			@ApiResponse(responseContainer = "List", response = Order.class, code = 200, message = "订单列表"),
			@ApiResponse(code = 405, message = "权限有问题"), @ApiResponse(code = 500, message = "后台报错了"),
			@ApiResponse(code = 600, message = "自定义权限") })
	@ApiOperation(value = "listOrders", httpMethod = "GET", notes = "订单列表")
	@RequestMapping(value = "/order/listOrders", method = RequestMethod.GET)
	@ResponseBody
	public List<Order> listOrders() {
		
		List<Order> orders = new ArrayList<Order>();
		Order user01 = new Order(100L, "order 1");
		Order user02 = new Order(101L, "order 2");

		if (orders.size() == 0) {
			logger.error("没有数据哦");
		}

		orders.add(user01);
		orders.add(user02);
		return orders;
	}

}