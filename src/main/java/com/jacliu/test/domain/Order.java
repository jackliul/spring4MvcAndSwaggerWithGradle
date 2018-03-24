package com.jacliu.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "����ʵ��")
public class Order {  
    /**
	 * ������ʶ
	 */  
	@ApiModelProperty(required = true, value = "������ʶ")
	private Long orderCode;

	@ApiModelProperty(required = true, value = "�����û�")
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