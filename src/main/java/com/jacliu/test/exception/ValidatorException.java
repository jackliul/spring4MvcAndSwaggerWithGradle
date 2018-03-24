/**   
 * @description  
 * @author "jacliu"   
 * @date 2018年3月24日 下午2:52:32 
 * @version 1.0.0   
 */
package com.jacliu.test.exception;

/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0  
 * @
 */
public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;

	private String bizType;
	private int bizCode;
	private String message;

	public ValidatorException(String bizType, int bizCode, String message) {
		super(message);
		this.bizType = bizType;
		this.bizCode = bizCode;
		this.message = message;
	}

	public ValidatorException(String message) {
		super(message);
		this.bizType = "";
		this.bizCode = -1;
		this.message = message;
	}

	public ValidatorException(String bizType, String message) {
		super(message);
		this.bizType = bizType;
		this.bizCode = -1;
		this.message = message;
	}

	public ValidatorException(int bizCode, String message) {
		super(message);
		this.bizType = "";
		this.bizCode = bizCode;
		this.message = message;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public int getBizCode() {
		return bizCode;
	}

	public void setBizCode(int bizCode) {
		this.bizCode = bizCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
