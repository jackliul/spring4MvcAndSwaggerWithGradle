/**   
 * @description  
 * @author "jacliu"   
 * @date 2018��3��24�� ����12:48:13 
 * @version 1.0.0   
 */
package com.jacliu.test.exception;

/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0  
 * @
 */
public enum ExceptionEnum {

	SCUUESS("1", "成功"), FAILED("2", "失败");
	private ExceptionEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	private String value;
	private String desc;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}

