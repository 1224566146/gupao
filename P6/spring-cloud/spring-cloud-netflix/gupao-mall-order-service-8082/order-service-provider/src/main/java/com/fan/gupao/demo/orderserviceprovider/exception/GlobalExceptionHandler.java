package com.fan.gupao.demo.orderserviceprovider.exception;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e, HttpServletRequest request){
        log.info("GlobalExceptionHandler.handleException:{},{}",request.getRequestURL(),e);
        String msg = "系统繁忙:"+e.getMessage();
        if(e instanceof ValidException){
            msg = e.getMessage();
        }
        return new R.Builder<>().buildCustomize(msg);
    }

}
