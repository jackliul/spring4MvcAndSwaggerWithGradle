/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0   
 */
package com.jacliu.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.jacliu.test.exception.ExceptionEnum;
import com.jacliu.test.exception.TResult;

/**   
 * @description  
 * @author "jacliu"   
 * @version 1.0.0  
 * @
 */
@ControllerAdvice
public class SpringExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class);

	/**
	 * 
	 * @param ex
	 * @param req
	 * @return
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleOtherExceptions(final Exception ex, final WebRequest req) {
		TResult tResult = new TResult();
		tResult.setStatus(ExceptionEnum.FAILED.getValue());
		tResult.setErrorMessage(ExceptionEnum.FAILED.getDesc());

		logger.error("错误进来了：：{}", ex.getMessage());
		return new ResponseEntity<Object>(tResult, HttpStatus.OK);
	}

}