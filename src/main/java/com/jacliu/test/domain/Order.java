package com.jacliu.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "����ʵ��")
public class Order {
    /**
	 * ������ʶ
	 */
	@ApiModelProperty(required = true, value = "������ʶ")
	private Long orderCode;

	@ApiModelProperty(required = true, value = "�����û�")
	private String orderUser;

	private User user;

	private List<User> users;

	public Order() {
		super();
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
