package com.jacliu.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户实体")
public class User {
	/**
	 * 用户标识
	 */
	@ApiModelProperty(required = true, value = "用户标识")
	private Long id;
	/**
	 * 用户名
	 */
	@ApiModelProperty(required = true, value = "用户名")
	private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(required = true, value = "密码")
	private String passwords;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(required = true, value = "邮箱")
	private String email;
	/**
	 * 电话
	 */
	@ApiModelProperty(required = true, value = "电话")
	private String telephone;
	/**
	 * 地址
	 */
	@ApiModelProperty(required = true, value = "地址")
	private String address;

	public User() {
		super();
	}

	public User(Long id, String username, String passwords, String email, String telephone, String address) {
		super();
		this.id = id;
		this.username = username;
		this.passwords = passwords;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}  