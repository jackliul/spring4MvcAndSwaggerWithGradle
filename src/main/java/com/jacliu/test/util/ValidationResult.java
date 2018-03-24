/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0   
 */
package com.jacliu.test.util;

import java.util.Map;

/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0  
 * @
 */
public class ValidationResult {
	private boolean hasErrors;

	private Map<String, String> errorMsg;

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ValidationResult [hasErrors=" + hasErrors + ", errorMsg=" + errorMsg + "]";
	}
}
