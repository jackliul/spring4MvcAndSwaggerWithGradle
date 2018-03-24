package com.jacliu.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "订单实体")
public class Order {  
    /**
	 * 订单标识
	 */  
	@ApiModelProperty(required = true, value = "订单标识")
	private Long orderCode;

	@ApiModelProperty(required = true, value = "订单用户")
	private String orderUser;

	public Order(Long orderCode, String orderUser) {
		super();
		this.orderCode = orderCode;
		this.orderUser = orderUser;
	}

	public Long getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Long orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}

}  