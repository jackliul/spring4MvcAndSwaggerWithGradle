package com.jacliu.test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "�û�ʵ��")
public class User {
	/**
	 * �û���ʶ
	 */
	@ApiModelProperty(required = true, value = "�û���ʶ")
	private Long id;
	/**
	 * �û���
	 */
	@ApiModelProperty(required = true, value = "�û���")
	private String username;
	/**
	 * ����
	 */
	@ApiModelProperty(required = true, value = "����")
	private String passwords;
	/**
	 * ����
	 */
	@ApiModelProperty(required = true, value = "����")
	private String email;
	/**
	 * �绰
	 */
	@ApiModelProperty(required = true, value = "�绰")
	private String telephone;
	/**
	 * ��ַ
	 */
	@ApiModelProperty(required = true, value = "��ַ")
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