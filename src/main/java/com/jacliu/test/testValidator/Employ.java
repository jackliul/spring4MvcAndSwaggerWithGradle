package com.jacliu.test.testValidator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "员工实体")
public class Employ {

	@ApiModelProperty(required = true, value = "用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;

	@ApiModelProperty(required = true, value = "密码")
	@NotBlank(message = "{user.not.passwords}")
	private String passwords;

	@Valid
	private EmployInfo employInfo;

	/**
	 * 
	 */
	public Employ() {
		super();
	}


	/**
	 * @param username
	 * @param passwords
	 * @param employInfo
	 */
	public Employ(@Range(min = 1, max = 150) String username, String passwords, @Valid EmployInfo employInfo) {
		super();
		this.username = username;
		this.passwords = passwords;
		this.employInfo = employInfo;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passwords
	 */
	public String getPasswords() {
		return passwords;
	}

	/**
	 * @param passwords
	 *            the passwords to set
	 */
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}


	/**
	 * @return the employInfo
	 */
	public EmployInfo getEmployInfo() {
		return employInfo;
	}


	/**
	 * @param employInfo
	 *            the employInfo to set
	 */
	public void setEmployInfo(EmployInfo employInfo) {
		this.employInfo = employInfo;
	}


}