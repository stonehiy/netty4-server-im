package com.netty4.server.exception.handler;

import com.netty4.server.exception.ParamNullException;
import com.netty4.server.exception.TokenTimeoutException;
import com.netty4.server.exception.UnauthorizedException;
import com.netty4.server.util.Errors;
import com.netty4.server.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.security.auth.login.LoginException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@ControllerAdvice
public class CustomExceptionHandler  {
	private static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Object  handleExcpeion(RuntimeException e) {
		Result<Object> resp   = Result.build(Errors.FAILURE).setMsg("服务器开小差啦,请稍后再试");
		logger.error("接口调用异常:", e);
		return resp;
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Object  handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		Result<Object> resp   = Result.build(Errors.FAILURE).setMsg(e.getMessage());
		logger.error("接口参数错误:{} -> {}",e.getName(),e.getMessage());
		return resp;
	}


	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Object  handleConstraintViolationExceptionException(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
		Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
		List<String> msgList = new ArrayList<>();
		while (iterator.hasNext()) {
			ConstraintViolation<?> cvl = iterator.next();
			msgList.add(cvl.getMessageTemplate());
		}
		Result<Object> resp   = Result.build(Errors.PARAMETER_ERROR).setMsg(msgList.toString());
		logger.error("接口参数错误:{}", msgList.toString());
		return resp;
	}

	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Object  handleExcpeion(BindException e) {
	    StringBuilder sb = new StringBuilder();
	    e.getFieldErrors().forEach(objectErrors -> sb.append(objectErrors.getDefaultMessage()).append(","));
        String msg = sb.toString();
		logger.error("接口参数错误:{}",msg);
		return   Result.build(Errors.PARAMETER_ERROR).setMsg(msg.substring(0,msg.length()-1));
	}

	@ExceptionHandler(value = LoginException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public Object  handleLoginException(LoginException e) {
        logger.error("Token 验证异常:{}", e.getMessage());
		return  Result.build(Errors.TOEKN_UNAUTHORIZED);
	}

	@ExceptionHandler(value = TokenTimeoutException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Object  handleTokenTimeoutException(TokenTimeoutException e) {
        logger.error("Token 超时异常:{}", e.getMessage());
		return  Result.build(Errors.TOKEN_EXPIRE);
	}



	@ExceptionHandler(value = ParamNullException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Object  handleParamNullException(ParamNullException e) {
        logger.error("参数为空:{}", e.getMessage());
		return  Result.build(Errors.FAILURE).setMsg(e.getMessage());
	}

	@ExceptionHandler(value = UnauthorizedException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Object  handleUnauthorizedException(UnauthorizedException e) {
        logger.error("没有权限:{}", e.getMessage());
		return  Result.build(Errors.UNAUTHORIZED);
	}


}