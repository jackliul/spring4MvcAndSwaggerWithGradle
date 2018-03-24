package com.jacliu.test.testValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "员工详情")
public class EmployInfo {  

	@ApiModelProperty(required = true, value = "手机号码")
	@Pattern(regexp = "[3,6]", message = "手机号码格式不正确")
	private String telphone;

	@ApiModelProperty(required = true, value = "邮箱")
	@Email(message = "邮箱格式不正确")
	private String email;

	/**
	 * 
	 */
	public EmployInfo() {
		super();
	}

	/**
	 * @param telphone
	 * @param email
	 */
	public EmployInfo(@Pattern(regexp = "[3,6]") String telphone, @Email String email) {
		super();
		this.telphone = telphone;
		this.email = email;
	}

	/**
	 * @return the telphone
	 */
	public String getTelphone() {
		return telphone;
	}

	/**
	 * @param telphone
	 *            the telphone to set
	 */
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


}