package com.garden.life.commons.handler;

import cn.hutool.http.HttpStatus;
import com.garden.life.commons.bean.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     *  处理请求参数异常
     * @param exception 异常
     * @return 异常处理相响应返回
     */
    @ResponseBody
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validationExceptionHandler(Exception exception) {
        BindingResult bindingResult = null;
        if (exception instanceof BindException) {
            bindingResult = ((BindException) exception).getBindingResult();
        } else if (exception instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) exception).getBindingResult();
        }
        String message;
        if (bindingResult != null && bindingResult.hasErrors()) {
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            final String numberExceptionName = "NumberFormatException";
            if (message.contains(numberExceptionName)) {
                message = "参数类型错误！";
            }
        }else {
            message = "系统繁忙！";
        }
        return new ResponseResult<Object>(HttpStatus.HTTP_BAD_REQUEST, message);
    }

    /**
     * 未知异常处理
     * @param exception 异常
     * @return 异常处理响应
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object unknownExceptionHandler(Exception exception) {
        return new ResponseResult<Object>(HttpStatus.HTTP_INTERNAL_ERROR, "系统繁忙，请稍后重试！");
    }
}
